import java.util.Stack;

public class ArrayStackTest 
{
    static int evaluatePostFix(String exp)
    {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<exp.length(); i++)
        {
            char c = exp.charAt(i);

            if(Character.isDigit(c))
            {
                stack.push(c - '0');
            }

            else
            {
                int value1 = stack.pop();
                int value2 = stack.pop();

                switch(c)
                {
                    case '+':
                    stack.push(value2+value1);
                    break;

                    case '-':
                    stack.push(value2-value1);
                    break;

                    case '/':
                    stack.push(value2/value1);
                    break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args)
    {
        String exp = "231*+9-";
        System.out.println("postfix evaluation: " + evaluatePostFix(exp));
    }
}
