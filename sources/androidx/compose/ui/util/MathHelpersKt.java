package androidx.compose.ui.util;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.math.MathKt;
/* compiled from: MathHelpers.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a)\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a)\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0001\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0086\b\u001a\u0015\u0010\u0012\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0086\b\u001a\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0086\b\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0015\u001a\u00020\r*\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0086\b\u001a\u0015\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0086\b\u001a\u001d\u0010\u0017\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0086\b\u001a\u001d\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0086\b\u001a\u001d\u0010\u0017\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0013H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0001H\u0086\b¨\u0006\u001a"}, d2 = {"fastCbrt", "", "x", "fastMaxOf", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "d", "fastMinOf", "lerp", TtmlNode.START, "stop", "fraction", "", "", "normalizedAngleCos", "normalizedDegrees", "normalizedAngleSin", "fastCoerceAtLeast", "", "minimumValue", "fastCoerceAtMost", "maximumValue", "fastCoerceIn", "fastIsFinite", "", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MathHelpersKt {
    public static final double fastCoerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final float fastCoerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static final int fastCoerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long fastCoerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final double fastCoerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static final float fastCoerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static final int fastCoerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long fastCoerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final double fastCoerceIn(double d, double d2, double d3) {
        if (d < d2) {
            d = d2;
        }
        return d > d3 ? d3 : d;
    }

    public static final float fastCoerceIn(float f, float f2, float f3) {
        if (f < f2) {
            f = f2;
        }
        return f > f3 ? f3 : f;
    }

    public static final int fastCoerceIn(int i, int i2, int i3) {
        if (i < i2) {
            i = i2;
        }
        return i > i3 ? i3 : i;
    }

    public static final long fastCoerceIn(long j, long j2, long j3) {
        if (j < j2) {
            j = j2;
        }
        return j > j3 ? j3 : j;
    }

    public static final float lerp(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final long lerp(long j, long j2, float f) {
        return j + MathKt.roundToLong((j2 - j) * f);
    }

    public static final float fastMinOf(float f, float f2, float f3, float f4) {
        return Math.min(f, Math.min(f2, Math.min(f3, f4)));
    }

    public static final float fastMaxOf(float f, float f2, float f3, float f4) {
        return Math.max(f, Math.max(f2, Math.max(f3, f4)));
    }

    public static final boolean fastIsFinite(float f) {
        return (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final boolean fastIsFinite(double d) {
        return (Double.doubleToRawLongBits(d) & Long.MAX_VALUE) < 9218868437227405312L;
    }

    public static final float fastCbrt(float f) {
        float intBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f) & 8589934591L) / 3)) + 709952852);
        float f2 = intBitsToFloat - ((intBitsToFloat - (f / (intBitsToFloat * intBitsToFloat))) * 0.33333334f);
        return f2 - ((f2 - (f / (f2 * f2))) * 0.33333334f);
    }

    public static final float normalizedAngleSin(float f) {
        float floor = f - ((float) Math.floor(0.5f + f));
        float abs = Math.abs(floor) * 2.0f;
        float f2 = 1.0f - abs;
        return ((floor * 8.0f) * f2) / (1.25f - (abs * f2));
    }

    public static final int lerp(int i, int i2, float f) {
        return i + ((int) Math.round((i2 - i) * f));
    }

    public static final float normalizedAngleCos(float f) {
        float f2 = f + 0.25f;
        float floor = f2 - ((float) Math.floor(0.5f + f2));
        float abs = Math.abs(floor) * 2.0f;
        float f3 = 1.0f - abs;
        return ((floor * 8.0f) * f3) / (1.25f - (abs * f3));
    }
}
