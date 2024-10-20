public class Client {
    public static void main(String[] args) {
        System.out.println("COMP1010 Major Assignment");
        //Initialising an array of tracks
        Track[] tracks = new Track[10]; //Adjustable for when we add more tracks
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
        
        //Start at Track 1
        int currentTrackIndex = 0;

        //Simulated input: A seuquence of commands ('n' for next, 'p' for previous, 'q' for quitting)
        char[] simulatedUserChoices = {'n','n', 'n','p','p','q'};
        int inputIndex = 0;

        //Main Navigation Loop
        while (inputIndex < simulatedUserChoices.length){
            char userChoice = simulatedUserChoices[inputIndex];

            //Ask user for input; next, previous, quit
            System.out.println("Enter 'n' for next track, 'p' for previous track, or 'q' to quit");

            //Navigation based on input sequence
            if (userChoice == 'n'){
                if (currentTrackIndex < tracks.length - 1){
                    currentTrackIndex++;
                    //Display Current Track Information
                    System.out.println("Now Playing: ");
                    System.out.println(tracks[currentTrackIndex].getTrackInfo());
                }
                else {
                    System.out.println("You are at the last track.");
                }
            }
            else if(userChoice == 'p'){
                if (currentTrackIndex > 0){
                    currentTrackIndex--;
                    //Display Current Track Information
                    System.out.println("Now Playing: ");
                    System.out.println(tracks[currentTrackIndex].getTrackInfo());
                }
                else {
                    System.out.println("You are at the first track.");
                }
            }
            else if (userChoice == 'q'){
                break;
                
            }
            inputIndex++;
            System.out.println("Exiting player. Goodbye!");
        }
        
    }
}
