package com.thoaidz.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoaidz.blog.model.Comment;
import com.thoaidz.blog.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public List<Comment> getListCommentsByIdArticle(int idArticle) {
		return commentRepository.getListCommentsByIdArticle(idArticle);
	}
	
	public Comment saveNewComment(Comment comment) {
		return commentRepository.save(comment);
	}

	
}
