package com.pregenmed.pgmarticles.infrastructure.article.controller;

import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.AddArticleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.AddArticleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articles")
public interface ArticleController {

    //TODO add swagger
    //TODO add javadoc

    GetArticleByUuidResponse getArticleByUuid(UUID uuid);

    AddArticleResponse addArticle(AddArticleRequest addArticleRequest);


}
