package cl.uv.ici.arq.spotify.dto;

public class TrackDTO {
	
	private String id;
	private String title;
	//private String idPlaylist;
	private Integer duration;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	

}