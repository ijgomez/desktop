package org.desktop.base.views.components.datatables.listeners;

public interface AppDataTableSorterListener {

	void shortAction(int columnIndex);

	String getSortColumn();
	
	String getSortOrder();
}
