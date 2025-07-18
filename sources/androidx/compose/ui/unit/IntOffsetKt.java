package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: IntOffset.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u000e*\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", TtmlNode.START, "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IntOffsetKt {
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m6806constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    /* renamed from: lerp-81ZRxRo  reason: not valid java name */
    public static final long m6824lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset.m6806constructorimpl((MathHelpersKt.lerp(IntOffset.m6812getXimpl(j), IntOffset.m6812getXimpl(j2), f) << 32) | (MathHelpersKt.lerp(IntOffset.m6813getYimpl(j), IntOffset.m6813getYimpl(j2), f) & 4294967295L));
    }

    /* renamed from: toOffset--gyyYBs  reason: not valid java name */
    public static final long m6830toOffsetgyyYBs(long j) {
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(IntOffset.m6813getYimpl(j)) & 4294967295L) | (Float.floatToRawIntBits(IntOffset.m6812getXimpl(j)) << 32));
    }

    /* renamed from: plus-oCl6YwE  reason: not valid java name */
    public static final long m6828plusoCl6YwE(long j, long j2) {
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(IntOffset.m6812getXimpl(j) + Float.intBitsToFloat((int) (j2 >> 32))) << 32) | (Float.floatToRawIntBits(IntOffset.m6813getYimpl(j) + Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: minus-oCl6YwE  reason: not valid java name */
    public static final long m6826minusoCl6YwE(long j, long j2) {
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(IntOffset.m6812getXimpl(j) - Float.intBitsToFloat((int) (j2 >> 32))) << 32) | (Float.floatToRawIntBits(IntOffset.m6813getYimpl(j) - Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: plus-Nv-tHpc  reason: not valid java name */
    public static final long m6827plusNvtHpc(long j, long j2) {
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) + IntOffset.m6812getXimpl(j2)) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) + IntOffset.m6813getYimpl(j2)) & 4294967295L));
    }

    /* renamed from: minus-Nv-tHpc  reason: not valid java name */
    public static final long m6825minusNvtHpc(long j, long j2) {
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - IntOffset.m6812getXimpl(j2)) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - IntOffset.m6813getYimpl(j2)) & 4294967295L));
    }

    /* renamed from: round-k-4lQ0M  reason: not valid java name */
    public static final long m6829roundk4lQ0M(long j) {
        int round = Math.round(Float.intBitsToFloat((int) (j >> 32)));
        return IntOffset.m6806constructorimpl((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (round << 32));
    }
}
