package org.desktop.demo.containers.details.data;

import lombok.Data;

@Data
public class Sportman {
	
	private final Long id;

	private final String name;
	
	private final String surname;
	
	private final String sport;
	
	private final Integer year;
	
	private final Boolean vegetarian;
	
}
