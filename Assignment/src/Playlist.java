import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Track> tracks;

    // Constructor
    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    // Add a track to the playlist
    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println(track.getTrackInfo() + " added to playlist " + name);
    }

    // Method to display all tracks in the playlist
    public void displayTracks() {
        if (tracks.isEmpty()) {
            System.out.println("The playlist " + name + " is empty.");
        } else {
            System.out.println("Playlist: " + name);
            for (Track track : tracks) {
                System.out.println(track.getTrackInfo());
            }
        }
    }

    // Method to play a track
    public void playTrack(int trackIndex) {
        if (trackIndex >= 0 && trackIndex < tracks.size()) {
            Track track = tracks.get(trackIndex);
            track.play();
        } else {
            System.out.println("Invalid track selection.");
        }
    }

    // Getter for playlist name
    public String getName() {
        return name;
    }
}
