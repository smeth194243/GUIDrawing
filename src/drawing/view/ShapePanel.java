package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import drawing.controller.DrawingController;

public class ShapePanel extends JPanel
{
	private DrawingController baseController;
	private ArrayList<Shape> rectangleList;
	private ArrayList<Shape> triangleList;
	private ArrayList<Shape> circleList;
	private ArrayList<Shape> ellipseList;
	private ArrayList<Shape> polygonList;
	private ArrayList<ArrayList<Shape>> shapes;
	//private Color inverted;
	public ShapePanel(DrawingController baseController)
	{
		super();
		//inverted = Color.black;
		this.baseController = baseController;
		rectangleList = new ArrayList<Shape>();
		ellipseList = new ArrayList<Shape>();
		circleList = new ArrayList<Shape>();
		triangleList = new ArrayList<Shape>();
		polygonList = new ArrayList<Shape>();
		shapes = new ArrayList<ArrayList<Shape>>();
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
		
		for (ArrayList<Shape> currentList: shapes)
		{
			drawShapes(currentList, drawingGraphics);
		}
		//for(Rectangle currentRect : rectangleList)
		//{
		//	drawingGraphics.setColor(getRandomColor());
		//	int strokeWidth = (int)(Math.random() * 10)+1;
		//	drawingGraphics.setStroke(new BasicStroke(strokeWidth));
		//	//drawingGraphics.draw(currentRect);
		//	
		//	int randomness = (int) (Math.random() * 35);
		//	
		//	if(randomness % 5 == 0 || randomness % 7 ==0)
		//		
		//	{
		//		drawingGraphics.fill(currentRect);
		//	}
		//	else
		//	{
		//		drawingGraphics.draw(currentRect);
		//	}
		//}
	}
	private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
	{
		for(Shape currentShape : shapeList)
		{
			graphics.setColor(getRandomColor());
			int strokeWidth = (int)(Math.random() * 10) + 1;
			graphics.setStroke(new BasicStroke(strokeWidth));
			
			int randomness = (int) (Math.random() * 35);
			if(randomness % 5 == 0 || randomness % 7 == 0)
			{
				graphics.fill(currentShape);
				graphics.setColor(getRandomColor());
				graphics.draw(currentShape);
			}
			else
			{
				graphics.draw(currentShape);
			}
		}
	}
	
	private void addCircles()
	{
		if(circleList.size()>500)
		{
			circleList.clear();
		}
		
		for(int index =0; index < 30; index ++)
		{
			int radius = (int)(Math.random()* 25)+2;
			int xCorner = (int)(Math.random() * this.getWidth() -15);
			int yCorner = (int)(Math.random() * this.getHeight() -15);
			
		}
	}
	
	private void addTriangles()
	{
		if(triangleList.size()>500)
		{
			triangleList.clear();
		}
		
		for (int index =0; index < 30; index++)
		{
			int vertexCount = 3;
			int [] xVerticies = new int [vertexCount];
			int [] yVerticies = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner=(int)(Math.random()* this.getWidth());
				int yCorner=(int)(Math.random()* this.getHeight());
				xVerticies[vertex]= xCorner;
				yVerticies[vertex]= yCorner;
			}
			Polygon current = new Polygon(xVerticies, yVerticies, vertexCount);
			triangleList.add(current);
			
		}
		this.repaint();
	}
	
	private void addPolygons()
	{
		if(polygonList.size()>500)
		{
			polygonList.clear();
		}
		
		for (int index = 0; index< 30; index++)
		{
			int vertexCount = (int)(Math.random()* 7) +4;
			int [] xVerticies = new int [vertexCount];
			int [] yVerticies = new int [vertexCount];
			
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner=(int)(Math.random()* this.getWidth());
				int yCorner=(int)(Math.random()* this.getHeight());
				xVerticies[vertex]= xCorner;
				yVerticies[vertex]= yCorner;
			}
			Polygon current = new Polygon(xVerticies, yVerticies, vertexCount);
			polygonList.add(current);
		}
	}
	
	private void reset()
	{
		for( int index =0; index < shapes.size(); index++)
		{
			shapes.get(index).clear();
		}
		this.setBackground(getRandomColor());
		this.repaint();
	}
}


