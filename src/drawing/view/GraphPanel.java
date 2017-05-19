package drawing.view;

import java.awt.*;
import javax.swing.JPanel;
import java.util.*;

public class GraphPanel extends JPanel
{
	private int [] data = {27, 5, 54, 10};
	private int width;
	private ArrayList<Rectangle> graph;
	
	public GraphPanel(int [] data)
	{
		if(data != null)
		{
			this.data = data;
		}
		this.width = 10;
		graph = new ArrayList<Rectangle>();
		
		this.setMinimumSize(new Dimension(250, 250));
		setupPanel();
	}
	
	private void setupPanel()
	{
			this.setBackground(Color.LIGHT_GRAY);
	}
@Override
	protected void paintComponent(Graphics basic)
	{
	graph.clear();
	this.setBackground(new Color(128, 43, 226));
	if(this != null)
	{
		width = this.getWidth() / data.length;
	}
	for(int index = 0; index < data.length; index++)
	{
		int xPoint = index * width;
		int yPoint = this.getHeight() - data[index];
		Rectangle current = new Rectangle(xPoint, yPoint, width, data[index]);
		graph.add(current);
	}
	Graphics2D drawing = (Graphics2D) basic;
	for(Rectangle current : graph)
	{
		int alpha = (int) (Math.random() * 256);
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		Color random = new Color(red, green, blue, alpha);
		drawing.setColor(random);
		drawing.fill(current);
	}
	}

public void setData(int [] data)
{
	this.data = data;
	repaint();
}

public void sortData()
{
	Arrays.sort(data);
	repaint();
}
}
