package com.sagr.my_library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sagr.my_library.activities.AboutActivity;
import com.sagr.my_library.activities.AllBooksActivity;
import com.sagr.my_library.activities.AlreadyReadActivity;
import com.sagr.my_library.activities.CurrentlyReadActivity;
import com.sagr.my_library.activities.FavouriteActivity;
import com.sagr.my_library.activities.WantToReadActivity;
import com.sagr.my_library.utils.Utils;

public class MainActivity extends AppCompatActivity {


    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        Utils.getInstance();
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
            intent.putExtra(AboutActivity.WEB_URL,"https://github.com/Sagr32/My-Library");
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