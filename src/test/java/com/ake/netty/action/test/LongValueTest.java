package com.ake.netty.action.test;

import java.math.BigDecimal;

public class LongValueTest {

    public static void main(String[] args) {
        long v1 = (1L<<18)+(1L<<10)+1;
        long v2 = (1L << 19) + (1L << 11) + 2;
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(Long.toHexString(v1));
        System.out.println(Long.toHexString(v2));
    }
}
