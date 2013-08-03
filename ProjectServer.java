/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 *
 * @author Roman
 */
public class ProjectServer extends JApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//new Server();
	public JPanel panel1, panel2;
	public ServerThread serverThread;
	public ReverseText reverse;
	public CapitalizeText capitalize;
	public JButton capitalizeText, displayText, reverseText;
	public JTextField textBox;

	public void init(){
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		JPanel panel1 = new JPanel();
		displayText = new JButton();
		displayText.setText("Display Text");
		capitalizeText = new JButton();
		capitalizeText.setText("Capitalize Text");
		reverseText = new JButton();
		reverseText.setText("Reverse Text");
		textBox = new JTextField(20);
		textBox.setEnabled(false);
		panel1.add(displayText);
		panel1.setSize(400,400);
		panel1.add(capitalizeText);
		panel1.add(reverseText);
		panel1.add(textBox);
		frame.add(panel1);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(400,400);
		try{
			ServerSocket serverSocket = new ServerSocket(8000);
			Socket socket = serverSocket.accept();
			DataInputStream inputFromClient = 
					new DataInputStream(socket.getInputStream());
			while(true){
				String text = inputFromClient.readUTF();
				panel1.remove(capitalizeText);
				panel1.remove(reverseText);
				panel1.remove(displayText);
				panel1.remove(textBox);
				displayText = new JButton();
				displayText.setText("Display Text");
				capitalizeText = new JButton();
				capitalizeText.setText("Capitalize Text");
				reverseText = new JButton();
				reverseText.setText("Reverse Text");
				panel1.add(displayText);
				panel1.add(capitalizeText);
				panel1.add(reverseText);
				panel1.add(textBox);
				frame.pack();
				frame.setSize(400,400);
				textBox.setText(text);
				serverThread = new ServerThread();
				serverThread.run(textBox, text, capitalizeText, reverseText, displayText);
			}
		}

		catch(IOException ex){
			System.err.println(ex);

		}
	}
}
