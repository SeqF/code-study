package com.quibbler.security.filter;

import cn.hutool.core.util.StrUtil;
import com.quibbler.common.exception.CaptchaException;
import com.quibbler.global.Constans;
import com.quibbler.security.handler.LoginFailureHandler;
import com.quibbler.utils.RedisUtil;
import com.quibbler.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;

@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String url = request.getRequestURI();

        if ("/login".equals(url) && request.getMethod().equals("POST")) {
            try {
                //校验验证码
                validateCaptcha(request);
            } catch (CaptchaException e) {
                //交给认证失败处理器
                loginFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }
        //继续走过滤链
        filterChain.doFilter(request, response);
    }

    private void validateCaptcha(HttpServletRequest request) {

        String code = request.getParameter("captcha");
        String key = request.getParameter("token");

        if (StrUtil.isBlank(code) || StrUtil.isBlank(key)) {
            throw new CaptchaException("验证码错误");
        }

        if (!code.equals(redisUtil.hGet(Constans.CAPTCHA_KEY, key))) {
            throw new CaptchaException("验证码错误");
        }

        redisUtil.hDelete(Constans.CAPTCHA_KEY, key);
    }
}
