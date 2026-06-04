package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.internal.NativeProtocol;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: _Comparisons.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\u001aW\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\b\u001aO\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\f\u001a[\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000e\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u000f\u001aW\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\b\u001aO\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\f\u001a[\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000e\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u000f¨\u0006\u0012"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "1.4", "minOf", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes5.dex */
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public static final <T> T maxOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) ComparisonsKt.maxOf(t, ComparisonsKt.maxOf(t2, t3, comparator), comparator);
    }

    public static final <T> T maxOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    public static final <T> T maxOf(T t, T[] other, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> T minOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) ComparisonsKt.minOf(t, ComparisonsKt.minOf(t2, t3, comparator), comparator);
    }

    public static final <T> T minOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }

    public static final <T> T minOf(T t, T[] other, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }
}
