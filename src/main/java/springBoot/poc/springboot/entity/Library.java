package springBoot.poc.springboot.entity;


import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long libraryId;

    @Column(name = "book_name")
    private String bookName;

    public long getLibraryId() { return libraryId; }

    public void setLibraryId(long libraryId) { this.libraryId = libraryId; }

    public String getBookName() { return bookName; }

    public void setBookName(String bookName) { this.bookName = bookName; }
}
