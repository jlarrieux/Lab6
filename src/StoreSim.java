//--------------------------------------------------------------------
//
//  Laboratory 6, In-lab Exercise 3                    StoreSim.jshl
//
//  (Shell) Store simulation program
//
//  The student is to complete all missing or incomplete method
//     implementations for this class
//
//--------------------------------------------------------------------

// Simulates the flow of customers through a line in a store.

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

class StoreSim {


    public static void main(String args[]) throws IOException {
        Queue custQ = new AQueue(); // Line (queue) of customers containing
        //   the time that each customer arrived
        //   and joined the line
        Random rand                  // Initialize random number generator
                = new Random(System.currentTimeMillis());   // seed is system
        // clocktime to limit
        // sequence repetition

        int simLength,              // Length of simulation (minutes)
                minute,                 // Current minute
                timeArrived,            // Time dequeued customer arrived
                waitTime,               // How long dequeued customer waited
                totalServed = 0,        // Total customers served
                totalWait = 0,        // Total waiting time for all customers
                maxWait = 0,        // Longest wait
                numArrivals = 0,        // Number of new arrivals
                j;                      // Loop counter


        // Value read in as one of main's args[]
        // which will simplify redirecting the output to a file

        simLength = Integer.parseInt(args[0]);

        System.out.println("\nNumber of minutes the Simulator will run: "
                + simLength);
        Customer current;


        for (minute = 0; minute < simLength; minute++) {
            // Output time & number of customers waiting in line


            // Dequeue the first customer in line (if any). Increment
            // totalServed, add the time that this customer waited to
            // totalWait, and update maxWait if this customer waited
            // longer than any previous customer.


            if(!custQ.isEmpty()){
                current= (Customer) custQ.dequeue();
                totalServed++;
                waitTime =minute - current.getMinuteInserted();
                if(waitTime> maxWait) maxWait=waitTime;
                totalWait = totalWait + (waitTime);


            }

            // Determine the number of new customers.
            // Uses a random number generator.

            switch (rand.nextInt(4))  // Randomly generate a number
            // from 0 to 3
            {
                case 1: custQ.enqueue(new Customer(minute));
                        break;
                case 2: custQ.enqueue(new Customer(minute));
                        custQ.enqueue(new Customer(minute));
                        break;



            }

            // Add the new customers to the line
            // set precision to 2 decimal places
            DecimalFormat fmt = new DecimalFormat("0.##");
            System.out.println("\nCustomers served : " + totalServed);
            System.out.println("Average wait     : " + fmt.format((double) totalWait / totalServed));
            System.out.println("Longest wait     : " + maxWait);


        }





    } // main





} // class StoreSim