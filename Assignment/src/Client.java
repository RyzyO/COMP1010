import java.util.Random;
public class Client {
    public static void main(String[] args) {
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
        Random random = new Random(); //Random number generator for shuffle mode

        //Display Current Track Information
        System.out.println("Now Playing: ");
        System.out.println(tracks[currentTrackIndex].getTrackInfo());
        //Ask user for input; next, previous, quit
        System.out.println("Enter n for next track, p for previous track, q to quit or s to enable shuffle");

        //Main Navigation Loop
        while (true){
            // Using System.console() for input
            String userChoice = System.console().readLine("Enter your choice: ").trim();
            
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
            else {
                System.out.println("Invalid input. Please enter n, p, q or s");
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
}
