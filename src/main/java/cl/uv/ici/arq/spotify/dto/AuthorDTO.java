package cl.uv.ici.arq.spotify.dto;



public class AuthorDTO {
	private String id;
	private String name;
	private Integer followers;
	private Integer id_playlist;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFollowers() {
		return followers;
	}
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	
	public Integer getId_playlist() {
		return id_playlist;
	}
	public void setId_playlist(Integer id_playlist) {
		this.id_playlist = id_playlist;
	}
	
	
}


