package com.pregenmed.pgmarticles.infrastructure.article.repository;

import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {


    ArticleEntity findByUuid(UUID articleUuid);
}