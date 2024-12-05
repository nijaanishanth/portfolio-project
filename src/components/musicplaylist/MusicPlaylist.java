package components.musicplaylist;

/**
 * Interface Implementation for {@code MusicPlaylist} implemented on
 * {@code Queue} with {@code Map}.
 *
 * @author Nijaa Nishanth
 */
public interface MusicPlaylist extends MusicPlaylistKernel {

    /**
     * Shuffles the playlist to a different order than the original playlist.
     *
     * @updates: this
     *
     * @ensures: |#this| = |this| & #this /= this
     */
    void shuffle();

    /**
     * Adds a song directly after the current song.
     *
     * @param a
     *            the name of the artist of the song to be added
     *
     * @param n
     *            the name of the song to be added
     *
     * @requires |this| > 0
     *
     * @updates this
     *
     * @ensures: this = #this[0, 1) * n * #this[1, |#this|)
     *
     */
    void addToQueue(String n, String a);

    /**
     * Plays the playlist from the song specified and removes the songs before
     * it.
     *
     * @param n
     *            the name of the song to be added
     *
     * @requires |this| > 1
     *
     * @updates this
     *
     * @return the songs removed from the playlist this = #this[n|#this|,
     *         |#this|)
     *
     */
    MusicPlaylist playFromSong(String n);

}
