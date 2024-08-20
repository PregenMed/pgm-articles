package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.GetArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GetArticleUseCaseAdapter implements GetArticleUseCase {

    private final ArticleService articleService;

    @Override
    public Article getArticle(UUID articleUuid) {
        return articleService.getArticleByUuid(articleUuid);
    }
}
