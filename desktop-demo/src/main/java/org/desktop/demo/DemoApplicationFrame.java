package org.desktop.demo;

import java.io.File;

import org.desktop.base.views.ApplicationStatus;
import org.desktop.base.views.ApplicationViewConfiguration;
import org.desktop.base.views.annotations.ApplicationViewScan;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.dialog.init.ApplicationInitializationDialog;
import org.desktop.base.views.components.events.OpenFileEvent;
import org.desktop.base.views.components.events.OpenSettingsDialogEvent;
import org.desktop.base.views.components.events.SaveFileEvent;
import org.desktop.base.views.components.frames.AppFrame;
import org.desktop.base.views.components.menubar.AppMenuBar;
import org.desktop.base.views.components.toolbar.AppMainToolBar;
import org.desktop.base.views.factories.DialogFactory;
import org.desktop.base.views.helpers.SleepHelper;
import org.desktop.base.views.menu.ApplicationMenuBar;

import lombok.extern.slf4j.Slf4j;

@ApplicationViewScan(
		packages = {"org.desktop.demo.containers"},
		textResources = {"demoMessages"}
	)
@Slf4j
public class DemoApplicationFrame extends AppFrame implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 4661793292792888017L;

	private String[] arguments;

	public DemoApplicationFrame(ApplicationViewConfiguration viewConfiguration, String... args) {
		super(viewConfiguration);
		this.arguments = args;
	}

	protected void handlerInitializateGUI() { }
	
	protected AppMenuBar buildMenuBar() {
		return new ApplicationMenuBar();
	}
	
	protected AppMainToolBar buildToolBar() {
		return new DemoApplicationToolBar(getViewConfiguration());
	}
	
	protected ApplicationStatus buildStatusBar() {
		return new ApplicationStatus();
	}
	
	protected ApplicationInitializationDialog buildInitializationAction() {
		return new ApplicationInitializationDialog(this, arguments){

			/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
			private static final long serialVersionUID = -8783535924054686171L;

			@Override
			protected void handlerExecuteInitializationApplication() {
				// TODO Auto-generated method stub
				SleepHelper.sleep(10000);
			}

			@Override
			protected void handlerExecuteShutdownApplication() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

	@Override
	protected void handlerRegisterEventListeners() {
		super.register(OpenFileEvent.class, (e) -> openFileDialog());
		super.register(SaveFileEvent.class, (e) -> saveFileDialog());
		super.register(OpenSettingsDialogEvent.class, (e) -> openSettingsDialog());
	}
	
	

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

	private void openFileDialog() {
		File f;
		
		f = DialogFactory.showOpenFileDialog(getParent());
		if (f != null) {
			log.trace("File: {}", f.getAbsolutePath());
		}
		// TODO Auto-generated method stub
		
	}
	
	private void saveFileDialog() {
		File f;
		
		f = DialogFactory.showSaveFileDialog(getParent());
		if (f != null) {
			log.trace("File: {}", f.getAbsolutePath());
		}
		// TODO Auto-generated method stub

	}
	
	private void openSettingsDialog() {
		DialogFactory.showSettingsDialog(this);
		// TODO Auto-generated method stub
	}

}
