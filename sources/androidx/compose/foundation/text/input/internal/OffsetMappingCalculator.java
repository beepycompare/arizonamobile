package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: OffsetMappingCalculator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "<init>", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "mapFromSource", "Landroidx/compose/ui/text/TextRange;", TypedValues.CycleType.S_WAVE_OFFSET, "mapFromSource--jx7JFs", "(I)J", "mapFromDest", "mapFromDest--jx7JFs", "map", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1412constructorimpl(10);
    private int opsSize;

    public final void recordEditOperation(int i, int i2, int i3) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + i3);
        }
        int min = Math.min(i, i2);
        int max = Math.max(min, i2) - min;
        if (max >= 2 || max != i3) {
            int i4 = this.opsSize + 1;
            if (i4 > OpArray.m1419getSizeimpl(this.ops)) {
                this.ops = OpArray.m1414copyOfpSmdads(this.ops, Math.max(i4 * 2, OpArray.m1419getSizeimpl(this.ops) * 2));
            }
            OpArray.m1421setimpl(this.ops, this.opsSize, min, max, i3);
            this.opsSize = i4;
        }
    }

    /* renamed from: mapFromSource--jx7JFs  reason: not valid java name */
    public final long m1410mapFromSourcejx7JFs(int i) {
        return m1407mapfzxv0v0(i, true);
    }

    /* renamed from: mapFromDest--jx7JFs  reason: not valid java name */
    public final long m1409mapFromDestjx7JFs(int i) {
        return m1407mapfzxv0v0(i, false);
    }

    /* renamed from: map-fzxv0v0  reason: not valid java name */
    private final long m1407mapfzxv0v0(int i, boolean z) {
        int i2;
        int i3;
        int[] iArr = this.ops;
        int i4 = this.opsSize;
        if (i4 >= 0) {
            if (z) {
                i3 = i;
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i5 * 3;
                    int i7 = iArr[i6];
                    int i8 = iArr[i6 + 1];
                    int i9 = iArr[i6 + 2];
                    long m1408mapStepC6uMEY = m1408mapStepC6uMEY(i3, i7, i8, i9, z);
                    long m1408mapStepC6uMEY2 = m1408mapStepC6uMEY(i, i7, i8, i9, z);
                    i3 = Math.min(TextRange.m7003getStartimpl(m1408mapStepC6uMEY), TextRange.m7003getStartimpl(m1408mapStepC6uMEY2));
                    i = Math.max(TextRange.m6998getEndimpl(m1408mapStepC6uMEY), TextRange.m6998getEndimpl(m1408mapStepC6uMEY2));
                }
            } else {
                int i10 = i4 - 1;
                i3 = i;
                while (-1 < i10) {
                    int i11 = i10 * 3;
                    int i12 = iArr[i11];
                    int i13 = iArr[i11 + 1];
                    int i14 = iArr[i11 + 2];
                    OffsetMappingCalculator offsetMappingCalculator = this;
                    boolean z2 = z;
                    long m1408mapStepC6uMEY3 = offsetMappingCalculator.m1408mapStepC6uMEY(i3, i12, i13, i14, z2);
                    long m1408mapStepC6uMEY4 = offsetMappingCalculator.m1408mapStepC6uMEY(i, i12, i13, i14, z2);
                    i3 = Math.min(TextRange.m7003getStartimpl(m1408mapStepC6uMEY3), TextRange.m7003getStartimpl(m1408mapStepC6uMEY4));
                    i = Math.max(TextRange.m6998getEndimpl(m1408mapStepC6uMEY3), TextRange.m6998getEndimpl(m1408mapStepC6uMEY4));
                    i10--;
                    this = offsetMappingCalculator;
                    z = z2;
                }
            }
            i2 = i;
            i = i3;
        } else {
            i2 = i;
        }
        return TextRangeKt.TextRange(i, i2);
    }

    /* renamed from: mapStep-C6u-MEY  reason: not valid java name */
    private final long m1408mapStepC6uMEY(int i, int i2, int i3, int i4, boolean z) {
        int i5 = z ? i3 : i4;
        if (z) {
            i3 = i4;
        }
        if (i < i2) {
            return TextRangeKt.TextRange(i);
        }
        if (i == i2) {
            if (i5 == 0) {
                return TextRangeKt.TextRange(i2, i3 + i2);
            }
            return TextRangeKt.TextRange(i2);
        } else if (i < i2 + i5) {
            if (i3 == 0) {
                return TextRangeKt.TextRange(i2);
            }
            return TextRangeKt.TextRange(i2, i3 + i2);
        } else {
            return TextRangeKt.TextRange((i - i5) + i3);
        }
    }
}
