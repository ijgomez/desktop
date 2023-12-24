package org.desktop.base.views.components.buttons;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.SelectFileEvent;

public class SelectButton extends AppButton implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 9124367834491909447L;

	public SelectButton() {
		super("button.select.text", "button.select.tooltip");
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(e -> applicationModel.notify(new SelectFileEvent()));
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
