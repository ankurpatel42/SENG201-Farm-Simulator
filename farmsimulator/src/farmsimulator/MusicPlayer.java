package farmsimulator;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * This class contains the music that is to be played throughout the game, it loops continiously until the user has quit.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class MusicPlayer {
	
	/**
	 * The music to be played during the game.
	 * 
	 * @param filepath			The filepath/location of the .wav file which contains the audio to be played during the game.
	 */
	public void playMusic(String filepath) {
		
		try {
			
			File musicPath = new File(filepath);
			
			if (musicPath.exists()) {
				AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
				Clip audioClip = AudioSystem.getClip();
				audioClip.open(audio);
				audioClip.start();
				audioClip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else {
				JOptionPane.showMessageDialog(null, "No sound file found.");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error playing music.");
		}
	}
}
