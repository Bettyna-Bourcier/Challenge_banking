package banking;

import banking.model.Outgoing;
import banking.model.OutgoingTypeEnum;
import banking.model.User;
import banking.service.OutgoingsService;
import banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{

    @Autowired
    private UserService userService;

    @Autowired
    private OutgoingsService OutgoingService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * This function will be executed when the application starts and inserts a user and some Outgoing to test
     * @param event
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        User user1 =  new User("Expertus", "Technologies", "NH8569MP5",  bCryptPasswordEncoder.encode("challenge"));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 2), OutgoingTypeEnum.Accomodation, 875.00f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 12), OutgoingTypeEnum.Food, 86.23f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 4), OutgoingTypeEnum.Food, 56.50f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 15), OutgoingTypeEnum.Food, 96.12f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 22), OutgoingTypeEnum.Food, 56.30f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 23), OutgoingTypeEnum.Food, 78.25f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 28), OutgoingTypeEnum.Health, 52f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 30), OutgoingTypeEnum.Bank, 12f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 15), OutgoingTypeEnum.Hobbies, 38f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 8), OutgoingTypeEnum.Hobbies, 13.20f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 26), OutgoingTypeEnum.Hobbies, 63.50f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 7), OutgoingTypeEnum.Shopping, 120.36f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 20), OutgoingTypeEnum.Shopping, 23.30f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 18), OutgoingTypeEnum.Shopping, 25f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 17), OutgoingTypeEnum.Shopping, 45f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 4), OutgoingTypeEnum.Shopping, 35.25f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 8), OutgoingTypeEnum.Car, 45.23f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 26), OutgoingTypeEnum.Car, 36.20f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 29), OutgoingTypeEnum.Car , 23.36f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 18), OutgoingTypeEnum.Car , 39.56f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 1), OutgoingTypeEnum.Professional , 27.23f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 9), OutgoingTypeEnum.Professional , 12.30f));
        user1.addOutgoing(new Outgoing(createDate(2017, 12, 26), OutgoingTypeEnum.Subscriptions , 75f));
        user1.addOutgoing(new Outgoing(createDate(2017, 11, 22), OutgoingTypeEnum.Subscriptions , 89f));

        userService.save(user1);

        return;
    }
}
