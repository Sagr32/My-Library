package com.sagr.my_library.models;

public class Book {
    private int id;
    private String bookName;
    private String imageUrl;
    private String shortDesc;
    private String longDesc;
    private String authorName;
    private int pages;

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    private boolean isExpanded;
    public Book(int id, String bookName, String imageUrl, String shortDesc, String longDesc, String authorName, int pages) {
        this.id = id;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.authorName = authorName;
        this.pages = pages;
        isExpanded = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
