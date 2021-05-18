package com.quibbler.security.handler;

import com.baomidou.mybatisplus.extension.api.R;
import com.quibbler.security.JsonAuthentication;
import com.quibbler.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author paksu
 */
@Component
public class LoginFailureHandler extends JsonAuthentication implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result = Result.errorWithMessage(e.getMessage());
        this.writeJSON(request, response, result);
    }
}
