/**
 * Created by Jeannius on 6/7/2015.
 */
public class Customer {
    private int  totalWait=0;
    private int minuteInserted;

    public Customer(int minuteInserted){
        this.minuteInserted = minuteInserted;
    }

    public int getTotalWait(){
        return totalWait;
    }

    public void incrementTotalWait(int increment){
        totalWait = totalWait+ increment;
    }
    public int getMinuteInserted(){
        return this.minuteInserted;
    }


}
