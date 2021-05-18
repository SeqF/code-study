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
 *
 * 未授权用户访问资源的限制
 *
 * @author paksu
 */
@Component
public class JwtAuthenticationEntryPoint extends JsonAuthentication implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result = Result.errorWithMessage("访问失败");
        this.writeJSON(request, response,result);
    }
}
