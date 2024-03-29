package org.desktop.base.views.components.dialog.init;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.commons.lang3.SystemUtils;
import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.ApplicationModelImpl;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.helpers.SleepHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ApplicationInitializationDialog extends JDialog {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -3495759555845880204L;
	
	private String[] arguments;
	
	private transient ApplicationModel model;
	
	private ApplicationInitializationDialogPanel initializationDialogPanel;
	
	private int currentTask;

	protected ApplicationInitializationDialog(JFrame owner, String... args) {
		super(owner);
		this.arguments = args;
		this.initializeGUI();
	}

	private void initializeGUI() {
		this.initializationDialogPanel = this.getInitialDialogPanel();

		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		super.setSize(400, 530);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setUndecorated(true);
		super.setModal(true);
		super.setLayout(new BorderLayout());
		super.add(this.initializationDialogPanel, BorderLayout.CENTER);
		super.addWindowListener(new WindowAdapter() {
			
			

			@Override
			public void windowOpened(WindowEvent e) {
				log.debug("Start initialization application process...");
				Thread thread = new Thread(ApplicationInitializationDialog.this::executeInitializationApplication, "initThread");
				thread.setUncaughtExceptionHandler((Thread t, Throwable th) -> {
					log.error("Fallo al inicializar la consola: ", th);
					initializationDialogPanel.setStatusErrorTask(currentTask, th);
					initializationDialogPanel.enableButtons();
				});
				thread.start();
			}
			
		});
	}

	private ApplicationInitializationDialogPanel getInitialDialogPanel() {
		return new ApplicationInitializationDialogPanel();
	}
	
	private void executeInitializationApplication() {
		// Show environment settings.
		log.info("Operative System: {} ({}) {}", SystemUtils.OS_NAME, SystemUtils.OS_ARCH, SystemUtils.OS_VERSION); 
		log.info("Java Version: {}", SystemUtils.JAVA_RUNTIME_VERSION); 
		log.info("Id. Application: {}", ManagementFactory.getRuntimeMXBean().getName()); 
		log.info("Locale: {}", Locale.getDefault());
		log.info("Time Zone: {} ({})", TimeZone.getDefault().getDisplayName(), TimeZone.getDefault().getID());
	
		log.info("User Name: {}", SystemUtils.USER_NAME); 
		log.info("User Time Zone: {}", SystemUtils.USER_TIMEZONE); 
		log.info("User Language: {}", SystemUtils.USER_LANGUAGE); 
		log.info("User Country: {}", SystemUtils.USER_COUNTRY); 
		log.info("User Dir: {}", SystemUtils.USER_DIR); 
		log.info("User Home: {}", SystemUtils.USER_HOME);
		
		// Initialization Application.
		log.info("Arguments: {}", Arrays.toString(arguments));
		
		// Initialization Application Model.
		this.currentTask = 0;
		this.initializationDialogPanel.setStatusInProcessTask(this.currentTask);
		model = new ApplicationModelImpl();
		this.initializationDialogPanel.setStatusCompleteTask(this.currentTask);
		SleepHelper.sleep(1000);
		
		// Initialization Application Listeners.
		this.currentTask = 1;
		this.initializationDialogPanel.setStatusInProcessTask(this.currentTask);
		((ApplicationModelListener) getParent()).setModel(model);
		this.initializationDialogPanel.setStatusCompleteTask(this.currentTask);
		SleepHelper.sleep(1000);
		
		// Initialization Logical Business.
		this.currentTask = 2;
		this.initializationDialogPanel.setStatusInProcessTask(this.currentTask);
		handlerExecuteInitializationApplication();
		this.initializationDialogPanel.setStatusCompleteTask(this.currentTask);
		
		
		// Configuration Shutdown Hook.
		this.currentTask = 3;
		this.initializationDialogPanel.setStatusInProcessTask(this.currentTask);
		Runtime.getRuntime().addShutdownHook(new Thread(this::executeShutdownApplication));
		this.initializationDialogPanel.setStatusCompleteTask(this.currentTask);
		SleepHelper.sleep(1000);
		
		log.info("...application loaded.");

		getOwner().repaint();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	protected abstract void handlerExecuteInitializationApplication();

	private void executeShutdownApplication() {
		log.trace("Executing Shutdown Hook...");
		this.handlerExecuteShutdownApplication();
	}
	
	protected abstract void handlerExecuteShutdownApplication();

	
}
