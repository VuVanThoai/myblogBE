package com.thoaidz.blog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoaidz.blog.model.Article;
import com.thoaidz.blog.service.ArticleService;

@RestController
@RequestMapping("/api/v1/")
public class ArticleController {

	private ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("articles")
	ResponseEntity<List<Article>> getListArticle() {
		List<Article> listArticle = articleService.getListArticle();
		return new ResponseEntity<List<Article>>(listArticle, HttpStatus.OK);
	}

	@GetMapping("articles/{idCategory}")
	ResponseEntity<List<Article>> getListArticleByCategoryOffset(@PathVariable int idCategory, @RequestParam int offset) {
		List<Article> listArticleByCategory = articleService.getListArticleByCategory(idCategory, offset);
		return new ResponseEntity<List<Article>>(listArticleByCategory, HttpStatus.OK);
	}

	@GetMapping("article/{idArticle}")
	ResponseEntity<Article> getArticleById(@PathVariable int idArticle) {
		Optional<Article> articleById = articleService.getArticleById(idArticle);
		if (articleById.isPresent()) {
			return new ResponseEntity<Article>(articleById.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("article/query-url/{url}")
	ResponseEntity<Article> getArticleByUrl(@PathVariable String url) {
		Optional<Article> articleByUrl = articleService.getArticleByUrl(url);
		if (articleByUrl.isPresent()) {
			return new ResponseEntity<Article>(articleByUrl.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("articles/height-view")
	ResponseEntity<List<Article>> getListArticleHeightView() {
		List<Article> listArticleByOffset = articleService.getListArticleHeightView();
		return new ResponseEntity<List<Article>>(listArticleByOffset, HttpStatus.OK);
	}

	@GetMapping("articles/height-view/main")
	ResponseEntity<List<Article>> getListArticleHeightViewForMain() {
		List<Article> listArticleByOffset = articleService.getListArticleHeightViewForMain();
		return new ResponseEntity<List<Article>>(listArticleByOffset, HttpStatus.OK);
	}

	@GetMapping("articles/search")
	ResponseEntity<List<Article>> search(@RequestParam String key, @RequestParam int offset) {
		List<Article> listArticleByOffset = articleService.search(key, offset);
		return new ResponseEntity<List<Article>>(listArticleByOffset, HttpStatus.OK);
	}

	@GetMapping("articles/os/{offset}")
	ResponseEntity<List<Article>> getListNewArticlesLoadMoreOffset(@PathVariable int offset) {
		List<Article> listArticleByOffset = articleService.getListNewArticlesLoadMoreOffset(offset);
		return new ResponseEntity<List<Article>>(listArticleByOffset, HttpStatus.OK);
	}

	@PostMapping("article")
	ResponseEntity<Article> saveArticle(@Valid @RequestBody Article article) {
		Article newArticle = articleService.saveNewArticle(article);
		if (newArticle != null) {
			return new ResponseEntity<Article>(newArticle, HttpStatus.OK);
		} else {
			return new ResponseEntity<Article>(HttpStatus.BAD_GATEWAY);
		}
	}

	@PutMapping("article")
	ResponseEntity<Article> updateArticle(@Valid @RequestBody Article article) {
		Article newArticle = articleService.saveNewArticle(article);
		if (newArticle != null) {
			return new ResponseEntity<Article>(newArticle, HttpStatus.OK);
		} else {
			System.err.println("---error---------");
			return new ResponseEntity<Article>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("article/{id}")
	ResponseEntity<Boolean> deleteArticle(@PathVariable int id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
