package com.sagr.my_library.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sagr.my_library.R;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

public class BookDetailsActivity extends AppCompatActivity {


    private ImageView bookImage;
    private Button addToCurrentlyReading,addToFavourites,addToWantToRead,addToAlreadyRead;
    private TextView bookName,bookAuthor,bookDescription,pagesCount;
    public static String BOOK_ID_KEY = "book_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        initViews();
        Intent intent = getIntent();
        if(intent !=null){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId != -1){
                setData(Utils.getInstance().getBookById(bookId));
            }

        }



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