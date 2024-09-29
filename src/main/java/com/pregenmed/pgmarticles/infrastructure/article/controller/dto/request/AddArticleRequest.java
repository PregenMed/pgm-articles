package com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;
import jakarta.validation.constraints.Size;
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
    @Size.List({
            @Size(min = 10, message = "{validation.article.title.size.too_short}"),
            @Size(max = 255, message = "{validation.article.title.size.too_long}")
    })
    private String title;
    private UUID authorUuid;
    @Size.List({
            @Size(min = 1, message = "{validation.article.content.size.too_short}"),
            @Size(max = 10000, message = "{validation.article.content.size.too_long}")
    })
    private String content;
    private ArticleStatus status;
}
