package org.desktop.base.views.components.dialog.init;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.desktop.base.views.components.buttons.CancelButton;
import org.desktop.base.views.components.buttons.ExitButton;
import org.desktop.base.views.components.panels.DialogPanel;
import org.desktop.base.views.factories.ResourcesFactory;
import org.desktop.base.views.resources.Resources;
import org.desktop.base.views.resources.TextResources;

public class ApplicationInitializationDialogPanel extends JPanel {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -7761631327237930071L;
	
	private TextResources textResources = ResourcesFactory.getInstance().text();
	
	private List<DialogPanel> dialogPanels;
	
	
	private CancelButton cancelButton;
	
	private ExitButton exitButton;

	public ApplicationInitializationDialogPanel() {
		this.initializateGUI();
	}

	/**
	 * Method that contains the definition of the visual elements of the component.
	 */
	private void initializateGUI() {
		JLabel titleLabel;
		JPanel taskPanel;
		JPanel buttonPanel;
		
		titleLabel = new JLabel(Resources.APPLICATION_TITLE.getText(), SwingConstants.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont((float) (titleLabel.getFont().getSize() * 2)));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		taskPanel = new JPanel();
		taskPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		taskPanel.setLayout(new GridLayout(4, 1));
		taskPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		this.dialogPanels = new ArrayList<>();
		this.dialogPanels.add(0, new DialogPanel(textResources.get("dialog.init.task.1.title")));
		this.dialogPanels.add(1, new DialogPanel(textResources.get("dialog.init.task.2.title")));
		this.dialogPanels.add(2, new DialogPanel(textResources.get("dialog.init.task.3.title")));
		this.dialogPanels.add(3, new DialogPanel(textResources.get("dialog.init.task.4.title")));

		for (DialogPanel dialogPanel : dialogPanels) {
			dialogPanel.setWaitingStatusView();
			
			taskPanel.add(dialogPanel);
		}

		this.cancelButton = new CancelButton();
		this.cancelButton.addActionListener(e -> System.exit(0));
		
		this.exitButton = new ExitButton();
		this.exitButton.addActionListener(e -> System.exit(0));
		this.exitButton.setVisible(false);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		buttonPanel.add(this.cancelButton);
		buttonPanel.add(this.exitButton);
		
		super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		super.setLayout(new BorderLayout());
		super.add(titleLabel, BorderLayout.NORTH);
		super.add(taskPanel, BorderLayout.CENTER);
		super.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void setStatusLoadingTask(int indexTask) {
		this.dialogPanels.get(indexTask).setWaitingStatusView();
	}
	
	public void setStatusInProcessTask(int indexTask) {
		this.dialogPanels.get(indexTask).setInProgressStatusView();
	}
	
	public void setStatusCompleteTask(int indexTask) {
		this.dialogPanels.get(indexTask).setCompleteStatusView();
	}
	
	public void setStatusErrorTask(int indexTask, Throwable error) {
		this.dialogPanels.get(indexTask).setErrorView(error);
	}
	
	public void enableButtons() {
		super.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.cancelButton.setVisible(false);
		this.exitButton.setVisible(true);
	}
}
