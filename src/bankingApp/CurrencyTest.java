
package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {

    /* Example currencies:
     * 	CAD = Canadian dollar
     * 	EUR = Euros
     * 	GBP = Great British Pounds
     * 	HKD = Hong Kong Dollars
     */
    public Currency CAD, EUR, GBP, HKD;

    @Before
    public void setUp() throws Exception {
        // Setup some test currencies to use in the below test cases
        CAD = new Currency("CAD", 0.75);
        EUR = new Currency("EUR", 1.14);
        HKD = new Currency("HKD", 0.13);
    }

    @Test
    public void testGetName() {
        // Write the test case for testing the getName() function

        assertEquals("CAD", CAD.getName());
    }

    @Test
    public void testGetRate() {
        // @TODO: Write the test case for testing the getRate() function
        assertEquals(0.75, CAD.getRate(),0.12);
    }

    @Test
    public void testSetRate() {
        // @TODO: Write the test case for testing the setRate() function

        // For this function, you should do:
        // 1. Assert that the oldRate is correct
        // 2. Change the rate
        // 3. Assert that the newRate is correct
        // You will end up with 2 assert() statements in this function.
        assertEquals(0.75, CAD.getRate(),0.12);
        CAD.setRate(1.5);//ERROR WHEN SET RATE IS DIFFERENT THAN ACTUAL
        assertEquals(1.5, CAD.getRate(),0.12);
    }

    @Test
    public void testValueInUSD() {
        // @TODO: Write the test case for testing the valueInUSD() function
        assertEquals(57.0, EUR.valueInUSD(50),0.12);
        assertEquals(45.0,CAD.valueInUSD(60),0.12);
        assertEquals(8.45,HKD.valueInUSD(65),0.12);
    }

    @Test
    public void testValueInThisCurrency() {
        // @TODO: Write the test case for testing the valueInThisCurrency() function
        // For this function, you should:
        // 1. Assert the value of the "other" currency
        // 2. Get the value in "this" currency
        // 3. Assert that the value in "this" currency is correct
        // You will end up with 2 assert() statements in this function.


        assertEquals(8.67, HKD.valueInThisCurrency(50, CAD),0.12);
        CAD.getRate();
        assertEquals(288.46, CAD.valueInThisCurrency(50, HKD),0.12);



        assertEquals(76.0, EUR.valueInThisCurrency(50, CAD),0.12);
        CAD.getRate();
        assertEquals(32.89, CAD.valueInThisCurrency(50, EUR),0.12);



        assertEquals(32.89, CAD.valueInThisCurrency(50, EUR),0.12);
        CAD.getRate();
        assertEquals(76.0, EUR.valueInThisCurrency(50, CAD),0.12);




    }

}
