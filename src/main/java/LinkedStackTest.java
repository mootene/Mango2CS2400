//written by: Maya Tene 2021
public class LinkedStackTest 
{
    public static int precedence(char c)
    {
        int p = 0;
        switch (c)
            {
                case '^':
                    p = 3;
                    break;
                case '+':
                case '-':
                    p = 1;
                    break;
                case '/':
                case '*':
                    p = 2;
                    break;
                default:
                    break;
            }
        return p;        
    }
    /**
     * converts a given infix expression to postfix notation
     * @param infixStr given infix String
     * @return postfix conversion
     */
    public static String convertToPostfix(String infixStr)
    {
        LinkedStack<Character> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();
        char[] infix = infixStr.toCharArray();
        for(char c: infix)
        {
            if (c == ' ')
                continue;
            if (Character.isLetterOrDigit(c))
            {
                postfix.append(c);
                continue;
            }
            switch (c)
            {
                case '^':
                    operatorStack.push(c);
                    break;
                case '+':
                case '-':
                case '/':
                case '*':
                    while(!operatorStack.isEmpty() && (precedence(c) <= precedence(operatorStack.peek())))
                    {
                        postfix.append(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(c);
                    break;
                case '(':
                    operatorStack.push(c);
                    break;
                case ')':
                    Character topOperator = operatorStack.pop();
                    while(topOperator != '(')
                    {
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        while(!operatorStack.isEmpty())
        {
            Character topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
        return postfix.toString();
    }
    public static void print(String s)
    {
        System.out.println("infix: " + s);
        System.out.println("postfix: " + convertToPostfix(s));
    }
    public static void main(String[] args)
    {
        print("a+b");
        print("a*c+d-e^t");
        print("a*b/(c-a)+d*e");
    }
}