package cat.itb.nicereads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookListFragment extends Fragment {
    private BookViewModel bookViewModel;
    private RecyclerView bookList;
    private FloatingActionButton addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookViewModel = new ViewModelProvider(getActivity()).get(BookViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.book_list_fragment, container, false);
        bookList = v.findViewById(R.id.book_list);
        bookList.setLayoutManager(new LinearLayoutManager(getContext()));
        BookAdapter adapter = new BookAdapter(bookViewModel.books);
        bookList.setAdapter(adapter);
        addButton = v.findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Book book  = new Book();
//                bookViewModel.addBook(book);
//                NavDirections listToFragmentDirections = BookListFragmentDirections.actionBookListFragmentToBookFragment(book);
                Navigation.findNavController(v).navigate(R.id.action_bookListFragment_to_bookFragment);
            }
        });
        return v;
    }
}
