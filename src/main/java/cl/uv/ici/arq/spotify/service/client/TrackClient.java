package cl.uv.ici.arq.spotify.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.spotify.dto.TrackDTO;

@FeignClient(name = "trackClient", url = "${rest.endpoints.track.url}")
public interface TrackClient {

    @GetMapping("/track/{trackId}")
    public ResponseEntity<TrackDTO> findById(@PathVariable String trackId);
    @PostMapping
	public ResponseEntity<TrackDTO> save(@RequestBody TrackDTO track);
}