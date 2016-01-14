package cc.nash.JSocket;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import cc.nash.JSocket.ServerSend;
import cc.nash.JSocket.ServerReceive;

public class Server {
	static Frame frm = new Frame("JAVA Socket Server AWT Program");
	static Button btn1 = new Button("Start");
	static Button btn2 = new Button("Exit");
	static Label lab1 = new Label("Host IP Address");
	static Label title = new Label("JSocket");
	static TextArea txa1 = new TextArea("", 6, 10,
			TextArea.SCROLLBARS_VERTICAL_ONLY);
	static TextArea txa2 = new TextArea("", 6, 10, TextArea.SCROLLBARS_NONE);
	static TextField txf1 = new TextField("127.0.0.1");
	static ServerSend ss = new ServerSend();
	static ServerReceive sr = new ServerReceive();

	public static void main(String[] args) {
		try {
			InetAddress adr = InetAddress.getLocalHost();
			txf1.setText(adr.getHostAddress());
			btn1.addActionListener(new ActLis());
			btn2.addActionListener(new ActLis());
			frm.addWindowListener(new WinLis());

			frm.setLayout(null);
			title.setBounds(20, 40, 75, 40);
			btn1.setBounds(280, 40, 100, 20);
			btn2.setBounds(280, 65, 100, 20);
			frm.setBounds(100, 100, 400, 300);
			frm.setBackground(new Color(151, 255, 255));
			lab1.setBounds(100, 40, 160, 20);
			txa1.setBounds(20, 95, 360, 140);
			txa2.setBounds(20, 240, 360, 40);
			txf1.setBounds(100, 65, 160, 20);
			txa1.setEditable(false);
			title.setFont(new Font("Serief", Font.BOLD + Font.ITALIC, 18));
			title.setForeground(Color.BLUE);
			frm.add(title);
			frm.add(btn1);
			frm.add(btn2);
			frm.add(lab1);
			frm.add(txa1);
			frm.add(txa2);
			frm.add(txf1);
			frm.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	static class ActLis implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button btn = (Button) e.getSource();
			if (btn == btn1) {
				txa1.setText("Waiting for connecting(" + txf1.getText()
						+ ")...\n");
				System.out.println("Waiting for connecting...");
				txf1.setEditable(false);
				ss.start();
				sr.start();
			} else if (btn == btn2)
				System.exit(0);
			else
				System.out.println("No Button Click!");
		}
	}

	static class WinLis extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			frm.dispose();
			System.exit(0);
		}
	}
}