<<<<<<< HEAD
package src;

=======
>>>>>>> 4fab4c3cc92d2b12233b3d98ec85edd1ace0c6b4
import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Track> tracks;

<<<<<<< HEAD
=======
    // Constructor
>>>>>>> 4fab4c3cc92d2b12233b3d98ec85edd1ace0c6b4
    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

<<<<<<< HEAD
    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("Track added: " + track.getTitle());
    }

    public void renamePlaylist(String newName) {
        this.name = newName;
        System.out.println("Playlist renamed to: " + this.name);
    }

    public void displayTracks() {
        System.out.println("Playlist: " + this.name);
        for (Track track : tracks) {
            System.out.println("- " + track.getTitle());
        }
    }

    // Simulate adding tracks by pressing 'a' and renaming by pressing Shift+R
    public void run() {
        // Simulating user actions: Add track and rename
        System.out.println("Press 'a' to add a track or 'Shift+R' to rename the playlist.");
        String input = "a";  // Simulating the 'a' key being pressed
        if (input.equals("a")) {
            addTrack(new Track("New Track"));
        }

        input = "Shift+R";  // Simulating 'Shift+R' being pressed
        if (input.equals("Shift+R")) {
            String newName = "Renamed Playlist";  // Simulating renaming action
            renamePlaylist(newName);
        }

        displayTracks();
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist("My Playlist");
        playlist.run();
=======
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
>>>>>>> 4fab4c3cc92d2b12233b3d98ec85edd1ace0c6b4
    }
}
