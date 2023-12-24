package org.desktop.base.views.components.menubar.buttons;

import javax.swing.JMenuItem;

import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.factories.ResourcesFactory;
import org.desktop.base.views.resources.TextResources;

public abstract class AppMenuItem extends JMenuItem implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 7730448020444982488L;
	
	protected TextResources textResources = ResourcesFactory.getInstance().text();
	
	protected transient ApplicationModel applicationModel;

	protected AppMenuItem() {
		this.initializateGUI();
	}

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	protected abstract void initializateGUI();
	
	@Override
	public void setModel(ApplicationModel model) {
		if (model != null) {
			this.applicationModel = model;
			this.applicationModel.register(this);
			this.updateView();
		} else {
			this.applicationModel.unregister(this);
			this.applicationModel = model;
		}
	}

}
