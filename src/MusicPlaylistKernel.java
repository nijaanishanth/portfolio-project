import components.map.Map;
import components.standard.Standard;

/**
 * Kernel Implementation for {@code MusicPlaylist} implemented on {@code Queue}
 * with {@code Map}
 *
 * @author Nijaa Nishanth
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {

    /**
     * Adds a song to the end of the playlist.
     *
     * @param a
     *            the name of the artist of the song to be added
     *
     * @param n
     *            the name of the song to be added
     *
     * @updates: this
     *
     * @ensures: this = #this * n
     *
     */
    void addSong(String n, String a);

    /**
     * Removes a song from the playlist.
     *
     * @param n
     *            the name of the song to be removed
     *
     * @updates: this
     *
     * @returns: the song name and artist of the removed song
     *
     * @requires: this/= <>
     *
     * @ensures: this = <removed> * #this
     *
     */
    Map<String, String> removeSong(String n);

    /**
     * Returns the length of the playlist.
     *
     * @returns: number of songs in the playlist
     *
     * @ensures: length = |this|
     */
    int length();

}