package androidx.compose.ui.focus;

import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Focusability.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/Focusability;", "", "value", "", "constructor-impl", "(I)I", "canFocus", "", "node", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canFocus-impl$ui_release", "(ILandroidx/compose/ui/node/CompositionLocalConsumerModifierNode;)Z", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Focusability {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Always = m3767constructorimpl(1);
    private static final int SystemDefined = m3767constructorimpl(0);
    private static final int Never = m3767constructorimpl(2);

    /* renamed from: box-impl */
    public static final /* synthetic */ Focusability m3765boximpl(int i) {
        return new Focusability(i);
    }

    /* renamed from: constructor-impl */
    private static int m3767constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl */
    public static boolean m3768equalsimpl(int i, Object obj) {
        return (obj instanceof Focusability) && i == ((Focusability) obj).m3772unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m3769equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl */
    public static int m3770hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3768equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3770hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ int m3772unboximpl() {
        return this.value;
    }

    /* compiled from: Focusability.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/focus/Focusability$Companion;", "", "()V", "Always", "Landroidx/compose/ui/focus/Focusability;", "getAlways-LCbbffg", "()I", "I", "Never", "getNever-LCbbffg", "SystemDefined", "getSystemDefined-LCbbffg", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAlways-LCbbffg */
        public final int m3773getAlwaysLCbbffg() {
            return Focusability.Always;
        }

        /* renamed from: getSystemDefined-LCbbffg */
        public final int m3775getSystemDefinedLCbbffg() {
            return Focusability.SystemDefined;
        }

        /* renamed from: getNever-LCbbffg */
        public final int m3774getNeverLCbbffg() {
            return Focusability.Never;
        }
    }

    private /* synthetic */ Focusability(int i) {
        this.value = i;
    }

    public String toString() {
        return m3771toStringimpl(this.value);
    }

    /* renamed from: toString-impl */
    public static String m3771toStringimpl(int i) {
        if (m3769equalsimpl0(i, Always)) {
            return "Always";
        }
        if (m3769equalsimpl0(i, SystemDefined)) {
            return "SystemDefined";
        }
        if (m3769equalsimpl0(i, Never)) {
            return "Never";
        }
        throw new IllegalStateException("Unknown Focusability".toString());
    }

    /* renamed from: canFocus-impl$ui_release */
    public static final boolean m3766canFocusimpl$ui_release(int i, CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        if (m3769equalsimpl0(i, Always)) {
            return true;
        }
        if (m3769equalsimpl0(i, SystemDefined)) {
            return !InputMode.m4847equalsimpl0(((InputModeManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, CompositionLocalsKt.getLocalInputModeManager())).mo4853getInputModeaOaMEAU(), InputMode.Companion.m4852getTouchaOaMEAU());
        }
        if (m3769equalsimpl0(i, Never)) {
            return false;
        }
        throw new IllegalStateException("Unknown Focusability".toString());
    }
}
