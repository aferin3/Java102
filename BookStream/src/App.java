
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Book> books = new ArrayList<>();
        String[] titles = {"The Great Gatsby", "To Kill a Mockingbird", "1984", "The Catcher in the Rye", "Animal Farm", "The Hobbit", "Brave New World", "The Lord of the Rings", "Pride and Prejudice", "The Alchemist"};
        String[] authors = {"F. Scott Fitzgerald", "Harper Lee", "George Orwell", "J.D. Salinger", "George Orwell", "J.R.R. Tolkien", "Aldous Huxley", "J.R.R. Tolkien", "Jane Austen", "Paulo Coelho"};
        int[] dates = {1925, 1960, 1949, 1951, 1945, 1937, 1932, 1954, 1813, 1988};
        int[] pageCounts = {218, 324, 328, 224, 112, 304, 288, 1178, 432, 208};

        for(int i =0 ; i<10; i++){
            books.add(new Book(titles[i], authors[i], pageCounts[i],dates[i]));
        }

        Map<String,String> titleAuthorMap = new LinkedHashMap<>();

        books.stream().forEach(i -> titleAuthorMap.put(i.getTitle(), i.getAuthor()));

        ArrayList<Book> overPage400 = new ArrayList<>();

        books.stream().filter(i -> i.getPage() > 400).forEach(i -> overPage400.add(i));;

        overPage400.stream().forEach(i -> System.out.println(i.getTitle()+ " " + i.getPage()));



        
        
       

     

        
        
    }
}
