import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map2;
import components.queue.Queue1L;

/**
 * JUnit test fixture for {@code MusicPlaylist}'s constructor and kernel
 * methods.
 *
 * @author Nijaa Nishanth
 */
public class MusicPlaylistTest {

    /**
     * Constructor test cases.
     */

    // no argument constructor
    @Test
    public void test_constructor() {
        MusicPlaylist p = new MusicPlaylist();
        assertEquals(p.length(), 0);
    }

    // Map argument constructor
    @Test
    public void test_contructor2() {
        // ref constructor using addSong
        MusicPlaylist pRef = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");

        // test constructor with Map
        Map<String, String> s = pTest.currentSong().newInstance();
        s.add("name", "Espresso");
        s.add("artist", "Sabrina Carpenter");
        MusicPlaylist pTest = new MusicPlaylist(s);

        // check if equal
        assertEquals(pRef, pTest);
    }

    // Queue argument constructor
    @Test
    public void test_contructor3() {
        // ref constructor using addSong
        MusicPlaylist pRef = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Vampire", "Olivia Rodrigo");

        // test constructor with Queue
        Map<String, String> s1 = pTest.currentSong().newInstance();
        Map<String, String> s2 = s1.newInstance();
        s1.add("name", "Espresso");
        s1.add("artist", "Sabrina Carpenter");
        s2.add("name", "Vampire");
        s2.add("artist", "Olivia Rodrigo");
        Queue<Map<String, String>> p = new Queue1L<>();
        p.enqueue(s1);
        p.enqueue(s2);
        MusicPlaylist pTest = new MusicPlaylist(p);

        // check if equal
        assertEquals(pRef, pTest);
    }

    /**
     * newInstance test cases.
     */

    @Test
    public void test_newInstance() {
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = pRef.newInstance();
        assertEquals(pRef, pTest);
    }

    /**
     * clear test cases.
     */
    @Test
    public void test_clear() {
        MusicPlaylist pRef = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        MusicPlaylist pTest = new MusicPlaylist();
        pTest.clear();
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_clear2() {
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pTest.clear();
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_clear3() {
        MusicPlaylist pRef = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Vampire", "Olivia Rodrigo");
        pRef.addSong("Soft Spot", "Keshi");
        MusicPlaylist pTest = new MusicPlaylist();
        pTest.clear();
        assertEquals(pRef, pTest);
    }

    /**
     * transferFrom test cases
     */

    @Test
    public void test_transferFrom() {
        // create references for new and old
        MusicPlaylist pNewRef = new MusicPlaylist();
        pNewRef.addSong("Espresso", "Sabrina Carpenter");
        MusicPlaylist pOldRef = new MusicPlaylist();

        // test transfer from
        MusicPlaylist pNewTest = new MusicPlaylist();
        MusicPlaylist pOldTest = new MusicPlaylist();
        pOldTest.addSong("Espresso", "Sabrina Carpenter");
        pNewTest.transferFrom(pOldTest);

        // check if equal
        assertEquals(pNewRef, pNewTest);
        assertEquals(pOldTest, pOldTest);

    }

    @Test
    public void test_transferFrom2() {
        // create references for new and old
        MusicPlaylist pNewRef = new MusicPlaylist();
        pNewRef.addSong("Espresso", "Sabrina Carpenter");
        pNewRef.addSong("Vampire", "Olivia Rodrigo");
        pNewRef.addSong("Soft Spot", "Keshi");
        MusicPlaylist pOldRef = new MusicPlaylist();

        // test transfer from
        MusicPlaylist pNewTest = new MusicPlaylist();
        MusicPlaylist pOldTest = new MusicPlaylist();
        pOldTest.addSong("Espresso", "Sabrina Carpenter");
        pOldTest.addSong("Vampire", "Olivia Rodrigo");
        pOldTest.addSong("Soft Spot", "Keshi");
        pNewTest.transferFrom(pOldTest);

        // check if equal
        assertEquals(pNewRef, pNewTest);
        assertEquals(pOldTest, pOldTest);

    }

    /**
     * addSong test cases.
     */
    @Test
    public void test_addSong() {
        // create playlists with songs
        MusicPlaylist pTest = new MusicPlaylist();
        Map<String, String> s = pTest.currentSong().newInstance();
        s.add("name", "Espresso");
        s.add("artist", "Sabrina Carpenter");
        MusicPlaylist pRef = new MusicPlaylist(s);

        // use add song
        addSong("Espresso", "Sabrina Carpenter");

        // check if equal
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_addSong2() {
        // create playlists with songs
        MusicPlaylist pTest = new MusicPlaylist();
        Map<String, String> s1 = pTest.currentSong().newInstance();
        Map<String, String> s2 = s1.newInstance();
        s1.add("name", "Espresso");
        s1.add("artist", "Sabrina Carpenter");
        s2.add("name", "Vampire");
        s2.add("artist", "Olivia Rodrigo");
        Queue<Map<String, String>> p = new Queue1L<>();
        p.enqueue(s1);
        p.enqueue(s2);
        MusicPlaylist pRef = new MusicPlaylist(p);

        // use add song
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");

        // check if equal
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_addSong3() {
        // create playlists with songs
        MusicPlaylist temp = new MusicPlaylist();
        Map<String, String> s1 = temp.currentSong().newInstance();
        Map<String, String> s2 = s1.newInstance();
        s1.add("name", "Espresso");
        s1.add("artist", "Sabrina Carpenter");
        s2.add("name", "Vampire");
        s2.add("artist", "Olivia Rodrigo");
        Queue<Map<String, String>> p = new Queue1L<>();
        p.enqueue(s1);
        MusicPlaylist pTest = new MusicPlaylist(p);
        p.enqueue(s2);
        MusicPlaylist pRef = new MusicPlaylist(p);

        // use add song
        pTest.addSong("Vampire", "Olivia Rodrigo");

        // check if equal
        assertEquals(pRef, pTest);
    }

    /**
     * removeSong test cases.
     */

    @Test
    public void test_removeSong() {
        // creates playlists with songs
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");

        // use remove song
        pTest.removeSong("Espresso");

        // check if equal
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_removeSong2() {
        // creates playlists with songs
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pTest.addSong("Espresso", "Sabrina Carpenter");

        // use remove song
        pTest.removeSong("Espresso");

        // check if equal
        assertEquals(pRef, pTest);
    }

    @Test
    public void test_removeSong3() {

        // creates playlists with songs
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Soft Spot", "Keshi");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");

        // use remove song
        pTest.removeSong("Soft Spot");
        pTest.removeSong("Vampire");

        // check if equal
        assertEquals(pRef, pTest);
    }

    /**
     * currentSong test cases.
     */

    @Test
    public void test_currentSong() {
        // create playlists
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        Map<String, String> s = new Map2<>();
        s.add("name", "Espresso");
        s.add("artist", "Sabrina Carpenter");

        // use current song
        Map<String, String> sTest = pTest.currentSong();

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(s, sTest);

    }

    @Test
    public void test_currentSong() {
        // create playlists
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pTest.removeSong("Vampire");
        Map<String, String> s = new Map2<>();
        s.add("name", "Espresso");
        s.add("artist", "Sabrina Carpenter");

        // use current song
        Map<String, String> sTest = pTest.currentSong();

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(s, sTest);

    }

    /**
     * length test cases.
     */
    @Test
    public void test_length() {
        // create playlists
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Espresso", "Sabrina Carpenter");

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(1, pTest.length());
    }

    @Test
    public void test_length2() {
        // create playlists
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(0, pTest.length());
    }

    @Test
    public void test_length() {
        // create playlists
        MusicPlaylist pRef = new MusicPlaylist();
        MusicPlaylist pTest = new MusicPlaylist();
        pRef.addSong("Espresso", "Sabrina Carpenter");
        pTest.addSong("Espresso", "Sabrina Carpenter");
        pRef.addSong("Vampire", "Olivia Rodrigo");
        pTest.addSong("Vampire", "Olivia Rodrigo");
        pRef.addSong("Soft Spot", "Keshi");
        pTest.addSong("Soft Spot", "Keshi");

        // check if equal
        assertEquals(pRef, pTest);
        assertEquals(3, pTest.length());
    }
}
