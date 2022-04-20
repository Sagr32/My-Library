package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sagr.my_library.R;
import com.sagr.my_library.models.Book;

public class BookDetailsActivity extends AppCompatActivity {


    private ImageView bookImage;
    private Button addToCurrentlyReading,addToFavourites,addToWantToRead,addToAlreadyRead;
    private TextView bookName,bookAuthor,bookDescription,pagesCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        initViews();
        Book book = new Book(1,"Eloquent JavaScript, Third Edition","https://images-na.ssl-images-amazon.com/images/I/51InjRPaF7L._SX377_BO1,204,203,200_.jpg","A Modern Introduction to Programming","JavaScript lies at the heart of almost every modern web application, from social apps like Twitter to browser-based game frameworks like Phaser and Babylon. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.","Marijn Haverbeke",472);
        setData(book);

    }

    private void  initViews(){
        bookImage = (ImageView) findViewById(R.id.imgBookImage);
        addToCurrentlyReading =(Button) findViewById(R.id.btnAddToCurrentlyReading);
        addToFavourites =(Button) findViewById(R.id.btnAddToFavourites);
        addToWantToRead =(Button) findViewById(R.id.btnAddToWantToRead);
        addToAlreadyRead =(Button) findViewById(R.id.btnAddToAlreadyRead);
        bookName = (TextView) findViewById(R.id.txtBookName);
        bookAuthor =(TextView) findViewById(R.id.txtAuthor);
        bookDescription =(TextView) findViewById(R.id.txtDesc);
        pagesCount = (TextView)findViewById(R.id.txtPagesCount);
    }

   private void setData(Book book){

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