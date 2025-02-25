package com.sangay.ecom.learning;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ASCII {

    public static void main(String[] args) {

        String name=".";

        byte[] bytes = name.getBytes();

        char n='L';
        int decAscii=(int)n;
        String hexAsci=Integer.toHexString(decAscii);

        System.out.println(decAscii);
        System.out.println(hexAsci);
        System.out.println(bytes);

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }
}
