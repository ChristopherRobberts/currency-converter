package currencyconverter.domain;

import javax.persistence.*;

@Entity
@Table(name = "conversion_rates")
public class Conversion implements ConversionDTO {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "to_convert", nullable = false)
    private String toConvert;
    @Column(name = "SEK", nullable = false)
    private double SEK;
    @Column(name = "dollar", nullable = false)
    private double dollar;
    @Column(name = "euro", nullable = false)
    private double euro;
    @Column(name = "pound", nullable = false)
    private double pound;

    @Transient
    private double conval = 0;
    private final static String SEK_NAME = "SEK";
    private final static String DOLLAR_NAME = "dollar";
    private final static String EURO_NAME = "euro";
    private final static String POUND_NAME = "pound";

    public Conversion() {

    }

    public String getToConvert() {
        return this.toConvert;
    }

    public double getSEK() {
        return this.SEK;
    }

    public double getDollar() {
        return this.dollar;
    }

    public double getEuro() {
        return this.euro;
    }

    public double getPound() {
        return this.pound;
    }

    public void setSEK(double newRate) {
        this.SEK = newRate;
    }

    public void setDollar(double newRate) {
        this.dollar = newRate;
    }

    public void setEuro(double newRate) {
        this.euro = newRate;
    }

    public void setPound(double newRate) {
        this.pound = newRate;
    }

    public double getConval() {
        return this.conval;
    }

    public void setConval(double val) {
        this.conval = val;
    }

    public void updateValue(String to, double newValue) {
        switch (to) {
            case DOLLAR_NAME:
                this.dollar = newValue;
                break;
            case EURO_NAME:
                this.euro = newValue;
                break;
            case SEK_NAME:
                this.SEK = newValue;
                break;
            case POUND_NAME:
                this.pound = newValue;
                break;
            default:
                break;
        }
    }

    public void calculateConvertedValue(double amount, String to) {
        switch (to) {
            case DOLLAR_NAME:
                this.conval = amount * this.dollar;
                break;
            case EURO_NAME:
                this.conval = amount * this.euro;
                break;
            case SEK_NAME:
                this.conval = amount * this.SEK;
                break;
            case POUND_NAME:
                this.conval = amount * this.pound;
                break;
            default:
                break;
        }
    }

    public double getReferredValue(String curr) {
        switch (curr) {
            case DOLLAR_NAME:
                return this.dollar;
            case EURO_NAME:
                return this.euro;
            case SEK_NAME:
                return this.SEK;
            case POUND_NAME:
                return this.pound;
            default:
                break;
        }

        return -1;
    }
}
