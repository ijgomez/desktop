package org.desktop.base.views.factories;

import java.awt.Image;
import java.io.Serializable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import javax.swing.ImageIcon;

import org.desktop.base.views.helpers.EnumHelper;
import org.desktop.base.views.resources.ImagesResources;
import org.desktop.base.views.resources.TextResources;

public final class ResourcesFactory implements Serializable {

	private static final long serialVersionUID = 1412867994171031279L;

	private static final String DEFAULT_TEXT_RESOURCES = "messages";
	
	private static final String DEFAULT_IMAGES_RESOURCES = "images";

	private static final ResourcesFactory INSTANCE = new ResourcesFactory();
	
	public static ResourcesFactory getInstance() {
		return INSTANCE;
	}
	
	public static Optional<ImageIcon> getImageIcon(String key) {
		return getInstance().images().getImageIcon(key);
	}
	
	public static Optional<Image> getImage(String key) {
		return getInstance().images().getImage(key);
	}
	
	public static String getString(String key, Object... parameters) {
		return getInstance().text().getString(key, parameters);
	}
	
	private TextResources textResources;
	
	private ImagesResources imagesResources;
	
	/**
	 * New Instance.
	 */
	private ResourcesFactory() {
		
	}
	
	public void load(String[] textFileNames, String[] imagesFileNames) {
		this.loadTextResources(textFileNames);
		this.loadImageResources(imagesFileNames);
	}
	
	private void loadTextResources(String[] baseNames) {
		textResources = new TextResources();

		if (baseNames != null) {
			Stream.of(baseNames).forEach(baseName -> {
				ResourceBundle bundle = ResourceBundle.getBundle(baseName);
				EnumHelper.enumerationAsStream(bundle.getKeys()).forEach(key -> textResources.register(key, bundle.getString(key)));
			});
		}
		
		ResourceBundle defaultBundle = ResourceBundle.getBundle(DEFAULT_TEXT_RESOURCES);
		EnumHelper.enumerationAsStream(defaultBundle.getKeys()).forEach(key -> textResources.register(key, defaultBundle.getString(key)));
	}
	
	private void loadImageResources(String[] baseNames) {
		imagesResources = new ImagesResources();

		if (baseNames != null) {
			Stream.of(baseNames).forEach(baseName -> {
				ResourceBundle bundle = ResourceBundle.getBundle(baseName);
				EnumHelper.enumerationAsStream(bundle.getKeys()).forEach(key -> imagesResources.register(key, bundle.getString(key)));
			});
		}
		
		ResourceBundle defaultBundle = ResourceBundle.getBundle(DEFAULT_IMAGES_RESOURCES);
		EnumHelper.enumerationAsStream(defaultBundle.getKeys()).forEach(key -> imagesResources.register(key, defaultBundle.getString(key)));
	}
	
	public TextResources text() {
		return this.textResources;
	}
	
	public ImagesResources images() {
		return this.imagesResources;
	}

}
