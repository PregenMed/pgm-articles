package com.pregenmed.pgmarticles.domain.article.usecase.adapter;


import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.ArticleExistsUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleStatusUseCase;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.ArticleStatusUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.pregenmed.pgmarticles.infrastructure.article.mapper.ArticleStatusMapper.ARTICLE_STATUS_MAPPER;

@RequiredArgsConstructor
@Service
public class UpdateArticleStatusUseCaseAdapter implements UpdateArticleStatusUseCase {

    private final ArticleExistsUseCase articleExistsUseCase;
    private final ArticleService articleService;

    @Override
    public Article execute(UUID articleUuid, ArticleStatusUpdate articleStatusUpdate) throws Exception {

        if (articleExistsUseCase.execute(articleUuid)) {
            return articleService.updateArticleStatus(articleUuid, ARTICLE_STATUS_MAPPER.mapToArticleStatus(articleStatusUpdate));
        } else {
            throw new Exception(); // TODO add domain exception
        }
    }

}
