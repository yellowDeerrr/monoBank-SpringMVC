package bank.monobank.repositores.userCardsRepository;

import bank.monobank.Tables.userCards.CardHistory;
import bank.monobank.Tables.userCards.UserCards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardHistoryRepository extends JpaRepository<CardHistory, Long> {
    List<CardHistory> findByUserNumberCard(String userNumberCard);
}
