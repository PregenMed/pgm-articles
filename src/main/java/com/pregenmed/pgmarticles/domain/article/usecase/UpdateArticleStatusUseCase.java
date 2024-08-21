package com.pregenmed.pgmarticles.domain.article.usecase;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.ArticleStatusUpdate;

import java.util.UUID;

public interface UpdateArticleStatusUseCase {

    Article execute(UUID articleUuid, ArticleStatusUpdate articleStatusUpdate) throws Exception;
}
