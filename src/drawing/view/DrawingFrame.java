package drawing.view;

import javax.swing.JFrame;

import drawing.controller.DrawingController;

public class DrawingFrame extends JFrame
{

	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.setSize(this.getMaximumSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new DrawingPanel(baseController));
		this.setVisible(true);
	}
}