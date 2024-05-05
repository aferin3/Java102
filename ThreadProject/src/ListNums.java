
import java.util.List;

public class ListNums implements Runnable{

    private final List<Integer> nums;
    private final List<Integer> evenList;
    private final List<Integer> oddList;
    

    public ListNums(List<Integer> nums, List<Integer> evenNums, List<Integer> oddNums) {
        this.nums = nums;
        this.evenList = evenNums;
        this.oddList = oddNums;
    }


    





    @Override
    public void run() {
        for(int i: nums){
            if(i%2 == 0){
                synchronized (evenList){
                    evenList.add(i);
                }
            } 
            else{
                synchronized (oddList){
                    oddList.add(i);
                }
            }
        }
        
    }


    

}
