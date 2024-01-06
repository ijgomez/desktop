package org.desktop.base.views.defaults;

import org.desktop.base.views.ApplicationViewConfiguration;
import org.desktop.base.views.components.toolbar.AppMainToolBar;

public class DefaultApplicationToolBar extends AppMainToolBar {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -95062186306252920L;
	
	public DefaultApplicationToolBar(ApplicationViewConfiguration viewConfiguration) {
		super(viewConfiguration);
	}
	
	protected void handlerInitializateGUI() {
		// nothing
	}
	
	@Override
	protected void handlerRegisterEventListeners() {
		// nothing
		
	}
	
	@Override
	protected void handlerUpdateView() {
		// nothing
		
	}
	
	
}
