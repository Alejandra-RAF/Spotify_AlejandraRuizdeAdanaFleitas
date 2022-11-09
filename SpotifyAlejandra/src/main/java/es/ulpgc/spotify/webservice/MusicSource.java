package es.ulpgc.spotify.webservice;

import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Song;

import java.util.List;

public interface MusicSource {

    List<Artist> artistsOf(String id) throws Exception;
    List<Album> albumsOf(String id) throws Exception;
    List<Song> songsOf(String id) throws Exception;

}