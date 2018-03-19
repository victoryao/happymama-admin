package com.happymama.admin.filter;


import com.happymama.admin.constant.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String requestURI;

        HttpSession session = request.getSession();
        // 如果Session为空，则跳转到指定页面
        if (session == null || session.getAttribute(Constant.sessionCheckKey) == null) {
            requestURI = request.getRequestURI();
            if (requestURI.contains("admin")) {
                response.sendRedirect("/to/login.do");
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }

    }

}
