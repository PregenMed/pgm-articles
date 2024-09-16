package com.pregenmed.pgmarticles.infrastructure.article.controller;

import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.AddArticleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleContentRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleStatusRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.UpdateArticleTitleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.AddArticleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleContentResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleStatusResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleTitleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articles")
@Tag(name = "Article")
public interface ArticleController {

    //TODO add javadoc
    @Operation(
            description = "Give me article UUID and I will return you article",
            summary = "Get article",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200")
            }
    )
    GetArticleByUuidResponse getArticleByUuid(UUID articleUuid) throws Exception;

    @Operation(
            description = "Give me valid article and I will store it",
            summary = "Add article",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201")
            }
    )
    AddArticleResponse addArticle(AddArticleRequest addArticleRequest);

    @Operation(
            description = "Give me article UUID and I will delete it",
            summary = "Delete Article",
            responses = {
                    @ApiResponse(
                            description = "No Content",
                            responseCode = "204"),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404")
            }
    )
    ResponseEntity<Void> deleteArticle(UUID articleUuid);

    @Operation(
            description = "Give me a new article's content and I will update it",
            summary = "Update Article content",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404")
            }
    )
    UpdateArticleContentResponse updateContent(UpdateArticleContentRequest updateArticleContentRequest, UUID articleUuid) throws Exception;

    @Operation(
            description = "Give me a new article's title and I will update it",
            summary = "Update Article title",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404")
            }
    )
    UpdateArticleTitleResponse updateTitle(UpdateArticleTitleRequest updateArticleTitleRequest, UUID articleUuid) throws Exception;

    @Operation(
             description = "Give me a new article's status and I will update it",
            summary = "Update Article status",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404")
            }
    )
    UpdateArticleStatusResponse updateStatus(UpdateArticleStatusRequest updateArticleTitleRequest, UUID articleUuid) throws Exception;

}
