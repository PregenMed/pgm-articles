package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.ArticleExistsUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleTitleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateArticleTitleUseCaseAdapter implements UpdateArticleTitleUseCase {

    private final ArticleService articleService;
    private final ArticleExistsUseCase articleExistsUseCase;

    @Override
    public Article execute(UUID articleUuid, String title) throws Exception {

        if (articleExistsUseCase.execute(articleUuid)) {
            return articleService.updateArticleTitle(articleUuid, title);
        } else {
            throw new Exception(); // TODO add domain exception
        }
    }
}
