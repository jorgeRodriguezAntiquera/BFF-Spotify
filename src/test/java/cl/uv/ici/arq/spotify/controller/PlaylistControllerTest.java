package cl.uv.ici.arq.spotify.controller;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.uv.ici.arq.spotify.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistRequestDTO;
import cl.uv.ici.arq.spotify.dto.PlaylistResponseDTO;
import cl.uv.ici.arq.spotify.dto.TrackDTO;
import cl.uv.ici.arq.spotify.service.PlaylistService;




@SpringBootTest(classes = PlaylistControllerTest.class)
public class PlaylistControllerTest {

	@InjectMocks
    private PlaylistController playlistController;
	
	@Mock
    private PlaylistService playlistService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void saveTest() {    	

    	PlaylistRequestDTO request = new PlaylistRequestDTO();
		List<String> list = new ArrayList<String>();
		list.add("8106684c-8652-428e-a80b-f2b8b1476379");
		list.add("b323974e-b413-4776-bcba-52bd3957482c");
		request.setId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		request.setTracks(list);		
    	    	
    	ResponseEntity<PlaylistRequestDTO> expected = new ResponseEntity<PlaylistRequestDTO>(request, HttpStatus.CREATED);  
    	
    	when(playlistService.updateAuthorTracks(request)).thenReturn(request);
    	ResponseEntity<?> actual = playlistController.save(request);
    	System.out.println(expected);
    	System.out.println(actual);
    	Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void getbyUserIdTest() {
    	
    	String authorId="16266e63-2978-4a6e-8ff6-451b20fb1a35";
    	AuthorDTO author = new AuthorDTO();
		author.setId(authorId);
		author.setName("Carlos");
		

		List<TrackDTO> tracks = new ArrayList<TrackDTO>();
		TrackDTO java = new TrackDTO();
		java.setId("8106684c-8652-428e-a80b-f2b8b1476379");
		java.setDuration(1234);
		TrackDTO aws = new TrackDTO();
		aws.setId("b323974e-b413-4776-bcba-52bd3957482c");
		aws.setDuration(1234);
		tracks.add(java);
		tracks.add(aws);
		
		PlaylistResponseDTO response = new PlaylistResponseDTO(author,tracks);
		
		ResponseEntity<PlaylistResponseDTO> expected = new ResponseEntity<PlaylistResponseDTO>(response, HttpStatus.OK); 
    	

    	when(playlistService.getAuthorTracks(authorId)).thenReturn(response);    	
    	ResponseEntity<?> actual = playlistController.getAll(authorId);
    	
    	System.out.println(expected);
    	System.out.println(actual);
    	Assertions.assertEquals(expected, actual);
    	
    }
    
    
    @Test
    public void getAllTest() {
    	
    	
    	AuthorDTO author = new AuthorDTO();
		author.setId("16266e63-2978-4a6e-8ff6-451b20fb1a35");
		author.setName("Carlos");


		List<TrackDTO> tracks = new ArrayList<TrackDTO>();
		TrackDTO java = new TrackDTO();
		java.setId("8106684c-8652-428e-a80b-f2b8b1476379");
		java.setDuration(1234);
		TrackDTO aws = new TrackDTO();
		aws.setId("b323974e-b413-4776-bcba-52bd3957482c");
		aws.setDuration(1234);
		tracks.add(java);
		tracks.add(aws);
		
		List<PlaylistResponseDTO> response = new ArrayList<PlaylistResponseDTO>();
		response.add(new PlaylistResponseDTO(author,tracks));
		
		ResponseEntity<List<PlaylistResponseDTO>> expected = new ResponseEntity<List<PlaylistResponseDTO>>(response, HttpStatus.OK); 
    	

    	when(playlistService.getPlaylist()).thenReturn(response);    	
    	ResponseEntity<?> actual = playlistController.getAll();
    	
    	Assertions.assertEquals(expected, actual);
    	
    }
    
}

