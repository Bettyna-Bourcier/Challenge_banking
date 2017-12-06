package banking.repository;

import banking.model.Outgoings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutgoingsRepository extends JpaRepository<Outgoings, Integer> {
    List<Outgoings> findAll();
    Outgoings save(Outgoings outgoings);
}
