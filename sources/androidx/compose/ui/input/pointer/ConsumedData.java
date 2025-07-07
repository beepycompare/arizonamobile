package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PointerEvent.kt */
@Deprecated(message = "Use PointerInputChange.isConsumed and PointerInputChange.consume() instead")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/input/pointer/ConsumedData;", "", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "positionChange", "", "downChange", "(ZZ)V", "value", "getDownChange$annotations", "()V", "getDownChange", "()Z", "setDownChange", "(Z)V", "getPositionChange$annotations", "getPositionChange", "setPositionChange", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConsumedData {
    public static final int $stable = 8;
    private PointerInputChange change;
    private boolean downChange;
    private boolean positionChange;

    public ConsumedData() {
        this(false, false, 3, null);
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getDownChange$annotations() {
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getPositionChange$annotations() {
    }

    public ConsumedData(boolean z, boolean z2) {
        this.positionChange = z;
        this.downChange = z2;
    }

    public /* synthetic */ ConsumedData(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public ConsumedData(PointerInputChange pointerInputChange) {
        this(pointerInputChange.getPositionChange$ui_release(), pointerInputChange.getDownChange$ui_release());
        this.change = pointerInputChange;
    }

    public final boolean getPositionChange() {
        PointerInputChange consumedDelegate$ui_release;
        PointerInputChange pointerInputChange = this.change;
        if (pointerInputChange == null || (consumedDelegate$ui_release = pointerInputChange.getConsumedDelegate$ui_release()) == null) {
            PointerInputChange pointerInputChange2 = this.change;
            return pointerInputChange2 != null ? pointerInputChange2.getPositionChange$ui_release() : this.positionChange;
        }
        return consumedDelegate$ui_release.getPositionChange$ui_release();
    }

    public final void setPositionChange(boolean z) {
        PointerInputChange pointerInputChange = this.change;
        PointerInputChange consumedDelegate$ui_release = pointerInputChange != null ? pointerInputChange.getConsumedDelegate$ui_release() : null;
        if (consumedDelegate$ui_release != null) {
            consumedDelegate$ui_release.setPositionChange$ui_release(z);
        }
        PointerInputChange pointerInputChange2 = this.change;
        if (pointerInputChange2 != null) {
            pointerInputChange2.setPositionChange$ui_release(z);
        }
        this.positionChange = z;
    }

    public final boolean getDownChange() {
        PointerInputChange consumedDelegate$ui_release;
        PointerInputChange pointerInputChange = this.change;
        if (pointerInputChange == null || (consumedDelegate$ui_release = pointerInputChange.getConsumedDelegate$ui_release()) == null) {
            PointerInputChange pointerInputChange2 = this.change;
            return pointerInputChange2 != null ? pointerInputChange2.getDownChange$ui_release() : this.downChange;
        }
        return consumedDelegate$ui_release.getDownChange$ui_release();
    }

    public final void setDownChange(boolean z) {
        PointerInputChange pointerInputChange = this.change;
        PointerInputChange consumedDelegate$ui_release = pointerInputChange != null ? pointerInputChange.getConsumedDelegate$ui_release() : null;
        if (consumedDelegate$ui_release != null) {
            consumedDelegate$ui_release.setDownChange$ui_release(z);
        }
        PointerInputChange pointerInputChange2 = this.change;
        if (pointerInputChange2 != null) {
            pointerInputChange2.setDownChange$ui_release(z);
        }
        this.downChange = z;
    }
}
