package currencyconverter.presentation.conv;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdminUpdateForm {

    @NotBlank(message = "you must select from")
    @NotNull
    private String from;
    @NotNull
    @NotBlank(message = "you must select to")
    private String convto;

    @NotNull
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
