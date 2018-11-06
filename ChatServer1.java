package chattcp;

/*Chuong trinh chat don gian
Server nhan message tu Client */
import java.io.*;
import java.util.*;
import java.net.*;

public class ChatServer1 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");
		while(true) {
		Socket socket = server.accept();
		ThreadProcess thread = new ThreadProcess(socket);
		thread.start();
		}

		// socket.close();
	}
}