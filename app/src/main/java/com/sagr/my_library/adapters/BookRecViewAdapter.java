package com.sagr.my_library.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sagr.my_library.R;
import com.sagr.my_library.models.Book;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.BookViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.book_list,null);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        holder.bookName.setText(books.get(holder.getAdapterPosition()).getBookName());
        Glide.with(mContext)
                .load(books.get(holder.getAdapterPosition()).getImageUrl())
                .error(R.drawable.ic_error)
                .into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private TextView bookName;
        private ImageView bookImage;
      public BookViewHolder(@NonNull View itemView) {
          super(itemView);
          bookName = itemView.findViewById(R.id.txtBookName);
          bookImage = itemView.findViewById(R.id.imgBookImage);
      }
  }
}
