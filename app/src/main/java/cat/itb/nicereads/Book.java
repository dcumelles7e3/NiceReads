package cat.itb.nicereads;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title, author;
    private int status, rating;

    public Book() {
        this.title = "Ekisde";
        this.author = "author";
        this.status = 1;
        this.rating = 1;
    }

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        status = in.readInt();
        rating = in.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}