package src;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

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
    }
}
