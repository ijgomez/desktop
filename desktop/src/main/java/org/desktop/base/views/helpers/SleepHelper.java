package org.desktop.base.views.helpers;

public class SleepHelper {

	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private SleepHelper() {

	}
	
}
