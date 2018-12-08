package currencyconverter.repository;

import currencyconverter.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ConversionRequestRepository extends JpaRepository<Request, Integer> {

}
