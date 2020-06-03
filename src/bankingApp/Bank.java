package bankingApp;

import java.util.Hashtable;

public class Bank {
    private Hashtable<String, Account> accountlist = new Hashtable<String, Account>();
    private String name;
    private Currency currency;

    public Bank(String bankName, Currency baseCurrencyCode) {
        this.name = bankName;
        this.currency = baseCurrencyCode;
    }

    public String getName() {
        return name;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void openAccount(String accountid) throws AccountExistsException {
        if (accountlist.containsKey(accountid)) {
            throw new AccountExistsException();
        }
        else {
            accountlist.get(accountid);
        }
    }
    public void deposit(String accountid, Money money) throws AccountDoesNotExistException {
        if (accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        }
        else {
            Money m = new Money(money.getAmount(), new Currency("USD", money.getCurrency().getRate()));
            Account account = accountlist.get(accountid);
            account.deposit(m);
        }
    }
    public void withdraw(String accountid, Money money) throws AccountDoesNotExistException {
        if (!accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        }
        else {
            Account account = accountlist.get(accountid);
            account.deposit(money);
        }
    }

    public double getBalance(String accountid) throws AccountDoesNotExistException {
        if (!accountlist.containsKey(accountid)) {
            throw new AccountDoesNotExistException();
        }
        else {
            return accountlist.get(accountid).getBalance().getAmount();
        }
    }
    public void transfer(String fromaccount, Bank tobank, String toaccount, Money amount) throws AccountDoesNotExistException {
        if (!accountlist.containsKey(fromaccount) || !tobank.accountlist.containsKey(toaccount)) {
            throw new AccountDoesNotExistException();
        }
        else {
            accountlist.get(fromaccount).withdraw(amount);
            tobank.accountlist.get(toaccount).deposit(amount);
        }
    }


    public void transfer(String fromaccount, String toaccount, Money amount) throws AccountDoesNotExistException {
        transfer(fromaccount, this, fromaccount, amount);
    }
    public void addTimedPayment(String accountid, String payid, Integer interval, Integer next, Money amount, Bank tobank, String toaccount) {
        Account account = accountlist.get(accountid);
        account.addTimedPayment(payid, interval, next, amount, tobank, toaccount);
    }
    public void removeTimedPayment(String accountid, String id) {
        Account account = accountlist.get(accountid);
        account.removeTimedPayment(id);
    }
    public void tick() throws AccountDoesNotExistException {
        for (Account account : accountlist.values()) {
            account.tick();
        }
    }
}
