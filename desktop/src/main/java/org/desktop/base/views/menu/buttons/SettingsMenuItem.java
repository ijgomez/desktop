package org.desktop.base.views.menu.buttons;

import java.awt.Cursor;

import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.OpenSettingsDialogEvent;
import org.desktop.base.views.components.menubar.buttons.AppMenuItem;

public class SettingsMenuItem extends AppMenuItem {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 1266354841616399872L;

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	protected void initializateGUI() {
		this.textResources.getString("menu.button.settings.text").ifPresent(super::setText);
		this.textResources.getString("menu.button.settings.tool.tip").ifPresent(super::setToolTipText);
		
		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
		super.addActionListener(e -> applicationModel.notify(new OpenSettingsDialogEvent()));
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
