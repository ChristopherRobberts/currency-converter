package currencyconverter.repository;

import currencyconverter.domain.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ConversionRateRepository extends JpaRepository<Conversion, Long> {

    Conversion findByToConvert(String from);
}
