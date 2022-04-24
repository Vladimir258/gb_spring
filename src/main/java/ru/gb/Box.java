package ru.gb;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Setter
@ToString
// todo 2 - Помечаем аннотацией @Component и теперь это SpringBean (объект управляемый контекстом)
@Component
// todo 3 - Помечаем аннотацией @Scope("prototype") - каждый раз прося сделать bean, будет создаваться новый bean
@Scope("prototype")
public class Box {
    private String color;

    @PostConstruct
    public void init() {
        color = "Grey";
    }

    public Box() {}

}
