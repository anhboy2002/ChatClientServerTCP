package chattcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadProcess extends Thread {
	Socket sk;

	public ThreadProcess(Socket sk) {
		this.sk = sk;
	}

	public void run() {
		try {
		DataOutputStream dos = new DataOutputStream(this.sk.getOutputStream());
		DataInputStream din = new DataInputStream(this.sk.getInputStream());
		// nhap chuoi de gui den client
		Scanner kb = new Scanner(System.in);
		while (true) {
			// nhan du lieu tu client
			String st = din.readUTF();
			System.out.println(st);
			System.out.print("Server: ");
			String msg = kb.nextLine();
			dos.writeUTF("Server: " + msg);
			dos.flush();
			kb = kb.reset();
		}
	}
	catch(Exception e) {
		System.out.println("Loi :"+e.getMessage());
	}
}
}

