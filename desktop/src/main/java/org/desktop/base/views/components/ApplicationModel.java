package org.desktop.base.views.components;

import org.desktop.base.views.components.events.ApplicationEvent;

public interface ApplicationModel {
	
	public void register(ApplicationModelListener listener);
	
	public void unregister(ApplicationModelListener listener);
	
	public void notify(ApplicationEvent event);
}
