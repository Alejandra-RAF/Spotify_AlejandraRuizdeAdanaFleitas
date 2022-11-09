package es.ulpgc.spotify;

import es.ulpgc.spotify.database.MusicDatabase;
import es.ulpgc.spotify.database.SqliteMusicDatabase;
import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Song;
import es.ulpgc.spotify.webservice.MusicSource;
import es.ulpgc.spotify.webservice.Spotify;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> ArtistIds = Arrays.asList(
            "4NgfOZCL9Ml67xzM0xzIvC",
            "5Fv0DQ1ZBuc2DlidtOUCZr",
            "2ECP3nWC88LaFz4oQzTo3Z",
            "1tZ99AnqyjgrmPwLfGU5eo",
            "1lYT0A0LV5DUfxr6doRP3d"
    );

    public static void main(String[] args) throws Exception {
        MusicSource source = new Spotify();
        MusicDatabase musicDatabase = new SqliteMusicDatabase();
        for (String artistId: ArtistIds) {
            updatedArtist(source, musicDatabase, artistId);
            updateAlbums(source, musicDatabase, artistId);
            updateSongs(source, musicDatabase, artistId);
        }
    }

    private static void updateSongs(MusicSource source, MusicDatabase musicDatabase, String artistId) throws Exception {
        List<Song> songs = source.songsOf(artistId);
        for (Song song : songs) musicDatabase.add(song);
    }

    private static void updateAlbums(MusicSource source, MusicDatabase musicDatabase, String artistId) throws Exception {
        List<Album> albums = source.albumsOf(artistId);
        for (Album album : albums) musicDatabase.add(album);
    }

    private static void updatedArtist(MusicSource source, MusicDatabase musicDatabase, String artistId) throws Exception {
        List<Artist> artists = source.artistsOf(artistId);
        for (Artist artist : artists) musicDatabase.add(artist);
    }


}