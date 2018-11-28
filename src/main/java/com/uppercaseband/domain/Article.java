/**
 * 
 */
package com.uppercaseband.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author markdeleon
 *
 */
@Getter
@Setter
@Document
public class Article {
	
	@Id
	private String id;	//removed "database leakage" here from RDBMS design
	
	private String title;
	
	private String description;
	
	private Integer sortOrder;
	
	private Media media;
	
	private String subcontent;
	
	private Category category;
}
