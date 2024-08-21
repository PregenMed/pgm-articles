package com.pregenmed.pgmarticles.domain.article.usecase;

import com.pregenmed.pgmarticles.domain.article.model.Article;

import java.util.UUID;

public interface UpdateArticleContentUseCase {
    Article execute(UUID articleUuid, String articleContent) throws Exception;

}
