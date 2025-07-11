package kotlin.ranges;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0011\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", TtmlNode.START, "endExclusive", "<init>", "(DD)V", "_start", "_endExclusive", "getStart", "()Ljava/lang/Double;", "getEndExclusive", "lessThanOrEquals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "contains", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    private final boolean lessThanOrEquals(double d, double d2) {
        return d <= d2;
    }

    public OpenEndDoubleRange(double d, double d2) {
        this._start = d;
        this._endExclusive = d2;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Double d) {
        return contains(d.doubleValue());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getStart() {
        return Double.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    public boolean contains(double d) {
        return d >= this._start && d < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenEndDoubleRange) {
            if (isEmpty() && ((OpenEndDoubleRange) obj).isEmpty()) {
                return true;
            }
            OpenEndDoubleRange openEndDoubleRange = (OpenEndDoubleRange) obj;
            return this._start == openEndDoubleRange._start && this._endExclusive == openEndDoubleRange._endExclusive;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.hashCode(this._start) * 31) + Double.hashCode(this._endExclusive);
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
