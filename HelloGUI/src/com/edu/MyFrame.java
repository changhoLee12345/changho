package com.edu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		setSize(300, 200);
		setTitle("MyFrame");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());
		JButton button = new JButton("button");
		add(button);

	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
