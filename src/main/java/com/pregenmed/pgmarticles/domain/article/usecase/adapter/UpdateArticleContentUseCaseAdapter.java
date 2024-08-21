package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.ArticleExistsUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleContentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateArticleContentUseCaseAdapter implements UpdateArticleContentUseCase {

    private final ArticleService articleService;
    private final ArticleExistsUseCase articleExistsUseCase;

    @Override
    public Article execute(UUID articleUuid, String articleContent) throws Exception {
        if (articleExistsUseCase.execute(articleUuid)) {
            return articleService.updateArticleContent(articleUuid, articleContent);
        } else {
            throw new Exception(); // TODO add domain exception
        }

    }
}
