package spring.impl;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.impl.config.AppConfig;
import spring.impl.model.User;
import spring.impl.service.UserService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Meredith", "mer@gmail.com", "111"));
        userService.add(new User("Sarah", "sarah@gmail.com", "111"));
        userService.add(new User("Baily", "bal@gmail.com", "111"));
        userService.add(new User("Amelia", "amely@gmail.com", "111"));

        List<User> users = userService.listUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
