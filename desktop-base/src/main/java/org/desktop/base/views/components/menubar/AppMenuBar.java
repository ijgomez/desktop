package org.desktop.base.views.components.menubar;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JMenuBar;

import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.factories.ResourcesFactory;
import org.desktop.base.views.resources.TextResources;

public abstract class AppMenuBar extends JMenuBar implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -5289274357066149266L;

	protected TextResources textResources = ResourcesFactory.getFactory().text();
	
	protected transient ApplicationModel model;

	private transient Map<Class<?>, Consumer<ApplicationEvent>> handlers = new HashMap<>();

	protected AppMenuBar() {
		this.initializateGUI();
		this.registerEventListeners();
	}

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	protected abstract void initializateGUI();
	
	protected abstract void registerEventListeners();
	
	@Override
	public void setModel(ApplicationModel model) {
		if (model != null) {
			this.model = model;
			this.model.register(this);
			this.updateView();
		} else {
			this.model.unregister(this);
			this.model = model;
		}
	}

	@Override
	public void listener(ApplicationEvent event) { 
		if (this.handlers.containsKey(event.getClass())) {
			this.handlers.get(event.getClass()).accept(event);
		}
	}
	
	protected void register(Class<?> key, Consumer<ApplicationEvent> value) {
		this.handlers.put(key, value);
	}
}
