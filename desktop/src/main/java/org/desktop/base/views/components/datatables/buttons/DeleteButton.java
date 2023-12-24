package org.desktop.base.views.components.datatables.buttons;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.buttons.AppButton;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.DeleteEntityEvent;

public class DeleteButton<E> extends AppButton implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -2960155241027241105L;
	
	private Class<E> classView;
	
	public DeleteButton(Class<E> classView) {
		super("button.delete.text", "button.delete.tool.tip");
		this.classView = classView;
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(e -> applicationModel.notify(new DeleteEntityEvent(classView)));
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
