import java.util.*;

import Enum.AudioDeviceType;
import Enum.PlayListTraversalType;
import Facade.SpotifyFacadeClientHelper;

//check how to print enums

class Client {
    void run() {

        SpotifyFacadeClientHelper clientHelper = new SpotifyFacadeClientHelper();

        //song creation
        clientHelper.addSong("song-1", "C:\\music\\song1");
        clientHelper.addSong("song-2", "C:\\music\\song2");
        clientHelper.addSong("song-3", "C:\\music\\song3");
        clientHelper.addSong("song-4", "C:\\music\\song4");
        
        
        //audio device setup
        clientHelper.playSong("song-2", AudioDeviceType.BLUETOOTH);

        //playList setup
        clientHelper.createPlayList("Playlist-1");
        clientHelper.addSongsToPlayList("Playlist-1", "song-1");
        clientHelper.addSongsToPlayList("Playlist-1", "song-2");
        clientHelper.addSongsToPlayList("Playlist-1", "song-3");
        clientHelper.addSongsToPlayList("Playlist-1", "song-4");

        //Traversal stuffs
        clientHelper.printPlayList(PlayListTraversalType.RANDOM,"Playlist-1");



    }
}



public class Code {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Client obj = new Client();
        obj.run();
        
        sc.close();
    }
}