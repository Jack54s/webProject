package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by 11407 on 2017/5/18.
 */
public class LoopTag extends BodyTagSupport {

    private int times;

    @Override
    public int doStartTag() throws JspException {
        if(getTimes() == 0){
            times = 5;
        }
        return super.doStartTag();
    }

    @Override
    public int doAfterBody() throws JspException {
        if(times-- > 0) {
            try {
                this.getPreviousOut().println(this.getBodyContent().getString() + "<br/>");
            }
            catch (Exception e) {

            }
            return EVAL_BODY_AGAIN;
        }
        else {
            return SKIP_BODY;
        }
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }
}
