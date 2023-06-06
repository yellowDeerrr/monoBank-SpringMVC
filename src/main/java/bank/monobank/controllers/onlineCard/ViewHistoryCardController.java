package bank.monobank.controllers.onlineCard;

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

import java.util.List;

@Controller
public class ViewHistoryCardController {
    @Autowired
    private UserCardsRepository userCardsRepository;
    @Autowired
    private CardHistoryRepository cardHistoryRepository;
    @GetMapping("/OnlineCard/viewHistoryCard")
    public String viewHistoryCard(){
        return "OnlineCard/viewHistoryCard";
    }

    @PostMapping("/OnlineCard/viewHistoryCard")
    public String outHistory(@RequestParam String userNumber, @RequestParam String userNumberCard, Model model){
        UserCards userCards = userCardsRepository.findByUserNumberAndUserNumberCard(userNumber, userNumberCard);
        if (userCards != null){
            List<CardHistory> cardHistory = cardHistoryRepository.findByUserNumberCard(userNumberCard);
            if (cardHistory.isEmpty()){
                model.addAttribute("errorMessage", "History of card is empty");
            }else{
                model.addAttribute("history", cardHistory);
            }
        }else{
            model.addAttribute("errorMessage", "Something is not correct");
        }
        return "OnlineCard/viewHistoryCard";
    }
}
