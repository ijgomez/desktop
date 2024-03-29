package org.desktop.base.views.components.panels;

import javax.swing.JLabel;

public class EmptyContainerPanel extends AppContainerView {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 6744713898858449289L;

	@Override
	protected void initializateGUI() {
		super.add(new JLabel(textResources.get("container.empty.text")));
	}
	
	@Override
	protected void registerEventListeners() {
		// nothing
		
	}
	
	@Override
	public void updateView() {
		// nothing
		
	}

}
