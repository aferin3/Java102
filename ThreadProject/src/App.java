import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    static final int SIZE = 1000;
    static final int PART_SIZE = SIZE / 4;
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> nums = new ArrayList<>();
        

        for(int i = 1 ; i<=SIZE; i++){
            nums.add(i);
        }
        List<Integer> evenNums = new ArrayList<>();
        List<Integer> oddNums = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(4);
        

        for (int i = 0; i < 4; i++) {
            int start = i * PART_SIZE;
            int end = start + PART_SIZE;
            service.submit(new ListNums(nums.subList(start, end), evenNums, oddNums));
        }
        // threadpool kapatılır
        service.shutdown();
        try {
            // ThreadPool'in tüm işlerini bitirmesini bekleyin
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(oddNums);
    }
}
