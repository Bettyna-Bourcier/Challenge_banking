package banking.repository;


import banking.model.Outgoing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutgoingRepository extends JpaRepository<Outgoing, Integer> {
    List<Outgoing> findAll();
    Outgoing save(Outgoing outgoing);
}
