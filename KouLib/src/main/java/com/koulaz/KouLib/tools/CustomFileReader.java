package com.koulaz.KouLib.tools;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.koulaz.KouLib.entities.Book;

public final class CustomFileReader {

	private Scanner input;
	private final static File booksFile = new File("data\\Books.json");

	private void openFileForRead(File file) {
		try {
			input = new Scanner(file);
		} catch (IOException e) {
			System.err.println("[Reader]Cannot open the file: " + booksFile);
			System.exit(1);
		}
	}

	private void closeFileAfterRead() {
		if (input != null)
			input.close();
	}

	public Book[] getBooksFromFile() {
		openFileForRead(booksFile);

		System.err.print("[Reader]Reading...");
		String inputText = "";

		while (input.hasNext()) {
			inputText += input.next();
		}
		System.err.println("Done!");
		closeFileAfterRead();

		System.err.print("Converting...");
		Gson gson = new Gson();
		Book[] books = gson.fromJson(inputText, Book[].class);
		System.err.println("Done!");
		return books;
	}
}
