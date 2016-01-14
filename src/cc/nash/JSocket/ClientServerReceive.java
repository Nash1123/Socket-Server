package cc.nash.JSocket;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ClientServerReceive extends Thread {
	public void run() {
		byte buff[] = new byte[1024];
		try {
			Socket s = new Socket(ClientServer.txf1.getText(), 2525);
			ClientServer.txa1
					.append("Connected with server for receiving successfully!!\n");
			System.out
					.println("Connected with server for receiving successfully!!");

			InputStream in = s.getInputStream();
			int n;
			while (true) {
				n = in.read(buff);
				ClientServer.txa1.append("Server: " + new String(buff, 0, n));
				System.out.print("Received from server: ");
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
