
import components.map.Map;
import components.map.Map2;
import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Kernel Implementation for {@code MusicPlaylist} implemented on {@code Queue}
 * with {@code Map}.
 *
 * @author Nijaa Nishanth
 */
public class MusicPlaylist1 extends MusicPlaylistSecondary {

    /**
     * Queue to add songs.
     */
    private Queue<Map<String, String>> playlist;

    /**
     * Song from the Playlist.
     */
    private Map<String, String> song;

    /**
     * Creater of initial representation.
     */
    private void createNewRep() {
        this.playlist = new Queue1L<>();
        this.song = new Map2<>();
    }

    /*
     * Constructors ------------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public MusicPlaylist1() {
        this.createNewRep();
    }

    /**
     * Map Constructor.
     */
    public MusicPlaylist1(Map<String, String> s) {
        this.createNewRep();
        this.playlist.enqueue(s);
        this.song = s;
    }

    /**
     * Queue Constructor.
     */
    public MusicPlaylist1(Queue<Map<String, String>> p) {
        this.createNewRep();
        this.playlist.append(p);
        this.song = this.playlist.front();
    }

    /**
     * Standard methods. -------------------------------------------------------
     */

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final MusicPlaylist1 newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot constructo object of type " + this.getClass());
        }
    }

    @Override
    public final void transferFrom(MusicPlaylist1 source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MusicPlaylist1 : ""
                + "Violation of: source is of dynamic type MusicPlaylist1";
        MusicPlaylist1 localSource = (MusicPlaylist1) source;
        this.playlist = localSource.playlist;
        this.song = localSource.song;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods ---------------------------------------------------------
     */

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
    public final void addSong(String n, String a) {
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
    public final Map<String, String> removeSong(String n) {
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
    public final int length() {
        return this.playlist.length();
    }

}