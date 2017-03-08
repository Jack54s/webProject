package com.redweb.filter;

import com.redweb.response.HttpCharacterResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by 11407 on 2017/3/8.
 */
public class OutputReplaceFilter implements Filter {

    private Properties pp = new Properties();

    public void init(FilterConfig config) throws ServletException {
        String file = config.getInitParameter("file");
        String realPath = config.getServletContext().getRealPath(file);

        try {
            pp.load(new FileInputStream(realPath));
        } catch (IOException e) {}
    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpCharacterResponseWrapper response = new HttpCharacterResponseWrapper((HttpServletResponse) res);

        chain.doFilter(req, response);

        String output = response.getCharArrayWriter().toString();

        for (Object obj : pp.keySet()) {
            String key = (String) obj;
            output = output.replace(key, pp.getProperty(key));
        }
        PrintWriter out = res.getWriter();
        out.write(output);
        out.println("<!-- Generated at " + new java.util.Date() + " -->");
    }

    public void destroy() {}
}
