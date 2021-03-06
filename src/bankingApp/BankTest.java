package bankingApp;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
    protected Currency CAD;
    protected Currency HKD;
    protected Bank RBC;
    protected Bank TD;
    protected Bank HSBC;
    protected Money CAD10;



    @Before
    public void setUp() throws Exception {

        // setup some test currencies
        this.HKD = new Currency("HKD", 0.13);
        this.CAD = new Currency("CAD", 0.75);

        // setup test banks
        this.RBC = new Bank("Royal Bank of Canada", CAD);
        this.TD = new Bank("TD Bank", CAD);
        this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);

        // add sample customers to the banks


        // HINT:  uncomment these lines AFTER you test the openAccount() function
        // You can quickly uncomment / comment by highlighting the lines of code and pressing
        // CTRL + / on your keyboard  (or CMD + / for Macs)

        this.RBC.openAccount("Marcos", new Account("Peter", CAD));
        this.RBC.openAccount("Albert", new Account("Peter", CAD));
        this.TD.openAccount("Jigesha", new Account("Peter", CAD));
        this.HSBC.openAccount("Pritesh", new Account("Peter", CAD));
    }

    @Test
    public void testGetName() {
        String nameOfBank1 = RBC.getName();
        assertEquals("Royal Bank of Canada",nameOfBank1);
        String nameOfBank2 = TD.getName();
        assertEquals("TD Bank",nameOfBank2);
        String nameOfBank3 = HSBC.getName();
        assertEquals("Hong Kong Shanghai Banking Corporation",nameOfBank3);
    }

    @Test
    public void testGetCurrency() {
        assertEquals("CAD", new Currency("CAD",0.75).getName());
        assertEquals(0.75, new Currency("CAD",0.75).getRate(),0.001);

        assertEquals("HKD", new Currency("HKD",0.13).getName());
        assertEquals(0.13, new Currency("HKD",0.13).getRate(),0.001);

        assertEquals("EUR", new Currency("EUR",1.14).getName());
        assertEquals(1.14, new Currency("EUR",1.14).getRate(),0.001);
    }

// have to be resolved later
public void testOpenAccount() throws AccountExistsException  {
    // If the function throws an exception, you should also test
    // that the exception gets called properly.

    // See the example in class notes for testing exceptions.
    Exception exception = assertThrows(AccountExistsException.class, () -> {
        RBC.openAccount("AMAN", new Account("Peter", CAD));

    });

    String expectedMessage = "This account is already exist";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
}


    @Test (expected = AccountDoesNotExistException.class)
    public void testDeposit() throws AccountDoesNotExistException {
//deposit the amount in a new account
        RBC.deposit("KARAN",new Money(10,HKD));

 //checking the balance in the account
        assertEquals(76.92,RBC.getBalance("KARAN"),0.001);

  //checking to see if the error shows if deposited in an account that doesnot exist
        String actualMessage = assertThrows(AccountDoesNotExistException.class, () -> {


          //exceptional handlind working

            RBC.deposit("XYZ",new Money(10,CAD));
        }).getMessage();



        //checking to see if the value is shown when encountered with an unknown account.

        assertTrue(actualMessage.contains("Account doesnot Exist"));
    }
    @Test(expected = AccountDoesNotExistException.class)
    public void testWithdraw() throws AccountDoesNotExistException {

//depositing the amount in a open account and see if the amount is deposited
        HSBC.deposit("Pritesh",new Money(5,HKD));
        HSBC.getBalance("Pritesh");
        assertEquals(5,HSBC.getBalance("Pritesh"),2);

       //checking to see if the amount can be withdrawn from the account
        RBC.withdraw("Macro",new Money(2,CAD));
        assertEquals(23.08,RBC.getBalance("Macro"),2);

//checking if withdraw work on an account that doesnot exist
        Exception exception = assertThrows(AccountDoesNotExistException.class, () -> {
         RBC.withdraw("emad",new Money(8.46,HKD));
         });
        assertTrue(exception.getMessage().contains("Account doesnot Exit"));





    }



    @Test (expected = AccountDoesNotExistException.class)
    public void testGetBalance() throws AccountDoesNotExistException {

        double bal= 0.0;
        bal = RBC.getBalance("Marcos");
    }


    @Test (expected = AccountDoesNotExistException.class)
    public void testTransfer() throws AccountDoesNotExistException {
        // Note: You should test both types of transfers:
        // 1. Transfer from account to account
        // 2. Transfer between banks
        // See the Bank.java file for more details on Transfers
        RBC.transfer("Marcos", TD, "Albert", new Money(15,CAD));
        RBC.transfer("Marcos", "Albert", new Money(15,CAD));
    }



}