package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {

        String message;
        Scanner scanner = new Scanner(System.in);
        boolean quit;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        rabbitTemplate.setRoutingKey("chat_messages");

        System.out.println("Input a message, we will sent it for you (q for quit)");
        do {
            message = scanner.nextLine();
            quit = message.equals("q");
            if (!quit && !message.equals("")){
                rabbitTemplate.convertAndSend(message);
                System.out.println("Message sent. Input a message, we will sent it for you (q for quit)");
            }
        } while (!quit);
        System.out.println("Bye");
    }
}
