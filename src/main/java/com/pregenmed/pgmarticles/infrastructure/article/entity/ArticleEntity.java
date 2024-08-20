package com.pregenmed.pgmarticles.infrastructure.article.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Table(name = "article")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity {

    //TODO tune up entity nulls,constraints etc


    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "title")
    private String title;
    @Column(name = "authorUuid")
    private UUID authorUuid;
    @Column(name = "content")
    private String content;
    @Column(name = "createdAt")
    @CreationTimestamp
    private Instant createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private Instant updatedAt;
}
