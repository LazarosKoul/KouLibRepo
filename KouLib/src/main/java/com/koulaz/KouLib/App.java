package com.koulaz.KouLib;

import com.koulaz.KouLib.frames.MainAppFrame;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to my library!");

        MainAppFrame mainAppFrame = new MainAppFrame();
        mainAppFrame.setVisible(true);
    }
}
