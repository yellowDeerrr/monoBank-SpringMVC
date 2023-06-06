package bank.monobank.controllers.admin;

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

import java.awt.*;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private CardHistoryRepository cardHistoryRepository;
    @Autowired
    private UserCardsRepository userCardsRepository;
    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @PostMapping("/admin")
    public String admin(@RequestParam String login, @RequestParam String password, Model model){
        if (login.equals("admin") && password.equals("admin")){
            model.addAttribute("successful", "Control panel");
            return "admin/admin";
        }else{
            model.addAttribute("errorMessage", "error");
            return "admin/admin";
        }
    }

    @GetMapping("/admin/controlPanel")
    public String getAdminControlPanel(){
        return "admin/controlPanel";
    }

    @PostMapping("/admin/controlPanel")
    public String controPanel(@RequestParam String history, Model model){
        if (history.equals("history")){
            List<CardHistory> cardHistory = cardHistoryRepository.findAll();
            model.addAttribute("history", cardHistory);
            return "admin/controlPanel";
        } else if(history.equals("users")){
            List<UserCards> userCards = userCardsRepository.findAll();
            model.addAttribute("users", userCards);
            return "admin/controlPanel";
        }
        return "admin/controlPanel";
    }
}
