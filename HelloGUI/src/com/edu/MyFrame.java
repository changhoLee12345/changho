package com.edu;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {

		setSize(300, 200);
		setLocation(200, 300);
		setTitle("MyFrame");
		setLayout(new FlowLayout());

		getContentPane().setBackground(Color.yellow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Cancel");
		add(button1);
		add(button2);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
