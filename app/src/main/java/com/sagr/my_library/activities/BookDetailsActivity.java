package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sagr.my_library.R;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

import java.util.ArrayList;

public class BookDetailsActivity extends AppCompatActivity {


    private ImageView bookImage;
    private Button addToCurrentlyReading, addToFavourites, addToWantToRead, addToAlreadyRead;
    private TextView bookName, bookAuthor, bookDescription, pagesCount;
    public static String BOOK_ID_KEY = "book_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        initViews();
        Intent intent = getIntent();

        if (intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                setData(incomingBook);
                handleAlreadyRead(incomingBook);
                handleCurrentlyRead(incomingBook);
                handleFavurite(incomingBook);
                handleWantToRead(incomingBook);




            }

        }


    }

    void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadList = Utils.getInstance(this).getAlreadyReadList();
        boolean existInAlreadyRead = Utils.getInstance(this).existInList(book, alreadyReadList);

        if (existInAlreadyRead) {
            addToAlreadyRead.setEnabled(false);
        } else {
            addToAlreadyRead.setOnClickListener((View v) -> {
                if (Utils.getInstance(this).addToAlreadyReady(book)) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, AlreadyReadActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "error , please try again later", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    void handleCurrentlyRead(Book book) {
        ArrayList<Book> currentlyReadList = Utils.getInstance(this).getCurrentlyReadingList();
        boolean existInCurrentlyRead = Utils.getInstance(this).existInList(book, currentlyReadList);
        if (existInCurrentlyRead) {
            addToCurrentlyReading.setEnabled(false);
        } else {
            addToCurrentlyReading.setOnClickListener((View v) -> {
                if (Utils.getInstance(this).addToCurrentlyRead(book)) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CurrentlyReadActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "error , please try again later", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    void handleFavurite(Book book) {
        ArrayList<Book> favouriteList = Utils.getInstance(this).getFavouriteList();
        boolean existInFavourite = Utils.getInstance(this).existInList(book, favouriteList);
        if (existInFavourite) {
            addToFavourites.setEnabled(false);
        } else {
            addToFavourites.setOnClickListener((View v) -> {
                if (Utils.getInstance(this).addToFavourite(book)) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, FavouriteActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "error , please try again later", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    void handleWantToRead(Book book) {
        ArrayList<Book> wantToReadList = Utils.getInstance(this).getWantToReadList();
        boolean existInWantToRead = Utils.getInstance(this).existInList(book, wantToReadList);
        if (existInWantToRead) {
            addToWantToRead.setEnabled(false);
        } else {
            addToWantToRead.setOnClickListener((View v) -> {
                if (Utils.getInstance(this).addToWantToRead(book)) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, WantToReadActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "error , please try again later", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


    private void initViews() {
        bookImage = (ImageView) findViewById(R.id.imgBookImage);
        addToCurrentlyReading = (Button) findViewById(R.id.btnAddToCurrentlyReading);
        addToFavourites = (Button) findViewById(R.id.btnAddToFavourites);
        addToWantToRead = (Button) findViewById(R.id.btnAddToWantToRead);
        addToAlreadyRead = (Button) findViewById(R.id.btnAddToAlreadyRead);
        bookName = (TextView) findViewById(R.id.txtBookName);
        bookAuthor = (TextView) findViewById(R.id.txtAuthor);
        bookDescription = (TextView) findViewById(R.id.txtDesc);
        pagesCount = (TextView) findViewById(R.id.txtPagesCount);
    }

    private void setData(Book book) {

        bookName.setText(book.getBookName());
        bookAuthor.setText(book.getAuthorName());
        bookDescription.setText(book.getLongDesc());
        pagesCount.setText(String.valueOf(book.getPages()));
        Glide.with(this)
                .load(book.getImageUrl())
                .error(R.drawable.ic_error)
                .into(bookImage);

    }
}