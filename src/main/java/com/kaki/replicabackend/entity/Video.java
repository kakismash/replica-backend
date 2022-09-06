package com.kaki.replicabackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("video")
public class Video {

    @Id
    private Long id;

    @NonNull
    @Column()
    private String name;

    private String description;

    @NonNull
    @Column()
    private String size;

    @NonNull
    @Column()
    private Long duration;

    @NonNull
    @Column()
    private String format;

}