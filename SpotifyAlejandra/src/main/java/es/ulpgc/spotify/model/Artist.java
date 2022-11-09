package es.ulpgc.spotify.model;

public class Artist {
    public String id;
    public String name;
    public int popularity;
    public String genres;
    public int followers;

    public Artist(String id, String name, int popularity, String genres, int followers){
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.genres = genres;
        this.followers = followers;
    }

}
