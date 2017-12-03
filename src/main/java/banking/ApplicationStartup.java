package banking;

import banking.model.User;
import banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

    @Autowired
    private UserService userService;

    /**
     * This function will be executed when the application starts and inserts a user
     * @param event
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        userService.save(new User("John", "Doe", "challenge", "17859648F"));
        return;
    }
}
