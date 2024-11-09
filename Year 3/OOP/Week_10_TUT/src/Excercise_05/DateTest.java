package Excercise_05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

public class DateTest {

    public DateTest(){
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addDays() {
        Date d = new Date(12, 2, 2019);
        d.addDays(4);
        assertEquals(2019, d.getYear());
        assertEquals(2, d.getMonth());
        assertEquals(12, d.getDay());
    }
    @Test
    public void test2(){
        Date d = new Date(12, 2 ,2019);
        d.addDays(4);

        Date exp = new Date(16 , 2, 2019);
        assertEquals(exp,d);
    }

    @Test
    public void printDate(){
        Date d3 = new Date(29, 10, 2002);
        assertEquals(d3.toString(),"Date [ day 29 month = 10 year = 2002]");
    }
    @Test
    public void printDate_test(){
        // Prepare to capture output
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        // define the line separator \n if you use println
        // Line separators are different on different systems!
        // This does not work: assertEquals("("The date is 2019-12-28" n",
        os.toString();
        String separator = System.lineSeparator();
        // perform the test
        Date d = new Date(28, 12, 2019);
        d.printDate();
        assertEquals("The date is 2019-12-28" + separator, os.toString());

        //Restore normal operation
        System.setOut(originalOut);
    }

}