package org.desktop.demo.containers.details.data;

import org.desktop.base.views.components.datatables.AppDataTableCriteria;

import lombok.Data;

@Data
public class PaginationCriteria implements AppDataTableCriteria {

	private Integer pageNumber;
	
	private Integer pageSize;
	
	private String sortField;
	
	private String sortOrder;
	
}
