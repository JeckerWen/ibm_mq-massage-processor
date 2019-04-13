package com.aistrong.hnyc_codecenter.task.entity;

public class Book {
    private long bookId;
    private String name;
    private int number;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "bookId:" + this.getBookId() + " name" + this.getName() + " number:" + this.getName();
    }
}
