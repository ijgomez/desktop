package org.desktop.base.views.helpers;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class EnumHelper {

	public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
	    return StreamSupport.stream(
	        Spliterators.spliteratorUnknownSize(
	            new Iterator<T>() {
	                public T next() {
	                    return e.nextElement();
	                }
	                public boolean hasNext() {
	                    return e.hasMoreElements();
	                }
	            },
	            Spliterator.ORDERED), false);
	}
	
	private EnumHelper() {
	}
}
