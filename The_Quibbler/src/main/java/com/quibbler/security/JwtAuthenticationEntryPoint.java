package com.quibbler.security;

import com.quibbler.utils.Result;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 * 当用户未登录或者token解析失败时会触发这个处理器
 *
 * @author paksu
 */
@Component
public class JwtAuthenticationEntryPoint extends JsonAuthentication implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        String errorMessage = "未认证,访问失败";
        if (e instanceof LockedException) {
            errorMessage = "账户被锁定";
        } else if (e instanceof AccountExpiredException) {
            errorMessage = "账户过期";
        } else if (e instanceof DisabledException) {
            errorMessage = "账户被禁用";
        }
        //设置response状态码为未认证 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Result result = Result.errorWithMessage(errorMessage);
        this.writeJSON(request, response, result);
    }
}
