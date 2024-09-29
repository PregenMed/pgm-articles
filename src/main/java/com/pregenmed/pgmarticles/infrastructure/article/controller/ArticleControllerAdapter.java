package com.pregenmed.pgmarticles.infrastructure.article.controller;

import com.pregenmed.pgmarticles.domain.article.usecase.AddArticleUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.DeleteArticleUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.GetArticleUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleContentUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleStatusUseCase;
import com.pregenmed.pgmarticles.domain.article.usecase.UpdateArticleTitleUseCase;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.AddArticleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleContentRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleStatusRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleTitleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.AddArticleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleContentResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleStatusResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleTitleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private final DeleteArticleUseCase deleteArticleUseCase;
    private final UpdateArticleContentUseCase updateArticleContentUseCase;
    private final UpdateArticleTitleUseCase updateArticleTitleUseCase;
    private final UpdateArticleStatusUseCase updateArticleStatusUseCase;

    @Override
    @GetMapping("/dummy")
    public String dummyEndpoint() {
        return "response from my dummy endpoint1";
    }

    @Override
    @GetMapping("/{articleUuid}")
    @ResponseStatus(OK)
    public GetArticleByUuidResponse getArticleByUuid(@PathVariable UUID articleUuid) throws Exception {
        return ARTICLE_MAPPER.mapToGetArticleByUuidResponse(getArticleUseCase.getArticle(articleUuid));
    }

    @PostMapping
    @Override
    @ResponseStatus(CREATED)
    public AddArticleResponse addArticle(@RequestBody @Valid AddArticleRequest addArticleRequest) {
        System.out.println(UUID.randomUUID());
        return ARTICLE_MAPPER.mapToAddArticleResponse(addArticleUseCase.addArticle(
                ARTICLE_MAPPER.mapToArticle(addArticleRequest)));
    }

    @Override
    @DeleteMapping("/{articleUuid}")
    public ResponseEntity<Void> deleteArticle(@PathVariable UUID articleUuid) {
        return deleteArticleUseCase.deleteArticle(articleUuid) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/{articleUuid}/content")
    public UpdateArticleContentResponse updateContent(@RequestBody UpdateArticleContentRequest updateArticleContentRequest, @PathVariable UUID articleUuid) throws Exception {
        return ARTICLE_MAPPER.mapToUpdateArticleContentResponse(updateArticleContentUseCase.execute(articleUuid, updateArticleContentRequest.getContent()));
    }

    @Override
    @PutMapping("/{articleUuid}/title")
    public UpdateArticleTitleResponse updateTitle(UpdateArticleTitleRequest updateArticleTitleRequest, UUID articleUuid) throws Exception {
        return ARTICLE_MAPPER.mapToUpateArticleTitleResponse(updateArticleTitleUseCase.execute(articleUuid, updateArticleTitleRequest.getTitle()));
    }

    @Override
    @PutMapping("/{articleUuid}/status")
    public UpdateArticleStatusResponse updateStatus(UpdateArticleStatusRequest updateArticleTitleRequest, UUID articleUuid) throws Exception {
        return ARTICLE_MAPPER.mapToUpdateArticleStatusResponse(updateArticleStatusUseCase.execute(articleUuid, updateArticleTitleRequest.getStatus()));
    }
}
