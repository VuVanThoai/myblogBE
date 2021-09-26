package com.thoaidz.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thoaidz.blog.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query(value = "SELECT * FROM Comment WHERE id_article = :idArticle ORDER BY create_date DESC", nativeQuery = true)
	List<Comment> getListCommentsByIdArticle(@Param("idArticle") int idArticle);

}
