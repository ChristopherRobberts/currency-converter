package currencyconverter.domain;

public interface ConversionDTO {

    String getToConvert();

    double getDollar();

    double getSEK();

    double getEuro();

    double getPound();

    double getConval();

    void calculateConvertedValue(double amount, String convertTo);
}
