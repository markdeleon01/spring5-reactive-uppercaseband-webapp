/**
 * 
 */
package com.uppercaseband.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;

import reactor.core.publisher.Flux;

/**
 * @author markdeleon
 *
 */
public interface ArticleRepository extends ReactiveMongoRepository<Article, String>{
	
	Flux<Article> findByCategory(Category c);	//find zero or more elements of Article based on Category

}
