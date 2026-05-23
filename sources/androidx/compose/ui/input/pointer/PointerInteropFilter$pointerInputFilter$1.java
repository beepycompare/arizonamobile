package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerInteropFilter.android.kt */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "lastEventDispatchedToInitialPass", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancel", "reset", "dispatchToView", "shouldConsume", "stopDispatching", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerEvent lastEventDispatchedToInitialPass;
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0124 A[ORIG_RETURN, RETURN] */
    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo6710onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (!changes.get(i2).isConsumed()) {
                }
            }
            z2 = true;
            if (!this.this$0.getDisallowIntercept$ui()) {
                int size3 = list.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size3) {
                        PointerInputChange pointerInputChange2 = changes.get(i3);
                        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                            break;
                        }
                        i3++;
                    } else if (!z2) {
                        z3 = false;
                    }
                }
            }
            z3 = true;
            if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
                if (pointerEventPass == PointerEventPass.Initial && z3) {
                    this.lastEventDispatchedToInitialPass = pointerEvent;
                    dispatchToView(pointerEvent, !z || this.this$0.getDisallowIntercept$ui());
                }
                if (pointerEventPass == PointerEventPass.Main && z && Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass) && this.this$0.getDisallowIntercept$ui()) {
                    int size4 = list.size();
                    for (int i4 = 0; i4 < size4; i4++) {
                        changes.get(i4).consume();
                    }
                }
                if (pointerEventPass == PointerEventPass.Final && !z3 && !Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass)) {
                    dispatchToView(pointerEvent, true);
                }
            }
            if (pointerEventPass != PointerEventPass.Final) {
                int size5 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 < size5) {
                        if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i5))) {
                            break;
                        }
                        i5++;
                    } else {
                        reset();
                        break;
                    }
                }
                if (Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass) && z) {
                    int size6 = list.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size6) {
                            break;
                        } else if (!changes.get(i6).isConsumed()) {
                            i6++;
                        } else if (!this.this$0.getDisallowIntercept$ui()) {
                            stopDispatching(pointerEvent);
                            return;
                        }
                    }
                    int size7 = list.size();
                    for (int i7 = 0; i7 < size7; i7++) {
                        changes.get(i7).consume();
                    }
                    return;
                }
                return;
            }
            return;
        }
        z2 = false;
        if (!this.this$0.getDisallowIntercept$ui()) {
        }
        z3 = true;
        if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
        }
        if (pointerEventPass != PointerEventPass.Final) {
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(uptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                }
            });
            reset();
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui(false);
        this.lastEventDispatchedToInitialPass = null;
    }

    private final void dispatchToView(PointerEvent pointerEvent, boolean z) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (changes.get(i).isConsumed()) {
                stopDispatching(pointerEvent);
                return;
            }
        }
        LayoutCoordinates layoutCoordinates$ui = getLayoutCoordinates$ui();
        if (layoutCoordinates$ui != null) {
            long mo6829localToRootMKHz9U = layoutCoordinates$ui.mo6829localToRootMKHz9U(Offset.Companion.m5119getZeroF1C5BW0());
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.m6746toMotionEventScoped4ec7I(pointerEvent, mo6829localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    PointerInteropFilter.DispatchToViewState dispatchToViewState;
                    if (motionEvent.getActionMasked() == 0) {
                        PointerInteropFilter$pointerInputFilter$1 pointerInteropFilter$pointerInputFilter$1 = PointerInteropFilter$pointerInputFilter$1.this;
                        if (pointerInteropFilter.getOnTouchEvent().invoke(motionEvent).booleanValue()) {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.Dispatching;
                        } else {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.NotDispatching;
                        }
                        pointerInteropFilter$pointerInputFilter$1.state = dispatchToViewState;
                        return;
                    }
                    pointerInteropFilter.getOnTouchEvent().invoke(motionEvent);
                }
            });
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                if (z) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        changes.get(i2).consume();
                    }
                }
                InternalPointerEvent internalPointerEvent$ui = pointerEvent.getInternalPointerEvent$ui();
                if (internalPointerEvent$ui != null) {
                    internalPointerEvent$ui.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept$ui());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }

    private final void stopDispatching(PointerEvent pointerEvent) {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            LayoutCoordinates layoutCoordinates$ui = getLayoutCoordinates$ui();
            if (layoutCoordinates$ui != null) {
                long mo6829localToRootMKHz9U = layoutCoordinates$ui.mo6829localToRootMKHz9U(Offset.Companion.m5119getZeroF1C5BW0());
                final PointerInteropFilter pointerInteropFilter = this.this$0;
                PointerInteropUtils_androidKt.m6745toCancelMotionEventScoped4ec7I(pointerEvent, mo6829localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$stopDispatching$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                        invoke2(motionEvent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MotionEvent motionEvent) {
                        PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                    }
                });
            } else {
                throw new IllegalStateException("layoutCoordinates not set".toString());
            }
        }
        this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
    }
}
