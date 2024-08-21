package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.DeleteArticleUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.GetArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteArticleUseCaseAdapter implements DeleteArticleUseCase {

    private final GetArticleUseCase getArticleUseCase;
    private final ArticleService articleService;


    @Override
    public boolean deleteArticle(UUID articleUuid) {

        try {
            return articleService.deleteArticle(getArticleUseCase.getArticle(articleUuid));
        }catch (Exception e) {
            return false;
        }
    }
}
