package com.pregenmed.pgmarticles.infrastructure.article.repository;

import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleEntity;
import com.pregenmed.pgmarticles.infrastructure.article.entity.ArticleStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

    // TODO improve that with id when Redis will be ready
    @Query("SELECT a FROM ArticleEntity a WHERE a.uuid = :uuid AND a.status <> :status")
    Optional<ArticleEntity> getArticleByUuidAndStatusNot(
            @Param(value = "uuid") UUID articleUuid,
            @Param(value = "status") ArticleStatusEntity articleStatusEntity);

    boolean existsByUuid(UUID articleUuid);
}