package org.desktop.base.views.components.buttons;

import java.awt.Cursor;

import javax.swing.JButton;

import org.desktop.base.views.factories.ResourcesFactory;
import org.desktop.base.views.resources.ImagesResources;
import org.desktop.base.views.resources.TextResources;

public abstract class BasicButton extends JButton {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 4106812624638240974L;
	
	private TextResources textResources = ResourcesFactory.getInstance().text();
	
	private ImagesResources imagesResources = ResourcesFactory.getInstance().images();
	
	private String iconKey;
	
	private String titleTextKey;
	
	private String toolTipTextKey;

	protected BasicButton(String iconKey, String titleTextKey, String toolTipTextKey) {
		this(titleTextKey, toolTipTextKey);
		this.iconKey = iconKey;
		this.initializateGUI();
	}
	
	protected BasicButton(String titleTextKey, String toolTipTextKey) {
		this.titleTextKey = titleTextKey;
		this.toolTipTextKey = toolTipTextKey;
		this.initializateGUI();
	}
	
	protected BasicButton(String iconKey) {
		this.iconKey = iconKey;
		this.initializateGUI();
	}

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	private void initializateGUI() {
		this.imagesResources.getImageIcon(iconKey).ifPresent(super::setIcon);
		this.textResources.getString(titleTextKey).ifPresent(super::setText);
		this.textResources.getString(toolTipTextKey).ifPresent(super::setToolTipText);

		super.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.handlerInitializateGUI();
	}

	protected abstract void handlerInitializateGUI();
	
}
