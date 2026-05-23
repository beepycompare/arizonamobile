package androidx.compose.ui.graphics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PathOperation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class PathOperation {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m5648constructorimpl(0);
    private static final int Intersect = m5648constructorimpl(1);
    private static final int Union = m5648constructorimpl(2);
    private static final int Xor = m5648constructorimpl(3);
    private static final int ReverseDifference = m5648constructorimpl(4);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PathOperation m5647boximpl(int i) {
        return new PathOperation(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5648constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5649equalsimpl(int i, Object obj) {
        return (obj instanceof PathOperation) && i == ((PathOperation) obj).m5653unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5650equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5651hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5649equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5651hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5653unboximpl() {
        return this.value;
    }

    /* compiled from: PathOperation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/PathOperation$Companion;", "", "<init>", "()V", "Difference", "Landroidx/compose/ui/graphics/PathOperation;", "getDifference-b3I0S0c", "()I", "I", "Intersect", "getIntersect-b3I0S0c", "Union", "getUnion-b3I0S0c", "Xor", "getXor-b3I0S0c", "ReverseDifference", "getReverseDifference-b3I0S0c", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getDifference-b3I0S0c  reason: not valid java name */
        public final int m5654getDifferenceb3I0S0c() {
            return PathOperation.Difference;
        }

        /* renamed from: getIntersect-b3I0S0c  reason: not valid java name */
        public final int m5655getIntersectb3I0S0c() {
            return PathOperation.Intersect;
        }

        /* renamed from: getUnion-b3I0S0c  reason: not valid java name */
        public final int m5657getUnionb3I0S0c() {
            return PathOperation.Union;
        }

        /* renamed from: getXor-b3I0S0c  reason: not valid java name */
        public final int m5658getXorb3I0S0c() {
            return PathOperation.Xor;
        }

        /* renamed from: getReverseDifference-b3I0S0c  reason: not valid java name */
        public final int m5656getReverseDifferenceb3I0S0c() {
            return PathOperation.ReverseDifference;
        }
    }

    private /* synthetic */ PathOperation(int i) {
        this.value = i;
    }

    public String toString() {
        return m5652toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5652toStringimpl(int i) {
        return m5650equalsimpl0(i, Difference) ? "Difference" : m5650equalsimpl0(i, Intersect) ? "Intersect" : m5650equalsimpl0(i, Union) ? "Union" : m5650equalsimpl0(i, Xor) ? "Xor" : m5650equalsimpl0(i, ReverseDifference) ? "ReverseDifference" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
