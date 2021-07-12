package cl.uv.ici.arq.spotify.dto;

import java.util.List;

import lombok.Data;
@Data
public class PlaylistRequestDTO {

	public PlaylistRequestDTO(String authorId, List<String> tracks) {
		this.tracks=tracks;
		this.authorId=authorId;
	}
	public PlaylistRequestDTO() {
		
	}
	private String id;
	private List<String> tracks;
	private String authorId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTracks() {
		return tracks;
	}
	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	
	
}