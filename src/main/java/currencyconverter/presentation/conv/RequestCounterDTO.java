package currencyconverter.presentation.conv;

public class RequestCounterDTO {
    private long count;

    public RequestCounterDTO(long count) {
        this.count = count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return this.count;
    }
}
