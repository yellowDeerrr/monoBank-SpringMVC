package bank.monobank.controllers.ATM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ATMController {
    @GetMapping("/ATM")
    public String ATM(){
        return "ATM/ATM";
    }
}
