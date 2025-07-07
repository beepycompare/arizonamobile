package dagger.hilt.android;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
/* loaded from: classes4.dex */
public @interface AndroidEntryPoint {
    Class<?> value() default Void.class;
}
