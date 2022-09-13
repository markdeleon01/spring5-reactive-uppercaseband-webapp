/**
 * 
 */
package com.uppercaseband.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.uppercaseband.commands.ArticleCommand;
import com.uppercaseband.services.ArticleService;

import reactor.core.publisher.Flux;

/**
 * @author markdeleon
 *
 */
public class ArticleControllerTest {
	
	WebTestClient webTestClient;
	ArticleService articleService;
	ArticleController articleController;
	
	
	@Before
	public void setUp() throws Exception {
		articleService = Mockito.mock(ArticleService.class);
		articleController = new ArticleController(articleService);
		webTestClient = WebTestClient.bindToController(articleController).build();
	}
	
	
	@Test
	public void testGetAllArticles() {
		
		BDDMockito.given( articleService.getAllArticles())
					.willReturn( Flux.just( new ArticleCommand() ) );
		
		webTestClient.get()
					.uri(ArticleController.BASE_URL)
					.exchange()
					.expectBodyList(ArticleCommand.class)
					.hasSize(1);
	}
	
	
	@Test
	public void testGetArticlesByCategory() {
		
		BDDMockito.given( articleService.getArticlesByCategory( "SOMECATEGORY" ) )
				.willReturn( Flux.just( new ArticleCommand() ));
					
		
		webTestClient.get()
					.uri(ArticleController.BASE_URL+"?category=someCategory")
					.exchange()
					.expectBodyList(ArticleCommand.class)
					.hasSize(1);		
	}
	
	
	@Test
	public void testGetArticlesInvalidCategory() {
		
		BDDMockito.given( articleService.getArticlesByCategory( "SOMEINVALIDCATEGORY" ) )
				.willReturn( Flux.empty() );
					
		
		webTestClient.get()
					.uri(ArticleController.BASE_URL+"?category=someInvalidCategory")
					.exchange()
					.expectBodyList(ArticleCommand.class)
					.hasSize(0);
	}

}
