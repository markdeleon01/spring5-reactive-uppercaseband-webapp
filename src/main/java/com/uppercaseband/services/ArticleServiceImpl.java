/**
 * 
 */
package com.uppercaseband.services;


import org.springframework.stereotype.Service;

import com.uppercaseband.commands.ArticleCommand;
import com.uppercaseband.converters.ArticleToArticleCommand;
import com.uppercaseband.domain.Category;
import com.uppercaseband.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * @author markdeleon
 *
 */

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;
	private final ArticleToArticleCommand articleConverter;

	
	public ArticleServiceImpl(ArticleRepository articleRepository, ArticleToArticleCommand articleConverter) {
		this.articleRepository = articleRepository;
		this.articleConverter = articleConverter;
	}


	@Override
	public Flux<ArticleCommand> getAllArticles() {
		
		log.debug("getAllArticles");
		
		return articleRepository.findAll()
			.map(articleConverter::convert);
	}


	@Override
	public Flux<ArticleCommand> getArticlesByCategory(String category) {
		
		log.debug("getArticlesByCategory="+category);

		return articleRepository.findByCategory(Category.valueOf(category))
				.map(articleConverter::convert);
	}

}
