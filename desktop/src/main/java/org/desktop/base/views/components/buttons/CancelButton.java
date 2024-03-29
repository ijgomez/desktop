package org.desktop.base.views.components.buttons;

public class CancelButton extends BasicButton {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 9124367834491909447L;

	public CancelButton() {
		super("button.cancel.text", "button.cancel.tool.tip");
	}
	
	@Override
	protected void handlerInitializateGUI() { 
		// nothing
	}
	
}
