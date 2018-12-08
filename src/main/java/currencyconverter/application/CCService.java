package currencyconverter.application;

import currencyconverter.domain.Conversion;
import currencyconverter.domain.ConversionDTO;
import currencyconverter.domain.Request;
import currencyconverter.repository.ConversionRateRepository;
import currencyconverter.repository.ConversionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class CCService {

    @Autowired
    private ConversionRateRepository conversionRateRepository;
    @Autowired
    private ConversionRequestRepository conversionRequestRepository;

    public ConversionDTO getConvertedValue(String from) {
        return conversionRateRepository.findByToConvert(from);
    }

    public void addNewRequest(String from, String to) {
        conversionRequestRepository.save(new Request(from, to));
    }

    public long countNumberOfRequests() {
        return conversionRequestRepository.count();
    }

    public ConversionDTO updateConversion(String from, String to, double newValue) {
        System.out.println(from + " " + to + " " + newValue);
        Conversion conv = conversionRateRepository.findByToConvert(from);
        conv.updateValue(to, newValue);
        conversionRateRepository.save(conv);
        return conv;
    }
}