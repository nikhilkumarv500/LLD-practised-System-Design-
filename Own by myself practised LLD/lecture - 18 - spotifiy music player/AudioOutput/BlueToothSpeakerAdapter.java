package AudioOutput;

import AudioOutput.ExternalAudioApis.ExternalBlueToothApi;
import Model.Song;

public class BlueToothSpeakerAdapter implements IAudioOutputDevice {
    ExternalBlueToothApi externalBlueToothApi;

    public BlueToothSpeakerAdapter(ExternalBlueToothApi externalBlueToothApi) {
        this.externalBlueToothApi=externalBlueToothApi;
    }

    @Override
    public void playAudio(Song song) {
        externalBlueToothApi.playWithBlueTooth(song.getTitle());
    }
}
