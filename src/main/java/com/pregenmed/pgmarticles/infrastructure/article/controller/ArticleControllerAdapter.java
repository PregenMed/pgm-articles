package com.pregenmed.pgmarticles.infrastructure.article.controller;

import com.pregenmed.pgmarticles.domain.article.usecase.GetArticleUseCase;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.pregenmed.pgmarticles.infrastructure.article.mapper.ArticleMapper.ARTICLE_MAPPER;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleControllerAdapter implements ArticleController {
    private final GetArticleUseCase getArticleUseCase;

    @Override

    @GetMapping("/{uuid}")
    @ResponseStatus(OK)
    public GetArticleByUuidResponse getArticleByUuid(UUID uuid) {
        return ARTICLE_MAPPER.mapToGetArticleByUuidResponse(getArticleUseCase.getArticle(uuid));
    }
}
