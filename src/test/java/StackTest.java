//written by: Maya Tene 2021

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;

public class StackTest
{
    
    @ParameterizedTest
    @ValueSource(classes = {
            LinkedStack.class,
            ResizeableArrayStack.class})
    void testPush(Class stackClass)
    {
        StackInterface<Integer> stack = constructStack(stackClass);
        int newEntry = 1;
        stack.push(newEntry);
        assertEquals(newEntry, stack.peek());
    }


    @ParameterizedTest
    @ValueSource(classes = {
            LinkedStack.class,
            ResizeableArrayStack.class})
    void testPop(Class stackClass)
    {
        StackInterface<Integer> stack = constructStack(stackClass);
        stack.push(1);
        assertEquals(1, stack.pop());
        for (int i = 0; i < 10; i++)
        {
            stack.push(i);
        }
        for (int i = 9; i >= 0; i--)
        {
            assertEquals(i, stack.pop());
        }
    }

    @ParameterizedTest
    @ValueSource(classes = {
            LinkedStack.class,
            ResizeableArrayStack.class})
    void testPeek(Class stackClass)
    {
        StackInterface<Integer> stack = constructStack(stackClass);
        stack.push(1);
        assertEquals(1, stack.peek());
    }


    @ParameterizedTest
    @ValueSource(classes = {
            LinkedStack.class,
            ResizeableArrayStack.class})
    void testClear(Class stackClass)
    {
        StackInterface<Integer> stack = constructStack(stackClass);
        for (int i = 0; i < 3; i++)
        {
            stack.push(i);
        }
        stack.clear();
        assertTrue(stack.isEmpty());
    }


    @ParameterizedTest
    @ValueSource(classes = {
            LinkedStack.class,
            ResizeableArrayStack.class})
    void testIsEmpty(Class stackClass)
    {
        StackInterface<Integer> stack = constructStack(stackClass);
        assertTrue(stack.isEmpty());
        for (int i = 0; i < 3; i++)
        {
            stack.push(i);
        }
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 3; i++)
        {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    static StackInterface constructStack(Class c)
    {
        try 
        {
            return (StackInterface) c.getConstructor().newInstance();
        } 
        catch (InvocationTargetException ex) 
        {
            if (ex.getTargetException() instanceof IllegalArgumentException) 
            {
                throw new IllegalArgumentException(ex.getTargetException().getMessage(), ex);
            } 
            else 
            {
                throw new RuntimeException("Re-throwing: ", ex);
            }
        } 
        catch (NoSuchMethodException | InstantiationException |
                IllegalAccessException  ex) 
        {
            throw new RuntimeException("Re-throwing: ", ex);
        }
    }

}