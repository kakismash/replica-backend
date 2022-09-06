package com.kaki.replicabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaki.replicabackend.entity.Video;
import com.kaki.replicabackend.repository.VideoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Mono<Video> getVideoByName(String name) {
        return this.videoRepository.findByName(name);
    }

    public Flux<Video> getVideosByName(String name) {
        return this.videoRepository.findAllVideoByName(name);
    }

    public Flux<Video> getAllVideos() {
        return this.videoRepository.findAll();
    }

    public Mono<Video> getById(Long id) {
        return this.videoRepository.findById(id);
    }

    public Mono<Video> createOrUpdateVideo(Video video) {
        return this.videoRepository.save(video);
    }

    public Mono<Void> deleteVideo(Long videoId) {
        return this.videoRepository.deleteById(videoId);
    }

}