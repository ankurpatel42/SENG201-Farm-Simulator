package farmsimulator;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * This class contains the music that is to be played throughout the game, it loops continuously until the user has quit.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class MusicPlayer {
	
	/**
	 * The music to be played during the game.
	 *
	 */
	public void playMusic() {
		
		try {
			
			URL music = getClass().getResource("/music/Sergey_Cheremisinov_The_Healing.wav");

			AudioInputStream audio = AudioSystem.getAudioInputStream(music);
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audio);
			audioClip.start();
			audioClip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error playing music");
		}
	}
}
