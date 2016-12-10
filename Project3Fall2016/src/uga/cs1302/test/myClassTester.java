package uga.cs1302.test;

import java.awt.*;

import uga.cs1302.myStack.IntegerStackEmulator;
public class myClassTester {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegerStackEmulator window = new IntegerStackEmulator();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
