public class PostfixCalc
{
    /**
     * determines the precedence of a given operational character 
     * @param c operational character (*,/,-,+,^)
     * @return integer value representing precedence, larger = higher precedence.
     */
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
}