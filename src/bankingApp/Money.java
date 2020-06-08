package bankingApp;

public class Money implements Comparable {
    private double amount;
    private Currency currency;

    /**
     * New Money
     * @param amount	The amount of money
     * @param currency	The currency of the money
     */
    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Return the amount of money.
     * @return Amount of money as an double type.
     */
    public double getAmount() {
        return this.amount;

    }

    /**
     * Returns the currency of this Money.
     * @return Currency object representing the currency of this Money
     */
    public Currency getCurrency() {
        // @TODO:  Fill in the code for this
        return this.currency;
    }

    /**
     * Returns the amount of the money in the string form "(amount) (currencyname)", e.g. "10.5 CAD".
     *  @return String representing the amount of Money.
     */
    public String toString() {
        // @TODO:  Fill in the code for this
        return String.valueOf(this.amount) + " " + this.currency.getName();
    }

    /**
     * Gets the universal value of the Money, according the rate of its Currency.
     * @return The value of the Money in the "universal currency". (USD)
     */
    public double getUniversalValue() {
        // @TODO:  Fill in the code for this
        double universalValue = 0.0;

        if (this.currency.getName().equals("CAD")) {
            universalValue = this.amount * 0.75;
            return universalValue;
        }
        else if (this.currency.getName().equals("EUR")) {
            universalValue = this.amount * 1.14;
            return universalValue;
        }
        else if (this.currency.getName().equals("HKD")) {
            universalValue = this.amount * 0.13;
            return universalValue;
        }
        else {
            return universalValue;
        }


    }

    /**
     * Check to see if the value of this money is equal to the value of another Money of some other Currency.
     * @param other The other Money that is being compared to this Money.
     * @return A Boolean indicating if the two monies are equal.
     */
    public boolean equals(Money other) {
        // @TODO:  Fill in the code for this
        boolean chk = false;
        double actual, expected = 0.0;
        actual = this.getUniversalValue();
        expected = other.getUniversalValue();

        if (actual == expected) {
            chk = true;
        }
        else
        {
            chk = false;
        }

        return chk;

    }

    /**
     * Adds a Money to this Money, regardless of the Currency of the other Money.
     * @param other The Money that is being added to this Money.
     * @return A new Money with the same Currency as this Money, representing the added value of the two.
     * (Remember to convert the other Money before adding the amounts)
     */
    public Money add(Money other) {

        double money = 0.0;

        money = other.currency.valueInThisCurrency(other.amount, this.currency);

        this.amount = this.amount + money;

        return this;

    }

    /**
     * Subtracts a Money from this Money, regardless of the Currency of the other Money.
     * @param other The money that is being subtracted from this Money.
     * @return A new Money with the same Currency as this Money, representing the subtracted value.
     * (Again, remember converting the value of the other Money to this Currency)
     */
    public Money subtract(Money other) {

        double money = 0.0;

        //CAN 200
        //CAN to EUR
        //CAN 200 * .75 = 150

        money = other.currency.valueInThisCurrency(other.amount, this.currency);

        this.amount = this.amount - money;

        return this;
    }

    /**
     * Check to see if the amount of this Money is zero or not
     * @return True if the amount of this Money is equal to 0.0, False otherwise
     */
    public boolean isZero() {
        // @TODO:  Fill in the code for this
        boolean chk = false;

        if (this.amount == 0.0) {
            chk = true;
        }
        else {
            chk = false;
        }

        return chk;

    }
    /**
     * Negate the amount of money, i.e. if the amount is 10.0 CAD the negation returns -10.0 CAD
     * @return A new instance of the money class initialized with the new negated money amount.
     */
    public Money negate() {
        // @TODO:  Fill in the code for this
        double negate = this.amount;

        negate = negate - (negate * 2);

        return new Money(negate, this.currency);
    }

    /**
     * Compare two Money objects.
     * compareTo is required because the class implements the Comparable interface.
     * (Remember the universalValue method, and that Integers already implement Comparable).
     * Also, since compareTo must take an Object, you will have to explicitly downcast it to a Money.
     * @return 0 if the values of the two money are equal.
     * A negative integer if this Money is less valuable than the other Money.
     * A positive integer if this Money is more valuable than the other Money.
     */
    public int compareTo(Object other) {
        // @TODO:  Fill in the code for this
        double checkValue = 0;
        Money newObject = (Money)other;
        double actual = 0.0;
        double expected = 0.0;

        actual = this.getUniversalValue();
        expected = newObject.getUniversalValue();

        if (actual == expected) {
            checkValue = 0.0;
        }
        else if (actual > expected)
        {
            checkValue =  (actual - expected);
        }
        else {
            checkValue =  (actual - expected);
        }
        return (int) checkValue;
    }
}
