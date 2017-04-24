package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import drawing.controller.DrawingController;

public class ShapePanel extends JPanel
{
	private DrawingController baseController;
	private List<Rectangle> rectangleList;
	//private Color inverted;
	public ShapePanel(DrawingController baseController)
	{
		super();
		//inverted = Color.black;
		this.baseController = baseController;
		this.rectangleList = new ArrayList<Rectangle>();
		this.setMinimumSize(new Dimension(100,500));
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setMinimumSize(new Dimension(250,500));
	}
	private Color getRandomColor()
	{
		int alpha = (int)(Math.random() * 255);
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		
		return new Color(red, green, blue, alpha);
	}
	public void addRectangles()
	{
		for(int index = 0; index < 500; index++)
		{
			int width = (int)(Math.random()*120)+1;
			int height = (int)(Math.random()*150)+15;
			int xCorner = (int)(Math.random()*(getWidth()-15));
			int yCorner = (int)(Math.random()*(getHeight()-15));
			Rectangle currentRectangle = new Rectangle(xCorner,yCorner,width,height);
			rectangleList.add(currentRectangle);
		}
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics graphics)
	{
		Graphics2D drawingGraphics = (Graphics2D) graphics;
		for(Rectangle currentRect : rectangleList)
		{
			drawingGraphics.setColor(getRandomColor());
			int strokeWidth = (int)(Math.random() * 10)+1;
			drawingGraphics.setStroke(new BasicStroke(strokeWidth));
			//drawingGraphics.draw(currentRect);
			
			int randomness = (int) (Math.random() * 35);
			
			if(randomness % 5 == 0 || randomness % 7 ==0)
				
			{
				drawingGraphics.fill(currentRect);
			}
			else
			{
				drawingGraphics.draw(currentRect);
			}
		}
	}
	
}


