package com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request;


import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    // TODO add validation

    private String title;
    private UUID authorUuid;
    private String content;
    private ArticleStatus status;
}
