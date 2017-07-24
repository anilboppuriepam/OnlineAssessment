package com.jport.alarm;
import java.util.TimerTask;


public class MyTimer extends TimerTask {

	 int totalTime =5;
	@Override
	public void run() {
	  System.out.println("Helllo....");
	  System.out.println("Time left in exam "+  (totalTime -= 1 ));
	 if(totalTime == 0)
		 //System.exit(0);
		this.cancel();
	}
public int getTotalTime() {
	return totalTime;
}
}
