package Module5.solid.isp;

public class Demo4 {
    
}

/**
 * The interface below is too broad. Given the design requirements, how 
 * would you split it?
 * 
 * 1. A PodcastPlayer needs to be added — it plays and records audio, 
 * but cannot stream online or convert formats.
 * 
 * 2. A StreamingPlayer needs to play and stream online only — no 
 * recording or format conversion.
 * 
 * 3. A component should be able to depend on only the capability it 
 * needs — for example, a RecordingService should not be aware that 
 * players can also stream.
 * 
 * 4. Adding a new capability (e.g., subtitle support) should not force 
 * all existing player classes to be updated.
 */

// BEFORE
interface IMediaPlayer {
    void play(String file);
    void pause();
    void stop();
    void record(String file);
    void convertFormat(String file, String format);
    void streamOnline(String url);
}

class BasicPlayer implements IMediaPlayer {
    public void play(String file) { System.out.println("Playing: " + file); }
    public void pause()           { System.out.println("Paused."); }
    public void stop()            { System.out.println("Stopped."); }
    public void record(String file) {
        throw new UnsupportedOperationException("Cannot record!");
    }
    public void convertFormat(String file, String format) {
        throw new UnsupportedOperationException("Cannot convert!");
    }
    public void streamOnline(String url) {
        throw new UnsupportedOperationException("Cannot stream!");
    }
}

// AFTER
interface IPlayable {
  void play(String file);
  void pause();
  void stop();
}
interface IRecordable {
  void record(String file);
}
interface IConvertible {
  void convertFormat(String file, String format);
}
interface IStreamable {
  void streamOnline(String url);
}

class BasicPlayer implements IPlayable {
  public void play(String file) { ... }
  public void pause()           { ... }
  public void stop()            { ... }
}

class PodcastPlayer implements IPlayable, IRecordable {
  public void play(String file)   { ... }
  public void pause()             { ... }
  public void stop()              { ... }
  public void record(String file) { ... }
}

class StreamingPlayer implements IPlayable, IStreamable {
  public void play(String file)        { ... }
  public void pause()                  { ... }
  public void stop()                   { ... }
  public void streamOnline(String url) { ... }
}

