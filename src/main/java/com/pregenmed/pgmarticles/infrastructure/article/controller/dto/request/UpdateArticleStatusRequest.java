package com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleStatusRequest {
    // TODO add validation and swagger description
    private ArticleStatusUpdate status;
}
