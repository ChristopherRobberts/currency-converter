package currencyconverter.application;

import currencyconverter.domain.Conversion;
import currencyconverter.domain.ConversionDTO;
import currencyconverter.domain.Request;
import currencyconverter.repository.ConversionRateRepository;
import currencyconverter.repository.ConversionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
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
        Conversion conversionFrom = conversionRateRepository.findByToConvert(from);
        Conversion conversionTo = conversionRateRepository.findByToConvert(to);
        conversionFrom.updateValue(to, newValue);
        double currentValue = conversionTo.getReferredValue(from);

        conversionTo.updateValue(from, currentValue/newValue);
        conversionRateRepository.save(conversionFrom);
        conversionRateRepository.save(conversionTo);
        return conversionFrom;
    }
}