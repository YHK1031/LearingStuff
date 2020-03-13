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
	
	/**02 사용자들의 정보를 저장하는 맵. */
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
	
	public void setting() {
		try {
			Collections.synchronizedMap(clientMap); // 교통정리??
			serverSocket = new ServerSocket(7777);
			while(true) {
				/**01  서버가 할일 분담. 계속 접속 받는것*/
				// 서버가 할일 : 방문자를 계속 받아서 쓰레드를 생성
				System.out.println("대기중 ....");
				socket = serverSocket.accept();	//계속 반복해서 사용자를 받는다.
				System.out.println(socket.getInetAddress()+"에 접속했습니다.");
				// 여기서 새로운 사용자 스레드 클래스 생성해서 소켓정보 넣어주기
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
	
	//메세지 내용 전파
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
		/**02 리시버가 한일은 자기 혼자서 네트워크 처리 계속 듣기.. */
		public Receiver(Socket socket) throws IOException{

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			// 리시버가 처음에는 클라이언트 아이디를 받아오고 싶음
			nick = in.readUTF();
			out.writeUTF("Your nick name is : "+nick+"\n");
			addClient(nick, out);

		}
		
		@Override
		public void run() {
				try {
					// 계속 듣기만
					while(in!=null) {
					String message = in.readUTF();
					sendMessage(message,nick);
					gui.appendMsg(nick+" : "+message+"\n");
					}
				}catch(IOException e) {
					// 사용접속 종료시 여기서 사용자 빼기
					removeClient(nick);
				}
				
		}
	}

}
