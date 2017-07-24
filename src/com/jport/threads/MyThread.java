package com.jport.threads;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyThread extends Thread {

	GregorianCalendar startTime;
	GregorianCalendar endTime;
	int diff1;
	int diff2;
	private int timeLeft;
	
	public int getTimeLeft() {
		return timeLeft;
	}
	public MyThread(GregorianCalendar startTime, GregorianCalendar endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		diff1 =  startTime.get(startTime.MINUTE); 
	}
 
	public void run() {
		
	
	
	if( diff1 !=60){
	   diff2 = 60 - diff1;
	}
	 System.out.println(diff1);
     System.out.println(diff2);
		
		while ( (startTime.get(startTime.HOUR) != endTime.get(endTime.HOUR)) || (startTime.get(startTime.MINUTE) != endTime.get(endTime.MINUTE))) {
							while (diff1 > 0) {
				startTime.add(startTime.MINUTE, 1);
				diff1--;
				timeLeft = diff1; System.out.println(diff1);
				try {
					sleep(60 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (diff1 == 0 && diff2 > 0){
				//startTime.add(startTime.HOUR, 1);
				//break;
			}
			if (diff1 == 0) {

				while (diff2 > 0) {

					startTime.add(startTime.MINUTE, 1);
					diff2--;
					timeLeft=diff2;
				try {
					sleep(60 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

			}

			
		}
	}

}