package cc.nash.JSocket;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSend extends Thread {
	static int flag_send = 0;

	public void run() {
		try {
			Server.txa2.addKeyListener(new KeyLis());
			ServerSocket svs = new ServerSocket(2525);
			Socket s = svs.accept();
			Server.txa1
					.append("Clinet connecting for sending successfully!!\n");
			System.out.println("Clinet connecting for sending successfully!!");

			System.out.println("Data transfering...");
			OutputStream out = s.getOutputStream();
			String str;
			while (true) {
				if (flag_send == 1) {
					str = Server.txa2.getText();
					out.write(str.getBytes());
					flag_send = 0;
					System.out.print("Send:" + str);
				}
				sleep((int) (100 * Math.random()));
			}
			// in.close();
			// out.close();
			// s.close();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	static class KeyLis extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				flag_send = 1;
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Server.txa1.append("Server: " + Server.txa2.getText());
				Server.txa2.setText("\r");
			}

		}
	}
}
