/**
 * 
 */
package com.uppercaseband.services;

import com.uppercaseband.commands.ArticleCommand;

import reactor.core.publisher.Flux;

/**
 * @author markdeleon
 *
 */
public interface ArticleService {	//the service returns reactive types (mono or flux)
	
	Flux<ArticleCommand> getAllArticles();
	
	Flux<ArticleCommand> getArticlesByCategory(String category);

}
