package com.learning.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "EDITION")
    private String edition;

    @ElementCollection
    @CollectionTable(name = "author", joinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Author> authors = new HashSet<>();

    private Book() { //for JPA
    }

    public Book(long id, String title, String edition, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.edition = edition;
        this.authors = authors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                +'\'' +
                '}';
    }
}
