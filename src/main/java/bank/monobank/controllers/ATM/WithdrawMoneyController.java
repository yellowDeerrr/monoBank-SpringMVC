package bank.monobank.controllers.ATM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WithdrawMoneyController {
    @GetMapping("/ATM/WithdrawMoney")
    public String WithdrawMoney(){
        return "ATM/withdrawMoney";
    }
}
