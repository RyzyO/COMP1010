

public class Track {
    String TrackName;
    String Artist; 
    Double Duration;
    Integer SongID;

    public Track(String TrackName, String Artist, Double Duration, Integer SongID) {
        this.TrackName = TrackName;
        this.Artist = Artist;
        this.Duration = Duration;
        this.SongID = SongID;
    }

    public void trackDetails() {
        System.out.println(this.SongID);
        System.out.println(this.TrackName);
        System.out.println(this.Artist);
        System.out.println(this.Duration);
    }

}
