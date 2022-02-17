package org.desktop.base.views;

import java.util.Calendar;

import javax.swing.JLabel;

import org.desktop.base.views.components.ApplicationModelListener;
import org.desktop.base.views.components.panels.AppPanel;

public class ApplicationStatus extends AppPanel implements ApplicationModelListener {

	/** Value that it is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. */
	private static final long serialVersionUID = -1661205291887146815L;

	@Override
	protected void initializateGUI() {
		JLabel timeLabel;
		
		timeLabel = new JLabel();
		timeLabel.setText(String.format("%1$tH:%1$tM:%1$tS del %1$te de %1$tB de %1$tY.", Calendar.getInstance()));

		super.add(timeLabel);
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
