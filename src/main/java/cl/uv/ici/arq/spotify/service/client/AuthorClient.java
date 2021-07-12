package cl.uv.ici.arq.spotify.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.spotify.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;

@FeignClient(name = "authorClient", url = "${rest.endpoints.author.url}")
public interface AuthorClient {

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> findAll();

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable String userId);

    @PutMapping("/authors/playlist")
    public ResponseEntity<PlaylistRequestDTO> savePlaylist(@RequestBody PlaylistRequestDTO request);

    @GetMapping("/authors/playlist")
    public ResponseEntity<List<PlaylistRequestDTO>> getPlaylist();

    @GetMapping("/authors/{authorId}/playlist")
    public ResponseEntity<PlaylistRequestDTO> getPlaylistByAuthor(@PathVariable String authorId);
}
