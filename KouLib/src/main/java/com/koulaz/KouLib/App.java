package com.koulaz.KouLib;

import javax.swing.JFrame;
import com.koulaz.KouLib.frames.MainAppFrame;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to my library!");

		MainAppFrame mainAppFrame = new MainAppFrame();
		mainAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainAppFrame.setSize(800, 700);
		mainAppFrame.setVisible(true);

	}
}
