import java.util.Arrays;
import java.util.EmptyStackException;

public final class ResizeableArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public void push(T newEntry)
    {
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2*stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }

    public T pop()
    {
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
    
    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    public void clear()
    {
        topIndex = 0;
    }
}