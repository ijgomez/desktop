package org.desktop.base.views.components.dialog;

import javax.swing.JPanel;

public abstract class InformationDialogPanel extends JPanel {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -6614126316557941802L;

	private String message;
	
	protected InformationDialogPanel(String message) {
		this.message = message;
	}
	
	public abstract void handlerConfirmMessageAction();
}
