package androidx.compose.ui.input.nestedscroll;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: NestedScrollModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class NestedScrollSource {
    public static final Companion Companion = new Companion(null);
    private static final int Drag;
    private static final int Fling;
    private static final int Relocate;
    private static final int SideEffect;
    private static final int UserInput;
    private static final int Wheel;
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m6539boximpl(int i) {
        return new NestedScrollSource(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6540constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6541equalsimpl(int i, Object obj) {
        return (obj instanceof NestedScrollSource) && i == ((NestedScrollSource) obj).m6545unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6542equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6543hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6541equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6543hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6545unboximpl() {
        return this.value;
    }

    private /* synthetic */ NestedScrollSource(int i) {
        this.value = i;
    }

    public String toString() {
        return m6544toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6544toStringimpl(int i) {
        return m6542equalsimpl0(i, UserInput) ? "UserInput" : m6542equalsimpl0(i, SideEffect) ? "SideEffect" : m6542equalsimpl0(i, Relocate) ? "Relocate" : "Invalid";
    }

    /* compiled from: NestedScrollModifier.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0007R\u001e\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0007R\u001e\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "<init>", "()V", "UserInput", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getUserInput-WNlRxjI", "()I", "I", "SideEffect", "getSideEffect-WNlRxjI", "Drag", "getDrag-WNlRxjI$annotations", "getDrag-WNlRxjI", "Fling", "getFling-WNlRxjI$annotations", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "Wheel", "getWheel-WNlRxjI$annotations", "getWheel-WNlRxjI", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.UserInput", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.UserInput"}))
        /* renamed from: getDrag-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m6546getDragWNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by SideEffect.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.SideEffect", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect"}))
        /* renamed from: getFling-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m6547getFlingWNlRxjI$annotations() {
        }

        @Deprecated(message = "Do not use. Will be removed in the future.")
        /* renamed from: getRelocate-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m6548getRelocateWNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(expression = "NestedScrollSource.UserInput", imports = {"import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.UserInput"}))
        /* renamed from: getWheel-WNlRxjI$annotations  reason: not valid java name */
        public static /* synthetic */ void m6549getWheelWNlRxjI$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUserInput-WNlRxjI  reason: not valid java name */
        public final int m6554getUserInputWNlRxjI() {
            return NestedScrollSource.UserInput;
        }

        /* renamed from: getSideEffect-WNlRxjI  reason: not valid java name */
        public final int m6553getSideEffectWNlRxjI() {
            return NestedScrollSource.SideEffect;
        }

        /* renamed from: getDrag-WNlRxjI  reason: not valid java name */
        public final int m6550getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* renamed from: getFling-WNlRxjI  reason: not valid java name */
        public final int m6551getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }

        /* renamed from: getRelocate-WNlRxjI  reason: not valid java name */
        public final int m6552getRelocateWNlRxjI() {
            return NestedScrollSource.Relocate;
        }

        /* renamed from: getWheel-WNlRxjI  reason: not valid java name */
        public final int m6555getWheelWNlRxjI() {
            return NestedScrollSource.Wheel;
        }
    }

    static {
        int m6540constructorimpl = m6540constructorimpl(1);
        UserInput = m6540constructorimpl;
        int m6540constructorimpl2 = m6540constructorimpl(2);
        SideEffect = m6540constructorimpl2;
        Drag = m6540constructorimpl;
        Fling = m6540constructorimpl2;
        Relocate = m6540constructorimpl(3);
        Wheel = m6540constructorimpl;
    }
}
