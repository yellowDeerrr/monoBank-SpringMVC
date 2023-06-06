package bank.monobank.controllers.ATM;

import bank.monobank.Tables.userCards.CardHistory;
import bank.monobank.Tables.userCards.UserCards;
import bank.monobank.repositores.userCardsRepository.CardHistoryRepository;
import bank.monobank.repositores.userCardsRepository.UserCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class ReplenishCardController {
    @Autowired
    private UserCardsRepository userCardsRepository;
    @Autowired
    private CardHistoryRepository cardHistoryRepository;

    @GetMapping("/ATM/ReplenishCard")
    public String replenishCard(){
        return "ATM/replenishCard";
    }

    @PostMapping("/ATM/ReplenishCard")
    public String getCardToReplenishCard(@RequestParam String userNumberCard, @RequestParam int howMuch, Model model){
        UserCards user = userCardsRepository.findByUserNumberCard(userNumberCard);
        if (user == null) {
            model.addAttribute("message", "Number card is not correct");
        } else {
            int userMoney = user.getUserMoney() + howMuch;
            user.setUserMoney(userMoney);
            userCardsRepository.save(user);
            CardHistory cardHistory = new CardHistory(userNumberCard, "ATM", "+" + howMuch, userMoney, new Timestamp(System.currentTimeMillis()));
            cardHistoryRepository.save(cardHistory);
            model.addAttribute("message", "Successful");
        }

        return "ATM/replenishCard";
    }
}
