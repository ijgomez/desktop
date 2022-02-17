package org.desktop.base.views.components.buttons;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.ChangeViewEvent;

public class ChangeViewButton<E> extends AppButton implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 7965182179055476500L;
	
	private Class<E> classView;

	public ChangeViewButton(String titleTextKey, String toolTipTextKey, Class<E> classView) {
		super(titleTextKey, toolTipTextKey);
		this.classView = classView;
	}
	
	public Class<E> getClassView() {
		return classView;
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(e -> model.notify(new ChangeViewEvent(classView)));
	}
	
	@Override
	public void listener(ApplicationEvent event) { 
		// nothing
	}
	
	@Override
	public void updateView() { 
		// nothing
	}

}
