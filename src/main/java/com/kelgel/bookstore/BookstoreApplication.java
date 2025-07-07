package com.kelgel.bookstore;

import com.kelgel.bookstore.domain.Book;
import com.kelgel.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @Configuration, @EnableAutoConfiguration, @ComponentScan
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) { // 앱 실행 시작점 (Spring Boot 전체 시작)
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) { // 앱이 완전히 시작된 후에 자동으로 실행되는 코드
//		Book book = new Book(null, "Clean Code", "Robert C. Martin", 33000, "인사이트","개발자 코드 품질 개선서");
//		bookRepository.save(book);

		System.out.println("✅ 저장된 책 목록:");
		bookRepository.findAll().forEach(System.out::println);
	}

}
