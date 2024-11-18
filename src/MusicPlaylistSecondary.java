
import components.map.Map;
import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary methods for {@code SimpleWriter}.
 *
 * @author Nijaa Nishanth
 *
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    /*
     * Playlist
     */
    private Queue<Map<String, String>> playlist;

    /*
     * Current song
     */
    private Map<String, String> song;

    /**
     * converts playlist to a string.
     *
     * @return string of songs in the playlist
     *
     * @requires this /= empty
     *
     * @ensures <this>
     *
     */
    @Override
    String toString() {
        String p = "";
        for (Map<String, String> s : this.playlist) {
            p += "artist: " + s.key("artist") + " name: " + s.key("name");
        }
        return p;
    }

    /**
     * reports the hashcode of the playlist.
     *
     * @return hashcode number
     *
     * @ensures hashcode number for this
     *
     */
    @Override
    int hashCode() {
        return this.playlist.hashCode();
    }

    /**
     * reports whether two playlists are equal to each other.
     *
     * @param p
     *
     *
     * @return whether or not the two strings are equal
     *
     * @ensures this
     *
     */
    boolean equals(MusicPlaylist p) {
        if (p == null) {
            return false;
        } else if (this.playlist.length() != p.length()) {
            return false;
        } else if (this.playlist == p) {
            return true;
        } else {
            Queue<Map<String, String>> temp = this.playlist.newInstance();
            temp.transferFrom(this.playlist);
            Map<String, String> songThis = this.song.newInstance();
            for (Map<String, String> songP : p) {
                if (!(songP.key("artist").equals(songThis.key("artist")))) {
                    return false;
                } else if (!(songP.key("name").equals(songThis.key("name")))) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Shuffles the playlist to a different order than the original playlist.
     *
     * @requires this /= empty
     * @updates this
     *
     * @ensures |#this| = |this| & #this /= this
     */
    void shuffle() {
        Queue<Map<String, String>> temp = new Queue1L<>();
        temp.transferFrom(this.playlist);
        while (temp.length() > 0) {
            Map<String, String> s = temp.front;
            String name = s.value("name");
            String artist = s.value("artist");
            this.playlist.removeSong(name);
            this.playlist.addSong(name, artist);
        }
    }

    /**
     * Adds a song directly after the current song.
     *
     * @param a
     *            the name of the artist of the song to be added
     *
     * @param n
     *            the name of the song to be added
     *
     * @requires this /= empty
     *
     * @updates this
     *
     * @ensures this = #this[0, 1) * n * #this[1, |#this|)
     *
     */
    void addToQueue(String n, String a) {
        Queue<Map<String, String>> temp = this.playlist.newInstance();
        temp.transferFrom(this.playlist);
        Map<String, String> s = temp.dequeue();
        this.playlist.addSong(s.value("name"), s.value("artist"));
        this.playlist.addSong(n, a);
        while (temp.length() > 1) {
            Map<String, String> s = temp.dequeue();
            this.playlist.addSong(s.value("name"), s.value("artist"));
        }
    }

    /**
     * Plays the playlist from the song specified and removes the songs before
     * it.
     *
     * @param n
     *            the name of the song to be added
     *
     * @requires this /= empty
     *
     * @updates this
     *
     * @return the songs removed from the playlist this = #this[n|#this|,
     *         |#this|)
     *
     */
    Queue<Map<String, String>> playFromSong(String n) {
        boolean songPassed = false;
        Queue<Map<String, String>> passed = this.playlist.newInstance();
        while (!songPassed) {
            Map<String, String> s = this.playlist.front();
            if (s.value("name").equals(n)) {
                songPassed = true;
                this.song = s;
            } else {
                this.playlist.removeSong(s.value("name"));
                passed.addSong(s.value("name"), s.value("artist"));
            }
        }
        return passed;
    }

}
