package org.example;

public class Book {

  String title;
  String author;
  int number;

  public Book(String title, String author, int number) {
    this.title = title;
    this.author = author;
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getNumber() {
    return number;
  }
}
