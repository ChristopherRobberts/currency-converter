package currencyconverter.presentation.controller;

public class AdminUpdateForm {

    private String from;
    private String convto;
    private double newval;

    public String getFrom() {
        return this.from;
    }

    public String getConvto() {
        return this.convto;
    }

    public double getNewval() {
        return this.newval;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setConvto(String convto) {
        this.convto = convto;
    }

    public void setNewval(double newval) {
        this.newval = newval;
    }
}
