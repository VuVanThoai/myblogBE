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

	@Query(value = "SELECT * FROM Article WHERE id_category = :idCategory ORDER BY create_date DESC LIMIT 18 OFFSET :offset", nativeQuery = true)
	List<Article> getListArticlesByIdCategoryOffset(@Param("idCategory") int idCategory, @Param("offset") int offset);
	
	@Query(value = "SELECT * FROM Article WHERE url = :url limit 1", nativeQuery = true)
	Optional<Article> getArticleByUrl(@Param("url") String url);
	
	@Query(value = "SELECT * FROM Article ORDER BY view DESC LIMIT :limit", nativeQuery = true)
	List<Article> getListArticleHeightView(@Param("limit") int limit);
	
	@Query(value = "SELECT * FROM Article ORDER BY create_date DESC LIMIT 24 OFFSET :offset", nativeQuery = true)
	List<Article> getListNewArticlesLoadMoreOffset(@Param("offset") int offset);
	
	@Query(value = "SELECT * FROM Article WHERE title LIKE %:key% OR body LIKE %:key% OR tag LIKE %:key% ORDER BY create_date DESC LIMIT 18 OFFSET :offset", nativeQuery = true)
	List<Article> search(@Param("key") String key, @Param("offset") int offset);
	
}
