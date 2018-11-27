/**
 * 
 */
package com.uppercaseband.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;
import com.uppercaseband.repository.ArticleRepository;

/**
 * @author markdeleon
 *
 */

@RunWith(SpringRunner.class)
@DataMongoTest					//integration test
public class ArticleRepositoryTest {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@Before
	public void setUp() {
		articleRepository.deleteAll().block();
	}
	
	
	@Test
	public void testArticleSave() {
    	Article article = new Article();
    	article.setTitle("Tanging Ikaw");
    	article.setDescription("The brand new single from UPPERCASE released under Radio Insect Records");
    	article.setDisplayOrder(100);
    	article.setCategory(Category.HIGHLIGHTS);
    	article.setSubcontent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>");
    	
    	Media article1Media = new Media();
    	article1Media.setType(MediaType.IMAGE);
    	article1Media.setPath("/images/tanging_ikaw.png");
    	
    	article.setMedia(article1Media);
    	
    	articleRepository.save(article).block();
    	//the save() acts reactively but there is no subscriber so we need to block() to force the save

        Long count = articleRepository.count().block();	//the block() triggers the whole reactive "train" to take off

        assertEquals(Long.valueOf(1L), count);
	}

}
