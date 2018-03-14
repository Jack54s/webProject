package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11407 on 2017/5/18.
 */
public class Column extends TagSupport {

    private String property;
    private String label;

    public int doStartTag() throws JspException {
        if(!(this.getParent() instanceof Table)) {
            throw new JspException("Column must be inside Table. ");
        }
        Map<String, String> column = new HashMap<String, String>();

        column.put("label", label);
        column.put("property", property);

        Table table = (Table) this.getParent();

        table.getColumns().add(column);

        return SKIP_BODY;
    }

    public int doEndTag()
            throws JspException
    {
        return EVAL_PAGE;
    }

    public String getProperty()
    {
        return property;
    }

    public void setProperty(String property)
    {
        this.property = property;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
}
