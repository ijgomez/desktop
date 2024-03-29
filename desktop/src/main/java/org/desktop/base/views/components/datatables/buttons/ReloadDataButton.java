package org.desktop.base.views.components.datatables.buttons;

import org.desktop.base.views.components.buttons.AppButton;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.ReloadDataEvent;

public class ReloadDataButton extends AppButton {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -2960155241027241105L;
	
	public ReloadDataButton() {
		super("button.reload.text", "button.reload.tool.tip");
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(e -> applicationModel.notify(new ReloadDataEvent()));
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
