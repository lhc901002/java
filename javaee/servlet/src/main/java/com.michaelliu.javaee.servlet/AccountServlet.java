package com.michaelliu.javaee.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by michael on 2016/8/6.
 */
@WebServlet(urlPatterns="/account", initParams={@WebInitParam(name="type", value="checking")})
public class AccountServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(AccountServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        String type = config.getInitParameter("type");
        log.info("init param type: " + type);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        String path = context.getContextPath();
        log.info("ContextPath: " + path);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

}
