package bank.monobank.Tables.userCards;

import jakarta.persistence.*;

@Entity
public class UserCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userNumber;
    @Column
    private String userNumberCard;
    @Column
    private int userMoney;

    public UserCards() {
    }

    public UserCards(String userNumber, String userNumberCard, int userMoney) {
        this.userNumber = userNumber;
        this.userNumberCard = userNumberCard;
        this.userMoney = userMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserNumberCard() {
        return userNumberCard;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public void setUserNumberCard(String userNumberCard) {
        this.userNumberCard = userNumberCard;
    }
}
