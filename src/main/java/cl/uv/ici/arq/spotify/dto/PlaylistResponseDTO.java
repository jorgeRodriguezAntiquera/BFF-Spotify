package cl.uv.ici.arq.spotify.dto;

import java.util.List;

import lombok.Data;
@Data
public class PlaylistResponseDTO {
	
	public PlaylistResponseDTO(AuthorDTO author, List<TrackDTO> trackList) {
        this.author=author;
        this.trackList=trackList;
    }

    public PlaylistResponseDTO() {}

    private AuthorDTO author;
    private List<TrackDTO> trackList;
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<TrackDTO> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<TrackDTO> trackList) {
		this.trackList = trackList;
	}

    
}
