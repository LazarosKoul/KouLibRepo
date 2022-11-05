package com.koulaz.KouLib.frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.koulaz.KouLib.entities.Book;
import com.koulaz.KouLib.tools.CustomFileReader;

public class MainAppFrame extends JFrame{

	private JLabel label;
	private JButton newBookButton;
	private String addBookPath = "resources\\add_Book.gif";
	
	public MainAppFrame() {
		super("KouLib");
		setLayout(new FlowLayout());
		
		label = new JLabel("Here is your books:");
		add(label);
	
		//Books
		for (Book b: new CustomFileReader().getBooksFromFile() ){
			JLabel bookListLabel = new JLabel(b.toViewString());
			add(bookListLabel);
		}
		
		//Button
		Icon plusIcon = new ImageIcon(getClass().getResource(addBookPath));
		newBookButton = new JButton("Add Book", plusIcon);
		newBookButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewBookFrame newBookFrame = new NewBookFrame();
				newBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newBookFrame.setSize(500,400);
				newBookFrame.setVisible(true);
				
			}
		});
		add(newBookButton);
		
		addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent e) {
				// TODO Auto-generated method stub
				if (e.getNewState() == WindowEvent.WINDOW_GAINED_FOCUS) {
					for (Book b: new CustomFileReader().getBooksFromFile() ){
						JLabel bookListLabel = new JLabel(b.toViewString());
						add(bookListLabel);
					}
				}
			}
		});
	}
}
