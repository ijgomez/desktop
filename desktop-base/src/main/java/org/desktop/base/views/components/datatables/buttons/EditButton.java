package org.desktop.base.views.components.datatables.buttons;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.buttons.AppButton;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.OpenEntityEvent;

public class EditButton<E> extends AppButton implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -2960155241027241105L;
	
	private Class<E> classView;
	
	public EditButton(Class<E> classView) {
		super("button.edit.text", "button.edit.tool.tip");
		this.classView = classView;
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener((e) -> model.notify(new OpenEntityEvent(classView, "EDIT")));
	}
	
	@Override
	public void listener(ApplicationEvent event) { }

	@Override
	public void updateView() { }

	

}
