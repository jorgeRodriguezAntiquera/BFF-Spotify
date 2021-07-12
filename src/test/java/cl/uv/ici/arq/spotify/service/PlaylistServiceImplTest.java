package cl.uv.ici.arq.spotify.service;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.uv.ici.arq.spotify.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistResponseDTO;
import cl.uv.ici.arq.spotify.dto.TrackDTO;
import cl.uv.ici.arq.spotify.service.client.AuthorClient;
import cl.uv.ici.arq.spotify.service.client.TrackClient;
import cl.uv.ici.arq.spotify.service.impl.PlaylistServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PlaylistServiceImplTest.class)
public class PlaylistServiceImplTest {

	@Mock
	private AuthorClient authorClientMock;

	@Mock
	private TrackClient trackClientMock;

	@InjectMocks
	private PlaylistServiceImpl playlistService;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	void updateAuthorTrackTest() {
		
		PlaylistRequestDTO expected = new PlaylistRequestDTO();
		List<String> list = new ArrayList<String>();
		list.add("8106684c-8652-428e-a80b-f2b8b1476379");
		list.add("b323974e-b413-4776-bcba-52bd3957482c");
		expected.setAuthorId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		expected.setTracks(list);		
		
		
		when(authorClientMock.savePlaylist(expected)).thenReturn(savePlaylist());
		
		PlaylistRequestDTO actual = playlistService.updateAuthorTracks(expected);

		Assertions.assertEquals(expected, actual);

		
	}
	
	
	@Test
	void getKnlowledgeTest() {
		String authorId = "16266e63-2978-4a6e-8ff6-451b20fb1a35";

		AuthorDTO author = new AuthorDTO();
		author.setId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		author.setName("Carlos");
		

		List<TrackDTO> tracks = new ArrayList<TrackDTO>();
		TrackDTO java = new TrackDTO();
		java.setId("8106684c-8652-428e-a80b-f2b8b1476379");
		java.setDuration(1234);
		java.setTitle("AWS");
		TrackDTO aws = new TrackDTO();
		aws.setId("b323974e-b413-4776-bcba-52bd3957482c");
		
		tracks.add(java);
		tracks.add(aws);

		List<PlaylistResponseDTO> expected = new ArrayList<PlaylistResponseDTO>();
		expected.add(new PlaylistResponseDTO(author,tracks));
		
		
		
		when(authorClientMock.getPlaylist()).thenReturn(getPlaylist());
		when(authorClientMock.findById(authorId)).thenReturn(getAuthor());
		when(trackClientMock.findById("8106684c-8652-428e-a80b-f2b8b1476379")).thenReturn(getTrackByIdJAVA());
		when(trackClientMock.findById("b323974e-b413-4776-bcba-52bd3957482c")).thenReturn(getTrackByIdAWS());

		List<PlaylistResponseDTO> actual = playlistService.getPlaylist();
		System.out.println(expected.toString());
    	System.out.println(actual.toString());
		Assertions.assertEquals(expected, actual);

		
		
	}
	
	
	@Test
	void getAuthorTracksTest() {
		String authorId = "16266e63-2978-4a6e-8ff6-451b20fb1a35";

		AuthorDTO author = new AuthorDTO();
		author.setId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		author.setName("Carlos");
		

		List<TrackDTO> tracks = new ArrayList<TrackDTO>();
		TrackDTO java = new TrackDTO();
		java.setId("8106684c-8652-428e-a80b-f2b8b1476379");
		java.setDuration(1234);
		java.setTitle("AWS");
		TrackDTO aws = new TrackDTO();
		aws.setId("b323974e-b413-4776-bcba-52bd3957482c");
		tracks.add(java);
		tracks.add(aws);

		PlaylistResponseDTO expected = new PlaylistResponseDTO();
		expected.setAuthor(author);
		expected.setTrackList(tracks);

		when(authorClientMock.findById(authorId)).thenReturn(getAuthor());
		when(authorClientMock.getPlaylistByAuthor(authorId)).thenReturn(getPlaylistByAuthor());
		when(trackClientMock.findById("8106684c-8652-428e-a80b-f2b8b1476379")).thenReturn(getTrackByIdJAVA());
		when(trackClientMock.findById("b323974e-b413-4776-bcba-52bd3957482c")).thenReturn(getTrackByIdAWS());

		PlaylistResponseDTO actual = playlistService.getAuthorTracks(authorId);
		System.out.println(expected);
    	System.out.println(actual);
		Assertions.assertEquals(expected, actual);

	}
	
	
	ResponseEntity<PlaylistRequestDTO> savePlaylist(){
		PlaylistRequestDTO response = new PlaylistRequestDTO();
		List<String> list = new ArrayList<String>();
		list.add("8106684c-8652-428e-a80b-f2b8b1476379");
		list.add("b323974e-b413-4776-bcba-52bd3957482c");
		response.setAuthorId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		response.setTracks(list);		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}

	
	private ResponseEntity<List<PlaylistRequestDTO>> getPlaylist(){
		List<PlaylistRequestDTO> response = new ArrayList<PlaylistRequestDTO>();
		List<String> list = new ArrayList<String>();
		list.add("8106684c-8652-428e-a80b-f2b8b1476379");
		list.add("b323974e-b413-4776-bcba-52bd3957482c");
		response.add(new PlaylistRequestDTO("16266e63-2978-4a6e-8ff6-451b20fb1a35",list));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	private ResponseEntity<AuthorDTO> getAuthor() {
		AuthorDTO response = new AuthorDTO();
		response.setId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		response.setName("Carlos");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private ResponseEntity<PlaylistRequestDTO> getPlaylistByAuthor() {
		PlaylistRequestDTO response = new PlaylistRequestDTO();
		List<String> list = new ArrayList<String>();
		list.add("8106684c-8652-428e-a80b-f2b8b1476379");
		list.add("b323974e-b413-4776-bcba-52bd3957482c");
		response.setAuthorId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		response.setTracks(list);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private ResponseEntity<TrackDTO> getTrackByIdAWS() {
		TrackDTO aws = new TrackDTO();
		aws.setId("b323974e-b413-4776-bcba-52bd3957482c");
		aws.setDuration(1234);
		return new ResponseEntity<>(aws, HttpStatus.OK);
	}

	private ResponseEntity<TrackDTO> getTrackByIdJAVA() {
		TrackDTO java = new TrackDTO();
		java.setId("8106684c-8652-428e-a80b-f2b8b1476379");
		java.setDuration(1234);
		return new ResponseEntity<>(java, HttpStatus.OK);
	}
}
