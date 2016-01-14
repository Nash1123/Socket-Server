package cc.nash.JSocket;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ClientServerSend extends Thread {
	static int flag_send = 0;

	public void run() {
		try {
			ClientServer.txa2.addKeyListener(new KeyLis());

			Socket s = new Socket(ClientServer.txf1.getText(), 2526);
			ClientServer.txa1
					.append("Connected with server for sending successfully!!\n");
			System.out
					.println("Connected with server for sending successfully!!");

			System.out.println("Data transfering...");
			OutputStream out = s.getOutputStream();
			String str;
			while (true) {
				if (flag_send == 1) {
					str = ClientServer.txa2.getText();
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
				ClientServer.txa1.append("Client: "
						+ ClientServer.txa2.getText());
				ClientServer.txa2.setText("\r");
			}

		}
	}
}
