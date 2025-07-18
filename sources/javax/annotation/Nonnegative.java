package javax.annotation;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface Nonnegative {
    When when() default When.ALWAYS;

    /* loaded from: classes3.dex */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnegative nonnegative, Object obj) {
            if (!(obj instanceof Number)) {
                return When.NEVER;
            }
            Number number = (Number) obj;
            if (!(number instanceof Long) ? !(!(number instanceof Double) ? !(number instanceof Float) ? number.intValue() >= 0 : number.floatValue() >= 0.0f : number.doubleValue() >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : number.longValue() < 0) {
                return When.NEVER;
            }
            return When.ALWAYS;
        }
    }
}
