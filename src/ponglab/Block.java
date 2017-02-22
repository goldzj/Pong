package ponglab;

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	//constructors
	public Block()
	{
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
	}
	public Block(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 0;
		height = 0;
	}
	public Block(int x, int y, int wid, int hei)
	{
		xPos = x;
		yPos = y;
		width = wid;
		height = hei;
	}
	public Block(int x, int y, int wid, int hei, Color col)
	{
		xPos = x;
		yPos = y;
		width = wid;
		height = hei;
		color = col;
	}
	
   //set methods
   public void setColor(Color col)
   {
	   color = col;
   } 
   public void setX(int x)
   {
	   xPos = x;
   }
   public void setY(int y)
   {
	   yPos = y;
   }
   public void setPos(int x, int y)
   {
	   xPos = x;
	   yPos = y;
   }
   public void setDimensions(int wid, int hei)
   {
	   width = wid;
	   height = hei;
   }
   
   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block other = (Block)obj;
		if (xPos == other.xPos && yPos == other.yPos && width == other.width && height == other.height && color == other.color)
		{
			return true;
		}
		
		return false;
	}   

   //get methods
   public int getX()
   {
	   return xPos;
   }
   public int getY()
   {
	   return yPos;
   }
   public int getWidth()
   {
	   return width;
   }
   public int getHeight()
   {
	   return height;
   }
   public Color getColor()
   {
	   return color;
   }

   //toString() method  - x , y , width, height, color
   public String toString()
   {
	   return "(" + xPos + "," + yPos + "," + width + "," + height + "," + color + ")";
   }

}