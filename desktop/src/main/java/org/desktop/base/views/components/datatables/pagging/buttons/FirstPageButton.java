package org.desktop.base.views.components.datatables.pagging.buttons;

import java.awt.event.ActionEvent;

import org.desktop.base.views.components.buttons.BasicButton;
import org.desktop.base.views.components.datatables.listeners.AppDataTablePaginationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstPageButton extends BasicButton {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 5901851081022606096L;

	/**
	 * New Instance.
	 */
	public FirstPageButton() {
		super("datatable.pagging.button.first.text", "datatable.pagging.button.first.tool.tip");
	}
	
	@Override
	protected void handlerInitializateGUI() {
		super.addActionListener(this::firstPageAction);
	}

	/**
	 * Send the event generated by pressing the button to the parent component.
	 * 
	 * @param e Event
	 */
	private void firstPageAction(ActionEvent e) {
		log.trace("Fist page: {}", e);
		if (super.getParent() instanceof AppDataTablePaginationListener appDataTablePaginationListener) {
			appDataTablePaginationListener.firstPageAction(e);
		}
	}

}