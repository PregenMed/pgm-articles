package com.pregenmed.pgmarticles.domain.article.usecase.adapter;

import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.domain.article.usecase.ArticleExistsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ArticleExistsUseCaseAdapter implements ArticleExistsUseCase {

    private final ArticleService articleService;

    @Override
    public boolean execute(UUID articleUUID) {
        return articleService.articleExistByUuid(articleUUID);
    }
}
