package currencyconverter.domain;

import javax.persistence.*;

@Entity
@Table(name="requests")
public class Request implements RequestDTO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NAME")
    @SequenceGenerator(name = "SEQ_NAME", sequenceName = "request_sequence")
    private Integer id;

    @Column(name = "fromCurrency")
    private String from;
    @Column(name = "toCurrency")
    private String to;

    public Request(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
