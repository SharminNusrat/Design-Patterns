package media_player;

import java.util.ArrayList;
import java.util.List;

//Base Media Player interface
interface MediaPlayer {
 void play(String filename);
 void stop();
}

//Concrete media players for different file types
class AudioPlayer implements MediaPlayer {
 private Quality quality;
 
 public AudioPlayer(Quality quality) {
     this.quality = quality;
 }
 
 @Override
 public void play(String filename) {
     System.out.println("Playing audio file: " + filename + " at " + quality + " quality");
 }
 
 @Override
 public void stop() {
     System.out.println("Stopping audio playback");
 }
}

class VideoPlayer implements MediaPlayer {
 private Quality quality;
 
 public VideoPlayer(Quality quality) {
     this.quality = quality;
 }
 
 @Override
 public void play(String filename) {
     System.out.println("Playing video file: " + filename + " at " + quality + " quality");
 }
 
 @Override
 public void stop() {
     System.out.println("Stopping video playback");
 }
}

//Factory for creating media players
class MediaPlayerFactory {
 public static MediaPlayer createPlayer(String fileType, Quality quality) {
     if (fileType.endsWith(".mp3") || fileType.endsWith(".wav")) {
         return new AudioPlayer(quality);
     } else if (fileType.endsWith(".mp4") || fileType.endsWith(".avi")) {
         return new VideoPlayer(quality);
     }
     throw new UnsupportedOperationException("Unsupported media type");
 }
}

//Quality enum
enum Quality {
 LOW, MEDIUM, HIGH
}

//Decorator for adding features
abstract class MediaPlayerDecorator implements MediaPlayer {
 protected MediaPlayer player;
 
 public MediaPlayerDecorator(MediaPlayer player) {
     this.player = player;
 }
 
 @Override
 public void play(String filename) {
     player.play(filename);
 }
 
 @Override
 public void stop() {
     player.stop();
 }
}

class SubtitleDecorator extends MediaPlayerDecorator {
 public SubtitleDecorator(MediaPlayer player) {
     super(player);
 }
 
 @Override
 public void play(String filename) {
     super.play(filename);
     System.out.println("Enabling subtitles");
 }
}

class EqualizerDecorator extends MediaPlayerDecorator {
 public EqualizerDecorator(MediaPlayer player) {
     super(player);
 }
 
 @Override
 public void play(String filename) {
     super.play(filename);
     System.out.println("Applying equalizer settings");
 }
}

//Observer interface and concrete observer
interface PlaybackObserver {
 void update(String event);
}

class PlaybackLogger implements PlaybackObserver {
 @Override
 public void update(String event) {
     System.out.println("Log: " + event);
 }
}

//Media Player Manager (Singleton with Observer functionality)
class MediaPlayerManager {
 private static MediaPlayerManager instance;
 private List<PlaybackObserver> observers = new ArrayList<>();
 private MediaPlayer currentPlayer;
 
 private MediaPlayerManager() {}
 
 public static MediaPlayerManager getInstance() {
     if (instance == null) {
         instance = new MediaPlayerManager();
     }
     return instance;
 }
 
 public void addObserver(PlaybackObserver observer) {
     observers.add(observer);
 }
 
 public void notifyObservers(String event) {
     for (PlaybackObserver observer : observers) {
         observer.update(event);
     }
 }
 
 public void playMedia(String filename, Quality quality) {
     // Create appropriate player using factory
     currentPlayer = MediaPlayerFactory.createPlayer(filename, quality);
     
     // Add features using decorators if needed
     if (filename.endsWith(".mp4")) {
         currentPlayer = new SubtitleDecorator(currentPlayer);
     }
     currentPlayer = new EqualizerDecorator(currentPlayer);
     
     // Play and notify observers
     currentPlayer.play(filename);
     notifyObservers("Started playing: " + filename);
 }
 
 public void stopPlayback() {
     if (currentPlayer != null) {
         currentPlayer.stop();
         notifyObservers("Playback stopped");
     }
 }
}

//Example usage
public class MediaPlayerDemo {
 public static void main(String[] args) {
     MediaPlayerManager playerManager = MediaPlayerManager.getInstance();
     playerManager.addObserver(new PlaybackLogger());
     
     // Play different media files
     playerManager.playMedia("song.mp3", Quality.HIGH);
     System.out.println("-------------------");
     playerManager.playMedia("movie.mp4", Quality.HIGH);
     System.out.println("-------------------");
     playerManager.stopPlayback();
 }
}