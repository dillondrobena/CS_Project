import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectClient extends JApplet implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton sendText;
	public JLabel label;
	public JTextField textField;
	public DataOutputStream toServer;

	public void init(){
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		sendText = new JButton();
		sendText.setText("Send");
		textField = new JTextField(20);
		textField.setSize(100, 10);
		panel.add(sendText);
		panel.add(textField, BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);		
		try {
			Socket socket = new Socket("localhost", 8000);
			toServer = new DataOutputStream(socket.getOutputStream());
			sendText.addActionListener(this);
		}
		catch (IOException ex){
			System.err.println(ex);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (textField.getText() != null){
			try {
				toServer.writeUTF(textField.getText());
				textField.setText("");
			}
			catch (IOException e1){
				e1.printStackTrace();
			}
		}
	}
}
