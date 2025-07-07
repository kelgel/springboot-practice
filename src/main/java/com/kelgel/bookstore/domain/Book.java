package com.kelgel.bookstore.domain;

import lombok.*; // 롬복으로 getter/setter 생성
import jakarta.persistence.*;  // JPA 어노테이션

@Entity // 이 클래스가 DB 테이블로 매핑됨
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Book {

    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    private String title;
    private String author;
    private int price;
    private String publisher;
    private String description;
}
