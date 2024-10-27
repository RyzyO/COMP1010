import java.util.ArrayList;
public class Track {
    String TrackName;
    String Artist; 
    String Album;
    int Duration; // in seconds as per the UML
    Integer SongID;
    String Genre;

    //Static list to keep track of all tracks
    static ArrayList<Track> tracklist = new ArrayList<>();

    // Constructor
    public Track(String TrackName, String Artist, String Album, int Duration, Integer SongID, String Genre) {
        this.TrackName = TrackName;
        this.Artist = Artist;
        this.Album = Album;
        this.Duration = Duration;
        this.SongID = SongID;
        this.Genre = Genre;
    }

    public Track(String string, String string2) {
        //TODO Auto-generated constructor stub
    }

    //Method to play the track
    public void play(){
        System.out.println("Playing " + TrackName + " by " + Artist + Album);
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
        return "Track: "+ TrackName + "\nArtist: "+ Artist + "\nAlbum: " + Album + "\nDuration: "+ Duration + " seconds\nGenre: " + Genre;
    }

    //Method for getting the title
    public String getTitle(){
        return TrackName;
    }
    //Method for getting the artist
    public String getArtist(){
        return Artist;
    }

}
