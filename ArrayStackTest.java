import java.util.Stack;
import java.util.Scanner;

public class ArrayStackTest 
{
    /**
     * evaluates a given postfix notation
     * @param postfix given postfix String
     * @return postfix evaluation
     */
    public static int evaluatePostFix(String postfix)
    {
        ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<Integer>();

        for(int i = 0; i<postfix.length(); i++)
        {
            char c = postfix.charAt(i);

            if(Character.isDigit(c))
            {
                stack.push(c - '0');
            }

            else
            {
                int a = stack.pop();
                int b = stack.pop();

                switch(c)
                {
                    case '+':
                    stack.push(a+b);
                    break;

                    case '-':
                    stack.push(b-a);
                    break;

                    case '/':
                    stack.push(b/a);
                    break;

                    case '*':
                    stack.push(a*b);

                    default:
                    break;
                }
            }
        }
        return stack.pop();
    }


    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String post =s.nextLine();
        int value = evaluatePostFix(post);
        System.out.println(value);
    }
}
