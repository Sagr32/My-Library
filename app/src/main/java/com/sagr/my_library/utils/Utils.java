package com.sagr.my_library.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sagr.my_library.models.Book;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private SharedPreferences sharedPreferences;

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";



    public Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("books_db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getAllBooksList() == null) {
            initData();
        }
        if (getCurrentlyReadingList() == null) {
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<>()));
            editor.commit();

        }
        if (getAlreadyReadList() == null) {
            editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<>()));
            editor.commit();
        }
        if (getFavouriteList() == null) {
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<>()));
            editor.commit();
        }
        if (getWantToReadList() == null) {
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<>()));
            editor.commit();
        }
    }


    void initData() {
        ArrayList<Book> books = new ArrayList<>();
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books.add(new Book(1, "Eloquent JavaScript, Third Edition", "https://images-na.ssl-images-amazon.com/images/I/51InjRPaF7L._SX377_BO1,204,203,200_.jpg", "A Modern Introduction to Programming", "JavaScript lies at the heart of almost every modern web application, from social apps like Twitter to browser-based game frameworks like Phaser and Babylon. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.", "Marijn Haverbeke", 472));
        books.add(new Book(2, "Practical Modern JavaScript", "https://images-na.ssl-images-amazon.com/images/I/51LHTs-4ziL._SX331_BO1,204,203,200_.jpg", "Dive into ES6 and the Future of JavaScript", "To get the most out of modern JavaScript, you need learn the latest features of its parent specification, ECMAScript 6 (ES6). This book provides a highly practical look at ES6, without getting lost in the specification or its implementation details.",
                "Nicolás Bevacqua", 334));
        books.add(new Book(3, "Understanding ECMAScript 6", "https://images-na.ssl-images-amazon.com/images/I/817f4ZWXjhL.jpg", "The Definitive Guide for JavaScript Developers", "ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that ECMAScript 6 brings to JavaScript.",
                "Nicholas C. Zakas", 352));
        books.add(new Book(4, "Speaking JavaScript", "https://images-na.ssl-images-amazon.com/images/I/91sXL7wrjgL.jpg", "An In-Depth Guide for Programmers", "Like it or not, JavaScript is everywhere these days -from browser to server to mobile- and now you, too, need to learn the language or dive deeper than you have. This concise book guides you into and through JavaScript, written by a veteran programmer who once found himself in the same position.",
                "O'Reilly Media", 460));
      editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
      editor.commit();
    }

    public  ArrayList<Book> getAllBooksList() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadingList() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadList() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null), type);
        return books;
    }

    public  ArrayList<Book> getFavouriteList() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS, null), type);
        return books;
    }

    public  ArrayList<Book> getWantToReadList() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null), type);
        return books;
    }



    public boolean addToCurrentlyRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadingList();
        if(books != null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavourite(Book book) {
        ArrayList<Book> books = getFavouriteList();
        if(books !=null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }



        return false;
    }

    public boolean addToWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadList();
        if(books !=null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return true;
            }
        }

        return false;
    }

    public boolean addToAlreadyReady(Book book) {
        ArrayList<Book> books = getAlreadyReadList();
        if(books !=null){
            if(books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS,gson.toJson(books));
                editor.commit();
                return  true;
            }
        }
        return false;
    }


    public static Utils getInstance(Context context) {
        if (instance == null) {
            instance = new Utils(context);
        }
        return instance;
    }

    public Book getBookById(int bookId) {
        for (Book b : getAllBooksList()) {
            if (b.getId() == bookId) {
                return b;
            }
        }
        return null;
    }

    public boolean existInList(Book book, ArrayList<Book> list) {
        for (Book b : list) {
            if (b.getId() == book.getId()) {
                return true;
            }
        }
        return false;
    }



    public boolean removeFromAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadList();
        if (null != books) {
            for (Book b: books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromWantToRead (Book book) {
        ArrayList<Book> books = getWantToReadList();
        if (null != books) {
            for (Book b: books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromCurrentlyReading (Book book) {
        ArrayList<Book> books = getCurrentlyReadingList();
        if (null != books) {
            for (Book b: books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromFavorites (Book book) {
        ArrayList<Book> books = getFavouriteList();
        if (null != books) {
            for (Book b: books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
