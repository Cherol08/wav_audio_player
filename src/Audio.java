import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

	// Application only supports wav audio files
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner input = new Scanner(System.in);
		
		File file = new File("Illusions-Anno_Domini_Beats.wav");
		AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		
		clip.open(audiostream);

		String choice = "";
		
		while(!choice.equals("Q")) {
			System.out.println("\nP-Play\nS-Stop\nR-Reset\nQ-Quit");
			System.out.println("Choose an option: ");
			choice = input.next();
			
			
			switch(choice.toUpperCase()){
				case "P": clip.start(); break;
				case "S": clip.stop(); break;
				case "R": clip.setMicrosecondPosition(0); break;
				case "Q": clip.close(); break;
				default: System.out.println("Pick a valid option"); break;
			}
		}
		
		input.close();
	}

}
