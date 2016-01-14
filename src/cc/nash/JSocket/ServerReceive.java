package cc.nash.JSocket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReceive extends Thread {
	public void run() {
		byte buff[] = new byte[1024];
		try {
			ServerSocket svs = new ServerSocket(2526);

			Socket s = svs.accept();
			Server.txa1
					.append("Clinet connecting for receiving successfully!!\n");
			System.out
					.println("Clinet connecting for receiving successfully!!");

			InputStream in = s.getInputStream();
			int n;
			while (true) {
				n = in.read(buff);
				Server.txa1.append("Client: " + new String(buff, 0, n));
				System.out.print("Received from client: ");
				System.out.print(new String(buff, 0, n));
				sleep((int) (100 * Math.random()));
			}
			// in.close();
			// s.close();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
}
