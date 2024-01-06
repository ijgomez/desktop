package org.desktop.base.views.menu;

import java.awt.Cursor;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.menubar.AppMenuBar;
import org.desktop.base.views.menu.buttons.CloseMenuItem;
import org.desktop.base.views.menu.buttons.OpenMenuItem;
import org.desktop.base.views.menu.buttons.SaveMenuItem;
import org.desktop.base.views.menu.buttons.SettingsMenuItem;

public class ApplicationMenuBar extends AppMenuBar {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 7189582102634292466L;

	private OpenMenuItem openFileMenuItem;
	
	private SaveMenuItem saveMenuItem;
	
	private CloseMenuItem closeMenuItem;
	
	private SettingsMenuItem settingsMenuItem;
	
	@Override
	protected void initializateGUI() {
		JMenu fileMenu;
		JMenu editMenu;
		JMenu settingsMenu;

        openFileMenuItem = new OpenMenuItem();
        
        saveMenuItem = new SaveMenuItem();
        
        closeMenuItem = new CloseMenuItem();
        
        settingsMenuItem = new SettingsMenuItem();
        
        fileMenu = new JMenu();
        fileMenu.setText(textResources.getStringOrDefault("menu.file.text"));
        fileMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(new JPopupMenu.Separator());
        fileMenu.add(closeMenuItem);
        
        editMenu = new JMenu();
        editMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editMenu.setText(textResources.getStringOrDefault("menu.edit.text"));
        
        settingsMenu = new JMenu();
        settingsMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingsMenu.setText(textResources.getStringOrDefault("menu.settings.text"));
        settingsMenu.add(settingsMenuItem);

        super.add(fileMenu);
        super.add(editMenu);
        super.add(settingsMenu);
		
	}
	
	@Override
	protected void registerEventListeners() {
		// nothing
		
	}
	
	@Override
	public void setModel(ApplicationModel model) {
		super.setModel(model);
		this.openFileMenuItem.setModel(model);
		this.saveMenuItem.setModel(model);
		this.closeMenuItem.setModel(model);
		this.settingsMenuItem.setModel(model);
	}
	
	@Override
	public void updateView() {
		// nothing
		
	}
	
}
