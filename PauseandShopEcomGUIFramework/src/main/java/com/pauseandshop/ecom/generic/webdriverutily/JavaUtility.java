package com.pauseandshop.ecom.generic.webdriverutily;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
		public int getRandomNumber() {
			Random ranDom =new Random();
			int ranDomNumber= ranDom.nextInt();
			return ranDomNumber;	
		}


		public String getSystemDateYYYYMMDD() {
			Date dateobj =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(dateobj);
			return date;
		}


		public String getRequireDateYYYYMMDD(int days) {
			Date dateobj1 =new Date();
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			String date = sim.format(dateobj1);
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,30);
			String reqDate = sim.format(cal.getTime());
			return reqDate;
			
		}	


}
