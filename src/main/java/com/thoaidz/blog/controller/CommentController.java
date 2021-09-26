package com.thoaidz.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoaidz.blog.model.Comment;
import com.thoaidz.blog.service.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("comments/{idArticle}")
	ResponseEntity<List<Comment>> getListCommentsByIdArticle(@PathVariable int idArticle) {
		List<Comment> listCommentByIdArticle = commentService.getListCommentsByIdArticle(idArticle);
		return new ResponseEntity<List<Comment>>(listCommentByIdArticle, HttpStatus.OK);
	}
	
	@PostMapping("comment")
	ResponseEntity<Comment> saveNewComment(@Valid @RequestBody Comment comment) {
		Comment newComment = commentService.saveNewComment(comment);
		return new ResponseEntity<Comment>(newComment, HttpStatus.OK);
	}

}
