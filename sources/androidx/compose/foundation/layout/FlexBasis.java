package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
/* compiled from: FlexBox.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/FlexBasis;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "isAuto", "", "isAuto-impl$foundation_layout", "(J)Z", "isDp", "isDp-impl$foundation_layout", "isPercent", "isPercent-impl$foundation_layout", "value", "", "getValue-impl$foundation_layout", "(J)F", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FlexBasis {
    private static final long TypeAuto = 0;
    private static final long TypeDp = 1;
    private static final long TypePercent = 2;
    private static final int TypeShift = 32;
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Auto = m824constructorimpl(0);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FlexBasis m823boximpl(long j) {
        return new FlexBasis(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m824constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m825equalsimpl(long j, Object obj) {
        return (obj instanceof FlexBasis) && j == ((FlexBasis) obj).m833unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m826equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m828hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isAuto-impl$foundation_layout  reason: not valid java name */
    public static final boolean m829isAutoimpl$foundation_layout(long j) {
        return (j >>> 32) == 0;
    }

    /* renamed from: isDp-impl$foundation_layout  reason: not valid java name */
    public static final boolean m830isDpimpl$foundation_layout(long j) {
        return (j >>> 32) == 1;
    }

    /* renamed from: isPercent-impl$foundation_layout  reason: not valid java name */
    public static final boolean m831isPercentimpl$foundation_layout(long j) {
        return (j >>> 32) == 2;
    }

    public boolean equals(Object obj) {
        return m825equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m828hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m833unboximpl() {
        return this.packedValue;
    }

    /* compiled from: FlexBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/FlexBasis$Companion;", "", "<init>", "()V", "TypeShift", "", "TypeAuto", "", "TypeDp", "TypePercent", "Auto", "Landroidx/compose/foundation/layout/FlexBasis;", "getAuto-d-lZNVs", "()J", "J", "Dp", "value", "Landroidx/compose/ui/unit/Dp;", "Dp-cHuBJEI", "(F)J", "Percent", "", "Percent-uoj9tHE", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAuto-d-lZNVs  reason: not valid java name */
        public final long m836getAutodlZNVs() {
            return FlexBasis.Auto;
        }

        /* renamed from: Dp-cHuBJEI  reason: not valid java name */
        public final long m834DpcHuBJEI(float f) {
            return FlexBasis.m824constructorimpl((Float.floatToIntBits(f) & 4294967295L) | 4294967296L);
        }

        /* renamed from: Percent-uoj9tHE  reason: not valid java name */
        public final long m835Percentuoj9tHE(float f) {
            return FlexBasis.m824constructorimpl((Float.floatToIntBits(f) & 4294967295L) | 8589934592L);
        }
    }

    private /* synthetic */ FlexBasis(long j) {
        this.packedValue = j;
    }

    /* renamed from: getValue-impl$foundation_layout  reason: not valid java name */
    public static final float m827getValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) j);
    }

    public String toString() {
        return m832toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m832toStringimpl(long j) {
        return m829isAutoimpl$foundation_layout(j) ? "FlexBasis.Auto" : m830isDpimpl$foundation_layout(j) ? "FlexBasis.Dp(" + m827getValueimpl$foundation_layout(j) + ".dp)" : m831isPercentimpl$foundation_layout(j) ? "FlexBasis.Percent(" + MathKt.roundToInt(m827getValueimpl$foundation_layout(j) * 100.0f) + "%)" : "FlexBasis.Unknown";
    }
}
