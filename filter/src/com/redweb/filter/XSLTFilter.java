package com.redweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 11407 on 2017/3/10.
 */
public class XSLTFilter implements Filter {

    private ServletContext servletContext;

    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        Source styleSource = new StreamSource(servletContext.getRealPath("/MessageLog.xsl"));

        Source xmlSource = new StreamSource(servletContext.getRealPath(request.getRequestURI().replace(request.getContextPath() + "", "")));

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer(styleSource);
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            StreamResult result = new StreamResult(charArrayWriter);
            transformer.transform(xmlSource, result);
            response.setContentType("text/html");
            response.setContentLength(charArrayWriter.toString().length());

            PrintWriter out = response.getWriter();
            out.write(charArrayWriter.toString());
        }catch (Exception ex) {}
    }
    public void destroy() {}
}
