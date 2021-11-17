package controller;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import object.Book;

public class BookController {
	BookDao bookDao;

	public BookController() {
		bookDao = BookDao.getInstance();

	}

	// list 출력
	private void printList(List<Book> bookList) {
		System.out.println("=======================================");
		System.out.println("\t\t도서 리스트");

		for (Book b : bookList) {
			System.out.println("---------------------------------------");
			b.showInfo();
		}

		System.out.println("=======================================\n");
	}

	// 전체 목록 출력
	public void showAll() {
		List<Book> bookList = bookDao.selectAllList();
		printList(bookList);
	}

	// 카테고리 번호로 검색
	public void selectByCategory(int categoryId) {
		List<Book> bookList = bookDao.selectByCategory(categoryId);
		printList(bookList);
	}

	// 책의 제목으로 검색
	public void selectByName(String bookName) {
		List<Book> bookList = bookDao.selectByBookName(bookName);
		printList(bookList);
	}

	// 책의 저자명으로 검색
	public void selectByWriter(String writer) {
		List<Book> bookList = bookDao.selectByWriter(writer);
		printList(bookList);
	}

	// 출판사명으로 검색
	public void selectByPublisher(String publisher) {
		List<Book> bookList = bookDao.selectByPublisher(publisher);
		printList(bookList);
	}
	
	// 도서 등록 메소드
	public void insertBook(Book book) {
		bookDao.insertBook(book);
	}

	// 도서 정보를 수정하는 메소드
	public void editBook(Book book) {
		bookDao.editBook(book);
	}

	// 도서 정보를 삭제하는 메소드
	public void deleteBook(int bookid) {
		bookDao.deleteBook(bookid);
	}

	// 책 구입 메소드(오버로딩) -- 지명근
	public boolean buyBook(int bookId) {
		boolean result = false;

		// 책 재고확인
		if (bookDao.isThereBook(bookId)) {
			result = true; // 남아있을시 구입
			bookDao.saleBook(bookId);
		} 

		return result;
	}

	// 책 구입 메소드(오버로딩) - 책제목으로
	public boolean buyBook(String bookName) {
		boolean result = false;
		int bookId = bookDao.getBookId(bookName);
		
		// 책 재고확인 후 재고가 있으면 구입
		if (bookDao.isThereBook(bookId)) {
			result = true; // 남아있을시 구입
			bookDao.saleBook(bookId);
		} 
		
		return result;
	}

	// 유저 책 구매내역
//	public void userOrderDetail() {
//		List<Book> bookList = bookDao.printUserOrders();
//
//		if (bookList == null) {
//			System.out.println("구입하신 책이 없습니다.");
//
//		} else {
//			for (Book b : bookList) {
//				System.out.println("책이름 : " + b.getBookName() + ", 가격 : " + b.getPrice() + ", 지은이 : " + b.getWriter()
//						+ ", 출판사 : " + b.getPublisher());
//			}
//		}
//
//	}

	// 랜덤 도서 추천
	public void showRandomBook() {
		Book book = bookDao.randomBook();
		System.out.println("서점에 있는 책 중에서 무작위로 추천드리겠습니다.");
		System.out.println("==================================================");
		book.showInfo();
		System.out.println("==================================================\n");
	}

}
