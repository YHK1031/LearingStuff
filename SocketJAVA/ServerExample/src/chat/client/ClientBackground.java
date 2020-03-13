package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGUI gui;
		
		public void connect() {
			try {
				socket = new Socket("127.0.0.1",7777);
				System.out.println("¼­¹ö¿¬°áµÊ");
				
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				while(in!=null) {
					String message = in.readUTF();
					System.out.println("message from server: "+message);
					this.gui.appendMsg(message);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			ClientBackground clientBackground = new ClientBackground();
			clientBackground.connect();
		}

		public ClientGUI getGui() {
			return gui;
		}

		public void setGui(ClientGUI gui) {
			this.gui = gui;
		}
		
		public void sendData(String msg) {
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
