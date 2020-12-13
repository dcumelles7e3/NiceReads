package cat.itb.nicereads;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {
    List<Book> books = new ArrayList<Book>();

    public BookViewModel() {
        books.add(new Book("Los Pistoleros del Eclipse", "Callejeros", 3, 5));
        books.add(new Book("Ramón el Vanidoso", "Callejeros", 3, 4));
        books.add(new Book("Harry el Susio Potter", "Bananero", 3, 4.5f));
        books.add(new Book("Opera Rock Triunfo", "Mojinos Escozios", 3, 5));
        books.add(new Book("Perokeise", "Ekisde", 1, 3));
        books.add(new Book("Los Pistoleros del Eclipse", "Callejeros", 3, 5));

    }

    public void addBook(Book book) {
        books.add(book);
    }
}