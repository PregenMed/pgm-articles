package com.pregenmed.pgmarticles.infrastructure.article.adapter;

import com.pregenmed.pgmarticles.domain.article.model.Article;
import com.pregenmed.pgmarticles.domain.article.service.ArticleService;
import com.pregenmed.pgmarticles.infrastructure.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.pregenmed.pgmarticles.infrastructure.article.mapper.ArticleMapper.ARTICLE_MAPPER;

@Service
@RequiredArgsConstructor
public class ArticleServiceAdapter implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article getArticleByUuid(UUID uuid) {
        //TODO exception handling

        return ARTICLE_MAPPER.mapToArticle(articleRepository.findByUuid(uuid));
    }

    @Override
    public Article addArticle(Article article) {
        // TODO exception handling
        return ARTICLE_MAPPER.mapToArticle(articleRepository.save(ARTICLE_MAPPER.mapToArticleEntity(article)));
    }


}
