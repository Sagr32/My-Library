package com.sagr.my_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sagr.my_library.Activities.AboutActivity;
import com.sagr.my_library.Activities.AllBooksActivity;
import com.sagr.my_library.Activities.AlreadyReadActivity;
import com.sagr.my_library.Activities.CurrentlyReadActivity;
import com.sagr.my_library.Activities.FavouriteActivity;
import com.sagr.my_library.Activities.WantToReadActivity;

public class MainActivity extends AppCompatActivity {


    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener((View v) -> {
           Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
           startActivity(intent);
        });

        btnAlreadyRead.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
            startActivity(intent);
        });

        btnWantToRead.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
            startActivity(intent);

        });

        btnCurrentlyReading.setOnClickListener((View v)->{
            Intent intent = new Intent(MainActivity.this, CurrentlyReadActivity.class);
            startActivity(intent);
        });

        btnFavorite.setOnClickListener((View v)->{
            Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
            startActivity(intent);
        });
        btnAbout.setOnClickListener((View v )->{
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
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