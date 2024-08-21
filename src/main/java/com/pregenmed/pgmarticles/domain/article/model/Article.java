package com.pregenmed.pgmarticles.domain.article.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private int id;
    private UUID uuid;
    private String title;
    private UUID authorUuid;
    private String content;
    private ArticleStatus status;
    private Instant createdAt;
    private Instant updatedAt;
}
