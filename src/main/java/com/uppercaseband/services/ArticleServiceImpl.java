/**
 * 
 */
package com.uppercaseband.services;


import java.io.PrintWriter;
import java.io.StringWriter;

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

		try {
			Category theCategory = Category.valueOf(category);
			
			return articleRepository.findByCategory(theCategory)
					.map(articleConverter::convert);
			
		} catch (IllegalArgumentException e) {	//for invalid category
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
			log.error(sStackTrace);
			
			return Flux.empty();
		}
	}

}
