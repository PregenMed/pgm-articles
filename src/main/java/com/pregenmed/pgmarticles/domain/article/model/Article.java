package com.pregenmed.pgmarticles.domain.article.model;

import lombok.*;

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
    private Instant createdAt;
    private Instant updatedAt;
}
