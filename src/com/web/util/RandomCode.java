package com.web.util;

import java.util.Random;

public class RandomCode {
   public static String getRandomCode() {//���6λ�����
	   String val = "";  
       Random random = new Random();  
         
       for(int i = 0; i < 6; i++) {  
             
           String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
           //�����ĸ��������  
           if( "char".equalsIgnoreCase(charOrNum) ) {  
               //����Ǵ�д��ĸ����Сд��ĸ  
               int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
               val += (char)(random.nextInt(26) + temp);  
           } else if( "num".equalsIgnoreCase(charOrNum) ) {  
               val += String.valueOf(random.nextInt(10));  
           }  
       }  
       return val;  
   }
}
