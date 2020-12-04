package cat.itb.nicereads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookListFragment extends Fragment {
    private BookViewModel bookViewModel;
    private RecyclerView bookList;

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
        return v;
    }
}
