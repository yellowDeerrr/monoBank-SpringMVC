package bank.monobank.controllers.ATM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplenishCardController {
    @GetMapping("/ATM/ReplenishCard")
    public String replenishCard(){
        return "ATM/replenishCard";
    }
}
