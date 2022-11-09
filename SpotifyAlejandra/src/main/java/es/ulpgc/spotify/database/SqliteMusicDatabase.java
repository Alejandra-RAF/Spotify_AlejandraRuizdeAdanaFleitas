package es.ulpgc.spotify.database;

import es.ulpgc.spotify.model.Album;
import es.ulpgc.spotify.model.Artist;
import es.ulpgc.spotify.model.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CREAMOS LAS TABLAS Y ESTABLECEMOS LA CONECCIÓN CON EL DMLTranslate
public class SqliteMusicDatabase implements MusicDatabase{

    private final Connection connection;

    public SqliteMusicDatabase() throws SQLException {
        String url ="jdbc:sqlite:database.db";
        connection = DriverManager.getConnection(url);
        initDatabase();
    }

    private static final String TableArtists =
            "CREATE TABLE IF NOT EXISTS artists (" +
                    "id TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "popularity NUMBER, " +
                    "genres TEXT," +
                    "followers);";

    private static final String TableAlbums =
            "CREATE TABLE IF NOT EXISTS albums (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "ReleaseDate TEXT, " +
                    "totalTracks NUMBER);";

    private static final String TableSongs =
            "CREATE TABLE IF NOT EXISTS songs (" +
                    "title TEXT, " +
                    "author TEXT, " +
                    "duration NUMBER, " +
                    "explicit TEXT);";

    private void initDatabase() throws SQLException{
        connection.createStatement().execute(TableArtists);
        connection.createStatement().execute(TableAlbums);
        connection.createStatement().execute(TableSongs);
    }

    @Override
    public void add(Artist artist) {
        try{
            connection.createStatement().execute(DMLTranslate.insertStatementOf(artist));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Album album)  {
        try{
            connection.createStatement().execute(DMLTranslate.insertStatementOf(album));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Song song)  {
        try{
            connection.createStatement().execute(DMLTranslate.insertStatementOf(song));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
