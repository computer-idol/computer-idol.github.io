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
	            // 得到<img />数据
	            img = m_image.group();
	            // 匹配<img>中的src数据
	            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
	           if(m.find()) {
	               src+=m.group(1);
	            }
	        }
	        return src;
	    }
}
