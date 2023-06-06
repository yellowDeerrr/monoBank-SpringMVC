package bank.monobank.controllers.onlineCard;

import bank.monobank.Tables.userCards.UserCards;
import bank.monobank.repositores.userCardsRepository.UserCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewInfoCardController {
    @Autowired
    private UserCardsRepository userCardsRepository;

    @GetMapping("/OnlineCard/viewInfoCard")
    public String WithdrawMoney(){
        return "OnlineCard/viewInfoCard";
    }

    @PostMapping("/OnlineCard/viewInfoCard")
    public String getCard(@RequestParam String userNumber, @RequestParam String userNumberCard, Model model){
        List<UserCards> user = userCardsRepository.findAllByUserNumberAndUserNumberCard(userNumber, userNumberCard);
        if (user.isEmpty()) {
            model.addAttribute("errorMessage", "Something is not correct");
        } else {
            model.addAttribute("user", user);
        }
        return "OnlineCard/viewInfoCard";
    }
}
