package com.kelgel.bookstore.controller;

import com.kelgel.bookstore.domain.Book;
import com.kelgel.bookstore.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class BookController {
    private final BookRepository bookRepository; // DB와 연결된 BookRepository를 필드로 선언

    // @Autowired 대신에 생성자 주입
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 관리자용 책 목록 가져오기
    @GetMapping("/admin/books")
    public String getBookList(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books",books);
        return "bookList";
    }

    // 관리자용 책 등록 GET
    @GetMapping("/admin/books/new")
    public String showCreateForm(Model model){
        model.addAttribute("book", new Book()); // 빈 Book 객체를 폼에 바인딩
        return "bookForm";
    }

    // 관리자용 책 등록 POST
    @PostMapping("/admin/books/new")
    public String createBook(@ModelAttribute Book book) { // 폼에서 넘어온 값을 Book 객체로 자동 바인딩
        bookRepository.save(book);
        return "redirect:/admin/books";
    }

    //관리자용 책 수정
    @GetMapping("/admin/books/edit/{id}")
    public String showEditForm(@PathVariable Long id,  Model model) {
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "bookForm";
    }

    //관리자용 책 수정
    @PostMapping("/admin/books/edit/{id}")
    public String showEditForm(@PathVariable Long id,  @ModelAttribute  Book book) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/admin/books";
    }

    //관리자용 책 삭제
    @GetMapping("/admin/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/admin/books";
    }
}
