
import components.map.Map;
import components.queue.Queue;

/**
 * Layered implementations of secondary methods for {@code SimpleWriter}.
 *
 * @author Nijaa Nishanth
 *
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

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
        Queue<Map<String, String>> playlist = this.newInstance();
        playlist.transferFrom(this);
        String p = "";
        for (Map<String, String> s : playlist) {
            p += "artist: " + s.key("artist") + " name: " + s.key("name");
        }
        this.transferFrom(playlist);
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
        return this.hashCode();
    }

    /**
     * reports whether two playlists are equal to each other.
     *
     * @param o
     *            the object to be compared to this
     *
     * @return whether or not the two strings are equal
     *
     * @ensures this
     *
     */
    @Override
    boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (this.length() != o.length()) {
            return false;
        } else {
            Queue<Map<String, String>> temp = this.newInstance();
            temp.transferFrom(this);
            Map<String, String> songThis = this.newInstance();
            for (Map<String, String> songP : o) {
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
        Queue<Map<String, String>> temp = this.newInstance();
        temp.transferFrom(this);
        while (temp.length() > 0) {
            Map<String, String> s = temp.front();
            String name = s.value("name");
            String artist = s.value("artist");
            this.removeSong(name);
            this.addSong(name, artist);
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
        Queue<Map<String, String>> temp = this.newInstance();
        temp.transferFrom(this);
        Map<String, String> s = temp.dequeue();
        this.addSong(s.value("name"), s.value("artist"));
        this.addSong(n, a);
        while (temp.length() > 1) {
            Map<String, String> s = temp.dequeue();
            this.addSong(s.value("name"), s.value("artist"));
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
        Queue<Map<String, String>> passed = this.newInstance();
        while (!songPassed) {
            Map<String, String> s = this.front();
            if (s.value("name").equals(n)) {
                songPassed = true;
            } else {
                this.removeSong(s.value("name"));
                passed.addSong(s.value("name"), s.value("artist"));
            }
        }
        return passed;
    }

}
