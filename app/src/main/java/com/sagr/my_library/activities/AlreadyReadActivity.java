package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sagr.my_library.R;
import com.sagr.my_library.adapters.BookRecViewAdapter;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

import java.util.ArrayList;

public class AlreadyReadActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookRecViewAdapter adapter;
    private ArrayList<Book> books = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read);
        recyclerView = findViewById(R.id.booksRecView);
        adapter = new BookRecViewAdapter(this);

        adapter.setBooks(Utils.getAlreadyReadList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}