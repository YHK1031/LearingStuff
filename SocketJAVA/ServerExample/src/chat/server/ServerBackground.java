package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGUI gui;
	
	/**02 ����ڵ��� ������ �����ϴ� ��. */
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
	
	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // ��������??
			serverSocket = new ServerSocket(7777);
			while(true) {
				/**01  ������ ���� �д�. ��� ���� �޴°�*/
				// ������ ���� : �湮�ڸ� ��� �޾Ƽ� �����带 ����
				System.out.println("����� ....");
				socket = serverSocket.accept();	//��� �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress()+"�� �����߽��ϴ�.");
				// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� �������� �־��ֱ�
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

	public ServerGUI getGui() {
		return gui;
	}

	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}

	public void addClient(String nick, DataOutputStream out) {
		// TODO Auto-generated method stub
		clientMap.put(nick,out);
	}
	
	public void removeClient(String nick) {
		clientMap.remove(nick);
	}
	
	//�޼��� ���� ����
	public void sendMessage(String msg, String inNick) {
		Iterator<String> it = clientMap.keySet().iterator();
		String key="";
		while(it.hasNext()) {
			key = it.next();
			try {
				if(!key.equals(inNick))
				clientMap.get(key).writeUTF(inNick+" : "+msg+"\n");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//----------------------------------------------------------------------
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		String nick;
		/**02 ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ó�� ��� ���.. */
		public Receiver(Socket socket) throws IOException{

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// ���ù��� ó������ Ŭ���̾�Ʈ ���̵� �޾ƿ��� ����
			nick = in.readUTF();
			out.writeUTF("Your nick name is : "+nick+"\n");
			addClient(nick, out);

		}
		
		@Override
		public void run() {
				try {
					// ��� ��⸸
					while(in!=null) {
					String message = in.readUTF();
					sendMessage(message,nick);
					gui.appendMsg(nick+" : "+message+"\n");
					}
				}catch(IOException e) {
					// ������� ����� ���⼭ ����� ����
					removeClient(nick);
				}
				
		}
	}

}
