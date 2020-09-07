package com.study.utils;

import org.junit.Test;

import java.util.UUID;

public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString();
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
