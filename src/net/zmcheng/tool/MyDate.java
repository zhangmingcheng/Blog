package net.zmcheng.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public MyDate(){

    }
    public static String getTime(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString = dateFormat.format(new Date());
		return dateString;
}
}
