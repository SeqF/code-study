package com.quibbler.security.handler;

import com.quibbler.security.JsonAuthentication;
import com.quibbler.utils.JwtUtil;
import com.quibbler.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author paksu
 */
@Component
public class LoginSuccessHandler extends JsonAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //生成jwt 放到header中
        String jwt = jwtUtil.generateToken(authentication.getName());
        //将jwt放入response的header中
        response.setHeader(jwtUtil.getHeader(), jwt);

        Result result = Result.successWithMessage("登录成功");
        this.writeJSON(request, response, result);
    }
}
