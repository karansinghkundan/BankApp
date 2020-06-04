package bankingApp;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    protected Currency CAD, HKD;
    protected Bank TD;
    protected Bank HSBC;
    protected Bank RBC;
    protected Account testAccount;


        @Before
        public void setUp() throws Exception {

            // setup test currencies
            CAD = new Currency("CAD", 0.75);
            RBC = new Bank("Royal Bank of Canada", CAD);

            // setup test accounts
            RBC.openAccount("Peter");
            testAccount = new Account("Albert", CAD);
            testAccount.deposit(new Money(100, CAD));

            // setup an initial deposit
            HSBC.deposit("Peter", new Money(500, CAD));
        }

        @Test
        public void testAddWithdraw() {
            // Something to consider - can you withdraw in a different currency?

            Money m = new Money(40, CAD);

            testAccount.withdraw(m);

            try {
                HSBC.withdraw("Peter", new Money(190, CAD));
            } catch (AccountDoesNotExistException e) {

                e.printStackTrace();
            }

            double moneyAfterWithdraw = 0.0;
            try {
                moneyAfterWithdraw = HSBC.getBalance("Peter");
            } catch (AccountDoesNotExistException e) {

                e.printStackTrace();
            }

            System.out.print(moneyAfterWithdraw);

            assertEquals(40.00,moneyAfterWithdraw,0.001);

        }

        @Test
        public void testGetBalance() {
            double getBalance = 0.0;
            try {
                getBalance = RBC.getBalance("Peter");
            } catch (AccountDoesNotExistException e) {

                e.printStackTrace();
            }

            System.out.print(getBalance);

            assertEquals(40.00,getBalance,0.001);

        }
    }
