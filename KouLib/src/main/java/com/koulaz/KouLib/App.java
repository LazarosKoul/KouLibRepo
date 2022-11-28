package com.koulaz.KouLib;

import com.koulaz.KouLib.frames.MainAppFrame;

/** This is the main class. 
 * It is used only for starting the application's main JFrame.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to my library!");

        MainAppFrame mainAppFrame = new MainAppFrame();
        mainAppFrame.setVisible(true);
    }
}
