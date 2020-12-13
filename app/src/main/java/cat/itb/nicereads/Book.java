package cat.itb.nicereads;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title, author;
    private int status;
    private float rating;

    public Book() {
    }

    public Book(String title, String author, int status, float rating) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.rating = rating;
    }

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        status = in.readInt();
        rating = in.readFloat();
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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