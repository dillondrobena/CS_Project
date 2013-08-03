import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ServerThread extends Thread implements ActionListener{
	public ReverseText reverse;
	public CapitalizeText capitalize;
	public JTextField textBox;
	public String text;
	public void run(JTextField textBox, String text, JButton capitalizeText, JButton reverseText, JButton displayText){
		this.textBox = textBox;
		this.text = text;
		reverse = new ReverseText(text);
		capitalize = new CapitalizeText(text);
		capitalizeText.addActionListener(this);
		capitalizeText.setActionCommand("capitalize");
		reverseText.addActionListener(this);
		reverseText.setActionCommand("reverse");
		displayText.addActionListener(this);
		displayText.setActionCommand("display");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("capitalize".equals(e.getActionCommand())){
			textBox.setText(capitalize.returnText());
		}
		if ("reverse".equals(e.getActionCommand())){
			textBox.setText(reverse.returnText());
		}
		if ("display".equals(e.getActionCommand())){
			textBox.setText(text);
		}
		
	}
}
