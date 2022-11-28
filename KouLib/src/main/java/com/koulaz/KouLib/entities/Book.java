package com.koulaz.KouLib.entities;

import java.util.ArrayList;

/**
 * This is a book entity representation, for application usage,
 * as well as saving.
 * @see Book(String bookName, String category, Author newBookAuthor)
 * @see Book(String bookName, ArrayList categories, ArrayList bookAuthors)
 */
public class Book {

    private String bookName;
    private ArrayList<String> categories;
    private ArrayList<Author> bookAuthors;

     /**
     * This constructor is recommended for com.google.code.gson library in order
     * to (De)Serialize this object from file.
     */
    public Book() {
        this.bookName = "Nothing";
        this.categories = new ArrayList<>();
        
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author());
        this.bookAuthors = authors;
    }
    /** This is the main constructor method.
     * @param bookName
     * @param categories 
     * @param bookAuthors
     * @see Book(String bookName, String category, Author newBookAuthor)
     */
    public Book(String bookName, ArrayList<String> categories, ArrayList<Author> bookAuthors) {
        this.bookName = bookName;
        this.categories = categories;
        this.bookAuthors = bookAuthors;
    }
    
    /** This constructor is used in case of a new book from only one author,
     * and it belongs in only one category.
     * @param bookName      Book title.
     * @param category      Book's category.
     * @param newBookAuthor Book's author
     * @see Book(String bookName, ArrayList categories, ArrayList bookAuthors)
     */
    public Book(String bookName, String category, Author newBookAuthor) {
        this.bookName = bookName;
        
        categories = new ArrayList<>();
        categories.add(category);

        bookAuthors = new ArrayList<>();
        bookAuthors.add(newBookAuthor);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<Author> getBookAuthors() {
        return bookAuthors;
    }
        public ArrayList<String> getBookAuthorsAsString() {
            ArrayList<String> authorsList = new ArrayList<>();
            for (Author a: bookAuthors ){
                authorsList.add(a.toString());
            }
        return authorsList;
    }

    /**
     * @param bookAuthors the bookAuthor to set
     */
    public void setBookAuthors(ArrayList<Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    @Override
    public String toString() {
        return "Book [ bookName=" + bookName + ", bookAuthors=" + bookAuthors + "]";
    }
}
