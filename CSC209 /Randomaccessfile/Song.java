public class Song {
    int id; // >> 4 bytes
    String title;// >> 20 bytes
    String genre;// >> 10 bytes
    double duration;// >> 8 bytes
    String artist;// >> 20 bytes
    // A single record of song is 4=20=10=6=20 = 62 bytes

    public Song(int id, String title, String genre, double duration, String artist) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.artist = artist;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
