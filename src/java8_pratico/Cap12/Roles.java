package java8_pratico.Cap12;

import java.lang.annotation.*;

// Container das anotações
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Roles {
    Role[] value();
}
