package com.quibbler.security;

import com.quibbler.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author paksu
 */
@Component
public class JwtAuthenticationEntryPoint extends JsonAuthentication implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        //设置response状态码为未认证 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Result result = Result.errorWithMessage("未认证,访问失败");
        this.writeJSON(request, response, result);
    }
}
