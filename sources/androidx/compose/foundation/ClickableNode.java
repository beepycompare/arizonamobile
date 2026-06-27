package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u001f\u0010&\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0007H\u0002JQ\u0010/\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b0J\u0017\u00101\u001a\u00020\u00072\u0006\u0010 \u001a\u000202H\u0004¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00072\u0006\u0010 \u001a\u000202H\u0004¢\u0006\u0004\b6\u00104R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "indirectDownEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "handleDownEvent", "down", "handleUpEvent", "up", "handleNonUpEventIfNeeded", "handleNonUpEventIfNeeded-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "indirectPointerEvent", "checkForCancellation", "onCancelPointerInput", "onCancelIndirectPointerInput", "cancelInput", "indirectPointer", "update", "update-O2vRcR0", "onClickKeyDownEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public class ClickableNode extends AbstractClickableNode {
    public static final int $stable = 8;
    private PointerInputChange downEvent;
    private IndirectPointerInputChange indirectDownEvent;

    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyDownEvent-ZmokQxo */
    protected final boolean mo254onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    private ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        super(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0, null);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo257onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo257onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        if (pointerEventPass == PointerEventPass.Main) {
            if (this.downEvent == null) {
                if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true, false, 2, null)) {
                    handleDownEvent(pointerEvent.getChanges().get(0));
                    return;
                }
                return;
            }
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                if (!PointerEventKt.changedToUp(changes.get(i))) {
                    m337handleNonUpEventIfNeededO0kMr_c(pointerEvent, j);
                    return;
                }
            }
            handleUpEvent(pointerEvent.getChanges().get(0));
        } else if (pointerEventPass == PointerEventPass.Final) {
            checkForCancellation(pointerEvent);
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass) {
        super.onIndirectPointerEvent(indirectPointerEvent, pointerEventPass);
        if (pointerEventPass == PointerEventPass.Main) {
            if (this.indirectDownEvent == null) {
                List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(changes.get(i))) {
                        handleDownEvent(indirectPointerEvent.getChanges().get(0));
                        return;
                    }
                }
                return;
            }
            List<IndirectPointerInputChange> changes2 = indirectPointerEvent.getChanges();
            int size2 = changes2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (!ClickableKt.access$changedToUp(changes2.get(i2))) {
                    handleNonUpEventIfNeeded(indirectPointerEvent);
                    return;
                }
            }
            handleUpEvent(indirectPointerEvent.getChanges().get(0));
        } else if (pointerEventPass == PointerEventPass.Final) {
            checkForCancellation(indirectPointerEvent);
        }
    }

    private final void handleDownEvent(PointerInputChange pointerInputChange) {
        pointerInputChange.consume();
        this.downEvent = pointerInputChange;
        if (getEnabled()) {
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(pointerInputChange);
            } else {
                m253handlePressInteractionStart3MmeM6k(pointerInputChange.m6685getPositionF1C5BW0(), false);
            }
        }
    }

    private final void handleDownEvent(IndirectPointerInputChange indirectPointerInputChange) {
        indirectPointerInputChange.consume();
        this.indirectDownEvent = indirectPointerInputChange;
        if (getEnabled()) {
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(indirectPointerInputChange);
            } else {
                m253handlePressInteractionStart3MmeM6k(indirectPointerInputChange.m6190getPositionF1C5BW0(), true);
            }
        }
    }

    private final void handleUpEvent(PointerInputChange pointerInputChange) {
        pointerInputChange.consume();
        if (getEnabled()) {
            PointerInputChange pointerInputChange2 = this.downEvent;
            Intrinsics.checkNotNull(pointerInputChange2);
            m252handlePressInteractionRelease3MmeM6k(pointerInputChange2.m6685getPositionF1C5BW0(), false);
            getOnClick().invoke();
        }
        this.downEvent = null;
    }

    private final void handleUpEvent(IndirectPointerInputChange indirectPointerInputChange) {
        indirectPointerInputChange.consume();
        if (getEnabled()) {
            IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
            Intrinsics.checkNotNull(indirectPointerInputChange2);
            m252handlePressInteractionRelease3MmeM6k(indirectPointerInputChange2.m6190getPositionF1C5BW0(), true);
            getOnClick().invoke();
        }
        this.indirectDownEvent = null;
    }

    /* renamed from: handleNonUpEventIfNeeded-O0kMr_c  reason: not valid java name */
    private final void m337handleNonUpEventIfNeededO0kMr_c(PointerEvent pointerEvent, long j) {
        long j2 = m250getExtendedTouchPaddinghWWAJMo(j);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.isConsumed() || PointerEventKt.m6621isOutOfBoundsjwHxaWs(pointerInputChange, j, j2)) {
                cancelInput(false);
                return;
            }
        }
    }

    private final void handleNonUpEventIfNeeded(IndirectPointerEvent indirectPointerEvent) {
        float touchSlop = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getTouchSlop();
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
            long m6190getPositionF1C5BW0 = indirectPointerInputChange.m6190getPositionF1C5BW0();
            IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
            Intrinsics.checkNotNull(indirectPointerInputChange2);
            boolean z = Math.abs(Offset.m5101getDistanceimpl(Offset.m5107minusMKHz9U(m6190getPositionF1C5BW0, indirectPointerInputChange2.m6190getPositionF1C5BW0()))) > touchSlop;
            if (indirectPointerInputChange.isConsumed() || z) {
                cancelInput(true);
                return;
            }
        }
    }

    private final void checkForCancellation(PointerEvent pointerEvent) {
        if (this.downEvent != null) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = changes.get(i);
                if (pointerInputChange.isConsumed() && !Intrinsics.areEqual(pointerInputChange, this.downEvent)) {
                    cancelInput(false);
                    return;
                }
            }
        }
    }

    private final void checkForCancellation(IndirectPointerEvent indirectPointerEvent) {
        if (this.indirectDownEvent != null) {
            List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
                if (indirectPointerInputChange.isConsumed() && !Intrinsics.areEqual(indirectPointerInputChange, this.indirectDownEvent)) {
                    cancelInput(true);
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        cancelInput(false);
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        cancelInput(true);
    }

    private final void cancelInput(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
        } else {
            this.downEvent = null;
        }
        handlePressInteractionCancel(z);
    }

    /* renamed from: update-O2vRcR0  reason: not valid java name */
    public final void m338updateO2vRcR0(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        m259updateCommonO2vRcR0(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyUpEvent-ZmokQxo */
    protected final boolean mo255onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        getOnClick().invoke();
        return true;
    }
}
