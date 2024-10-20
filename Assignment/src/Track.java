import java.util.ArrayList;
public class Track {
    String TrackName;
    String Artist; 
    int Duration; // in seconds as per the UML
    Integer SongID;
    String Genre;

    //Static list to keep track of all tracks
    static ArrayList<Track> tracklist = new ArrayList<>();

    // Constructor
    public Track(String TrackName, String Artist, int Duration, Integer SongID, String Genre) {
        this.TrackName = TrackName;
        this.Artist = Artist;
        this.Duration = Duration;
        this.SongID = SongID;
        this.Genre = Genre;
    }

    //Method to play the track
    public void play(){
        System.out.println("Playing " + TrackName + " by " + Artist);
    }

    //Method to pause the track
    public void pause(){
        System.out.println("Pausing " + TrackName);
    }

    //Method to stop the track
    public void stop(){
        System.out.println("Stopping "+ TrackName);
    }

    //Method to get track info
    public String getTrackInfo(){
        return "Track: "+ TrackName + "\nArtist: "+ Artist + "\nDuration: "+ Duration + " seconds\nGenre: " + Genre;
    }


}
