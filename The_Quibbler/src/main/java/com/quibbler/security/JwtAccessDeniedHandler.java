package com.quibbler.security;

import com.quibbler.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问权限处理器
 *
 * @author paksu.fang
 */
@Component
public class JwtAccessDeniedHandler extends JsonAuthentication implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException
            , ServletException {

        //设置response状态码为403
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        Result result = Result.errorWithMessage(e.getMessage());
        this.writeJSON(request, response, result);
    }
}
