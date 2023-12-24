package org.desktop.base.views.components.events;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChangeViewEvent extends ApplicationEvent {

	private Class<?> classEntity;
	
	public ChangeViewEvent(Class<?> entity) {
		this.classEntity = entity;
	}
	
}
