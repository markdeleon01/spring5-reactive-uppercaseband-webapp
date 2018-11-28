/**
 * 
 */
package com.uppercaseband.commands;

import com.uppercaseband.domain.MediaType;

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
public class MediaCommand {
	
	private MediaType type;
	
	private String path;
}
