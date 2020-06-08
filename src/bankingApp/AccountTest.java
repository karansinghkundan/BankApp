package bankingApp;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AccountTest {
    protected Currency HKD = new Currency("HKD", 0.13);
    protected Currency CAD = new Currency("CAD", 0.75);
    protected Bank TD;
    protected Bank HSBC;
    protected Bank RBC = new Bank("Royal Bank of Canada", CAD);
    protected Account testAccount;
    protected Account testAccount2 = new Account("Test", CAD);
    protected Money currency = new Money(50,CAD);;




    @Before
    public void setUp() throws Exception {
        RBC.openAccount("Peter");
        testAccount = new Account("Albert", CAD);
        testAccount.content = testAccount.content.add(new Money(100, CAD));
        // setup an initial deposit
        RBC.deposit("Peter", new Money(500, CAD));
    }



    @Test
    public void testAddWithdraw() {

        testAccount2.content = testAccount2.content.add(new Money(100, CAD));
        assertEquals(100,testAccount2.getBalance().getAmount(),0.001);
        testAccount2.content = testAccount2.content.subtract(new Money(60, HKD));
        assertEquals(89.6,testAccount2.getBalance().getAmount(),0.012);

    }


    @Test
    public void testGetBalance() {
        testAccount2.content= testAccount2.content.add(new Money(100, CAD));
        assertEquals(100,testAccount2.getBalance().getAmount(),0.001);
        testAccount2.content=testAccount2.content.add(new Money(50, HKD));
        assertEquals(108.67,testAccount2.getBalance().getAmount(),0.001);
    }
}