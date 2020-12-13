package cat.itb.nicereads;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {
    List<Book> books = new ArrayList<Book>();

    public BookViewModel() {
        books.add(new Book("Los Pistoleros del Eclipse", "Callejeros", 2, 5));
        books.add(new Book("El Retorno del Rey", "Tolkien", 0, 5));
        books.add(new Book("Ramón el Vanidoso", "Callejeros", 1, 4));
        books.add(new Book("Pim Pam Toma Lacasitos", "Callejeros", 0, 3.5f));
        books.add(new Book("Opera Rock Triunfo", "Mojinos Escozios", 1, 5));
        books.add(new Book("Fahrenheit 451", "Ray Bradbury", 2, 4.5f));
    }

    public void addBook(Book book) {
        books.add(book);
    }
}