package kotlin.time.jdk8;

import com.facebook.internal.NativeProtocol;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InstantConversions.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b\u001a.\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b¨\u0006\n"}, d2 = {"toJavaInstant", "Ljava/time/Instant;", "Lkotlin/time/Instant;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "toKotlinInstant", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, pn = "kotlin.time", xi = 48)
/* loaded from: classes5.dex */
public final class InstantConversionsJDK8Kt {
    public static final Instant toJavaInstant(kotlin.time.Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Instant ofEpochSecond = Instant.ofEpochSecond(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(...)");
        return ofEpochSecond;
    }

    public static final kotlin.time.Instant toKotlinInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return kotlin.time.Instant.Companion.fromEpochSeconds(instant.getEpochSecond(), instant.getNano());
    }
}
