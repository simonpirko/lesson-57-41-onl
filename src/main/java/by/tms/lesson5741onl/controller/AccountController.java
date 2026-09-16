package by.tms.lesson5741onl.controller;

import by.tms.lesson5741onl.entity.Account;
import by.tms.lesson5741onl.repository.AccountRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/reg")
    public String registration() {
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(Account account) {
        accountRepository.save(account);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allAccounts(Model model) {
        List<Account> all = accountRepository.findAll();
        model.addAttribute("accounts", all);
        return "all";
    }
}
