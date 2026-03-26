package Manager;

import java.util.*;

import Model.PlayList;
import Model.Song;

public class PlayListManager {
    static PlayListManager selfObj;

    private PlayListManager(){}

    Map<String, PlayList> playlistMap = new HashMap<>();

    public static PlayListManager getInstance() {
        if(selfObj == null) selfObj=new PlayListManager();
        return selfObj;
    }

    public void createPlayList(String name) {
        if(playlistMap.containsKey(name)) {
            System.out.println("Playlist already exists");
            return;
        }
        playlistMap.put(name, new PlayList(name));
        System.out.println("Playlist created = " + name);
    }

    public void addSongToPlayList(String name, Song song) {
        if(playlistMap.containsKey(name) == false) {
            System.out.println("playlist does not exists = " + name );
            return;
        }
        playlistMap.get(name).addNewSong(song);
    }

    public PlayList getPlayList(String name) {
        if(playlistMap.containsKey(name) == false) {
            System.out.println("playlist does not exists = " + name );
            return null;
        }
        return playlistMap.get(name);
    }
}
