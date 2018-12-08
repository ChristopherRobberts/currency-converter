package currencyconverter.presentation.controller;

public class RequestCounter {
    private long count;

    public RequestCounter(long count) {
        this.count = count;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
