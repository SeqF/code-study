package com.study.blog.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5SlatUtils {

    public static String saltcode(String str1,String str2) {
        ByteSource salt=ByteSource.Util.bytes(str2);
        String password = new SimpleHash("MD5", str1, salt,3).toString();
        return password;

    }
    public static void main(String[] args) {
        System.out.println(saltcode("Gundam00","paksu"));
    }
}
