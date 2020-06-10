package bankingApp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Currency {
    private String name;
    private double rate;
//    Currency[] cur = {new Currency("CAD",0.75),new Currency("EUR",1.14),new Currency("HKD",0.13)};

    public Currency(String currencyCode, double rate) {
        this.name = currencyCode;
        this.rate = rate;
    }


    public double valueInUSD(double amount) {
        double amt = 0.0;
        if(this.name == "CAD")
        {
            amt = (amount*0.75);
        }
        else if (this.name == "EUR")
        {
            amt = (amount*1.14);
        }
        else if(this.name == "HKD")
        {
            amt = (amount*0.13);
        }
        double rate1 = round(amt, 2);
        return rate1;

    }
    public String getName() {
        return this.name;

    }

    public double getRate() {
        return this.rate;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }
    public double valueInThisCurrency(double amount, Currency othercurrency) {

        double currencyValue = 0.0;

        if(this.name.equals("CAD"))
        {
            if(othercurrency.name.equals("EUR") )
            {
                double currency1 = amount*0.75;
                double currency2 = currency1/1.14;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("HKD") )
            {
                double currency1 = amount*0.75;
                double currency2 = currency1/0.13;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("CAD") ) {
                return amount;
            }
            else {
                return currencyValue;
            }
        }
        else if(this.name.equals("EUR"))
        {
            if(othercurrency.name.equals("CAD") )
            {
                double currency1 = amount*1.14;
                double currency2 = currency1/0.75;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("HKD") )
            {
                double currency1 = amount*1.14;
                double currency2 = currency1/0.13;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("EUR") ) {
                return amount;
            }
            else {
                return currencyValue;
            }
        }
        else if(this.name.equals("HKD"))
        {
            if(othercurrency.name.equals("CAD") )
            {
                double currency1 = amount*0.13;
                double currency2 = currency1/0.75;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("EUR") )
            {
                double currency1 = amount*0.13;
                double currency2 = currency1/1.14;
                currencyValue = round(currency2 , 2);
                return currencyValue;
            }
            else if(othercurrency.name.equals("HKD") ) {
                return amount;
            }
            else {
                return currencyValue;
            }
        }

        else {
            return currencyValue;
        }

        // @TODO:  Fill in the code for this
        // Round all final results to 2 decimal points. See round() function.

    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}