package chattcp;

/*Chuong trinh chat don gian
Cient nhan chuoi tu ban phim gui den server */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class ChatClient1 {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		// nhap chuoi de gui den sever
		Scanner kb = new Scanner(System.in);
		System.out.println("Name Client:");
		String nameClient=kb.nextLine();
		while (true) {
			System.out.print("Client "+nameClient +" :");
			String msg = kb.nextLine();
			dos.writeUTF("Client " +nameClient+": "+ msg);
			dos.flush();
			// nhan du lieu tu server
			String st = din.readUTF();
			System.out.println(st);
			kb = kb.reset();
		}
	}
}