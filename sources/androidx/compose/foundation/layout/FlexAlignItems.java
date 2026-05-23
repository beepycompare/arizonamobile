package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FlexBox.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignItems;", "", "bits", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FlexAlignItems {
    public static final Companion Companion = new Companion(null);
    private final int bits;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FlexAlignItems m798boximpl(int i) {
        return new FlexAlignItems(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m799constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m800equalsimpl(int i, Object obj) {
        return (obj instanceof FlexAlignItems) && i == ((FlexAlignItems) obj).m804unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m801equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m802hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m800equalsimpl(this.bits, obj);
    }

    public int hashCode() {
        return m802hashCodeimpl(this.bits);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m804unboximpl() {
        return this.bits;
    }

    private /* synthetic */ FlexAlignItems(int i) {
        this.bits = i;
    }

    public String toString() {
        return m803toStringimpl(this.bits);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m803toStringimpl(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return "Baseline";
                        }
                        return "INVALID";
                    }
                    return "Stretch";
                }
                return "Center";
            }
            return "End";
        }
        return "Start";
    }

    /* compiled from: FlexBox.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignItems$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/FlexAlignItems;", "getStart-20X20zU", "()I", "End", "getEnd-20X20zU", "Center", "getCenter-20X20zU", "Stretch", "getStretch-20X20zU", "Baseline", "getBaseline-20X20zU", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getStart-20X20zU  reason: not valid java name */
        public final int m808getStart20X20zU() {
            return FlexAlignItems.m799constructorimpl(0);
        }

        /* renamed from: getEnd-20X20zU  reason: not valid java name */
        public final int m807getEnd20X20zU() {
            return FlexAlignItems.m799constructorimpl(1);
        }

        /* renamed from: getCenter-20X20zU  reason: not valid java name */
        public final int m806getCenter20X20zU() {
            return FlexAlignItems.m799constructorimpl(2);
        }

        /* renamed from: getStretch-20X20zU  reason: not valid java name */
        public final int m809getStretch20X20zU() {
            return FlexAlignItems.m799constructorimpl(3);
        }

        /* renamed from: getBaseline-20X20zU  reason: not valid java name */
        public final int m805getBaseline20X20zU() {
            return FlexAlignItems.m799constructorimpl(4);
        }
    }
}
