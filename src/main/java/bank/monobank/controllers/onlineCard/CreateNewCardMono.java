package bank.monobank.controllers.onlineCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateNewCardMono {
    @GetMapping("/OnlineCard/createNewCardMono")
    public String createNewCardMono(){
        return "OnlineCard/createNewCardMono";
    }
}
