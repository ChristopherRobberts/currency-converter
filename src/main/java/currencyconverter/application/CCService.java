package currencyconverter.application;

import currencyconverter.domain.Conversion;
import currencyconverter.domain.ConversionDTO;
import currencyconverter.repository.ConversionRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class CCService {

    @Autowired
    private ConversionRateRepository conversionRateRepository;


    public ConversionDTO getConvertedValue(String from, String to) {
        return conversionRateRepository.findByToConvert(from);
    }

    public void addConversionRate() {
        
    }
}