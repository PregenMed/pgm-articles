package com.pregenmed.pgmarticles.infrastructure.article.mapper;

import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;
import com.pregenmed.pgmarticles.infrastructure.article.controller.dto.request.ArticleStatusUpdate;
import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleStatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleStatusMapper {


    ArticleStatusMapper ARTICLE_STATUS_MAPPER = Mappers.getMapper(ArticleStatusMapper.class);

    @ValueMapping(source = "DRAFT", target = "DRAFT")
    @ValueMapping(source = "PUBLISHED", target = "PUBLISHED")
    @ValueMapping(source = "ARCHIVED", target = "ARCHIVED")
    ArticleStatus mapToArticleStatus(ArticleStatusUpdate articleStatusUpdate);

    @ValueMapping(source = "DRAFT", target = "DRAFT")
    @ValueMapping(source = "PUBLISHED", target = "PUBLISHED")
    @ValueMapping(source = "ARCHIVED", target = "ARCHIVED")
    @ValueMapping(source = "DELETED", target = "DELETED")
    ArticleStatusEntity mapToArticleStatusEntity(ArticleStatus articleStatus);
}
