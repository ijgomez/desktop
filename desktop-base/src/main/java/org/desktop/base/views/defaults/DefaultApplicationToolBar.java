package org.desktop.base.views.defaults;

import org.desktop.base.views.ApplicationViewConfiguration;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.toolbar.AppMainToolBar;

public class DefaultApplicationToolBar extends AppMainToolBar implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -95062186306252920L;
	
	public DefaultApplicationToolBar(ApplicationViewConfiguration viewConfiguration) {
		super(viewConfiguration);
	}
	
	protected void handlerInitializateGUI() { }
	
	@Override
	protected void handlerRegisterEventListeners() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void handlerUpdateView() {
		// TODO Auto-generated method stub
		
	}
	
	
}
