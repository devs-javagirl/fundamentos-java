package java8_pratico.Cap12;

import java.lang.annotation.*;

// Definindo a anotação repetível
@Repeatable(Roles.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Role {
    String value();
}
