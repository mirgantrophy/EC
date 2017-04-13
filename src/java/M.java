package test;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class M 
{

	public static void main(String[] args) 
	{
		Gui main = new Gui();
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception ex) 
		{
			System.out.println("Unable to create GUI Window");
		}
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);

	}

}
