package currencyconverter.repository;

import currencyconverter.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.MANDATORY)
public interface ConversionRequestRepository extends JpaRepository<Request, Integer> {

}
