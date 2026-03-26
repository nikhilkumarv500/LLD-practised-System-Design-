package AudioOutput;
import Model.Song;

public class AudioPlayPauseEngine {
    boolean playing = false;
    Song song;

    public AudioPlayPauseEngine(Song song) {
        this.song=song;
    }

    public void playSong(IAudioOutputDevice iAudioOutputDevice, Song song) {

        if(! this.song.getTitle().equals(song.getTitle())) {
            System.out.println("AudioPlayPauseEngine contains other song");
            return;
        }

        if(playing==false){
            iAudioOutputDevice.playAudio(song);
            playing=true;
        }
        else {
            System.out.println("Already playing song: " + song.getTitle());
        }
    }

    public void pauseSong(IAudioOutputDevice iAudioOutputDevice, Song song) {
        
        if(! this.song.getTitle().equals(song.getTitle())) {
            System.out.println("AudioPlayPauseEngine contains other song");
            return;
        }

        if(playing==true) {
            playing=false;
            System.out.println("Song paused = " + song.getTitle());
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public void changeSong(Song song) {
        System.out.println("new song = " + song.getTitle() + 
        " ||[old song = "+ this.song.getTitle() + "]");

        this.song = song;
    }
}
