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
	
	public List<Article> getListArticleByCategory(int idCategory, int offset) {
		return articleRepository.getListArticlesByIdCategoryOffset(idCategory, offset);
	}
	
	public Optional<Article> getArticleById(int idArticle) {
		return articleRepository.findById(idArticle);
	}
	
	public Article saveNewArticle(Article article) {
		return articleRepository.save(article);
	}

	public Optional<Article> getArticleByUrl(String url) {
		return articleRepository.getArticleByUrl(url);
	}
	
	public List<Article> getListArticleHeightView() {
		return articleRepository.getListArticleHeightView(10);
	}
	
	public List<Article> getListArticleHeightViewForMain() {
		return articleRepository.getListArticleHeightView(6);
	}
	
	public List<Article> getListNewArticlesLoadMoreOffset(int offset) {
		return articleRepository.getListNewArticlesLoadMoreOffset(offset);
	}
	
	public List<Article> search(String key, int offset) {
		return articleRepository.search(key, offset);
	}
	
	public void deleteArticle(int id) {
		articleRepository.deleteById(id);
	}

}
