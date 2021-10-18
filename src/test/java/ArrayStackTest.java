import java.util.Stack;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStackTest 
{
    @Test
    void testConstructors()
    {
        ResizeableArrayStack<Integer> stack1 = new ResizeableArrayStack<>();
        ResizeableArrayStack<Integer> stack2 = new ResizeableArrayStack<>(75);
        // push doubles size from 50 to 100 ... 640 before reaching max capcity of 10000 at next operation
        assertEquals(6400, observedMaxCapactiy(stack1));
        assertEquals(9600, observedMaxCapactiy(stack2));
    }
    /**
     * returns the maximum index observed from repetitive push operations
     * @param stack stack being tested
     * @return observed largest index of stack
     */
    private int observedMaxCapactiy(ResizeableArrayStack<Integer> stack)
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
        return observeDepth;
    }

    public static void main(String[] args)
    {
        int value = PostfixCalc.evaluatePostFix(PostfixCalc.convertToPostfix("a*b/(c-a)+d*e"));
        System.out.println("evaluation of postfix expression from Task 1: " + value);
    }
}
