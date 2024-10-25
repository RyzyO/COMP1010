import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Client {
    private static Node head = null; // Head node for the linked list (Playlist)
    private static String playlistName = "My Playlist"; //Default name for the playlist
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        System.out.println("COMP1010 Major Assignment");
        //Initialising an array of tracks
        Track[] tracks = new Track[14]; //Adjustable for when we add more tracks
        // Create some tracks
        tracks[0] = new Track("Never Gonna Give You Up", "Risk Astley", 211, 1, "Pop");
        tracks[1] = new Track("Good Morning", "Kanye West", 195, 2, "Rap");
        tracks[2] = new Track("Learn To Fly", "Foo Fighters", 235, 3, "Rock");
        tracks[3] = new Track("Bye Bye Bye", "*NSYNC", 200, 4,"Dance Pop");
        tracks[4] = new Track("Bad Romance", "Lady Gaga", 295, 5, "Pop");
        tracks[5] = new Track("Smooth Criminal", "Michael Jackson", 258, 6, "Dance Pop");
        tracks[6] = new Track("Mr. Blue Sky", "Electric Light Orchestra", 303, 7, "Funk");
        tracks[7] = new Track("Mr. Brightside", "The Killers", 223, 8, "Rock");
        tracks[8] = new Track("In The End", "Linkin Park", 217, 9, "'Rock");
        tracks[9] = new Track("American Idiot", "Green Day", 176, 10, "Rock");
        tracks[10] = new Track("Holiday", "Green Day", 233, 11, "Rock");
        tracks[11] = new Track("Joker And The Thief", "Wolfmother", 280, 12, "Rock");
        tracks[12] = new Track("This Is How You Remind Me", "Nickelback", 224, 13, "Rock");
        tracks[13] = new Track("Starman - 2012 Remaster", "David Bowie", 254, 14, "Pop");
        
        //Start at Track 1
        int currentTrackIndex = 0;
        boolean isShuffleEnabled = false; // Shuffle mode flag
        boolean playlistCreated = false; //Flag to check if playlist is created
        Random random = new Random(); //Random number generator for shuffle mode

        //Display Current Track Information
        System.out.println("Now Playing: ");
        System.out.println(tracks[currentTrackIndex].getTrackInfo());
        //Ask user for input; next, previous, quit, shuffle or save to playlist
        System.out.println("Enter n for next track, p for previous track, q to quit, s to enable shuffle, or save to create Playlist");
        

        //Main Navigation Loop
        while (true){
            System.out.println("Current playlist name: " + playlistName);
            String userChoice = System.console().readLine("Enter your choice: ").trim();
            System.out.println(" ");
            
            
            boolean trackChanged = false;

            //Navigation based on input sequence
            if (userChoice.equals ("n")){
                if (isShuffleEnabled){
                    //Shuffle mode: pick a random track excluding the one thats playing
                    int newTrackIndex;
                    do{
                        newTrackIndex = random.nextInt(tracks.length);
                    }
                    while (newTrackIndex == currentTrackIndex); //Ensuring its a different track
                    currentTrackIndex = newTrackIndex;
                }
                else{ //Normal Mode: Move to next track in sequence
                    if (currentTrackIndex < tracks.length - 1){
                        currentTrackIndex++;
                    }
                    else {
                        System.out.println("You are at the last track.");
                    }
                }
                trackChanged = true; // Track moved to the next   
            }
            else if(userChoice.equals ("p")){
                if (currentTrackIndex > 0){
                    currentTrackIndex--;
                    trackChanged = true; //Track moved to the previous
                }
                else {
                    System.out.println("You are at the first track.");
                }
            }
            else if (userChoice.equals ("q")){
                System.out.println("Exiting player. Goodbye!");
                System.exit(0); //This will close the console
                break; //Not needed but just a fallback just in case
            }
            else if (userChoice.equals("s")){
                //Toggle shuffle mode
                isShuffleEnabled = !isShuffleEnabled;
                String shuffleStatus = isShuffleEnabled ? "enabled" : "disabled";
                System.out.println("Shuffle mode " + shuffleStatus);
            }
            else if (userChoice.equals("save")) {
                // Ask the user for a file name and ensure it ends with .csv
                String fileName = System.console().readLine("Enter a file name to save the playlist (e.g., playlist.csv): ").trim();
                if (!fileName.endsWith(".csv")) {
                    System.out.println("Invalid file name. Please include the .csv extension.");
                } else {
                    // Call the save method without a try-catch block
                    saveTracksToCSV(tracks, fileName); // Use a method that saves to file
                    System.out.println("Playlist saved to " + fileName);
                    playlistCreated = true;
                    //Show them how to manage the playlists
                    System.out.println("Press 'a' to add a track, 'r' to rename the playlist or 'd' to display the playlist");
                    System.out.println(" ");
                }
            }
            else if (userChoice.equals("a")){
                if (playlistCreated){
                    addTrackToPlaylist(tracks[currentTrackIndex]);
                    System.out.println("Track added to the playlist: " + tracks[currentTrackIndex].getTitle());
                    System.out.println("To save the playlist with the new songs, use 'save' and either retype the name of the file or create a new one!");
                    System.out.println(" ");
                }
                else {
                    System.out.println("Playlist is not created yet. Use 'save' to create the playlist first.");
                }
            }
            else if (userChoice.equals("d")){
                if (playlistCreated){
                    System.out.println("Displaying all tracks in playlist:");
                    displayPlaylist();
                }
                else {
                    System.out.println("Playlist is not created yet. Use 'save' to create the playlist first.");
                }
            }
            else if(userChoice.equals("r")){
                if (playlistCreated){
                    System.err.println("Enter a new name for the playlist: ");
                    playlistName = "";
                    int ch;
                    while ((ch = System.in.read())!= '\n' && ch != '\r'){//read until new line
                        playlistName += (char) ch; //Append each character
                    }
                    playlistName = playlistName.trim();
                    System.out.println("Playlist renamed to: " + playlistName);
                }
                else{
                    System.out.println("Playlist is not created yet. Use 'save' to create the playlist first.");
                }
            }
            else {
                System.out.println("Invalid input. Please enter n, p, q, s, or save.");
            }
            //Only display the track if it actually changed.
            if (trackChanged){
                //Display Current Track Information
                System.out.println("");
                System.out.println("Now Playing: ");
                System.out.println(tracks[currentTrackIndex].getTrackInfo());
            }
            
        }
        
    }
    public static void saveTracksToCSV(Track[] tracks, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        // Writing data manually to a file without new imports
        java.io.PrintWriter writer = new java.io.PrintWriter(fileName, "UTF-8");
    
        // Write header
        writer.println("Track Name, Artist, Duration (Seconds), SongID, Genre");
    
        //Write only tracks that are in the playlist
        Node current = head; //Start from the head of the linked list
        while (current != null){
            Track track = current.track;
            writer.println(track.TrackName + "," + track.Artist + "," + track.Duration + "," + track.SongID + "," + track.Genre);
            current = current.next; // Move onto the next node in the list
        }
        writer.close(); // Close the writer
    }

    // Node class for the linked list
    private static class Node{
        Track track;
        Node next;

        Node (Track track){
            this.track = track;
            this.next = null;
        }
    }

    
    // Method to add a track to the linked list (Playlist)
    private static void addTrackToPlaylist(Track track){
        if (head == null){ // Check if the playlist is empty
            head = new Node(track);
        }
        else {
            addTrackRecursive(head, track);
        }
    }

    // Recursive method to add track to the end of the linked list
    private static void addTrackRecursive(Node current, Track track){
        if (current.next == null){
            current.next = new Node(track);
        }
        else {
            addTrackRecursive(current.next, track);
        }
    }

    //Method to see if track is already in linked list (Playlist)
    private static boolean isTrackInPlaylist(Track track){
        return isTrackInPlaylistRecursive(head, track);
    }

    //Recursive method to check for duplicate track in linked list (playlist)
    private static boolean isTrackInPlaylistRecursive(Node node, Track track){
        if (node == null){
            return false;//Reached end of the list, track not found
        }
        if (node.track.getTitle().equals(track.getTitle()) && node.track.getArtist().equals(track.getArtist())){
            return true; //Track found in playlist
        }
        return isTrackInPlaylistRecursive(node.next, track);
    }

    //Method to display all tracks in the linked list (Playlist)
    private static void displayPlaylist(){
        displayPlaylistRecursive(head);
    }

    //Recursive method to display tracks
    private static void displayPlaylistRecursive(Node node){
        if (node != null){
            System.out.println("Track: " + node.track.getTitle() + " by " + node.track.getArtist());
            displayPlaylistRecursive(node.next);
        }
    }

    //Method to read a single character input from the console
    private static char readCharInput() throws IOException{
        try {
            //Read a single character and return it
            int input = System.in.read();
            //Consume the new line if there is any
            System.in.read(new byte[System.in.available()]);
            return (char) input;
        }
        catch (IOException e){
            System.out.println("Error reading input.");
            return ' ';// Return a default value or handle the error as needed 
        }
    }
}

