package cl.uv.ici.arq.spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistResponseDTO;
import cl.uv.ici.arq.spotify.service.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
    private PlaylistService service;


    @PutMapping
    public ResponseEntity<PlaylistRequestDTO> save(@RequestBody PlaylistRequestDTO request) {
        return new ResponseEntity<>(service.updateAuthorTracks(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponseDTO>> getAll() {
        return new ResponseEntity<>(service.getPlaylist(), HttpStatus.OK);
    }

     @GetMapping("/{authorId}")
    public ResponseEntity<PlaylistResponseDTO> getAll(@PathVariable String authorId) {
        return new ResponseEntity<>(service.getAuthorTracks(authorId), HttpStatus.OK);
    }
}
