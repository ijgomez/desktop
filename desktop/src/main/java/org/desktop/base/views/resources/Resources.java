package org.desktop.base.views.resources;

import org.desktop.base.views.factories.ResourcesFactory;

public enum Resources {

	APPLICATION_TITLE("application.title");
	
	private String textKey;
	
	private Resources(String textKey) {
		this.textKey = textKey;
	}
	
	public String getText() {
		return ResourcesFactory.getInstance().text().get(textKey);
	}
	

}
