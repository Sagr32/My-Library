package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sagr.my_library.R;
import com.sagr.my_library.adapters.BookRecViewAdapter;
import com.sagr.my_library.models.Book;

import java.util.ArrayList;

public class WantToReadActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookRecViewAdapter adapter;
    private ArrayList<Book> books = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read);
        recyclerView = findViewById(R.id.booksRecView);
        adapter = new BookRecViewAdapter(this);
//        books.add(new Book(1,"Eloquent JavaScript, Third Edition","https://images-na.ssl-images-amazon.com/images/I/51InjRPaF7L._SX377_BO1,204,203,200_.jpg","A Modern Introduction to Programming","JavaScript lies at the heart of almost every modern web application, from social apps like Twitter to browser-based game frameworks like Phaser and Babylon. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.","Marijn Haverbeke",472));
//        books.add(       new Book(2,"Practical Modern JavaScript","https://images-na.ssl-images-amazon.com/images/I/51LHTs-4ziL._SX331_BO1,204,203,200_.jpg","Dive into ES6 and the Future of JavaScript","To get the most out of modern JavaScript, you need learn the latest features of its parent specification, ECMAScript 6 (ES6). This book provides a highly practical look at ES6, without getting lost in the specification or its implementation details.",
//                "Nicolás Bevacqua",334));
        books.add(new Book(3,"Understanding ECMAScript 6","https://images-na.ssl-images-amazon.com/images/I/817f4ZWXjhL.jpg","The Definitive Guide for JavaScript Developers","ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that ECMAScript 6 brings to JavaScript.",
                "Nicholas C. Zakas",352   ));
        books.add(new Book(4,"Speaking JavaScript","https://images-na.ssl-images-amazon.com/images/I/91sXL7wrjgL.jpg","An In-Depth Guide for Programmers","Like it or not, JavaScript is everywhere these days -from browser to server to mobile- and now you, too, need to learn the language or dive deeper than you have. This concise book guides you into and through JavaScript, written by a veteran programmer who once found himself in the same position.",
                "O'Reilly Media",460));
        adapter.setBooks(books);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}