package banking.service;

import banking.model.Outgoings;
import banking.repository.OutgoingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutgoingsService {

    @Autowired
    private OutgoingsRepository outgoingsRepository;

    public void save(Outgoings outgoings) {
        outgoingsRepository.save(outgoings);
    }
}