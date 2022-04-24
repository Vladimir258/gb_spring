package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // todo 1 Создаем контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru");
        OrderService orderService = context.getBean(OrderService.class);

        orderService.createOrderFromProduct(3L);

//        Box box1 = context.getBean(Box.class);
//        Box box2 = context.getBean(Box.class);
//
//        System.out.println(box1.getColor());
//        System.out.println(box2.getColor());
//
//        box1.setColor("red");
//        System.out.println(box1.getColor());
//        System.out.println(box2.getColor());
//
//        box2.setColor("green");
//        System.out.println(box1.getColor());
//        System.out.println(box2.getColor());

        context.close();
    }
}
