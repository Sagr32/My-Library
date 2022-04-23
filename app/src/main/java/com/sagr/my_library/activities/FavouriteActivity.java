package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.sagr.my_library.MainActivity;
import com.sagr.my_library.R;
import com.sagr.my_library.adapters.BookRecViewAdapter;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookRecViewAdapter adapter;
    private ArrayList<Book> books = new ArrayList<>();
    public static final String ACTIVITY_NAME ="Favourite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        recyclerView = findViewById(R.id.booksRecView);
        adapter = new BookRecViewAdapter(this,ACTIVITY_NAME);

        adapter.setBooks(Utils.getInstance(this).getFavouriteList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}