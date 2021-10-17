//written by: Maya Tene 2021
public class LinkedStackTest 
{
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