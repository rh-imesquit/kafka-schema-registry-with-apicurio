package com.redhat.musicplayer.resource;

import com.redhat.musicplayer.model.Music;
import com.redhat.musicplayer.service.MusicService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/music")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MusicResource {

    @Inject
    MusicService service;

    @POST
    public Response sendMusic(Music music) {
        service.send(music);
        return Response.accepted(music).build();
    }
    
}
