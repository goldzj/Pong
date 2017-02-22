package ponglab;

import java.awt.Color; 
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;
	private Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.pink};
	public static Mixer mixer;
	public static Clip clip;
	
	
	//constructors
	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y)
	{
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int hei)
	{
		super(x, y, wid, hei);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int hei, Color col)
	{
		super(x, y, wid, hei, col);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int hei, Color col, int xS, int yS)
	{
		super(x, y, wid, hei, col);
		xSpeed = xS;
		ySpeed = yS;
	}  
	
    //set methods
	public void setXSpeed(int xS)
	{
		xSpeed = xS;
	}
   public void setYSpeed(int yS)
   {
	   ySpeed = yS;
   }
   public void setAll(int x, int y, int wid, int hei, Color col, int xS, int yS)
   {
	   super.setPos(x, y);
	   super.setDimensions(wid, hei);
	   super.setColor(col);
	   xSpeed = xS;
	   ySpeed = yS;
   }

   public void moveAndDraw(Graphics window)
   {
	   //draw a white ball at old ball location
	   draw(window, Color.white);

	   setX(getX()+xSpeed);
	   //setY
	   setY(getY()+ySpeed);
	   
	   //draw the ball at its new location
	   draw(window, super.getColor());
   }
   
	public boolean equals(Object obj)
	{
		Ball other = (Ball)obj;
		if(super.equals(other) && xSpeed == other.xSpeed && ySpeed == other.ySpeed)
		{
			return true;
		}
		return false;
	}   

	//get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}

	//toString() method
	public String toString()
	{
		return super.toString() + " " + xSpeed + " "+ ySpeed;
	}
	
	
	public void changeColor()
	{
		super.setColor(colors[randInt(0, colors.length-1)]);
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void initSound()
	{
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfos[0]);
		
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try { clip = (Clip)mixer.getLine(dataInfo); }
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		
		try
		{
			URL soundURL = Ball.class.getResource("/ponglab/pong.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream (soundURL);
			clip.open(audioStream);
		}
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		catch(UnsupportedAudioFileException uafe) { uafe.printStackTrace(); }
		catch(IOException ioe) { ioe.printStackTrace(); }
		
		
		/*do
		{
			try { Thread.sleep(20); }
			catch(InterruptedException ie) { ie.printStackTrace(); }
		} while (clip.isActive());
		*/
	}
	public static void playSound()
	{
		initSound();
		clip.start();
	}

}