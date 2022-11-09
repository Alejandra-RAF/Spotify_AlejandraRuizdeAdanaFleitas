package es.ulpgc.spotify.model;

public class Song {
    public String title;
    public String author;
    public boolean explicit;
    public int duration;

    public Song(String title, String author, int duration, boolean explicit) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.explicit = explicit;
    }
}
