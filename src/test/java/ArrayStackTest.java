import java.util.Stack;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStackTest 
{
    @Test
    void testConstructors()
    {
        ResizeableArrayStack<Integer> stack1 = new ResizeableArrayStack<>();
        ResizeableArrayStack<Integer> stack2 = new ResizeableArrayStack<>(75);
        assertTrue(isActualCapacity(50, stack1));
        assertTrue(isActualCapacity(75, stack2));
    }
    /**
     * verifies the intended capacity of a ResizeableArrayStackObject
     * @param expectedCapacity expected capacity of given stack
     * @param stack stack being tested
     * @return true if actual and expected capacity are equal, false otherwise
     */
    private boolean isActualCapacity(int expectedCapacity, ResizeableArrayStack<Integer> stack)
    {
        int observeDepth = 0;
        boolean atCapactiy = false;
        while (!atCapactiy)
        {
            try 
            {
                stack.push(42);
                observeDepth++;
            }
            catch  (Exception e)
            {
                atCapactiy = true;
            }
        }
        return (observeDepth == expectedCapacity);
    }

    public static void main(String[] args)
    {
        int value = PostfixCalc.evaluatePostFix(PostfixCalc.convertToPostfix("a*b/(c-a)+d*e"));
        System.out.println("evaluation of postfix expression from Task 1: " + value);
    }
}
