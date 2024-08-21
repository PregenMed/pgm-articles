package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.AddArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddArticleUseCaseAdapter implements AddArticleUseCase {
    private final ArticleService articleService;


    @Override
    public Article addArticle(Article article) {
        //assign new article valid UUID
        article.setUuid(UUID.randomUUID());

        return articleService.addArticle(article);
    }
}
