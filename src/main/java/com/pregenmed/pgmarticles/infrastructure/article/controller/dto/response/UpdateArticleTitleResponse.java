package com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response;

import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleTitleResponse {

// TODO add validation
    private UUID uuid;
    private String title;
    private UUID authorUuid;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    private ArticleStatus status;
}
