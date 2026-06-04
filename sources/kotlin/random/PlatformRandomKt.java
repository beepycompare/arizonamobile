package kotlin.random;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformRandom.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u0002H\u0081\u0088\u0004b\u0002\b\b\u001a\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0080\u0080\u0004¨\u0006\u000e"}, d2 = {"asJavaRandom", "Ljava/util/Random;", "Lkotlin/random/Random;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "asKotlinRandom", "defaultPlatformRandom", "Lkotlin/internal/InlineOnly;", "doubleFromParts", "", "hi26", "", "low27", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlatformRandomKt {
    public static final double doubleFromParts(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }

    public static final java.util.Random asJavaRandom(Random random) {
        java.util.Random impl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        AbstractPlatformRandom abstractPlatformRandom = random instanceof AbstractPlatformRandom ? (AbstractPlatformRandom) random : null;
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new KotlinRandom(random) : impl;
    }

    public static final Random asKotlinRandom(java.util.Random random) {
        Random impl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        KotlinRandom kotlinRandom = random instanceof KotlinRandom ? (KotlinRandom) random : null;
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new PlatformRandom(random) : impl;
    }

    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
}
