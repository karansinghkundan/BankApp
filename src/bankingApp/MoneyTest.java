package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
    protected Currency CAD, HKD, NOK, EUR;
    protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100, CAD152;

    @Before
    public void setUp() throws Exception {
        // setup sample currencies
        CAD = new Currency("CAD", 0.75);
        HKD = new Currency("HKD", 0.13);
        EUR = new Currency("EUR", 1.14);

        // setup sample money amounts
        CAD100 = new Money(100, CAD);

        EUR10 = new Money(10, EUR);
        CAD200 = new Money(200, CAD);
        EUR20 = new Money(20, EUR);
        CAD0 = new Money(0, CAD);
        EUR0 = new Money(0, EUR);
        CADnegative100 = new Money(-100, CAD);

        CAD152 = new Money(15.2, CAD);
    }

    @Test
    public void testGetAmount() {

        assertEquals(10.00, EUR10.getAmount(),0.001);
    }

    @Test
    public void testGetCurrency() {

        assertEquals(CAD200.getCurrency().getName(), new Currency("CAD",0.75).getName());
    }

    @Test
    public void testToString() {

        getaVoid();

    }

    private void getaVoid() {
        assertEquals("20.0 EUR", EUR20.toString());
    }

    @Test
    public void testGetUniversalValue() {
        assertEquals(11.399999999999999, EUR10.getUniversalValue(),0.001);
    }

    @Test
    public void testEqualsMoney() {
        assertEquals(true, EUR10.equals(CAD152));
    }

    @Test
    public void testAdd() {

        assertEquals(141.58, EUR10.add(CAD200).getAmount(),0.001);

        assertEquals(215.20, CAD152.add(CAD200).getAmount(),0.001);

    }


    @Test
    public void testSubtract() {
        assertEquals(-121.58, EUR10.subtract(CAD200).getAmount() ,0.001);
        assertEquals(-184.80, CAD152.subtract(CAD200).getAmount(),0.001);

    }

    @Test
    public void testIsZero() {
        assertEquals(true, CAD0.isZero());
    }

    @Test
    public void testNegate() {
        assertEquals(-200.00, CAD200.negate().getAmount(),0.001);
    }

    @Test
    public void testCompareTo() {
        assertEquals(-138, CAD152.compareTo(CAD200));
    }
}