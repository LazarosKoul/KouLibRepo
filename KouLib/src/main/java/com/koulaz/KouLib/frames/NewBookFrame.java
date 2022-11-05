package com.koulaz.KouLib.frames;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.koulaz.KouLib.entities.Book;
import com.koulaz.KouLib.tools.CustomFileWriter;

public class NewBookFrame extends JFrame {

	private String cleanIconPath = "resources\\clean.gif";
	private String saveIconPath = "resources\\save.gif";
	private String cancelIconPath = "resources\\cancel.gif";

	private JLabel tiltleLabel;
	private JTextField titleField;
	private JLabel authorLabel;
	private JTextField authorField;
	private JLabel errorLabel;

	private JButton saveButton;
	private JButton clearButton;
	private JButton cancelButton;

	public NewBookFrame() {
		super("Insert A New Book!");
		setLayout(new FlowLayout());

		tiltleLabel = new JLabel("Insert Book Title:");
		add(tiltleLabel);
		titleField = new JTextField(10);
		add(titleField);

		authorLabel = new JLabel("Insert Author:");
		add(authorLabel);
		authorField = new JTextField(10);
		add(authorField);

		errorLabel = new JLabel("Fields cannot be empty.");
		errorLabel.setVisible(false);
		add(errorLabel);

		Icon saveButtonIcon = new ImageIcon(getClass().getResource(saveIconPath));
		saveButton = new JButton("Save", saveButtonIcon);
		add(saveButton);

		Icon clearButtonIcon = new ImageIcon(getClass().getResource(cleanIconPath));
		clearButton = new JButton("Clear", clearButtonIcon);
		add(clearButton);

		Icon cancelButtonIcon = new ImageIcon(getClass().getResource(cancelIconPath));
		cancelButton = new JButton("Cancel", cancelButtonIcon);
		add(cancelButton);

		ButtonHandler bHandler = new ButtonHandler();
		saveButton.addActionListener(bHandler);
		clearButton.addActionListener(bHandler);
		cancelButton.addActionListener(bHandler);
	}

	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == saveButton) {
				String newTitle = titleField.getText();
				String newAuthor = authorField.getText();
				if (newTitle.isEmpty() || newAuthor.isEmpty()) {
					errorLabel.setVisible(true);
					return ;
				}

				Book newBook = new Book(newTitle, newAuthor);
				new CustomFileWriter().saveBooktoFile(newBook);
				JOptionPane.showMessageDialog(null, "Book saved!");
			} else if (event.getSource() == clearButton) {
				titleField.setText("");
				authorField.setText("");
			} else if (event.getSource() == cancelButton) {
				JOptionPane.showMessageDialog(null, "Let's CAncel.");
			}
		}
	}

}
