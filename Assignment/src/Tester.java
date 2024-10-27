import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    // Sample current track index for testing
    int currentTrackIndex = 1;
    ArrayList<String> playlist;

    @Before
    public void setUp() {
        // Initialize the playlist for testing
        playlist = new ArrayList<>();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song D");
    }

    // Test to check if the currentTrackIndex is valid
    @Test
    public void testCurrentTrackIndexValid() {
        assertFalse("Invalid Track Index", currentTrackIndex < 0);
    }

    // Test to check if currentTrackIndex is negative
    @Test
    public void testCurrentTrackIndexNegative() {
        currentTrackIndex = -1;
        assertTrue("Current Track Index should be invalid", currentTrackIndex < 0);
    }

    // Test for boundary value (index = 0)
    @Test
    public void testCurrentTrackIndexBoundary() {
        currentTrackIndex = 0;
        assertFalse("Track index should be valid", currentTrackIndex < 0);
    }

    // Test to ensure shuffle randomizes playlist
    @Test
    public void testShufflePlaylist() {
        ArrayList<String> originalPlaylist = new ArrayList<>(playlist);
        Collections.shuffle(playlist);
        assertNotEquals("Playlist should be shuffled", originalPlaylist, playlist);
    }

    // Test to check if playlist is not empty
    @Test
    public void testPlaylistNotEmpty() {
        assertFalse("Playlist should not be empty", playlist.isEmpty());
    }

    // Test to check if the playlist has the correct number of tracks
    @Test
    public void testPlaylistSize() {
        assertEquals("Playlist should have 4 tracks", 4, playlist.size());
    }

    // Test to verify track retrieval by index
    @Test
    public void testTrackRetrieval() {
        String track = playlist.get(2);  // Assume track at index 2 is "Song C"
        assertEquals("Track at index 2 should be 'Song C'", "Song C", track);
    }

    // Test for boundary check at the end of the playlist (e.g., shuffle or move to next track)
    @Test
    public void testTrackBoundaryAtEnd() {
        currentTrackIndex = playlist.size() - 1; // Last track
        assertEquals("Current track index should be the last index", 3, currentTrackIndex);
    }

    // Test for retrieving a song after shuffling
    @Test
    public void testRetrieveSongAfterShuffle() {
        Collections.shuffle(playlist);
        String trackAfterShuffle = playlist.get(0); // Random first track after shuffle
        assertNotNull("There should still be a valid track after shuffle", trackAfterShuffle);
    }

}
