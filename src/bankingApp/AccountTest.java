package bankingApp;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AccountTest extends Money {
    protected Currency HKD = new Currency("HKD", 0.13);
    protected Currency CAD = new Currency("CAD", 0.75);
    protected Bank TD;
    protected Bank HSBC;
    protected Bank RBC = new Bank("Royal Bank of Canada", CAD);
    protected Account testAccount,testAccount2 = new Account("Test", CAD);
    protected Money currency = new Money(50,CAD);;

    /**
     * New Money
     *
     * @param amount   The amount of money
     * @param currency The currency of the money
     */
    public AccountTest(double amount, Currency currency) {
        super(amount, currency);
    }


    @Before
    public void setUp() throws Exception {
        RBC.openAccount("Peter");
        testAccount = new Account("Albert", CAD);
        testAccount.deposit(new Money(100, CAD));
        // setup an initial deposit
        RBC.deposit("Peter", new Money(500, CAD));
    }



    @Test
    public void testAddWithdraw() {

        testAccount.deposit(currency);

        assertEquals(110,testAccount.getBalance().getAmount(),2);
        assertEquals(CAD,testAccount.getBalance().getCurrency());
    }


    @Test
    public void testGetBalance() {

    }
}