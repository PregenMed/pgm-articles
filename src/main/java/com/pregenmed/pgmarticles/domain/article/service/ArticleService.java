package com.pregenmed.pgmarticles.domain.article.service;

import com.pregenmed.pgmarticles.domain.article.model.Article;

import java.util.UUID;

public interface ArticleService {

    Article getArticleByUuid(UUID uuid);

    Article addArticle(Article article);
}
