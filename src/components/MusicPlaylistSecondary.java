package components;

import components.map.Map;

/**
 * Layered implementations of secondary methods for {@code MusicPlaylist}.
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
    public String toString() {
        MusicPlaylist playlist = this.newInstance();
        MusicPlaylist temp = this.newInstance();
        playlist.transferFrom(this);
        String p = "";
        while (temp.length() > 0) {
            Map<String, String> s = temp.currentSong();
            p += "artist: " + s.key("artist") + " name: " + s.key("name");
            this.addSong(s.value("name"), s.value("artist"));
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
    public int hashCode() {
        return this.hashCode();
    }

    /**
     * reports whether two playlists are equal to each other.
     *
     * @param obj
     *            the object to be compared to this
     *
     * @return whether or not the two strings are equal
     *
     * @ensures this
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        }
        MusicPlaylist o = (MusicPlaylist) obj;
        if (this.length() != o.length()) {
            return false;
        } else {
            MusicPlaylist temp = this.newInstance();
            MusicPlaylist tempO = this.newInstance();
            temp.transferFrom(this);
            tempO.transferFrom(o);
            while (tempO.length() > 0) {
                Map<String, String> songP = tempO.currentSong();
                Map<String, String> songThis = temp.currentSong();
                songP = tempO.removeSong(songP.value("name"));
                songThis = temp.removeSong(songThis.value("name"));
                o.addSong(songP.value("name"), songP.value("artist"));
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
    @Override
    public void shuffle() {
        MusicPlaylist temp = this.newInstance();
        temp.transferFrom(this);
        while (temp.length() > 0) {
            Map<String, String> s = temp.currentSong();
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
    @Override
    public void addToQueue(String n, String a) {
        MusicPlaylist temp = this.newInstance();
        temp.transferFrom(this);
        Map<String, String> s = temp.currentSong();
        temp.removeSong(s.value("name"));
        this.addSong(s.value("name"), s.value("artist"));
        this.addSong(n, a);
        while (temp.length() > 1) {
            s = temp.currentSong();
            temp.removeSong(s.value("name"));
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
    @Override
    public MusicPlaylist playFromSong(String n) {
        boolean songPassed = false;
        MusicPlaylist passed = this.newInstance();
        while (!songPassed) {
            Map<String, String> s = this.currentSong();
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
