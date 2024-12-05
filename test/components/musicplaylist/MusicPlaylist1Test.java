package components.musicplaylist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code MusicPlaylist}'s secondary methods.
 *
 * @author Nijaa Nishanth
 */
public class MusicPlaylist1Test {

    /**
     * toString test cases.
     */

    @Test
    public void test_toString() {
        // create playlist
        MusicPlaylist p = new MusicPlaylist1();
        p.addSong("Espresso", "Sabrina Carpenter");
        p.addSong("Vampire", "Olivia Rodrigo");

        // create strings
        String pTest = p.toString();
        String pRef = "Espresso - Sabrina Carpenter Vampire - Olivia Rodrigo";

        // check if equal
        assertEquals(pRef, pTest);

    }

    @Test
    public void test_toString2() {
        // create playlist
        MusicPlaylist p = new MusicPlaylist1();
        p.addSong("Espresso", "Sabrina Carpenter");

        // create strings
        String pTest = p.toString();
        String pRef = "Espresso - Sabrina Carpenter";

        // check if equal
        assertEquals(pRef, pTest);

    }

    // empty String
    @Test
    public void test_toString3() {
        // create playlist
        MusicPlaylist p = new MusicPlaylist1();

        // create strings
        String pTest = p.toString();
        String pRef = "";

        // check if equal
        assertEquals(pRef, pTest);

    }

    /**
     * hashCode test cases.
     */

    /**
     * equals test cases.
     */

    /**
     * shuffle test cases.
     */
    @Test
    public void test_shuffle() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Vampire", "Olivia Rodrigo");
        pRef.addSong("Soft Spot", "Keshi");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Soft Spot", "Keshi");

        // use shuffle
        pTest.shuffle();

        // check if not equal but length is same
        assertEquals(pRef.length(), pTest.length());
        assertNotEquals(pRef, pTest);
    }

    @Test
    public void test_shuffle2() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Soft Spot", "Keshi");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Soft Spot", "Keshi");

        // use shuffle
        pTest.shuffle();

        // check if not equal but length is same
        assertEquals(pRef.length(), pTest.length());
        assertNotEquals(pRef, pTest);
    }

    /**
     * addToQueue test cases.
     */
    @Test
    public void test_addToQueue() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Soft Spot", "Keshi");
        pTest.addSong("Espresso", "Sabrina Carpenter");

        // use addToQueue
        pTest.addToQueue("Soft Spot", "Keshi");
        assertEquals(pRef, pTest);

    }

    @Test
    public void test_addToQueue2() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Soft Spot", "Keshi");
        pRef.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");

        // use addToQueue
        pTest.addToQueue("Soft Spot", "Keshi");

        // check if equal
        assertEquals(pRef, pTest);

    }

    /**
     * playFromSong test cases.
     */
    @Test
    public void test_playFromSong() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Soft Spot", "Keshi");
        pTest.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Soft Spot", "Keshi");

        // use playFromSong
        pTest.playFromSong("Espresso");

        // check if equal
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_playFromSong2() {
        // create playlists
        MusicPlaylist pTest = new MusicPlaylist1();
        MusicPlaylist pRef = new MusicPlaylist1();

        pRef.addSong("Vampire", "Olivia Rodrigo");
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Soft Spot", "Keshi");

        pTest.addSong("Dream", "Keshi");
        pTest.addSong("Senses", "Mico");
        pTest.addSong("Nonsense", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Soft Spot", "Keshi");

        MusicPlaylist pRetRef = new MusicPlaylist1();
        MusicPlaylist pRetTest = new MusicPlaylist1();
        pRetRef.addSong("Dream", "Keshi");
        pRetRef.addSong("Senses", "Mico");
        pRetRef.addSong("Nonsense", "Sabrina Carpenter");

        // use playFromSong
        pRetTest = pTest.playFromSong("Vampire");

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(pRetRef, pRetTest);
    }

}
