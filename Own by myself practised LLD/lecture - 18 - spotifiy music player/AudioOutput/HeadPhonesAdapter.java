package AudioOutput;

import AudioOutput.ExternalAudioApis.ExternalHeadphoneApi;
import Model.Song;

public class HeadPhonesAdapter implements IAudioOutputDevice{
    ExternalHeadphoneApi externalHeadphoneApi;

    public HeadPhonesAdapter(ExternalHeadphoneApi externalHeadphoneApi) {
        this.externalHeadphoneApi=externalHeadphoneApi;
    }

    @Override
    public void playAudio(Song song) {
        externalHeadphoneApi.playWithHeadphone(song.getTitle());
    }
}
