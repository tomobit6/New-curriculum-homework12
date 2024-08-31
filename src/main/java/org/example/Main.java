package org.example;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    //図書管理システムを作る。
    //書籍（book)を管理する情報（タイトル、著者、番号）を持つオブジェクト（クラス）を作って、そこに情報を格納する。
    //図書館（library)みたいなものを作って、そこにbookをListでもつようなものを保持する。
    //mainめそっどからこのライブラリークラスに対して本の検索ができるようにする。ライブラリークラスは書籍検索の機能を持つ。
    //タイトル検索、著者検索、番号検索メソッドをlibraryにもたせる。
    //それをmainメソッドで実行する。
    Book book1 = new Book("ノルウェイの森", "村上春樹", 1);
    Book book2 = new Book("そして誰もいなくなった", "アガサ・クリスティ", 2);
    Book book3 = new Book("罪と罰", "フョードル・ドストエフスキー", 3);
    Book book4 = new Book("百年の孤独", "ガブリエル・ガルシア＝マルケス", 4);
    Book book5 = new Book("老人と海", "アーネスト・ヘミングウェイ", 5);
    Book book6 = new Book("罪の名前", "木原音瀬", 6);
    Book book7 = new Book("1Q84", "村上春樹", 7);
    Book book8 = new Book("8050", "林真理子", 8);

    List<Book> bookList = List.of(book1, book2, book3, book4, book5, book6, book7, book8);

    //インスタンス生成
    Library library = new Library(bookList);

    Scanner scanner = new Scanner(System.in);
    String bookInformation;

    while (true) {  // 無限ループを開始
      System.out.print("検索するキーワードを入力してください。： ");
      bookInformation = scanner.nextLine();

      if (bookInformation.isEmpty()) {
        System.out.println("入力がありませんでした。再度入力してください。");
      } else {
        break; //入力が正しい場合は抜ける。
      }
    }
    //Setは同じ値を持てない＝重複する情報は１つだけ表示できる。addAllメソッドで複数の値をまとめて追加。
    Set<Book> searchResults = new LinkedHashSet<>();
    searchResults.addAll(library.findByTitle(bookInformation));
    searchResults.addAll(library.findByAuthor(bookInformation));

    try {
      int bookNumber = Integer.parseInt(bookInformation);
      searchResults.addAll(library.findByNumber(bookNumber));
    } catch (NumberFormatException e) {
      // 数字ではなかった場合はスキップ
    }

    if (searchResults.isEmpty()) {
      System.out.println("該当する本が見つかりませんでした。");
    } else {
      System.out.println("検索結果: " + searchResults.size() + " 件が見つかりました。");
      for (Book book : searchResults) {
        System.out.println("------------------------------------");
        System.out.println("本のタイトル：" + book.getTitle());
        System.out.println("著者名：" + book.getAuthor());
        System.out.println("番号：" + book.getNumber());
      }
    }
  }
}
