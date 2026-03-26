package Model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    String name;
    List<Song> songs;

    public PlayList(String name) {
        this.name=name;
        songs=new ArrayList<>();
    }

    public void addNewSong(Song song) {
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "\nPlayList [name=" + name + ", songs=" + songs + "]\n";
    }

    
}
