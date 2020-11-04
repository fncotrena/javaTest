package com.prueba.javatest.util;

public class StringUtil {

    public static String repeat  (String str,int times) {
        String result = "";
        if(times<0){
            throw  new IllegalArgumentException("numero ingresado es negativo");

        }
        for (int i = 0; i < times; i++) {
            result+=str;
        }
    return result;
    }
    public static boolean isEmpty(String str) {
       if(str==null) return true;
       return str.trim().isEmpty();
    }
}
