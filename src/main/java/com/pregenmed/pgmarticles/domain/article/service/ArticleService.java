package com.pregenmed.pgmarticles.domain.article.service;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;

import java.util.UUID;

public interface ArticleService {

    Article getArticleByUuid(UUID articleUuid) throws Exception;

    Article addArticle(Article article);

    boolean deleteArticle(Article article) throws Exception;

    boolean articleExistByUuid(UUID articleUUID);

    Article updateArticleContent(UUID articleUuid, String articleContent) throws Exception;

    Article updateArticleTitle(UUID articleUuid, String title) throws Exception;

    Article updateArticleStatus(UUID articleUuid, ArticleStatus articleStatus) throws Exception;

}
