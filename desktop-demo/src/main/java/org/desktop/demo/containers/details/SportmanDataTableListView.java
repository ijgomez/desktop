package org.desktop.demo.containers.details;

import java.awt.BorderLayout;

import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.events.ApplicationEvent;
import org.desktop.base.views.components.events.OpenEntityEvent;
import org.desktop.base.views.components.panels.AppPanel;
import org.desktop.demo.containers.details.data.Sportman;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SportmanDataTableListView  extends AppPanel {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 5574414910291766370L;

	private SportmanDataTableToolBar toolBar;
	
	private SportmanDataTable datatable;

	@Override
	protected void initializateGUI() {
		
		this.toolBar = new SportmanDataTableToolBar();
		
		this.datatable = new SportmanDataTable();
		
		super.setLayout(new BorderLayout());
		super.add(this.toolBar, BorderLayout.NORTH);
		super.add(this.datatable, BorderLayout.CENTER);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setModel(ApplicationModel model) {
		super.setModel(model);
		this.toolBar.setModel(model);
		this.datatable.setModel(model);
	}
	
	@Override
	protected void registerEventListeners() {
		super.addEventListener(OpenEntityEvent.class, this::openEntityDialog);
		// TODO Auto-generated method stub
		
	}

	private void openEntityDialog(ApplicationEvent e) {
		log.trace("New Registry: {}", e);
		// TODO Auto-generated method stub
		this.datatable.addRegister(new Sportman(0L, "", "", "", 0, false));
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
