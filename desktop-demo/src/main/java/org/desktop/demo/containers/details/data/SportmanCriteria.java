package org.desktop.demo.containers.details.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SportmanCriteria extends PaginationCriteria {

	private String name;
	
	private String surname;
	
	private String sport;
	
	private Integer year;
	
	private Boolean vegetarian;
	
}
