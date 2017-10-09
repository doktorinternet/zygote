package resource;

import org.lwjgl.Sys;

public class Rhythm {

    int BPM;

    public Rhythm(int BPM){
        this.BPM = BPM;
    }

    public int getBPM() {
        return BPM;
    }

    // 1 second divided by beats per second, times 1000 to get value in millis
//    public float decrementPerFrame(int delta){
//        float x = (1f/(BPM/60f))*1000f;
//        return 1f/(x/delta);
//    }
    public float millisPerBeat(){
        return (1f/(BPM/60f))*1000f; // if bpm 120 return 500
    }

    public float secondsPerBeat(){
        return 1f/(BPM/60f); // if bpm 120 return 0.5
    }

    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }


    public int getDelta() {
        long lastTime = getTime();
        long currentTime = getTime();
        int delta = (int) (currentTime - lastTime);
        //lastTime = getTime();
        return delta;
    }
}
