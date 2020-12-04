package cat.itb.nicereads;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    List<Book> books;

    public BookAdapter(List<Book> books){
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bindData(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends  RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        TextView status;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            status = itemView.findViewById(R.id.status);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections listToFragmentDirections = BookListFragmentDirections.actionBookListFragmentToBookFragment(books.get(getAdapterPosition()));
                    Navigation.findNavController(v).navigate(listToFragmentDirections);
                }
            });
        }

        public void bindData(Book book){
            title.setText(book.getTitle());
            author.setText(book.getAuthor());
            status.setText(String.valueOf(book.getStatus()));

        }
    }
}
