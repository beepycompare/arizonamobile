package kotlin.internal.jdk8;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;
import kotlin.time.Instant;
import kotlin.time.jdk8.InstantConversionsJDK8Kt;
/* compiled from: JDK8PlatformImplementations.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001fB\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082\u0080\u0004J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004JA\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00122\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0014\u001a\u0002H\u000fH\u0096\u0080\u0004¢\u0006\u0002\u0010\u0015JN\u0010\u0016\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000f\"\n\b\u0002\u0010\u0017*\u0004\b\u0002H\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000f0\u00182\u0006\u0010\u0013\u001a\u0002H\u00102\u0006\u0010\u0019\u001a\u0002H\u0017H\u0096\u0080\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004\u0082\u0002\u0004\n\u0002\b9¨\u0006 "}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getOrDefault", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "map", "", "key", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent", "NewV", "Ljava/util/concurrent/ConcurrentMap;", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object computeIfAbsent$lambda$0(Object obj, Object obj2) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JDK8PlatformImplementations.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0007¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "", "Ljava/lang/Integer;", "Lkotlin/jvm/JvmField;", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = new ReflectSdkVersion();
        public static final Integer sdkVersion;

        private ReflectSdkVersion() {
        }

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                sdkVersion = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            sdkVersion = num2;
        }
    }

    private final boolean sdkIsNullOrAtLeast(int i) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion.intValue() >= i;
    }

    @Override // kotlin.internal.PlatformImplementations
    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        IntRange intRange = new IntRange(matcher.start(name), matcher.end(name) - 1);
        if (intRange.getStart().intValue() >= 0) {
            String group = matcher.group(name);
            Intrinsics.checkNotNullExpressionValue(group, "group(...)");
            return new MatchGroup(group, intRange);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.internal.PlatformImplementations
    public <K, V> V getOrDefault(Map<K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (sdkIsNullOrAtLeast(24)) {
            return map.getOrDefault(k, v);
        }
        V v2 = map.get(k);
        if (v2 == null) {
            if (map.containsKey(k)) {
                return null;
            }
            return v;
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.internal.PlatformImplementations
    public <K, V, NewV extends V> V computeIfAbsent(ConcurrentMap<K, V> map, K k, final NewV newValue) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (sdkIsNullOrAtLeast(24)) {
            final Function1 function1 = new Function1() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return JDK8PlatformImplementations.computeIfAbsent$lambda$0(newValue, obj);
                }
            };
            return map.computeIfAbsent(k, new Function() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Object invoke;
                    invoke = Function1.this.invoke(obj);
                    return invoke;
                }
            });
        }
        V putIfAbsent = map.putIfAbsent(k, newValue);
        return putIfAbsent == null ? newValue : putIfAbsent;
    }

    @Override // kotlin.internal.PlatformImplementations
    public Random defaultPlatformRandom() {
        return sdkIsNullOrAtLeast(34) ? new PlatformThreadLocalRandom() : super.defaultPlatformRandom();
    }

    @Override // kotlin.internal.PlatformImplementations
    public Clock getSystemClock() {
        return sdkIsNullOrAtLeast(26) ? new Clock() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations$getSystemClock$1
            @Override // kotlin.time.Clock
            public Instant now() {
                java.time.Instant now = java.time.Instant.now();
                Intrinsics.checkNotNullExpressionValue(now, "now(...)");
                return InstantConversionsJDK8Kt.toKotlinInstant(now);
            }
        } : new Clock() { // from class: kotlin.internal.jdk8.JDK8PlatformImplementations$getSystemClock$2
            @Override // kotlin.time.Clock
            public Instant now() {
                return Instant.Companion.fromEpochMilliseconds(System.currentTimeMillis());
            }
        };
    }
}
