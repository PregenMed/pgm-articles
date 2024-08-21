package com.pregenmed.pgmarticles.infrastructure.article.controller;

import com.pregenmed.pgmarticles.domain.article.usecase.AddArticleUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.GetArticleUseCase;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.AddArticleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.AddArticleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.pregenmed.pgmarticles.infrastructure.article.mapper.ArticleMapper.ARTICLE_MAPPER;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleControllerAdapter implements ArticleController {
    private final GetArticleUseCase getArticleUseCase;
    private final AddArticleUseCase addArticleUseCase;

    @Override
    @GetMapping("/{uuid}")
    @ResponseStatus(OK)
    public GetArticleByUuidResponse getArticleByUuid(@PathVariable UUID uuid) {
        return ARTICLE_MAPPER.mapToGetArticleByUuidResponse(getArticleUseCase.getArticle(uuid));
    }


    @PostMapping()
    @Override
    @ResponseStatus(CREATED)
    public AddArticleResponse addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        return ARTICLE_MAPPER.mapToAddArticleResponse(addArticleUseCase.addArticle(
                ARTICLE_MAPPER.mapToArticle(addArticleRequest)));
    }
}
