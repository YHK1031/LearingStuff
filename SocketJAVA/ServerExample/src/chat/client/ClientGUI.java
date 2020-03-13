package chat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chat.server.ServerGUI;

public class ClientGUI extends JFrame implements ActionListener{

	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	private ClientBackground client = new ClientBackground();
	
	
	public ClientGUI() {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("Clinet area");
		client.setGui(this);
		appendMsg("Enter your nick name..\n");
		client.connect();
		
	}
	
	public static void main(String[] args) {
		new ClientGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = jtf.getText();
		jta.append("[me]"+msg+"\n");
		System.out.println(msg);
		client.sendData(msg);
		jtf.setText("");
	}

	public void appendMsg(String message) {
		// TODO Auto-generated method stub
		jta.append(message);
		System.out.println("message from server : "+message);
	}
}
