//written by: Maya Tene 2021
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

public class PostfixCalcTest
{
    @DisplayName("Test PostfixCalc.precedence(char c)")
    @Test
    void testPrecedence()
    {
        assertEquals(3, PostfixCalc.precedence('^'));
        assertEquals(1, PostfixCalc.precedence('+'));
        assertEquals(2, PostfixCalc.precedence('*'));
        assertEquals(PostfixCalc.precedence('+'), PostfixCalc.precedence('-'));
        assertEquals(PostfixCalc.precedence('/'), PostfixCalc.precedence('*'));
    }

    @DisplayName("Test PostfixCalc.convertToPostfix(String infix)")
    @Test
    void testConvertToPostfix()
    {
        assertEquals("ab+", PostfixCalc.convertToPostfix("a+b"));
        assertEquals("ab*ca-/de*+", PostfixCalc.convertToPostfix("a*b/(c-a)+d*e"));
    }

    @DisplayName("Test PostfixCalc.variableToValue()")
    @Test
    void testVariableToValue()
    {
        assertEquals(2, PostfixCalc.variableToValue('a'));
        assertEquals(0, PostfixCalc.variableToValue('z'));
    }

    @DisplayName("Test PostfixCalc.evaluatePostfix()")
    @Test
    void testEvaluatePostfix()
    {
        assertEquals(5, PostfixCalc.evaluatePostFix("ab+"));
        assertEquals(33, PostfixCalc.evaluatePostFix("ab*ca-/de*+"));
    }
}