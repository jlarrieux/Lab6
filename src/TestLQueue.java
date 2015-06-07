import java.io.IOException;

/**
 * Created by Jeannius on 6/7/2015.
 */
public class TestLQueue {
    public static void main(String args[]) throws IOException
    {
        Queue testQueue = new LQueue(8);        // Test queue of char
        char testElement = 'x';                 // Queue element
        char cmd = 'x';                         // Input command

        System.out.println("\nCommands:");
        System.out.println("  +x : Enqueue x");
        System.out.println("  -  : Dequeue");
        System.out.println("  C  : Clear the queue");
        System.out.println("  E  : Empty queue?");
        System.out.println("  F  : Full queue?");
        System.out.println
                ("  >x : Put x at front    (Inactive : In-lab Exercise 1)");
        System.out.println
                ("  =  : Get x from rear   (Inactive : In-lab Exercise 1)");
        System.out.println
                ("  #  : Length            (Inactive : In-lab Exercise 2)");
        System.out.println("  Q  : Quit the test program");
        System.out.println();

        do
        {
            testQueue.showStructure();                    // Output queue

            System.out.print("\nCommand: ");              // Read command
            cmd = (char)System.in.read();
            while (Character.isWhitespace(cmd))           // ignore whitespace
                cmd = (char)System.in.read();
            if ( cmd == '+'  ||  cmd == '>' )
            {
                testElement = (char)System.in.read();
                if (Character.isWhitespace(testElement))  // testElement is whitespace
                    System.out.print("Element to add: ");
                while (Character.isWhitespace(testElement))
                    testElement = (char)System.in.read(); // get valid testElement
            }

            switch ( cmd )
            {
                case '+' :                                 // enqueue
                    System.out.println("Enqueue " + testElement);
                    testQueue.enqueue(new Character(testElement));
                    break;

                case '-' :                                  // dequeue
                    System.out.println("Dequeued " + testQueue.dequeue());
                    break;

                case 'C' : case 'c' :                       // clear
                System.out.println("Clear the queue");
                testQueue.clear();
                break;

                case 'E' : case 'e' :                       // empty
                if ( testQueue.isEmpty() )
                    System.out.println("Queue is empty");
                else
                    System.out.println("Queue is NOT empty");
                break;

                case 'F' : case 'f' :                       // full
                if ( testQueue.isFull() )
                    System.out.println("Queue is full");
                else
                    System.out.println("Queue is NOT full");
                break;

                // Note: in the following three cases testQueue which is of
                //   type Queue must be typecast to AQueue since the methods
                //   putFront, getRear and length are not declared in the
                //   Queue interface

                case '>' :                              // In-lab Exercise 1
                    System.out.println("Put " + testElement + " in front ");
                    ((AQueue) testQueue).putFront(new Character(testElement));
                    break;

                case '=' :                              // In-lab Exercise 1
                    System.out.println
                            ("Got " + ((AQueue)testQueue).getRear() + " from rear ");
                    break;

                case '#' :                              // In-lab Exercise 2
                    System.out.println("Length = " + ((AQueue)testQueue).length());
                    break;

                case 'Q' : case 'q' :                   // Quit test program
                break;

                default :                               // Invalid command
                    System.out.println("Inactive or invalid command");
            }
        } while ( cmd != 'Q'  &&  cmd != 'q' );
    } // main

}
