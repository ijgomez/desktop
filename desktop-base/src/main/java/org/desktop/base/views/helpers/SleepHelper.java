package org.desktop.base.views.helpers;

public class SleepHelper {

	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private SleepHelper() {

	}
	
}
