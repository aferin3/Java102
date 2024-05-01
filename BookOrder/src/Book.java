

public class Book implements Comparable<Book>{
    String name;
    int pageNumber;
    String author;
    int PublishDate;
    
    

    public Book(String name, int pageNumber, String author, int publishdate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.PublishDate = publishdate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return this.PublishDate;
    }

    public void setPublishDate(int PublishDate) {
        this.PublishDate = PublishDate;
    }

    @Override
    public int compareTo(Book book) {
        

        return this.name.compareTo(book.name);

        
    }
    
    
    
    

}
