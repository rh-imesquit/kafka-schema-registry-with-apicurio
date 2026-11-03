package com.redhat.musicplayer.service;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import com.redhat.musicplayer.model.Music;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MusicService {
    private static final Logger LOG = Logger.getLogger(MusicService.class);
    @Inject
    @Channel("music-out")
    Emitter<Music> musicEmitter;

    public void send(Music music) {
        LOG.infof("Enviando música para o Kafka — %s", music);
        musicEmitter.send(music);
    }
}
