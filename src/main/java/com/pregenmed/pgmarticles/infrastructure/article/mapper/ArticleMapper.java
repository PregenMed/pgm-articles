package com.pregenmed.pgmarticles.infrastructure.article.mapper;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.response.GetArticleByUuidResponse;
import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    Article mapToArticle(ArticleEntity article);

    ArticleEntity mapToArticleEntity(Article article);

    GetArticleByUuidResponse mapToGetArticleByUuidResponse(Article article);
}
