package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by 11407 on 2017/5/18.
 */
public class AddTag extends TagSupport {

    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            this.pageContext.getOut().println(num1 + " + " + num2 + " = " + (num1 + num2));
        }
        catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
