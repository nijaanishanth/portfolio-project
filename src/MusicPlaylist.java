import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/*
 * Proof of Concept for {@code MusicPlaylist} implemented on {@code Queue} with {@code Map.Pair}
 *
 * @param<Map.Pair<String, String>>
 * @author Nijaa Nishanth
 */
public class MusicPlaylist {

    /*
     * Adds a song to the end of the playlist.
     *
     * @param a the name of the artist of the song to be added
     *
     * @param n the name of the song to be added
     *
     * @updates this
     *
     */
    private static void addSong(String n, String a) {
        Map.Pair<String, String> song = new Map.Pair<>();
        Map<String, String> temp = new Map1L<>();
        temp.add(n, a);
        this.enqueue(songs.remove(n));
    }

    /*
     * Removes a song from the playlist.
     *
     * @param n the name of the song to be removed
     *
     * @updates this
     *
     * @returns the song name and artist of the removed song
     *
     */
    private static Map.Pair<String, String> removeSong(String n){
        temp.transferFrom(this);
        Queue<String> temp = new Queue1L<>();
        Map.Pair<String, String> song = new Map.Pair<String, String>;
        Map.Pair<String, String> removed = new Map.Pair<String, String>;
        while(temp.length() > 0)
        {
            song = temp.dequeue();
            if(!song.key().equals(n))
            {
                this.enqueue(song);
            }
            else
            {
                removed = song;
            }
        }
        return removed;

    }

    /*
     * Returns the length of the playlist.
     *
     * @returns number of songs in the playlist
     *
     */
    private static int length() {
        return this.length();
    }

}

public static void main(String[] args) {
    MusicPlaylist study = new MusicPlaylist();
    SimpleWriter out = new SimpleWriter1L();

    // add songs
    study.addSong("Soft Spot", "keshi");
    out.println(study);
    study.addSong("Nonsense", "Sabrina Carpenter");
    out.println(study);

    // check the length
    out.println("length: " + study.length());

    // remove a song
    Map.Pair<String, String> removed = study.removeSong("Nonsense");
    out.println(study);
    out.println("removed: " + removed);

}