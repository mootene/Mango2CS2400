// written by: Maya Tene 2021
import java.util.EmptyStackException;
/**
 * Linked Implementation of StackInterface
 * @param <T> entry type
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode;
    private int depth;

    /**
     * default constructor initializes null topNode 
     */
    public LinkedStack()
    {
        topNode = null;
        depth = 0;
    }// end of default constructor

    /**
     * Adds new entry to the top of this stack
     * @param newEntry entry to be added
     */
    public void push(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry, topNode);
        topNode = newNode;
        depth++;
    }//end of push

    /**
     * Removes and return's this stack's topmost entry
     * @return the data in the old top entry of this stack
     * @throws EmptyStackException if this stack is empty before call
     */
    public T pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        
        T topData = peek();
        topNode = topNode.getNextNode();
        depth--;
        return topData;
    }

    /**
     * Retrieves topmost entry in this stack
     * @return topmost entry 
     * @throws EmptyStackException if this is empty before call
     */
    public T peek()
    {
        //check if empty
        if (isEmpty())
            throw new EmptyStackException();
        return topNode.getData();
    }

    /**
     * checks if stack is empty
     * @return True if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (topNode == null);
    }

    /**
     * removes all entries in stack
     */
    public void clear()
    {
        topNode = null;
        depth = 0;
    }

    private class Node<U>
    {
        private U data;
        private Node<U> next;

        private Node(U data)
        {
            this(data, null);
        }
        
        private Node(U data, Node<U> nextNode)
        {
            this.data = data;
            next = nextNode;
        }
        private U getData()
        {
            return data;
        }
        private void setData(U newData)
        {
            data = newData;
        }
        private Node<U> getNextNode()
        {
            return next;
        }
        private void setNextNode(Node<U> nextNode)
        {
            next = nextNode;
        }
    }

}