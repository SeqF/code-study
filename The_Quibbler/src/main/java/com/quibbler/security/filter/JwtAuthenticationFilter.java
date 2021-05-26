package com.quibbler.security.filter;

import cn.hutool.core.util.StrUtil;
import com.quibbler.security.SecurityUserDetailsServiceImpl;
import com.quibbler.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户认证处理器
 *
 * @author paksu
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SecurityUserDetailsServiceImpl securityUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        //从进来的request的token中 获取到数据库
        String token = request.getHeader(jwtUtil.getHeader());

        //token不为空时,通过loadByUsername获取到userDetails，并设置到Authentication中
        if (StrUtil.isNotEmpty(token) && token.startsWith(jwtUtil.getPrefix())) {
            Claims claim = jwtUtil.getClaimByToken(token);

//            throw new DisabledException("账户被禁用");
            if (claim == null) {
                throw new JwtException("token异常");
            }
            if (jwtUtil.isTokenExpired(claim)) {
                throw new JwtException("token已过期");
            }
            String username = claim.getSubject();

            UserDetails userDetails = securityUserDetailsService.loadUserByUsername(username);
            //获取用户的权限等信息
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null,
                            userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

//        token为空,让过滤器链继续
        chain.doFilter(request, response);
    }
}
