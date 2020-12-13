package cat.itb.nicereads;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class BookFragment extends Fragment {
    private TextInputEditText nameText;
    private TextInputEditText authorText;
    private Spinner spinner;
    private Button addButton;
    private RatingBar ratingBar;

    private BookViewModel bookViewModel;
    private Book book;
    private boolean replace = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookViewModel = new ViewModelProvider(getActivity()).get(BookViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_fragment, container, false);

        nameText = (TextInputEditText) view.findViewById(R.id.name_text_edit);
        authorText = (TextInputEditText) view.findViewById(R.id.author_text_edit);
        ratingBar = (RatingBar) view.findViewById(R.id.rating_bar);
        spinner = view.findViewById(R.id.spinner);
        addButton = view.findViewById(R.id.add_button);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (getArguments() != null) book = getArguments().getParcelable("book");
        if (book != null) {
            nameText.setText(book.getTitle());
            authorText.setText(book.getAuthor());
            ratingBar.setRating(book.getRating());
            spinner.setSelection(book.getStatus());
        } else {
            replace = false;
            book = new Book("", "", 0, 0);
        }

        if (replace) addButton.setText("Save");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        nameText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                return false;
//            }
//        });
//        authorText.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                return false;
//            }
//        });
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//
//            }
//        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameText.getText().toString().equals("")||authorText.getText().toString().equals("")){
                    Toast.makeText(getContext(), "You cannot leave a box empty!", Toast.LENGTH_SHORT).show();
                } else {
                    book.setTitle(nameText.getText().toString());
                    book.setAuthor(authorText.getText().toString());
                    book.setStatus(spinner.getSelectedItemPosition());
                    book.setRating(ratingBar.getRating());
                    if (!replace) bookViewModel.addBook(book);
                    Navigation.findNavController(v).popBackStack();
                }
            }
        });


    }
}
