package com.pregenmed.pgmarticles.domain.article.usecase;

import java.util.UUID;

public interface DeleteArticleUseCase {
    boolean deleteArticle(UUID articleUuid);
}
