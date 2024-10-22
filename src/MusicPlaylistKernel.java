import components.map.Map;
import components.queue.Queue;
import components.standard.Standard;

/*
 * Kernel Implementation for {@code MusicPlaylist} implemented on {@code Queue} with {@code Map}
 *
 * @param Queue<Map<String, String>>
 * @author Nijaa Nishanth
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {

    /* Queue to add songs */
    private Queue<Map<String, String>> playlist;

    /* song */
    private Map<String, String> song;

    /*
     * Creator of initial representation.
     *
     * @ensures this.playlist = new playlist
     */
    private void createNewRep();

    /*
     * No-argument constructor
     */
    public MusicPlaylistKernel();

    /*
     * Kernel Methods
     */

    /*
     * Adds a song to the end of the playlist.
     *
     * @param a the name of the artist of the song to be added
     *
     * @param n the name of the song to be added
     *
     * @updates: this
     *
     * @ensures: this = #this * n
     *
     */
    public final void addSong(String n, String a);

    /*
     * Removes a song from the playlist.
     *
     * @param n the name of the song to be removed
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
    public final Map<String, String> removeSong(String n);

    /*
     * Returns the length of the playlist.
     *
     * @returns: number of songs in the playlist
     *
     * @ensures: length = |this|
     */
    private final int length();

}