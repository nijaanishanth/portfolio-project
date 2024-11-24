
import components.map.Map;
import components.queue.Queue;
import components.standard.Standard;

/**
 * Kernel Implementation for {@code MusicPlaylist} implemented on {@code Queue}
 * with {@code Map}.
 *
 * @author Nijaa Nishanth
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {

    /* Queue to add songs */
    Queue<Map<String, String>> playlist;

    /* song */
    Map<String, String> song;

    /**
     * Adds a song to the end of the playlist.
     *
     * @param a
     *            the name of the artist of the song to be added
     *
     * @param n
     *            the name of the song to be added
     *
     * @updates this
     *
     * @ensures this = #this * n
     *
     */
    void addSong(String n, String a)
    {
        this.song = new Map2<String, String>();
        this.song.add("name", n);
        this.song.add("artist", a);
        this.playlist.enqueue(this.song);
    }

    /**
     * Removes a song from the playlist.
     *
     * @param n
     *            the name of the song to be removed
     *
     * @updates this
     *
     * @return the song name and artist of the removed song
     *
     * @requires this/= <>
     *
     * @ensures this = <removed> * #this
     *
     */
    Map<String, String> removeSong(String n)
    {
        Queue<Map<String, String>> temp = new Queue1L<>();
        temp.transferFrom(this.playlist);
        Map<String, String> song = new Map2<>();
        Map<String, String> removed = new Map2<>();
        while (temp.length() > 0) {
            song = temp.dequeue();
            if (!song.value("name").equals(n)) {
                this.playlist.enqueue(song);
            } else {
                removed.transferFrom(song);
            }
        }
        return removed;
    }

    /**
     * Returns the length of the playlist.
     *
     * @return number of songs in the playlist
     *
     * @ensures length = |this|
     */
    int length()
    {
        return this.playlist.length();
    }

}