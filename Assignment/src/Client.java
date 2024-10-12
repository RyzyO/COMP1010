public class Client {
    public static void main(String[] args) {
        System.out.println("COMP1010 Major Assignment");
        // Create some tracks
        Track Track1 = new Track("Never Gonna Give You Up", "Risk Astley", 211, 1, "Pop");
        Track Track2 = new Track("Good Morning", "Kanye West", 195, 2, "Rap");
        Track Track3 = new Track("Learn To Fly", "Foo Fighters", 2235, 3, "Rock");
        


        System.out.println(Track1.getTrackInfo());
        System.out.println(Track2.getTrackInfo());
        System.out.println(Track3.getTrackInfo());
        //Track currentTrack = new Track();
        
        //currentTrack.trackDetails();
        

    }
}
