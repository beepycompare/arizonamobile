package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
/* compiled from: JvmFlagAnnotations.kt */
@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\"\b\u0003\u0012\u001e\b\u0004\u0012\u001a\b\fJ\u0006\b\n0\u00058\u0006J\u0006\b\n0\u00058\u0007J\u0006\b\n0\u00058\bÊ\u0001\u000e\b\t\u0012\n\b\n\u0012\u0006\b\n0\u000b8\fÊ\u0001\u0002\b\r¨\u0006\u0002"}, d2 = {"Lkotlin/jvm/Synchronized;", "", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "SOURCE", "Lkotlin/annotation/MustBeDocumented;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Documented
/* loaded from: classes5.dex */
public @interface Synchronized {
}
