package org.desktop.demo.containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.desktop.base.views.annotations.ApplicationContainerViewConfig;
import org.desktop.base.views.components.ApplicationModel;
import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.panels.AppPanel;
import org.desktop.demo.containers.details.SportmanDataTableListView;

@ApplicationContainerViewConfig(titleTextKey = "toolbar.button.container.datatable.text", toolTipTextKey = "toolbar.button.container.datatable.tool.tip", order = 2, selected = true)
public class DataTableContainerView extends AppPanel implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = 8543052142754893011L;
	
	private SportmanDataTableListView listLeftView;
	
	private SportmanDataTableListView listRightView;
	
	@Override
	protected void initializateGUI() {
		JPanel panel;
		
		listLeftView = new SportmanDataTableListView();
		
		listRightView = new SportmanDataTableListView();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(listLeftView);
		panel.add(listRightView);
		
		// TODO Auto-generated method stub
		super.setLayout(new BorderLayout());
		super.add(new JLabel("Datatable container"), BorderLayout.NORTH);
		super.add(panel, BorderLayout.CENTER);
	}
	
	@Override
	public void setModel(ApplicationModel model) {
		super.setModel(model);
		this.listLeftView.setModel(model);
		this.listRightView.setModel(model);
	}

	@Override
	protected void registerEventListeners() { 
		// nothing
	}
	
	@Override
	public void updateView() { 
		// nothing
	}

}
