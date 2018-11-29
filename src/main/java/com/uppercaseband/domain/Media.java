/**
 * 
 */
package com.uppercaseband.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author markdeleon
 *
 */
@Data
public class Media {

	@Id
	private String id;	//removed "database leakage" here from RDBMS design
	
	private MediaType type;
	
	private String path;
}
