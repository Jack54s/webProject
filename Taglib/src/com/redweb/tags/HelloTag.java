package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by 11407 on 2017/5/18.
 */
public class HelloTag extends TagSupport {

    private String name;

    @Override
    public int doEndTag() throws JspException {
        try {
            this.pageContext.getOut().println("Hello, " + name);
        }
        catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
