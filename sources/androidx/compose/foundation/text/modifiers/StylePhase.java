package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextStyleProviderNode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\t\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/modifiers/StylePhase;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class StylePhase {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Layout = m2009constructorimpl(1);
    private static final int Draw = m2009constructorimpl(2);
    private static final int All = m2009constructorimpl(-1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ StylePhase m2008boximpl(int i) {
        return new StylePhase(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m2009constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2010equalsimpl(int i, Object obj) {
        return (obj instanceof StylePhase) && i == ((StylePhase) obj).m2014unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2011equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2012hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2013toStringimpl(int i) {
        return "StylePhase(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2010equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2012hashCodeimpl(this.value);
    }

    public String toString() {
        return m2013toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2014unboximpl() {
        return this.value;
    }

    /* compiled from: TextStyleProviderNode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/modifiers/StylePhase$Companion;", "", "<init>", "()V", "Layout", "Landroidx/compose/foundation/text/modifiers/StylePhase;", "getLayout-oWBPZag", "()I", "I", "Draw", "getDraw-oWBPZag", "All", "getAll-oWBPZag", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLayout-oWBPZag  reason: not valid java name */
        public final int m2017getLayoutoWBPZag() {
            return StylePhase.Layout;
        }

        /* renamed from: getDraw-oWBPZag  reason: not valid java name */
        public final int m2016getDrawoWBPZag() {
            return StylePhase.Draw;
        }

        /* renamed from: getAll-oWBPZag  reason: not valid java name */
        public final int m2015getAlloWBPZag() {
            return StylePhase.All;
        }
    }

    private /* synthetic */ StylePhase(int i) {
        this.value = i;
    }
}
