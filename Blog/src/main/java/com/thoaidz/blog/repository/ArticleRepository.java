package com.thoaidz.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thoaidz.blog.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT * FROM Article WHERE id_category = :idCategory", nativeQuery = true)
	List<Article> findByIdCategory(@Param("idCategory") int idCategory);
	
	@Query(value = "SELECT * FROM Article ORDER BY create_date DESC LIMIT 20 OFFSET :offset", nativeQuery = true)
	List<Article> getListArticlesOffset(@Param("offset") int offset);
	
	@Query(value = "SELECT * FROM Article WHERE url = :url", nativeQuery = true)
	Optional<Article> getArticleByUrl(@Param("url") String url);
}
