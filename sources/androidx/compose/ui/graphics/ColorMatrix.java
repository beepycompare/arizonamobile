package androidx.compose.ui.graphics;

import androidx.core.text.util.LocalePreferences;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ColorMatrix.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0086\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u001e\u0010\u000bJP\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001426\u0010!\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t0\"H\u0082\b¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,J(\u0010)\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0014H\u0086\n¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b4\u00102J\u0015\u00105\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b6\u00102J\u0015\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\u0014¢\u0006\u0004\b9\u00102J-\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014¢\u0006\u0004\b?\u0010@J\u001b\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010,J\u0010\u0010D\u001a\u00020EHÖ\u0001¢\u0006\u0004\bF\u0010GR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ColorMatrix {
    private final float[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m4133boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m4134constructorimpl(float[] fArr) {
        return fArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4138equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m4153unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4139equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4141hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4152toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m4138equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m4141hashCodeimpl(this.values);
    }

    public String toString() {
        return m4152toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m4153unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m4135constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m4134constructorimpl(fArr);
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m4140getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m4144setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 5) + i2] = f;
    }

    /* renamed from: set-jHG-Opc  reason: not valid java name */
    public static final void m4145setjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 20 && fArr2.length >= 20) {
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[3];
            fArr[4] = fArr2[4];
            fArr[5] = fArr2[5];
            fArr[6] = fArr2[6];
            fArr[7] = fArr2[7];
            fArr[8] = fArr2[8];
            fArr[9] = fArr2[9];
            fArr[10] = fArr2[10];
            fArr[11] = fArr2[11];
            fArr[12] = fArr2[12];
            fArr[13] = fArr2[13];
            fArr[14] = fArr2[14];
            fArr[15] = fArr2[15];
            fArr[16] = fArr2[16];
            fArr[17] = fArr2[17];
            fArr[18] = fArr2[18];
            fArr[19] = fArr2[19];
        }
    }

    /* renamed from: timesAssign-jHG-Opc  reason: not valid java name */
    public static final void m4151timesAssignjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length < 20) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr2[0];
        float f3 = fArr[1];
        float f4 = fArr2[5];
        float f5 = fArr[2];
        float f6 = fArr2[10];
        float f7 = fArr[3];
        float f8 = fArr2[15];
        float f9 = (f * f2) + (f3 * f4) + (f5 * f6) + (f7 * f8);
        float f10 = fArr2[1];
        float f11 = fArr2[6];
        float f12 = fArr2[11];
        float f13 = fArr2[16];
        float f14 = (f * f10) + (f3 * f11) + (f5 * f12) + (f7 * f13);
        float f15 = fArr2[2];
        float f16 = fArr2[7];
        float f17 = fArr2[12];
        float f18 = fArr2[17];
        float f19 = (f * f15) + (f3 * f16) + (f5 * f17) + (f7 * f18);
        float f20 = fArr2[3];
        float f21 = fArr2[8];
        float f22 = fArr2[13];
        float f23 = fArr2[18];
        float f24 = fArr2[4];
        float f25 = fArr2[9];
        float f26 = fArr2[14];
        float f27 = fArr2[19];
        float f28 = (f * f24) + (f3 * f25) + (f5 * f26) + (f7 * f27) + fArr[4];
        float f29 = fArr[5];
        float f30 = fArr[6];
        float f31 = fArr[7];
        float f32 = fArr[8];
        float f33 = (f29 * f2) + (f30 * f4) + (f31 * f6) + (f32 * f8);
        float f34 = (f29 * f10) + (f30 * f11) + (f31 * f12) + (f32 * f13);
        float f35 = (f29 * f15) + (f30 * f16) + (f31 * f17) + (f32 * f18);
        float f36 = (f29 * f20) + (f30 * f21) + (f31 * f22) + (f32 * f23);
        float f37 = (f29 * f24) + (f30 * f25) + (f31 * f26) + (f32 * f27) + fArr[9];
        float f38 = fArr[10];
        float f39 = fArr[11];
        float f40 = fArr[12];
        float f41 = fArr[13];
        float f42 = (f38 * f10) + (f39 * f11) + (f40 * f12) + (f41 * f13);
        float f43 = (f38 * f15) + (f39 * f16) + (f40 * f17) + (f41 * f18);
        float f44 = (f38 * f24) + (f39 * f25) + (f40 * f26) + (f41 * f27) + fArr[14];
        float f45 = fArr[15];
        float f46 = fArr[16];
        float f47 = (f2 * f45) + (f4 * f46);
        float f48 = fArr[17];
        float f49 = f47 + (f6 * f48);
        float f50 = fArr[18];
        fArr[0] = f9;
        fArr[1] = f14;
        fArr[2] = f19;
        fArr[3] = (f * f20) + (f3 * f21) + (f5 * f22) + (f7 * f23);
        fArr[4] = f28;
        fArr[5] = f33;
        fArr[6] = f34;
        fArr[7] = f35;
        fArr[8] = f36;
        fArr[9] = f37;
        fArr[10] = (f38 * f2) + (f39 * f4) + (f40 * f6) + (f41 * f8);
        fArr[11] = f42;
        fArr[12] = f43;
        fArr[13] = (f38 * f20) + (f39 * f21) + (f40 * f22) + (f41 * f23);
        fArr[14] = f44;
        fArr[15] = f49 + (f8 * f50);
        fArr[16] = (f10 * f45) + (f11 * f46) + (f12 * f48) + (f13 * f50);
        fArr[17] = (f15 * f45) + (f16 * f46) + (f17 * f48) + (f18 * f50);
        fArr[18] = (f20 * f45) + (f21 * f46) + (f22 * f48) + (f23 * f50);
        fArr[19] = (f45 * f24) + (f46 * f25) + (f48 * f26) + (f50 * f27) + fArr[19];
    }

    /* renamed from: setToSaturation-impl  reason: not valid java name */
    public static final void m4149setToSaturationimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f2 = 1 - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = f2 * 0.072f;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    /* renamed from: setToScale-impl  reason: not valid java name */
    public static final void m4150setToScaleimpl(float[] fArr, float f, float f2, float f3, float f4) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = f;
        fArr[6] = f2;
        fArr[12] = f3;
        fArr[18] = f4;
    }

    /* renamed from: setToRotateRed-impl  reason: not valid java name */
    public static final void m4148setToRotateRedimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f2 = f * 0.0027777778f;
        float f3 = 0.25f + f2;
        float floor = f3 - ((float) Math.floor(f3 + 0.5f));
        float abs = Math.abs(floor) * 2.0f;
        float f4 = 1.0f - abs;
        float f5 = ((floor * 8.0f) * f4) / (1.25f - (abs * f4));
        float floor2 = f2 - ((float) Math.floor(0.5f + f2));
        float abs2 = Math.abs(floor2) * 2.0f;
        float f6 = 1.0f - abs2;
        float f7 = ((floor2 * 8.0f) * f6) / (1.25f - (abs2 * f6));
        fArr[6] = f5;
        fArr[7] = f7;
        fArr[11] = -f7;
        fArr[12] = f5;
    }

    /* renamed from: setToRotateGreen-impl  reason: not valid java name */
    public static final void m4147setToRotateGreenimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f2 = f * 0.0027777778f;
        float f3 = 0.25f + f2;
        float floor = f3 - ((float) Math.floor(f3 + 0.5f));
        float abs = Math.abs(floor) * 2.0f;
        float f4 = 1.0f - abs;
        float f5 = ((floor * 8.0f) * f4) / (1.25f - (abs * f4));
        float floor2 = f2 - ((float) Math.floor(0.5f + f2));
        float abs2 = Math.abs(floor2) * 2.0f;
        float f6 = 1.0f - abs2;
        float f7 = ((floor2 * 8.0f) * f6) / (1.25f - (abs2 * f6));
        fArr[0] = f5;
        fArr[2] = -f7;
        fArr[10] = f7;
        fArr[12] = f5;
    }

    /* renamed from: setToRotateBlue-impl  reason: not valid java name */
    public static final void m4146setToRotateBlueimpl(float[] fArr, float f) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f2 = f * 0.0027777778f;
        float f3 = 0.25f + f2;
        float floor = f3 - ((float) Math.floor(f3 + 0.5f));
        float abs = Math.abs(floor) * 2.0f;
        float f4 = 1.0f - abs;
        float f5 = ((floor * 8.0f) * f4) / (1.25f - (abs * f4));
        float floor2 = f2 - ((float) Math.floor(0.5f + f2));
        float abs2 = Math.abs(floor2) * 2.0f;
        float f6 = 1.0f - abs2;
        float f7 = ((floor2 * 8.0f) * f6) / (1.25f - (abs2 * f6));
        fArr[0] = f5;
        fArr[1] = f7;
        fArr[5] = -f7;
        fArr[6] = f5;
    }

    /* renamed from: convertRgbToYuv-impl  reason: not valid java name */
    public static final void m4136convertRgbToYuvimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl  reason: not valid java name */
    public static final void m4137convertYuvToRgbimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m4142resetimpl(float[] fArr) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    /* renamed from: rotateInternal-impl  reason: not valid java name */
    private static final void m4143rotateInternalimpl(float[] fArr, float f, Function2<? super Float, ? super Float, Unit> function2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f2 = f * 0.0027777778f;
        float f3 = 0.25f + f2;
        float floor = f3 - ((float) Math.floor(f3 + 0.5f));
        float abs = Math.abs(floor) * 2.0f;
        float f4 = 1.0f - abs;
        float floor2 = f2 - ((float) Math.floor(0.5f + f2));
        float abs2 = Math.abs(floor2) * 2.0f;
        float f5 = 1.0f - abs2;
        function2.invoke(Float.valueOf(((floor * 8.0f) * f4) / (1.25f - (abs * f4))), Float.valueOf(((floor2 * 8.0f) * f5) / (1.25f - (abs2 * f5))));
    }
}
