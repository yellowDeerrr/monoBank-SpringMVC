package bank.monobank.controllers.onlineCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnlineCardController {
    @GetMapping("/OnlineCard")
    public String onlineCard(){
        return "OnlineCard/onlineCard";
    }
}
