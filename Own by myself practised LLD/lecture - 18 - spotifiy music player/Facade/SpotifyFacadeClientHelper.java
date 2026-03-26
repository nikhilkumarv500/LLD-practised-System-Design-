package Facade;

import java.util.*;

import AudioOutput.AudioPlayPauseEngine;
import AudioOutput.IAudioOutputDevice;
import Enum.AudioDeviceType;
import Enum.PlayListTraversalType;
import Manager.AudioDeviceManager;
import Manager.PlayListManager;
import Manager.PlayListTraversalManager;
import Model.Song;

public class SpotifyFacadeClientHelper {

    List<Song> songList = new ArrayList<>();
    IAudioOutputDevice iAudioOutputDevice;

    public void addSong(String title, String path) {
        songList.add(new Song(title, path));
    }

    public void playSong(String title, AudioDeviceType audioType) {
        iAudioOutputDevice = AudioDeviceManager.getInstance()
                                                .connectAudioDevice(audioType);

        Song song = null;
        for(Song x:songList){
            if(x.getTitle().equals(title)) {
                song=x;
                break;
            }
        }            

        AudioPlayPauseEngine audioPlayPauseEngine = new AudioPlayPauseEngine(song);

        audioPlayPauseEngine.playSong(iAudioOutputDevice,song);
        audioPlayPauseEngine.pauseSong(iAudioOutputDevice,song);
    }

    public void createPlayList(String name) {
        PlayListManager playListManager = PlayListManager.getInstance();
        playListManager.createPlayList("Playlist-1");
    }

    public void addSongsToPlayList(String playListName,String title) {
        PlayListManager playListManager = PlayListManager.getInstance();
        Song song = null;
        for(Song x:songList){
            if(x.getTitle().equals(title)) {
                song=x;
                break;
            }
        }
        playListManager.addSongToPlayList(playListName, song);
        // System.out.println(playListManager.getPlayList("Playlist-1"));
    }

    public void printPlayList(PlayListTraversalType traversalType, String playListName) {
        PlayListManager playListManager = PlayListManager.getInstance();

        PlayListTraversalManager playListTraversalManager = new 
        PlayListTraversalManager(traversalType, 
        playListManager.getPlayList(playListName));

        playListTraversalManager.doPlayListTraversal();
    }
    
}