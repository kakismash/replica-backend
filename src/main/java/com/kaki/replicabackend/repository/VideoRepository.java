package com.kaki.replicabackend.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.kaki.replicabackend.entity.Video;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VideoRepository extends R2dbcRepository<Video, Long> {

    Mono<Video> findByName(String name);

    Flux<Video> findAllVideoByName(String name);
}