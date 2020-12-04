package cat.itb.nicereads;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {
    List<Book> books = new ArrayList<Book>();

    public BookViewModel() {
        for (int i = 0; i < 3; i++) {
            Book book = new Book();
            books.add(book);
        }
    }
}