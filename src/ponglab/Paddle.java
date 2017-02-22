package ponglab;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variable
   private int speed;

   //constructor
   public Paddle()
   {
	   super(10,10);
	   speed =5;
   }
   public Paddle(int x, int y)
	{
		super(x, y);
		speed = 5;
	}
	public Paddle(int x, int y, int wid, int hei)
	{
		super(x, y, wid, hei);
		speed = 5;
	}
	public Paddle(int x, int y, int wid, int hei, Color col)
	{
		super(x, y, wid, hei, col);
		speed = 5;
	}
	public Paddle(int x, int y, int wid, int hei, int sp)
	{
		super(x, y, wid, hei);
		speed = sp;
	}
	public Paddle(int x, int y, int wid, int hei, Color col, int sp)
	{
		super(x, y, wid, hei, col);
		speed = sp;
	}

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setY(getY()-speed);
	   draw(window, super.getColor());
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   setY(getY()+speed);
	   draw(window, super.getColor());
   }

   //get method
   public int getSpeed()
   {
	   return speed;
   }
   
   //toString() method
   public String toString()
   {
	   return super.toString() + " " + speed;
   }
}