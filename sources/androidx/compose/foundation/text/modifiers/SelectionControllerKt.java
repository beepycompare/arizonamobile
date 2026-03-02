package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
/* compiled from: SelectionController.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0000¨\u0006\b"}, d2 = {"makeDefaultSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionControllerKt {
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1, java.lang.Object] */
    public static final Modifier makeDefaultSelectionModifier(final SelectionRegistrar selectionRegistrar, final long j, final Function0<? extends LayoutCoordinates> function0) {
        final ?? r0 = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1
            private long lastPosition = Offset.Companion.m4543getZeroF1C5BW0();
            private long dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
            private SelectionAdjustment selectionAdjustmentMode = SelectionAdjustment.Companion.getNone();

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1253onDownk4lQ0M(long j2) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            public final long getLastPosition() {
                return this.lastPosition;
            }

            public final void setLastPosition(long j2) {
                this.lastPosition = j2;
            }

            public final long getDragTotalDistance() {
                return this.dragTotalDistance;
            }

            public final void setDragTotalDistance(long j2) {
                this.dragTotalDistance = j2;
            }

            public final SelectionAdjustment getSelectionAdjustmentMode() {
                return this.selectionAdjustmentMode;
            }

            public final void setSelectionAdjustmentMode(SelectionAdjustment selectionAdjustment) {
                this.selectionAdjustmentMode = selectionAdjustment;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-3MmeM6k */
            public void mo1255onStart3MmeM6k(long j2, SelectionAdjustment selectionAdjustment) {
                this.selectionAdjustmentMode = selectionAdjustment;
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    if (!invoke.isAttached()) {
                        return;
                    }
                    selectionRegistrar2.mo1644notifySelectionUpdateStartubNVwUQ(invoke, j2, this.selectionAdjustmentMode, true);
                    this.lastPosition = j2;
                }
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                    this.dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1254onDragk4lQ0M(long j2) {
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j3 = j;
                    if (invoke.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                        long m4532plusMKHz9U = Offset.m4532plusMKHz9U(this.dragTotalDistance, j2);
                        this.dragTotalDistance = m4532plusMKHz9U;
                        long m4532plusMKHz9U2 = Offset.m4532plusMKHz9U(this.lastPosition, m4532plusMKHz9U);
                        if (selectionRegistrar2.mo1643notifySelectionUpdatenjBpvok(invoke, m4532plusMKHz9U2, this.lastPosition, false, this.selectionAdjustmentMode, true)) {
                            this.lastPosition = m4532plusMKHz9U2;
                            this.dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
                        }
                    }
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                    selectionRegistrar.notifySelectionUpdateEnd();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                    selectionRegistrar.notifySelectionUpdateEnd();
                }
            }
        };
        final ?? r1 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1
            private long lastPosition = Offset.Companion.m4543getZeroF1C5BW0();

            public final long getLastPosition() {
                return this.lastPosition;
            }

            public final void setLastPosition(long j2) {
                this.lastPosition = j2;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1514onExtendk4lQ0M(long j2) {
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j3 = j;
                    if (invoke.isAttached()) {
                        if (selectionRegistrar2.mo1643notifySelectionUpdatenjBpvok(invoke, j2, this.lastPosition, false, SelectionAdjustment.Companion.getNone(), false)) {
                            this.lastPosition = j2;
                        }
                        return SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3);
                    }
                    return false;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1515onExtendDragk4lQ0M(long j2) {
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j3 = j;
                    if (invoke.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                        if (selectionRegistrar2.mo1643notifySelectionUpdatenjBpvok(invoke, j2, this.lastPosition, false, SelectionAdjustment.Companion.getNone(), false)) {
                            this.lastPosition = j2;
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-9KIMszo */
            public boolean mo1516onStart9KIMszo(long j2, SelectionAdjustment selectionAdjustment, int i) {
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j3 = j;
                    if (invoke.isAttached()) {
                        selectionRegistrar2.mo1644notifySelectionUpdateStartubNVwUQ(invoke, j2, selectionAdjustment, false);
                        this.lastPosition = j2;
                        return SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3);
                    }
                    return false;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1513onDrag3MmeM6k(long j2, SelectionAdjustment selectionAdjustment) {
                LayoutCoordinates invoke = function0.invoke();
                if (invoke != null) {
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    long j3 = j;
                    if (invoke.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                        if (selectionRegistrar2.mo1643notifySelectionUpdatenjBpvok(invoke, j2, this.lastPosition, false, selectionAdjustment, false)) {
                            this.lastPosition = j2;
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
                selectionRegistrar.notifySelectionUpdateEnd();
            }
        };
        return SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, (Object) r1, (Object) r0, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1.this, r0, continuation);
                return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
            }
        });
    }
}
