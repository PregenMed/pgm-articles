package com.pregenmed.pgmarticles.domain.article.usecase;

import com.pregenmed.pgmarticles.domain.article.model.Article;

import java.util.UUID;

public interface GetArticleUseCase {
   Article getArticle(UUID articleUuid) throws Exception;
}
