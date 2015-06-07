//--------------------------------------------------------------------
//
//  Laboratory 6                                          AQueue.jshl
//
//  Class definition for the array implementation of the Queue ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------



class AQueue implements Queue               // Array-based queue class
{


    // Data members
    private int maxSize;        // Maximum number of elements in the queue
    private int front =-1;          // Index of the front element
    private int rear =-1;           // Index of the rear element
    private Object[] element;  // Array containing the queue elements
    private int currentSize=0;


    // Constructors
    public AQueue()               // Constructor: default size
    {
        setup(defMaxQueueSize);
    }


    public AQueue(int size)      // Constructor: sets size
    {
        if(size==0) System.out.printf("Attempting to create a Queue with no size!\n");
        else setup(size);
    }


    // Class methods
    private void setup(int size)    // Called by Constructors only
    {
        element = new Object[size];
        maxSize = size;

    }

    // Queue manipulation operations
    //----- Insert method implementations for the interface Queue here -----//


    @Override
    public void enqueue(Object newElement) {
        if(isFull()) System.out.printf("Cannot Add element to Full Queue!\n");
        else if(newElement==null) System.out.println("Attempting to insert a null element!\n");
        else{
//            System.out.printf("Enqueuing: %s at position %d\n", String.valueOf(newElement), (rear+1)%maxSize);
            if(isEmpty()){
                front++;
                rear++;
            }
            else rear=(rear+1)%maxSize;
            element[rear]=newElement;
            currentSize++;
//            System.out.printf("Rear after: %d\n", rear);

        }

    }


    @Override
    public Object dequeue() {
        if( isEmpty()) return null;
        else {
            Object obj = new Object();
            obj = element[front];
            if(front==rear){
                front=-1;
                rear=-1;
            }
            else front=(front+1)%maxSize;
            currentSize--;
//            System.out.printf("New front: %d\t\t with rear: %d\n", front, rear);
            return obj;
        }
    }


    @Override
    public void clear() {

    }


    @Override
    public boolean isEmpty() {
        if(front==-1) return true;
        else return false;
    }


    @Override
    public boolean isFull() {
//        System.out.printf("Front: %d\t\trear: %d\t\tmod-front: %d\t\tmod-rear: %d\n", front,rear,front%maxSize, rear%maxSize );
        if((rear+1)%maxSize== front ) return true;

        else return false;
    }


    public void showStructure()
    // Array implementation. Outputs the elements in a queue. If the
    // queue is empty, outputs "Empty queue". This operation is intended
    // for testing and debugging purposes only.
    {
        int j;   // Loop counter

        if (isEmpty())
            System.out.println("Empty queue");
        else {
//            System.out.println("front = " + front + "  rear = " + rear);
            for (j = 0; j < maxSize; j++)  System.out.print(j + "\t");
            System.out.println();
            if (rear >= front)
                for (j = 0; j < maxSize; j++)
                    if ((j >= front) && (j <= rear))
                        System.out.print(element[j] + "\t");
                    else
                        System.out.print(" \t");
            else
                for (j = 0; j < maxSize; j++)
                    if ((j >= front) || (j <= rear))
                        System.out.print(element[j] + "\t");
                    else
                        System.out.print(" \t");
//            System.out.printf("Length: %d\n", element.length);
            System.out.println();
        }
    } // showStructure for AQueue

    // In-lab operations
    // These methods are NOT included in the interface Queue.
    // Since compiler errors will occur before some of these methods
    //   are implemented, they have been temporarily commented out.
    // Remove the comment delimeters '/*' and '*/' once these methods
    //   are implemented.

    public void putFront ( Object newElement )  // Insert at front
    {
        int oldPosition;
        if(isFull())System.out.println("Attempting to insert element in a full queue!\n");
        else if(newElement==null) System.out.println("Attempting to insert null element!\n");
        else {
            if(isEmpty()) enqueue(newElement);
            else {
                rear=(rear+1)%maxSize;
                System.out.printf("Rear: %d\n", rear);
                for(int i =rear; i!=(front)%maxSize; i=(i-1)%maxSize) {
                    oldPosition =(i-1)%maxSize;
                    element[i] = element[oldPosition];
                    System.out.printf("Inserted at position %d, the value  %s that was at position %d\n", i, String.valueOf(element[oldPosition]), oldPosition);
                }
                element[front] = newElement;
            }

        }

    }
    public Object getRear ( )                   // Get from rear
    {
        if(isEmpty()){
            System.out.println("Attempting to dequeue an empty queue! \n");
            return null;
        }
        else{
            Object obj = new Object();
            obj = element[rear];
            if(front==rear){
                front=-1;
                rear=-1;
            }
            else rear =(rear-1)%maxSize;

            return element[rear];
        }
    }
    public int length ( )                       // Number of elements
    {
       return currentSize;
    }




} // class AQueue