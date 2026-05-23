package androidx.compose.ui.geometry;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: CornerRadius.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001f\u0010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b%\u0010#J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u000202HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00064"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "isZero", "", "isZero-impl", "(J)Z", "isCircular", "isCircular-impl", "unaryMinus", "unaryMinus-kKHJgLs", "minus", "other", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "operand", "times-Bz7bX_o", "(JF)J", TtmlNode.TAG_DIV, "div-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class CornerRadius {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m5057constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CornerRadius m5054boximpl(long j) {
        return new CornerRadius(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m5057constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5061equalsimpl(long j, Object obj) {
        return (obj instanceof CornerRadius) && j == ((CornerRadius) obj).m5073unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5062equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5065hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isCircular-impl  reason: not valid java name */
    public static final boolean m5066isCircularimpl(long j) {
        return (j >>> 32) == (j & 4294967295L);
    }

    /* renamed from: isZero-impl  reason: not valid java name */
    public static final boolean m5067isZeroimpl(long j) {
        long j2 = j & 9223372034707292159L;
        return (((~j2) & (j2 - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0;
    }

    public boolean equals(Object obj) {
        return m5061equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5065hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m5073unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ CornerRadius(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* compiled from: CornerRadius.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-kKHJgLs$annotations  reason: not valid java name */
        public static /* synthetic */ void m5074getZerokKHJgLs$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-kKHJgLs  reason: not valid java name */
        public final long m5075getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    /* renamed from: unaryMinus-kKHJgLs  reason: not valid java name */
    public static final long m5072unaryMinuskKHJgLs(long j) {
        return m5057constructorimpl(j ^ (-9223372034707292160L));
    }

    public String toString() {
        return m5071toStringimpl(this.packedValue);
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m5063getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m5064getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m5055component1impl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m5056component2impl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: copy-OHQCggk  reason: not valid java name */
    public static final long m5058copyOHQCggk(long j, float f, float f2) {
        return m5057constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    /* renamed from: copy-OHQCggk$default  reason: not valid java name */
    public static /* synthetic */ long m5059copyOHQCggk$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m5058copyOHQCggk(j, f, f2);
    }

    /* renamed from: minus-vF7b-mM  reason: not valid java name */
    public static final long m5068minusvF7bmM(long j, long j2) {
        return m5057constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: plus-vF7b-mM  reason: not valid java name */
    public static final long m5069plusvF7bmM(long j, long j2) {
        return m5057constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L));
    }

    /* renamed from: times-Bz7bX_o  reason: not valid java name */
    public static final long m5070timesBz7bX_o(long j, float f) {
        return m5057constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) * f) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) * f) & 4294967295L));
    }

    /* renamed from: div-Bz7bX_o  reason: not valid java name */
    public static final long m5060divBz7bX_o(long j, float f) {
        return m5057constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) / f) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) / f) & 4294967295L));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5071toStringimpl(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i2), 1) + ')';
    }
}
