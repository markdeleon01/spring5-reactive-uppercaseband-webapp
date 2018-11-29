/**
 * 
 */
package com.uppercaseband.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uppercaseband.commands.ArticleCommand;
import com.uppercaseband.services.ArticleService;

import reactor.core.publisher.Flux;


/**
 * @author markdeleon
 *
 */
@RestController
public class ArticleController {

	//provide a constant for the base URL
    public static final String BASE_URL = "/api/v1/articles";

    
	private final ArticleService articleService;
	

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	
	@GetMapping(ArticleController.BASE_URL)
	public Flux<ArticleCommand> getAllArticles() {

		return articleService.getAllArticles();
	}
	
	
	@GetMapping(ArticleController.BASE_URL+"/{category}")
	public Flux<ArticleCommand> getArticlesByCategory(@PathVariable Optional<String> category) {
		
		if (category.isPresent()) {
			return articleService.getArticlesByCategory(category.get());			
		} else {
			return Flux.empty();
		}
	}

}
