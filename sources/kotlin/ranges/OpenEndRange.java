package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Range.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0017\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\nH\u0096\u0080\u0004R\u0013\u0010\u0004\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011Ê\u0001\u0010\b\u0012\u0012\f\b\u0013\u0012\b\b\fJ\u0004\b\t0\u0014¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/OpenEndRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "", TtmlNode.START, "getStart", "()Ljava/lang/Comparable;", "endExclusive", "getEndExclusive", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OpenEndRange<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndExclusive();

    T getStart();

    boolean isEmpty();

    /* compiled from: Range.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(OpenEndRange<T> openEndRange, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value.compareTo(openEndRange.getStart()) >= 0 && value.compareTo(openEndRange.getEndExclusive()) < 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(OpenEndRange<T> openEndRange) {
            return openEndRange.getStart().compareTo(openEndRange.getEndExclusive()) >= 0;
        }
    }
}
