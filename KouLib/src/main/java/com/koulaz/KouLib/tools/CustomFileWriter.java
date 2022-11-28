package com.koulaz.KouLib.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.koulaz.KouLib.entities.*;

public final class CustomFileWriter {

	private static FileWriter output;
	private final static File booksFile = new File("data\\Books.json");

	private static void openFileToWrite(File file) {
		if (!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("File can not be created.");
				System.exit(1);
			}
			System.out.println("A new file has been created.");
		}
		try {
			output = new FileWriter(file);
		} catch (IOException e) {
			System.err.println("[Writer]Cannot open the file: " + booksFile);
			System.exit(1);
		}
	}

	private static void closeFileAfterWrite() {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				System.out.print("File did not close properly.");
			}
		}

	}

	public static void saveBooktoFile(Book newBook) {
		ArrayList<Book> books = new ArrayList<Book> (Arrays.asList(CustomFileReader.getBooksFromFile()));
		books.add(newBook);

		openFileToWrite(booksFile);

		Gson gson = new Gson();
		String aStringToSave = gson.toJson(books);

		FileWriter fw;
		try {
			fw = new FileWriter(booksFile, true);
			System.out.print("Saving...");
			fw.write(aStringToSave);
			System.out.println("Done!");
			fw.close();
		} catch (IOException e) {
			System.out.println("Cannot save books properly.");
		}
		closeFileAfterWrite();
	}
}
