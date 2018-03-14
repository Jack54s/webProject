package com.redweb.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11407 on 2017/5/18.
 */
public class DynamicAttributeTag extends TagSupport implements DynamicAttributes {

    private Map<String, Double> map = new HashMap<String, Double>();

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        double min = map.get(map.keySet().iterator().next());
        double max = map.get(map.keySet().iterator().next());

        for (Double d : map.values()) {
            min = Math.min(d, min);
            max = Math.max(d, max);
        }

        StringBuffer buffer = new StringBuffer();

        buffer.append("<table>");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            buffer.append("<tr>");
            buffer.append("<td>" + entry.getKey() + "</td>");

            buffer.append("<td><img src='vote.gif' height='10' width='");
            buffer.append((entry.getValue() - min) / (max - min + 1) * 200 + 10);
            buffer.append("' />" + entry.getValue() + "</td>");
            buffer.append("</tr>");
        }
        buffer.append("</table>");

        try {
            out.write(buffer.toString());
        }
        catch (Exception e) {}
        return super.doEndTag();
    }

    @Override
    public void setDynamicAttribute(String uri, String key, Object value) throws JspException {
        map.put(key, Double.parseDouble((String) value));
    }
}
