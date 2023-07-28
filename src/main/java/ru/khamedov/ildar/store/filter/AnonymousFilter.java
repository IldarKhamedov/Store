package ru.khamedov.ildar.store.filter;

import ru.khamedov.ildar.store.service.AnonymousService;
import ru.khamedov.ildar.store.service.AuthenticationService;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AnonymousFilter implements Filter {

    @Resource
    private AnonymousService anonymousService;

    @Resource
    private AuthenticationService authenticationService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String httpSessionId=((HttpServletRequest) servletRequest).getSession().getId();
        anonymousService.createAnonymous(httpSessionId);
        authenticationService.setHttpSessionId(httpSessionId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
