package com.spiritlight.collab.utils;

import java.util.Locale;

public class StringUtils {

    public static String asTitle(String in) {
        if(in == null) return "Null";
        if(in.isEmpty()) return in;
        if(in.length() == 1) return in.toUpperCase(Locale.ROOT);
        return Character.toUpperCase(in.charAt(0)) + in.substring(1).toLowerCase(Locale.ROOT);
    }
}
