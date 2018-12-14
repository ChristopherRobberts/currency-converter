package currencyconverter.presentation.conv;

import currencyconverter.application.CCService;
import currencyconverter.domain.ConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


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
    public String makeConversion(@ModelAttribute @Valid ConversionForm conversionForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("should enter here and return");
            model.addAttribute("conversionDetails", conversionForm);
            return "homepage";
        }

        String fromCurrency = conversionForm.getFrom();
        String toCurrency = conversionForm.getConvto();

        this.ccService.addNewRequest(fromCurrency, toCurrency);
        System.out.println(toCurrency);
        this.conversion = this.ccService.getConvertedValue(fromCurrency);
        this.conversion.calculateConvertedValue(conversionForm.getAmount(), toCurrency);

        model.addAttribute("conversionDetails", conversionForm);
        model.addAttribute("conversionComplete", conversion);
        return "homepage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        long count = ccService.countNumberOfRequests();
        model.addAttribute("counter", new RequestCounterDTO(count));
        model.addAttribute("update", new AdminUpdateForm());
        model.addAttribute("updated", conversion);
        return "admin";
    }

    @PostMapping("/updateRequest")
    public String makeUpdate(@ModelAttribute @Valid AdminUpdateForm adminUpdateForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("update", adminUpdateForm);
            return "admin";
        }

        long count = ccService.countNumberOfRequests();
        this.conversion = ccService.updateConversion(adminUpdateForm.getFrom(),
                adminUpdateForm.getConvto(), adminUpdateForm.getNewval());

        model.addAttribute("counter", new RequestCounterDTO(count));
        model.addAttribute("update", adminUpdateForm);
        model.addAttribute("updated", conversion);

        return "admin";
    }
}
