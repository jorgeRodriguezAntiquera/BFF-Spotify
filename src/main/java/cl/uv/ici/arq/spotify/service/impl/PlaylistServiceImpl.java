package cl.uv.ici.arq.spotify.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.spotify.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistResponseDTO;

import cl.uv.ici.arq.spotify.dto.TrackDTO;

import cl.uv.ici.arq.spotify.service.PlaylistService;
import cl.uv.ici.arq.spotify.service.client.AuthorClient;
import cl.uv.ici.arq.spotify.service.client.TrackClient;

@Service("PlaylistService")
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private  AuthorClient author;

	@Autowired
	private TrackClient track;

	@Override
	public PlaylistRequestDTO updateAuthorTracks(PlaylistRequestDTO request) {
		return author.savePlaylist(request).getBody();
	}

	@Override
	public List<PlaylistResponseDTO> getPlaylist() {

		List<PlaylistResponseDTO> response = new ArrayList<PlaylistResponseDTO>();
		List<PlaylistRequestDTO> listAuthors = author.getPlaylist().getBody();

		AuthorDTO authorDTO = new AuthorDTO();
		List<TrackDTO> listTracks = new ArrayList<TrackDTO>();

		for (PlaylistRequestDTO playlistRequestDTO : listAuthors) {

			authorDTO = author.findById(playlistRequestDTO.getAuthorId()).getBody();
			listTracks = new ArrayList<TrackDTO>();

			for (String trackId : playlistRequestDTO.getTracks()) {
				listTracks.add(track.findById(trackId).getBody());
			}

			response.add(new PlaylistResponseDTO(authorDTO, listTracks));
		}

		return response;

	}
	
	@Override
	public PlaylistResponseDTO getAuthorTracks(String authorId) {

		AuthorDTO authorDTO = author.findById(authorId).getBody();
		List<TrackDTO> listTracks = new ArrayList<TrackDTO>();
		List<String> tracks = author.getPlaylistByAuthor(authorId).getBody().getTracks();

		for (String trackId : tracks) {
			listTracks.add(track.findById(trackId).getBody());
		}

		return new PlaylistResponseDTO(authorDTO, listTracks);
	}


}