package com.sagr.my_library.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sagr.my_library.R;
import com.sagr.my_library.activities.AllBooksActivity;
import com.sagr.my_library.activities.AlreadyReadActivity;
import com.sagr.my_library.activities.BookDetailsActivity;
import com.sagr.my_library.activities.CurrentlyReadActivity;
import com.sagr.my_library.activities.FavouriteActivity;
import com.sagr.my_library.activities.WantToReadActivity;
import com.sagr.my_library.models.Book;
import com.sagr.my_library.utils.Utils;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.BookViewHolder> {

    private ArrayList<Book> books = new ArrayList<>();
    private final Context mContext;
    private final String parentName;

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public BookRecViewAdapter(Context mContext, String parentName) {
        this.mContext = mContext;
        this.parentName = parentName;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.book_list, null);
        BookViewHolder bookViewHolder = new BookViewHolder(view);
        bookViewHolder.cardView.setOnClickListener((View v) -> {
            Intent intent = new Intent(parent.getContext(), BookDetailsActivity.class);
            intent.putExtra(BookDetailsActivity.BOOK_ID_KEY, books.get(bookViewHolder.getAdapterPosition()).getId());
            parent.getContext().startActivity(intent);
        });

        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        holder.bookName.setText(books.get(holder.getAdapterPosition()).getBookName());
        holder.authorName.setText(books.get(holder.getAdapterPosition()).getAuthorName());
        holder.totalPages.setText(String.valueOf(books.get(holder.getAdapterPosition()).getPages()));
        holder.shortDesc.setText(books.get(holder.getAdapterPosition()).getShortDesc());
        holder.longDesc.setText(books.get(holder.getAdapterPosition()).getLongDesc());


        Glide.with(mContext)
                .load(books.get(holder.getAdapterPosition()).getImageUrl())
                .error(R.drawable.ic_error)
                .into(holder.bookImage);

        if (books.get(holder.getAdapterPosition()).isExpanded()) {
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.btnUpArrow.setVisibility(View.VISIBLE);
            holder.btnDownArrow.setVisibility(View.GONE);

        } else {
            holder.expandedLayout.setVisibility(View.GONE);
            holder.btnUpArrow.setVisibility(View.GONE);
            holder.btnDownArrow.setVisibility(View.VISIBLE);

        }
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        switch (parentName) {
            case AllBooksActivity.ACTIVITY_NAME:
                holder.btnDelete.setVisibility(View.GONE);
                break;

            case AlreadyReadActivity
                    .ACTIVITY_NAME:
                holder.btnDelete.setOnClickListener((View v) -> {
                    builder.setMessage("Are you sure you want to delete " + books.get(holder.getAdapterPosition()).getBookName() + "?");
                    builder.setNegativeButton("No", (dialog, which) -> {

                    });
                    builder.setPositiveButton("Yes", (dialog, which) -> {
                        Utils.getInstance(mContext).removeFromAlreadyRead(books.get(holder.getAdapterPosition()));
                        notifyDataSetChanged();
                        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
                    });
                    builder.create().show();


                });

                break;
            case CurrentlyReadActivity
                    .ACTIVITY_NAME:
                holder.btnDelete.setOnClickListener((View v) -> {
                    builder.setMessage("Are you sure you want to delete " + books.get(holder.getAdapterPosition()).getBookName() + "?");
                    builder.setNegativeButton("No", (dialog, which) -> {

                    });
                    builder.setPositiveButton("Yes", (dialog, which) -> {
                        Utils.getInstance(mContext).removeFromCurrentlyReading(books.get(holder.getAdapterPosition()));
                        notifyDataSetChanged();
                        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();

                    });
                    builder.create().show();


                });

                break;
            case FavouriteActivity
                    .ACTIVITY_NAME:
                holder.btnDelete.setOnClickListener((View v) -> {
                    builder.setMessage("Are you sure you want to delete " + books.get(holder.getAdapterPosition()).getBookName() + "?");
                    builder.setNegativeButton("No", (dialog, which) -> {

                    });
                    builder.setPositiveButton("Yes", (dialog, which) -> {
                        Utils.getInstance(mContext).removeFromFavorites(books.get(holder.getAdapterPosition()));
                        notifyDataSetChanged();
                        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();


                    });
                    builder.create().show();


                });
                break;
            case WantToReadActivity
                    .ACTIVITY_NAME:

                holder.btnDelete.setOnClickListener((View v) -> {
                    builder.setMessage("Are you sure you want to delete " + books.get(holder.getAdapterPosition()).getBookName() + "?");
                    builder.setNegativeButton("No", (dialog, which) -> {

                    });
                    builder.setPositiveButton("Yes", (dialog, which) -> {

                        Utils.getInstance(mContext).removeFromWantToRead(books.get(holder.getAdapterPosition()));
                        notifyDataSetChanged();
                        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();

                    });
                    builder.create().show();


                });
                break;
        }


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView bookName, authorName, shortDesc, longDesc, totalPages, btnDelete;
        private final ImageView bookImage, btnUpArrow, btnDownArrow;
        private final RelativeLayout collapsedLayout, expandedLayout;


        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.txtBookName);
            bookImage = itemView.findViewById(R.id.imgBookImage);
            authorName = itemView.findViewById(R.id.txtAuthor);
            shortDesc = itemView.findViewById(R.id.txtShortDesc);
            longDesc = itemView.findViewById(R.id.txtLongDesc);
            totalPages = itemView.findViewById(R.id.txtPages);
            btnUpArrow = itemView.findViewById(R.id.btnUpArrow);
            btnDownArrow = itemView.findViewById(R.id.btnDownArrow);
            collapsedLayout = itemView.findViewById(R.id.collapsedLayout);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);
            cardView = itemView.findViewById(R.id.cardView);
            btnDelete = itemView.findViewById(R.id.txtDelete);

            btnDownArrow.setOnClickListener((View v) -> {
                Book book = books.get(getAdapterPosition());
                book.setExpanded(!book.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
            btnUpArrow.setOnClickListener((View v) -> {
                Book book = books.get(getAdapterPosition());
                book.setExpanded(!book.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });

        }
    }
}
