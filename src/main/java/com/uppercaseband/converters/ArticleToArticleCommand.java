/**
 * 
 */
package com.uppercaseband.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.uppercaseband.commands.ArticleCommand;
import com.uppercaseband.domain.Article;

import lombok.Synchronized;

/**
 * @author markdeleon
 *
 */

@Component		//Spring bean
public class ArticleToArticleCommand implements Converter<Article, ArticleCommand> {

	
	private final MediaToMediaCommand mediaConverter;
	
	
	public ArticleToArticleCommand(MediaToMediaCommand mediaConverter) {
		this.mediaConverter = mediaConverter;
	}


    @Synchronized
    @Nullable
	@Override
	public ArticleCommand convert(Article article) {

		if (article == null) {
			return null;
		}
		
		final ArticleCommand articleCommand = new ArticleCommand();
		articleCommand.setTitle(article.getTitle());
		articleCommand.setDescription(article.getDescription());
		articleCommand.setSubcontent(article.getSubcontent());
		articleCommand.setCategory(article.getCategory());
		articleCommand.setDisplayOrder(article.getSortOrder());
		articleCommand.setMedia(mediaConverter.convert(article.getMedia()));
		return articleCommand;
	}

}
