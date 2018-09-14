package chuvaev.enterprise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.ForbiddenException;
import java.io.IOException;

@WebFilter(urlPatterns={"/profile/*"})
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("MainFilter");
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final boolean check = "admin".equals(login) && "qwerty".equals(password);
        if(!check) throw new ForbiddenException();
        filterChain.doFilter(request,response);
    }
    @Override
    public void destroy(){

    }
}
