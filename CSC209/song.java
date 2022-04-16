class Song {
    private int id;
    private String title;
    private String genre;
    private double duration;
    private String artist;

    public Song(int id, String title, String genre, double duration, String artist) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.artist = artist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }
}