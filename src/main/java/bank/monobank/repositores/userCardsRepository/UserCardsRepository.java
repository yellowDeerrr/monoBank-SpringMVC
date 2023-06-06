package bank.monobank.repositores.userCardsRepository;

import bank.monobank.Tables.userCards.UserCards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCardsRepository extends JpaRepository<UserCards, Long> {
    UserCardsRepository findByUserNumber(String userNumber);

    UserCards findByUserNumberCard(String userNumberCard);

    List<UserCards> findAllByUserNumberAndUserNumberCard(String userNumber, String userNumberCard);

    UserCards findByUserNumberAndUserNumberCard(String userNumber, String userNumberCard);
}
