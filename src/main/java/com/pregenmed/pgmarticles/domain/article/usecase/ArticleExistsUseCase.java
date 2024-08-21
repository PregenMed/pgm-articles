package com.pregenmed.pgmarticles.domain.article.usecase;

import java.util.UUID;

public interface ArticleExistsUseCase {
    boolean execute(UUID articleUUID);
}
