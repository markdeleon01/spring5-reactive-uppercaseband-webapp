/**
 * 
 */
package com.uppercaseband.commands;

import com.uppercaseband.domain.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author markdeleon
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ArticleCommand {
	
	private String title;
	
	private String description;
	
	private Integer displayOrder;
	
	private MediaCommand media;
	
	private String subcontent;
	
	private Category category;
}
