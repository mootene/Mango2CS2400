//written by: Maya Tene 2021
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedStackTest 
{
    @Test
    void testConstructor()
    {
        LinkedStack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
    }

    /**
     * prints the infix and postfix interpretations of a given expression
     * @param s infix expression to be converted/displayed
     */
    public static void print(String s)
    {
        System.out.println("infix: " + s);
        System.out.println("postfix: " + PostfixCalc.convertToPostfix(s));
    }
    public static void main(String[] args)
    {
        print("a+b");
        print("a*c+d-e^t");
        print("a*b/(c-a)+d*e");
    }
}