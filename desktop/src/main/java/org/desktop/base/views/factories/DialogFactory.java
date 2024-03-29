package org.desktop.base.views.factories;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileSystemView;

import org.desktop.base.views.components.dialog.InformationDialogPanel;
import org.desktop.base.views.components.dialog.ProgressDialogPanel;
import org.desktop.base.views.components.dialog.WarningDialogPanel;
import org.desktop.base.views.resources.TextResources;
import org.desktop.base.views.settings.SettingsContainerView;

import lombok.extern.slf4j.Slf4j;

/**
 * Class that generates the modal windows or dialogs common to the application.
 * 
 * @author ijgomez
 *
 */
@Slf4j
public class DialogFactory {
	
	private static final Dimension DEFAULT_DIALOG_SIZE = new Dimension(450, 200);

	/**
	 * Displays the dialog to confirm the exit of the application.
	 * 
	 * @param parentComponent Top component or parent.
	 * @return Result of the confirmation dialogue.
	 */
	public static boolean showConfirmExitDialog(Component parentComponent) {
		TextResources textResources = ResourcesFactory.getInstance().text();

		int showConfirmDialog = JOptionPane.showConfirmDialog(parentComponent, textResources.get("dialog.confirm.exit.text"), textResources.get("dialog.confirm.exit.title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		return (showConfirmDialog == JOptionPane.YES_OPTION);
	}
	
	/**
	 * Displays a progress dialog while performing an operation.
	 * 
	 * @param frame    Top component or parent.
	 * @param runnable Operation.
	 */
	public static void showProgressDialog(JFrame frame, Runnable runnable) {
		TextResources textResources = ResourcesFactory.getInstance().text();
		
		textResources.getString("dialog.status.inprocess.title").ifPresent(msg -> showProgressDialog(frame, runnable, msg, 400, 150));
	}
	
	/**
	 * Displays a progress dialog while performing an operation.
	 * 
	 * @param frame    Top component or parent.
	 * @param runnable Operation.
	 * @param title    Title.
	 * @param width    Width of dialog.
	 */
	public static void showProgressDialog(JFrame frame, Runnable runnable, String title, Integer width, Integer height) {
		final JDialog dialog;
		final JPanel progessDialogPanel;
		TextResources textResources = ResourcesFactory.getInstance().text();
		Thread thread;
		
		progessDialogPanel = new ProgressDialogPanel(title);
		
		
		dialog = new JDialog(frame);
		dialog.setBounds(new Rectangle(frame.getLocation().x + (frame.getBounds().width / 2) - (width/2), frame.getLocation().y + (frame.getBounds().height / 2) - (height/2), width, height));
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.add(progessDialogPanel);
		dialog.setResizable(false);
		dialog.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		textResources.getString("application.title").ifPresent(dialog::setTitle);

		dialog.setModal(true);
		
		thread = new Thread(runnable, "PROGRESS_THREAD"){
			@Override
			public void run() {
				super.run();
				dialog.setVisible(false);
				dialog.dispose();
			}
		};
		thread.setUncaughtExceptionHandler((Thread t, Throwable th) -> {
			log.error("Fail in operation:", th);
			dialog.setVisible(false);
			dialog.dispose();
			DialogFactory.showErrorDialog(frame, th);
		});
		thread.start();
		dialog.setVisible(true);
	}
	
	public static void showErrorDialog(JFrame frame, Throwable th) {
		try {
			showWarningDialog(frame, th.getCause().getMessage());
		} catch (Exception e) {
			showWarningDialog(frame, "Fail in application");
		} 
		
	}
	
	public static void showWarningDialog(JComponent component, String menssage) {
		showWarningDialog((JFrame) SwingUtilities.getRoot(component), menssage);
	}
	
	public static void showInformationDialog(JComponent component, String menssage) {
		showInformationDialog((JFrame) SwingUtilities.getRoot(component), menssage);
	}
	
	public static void showWarningDialog(JFrame frame, String menssage) {
		final JDialog dialog;
		
		dialog = new JDialog(frame);
		dialog.setSize(DEFAULT_DIALOG_SIZE);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.add(new WarningDialogPanel(menssage){

			/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
			private static final long serialVersionUID = -1309782158613454668L;
			
			@Override
			public void handlerConfirmMessageAction() {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		dialog.setResizable(false);
		dialog.setUndecorated(true);
		dialog.setModal(true);
		dialog.setLocationRelativeTo(frame);
		
		dialog.setVisible(true);
	}
	
	public static void showInformationDialog(JFrame frame, String menssage) {
		final JDialog dialog;
		
		dialog = new JDialog(frame);
		dialog.setSize(DEFAULT_DIALOG_SIZE);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.add(new InformationDialogPanel(menssage) {

			/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
			private static final long serialVersionUID = -3190135355156187022L;

			@Override
			public void handlerConfirmMessageAction() {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		dialog.setResizable(false);
		dialog.setUndecorated(true);
		dialog.setModal(true);
		dialog.setLocationRelativeTo(frame);
		
		dialog.setVisible(true);
	}
	
	public static void showSettingsDialog(JFrame frame) {
		final JDialog dialog;
		
		dialog = new JDialog(frame);
		dialog.setSize(new Dimension((int)(frame.getSize().width /1.5), (int)(frame.getSize().height /1.5)));
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.add(new SettingsContainerView() {

			/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
			private static final long serialVersionUID = 2811941159640966887L;

			@Override
			protected void closeDialogAction(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		dialog.setModal(true);
		dialog.setLocationRelativeTo(frame);
		
		dialog.setVisible(true);
	}
	
	public static File showOpenFileDialog(Component parent) {
		JFileChooser jfc;
		
		jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		if (jfc.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		} 
		return null;
		
	}
	
	public static File showSaveFileDialog(Component parent) {
		JFileChooser jfc;
		
		jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		if (jfc.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
			return jfc.getSelectedFile();
		} 
		return null;
		
	}
		
	private DialogFactory() {
		
	}	
}
