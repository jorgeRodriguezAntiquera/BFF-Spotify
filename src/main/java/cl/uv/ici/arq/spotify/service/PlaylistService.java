package cl.uv.ici.arq.spotify.service;



import java.util.List;

import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistResponseDTO;
import cl.uv.ici.arq.spotify.dto.TrackDTO;
public interface PlaylistService {

	 	public PlaylistRequestDTO updateAuthorTracks(PlaylistRequestDTO request);

	    public List<PlaylistResponseDTO> getPlaylist();

	    public PlaylistResponseDTO getAuthorTracks(String authorId);
	    
	   
}
