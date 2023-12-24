package org.desktop.base.views.components.buttons;

import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.ApplicationModelListener;

public abstract class AppButton extends BasicButton implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 4106812624638240974L;
	
	protected transient ApplicationModel applicationModel;

	protected AppButton(String titleTextKey, String toolTipTextKey) {
		super(titleTextKey, toolTipTextKey);
	}
	
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
