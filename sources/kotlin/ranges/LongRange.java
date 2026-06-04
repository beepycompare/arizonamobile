package kotlin.ranges;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PrimitiveRanges.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001$B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0082\u0004J\n\u0010 \u001a\u00020!H\u0096\u0080\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006%"}, d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", TtmlNode.START, "endInclusive", "<init>", "(JJ)V", "getStart", "()Ljava/lang/Long;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "Lkotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "contains", "", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LongRange extends LongProgression implements ClosedRange<Long>, OpenEndRange<Long> {
    public static final Companion Companion = new Companion(null);
    private static final LongRange EMPTY = new LongRange(1, 0);

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Long l) {
        return contains(l.longValue());
    }

    @Override // kotlin.ranges.ClosedRange
    public Long getStart() {
        return Long.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Long getEndExclusive() {
        if (getLast() == Long.MAX_VALUE) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return Long.valueOf(getLast() + 1);
    }

    public boolean contains(long j) {
        return getFirst() <= j && j <= getLast();
    }

    @Override // kotlin.ranges.LongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (isEmpty() && ((LongRange) obj).isEmpty()) {
                return true;
            }
            LongRange longRange = (LongRange) obj;
            return getFirst() == longRange.getFirst() && getLast() == longRange.getLast();
        }
        return false;
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Long.hashCode(getFirst()) * 31) + Long.hashCode(getLast());
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    /* compiled from: PrimitiveRanges.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/ranges/LongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongRange getEMPTY() {
            return LongRange.EMPTY;
        }
    }
}
