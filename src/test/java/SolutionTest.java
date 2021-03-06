import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    Solution solution;
    public SolutionTest(){}

    @Before
    public void setUp()
    {
        solution = Solution.getInstance();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void test1()
    {
        String input = "101";
        assertEquals(1, solution.getMin(input));
    }

    @Test
    public void test2()
    {
        String input = "101101101";
        assertEquals(3, solution.getMin(input));
    }

    @Test
    public void test3()
    {
        String input = "1111101";
        assertEquals(1, solution.getMin(input));
    }

    @Test
    public void test4(){
        String input = "00000";
        assertEquals(-1, solution.getMin(input));
    }

    @Test
    public void test5(){
        String input = "11111111111111111111111111111111111111111111111111";
        assertEquals(50, solution.getMin(input));
    }

    @Test
    public void test6(){
        String input = "10110001101000101011110000101110110001010";
        assertEquals(-1, solution.getMin(input));
    }

    @Test
    public void test7(){
        String input = "10110001101000101011110000101110110001011";
        assertEquals(2, solution.getMin(input));
    }

    @Test
    public void test8(){
        String input = "111011100110101100101110111";
        assertEquals(5, solution.getMin(input));
    }

    @Test
    public void test9(){
        String input = "001000";
        assertEquals(-1, solution.getMin(input));
    }

    @Test
    public void test10(){
        String input = "000001";
        assertEquals(-1, solution.getMin(input));
    }

    @Test
    public void test11(){
        String input = "110111110101111000011";
        assertEquals(3, solution.getMin(input));
    }

    /**
     * test case if the string does not contain 0's and 1's 
     */
    @Test
    public void test12(){
        String input = "123456";
        assertEquals(0, solution.getMin(input));
    }
    
    /**
     * test case if the string  is  empty 
     */
    @Test
    public void test13(){
        String input = " ";
        assertEquals(0, solution.getMin(input));
    }
    
    /**
     * test case if the string size is grater than 50 
     */
    @Test
    public void test14(){
        String input = "111111111111111111111111111111111111111111111111111";
        assertEquals(0, solution.getMin(input));
    }



}
