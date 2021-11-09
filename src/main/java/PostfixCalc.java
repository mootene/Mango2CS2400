//written by: Maya Tene 2021
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
            if (Character.isLetter(c))
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

    /**
     * converts a given character variable to a predetermined number value
     * @param variable variable to be translated
     * @return integer value of given variable character
     */
    public static int variableToValue(char variable)
    {
        int value = 0;
        switch (variable)
        {
            case 'a':
                value = 2;
                break;
            case 'b':
                value = 3;
                break;
            case 'c':
                value = 4;
                break;
            case 'd':
                value = 5;
                break;
            case 'e':
                value = 6;
                break;
            default:
                value = 0;
                break;
        }
        return value;
    }

    /**
     * evaluates a given postfix notation
     * @param postfix given postfix String
     * @return postfix evaluation
     */
    public static int evaluatePostFix(String postfix)
        {
            ResizeableArrayStack<Integer> postfixstack = new ResizeableArrayStack<Integer>();
            
            while(!postfix.isEmpty())
            {
                char[] postfix = postfix.toCharArray();
            
                for(char c: postfix)
                {
                    if(c == ' ')
                    {
                        continue;
                    }

                    if(Character.isLetter(c))
                    {
                        postfixstack.push(variableToValue(c));
                    }

                    else
                    {
                        int a = postfixstack.pop();
                        int b = postfixstack.pop();
                    }
                    switch(c)
                    {
                        case '^':
                            postfixstack.push(c);
                            break;
                        case '+':
                            postfixstack.push(a+b);
                            break;
                        case '-':
                            postfixstack.push(b-a);
                            break;
                        case '*':
                            postfixstack.push(a*b);
                            break;
                        case '/':
                            postfixstack.push(a/b);
                            break;

                        default:
                        break;
                    }

                }
            }
            return postfixstack.peek();
        }
}