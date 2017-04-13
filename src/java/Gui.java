/* TODO
 * set label for month/day/year date box and separate by non-editable boxes
 * containing a '-' in order to minimize user error
 */
package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener
{
	private Connector c;
	private JTextField firstF, lastF, addressF, emailF, phoneF, dateF;
	private JLabel firstL, lastL, addressL, emailL, phoneL, dateL;
	private JButton add;
	private String date;
	public Gui()
	{
		c = new Connector();
		setLayout(null);
		setSize(300, 400);
		
		firstF = new JTextField("");
		lastF = new JTextField("");
		addressF = new JTextField("");
		emailF = new JTextField("");
		phoneF = new JTextField("");
		dateF = new JTextField("");
		
		firstL = new JLabel("First Name");
		lastL = new JLabel("Last Name");
		addressL = new JLabel("Address");
		emailL = new JLabel("Email");
		phoneL = new JLabel("Phone Number");
		dateL = new JLabel("Date Started");
		
		firstF.setBounds(50, 50, 100, 20);
		add(firstF);
		
		firstL.setBounds(75, 20, 100, 50);
		add(firstL);
		
		lastF.setBounds(50, 100, 100, 20);
		add(lastF);
		lastL.setBounds(75, 80, 100, 20);
		add(lastL);
		
		addressF.setBounds(50, 150, 100, 20);
		add(addressF);
		addressL.setBounds(75, 130, 100, 20);
		add(addressL);
		
		emailF.setBounds(50, 200, 100, 20);
		add(emailF);
		emailL.setBounds(85, 180, 100, 20);
		add(emailL);
		
		phoneF.setBounds(50, 250, 100, 20);
		add(phoneF);
		phoneL.setBounds(65, 230, 100, 20);
		add(phoneL);
		
		dateF.setBounds(50, 300, 100, 20);
		add(dateF);
		dateL.setBounds(65, 280, 100, 20);
		add(dateL);
		
		add = new JButton("Add Client");
		add.setBounds(200, 150, 75, 75);
		add(add);
		
		dateF.setToolTipText("Please use format MM-DD-YYYY");
		phoneF.setToolTipText("Please enter only numerical values");
		
		add.addActionListener(this);

	}
	
	private void parseDate()
	{
		String entry = dateF.getText();
		String month = entry.substring(0, entry.indexOf("-"));
		String day = entry.substring(entry.indexOf("-")+1, entry.lastIndexOf("-"));
		String year = entry.substring(entry.lastIndexOf("-")+ 1);
		date = year + "-" + month + "-" + day;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == add)
		{
			parseDate();
			Client temp = new Client();
			temp.setAddress(addressF.getText());
			temp.setfirstName(firstF.getText());
			temp.setlastName(lastF.getText());
			temp.setEmail(emailF.getText());
			temp.setPhone(Integer.parseInt(phoneF.getText()));
			temp.setDate(date);
			
			c.addClient(temp);
			
		}
		
	}

}
