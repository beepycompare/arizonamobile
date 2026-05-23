package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FlexBox.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignContent;", "", "bits", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FlexAlignContent {
    public static final Companion Companion = new Companion(null);
    private final int bits;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FlexAlignContent m785boximpl(int i) {
        return new FlexAlignContent(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m786constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m787equalsimpl(int i, Object obj) {
        return (obj instanceof FlexAlignContent) && i == ((FlexAlignContent) obj).m791unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m788equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m789hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m787equalsimpl(this.bits, obj);
    }

    public int hashCode() {
        return m789hashCodeimpl(this.bits);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m791unboximpl() {
        return this.bits;
    }

    private /* synthetic */ FlexAlignContent(int i) {
        this.bits = i;
    }

    public String toString() {
        return m790toStringimpl(this.bits);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m790toStringimpl(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return "SpaceAround";
                            }
                            return "INVALID";
                        }
                        return "SpaceBetween";
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
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignContent$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/FlexAlignContent;", "getStart-d9B3MrI", "()I", "End", "getEnd-d9B3MrI", "Center", "getCenter-d9B3MrI", "Stretch", "getStretch-d9B3MrI", "SpaceBetween", "getSpaceBetween-d9B3MrI", "SpaceAround", "getSpaceAround-d9B3MrI", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getStart-d9B3MrI  reason: not valid java name */
        public final int m796getStartd9B3MrI() {
            return FlexAlignContent.m786constructorimpl(0);
        }

        /* renamed from: getEnd-d9B3MrI  reason: not valid java name */
        public final int m793getEndd9B3MrI() {
            return FlexAlignContent.m786constructorimpl(1);
        }

        /* renamed from: getCenter-d9B3MrI  reason: not valid java name */
        public final int m792getCenterd9B3MrI() {
            return FlexAlignContent.m786constructorimpl(2);
        }

        /* renamed from: getStretch-d9B3MrI  reason: not valid java name */
        public final int m797getStretchd9B3MrI() {
            return FlexAlignContent.m786constructorimpl(3);
        }

        /* renamed from: getSpaceBetween-d9B3MrI  reason: not valid java name */
        public final int m795getSpaceBetweend9B3MrI() {
            return FlexAlignContent.m786constructorimpl(4);
        }

        /* renamed from: getSpaceAround-d9B3MrI  reason: not valid java name */
        public final int m794getSpaceAroundd9B3MrI() {
            return FlexAlignContent.m786constructorimpl(5);
        }
    }
}
