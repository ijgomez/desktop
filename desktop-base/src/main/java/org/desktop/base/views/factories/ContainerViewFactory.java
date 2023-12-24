package org.desktop.base.views.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.exceptions.ApplicationViewException;
import org.desktop.base.views.components.panels.EmptyContainerPanel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainerViewFactory {

	private static final ContainerViewFactory INSTANCE = new ContainerViewFactory();
	
	public static ContainerViewFactory getInstance() {
		return INSTANCE;
	}
	
	private Map<Class<?>, Class<?>> views;
	
	private Class<?> defaultContainerView = EmptyContainerPanel.class;
	
	private ContainerViewFactory() {
		this.views = Collections.synchronizedMap(new HashMap<>());
	}
	
	public void setDefaultContainerView(Class<?> classEntity) {
		this.defaultContainerView = classEntity;
	}
	
	public ApplicationModelListener getContainerView(Class<?> classEntity) throws ApplicationViewException {
		try {
			
			log.trace("Creating container view for the entity {}...", classEntity);
			return (ApplicationModelListener) this.views.getOrDefault(classEntity, this.defaultContainerView).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ApplicationViewException("Failed to create container view.", e);
		}
		
	}
	
}
