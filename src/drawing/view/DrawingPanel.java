package drawing.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private JButton buildButton;
	private ShapePanel recPanel;
	private GraphPanel graphPanel;
	
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		buildButton = new JButton("Click to draw");
		recPanel = new ShapePanel(baseController);
		graphPanel = new GraphPanel(setupArray());
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private int[] setupArray()
	{
		int length = (int)(Math.random() * 10) + 3;
		int [] randomArray = new int [length];
		for(int index =0; index < length; index ++)
		{
			randomArray[index] = (int)(Math.random()* 50) + 3;
		}
		return randomArray;
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setSize(new Dimension(1000, 1000));
		this.add(buildButton);
		this.add(recPanel);
		this.add(graphPanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, buildButton, 450, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, buildButton, 30, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, recPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, recPanel, -688, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, recPanel, 937, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, recPanel, 0, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		buildButton.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent clicked)
				{
					recPanel.addRectangles();
				}
			}
		);
			
	}
}
