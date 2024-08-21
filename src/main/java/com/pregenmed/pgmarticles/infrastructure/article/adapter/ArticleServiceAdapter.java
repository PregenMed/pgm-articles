package com.pregenmed.pgmarticles.infrastructure.article.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.model.ArticleStatus;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleEntity;
import com.pregenmed.pgmarticles.infrastructure.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleStatusEntity.DELETED;
import static com.pregenmed.pgmarticles.infrastructure.article.mapper.ArticleMapper.ARTICLE_MAPPER;

@Service
@RequiredArgsConstructor
public class ArticleServiceAdapter implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article getArticleByUuid(UUID articleUuid) throws Exception {
        //TODO exception handling
        // TODO add to redis when ready

        return ARTICLE_MAPPER.mapToArticle(getArticleEntityByUuid(articleUuid));

    }

    @Override
    public Article addArticle(Article article) {
        // TODO exception handling
        return ARTICLE_MAPPER.mapToArticle(articleRepository.save(ARTICLE_MAPPER.mapToArticleEntity(article)));
    }

    @Override
    public boolean deleteArticle(Article article) throws Exception {
//TODO delete from Redis when ready
        // TODO add auditing
        article.setStatus(ArticleStatus.DELETED);
        try {
            //TODO refactor when update functionality will be ready
            return Optional.ofNullable(articleRepository.save(ARTICLE_MAPPER.mapToArticleEntity(article)))
                    .map(entity -> DELETED.equals(entity.getStatus()))
                    .orElse(false);
        } catch (Exception e) {
            //TODO add custom exception when you start implementing exception handling and domain exceptionss
            // some unexpected exception
            throw new Exception();
        }

    }

    @Override
    public boolean articleExistByUuid(UUID articleUUID) {
        return articleRepository.existsByUuid(articleUUID);
    }

    @Override
    public Article updateArticleContent(UUID articleUuid, String articleContent) throws Exception {
        // TODO add auditing
        var articleEntity = getArticleEntityByUuid(articleUuid);
        articleEntity.setContent(articleContent);
        return ARTICLE_MAPPER.mapToArticle(updateArticleEntity(articleEntity));
    }

    private ArticleEntity getArticleEntityByUuid(UUID articleUuid) throws Exception {
        return articleRepository.getArticleByUuidAndStatusNot(articleUuid, DELETED).orElseThrow(() -> new Exception());       //TODO add custom exception when you start implementing exception handling and domain exceptions
    }

    private ArticleEntity updateArticleEntity(ArticleEntity articleEntity) {
        return articleRepository.save(articleEntity);
    }
}
