package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class TooltipAnchorPosition {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Above = m2872constructorimpl(1);
    private static final int Below = m2872constructorimpl(2);
    private static final int Left = m2872constructorimpl(3);
    private static final int Right = m2872constructorimpl(4);
    private static final int Start = m2872constructorimpl(5);
    private static final int End = m2872constructorimpl(6);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TooltipAnchorPosition m2871boximpl(int i) {
        return new TooltipAnchorPosition(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2872constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2873equalsimpl(int i, Object obj) {
        return (obj instanceof TooltipAnchorPosition) && i == ((TooltipAnchorPosition) obj).m2877unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2874equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2875hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2873equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2875hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2877unboximpl() {
        return this.value;
    }

    private /* synthetic */ TooltipAnchorPosition(int i) {
        this.value = i;
    }

    public String toString() {
        return m2876toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2876toStringimpl(int i) {
        return m2874equalsimpl0(i, Above) ? "Above" : m2874equalsimpl0(i, Below) ? "Below" : m2874equalsimpl0(i, Left) ? "Left" : m2874equalsimpl0(i, Right) ? "Right" : m2874equalsimpl0(i, Start) ? "Start" : m2874equalsimpl0(i, End) ? "End" : "Invalid";
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition$Companion;", "", "<init>", "()V", "Above", "Landroidx/compose/material3/TooltipAnchorPosition;", "getAbove-lOKsHw4", "()I", "I", "Below", "getBelow-lOKsHw4", "Left", "getLeft-lOKsHw4", "Right", "getRight-lOKsHw4", "Start", "getStart-lOKsHw4", "End", "getEnd-lOKsHw4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAbove-lOKsHw4  reason: not valid java name */
        public final int m2878getAbovelOKsHw4() {
            return TooltipAnchorPosition.Above;
        }

        /* renamed from: getBelow-lOKsHw4  reason: not valid java name */
        public final int m2879getBelowlOKsHw4() {
            return TooltipAnchorPosition.Below;
        }

        /* renamed from: getLeft-lOKsHw4  reason: not valid java name */
        public final int m2881getLeftlOKsHw4() {
            return TooltipAnchorPosition.Left;
        }

        /* renamed from: getRight-lOKsHw4  reason: not valid java name */
        public final int m2882getRightlOKsHw4() {
            return TooltipAnchorPosition.Right;
        }

        /* renamed from: getStart-lOKsHw4  reason: not valid java name */
        public final int m2883getStartlOKsHw4() {
            return TooltipAnchorPosition.Start;
        }

        /* renamed from: getEnd-lOKsHw4  reason: not valid java name */
        public final int m2880getEndlOKsHw4() {
            return TooltipAnchorPosition.End;
        }
    }
}
