package src;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Playlist {
    private String name;
    private ArrayList<Track> tracks;

    // Constructor
    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("Track added: " + track.getTrackInfo());
    }

    public void renamePlaylist(String newName) {
        this.name = newName;
        System.out.println("Playlist renamed to: " + this.name);
    }

    public void displayTracks() {
        System.out.println("Playlist: " + this.name);
        for (Track track : tracks) {
            System.out.println("- " + track.getTrackInfo());
        }
    }

    // Simulate adding tracks by pressing 'a' and renaming by pressing Shift+R
    public void run() {
        // Simulating user actions: Add track and rename
        System.out.println("Press 'a' to add a track or 'Shift+r' to rename the playlist.");
        String input = "a";  // Simulating the 'a' key being pressed
        if (input.equals("a")) {
            addTrack(new Track("New Track", "Unknown Artist", 200, 1, "Genre"));
        }

        input = "Shift+r";  // Simulating 'Shift+R' being pressed
        if (input.equals("Shift+r")) {
            String newName = "Renamed Playlist";  // Simulating renaming action
            renamePlaylist(newName);
        }

        displayTracks();
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist("My Playlist");
        playlist.run();

    // Add a track to the playlist
    public static void addTrack(Track track) {
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
}
