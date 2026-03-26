package Factory;

import AudioOutput.BlueToothSpeakerAdapter;
import AudioOutput.HeadPhonesAdapter;
import AudioOutput.IAudioOutputDevice;
import AudioOutput.ExternalAudioApis.ExternalBlueToothApi;
import AudioOutput.ExternalAudioApis.ExternalHeadphoneApi;
import Enum.AudioDeviceType;

public class AudioDeviceGeneratorFactory {

    IAudioOutputDevice iAudioOutputDevice;
    static AudioDeviceGeneratorFactory selfObj;

    private AudioDeviceGeneratorFactory(){}

    public static AudioDeviceGeneratorFactory getInstance() {
        if(selfObj==null) selfObj = new AudioDeviceGeneratorFactory();
        return selfObj;
    }

    public IAudioOutputDevice createFactory(AudioDeviceType type) {
        if(type==AudioDeviceType.BLUETOOTH) {
            iAudioOutputDevice = new BlueToothSpeakerAdapter(new ExternalBlueToothApi());
        } else if(type==AudioDeviceType.HEADPHONE) {
            iAudioOutputDevice = new HeadPhonesAdapter(new ExternalHeadphoneApi());
        }

        return iAudioOutputDevice;
    }
}
