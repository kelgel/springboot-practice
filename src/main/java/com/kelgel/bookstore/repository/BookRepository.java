package com.kelgel.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kelgel.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    //	Book 엔티티를 위한 Repository 인터페이스 정의
    // 	Book 엔티티를 다루고, 기본키(id 필드)는 Long 타입임을 명시함
}
