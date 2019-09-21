package org.desktop.base.views.menu.buttons;

import java.awt.Cursor;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.OpenSettingsDialogEvent;
import org.desktop.base.views.components.menubar.buttons.AppMenuItem;

public class SettingsMenuItem extends AppMenuItem implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 1266354841616399872L;

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	protected void initializateGUI() {
		this.textResources.getString("menu.button.settings.text").ifPresent((t) -> super.setText(t));
		this.textResources.getString("menu.button.settings.tool.tip").ifPresent((t) -> super.setToolTipText(t));
		
		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
		super.addActionListener((e) -> model.notify(new OpenSettingsDialogEvent()));
	}
	
	@Override
	public void listener(ApplicationEvent event) { }

	@Override
	public void updateView() { }
}