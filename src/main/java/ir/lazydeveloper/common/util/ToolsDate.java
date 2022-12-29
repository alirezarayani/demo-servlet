package ir.lazydeveloper.common.util;

import java.sql.Date;

public class ToolsDate {

    public static Date getNow() {
        java.util.Date date = new java.util.Date();
        return new Date(date.getTime());
    }
}
