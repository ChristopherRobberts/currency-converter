package currencyconverter.presentation.controller;

public class ConversionForm {

    private String from;
    private String convto;
    private double amount;

    public double getAmount() {
        return this.amount;
    }

    public String getFrom() {
        return this.from;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFrom(String currency) {
        this.from = currency;
    }

    public String getConvto() {
        return this.convto;
    }

    public void setConvto(String currency) {
        this.convto = currency;
    }
}
