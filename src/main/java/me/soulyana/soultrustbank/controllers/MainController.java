package me.soulyana.soultrustbank.controllers;

import me.soulyana.soultrustbank.entities.AccountService;
import me.soulyana.soultrustbank.entities.User;
import me.soulyana.soultrustbank.entities.UserService;
import me.soulyana.soultrustbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService  accountService;

    @Autowired
    private TransactionRepository transactionRepository;



    @RequestMapping("/")
    public String showMainPage(Principal p) {
        //Principal allows...
        //Has Bank Logo, bank address, contact numbers, login section,
        //login button takes us to login page
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/acctsummary")
    public String showAcctSummary(Model model) {
        model.addAttribute("title", "Account Summary");
        model.addAttribute("acctsummary", "1");
        return "acctsummary";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        //model.addAttribute("user", new User());
        model.addAttribute("registration", "2");
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);

        if(result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Successfully Created!");
        }
        return "index";
    }

    @RequestMapping("/deposit")
    public String showDepositPage(Model model) {
        model.addAttribute("title", "Deposit");
        model.addAttribute("deposit", "3");
        return "deposit";
    }

    @RequestMapping("/withdrawl")
    public String showWithdrawlPage(Model model) {
        model.addAttribute("title", "Withdrawl");
        model.addAttribute("withdrawl", "4");
        return "withdrawl";
    }
}
