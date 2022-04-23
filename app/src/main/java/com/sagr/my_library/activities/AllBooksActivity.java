package com.sagr.my_library.activities;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sagr.my_library.R;
import com.sagr.my_library.adapters.BookRecViewAdapter;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookRecViewAdapter adapter;
    private ArrayList<Book> books = new ArrayList<>();
    public static final String ACTIVITY_NAME = "AllBooks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        recyclerView = findViewById(R.id.booksRecView);
        adapter = new BookRecViewAdapter(this, ACTIVITY_NAME);

        adapter.setBooks(Utils.getInstance(this).getAllBooksList());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}