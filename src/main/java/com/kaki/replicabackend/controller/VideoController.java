package com.kaki.replicabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaki.replicabackend.entity.Video;
import com.kaki.replicabackend.service.VideoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/video")
public class VideoController {

    @Autowired(required = false)
    private VideoService videoService;

    @GetMapping
    private Flux<Video> getAllVideos(@RequestParam(name = "name", defaultValue = "none") String name) {
        if (name != "none") {
            return this.videoService.getVideosByName(name);
        } else {
            return this.videoService.getAllVideos();
        }
    }

    @GetMapping("/{id}")
    private Mono<Video> getVideoById(@PathVariable Long id) {
        return this.videoService.getById(id);
    }

    @PostMapping
    private Mono<Video> createOrUpdateVideo(@RequestBody Video video) {
        return this.videoService.createOrUpdateVideo(video);
    }

    @DeleteMapping("/{id}")
    private Mono<Void> deleteVideoById(@PathVariable Long id) {
        return this.videoService.deleteVideo(id);
    }

}