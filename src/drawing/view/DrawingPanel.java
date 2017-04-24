package drawing.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private Color current;
	private Color next;
	private int colorNumb;
	private int currentNumb;
	private int deltaRed;
	private int deltaGreen;
	private int deltaBlue;
	private double leftOverRed;
	private double leftOverGreen;
	private double leftOverBlue;
	private ShapePanel shapes;
	private JButton button;
	private SpringLayout layout;
	private DrawingController baseController;
	private double LR;
	private double LG;
	private double LB;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		shapes = new ShapePanel(baseController);
		button = new JButton("button");
		layout = new SpringLayout();
		current = Color.white;
		currentNumb = 0;
		colorNumb = 120;
		NextColor();
	}
	
	private void setup();
	private void setupLayout()
	private void setupListeners()


	private void setup()
	{
		this.setLayout(layout);
		this.add(button);
		this.add(shapes);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				shapes.addRectangles();
			}
			
		});
	}

	}