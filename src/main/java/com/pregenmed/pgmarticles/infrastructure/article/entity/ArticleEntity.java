package com.pregenmed.pgmarticles.infrastructure.article.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;


@Table(name = "article", schema = "pgmarticle",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"uuid", "author_uuid"})},
        indexes = {
                @Index(name = "idx_uuid", columnList = "uuid"),
                @Index(name = "idx_author_uuid", columnList = "author_uuid")
        })
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private UUID uuid;
    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author_uuid", nullable = false, updatable = false)
    private UUID authorUuid;
    @Column(name = "content", nullable = false, length = 10000)
    private String content;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Instant createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;
}
