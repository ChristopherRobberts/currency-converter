package currencyconverter.repository;

import currencyconverter.domain.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.MANDATORY)
public interface ConversionRateRepository extends JpaRepository<Conversion, Long> {

    Conversion findByToConvert(String from);
}
