import java.util.Comparator;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        Book book1 = new Book("Saatleri Ayarlama Enstitüsü", 352, "Ahmet Hamdi Tanpınar", 1961);
        Book book2 = new Book("Kuyucaklı Yusuf", 208, "Sabahattin Ali", 1937);
        Book book3 = new Book("Vurun Kahpeye", 240, "Halide Edip Adıvar", 1926);
        Book book4 = new Book("Hanımın Çiftliği", 232, "Orhan Kemal", 1940);
        Book book5 = new Book("Memleket Hikayeleri", 200, "Refik Halit Karay", 1919);


        TreeSet<Book> alphabook =new TreeSet<>();

        alphabook.add(book1);
        alphabook.add(book2);
        alphabook.add(book3);
        alphabook.add(book4);
        alphabook.add(book5);

        

        TreeSet<Book> pageBooks = new TreeSet<>(new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
               return (o1.getPageNumber()-o2.getPageNumber())*-1;
            }
                
            
        });
        for (Book book : alphabook) {
            System.out.println(book.getName());
            pageBooks.add(book);
        }
       
        System.out.println("Sayfa sıransına göre##################");
        for (Book book : pageBooks) {
            System.out.println(book.getName());
        }



    }
}
