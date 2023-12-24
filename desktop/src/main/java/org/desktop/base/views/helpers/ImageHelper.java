package org.desktop.base.views.helpers;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Class that contains methods to work with images or icons.
 * 
 * @author ijgomez
 *
 */
@Slf4j
public final class ImageHelper {

	/**
	 * Method for loading a resource as an image.
	 * 
	 * @param path Path in classpath of image.
	 * @return {@link Image}
	 */
	public static Image loadImage(String path) {
		if (path == null) throw new IllegalArgumentException("parameter 'path' cannot be null!");
		if (!path.startsWith("/")) throw new IllegalArgumentException("value of parameter 'path' should not be relative to the classpath");

		try {
			log.trace("Path image: {}", path);

			InputStream inputStream = ImageHelper.class.getResourceAsStream(path);

			assert (inputStream != null) : "inputStream no puede ser null";

			return new ImageIcon(IOUtils.toByteArray(inputStream)).getImage();
		} catch (IOException e) {
			log.error("Image not found: {}", path);
			throw new IllegalArgumentException("Image not found");
		}
	}

	/**
	 * Method for loading a resource as an icon.
	 * 
	 * @param path Path in classpath of icon.
	 * @return {@link ImageIcon}
	 */
	public static ImageIcon loadImageIcon(String path) {
		if (path == null) throw new IllegalArgumentException("parameter 'path' cannot be null!");
		if (!path.startsWith("/")) throw new IllegalArgumentException("value of parameter 'path' should not be relative to the classpath");

		try {
			log.trace("Path image: {}", path);

			InputStream inputStream = ImageHelper.class.getResourceAsStream(path);
			return new ImageIcon(IOUtils.toByteArray(inputStream));
		} catch (IOException e) {
			log.error("Image not found: {}", path);
			throw new IllegalArgumentException("Image not found");
		}
	}

	public static Image loadImage(byte[] bytes) {
		if (bytes != null) throw new IllegalArgumentException("parameter 'bytes' cannot be null!");
		return new ImageIcon(bytes).getImage();
	}
	
	private ImageHelper() {
		
	}
}
