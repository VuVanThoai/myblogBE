package com.thoaidz.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoaidz.blog.model.Article;
import com.thoaidz.blog.repository.ArticleRepository;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;

	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public List<Article> getListArticle() {
		return articleRepository.findAll();
	}
	
	public List<Article> getListArticleByCategory(int idCategory) {
		return articleRepository.findByIdCategory(idCategory);
	}
	
	public Optional<Article> getArticleById(int idArticle) {
		return articleRepository.findById(idArticle);
	}
	
	public Article saveNewArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public List<Article> getListArticlesOffset(int offset) {
		return articleRepository.getListArticlesOffset(offset);
	}
	
	public Optional<Article> getArticleByUrl(String url) {
		return articleRepository.getArticleByUrl(url);
	}

}
