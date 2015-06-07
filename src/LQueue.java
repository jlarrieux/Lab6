//--------------------------------------------------------------------
//
//  Laboratory 6                                          LQueue.jshl
//
//  Class definitions for the linked list implementation of the
//  Queue ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------



class QueueNode                // Facilitator class for the Queue class
{


    // Data members
    private Object element;         // Queue element
    private QueueNode next;         // Pointer to the next element

    // because there are no access labels (public, private or protected),
    // access is limited to the package where these methods are declared


    // Constructor
    QueueNode(Object elem, QueueNode nextPtr) {
        this.element =elem;
        this.next = nextPtr;
    }


    // Class methods --
    // LQueue needs to know about next and element
    // must be able to set the nextPtr as needed
    QueueNode getNext() {
        return next;
    }


    void setNext(QueueNode nextPtr) {
        next = nextPtr;
    }


    Object getElement() {
        return element;
    }

} // Class QueueNode

//--------------------------------------------------------------------



class LQueue implements Queue {


    // Data members
    private QueueNode front,        // Reference to the front element
            rear;        // Reference to the rear element


    // Constructors
    public LQueue()               // Constructor: default
    {
        setup();
    }


    public LQueue(int size)      // Constructor: ignore size
    {
        System.out.printf("No size limit, size of %d will be ignored!", size);
        setup();
    }


    // Class methods
    private void setup()           // Called by Constructors only
    {
        front = null;
        rear = null;
    }           // Initializes front and rear to null

    //----- Insert method implementations for the interface Queue here -----//


    @Override
    public void enqueue(Object newElement) {
        if(isEmpty()){

            front = new QueueNode(newElement,null);

        }
        else{
            if(rear==null){
                rear = new QueueNode(newElement,null);
                front.setNext(rear);
            }
            else{
                QueueNode nextToLast = nextToLast();
                rear = new QueueNode(newElement, null);
                nextToLast.setNext(rear);



            }


        }
        if(rear!=null)System.out.printf("Element in rear: %s\n", String.valueOf(rear.getElement()));
    }

    private QueueNode nextToLast(){
        QueueNode q, p=null;
        for(q=front;q!=null; q = q.getNext() ){
            p=q;
        }
//        System.out.printf("Next to last element p: %s\t\t with q: %s\n", String.valueOf(p.getElement()), String.valueOf(q.getElement()));
        return p;
    }
    @Override
    public Object dequeue() {
        if(isEmpty()){
            System.out.printf("Attempting to dequeue an empty Queue!\n");
            return null;
        }
        else {
            QueueNode temp = new QueueNode(front.getElement(), front.getNext());
            front = front.getNext();
            return temp;
        }
    }


    @Override
    public void clear() {
        front=null;
        rear=null;

    }


    @Override
    public boolean isEmpty() {
        if(front==null ) return true;
        else return false;
    }


    @Override
    public boolean isFull() {
        System.out.print("There are no size limit, Queue is never full!\n");
        return false;
    }


    public void showStructure()
    // Linked list implementation. Outputs the elements in a queue. If
    // the queue is empty, outputs "Empty queue". This operation is
    // intended for testing and debugging purposes only.
    {
        QueueNode p;                // Iterates through the queue

        if (front == null)
            System.out.println("Empty queue");
        else {
            System.out.print("front ");
            for (p = front; p != null; p = p.getNext())
                System.out.print(p.getElement() + " ");
            System.out.println("rear");
        }
    } // showStructure for LQueue

} // Class LQueue


