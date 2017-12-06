package banking;

import banking.model.Outgoings;
import banking.model.OutgoingsTypeEnum;
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
    private OutgoingsService outgoingsService;

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
     * This function will be executed when the application starts and inserts a user and some outgoings to test
     * @param event
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        User user1 =  new User("John", "Doe", "NH8569MP5",  bCryptPasswordEncoder.encode("challenge"));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 2), OutgoingsTypeEnum.Accomodation, 875.00f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 12), OutgoingsTypeEnum.Food, 86.23f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 4), OutgoingsTypeEnum.Food, 56.50f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 15), OutgoingsTypeEnum.Food, 96.12f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 22), OutgoingsTypeEnum.Food, 56.30f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 23), OutgoingsTypeEnum.Food, 78.25f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 28), OutgoingsTypeEnum.Health, 52f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 30), OutgoingsTypeEnum.Bank, 12f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 15), OutgoingsTypeEnum.Hobbies, 38f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 8), OutgoingsTypeEnum.Hobbies, 13.20f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 26), OutgoingsTypeEnum.Hobbies, 63.50f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 7), OutgoingsTypeEnum.Shopping, 120.36f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 20), OutgoingsTypeEnum.Shopping, 23.30f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 18), OutgoingsTypeEnum.Shopping, 25f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 17), OutgoingsTypeEnum.Shopping, 45f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 4), OutgoingsTypeEnum.Shopping, 35.25f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 8), OutgoingsTypeEnum.Car, 45.23f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 26), OutgoingsTypeEnum.Car, 36.20f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 29), OutgoingsTypeEnum.Car , 23.36f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 18), OutgoingsTypeEnum.Car , 39.56f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 1), OutgoingsTypeEnum.Professional , 27.23f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 9), OutgoingsTypeEnum.Professional , 12.30f));
        user1.addOutgoing(new Outgoings(createDate(2017, 12, 26), OutgoingsTypeEnum.Subscriptions , 75f));
        user1.addOutgoing(new Outgoings(createDate(2017, 11, 22), OutgoingsTypeEnum.Subscriptions , 89f));

        userService.save(user1);

        return;
    }
}
