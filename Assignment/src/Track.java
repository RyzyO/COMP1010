

public class Track {
    String trackName;
    String artist; 
    Double duration;
    Integer songId;

    public Track(String trackName, String artist, Double duration, Integer songId) {
        this.trackName = trackName;
        this.artist = artist;
        this.duration = duration;
        this.songId = songId;
    }

    public void trackDetails() {
        System.out.println("Current Track: " + this.trackName);
        System.out.println("By " + this.artist);
        System.out.println("Duration: " + this.duration);
    }

}
