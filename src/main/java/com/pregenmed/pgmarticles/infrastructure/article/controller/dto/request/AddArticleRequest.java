package com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request;


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
}
