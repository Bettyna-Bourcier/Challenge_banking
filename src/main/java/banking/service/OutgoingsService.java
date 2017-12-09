package banking.service;

import banking.model.Outgoing;
import banking.repository.OutgoingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutgoingsService {

    @Autowired
    private OutgoingRepository outgoingRepository;

    public void save(Outgoing outgoing) {
        outgoingRepository.save(outgoing);
    }
}