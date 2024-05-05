import java.time.Year;

public class Book {
    String title;
    String author;
    int page;
    int publisDate;


    public Book(String title, String author, int page, int year) {
        this.title = title;
        this.author = author;
        this.page = page;
        this.publisDate = year;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPublisDate() {
        return this.publisDate;
    }

    public void setPublisDate(int publisDate) {
        this.publisDate = publisDate;
    }

}
