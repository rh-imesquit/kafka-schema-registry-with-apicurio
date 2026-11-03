package com.redhat.musicplayer.service;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import com.redhat.musicplayer.model.Music;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MusicService {
    private static final Logger LOG = Logger.getLogger(MusicService.class);

    @Incoming("music-in")
    @Blocking
    public CompletionStage<Void> consume(Message<Music> message) {
        
        try {
            LOG.infof("Mensagem recebida do tópico [music] — %s", message.getPayload());
            return message.ack();
        } catch (Exception e) {
            LOG.errorf(e, "Erro ao processar mensagem do tópico [music] — %s", e.getMessage());
            return message.nack(e);
        }        
    }
}