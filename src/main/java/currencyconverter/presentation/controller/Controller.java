package currencyconverter.presentation.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@Scope("session")
public class Controller {

    @GetMapping("/")
    public String mainPage() {
        return "homepage";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
