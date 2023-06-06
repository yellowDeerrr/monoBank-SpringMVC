package bank.monobank.controllers.onlineCard;

import bank.monobank.Tables.userCards.CardHistory;
import bank.monobank.Tables.userCards.UserCards;
import bank.monobank.repositores.userCardsRepository.UserCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class CreateNewCardMono {
    @Autowired
    private UserCardsRepository userCardsRepository;

    @GetMapping("/OnlineCard/createNewCardMono")
    public String createNewCardMono(){
        return "OnlineCard/createNewCardMono";
    }

    @PostMapping("/OnlineCard/createNewCardMono")
    public String newCard(@RequestParam String userNumberToFind, Model model){
        UserCardsRepository user = userCardsRepository.findByUserNumber(userNumberToFind);
        String[] card;
        String userNumberCard, userNumberCardForUser;
        if (user == null){
            card = createRandomNumberCard();
            userNumberCard = card[0];
            userNumberCardForUser = card[1];
            model.addAttribute("answer", "Your number card: " + userNumberCardForUser);
            UserCards userSave = new UserCards(userNumberToFind, userNumberCard, 0);
            userCardsRepository.save(userSave);
        }else{
            model.addAttribute("answer", "Number is already using");
        }
        return "OnlineCard/createNewCardMono";
    }

    public String[] createRandomNumberCard(){
        int max = 9999;
        int min = 1000;
        int range = max - min + 1;

        String random1 = Integer.toString((int)(Math.random() * range) + min);
        String random2 = Integer.toString((int)(Math.random() * range) + min);
        String random3 = Integer.toString((int)(Math.random() * range) + min);
        String random4 = Integer.toString((int)(Math.random() * range) + min);

        String userNumberCard = random1 + random2 + random3 + random4;
        String userNumberCardForUser = random1 + " " + random2 + " " + random3 + " " + random4;

        UserCards user = userCardsRepository.findByUserNumberCard(userNumberCard);
        if (user != null){
            createRandomNumberCard();
        }
        return new String[]{userNumberCard, userNumberCardForUser};
    }
}
