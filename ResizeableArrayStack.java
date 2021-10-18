import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * Array Implementation of StackInterface
 * @param <T> entry type
 */

public final class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }//end default constructor

    public ResizeableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }//end constructor

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a stack whose capacity exceds allowed maximum.");
        }
    }

    private void checkIntegrity()
    {
        if(!integrityOK)
        {
            throw new SecurityException("ArrayStack object is corrupt");
        }
    }

    /**
     * Adds new entry to the top of the stack
     * @param newEntry entry to be added
     */

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2*stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }
    /**
     * Retrieves the top entry in the stack
     * @return the top entry
     * @throws EmptyStackException if it's empty before the call
     */

    public T peek()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }
    /**
     * Removes and return's the stack's topmost entry
     * @return the data in the old top entry of the stack
     * @throws EmptyStackException if the stack is empty before the call
     */

    public T pop()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }
    /**
     * checks if the stack is empty
     * @return True if empty, false if not
     */
    
    public boolean isEmpty()
    {
        return topIndex < 0;
    }
    /**
     * removes all the entries in the stack
     */

    public void clear()
    {
        checkIntegrity();

        while(topIndex>-1)
        {
            stack[topIndex] = null;
            topIndex--;
        }
    }
}//end ResizeableArrayStack