package com.sagr.my_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener((View v) -> {
            //TODO: Implement All Books
        });

        btnAlreadyRead.setOnClickListener((View v) -> {
            //TODO: Implement Already Read  Books
        });

        btnWantToRead.setOnClickListener((View v) -> {
            //TODO: Implement Want To Read Books

        });

        btnCurrentlyReading.setOnClickListener((View v)->{
            //TODO: Implement Currently Reading Books
        });

        btnFavorite.setOnClickListener((View v)->{
            //TODO: Implement Favorite Books
        });
        btnAbout.setOnClickListener((View v )->{
            //TODO: Implement About
        });





    }

    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorite = findViewById(R.id.btnFavouriteBooks);
        btnAbout = findViewById(R.id.btnAbout);
    }
}