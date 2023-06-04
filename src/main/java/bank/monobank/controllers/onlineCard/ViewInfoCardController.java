package bank.monobank.controllers.onlineCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewInfoCardController {
    @GetMapping("/OnlineCard/viewInfoCard")
    public String WithdrawMoney(){
        return "OnlineCard/viewInfoCard";
    }

    @PostMapping("/OnlineCard/viewInfoCard")
    public void getCard(){

    }
}
