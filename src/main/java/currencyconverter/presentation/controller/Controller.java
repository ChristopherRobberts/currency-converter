package currencyconverter.presentation.controller;

import currencyconverter.application.CCService;
import currencyconverter.domain.ConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
@Scope("session")
public class Controller {

    @Autowired
    private CCService ccService;
    private ConversionDTO conversion;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("conversionDetails", new ConversionForm());
        if (this.conversion != null) {
            model.addAttribute("conversionComplete", conversion);
        }

        return "homepage";
    }

    @PostMapping("/conversionRequest")
    public String makeConversion(@ModelAttribute ConversionForm conversionDetails, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("conversionDetails", new ConversionForm());
            return null;
        }

        this.conversion = this.ccService.getConvertedValue(conversionDetails.getFrom(), conversionDetails.getConvto());
        this.conversion.calculateConvertedValue(conversionDetails.getAmount(), conversionDetails.getConvto());
        System.out.println(conversionDetails.getAmount() + " " + conversionDetails.getFrom() + " " + conversionDetails.getConvto());
        model.addAttribute("conversionDetails", conversionDetails);
        model.addAttribute("conversionComplete", conversion);

        return "homepage";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
