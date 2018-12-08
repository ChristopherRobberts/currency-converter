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
    private RequestCounter req;

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

        String fromCurrency = conversionDetails.getFrom();
        String toCurrency = conversionDetails.getConvto();

        this.ccService.addNewRequest(fromCurrency, toCurrency);
        this.conversion = this.ccService.getConvertedValue(fromCurrency);
        this.conversion.calculateConvertedValue(conversionDetails.getAmount(), toCurrency);

        model.addAttribute("conversionDetails", conversionDetails);
        model.addAttribute("conversionComplete", conversion);

        return "homepage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        long count = ccService.countNumberOfRequests();
        req = new RequestCounter(count);
        model.addAttribute("counter", req);
        return "admin";
    }
}
