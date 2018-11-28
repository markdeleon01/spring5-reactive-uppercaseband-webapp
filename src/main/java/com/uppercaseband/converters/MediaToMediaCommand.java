/**
 * 
 */
package com.uppercaseband.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.uppercaseband.commands.MediaCommand;
import com.uppercaseband.domain.Media;

import lombok.Synchronized;

/**
 * @author markdeleon
 *
 */

@Component		//Spring bean
public class MediaToMediaCommand implements Converter<Media, MediaCommand> {

    @Synchronized
    @Nullable
	@Override
	public MediaCommand convert(Media media) {

		if (media == null) {
			return null;
		}
		
		final MediaCommand mediaCommand = new MediaCommand();
		mediaCommand.setType(media.getType());
		mediaCommand.setPath(media.getPath());
		return mediaCommand;
	}

}
