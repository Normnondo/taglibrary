package com.normnondo.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.time.*;
import java.io.IOException;

public class TimeOfDayTag extends SimpleTagSupport {
    LocalTime time = LocalTime.now(ZoneId.systemDefault());
    LocalTime morning = LocalTime.of(06,00);
    LocalTime noon = LocalTime.of(12, 00);
    LocalTime evening = LocalTime.of(18, 00);
    LocalTime late = LocalTime.of(22, 30);
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        if (time.isAfter(morning) && time.isBefore(noon)) {
            out.println("Good morning Sunshine!");
        } else if (time.isAfter(noon) && time.isBefore(evening)) {
            out.println("Good afternoon.");
        } else if (time.isAfter(evening) && time.isBefore(late)) {
            out.println("Good evening.");
        } else {
            out.println("What are you doing up?");
        }
    }
}

