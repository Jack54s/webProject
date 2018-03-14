package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by 11407 on 2017/5/18.
 */
public class ToLowerCaseTag extends BodyTagSupport {

    @Override
    public int doEndTag() throws JspException {
        String content = this.getBodyContent().getString();
        try {
            this.pageContext.getOut().print(content.toLowerCase());
        }
        catch (Exception e) {
        }
        return EVAL_PAGE;
    }
}
