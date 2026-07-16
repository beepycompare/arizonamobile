package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesSameCasesAdapter;
/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010 \u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u0016J\u0010\u0010&\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020\nH\u0087\n¢\u0006\u0004\b)\u0010\u000eJ7\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0007¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u0016\u0088\u0001\u0002¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "getValue-s-VKNKU", "()J", "J", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", CasesSameCasesAdapter.NEW, "", "getRed$annotations", "getRed-impl", "(J)F", CasesSameCasesAdapter.TOP, "getGreen$annotations", "getGreen-impl", "blue", "getBlue$annotations", "getBlue-impl", "alpha", "getAlpha$annotations", "getAlpha-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "copy", "copy-wmQWz5c", "(JFFFF)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Color {
    private final long value;
    public static final Companion Companion = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics());

    /* renamed from: box-impl */
    public static final /* synthetic */ Color m5338boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl */
    public static long m5344constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl */
    public static boolean m5348equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m5358unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m5349equalsimpl0(long j, long j2) {
        return ULong.m10085equalsimpl0(j, j2);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBlue$annotations() {
    }

    public static /* synthetic */ void getColorSpace$annotations() {
    }

    public static /* synthetic */ void getGreen$annotations() {
    }

    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m5355hashCodeimpl(long j) {
        return ULong.m10090hashCodeimpl(j);
    }

    public boolean equals(Object obj) {
        return m5348equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5355hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ long m5358unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: getValue-s-VKNKU */
    public final long m5357getValuesVKNKU() {
        return this.value;
    }

    /* renamed from: getColorSpace-impl */
    public static final ColorSpace m5352getColorSpaceimpl(long j) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics()[(int) ULong.m10078constructorimpl(j & 63)];
    }

    /* renamed from: convert-vNxB06k */
    public static final long m5345convertvNxB06k(long j, ColorSpace colorSpace) {
        return ColorSpaceKt.m5790connectYBCOT_4$default(m5352getColorSpaceimpl(j), colorSpace, 0, 2, null).mo5793transformToColorl2rxGTc$ui_graphics(j);
    }

    /* renamed from: getRed-impl */
    public static final float m5354getRedimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m10078constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 48) & 255))) / 255.0f;
        }
        short m10078constructorimpl = (short) ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = 32768 & m10078constructorimpl;
        int i5 = ((65535 & m10078constructorimpl) >>> 10) & 31;
        int i6 = m10078constructorimpl & 1023;
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
            float intBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
            return i4 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getGreen-impl */
    public static final float m5353getGreenimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m10078constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 40) & 255))) / 255.0f;
        }
        short m10078constructorimpl = (short) ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = 32768 & m10078constructorimpl;
        int i5 = ((65535 & m10078constructorimpl) >>> 10) & 31;
        int i6 = m10078constructorimpl & 1023;
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
            float intBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
            return i4 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getBlue-impl */
    public static final float m5351getBlueimpl(long j) {
        int i;
        int i2;
        int i3;
        if (ULong.m10078constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 32) & 255))) / 255.0f;
        }
        short m10078constructorimpl = (short) ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i4 = 32768 & m10078constructorimpl;
        int i5 = ((65535 & m10078constructorimpl) >>> 10) & 31;
        int i6 = m10078constructorimpl & 1023;
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
            float intBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
            return i4 == 0 ? intBitsToFloat : -intBitsToFloat;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* renamed from: getAlpha-impl */
    public static final float m5350getAlphaimpl(long j) {
        float ulongToDouble;
        float f;
        if (ULong.m10078constructorimpl(63 & j) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m10078constructorimpl(ULong.m10078constructorimpl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return ulongToDouble / f;
    }

    /* renamed from: component1-impl */
    public static final float m5339component1impl(long j) {
        return m5354getRedimpl(j);
    }

    /* renamed from: component2-impl */
    public static final float m5340component2impl(long j) {
        return m5353getGreenimpl(j);
    }

    /* renamed from: component3-impl */
    public static final float m5341component3impl(long j) {
        return m5351getBlueimpl(j);
    }

    /* renamed from: component4-impl */
    public static final float m5342component4impl(long j) {
        return m5350getAlphaimpl(j);
    }

    /* renamed from: component5-impl */
    public static final ColorSpace m5343component5impl(long j) {
        return m5352getColorSpaceimpl(j);
    }

    /* renamed from: copy-wmQWz5c$default */
    public static /* synthetic */ long m5347copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5350getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m5354getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m5353getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m5351getBlueimpl(j);
        }
        return m5346copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: copy-wmQWz5c */
    public static final long m5346copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m5352getColorSpaceimpl(j));
    }

    public String toString() {
        return m5356toStringimpl(this.value);
    }

    /* renamed from: toString-impl */
    public static String m5356toStringimpl(long j) {
        return "Color(" + m5354getRedimpl(j) + ", " + m5353getGreenimpl(j) + ", " + m5351getBlueimpl(j) + ", " + m5350getAlphaimpl(j) + ", " + m5352getColorSpaceimpl(j).getName() + ')';
    }

    /* compiled from: Color.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b6\u00107J(\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u000200H\u0002J9\u0010>\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010?\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u000205¢\u0006\u0004\b@\u00107J(\u0010A\u001a\u0002002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010B\u001a\u000200H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\b¨\u0006C"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "<init>", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "hsv", "hue", "", "saturation", "value", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsv-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hsvToRgbComponent", "n", "", CmcdData.STREAMING_FORMAT_HLS, CmcdData.STREAMING_FORMAT_SS, "v", "hsl", "lightness", "hsl-JlNiLsg", "hslToRgbComponent", CmcdData.STREAM_TYPE_LIVE, "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU$annotations */
        public static /* synthetic */ void m5359getBlack0d7_KjU$annotations() {
        }

        /* renamed from: getBlue-0d7_KjU$annotations */
        public static /* synthetic */ void m5360getBlue0d7_KjU$annotations() {
        }

        /* renamed from: getCyan-0d7_KjU$annotations */
        public static /* synthetic */ void m5361getCyan0d7_KjU$annotations() {
        }

        /* renamed from: getDarkGray-0d7_KjU$annotations */
        public static /* synthetic */ void m5362getDarkGray0d7_KjU$annotations() {
        }

        /* renamed from: getGray-0d7_KjU$annotations */
        public static /* synthetic */ void m5363getGray0d7_KjU$annotations() {
        }

        /* renamed from: getGreen-0d7_KjU$annotations */
        public static /* synthetic */ void m5364getGreen0d7_KjU$annotations() {
        }

        /* renamed from: getLightGray-0d7_KjU$annotations */
        public static /* synthetic */ void m5365getLightGray0d7_KjU$annotations() {
        }

        /* renamed from: getMagenta-0d7_KjU$annotations */
        public static /* synthetic */ void m5366getMagenta0d7_KjU$annotations() {
        }

        /* renamed from: getRed-0d7_KjU$annotations */
        public static /* synthetic */ void m5367getRed0d7_KjU$annotations() {
        }

        /* renamed from: getTransparent-0d7_KjU$annotations */
        public static /* synthetic */ void m5368getTransparent0d7_KjU$annotations() {
        }

        /* renamed from: getUnspecified-0d7_KjU$annotations */
        public static /* synthetic */ void m5369getUnspecified0d7_KjU$annotations() {
        }

        /* renamed from: getWhite-0d7_KjU$annotations */
        public static /* synthetic */ void m5370getWhite0d7_KjU$annotations() {
        }

        /* renamed from: getYellow-0d7_KjU$annotations */
        public static /* synthetic */ void m5371getYellow0d7_KjU$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getBlack-0d7_KjU */
        public final long m5374getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getDarkGray-0d7_KjU */
        public final long m5377getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU */
        public final long m5378getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getLightGray-0d7_KjU */
        public final long m5380getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getWhite-0d7_KjU */
        public final long m5385getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU */
        public final long m5382getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getGreen-0d7_KjU */
        public final long m5379getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getBlue-0d7_KjU */
        public final long m5375getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getYellow-0d7_KjU */
        public final long m5386getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* renamed from: getCyan-0d7_KjU */
        public final long m5376getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getMagenta-0d7_KjU */
        public final long m5381getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getTransparent-0d7_KjU */
        public final long m5383getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU */
        public final long m5384getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: hsv-JlNiLsg$default */
        public static /* synthetic */ long m5373hsvJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m5388hsvJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* renamed from: hsv-JlNiLsg */
        public final long m5388hsvJlNiLsg(float f, float f2, float f3, float f4, Rgb rgb) {
            if (!(0.0f <= f && f <= 360.0f && 0.0f <= f2 && f2 <= 1.0f && 0.0f <= f3 && f3 <= 1.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("HSV (" + f + ", " + f2 + ", " + f3 + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hsvToRgbComponent(5, f, f2, f3), hsvToRgbComponent(3, f, f2, f3), hsvToRgbComponent(1, f, f2, f3), f4, rgb);
        }

        private final float hsvToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (i + (f / 60.0f)) % 6.0f;
            return f3 - ((f2 * f3) * Math.max(0.0f, Math.min(f4, Math.min(4.0f - f4, 1.0f))));
        }

        /* renamed from: hsl-JlNiLsg$default */
        public static /* synthetic */ long m5372hslJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m5387hslJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* renamed from: hsl-JlNiLsg */
        public final long m5387hslJlNiLsg(float f, float f2, float f3, float f4, Rgb rgb) {
            if (!(0.0f <= f && f <= 360.0f && 0.0f <= f2 && f2 <= 1.0f && 0.0f <= f3 && f3 <= 1.0f)) {
                InlineClassHelperKt.throwIllegalArgumentException("HSL (" + f + ", " + f2 + ", " + f3 + ") must be in range (0..360, 0..1, 0..1)");
            }
            return ColorKt.Color(hslToRgbComponent(0, f, f2, f3), hslToRgbComponent(8, f, f2, f3), hslToRgbComponent(4, f, f2, f3), f4, rgb);
        }

        private final float hslToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (i + (f / 30.0f)) % 12.0f;
            return f3 - ((f2 * Math.min(f3, 1.0f - f3)) * Math.max(-1.0f, Math.min(f4 - 3.0f, Math.min(9.0f - f4, 1.0f))));
        }
    }
}
