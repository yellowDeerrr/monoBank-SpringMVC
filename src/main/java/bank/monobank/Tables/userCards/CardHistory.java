package bank.monobank.Tables.userCards;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class CardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userNumberCard;

    @Column(name = "from_location")
    private String from;

    @Column
    private String sum;

    @Column(name = "left_on_the_balance")
    private int leftOnTheBalance;

    @Column
    private Timestamp time;
    public CardHistory(){}

    public CardHistory(String userNumberCard, String from, String sum, int leftOnTheBalance, Timestamp time) {
        this.userNumberCard = userNumberCard;
        this.from = from;
        this.sum = sum;
        this.leftOnTheBalance = leftOnTheBalance;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNumberCard() {
        return userNumberCard;
    }

    public void setUserNumberCard(String userNumberCard) {
        this.userNumberCard = userNumberCard;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public int getLeftOnTheBalance() {
        return leftOnTheBalance;
    }

    public void setLeftOnTheBalance(int leftOnTheBalance) {
        this.leftOnTheBalance = leftOnTheBalance;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
