package Manager;

import AudioOutput.IAudioOutputDevice;
import Enum.AudioDeviceType;
import Factory.AudioDeviceGeneratorFactory;

public class AudioDeviceManager {
    static AudioDeviceManager selfObj;
    IAudioOutputDevice iAudioOutputDevice;
    

    private AudioDeviceManager(){}

    public static AudioDeviceManager getInstance() {
        if(selfObj==null) selfObj = new AudioDeviceManager();
        return selfObj;
    }

    public IAudioOutputDevice connectAudioDevice(AudioDeviceType type) {
        return iAudioOutputDevice = AudioDeviceGeneratorFactory.getInstance().createFactory(type);
    }

    public IAudioOutputDevice getAudioOutputDevice(){
        if(iAudioOutputDevice==null) System.out.println("AudioDeviceManager -> iAudioOutputDevice = is null");
        return iAudioOutputDevice;
    }   
}
