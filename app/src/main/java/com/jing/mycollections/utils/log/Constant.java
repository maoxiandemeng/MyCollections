package com.jing.mycollections.utils.log;

/**
 * Created by liu on 2015/11/29.
 */
public interface Constant {
    String DEFAULT_MESSAGE = "execute";
    String LINE_SEPARATOR = System.getProperty("line.separator");
    String NULL_TIPS = "Log with null object";
    int JSON_INDENT = 4;

    int V = 0x1;
    int D = 0x2;
    int I = 0x3;
    int W = 0x4;
    int E = 0x5;
    int A = 0x6;
    int JSON = 0x7;
}
