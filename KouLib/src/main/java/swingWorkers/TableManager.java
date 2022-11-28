package swingWorkers;

import com.koulaz.KouLib.entities.Book;
import com.koulaz.KouLib.tools.CustomFileReader;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import swingWorkers.TableManager.BookTableModel;


public class TableManager extends SwingWorker< Book[], Object> {

    private final JTable bookTable;
    private final JLabel jLabel;

    public TableManager(JLabel jLabel1, JTable bookTable) {
        this.bookTable = bookTable;
        this.jLabel = jLabel1;
    }

    @Override
    protected  Book[] doInBackground() throws Exception {
        System.err.println("Swing Worker is running in background.");
        jLabel.setText("Searching for books... Please wait.");
        Thread.sleep(2000);
        Book[] books = CustomFileReader.getBooksFromFile();
        return books;
    }

    @Override
    protected void done() {
        try {
            jLabel.setText("Books:");
            bookTable.setModel(new BookTableModel(get()));
        } catch (InterruptedException ex) {
            System.err.println("An InterruptedException has been trigered!");
        } catch (ExecutionException ex) {
            System.err.println("An ExecutionException has been trigered!");
        } finally {
            System.err.println("Swing Worker has been finished.");
        }
    }

    class BookTableModel extends AbstractTableModel {

        private final Book[] books;

        public BookTableModel(Book[] books) {
            this.books = books;
        }

        @Override
        public int getRowCount() {
            return books.length;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Title";
                case 1:
                    return "Author";
                case 2:
                    return "Categories";
            }
            return "";
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Book book = books[rowIndex];
            switch (columnIndex) {
                case 0:
                    return book.getBookName();
                case 1:
                    return String.join(", ", book.getBookAuthorsAsString());
                case 2:
                    return String.join(", ", book.getCategories());
            }
            return null;
        }
    }
}
