package game.view.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * G�n�rateur de sons. Soulever des fichiers wav et contenir des m�thodes pour chacun
� * du son.
 */ Uziel
public class Sound extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Sound playsound;

	private Sound()
	{

	}

	public static Sound getInstance()
	{
		if (playsound == null)
		{
			playsound = new Sound();
		}
		return playsound;
	}

	/**
	 * Son des boutons..
	 */
	public static void button()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/button.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Son des boutons....
	 */
	public static void diamond()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/diamond.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Son lorsque le jeu est perdu.
	 */
	public static void lost()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/lost.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Bruit d'un nouveau jeu.
	 */

	public static void newgame()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/newgame.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Bruit de victoire.
	 */
	public static void won()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/won.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Bruit de creuser.
	 */
	public static void dig()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/dig.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 *Bruit de l'explosion.
	 */
	public static void explosion()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/explosion.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 * Rock poussant le son.
	 */
	public static void push()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/push.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	/**
	 *Sonne quand Rockford marche.
	 */
	public static void step()
	{
		Clip clip = null;
		try
		{
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(playsound.getClass().getResource("/res/Sound/step.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(inputStream);

		}
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();
	}

	// SOUND TEST
	// public static void main(String[] args)
	// {
	// Sound playsound = new Sound();
	// playsound.button();
	// }
}