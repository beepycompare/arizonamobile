package kotlin.jvm;

import com.facebook.internal.NativeProtocol;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
/* compiled from: JvmPlatformAnnotations.kt */
@Target({ElementType.TYPE})
@Deprecated(message = "Please migrate to kotlin.jvm.KotlinActual in kotlin-annotations-jvm. ImplicitlyActualizedByJvmDeclaration will be dropped in future versions of Kotlin. See https://youtrack.jetbrains.com/issue/KT-67202")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\u000e\b\u0003\u0012\n\b\u0004\u0012\u0006\b\n0\u00058\u0006Ê\u0001\u0012\b\u0007\u0012\u000e\b\b\u0012\n\b\fJ\u0006\b\n0\t8\nÊ\u0001\u0002\b\u000bÊ\u0001\u0002\b\fÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¨\u0006\u0002"}, d2 = {"Lkotlin/jvm/ImplicitlyActualizedByJvmDeclaration;", "", "kotlin-stdlib", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "Lkotlin/ExperimentalMultiplatform;", "Lkotlin/annotation/MustBeDocumented;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/Deprecated;", "message", "Please migrate to kotlin.jvm.KotlinActual in kotlin-annotations-jvm. ImplicitlyActualizedByJvmDeclaration will be dropped in future versions of Kotlin. See https://youtrack.jetbrains.com/issue/KT-67202", "Lkotlin/DeprecatedSinceKotlin;", "errorSince", "2.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Documented
@DeprecatedSinceKotlin(errorSince = "2.1")
/* loaded from: classes5.dex */
public @interface ImplicitlyActualizedByJvmDeclaration {
}
