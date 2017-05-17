package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ResourceBundle;
import com.redweb.tags.Copyright;

/**
 * Created by 11407 on 2017/5/17.
 */
public class Copyright2 extends TagSupport {

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<div align=center style='line-height: 22px; font-size: 12px; '>");
            out.println(ResourceBundle.getBundle("copyright").getString("copyright"));
            out.println("</div>");
        }
        catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
