package java8_pratico.Cap12;

import java.lang.annotation.*;

// Container das anota��es
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Roles {
    Role[] value();
}
