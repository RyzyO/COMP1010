import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {

    int currentTrackIndex = 1;
    @Test
    public void testCurrentTrackIndex() {
        assertFalse("Invalid Track Index", currentTrackIndex < 0);
    }
}
