public class Track {
    String TrackName;
    String Artist; 
    Double Duration;

    public Track(String TrackName, String Artist, Double Duration) {
        this.TrackName = TrackName;
        this.Artist = Artist;
        this.Duration = Duration;
    }

    public String TrackDetails() {
        System.out.println(TrackName);
        System.out.println(Artist);
        System.out.println(Duration);
    }

}
