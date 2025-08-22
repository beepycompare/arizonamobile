package jakarta.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
/* loaded from: classes5.dex */
public @interface Named {
    String value() default "";
}
