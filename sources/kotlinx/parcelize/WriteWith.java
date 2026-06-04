package kotlinx.parcelize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlinx.parcelize.Parceler;
/* compiled from: WriteWith.kt */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0000Ê\u0001\u000e\b\u0005\u0012\n\b\u0006\u0012\u0006\b\n0\u00078\bÊ\u0001\u0012\b\t\u0012\u000e\b\n\u0012\n\b\fJ\u0006\b\n0\u000b8\f¨\u0006\u0004"}, d2 = {"Lkotlinx/parcelize/WriteWith;", "P", "Lkotlinx/parcelize/Parceler;", "", "org.jetbrains.kotlin:parcelize-runtime", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "SOURCE", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "TYPE"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes5.dex */
public @interface WriteWith<P extends Parceler<?>> {
}
