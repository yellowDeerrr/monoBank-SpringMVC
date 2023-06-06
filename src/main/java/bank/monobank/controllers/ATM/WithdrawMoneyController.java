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
public class WithdrawMoneyController {
    @Autowired
    private UserCardsRepository userCardsRepository;
    @Autowired
    private CardHistoryRepository cardHistoryRepository;

    @GetMapping("/ATM/WithdrawMoney")
    public String WithdrawMoney(){
        return "ATM/withdrawMoney";
    }

    @PostMapping("/ATM/WithdrawMoney")
    public String withdrawMoney(@RequestParam String userNumber, @RequestParam String userNumberCard, @RequestParam int howMuch, Model model){
        UserCards user = userCardsRepository.findByUserNumberAndUserNumberCard(userNumber, userNumberCard);
        if (user == null) {
            model.addAttribute("message", "Something is not correct");
        } else {
            int userMoney = user.getUserMoney() - howMuch;
            if (userMoney >= 0){
                user.setUserMoney(userMoney);
                userCardsRepository.save(user);

                CardHistory cardHistory = new CardHistory(userNumberCard, "ATM", "-" + howMuch, userMoney, new Timestamp(System.currentTimeMillis()));
                cardHistoryRepository.save(cardHistory);

                model.addAttribute("message", "Successful");
            }else{
                model.addAttribute("message", "You don't have a money");
            }

        }
        return "ATM/withdrawMoney";
    }
}
