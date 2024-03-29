package org.desktop.base.views.menu.buttons;

import java.awt.Cursor;

import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.CloseApplicationEvent;
import org.desktop.base.views.components.menubar.buttons.AppMenuItem;

public class CloseMenuItem extends AppMenuItem {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 5756386904187105201L;

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	protected void initializateGUI() {
		this.textResources.getString("menu.button.close.text").ifPresent(super::setText);
		this.textResources.getString("menu.button.close.tool.tip").ifPresent(super::setToolTipText);
		
		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		super.addActionListener(e -> applicationModel.notify(new CloseApplicationEvent()));
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
