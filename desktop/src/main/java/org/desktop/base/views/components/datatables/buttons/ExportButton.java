package org.desktop.base.views.components.datatables.buttons;

import org.desktop.base.views.components.buttons.AppButton;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.ExportDataEvent;

public class ExportButton extends AppButton {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -2960155241027241105L;
	
	public ExportButton() {
		super("button.export.text", "button.export.tool.tip");
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(e -> applicationModel.notify(new ExportDataEvent()));
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
