package currencyconverter.domain;

import javax.persistence.*;

@Entity
@Table(name = "conversion_rates")
public class Conversion implements ConversionDTO {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "to_convert")
    private String toConvert;
    @Column(name = "SEK")
    private double SEK;
    @Column(name = "dollar")
    private double dollar;
    @Column(name = "euro")
    private double euro;
    @Column(name = "pound")
    private double pound;

    @Transient
    private double conval = 0;

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

    public void calculateConvertedValue(double amount, String to) {
        switch (to) {
            case "dollar":
                this.conval = amount * this.dollar;
                break;
            case "euro":
                this.conval = amount * this.euro;
                break;
            case "SEK":
                this.conval = amount * this.SEK;
                break;
            case "pound":
                this.conval = amount * this.pound;
                break;
            default:
                System.out.println("something went wrong chris!");
                break;
        }
    }

    public double getConval() {
        return this.conval;
    }

    public void setConval(double val) {
        this.conval = val;
    }

    public void updateValue(String to, double newValue) {
        switch (to) {
            case "dollar":
                this.dollar = newValue;
                break;
            case "euro":
                this.euro = newValue;
                break;
            case "SEK":
                this.SEK = newValue;
                break;
            case "pound":
                this.pound = newValue;
                break;
            default:
                System.out.println("something went wrong chris!");
                break;
        }
    }
}
