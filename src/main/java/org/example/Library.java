package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

  List<Book> books;

  public Library(List<Book> books) {
    this.books = books;
  }

  //bookList に含まれる Book オブジェクトの中から、指定された title を含む本を見つけて、
  // その結果を result というリストに追加する処理を行っている。
  public List<Book> findByTitle(String title) {
    List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getTitle().contains(title)) {
        result.add(book);
      }
    }
    return result;
  }

  public List<Book> findByAuthor(String author) {
    List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getAuthor().contains(author)) {
        result.add(book);
      }
    }
    return result;
  }

  public List<Book> findByNumber(int number) {
    List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getNumber() == number) {
        result.add(book);
      }
    }
    return result;
  }
}
