package org.desktop.base.views.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ApplicationContainerViewConfig {
	
	public String titleTextKey();
	
	public String toolTipTextKey();
	
	public boolean selected();
	
	public int order();
	
}
