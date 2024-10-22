
import components.map.Map;
import components.queue.Queue;

/*
 * Interface Implementation for {@code MusicPlaylist} implemented on {@code Queue} with {@code Map}
 *
 * @param Queue<Map<String, String>>
 * @author Nijaa Nishanth
 */

public interface MusicPlaylist extends MusicPlaylistKernel {

    /* Queue to add songs */
    private Queue<Map<String, String>> playlist;

    /* song */
    private Map<String, String> song;

    /*
     * Shuffles the playlist to a different order than the original playlist
     *
     * @updates this
     *
     */
    public void shuffle()

    {
        Queue<Map<String, String>> temp = new Queue1L<>();
        temp.transferFrom(this.playlist);
        while (temp.length() > 0) {
            Map<String, String> s = temp.dequeue();
            this.playlist.addSong(s.value("name"), s.value("artist"));
        }
    }

    /*
     * Adds a song directly after the current song
     *
     * @param a the name of the artist of the song to be added
     *
     * @param n the name of the song to be added
     *
     * @updates this
     *
     */
    public final void addToQueue(String n, String a)
    {
        Queue<Map<String, String>> temp = new Queue1L<>();
        temp.transferFrom(this.playlist);
        this.song.add(n, a);
        Map<String, String> s = temp.dequeue();
        this.playlist.addSong()
        while(temp.length() > 1)
        {
            Map<String, String> s = temp.dequeue();

        }
    }

    /*
     * Plays the playlist from the song specified and removes the songs before
     * it
     *
     * @param n the name of the song to be added
     *
     * @updates this
     *
     */
    public final void playFromSong(String n) {

    }

}
