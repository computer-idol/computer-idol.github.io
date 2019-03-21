package com.web.util;

import java.util.Calendar;
import java.util.Date;

public  class GetDate {
   public static String getTime(Date date) {
	   String time="";
	   Calendar c = Calendar.getInstance();
	   c.setTime(date);
	   time+=c.get(Calendar.YEAR)+"-"+format(c.get(Calendar.MONTH)+1)+"-"+format(c.get(Calendar.DATE))+" "+format(c.get(Calendar.HOUR))
	   +":"+format(c.get(Calendar.MINUTE))+":"+format(c.get(Calendar.SECOND));
	   return time;
   }
   public static String format(int i) {
	   String fi="";
	   if(i<10) {
		   fi="0"+i;
		   return fi;
	   }
	   return Integer.toString(i);
   }
}
