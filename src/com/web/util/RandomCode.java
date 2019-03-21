package com.web.util;

import java.util.Random;

public class RandomCode {
   public static String getRandomCode() {//输出6位随机数
	   String val = "";  
       Random random = new Random();  
         
       for(int i = 0; i < 6; i++) {  
             
           String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
           //输出字母还是数字  
           if( "char".equalsIgnoreCase(charOrNum) ) {  
               //输出是大写字母还是小写字母  
               int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
               val += (char)(random.nextInt(26) + temp);  
           } else if( "num".equalsIgnoreCase(charOrNum) ) {  
               val += String.valueOf(random.nextInt(10));  
           }  
       }  
       return val;  
   }
}
