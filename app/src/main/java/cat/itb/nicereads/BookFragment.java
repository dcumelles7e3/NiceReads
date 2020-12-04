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
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class BookFragment extends Fragment {
    private EditText nameText;
    //private Spinner moduleSpinner;
    private Button dateButton;

    private Book Book;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Book = new Book();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_fragment, container, false);

        nameText = view.findViewById(R.id.name_text);

        //moduleSpinner = view.findViewById(R.id.spinner);
        dateButton = view.findViewById(R.id.date_button);


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.modules, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        moduleSpinner.setAdapter(adapter);
        dateButton.setEnabled(false);
        dateButton.setText((new Date()).toString());

        if (getArguments() != null) Book = getArguments().getParcelable("Book");
        if (Book != null){
            nameText.setText(Book.getTitle());
        }


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        nameText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Book.setTitle(nameText.getText().toString());
                return false;
            }
        });



    }
}
