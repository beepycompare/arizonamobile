package androidx.compose.ui.graphics;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.ShortCompanionObject;
/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0080\b\u001a\u0011\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0015H\u0080\b\u001a\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010\u001e\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0015H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Fp16Combined", "", "Fp16ExponentBias", "Fp16ExponentMask", "Fp16ExponentMax", "Fp16ExponentShift", "Fp16One", "Fp16SignMask", "Fp16SignShift", "Fp16SignificandMask", "Fp16TheNaN", "Fp32DenormalFloat", "", "Fp32DenormalMagic", "Fp32ExponentBias", "Fp32ExponentMask", "Fp32ExponentShift", "Fp32QNaNMask", "Fp32SignShift", "Fp32SignificandMask", "floatToHalf", "", "f", "halfToFloat", CmcdData.STREAMING_FORMAT_HLS, "max", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "toCompareValue", "value", "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Float16Kt {
    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16One = 15360;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final int Fp16TheNaN = 32256;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final int Fp32DenormalMagic = 1056964608;
    private static final float Fp32DenormalFloat = Float.intBitsToFloat(Fp32DenormalMagic);

    private static final int toCompareValue(short s) {
        return (s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE;
    }

    public static final short floatToHalf(float f) {
        int i;
        int i2;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int i3 = floatToRawIntBits >>> 31;
        int i4 = (floatToRawIntBits >>> 23) & 255;
        int i5 = Fp32SignificandMask & floatToRawIntBits;
        int i6 = 31;
        int i7 = 0;
        if (i4 == 255) {
            if (i5 != 0) {
                i2 = 512;
                i7 = i2;
            }
            i = (i3 << 15) | (i6 << 10) | i7;
        } else {
            int i8 = i4 - 112;
            if (i8 >= 31) {
                i6 = 49;
            } else if (i8 > 0) {
                i7 = i5 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i = (((i8 << 10) | i7) + 1) | (i3 << 15);
                } else {
                    i6 = i8;
                }
            } else if (i8 >= -10) {
                int i9 = (8388608 | i5) >> (1 - i8);
                if ((i9 & 4096) != 0) {
                    i9 += 8192;
                }
                i2 = i9 >> 13;
                i6 = 0;
                i7 = i2;
            } else {
                i6 = 0;
            }
            i = (i3 << 15) | (i6 << 10) | i7;
        }
        return (short) i;
    }

    /* renamed from: min-AoSsdG0  reason: not valid java name */
    public static final short m4225minAoSsdG0(short s, short s2) {
        if (Float16.m4197isNaNimpl(s) || Float16.m4197isNaNimpl(s2)) {
            return Float16.Companion.m4219getNaNslo4al4();
        }
        return Float16.m4184compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }

    /* renamed from: max-AoSsdG0  reason: not valid java name */
    public static final short m4224maxAoSsdG0(short s, short s2) {
        if (Float16.m4197isNaNimpl(s) || Float16.m4197isNaNimpl(s2)) {
            return Float16.Companion.m4219getNaNslo4al4();
        }
        return Float16.m4184compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    public static final float halfToFloat(short s) {
        int i;
        int i2;
        int i3;
        int i4 = 32768 & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else if (i6 != 0) {
            float intBitsToFloat = Float.intBitsToFloat(i6 + Fp32DenormalMagic) - Fp32DenormalFloat;
            return i4 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }
}
