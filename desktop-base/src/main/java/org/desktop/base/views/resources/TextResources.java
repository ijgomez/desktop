package org.desktop.base.views.resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TextResources implements Serializable {

	private static final long serialVersionUID = 3689926638047072394L;
	
	private Map<String, String> resources;
	
	public TextResources() {
		resources = new HashMap<>();
	}
	
	public void register(String key, String value) {
		this.resources.putIfAbsent(key, value);
	}
	
	public String get(String key) {
		Optional<String> optional = this.getString(key);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new IllegalArgumentException("resource '" + key + "' is empty or no exists!");
	}
	
	public Optional<String> getString(String key) {
		return Optional.of(this.resources.get(key));
	}
	
	public String getStringOrDefault(String key) {
		return this.resources.getOrDefault(key, key);
	}

	public String getString(String key, Object...parameters) {
		return String.format(this.resources.get(key), parameters);
	}
}
