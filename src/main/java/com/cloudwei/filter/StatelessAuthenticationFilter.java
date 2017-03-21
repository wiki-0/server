package com.cloudwei.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.cloudwei.service.TokenAuthenticationService;

public class StatelessAuthenticationFilter extends GenericFilterBean {

    private TokenAuthenticationService authenticationService;

    public StatelessAuthenticationFilter(TokenAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

         SecurityContextHolder.getContext().setAuthentication(
         authenticationService.getAuthentication((HttpServletRequest) req));
         chain.doFilter(req, res); // always continue

//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpServletResponse httpResponse = (HttpServletResponse) res;
//        Authentication authentication = authenticationService.getAuthentication(httpRequest);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(req, res);
//        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
