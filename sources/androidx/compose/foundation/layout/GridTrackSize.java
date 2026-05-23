package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* compiled from: Grid.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/GridTrackSize;", "Landroidx/compose/foundation/layout/GridTrackSpec;", "encodedValue", "", "constructor-impl", "(J)J", "type", "", "getType-impl$foundation_layout", "(J)I", "value", "", "getValue-impl$foundation_layout", "(J)F", "minValue", "getMinValue-impl$foundation_layout", "maxValue", "getMaxValue-impl$foundation_layout", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class GridTrackSize implements GridTrackSpec {
    private static final long Auto;
    public static final Companion Companion;
    private static final long MaxContent;
    private static final long MinContent;
    public static final int TypeAuto = 6;
    public static final int TypeFixed = 1;
    public static final int TypeFlex = 3;
    public static final int TypeMaxContent = 5;
    public static final int TypeMinContent = 4;
    public static final int TypeMinMax = 7;
    public static final int TypePercentage = 2;
    private final long encodedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ GridTrackSize m978boximpl(long j) {
        return new GridTrackSize(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m979constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m980equalsimpl(long j, Object obj) {
        return (obj instanceof GridTrackSize) && j == ((GridTrackSize) obj).m988unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m981equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getType-impl$foundation_layout  reason: not valid java name */
    public static final int m984getTypeimpl$foundation_layout(long j) {
        return (int) (j >>> 60);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m986hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m980equalsimpl(this.encodedValue, obj);
    }

    public int hashCode() {
        return m986hashCodeimpl(this.encodedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m988unboximpl() {
        return this.encodedValue;
    }

    private /* synthetic */ GridTrackSize(long j) {
        this.encodedValue = j;
    }

    /* renamed from: getValue-impl$foundation_layout  reason: not valid java name */
    public static final float m985getValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) j);
    }

    /* renamed from: getMinValue-impl$foundation_layout  reason: not valid java name */
    public static final float m983getMinValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(((int) ((j >>> 30) & LockFreeTaskQueueCore.HEAD_MASK)) << 2);
    }

    /* renamed from: getMaxValue-impl$foundation_layout  reason: not valid java name */
    public static final float m982getMaxValueimpl$foundation_layout(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(((int) (j & LockFreeTaskQueueCore.HEAD_MASK)) << 2);
    }

    public String toString() {
        return m987toStringimpl(this.encodedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m987toStringimpl(long j) {
        switch (m984getTypeimpl$foundation_layout(j)) {
            case 1:
                return "Fixed(" + m985getValueimpl$foundation_layout(j) + "dp)";
            case 2:
                return "Percentage(" + m985getValueimpl$foundation_layout(j) + ')';
            case 3:
                return "Flex(" + m985getValueimpl$foundation_layout(j) + "fr)";
            case 4:
                return "MinContent";
            case 5:
                return "MaxContent";
            case 6:
                return "Auto";
            case 7:
                return "MinMax(" + m983getMinValueimpl$foundation_layout(j) + "dp, " + m982getMaxValueimpl$foundation_layout(j) + "fr)";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    /* compiled from: Grid.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u0011J!\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0001\u0010\u001c\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010'\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b(\u0010\u001eJ\u001f\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b+\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010#\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0013\u0010%\u001a\u00020\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/GridTrackSize$Companion;", "", "<init>", "()V", "TypeFixed", "", "TypePercentage", "TypeFlex", "TypeMinContent", "TypeMaxContent", "TypeAuto", "TypeMinMax", "Fixed", "Landroidx/compose/foundation/layout/GridTrackSize;", "size", "Landroidx/compose/ui/unit/Dp;", "Fixed-psSkOvk", "(F)J", "Percentage", "value", "", "Percentage-9Tp3RV8", "Flex", "weight", "Landroidx/compose/foundation/layout/Fr;", "Flex-KGB9zo8", "MinMax", "min", "max", "MinMax-1z8F7YY", "(FF)J", "MinContent", "getMinContent-eyNpfc4", "()J", "J", "MaxContent", "getMaxContent-eyNpfc4", "Auto", "getAuto-eyNpfc4", "packMinMax", "packMinMax-ALYS8Xw", "pack", "type", "pack-ALYS8Xw", "(IF)J", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Fixed-psSkOvk  reason: not valid java name */
        public final long m992FixedpsSkOvk(float f) {
            if (Dp.m8165equalsimpl0(f, Dp.Companion.m8180getUnspecifiedD9Ej5fM()) || f < 0.0f) {
                throw new IllegalArgumentException(("Fixed size must be non-negative and specified (was " + ((Object) Dp.m8171toStringimpl(f)) + ')').toString());
            }
            return m990packALYS8Xw(1, f);
        }

        /* renamed from: Percentage-9Tp3RV8  reason: not valid java name */
        public final long m995Percentage9Tp3RV8(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Percentage cannot be negative".toString());
            }
            return m990packALYS8Xw(2, f);
        }

        /* renamed from: Flex-KGB9zo8  reason: not valid java name */
        public final long m993FlexKGB9zo8(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Flex weight must be non-negative".toString());
            }
            return m990packALYS8Xw(3, f);
        }

        /* renamed from: MinMax-1z8F7YY  reason: not valid java name */
        public final long m994MinMax1z8F7YY(float f, float f2) {
            if (f >= 0.0f) {
                if (f2 < 0.0f) {
                    throw new IllegalArgumentException("MinMax max weight cannot be negative".toString());
                }
                return m991packMinMaxALYS8Xw(f, f2);
            }
            throw new IllegalArgumentException("MinMax minimum size cannot be negative".toString());
        }

        /* renamed from: getMinContent-eyNpfc4  reason: not valid java name */
        public final long m998getMinContenteyNpfc4() {
            return GridTrackSize.MinContent;
        }

        /* renamed from: getMaxContent-eyNpfc4  reason: not valid java name */
        public final long m997getMaxContenteyNpfc4() {
            return GridTrackSize.MaxContent;
        }

        /* renamed from: getAuto-eyNpfc4  reason: not valid java name */
        public final long m996getAutoeyNpfc4() {
            return GridTrackSize.Auto;
        }

        /* renamed from: packMinMax-ALYS8Xw  reason: not valid java name */
        private final long m991packMinMaxALYS8Xw(float f, float f2) {
            if (f < 0.0f || f2 < 0.0f) {
                throw new IllegalArgumentException("minmax values must be non-negative".toString());
            }
            return GridTrackSize.m979constructorimpl((((Float.floatToRawIntBits(f) >>> 2) & LockFreeTaskQueueCore.HEAD_MASK) << 30) | 8070450532247928832L | (LockFreeTaskQueueCore.HEAD_MASK & (Float.floatToRawIntBits(f2) >>> 2)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: pack-ALYS8Xw  reason: not valid java name */
        public final long m990packALYS8Xw(int i, float f) {
            return GridTrackSize.m979constructorimpl(((i & 15) << 60) | (Float.floatToRawIntBits(f) & 4294967295L));
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        MinContent = companion.m990packALYS8Xw(4, 0.0f);
        MaxContent = companion.m990packALYS8Xw(5, 0.0f);
        Auto = companion.m990packALYS8Xw(6, 0.0f);
    }
}
