package currencyconverter.domain;

public interface RequestDTO {

    Integer getId();

    String getFrom();

    String getTo();

    void setCount(long count);
}
