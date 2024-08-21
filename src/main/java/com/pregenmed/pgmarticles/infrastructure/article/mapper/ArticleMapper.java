package com.pregenmed.pgmarticles.infrastructure.article.mapper;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.AddArticleRequest;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.AddArticleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleContentResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleStatusResponse;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.UpdateArticleTitleResponse;
import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    Article mapToArticle(ArticleEntity article);

    @Mapping(target = "id", ignore = true)
    ArticleEntity mapToArticleEntity(Article article);

    GetArticleByUuidResponse mapToGetArticleByUuidResponse(Article article);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Article mapToArticle(AddArticleRequest addArticleRequest);

    AddArticleResponse mapToAddArticleResponse(Article article);

    UpdateArticleContentResponse mapToUpdateArticleContentResponse(Article article);

    UpdateArticleTitleResponse mapToUpateArticleTitleResponse(Article article);

    UpdateArticleStatusResponse mapToUpdateArticleStatusResponse(Article article);
}
