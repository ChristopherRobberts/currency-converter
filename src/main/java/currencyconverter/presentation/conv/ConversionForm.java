package currencyconverter.presentation.conv;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ConversionForm {

    @NotNull
    private double amount;

    @NotEmpty
    @NotBlank
    private String from;

    @NotEmpty
    @NotBlank
    private String convto;

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
