package kotlin.ranges;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0011\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/OpenEndFloatRange;", "Lkotlin/ranges/OpenEndRange;", "", TtmlNode.START, "endExclusive", "<init>", "(FF)V", "_start", "_endExclusive", "getStart", "()Ljava/lang/Float;", "getEndExclusive", "lessThanOrEquals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "contains", "value", "isEmpty", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
final class OpenEndFloatRange implements OpenEndRange<Float> {
    private final float _endExclusive;
    private final float _start;

    private final boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public OpenEndFloatRange(float f, float f2) {
        this._start = f;
        this._endExclusive = f2;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Float f) {
        return contains(f.floatValue());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    public boolean contains(float f) {
        return f >= this._start && f < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenEndFloatRange) {
            if (isEmpty() && ((OpenEndFloatRange) obj).isEmpty()) {
                return true;
            }
            OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) obj;
            return this._start == openEndFloatRange._start && this._endExclusive == openEndFloatRange._endExclusive;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.hashCode(this._start) * 31) + Float.hashCode(this._endExclusive);
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
