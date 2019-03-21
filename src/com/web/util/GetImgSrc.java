package com.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetImgSrc {
	 public  static String getImgStr(String htmlStr) {
	        String src ="";
	        String img = "";
	        Pattern p_image;
	        Matcher m_image;
	        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
	        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
	        m_image = p_image.matcher(htmlStr);
	        while (m_image.find()) {
	            // �õ�<img />����
	            img = m_image.group();
	            // ƥ��<img>�е�src����
	            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
	           if(m.find()) {
	               src+=m.group(1);
	            }
	        }
	        return src;
	    }
}
