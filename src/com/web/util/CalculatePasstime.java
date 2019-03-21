package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculatePasstime {
	//计算间隔时间
	public String  passTime(String time){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Date date = new Date();
	   try {
		date = sdf.parse(time);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   long time1=new Date().getTime()/1000;
	   long time2=date.getTime()/1000;
	   long passTime=time1-time2;
	   String str="";
	   if(passTime<60){
	       str="刚刚";
	       return str;
	   }
	   else if(passTime>=60&&passTime<3600){
		   Double d1=new Double(Math.floor(passTime/60));
	       str=d1.intValue()+"分钟前";
	       return str;
	   }
	   else if(passTime>=3600&&passTime<86400){
		   Double d2=new Double(Math.floor(passTime/3600));
	       str=d2.intValue()+"小时前";
	       return str;
	   }
	   else if(passTime>=86400&&passTime<2592000){
		   Double d3=new Double(Math.floor(passTime/86400));
	       str=d3.intValue()+"天前";
	       return str;
	   }
	   else{
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
	      int year=c.get(Calendar.YEAR);
	      int month=c.get(Calendar.MONTH)+1>=10?c.get(Calendar.MONTH)+1:'0'+c.get(Calendar.MONTH)+1;
	      int day=c.get(Calendar.DATE)>=10?c.get(Calendar.DATE):'0'+c.get(Calendar.DATE);
	      str=Integer.toString(year)+'-'+Integer.toString(month)+'-'+Integer.toString(day);
	      return str;
	   }
	}
}
