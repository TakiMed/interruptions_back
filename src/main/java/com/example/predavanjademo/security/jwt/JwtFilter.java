package com.example.predavanjademo.security.jwt;

import com.example.predavanjademo.security.jwt.JwtConfigurer;
import com.example.predavanjademo.security.jwt.JwtTokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtFilter(JwtTokenProvider jwtTokenProvider) {this.jwtTokenProvider = jwtTokenProvider;}

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        try
        {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest; // kompletan zahtjev sa hederima, metodom itd
            String jwt = resolveToken(httpServletRequest); // ONLY TOKEN || NULL
            if(StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)){
            Authentication authentication = jwtTokenProvider.getAuthentication(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(servletRequest, servletResponse);

        }
        catch (ExpiredJwtException e)
        {
            ((HttpServletResponse) servletRequest).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }

    private String resolveToken(HttpServletRequest httpServletRequest)
    {
        String bearerToken = httpServletRequest.getHeader(JwtConfigurer.AUTHORIZED_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) { return bearerToken.substring(7); }

       String jwt = httpServletRequest.getParameter(JwtConfigurer.AUTHORIZED_TOKEN);
        if(StringUtils.hasText(jwt)) { return jwt; }
        return null;
    }
}
