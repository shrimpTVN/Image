package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ImageView;

public class ImageListener implements ActionListener
{
	private ImageView imageView;
	
	public ImageListener (ImageView imageView)
	{
		this.imageView = imageView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src= ((JButton) e.getSource()).getActionCommand();
		
			if (src.equals("ButtonRight"))
			{
				this.imageView.increase();
			}
			else
				this.imageView.decrease();
	}
	
	
}
