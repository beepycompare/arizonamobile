package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndirectPointerInputDragCycleDetector.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020-J3\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020!2\b\b\u0002\u00109\u001a\u00020:H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020-H\u0002J'\u0010A\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0004\bB\u0010CJ \u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\tH\u0002J \u0010F\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u0013H\u0002J \u0010G\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u0018H\u0002J \u0010H\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u00020\u000eH\u0002J1\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u0002052\u0006\u0010K\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020!H\u0002¢\u0006\u0004\bO\u0010PJ)\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010S\u001a\u00020!H\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020-2\u0006\u0010R\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010MH\u0002¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020-H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"¨\u0006Z"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "", "node", "Landroidx/compose/foundation/gestures/DragGestureNode;", "<init>", "(Landroidx/compose/foundation/gestures/DragGestureNode;)V", "getNode", "()Landroidx/compose/foundation/gestures/DragGestureNode;", "_awaitDownState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "touchSmooth", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "offsetSmoother", "Landroidx/compose/foundation/gestures/OffsetSmoother;", "nodeOffset", "requireTouchSlopDetector", "requireVelocityTracker", "processIndirectPointerInputEvent", "", "indirectPointerInputEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "(J)V", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", RemoteConfigConstants.ResponseFieldKey.STATE, "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "overSlopOffset", "sendDragStart-3f7A7Is", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Eu1f8Dk", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;J)V", "sendDragStopped", "sendDragStopped-k92h6UU", "sendDragCancelled", "DragDetectionState", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndirectPointerInputDragCycleDetector {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private DragDetectionState currentDragState;
    private final DragGestureNode node;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private long previousPositionOnScreen = Offset.Companion.m4542getUnspecifiedF1C5BW0();
    private final IndirectPointerInputEventSmoother touchSmooth = new IndirectPointerInputEventSmoother();
    private final OffsetSmoother offsetSmoother = new OffsetSmoother();
    private long nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();

    /* compiled from: IndirectPointerInputDragCycleDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DragDetectionState.AwaitDown.AwaitTouchSlop.values().length];
            try {
                iArr[DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IndirectPointerInputDragCycleDetector(DragGestureNode dragGestureNode) {
        this.node = dragGestureNode;
    }

    public final DragGestureNode getNode() {
        return this.node;
    }

    private final DragDetectionState.AwaitDown getAwaitDownState() {
        DragDetectionState.AwaitDown awaitDown = this._awaitDownState;
        if (awaitDown == null) {
            DragDetectionState.AwaitDown awaitDown2 = new DragDetectionState.AwaitDown(null, false, 3, null);
            this._awaitDownState = awaitDown2;
            return awaitDown2;
        }
        return awaitDown;
    }

    private final DragDetectionState.Dragging getDraggingState() {
        DragDetectionState.Dragging dragging = this._draggingState;
        if (dragging == null) {
            DragDetectionState.Dragging dragging2 = new DragDetectionState.Dragging(0L, 1, null);
            this._draggingState = dragging2;
            return dragging2;
        }
        return dragging;
    }

    private final DragDetectionState.AwaitTouchSlop getAwaitTouchSlopState() {
        DragDetectionState.AwaitTouchSlop awaitTouchSlop = this._awaitTouchSlopState;
        if (awaitTouchSlop == null) {
            DragDetectionState.AwaitTouchSlop awaitTouchSlop2 = new DragDetectionState.AwaitTouchSlop(null, 0L, false, 7, null);
            this._awaitTouchSlopState = awaitTouchSlop2;
            return awaitTouchSlop2;
        }
        return awaitTouchSlop;
    }

    private final DragDetectionState.AwaitGesturePickup getAwaitGesturePickupState() {
        DragDetectionState.AwaitGesturePickup awaitGesturePickup = this._awaitGesturePickupState;
        if (awaitGesturePickup == null) {
            DragDetectionState.AwaitGesturePickup awaitGesturePickup2 = new DragDetectionState.AwaitGesturePickup(null, 0L, null, 7, null);
            this._awaitGesturePickupState = awaitGesturePickup2;
            return awaitGesturePickup2;
        }
        return awaitGesturePickup;
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    public final void processIndirectPointerInputEvent(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass) {
        if (this.currentDragState == null) {
            this.currentDragState = getAwaitDownState();
        }
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(indirectPointerEvent, pointerEventPass, (DragDetectionState.AwaitDown) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(indirectPointerEvent, pointerEventPass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(indirectPointerEvent, pointerEventPass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
            throw new NoWhenBranchMatchedException();
        } else {
            processDraggingState(indirectPointerEvent, pointerEventPass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    public final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.node.isListeningForEvents$foundation()) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
        this.offsetSmoother.reset();
    }

    /* renamed from: moveToAwaitTouchSlopState-aWI9W7U$default  reason: not valid java name */
    static /* synthetic */ void m496moveToAwaitTouchSlopStateaWI9W7U$default(IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector, IndirectPointerInputChange indirectPointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = Offset.Companion.m4543getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        indirectPointerInputDragCycleDetector.m495moveToAwaitTouchSlopStateaWI9W7U(indirectPointerInputChange, j, j3, z);
    }

    /* renamed from: moveToAwaitTouchSlopState-aWI9W7U  reason: not valid java name */
    private final void m495moveToAwaitTouchSlopStateaWI9W7U(IndirectPointerInputChange indirectPointerInputChange, long j, long j2, boolean z) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(indirectPointerInputChange);
        awaitTouchSlopState.m504setPointerId0FcD4WY(j);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.node.getOrientationLock(), 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.node.getOrientationLock());
            }
            TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
            if (touchSlopDetector2 != null) {
                touchSlopDetector2.m607resetk4lQ0M(j2);
            }
        }
        awaitTouchSlopState.setVerifyConsumptionInFinalPass(z);
        this.currentDragState = awaitTouchSlopState;
    }

    /* renamed from: moveToDraggingState-0FcD4WY  reason: not valid java name */
    private final void m497moveToDraggingState0FcD4WY(long j) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m506setPointerId0FcD4WY(j);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* renamed from: moveToAwaitGesturePickupState-rnUCldI  reason: not valid java name */
    private final void m494moveToAwaitGesturePickupStaternUCldI(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(indirectPointerInputChange);
        awaitGesturePickupState.m502setPointerId0FcD4WY(j);
        TouchSlopDetector.m603resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitDown awaitDown) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        boolean changedToDownIgnoreConsumed;
        if (indirectPointerEvent.getChanges().isEmpty()) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            changedToDownIgnoreConsumed = IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(changes.get(i));
            if (!changedToDownIgnoreConsumed) {
                return;
            }
        }
        IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) CollectionsKt.first((List<? extends Object>) indirectPointerEvent.getChanges());
        if (WhenMappings.$EnumSwitchMapping$0[awaitDown.getAwaitTouchSlop().ordinal()] == 1) {
            if (!this.node.startDragImmediately()) {
                awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
            } else {
                awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.No;
            }
        } else {
            awaitTouchSlop = awaitDown.getAwaitTouchSlop();
        }
        awaitDown.setAwaitTouchSlop(awaitTouchSlop);
        if (pointerEventPass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.No) {
            indirectPointerInputChange.consume();
            awaitDown.setConsumedOnInitial(true);
        }
        if (pointerEventPass == PointerEventPass.Main) {
            if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                m496moveToAwaitTouchSlopStateaWI9W7U$default(this, indirectPointerInputChange, indirectPointerInputChange.m5612getIdJ3iCeTQ(), 0L, false, 12, null);
            } else if (awaitDown.getConsumedOnInitial()) {
                m499sendDragStart3f7A7Is(indirectPointerInputChange, indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()), Offset.Companion.m4543getZeroF1C5BW0());
                m498sendDragEventEu1f8Dk(indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()), Offset.Companion.m4543getZeroF1C5BW0());
                m497moveToDraggingState0FcD4WY(indirectPointerInputChange.m5612getIdJ3iCeTQ());
            }
        }
    }

    private final void processAwaitTouchSlop(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitTouchSlop awaitTouchSlop) {
        IndirectPointerInputChange indirectPointerInputChange;
        IndirectPointerInputChange indirectPointerInputChange2;
        boolean changedToUpIgnoreConsumed;
        long m517primaryAxisPosition_bfSUIo;
        long m519primaryAxisPreviousPosition_bfSUIo;
        IndirectPointerInputChange indirectPointerInputChange3;
        if (pointerEventPass == PointerEventPass.Initial) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            indirectPointerInputChange = null;
            if (i >= size) {
                indirectPointerInputChange2 = null;
                break;
            }
            indirectPointerInputChange2 = changes.get(i);
            if (PointerId.m6067equalsimpl0(indirectPointerInputChange2.m5612getIdJ3iCeTQ(), awaitTouchSlop.m503getPointerIdJ3iCeTQ())) {
                break;
            }
            i++;
        }
        IndirectPointerInputChange indirectPointerInputChange4 = indirectPointerInputChange2;
        if (indirectPointerInputChange4 == null) {
            List<IndirectPointerInputChange> changes2 = indirectPointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    indirectPointerInputChange3 = null;
                    break;
                }
                indirectPointerInputChange3 = changes2.get(i2);
                if (indirectPointerInputChange3.getPressed()) {
                    break;
                }
                i2++;
            }
            indirectPointerInputChange4 = indirectPointerInputChange3;
            if (indirectPointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            awaitTouchSlop.m504setPointerId0FcD4WY(indirectPointerInputChange4.m5612getIdJ3iCeTQ());
        }
        IndirectPointerInputChange indirectPointerInputChange5 = indirectPointerInputChange4;
        if (pointerEventPass == PointerEventPass.Main) {
            if (!indirectPointerInputChange5.isConsumed()) {
                changedToUpIgnoreConsumed = IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange5);
                if (changedToUpIgnoreConsumed) {
                    List<IndirectPointerInputChange> changes3 = indirectPointerEvent.getChanges();
                    int size3 = changes3.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        IndirectPointerInputChange indirectPointerInputChange6 = changes3.get(i3);
                        if (indirectPointerInputChange6.getPressed()) {
                            indirectPointerInputChange = indirectPointerInputChange6;
                            break;
                        }
                        i3++;
                    }
                    IndirectPointerInputChange indirectPointerInputChange7 = indirectPointerInputChange;
                    if (indirectPointerInputChange7 == null) {
                        moveToAwaitDownState();
                    } else {
                        awaitTouchSlop.m504setPointerId0FcD4WY(indirectPointerInputChange7.m5612getIdJ3iCeTQ());
                    }
                } else {
                    float m476pointerSlopE8SPZFQ = DragGestureDetectorKt.m476pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration()), PointerType.Companion.m6163getTouchT8wyACA());
                    TouchSlopDetector requireTouchSlopDetector = requireTouchSlopDetector();
                    m517primaryAxisPosition_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m517primaryAxisPosition_bfSUIo(indirectPointerInputChange5, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
                    m519primaryAxisPreviousPosition_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m519primaryAxisPreviousPosition_bfSUIo(indirectPointerInputChange5, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
                    long m604addPositionsakrDWew = requireTouchSlopDetector.m604addPositionsakrDWew(m517primaryAxisPosition_bfSUIo, m519primaryAxisPreviousPosition_bfSUIo, m476pointerSlopE8SPZFQ);
                    if ((9223372034707292159L & m604addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        indirectPointerInputChange5.consume();
                        IndirectPointerInputChange initialDown = awaitTouchSlop.getInitialDown();
                        Intrinsics.checkNotNull(initialDown);
                        m499sendDragStart3f7A7Is(initialDown, indirectPointerInputChange5, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()), m604addPositionsakrDWew);
                        m498sendDragEventEu1f8Dk(indirectPointerInputChange5, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()), m604addPositionsakrDWew);
                        m497moveToDraggingState0FcD4WY(indirectPointerInputChange5.m5612getIdJ3iCeTQ());
                    } else {
                        awaitTouchSlop.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                IndirectPointerInputChange initialDown2 = awaitTouchSlop.getInitialDown();
                if (initialDown2 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long m503getPointerIdJ3iCeTQ = awaitTouchSlop.m503getPointerIdJ3iCeTQ();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m494moveToAwaitGesturePickupStaternUCldI(initialDown2, m503getPointerIdJ3iCeTQ, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pointerEventPass == PointerEventPass.Final && awaitTouchSlop.getVerifyConsumptionInFinalPass()) {
            if (indirectPointerInputChange5.isConsumed()) {
                IndirectPointerInputChange initialDown3 = awaitTouchSlop.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long m503getPointerIdJ3iCeTQ2 = awaitTouchSlop.m503getPointerIdJ3iCeTQ();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m494moveToAwaitGesturePickupStaternUCldI(initialDown3, m503getPointerIdJ3iCeTQ2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            awaitTouchSlop.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitGesturePickup awaitGesturePickup) {
        boolean z;
        long m517primaryAxisPosition_bfSUIo;
        long m517primaryAxisPosition_bfSUIo2;
        if (pointerEventPass != PointerEventPass.Final) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = true;
                break;
            } else if (changes.get(i2).isConsumed()) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        List<IndirectPointerInputChange> changes2 = indirectPointerEvent.getChanges();
        int size2 = changes2.size();
        while (true) {
            if (i >= size2) {
                break;
            } else if (!changes2.get(i).getPressed()) {
                i++;
            } else if (!indirectPointerEvent.getChanges().isEmpty()) {
                if (z) {
                    m517primaryAxisPosition_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m517primaryAxisPosition_bfSUIo((IndirectPointerInputChange) CollectionsKt.first((List<? extends Object>) indirectPointerEvent.getChanges()), this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
                    IndirectPointerInputChange initialDown = awaitGesturePickup.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    m517primaryAxisPosition_bfSUIo2 = IndirectPointerInputDragCycleDetectorKt.m517primaryAxisPosition_bfSUIo(initialDown, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
                    long m4531minusMKHz9U = Offset.m4531minusMKHz9U(m517primaryAxisPosition_bfSUIo, m517primaryAxisPosition_bfSUIo2);
                    IndirectPointerInputChange initialDown2 = awaitGesturePickup.getInitialDown();
                    if (initialDown2 != null) {
                        m496moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, awaitGesturePickup.m501getPointerIdJ3iCeTQ(), m4531minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass, DragDetectionState.Dragging dragging) {
        IndirectPointerInputChange indirectPointerInputChange;
        IndirectPointerInputChange indirectPointerInputChange2;
        boolean changedToUpIgnoreConsumed;
        long m514positionChangeIgnoreConsumed_bfSUIo;
        long m513positionChange_bfSUIo;
        boolean changedToUpIgnoreConsumed2;
        if (pointerEventPass != PointerEventPass.Main) {
            return;
        }
        long m505getPointerIdJ3iCeTQ = dragging.m505getPointerIdJ3iCeTQ();
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            indirectPointerInputChange = null;
            if (i2 >= size) {
                indirectPointerInputChange2 = null;
                break;
            }
            indirectPointerInputChange2 = changes.get(i2);
            if (PointerId.m6067equalsimpl0(indirectPointerInputChange2.m5612getIdJ3iCeTQ(), m505getPointerIdJ3iCeTQ)) {
                break;
            }
            i2++;
        }
        IndirectPointerInputChange indirectPointerInputChange3 = indirectPointerInputChange2;
        if (indirectPointerInputChange3 == null) {
            return;
        }
        changedToUpIgnoreConsumed = IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange3);
        if (changedToUpIgnoreConsumed) {
            List<IndirectPointerInputChange> changes2 = indirectPointerEvent.getChanges();
            int size2 = changes2.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                IndirectPointerInputChange indirectPointerInputChange4 = changes2.get(i);
                if (indirectPointerInputChange4.getPressed()) {
                    indirectPointerInputChange = indirectPointerInputChange4;
                    break;
                }
                i++;
            }
            IndirectPointerInputChange indirectPointerInputChange5 = indirectPointerInputChange;
            if (indirectPointerInputChange5 == null) {
                if (!indirectPointerInputChange3.isConsumed()) {
                    changedToUpIgnoreConsumed2 = IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange3);
                    if (changedToUpIgnoreConsumed2) {
                        m500sendDragStoppedk92h6UU(indirectPointerInputChange3, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
                        moveToAwaitDownState();
                        return;
                    }
                }
                sendDragCancelled();
                moveToAwaitDownState();
                return;
            }
            dragging.m506setPointerId0FcD4WY(indirectPointerInputChange5.m5612getIdJ3iCeTQ());
        } else if (!indirectPointerInputChange3.isConsumed()) {
            m514positionChangeIgnoreConsumed_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m514positionChangeIgnoreConsumed_bfSUIo(indirectPointerInputChange3, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
            if (Offset.m4525getDistanceimpl(m514positionChangeIgnoreConsumed_bfSUIo) == 0.0f) {
                return;
            }
            m513positionChange_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m513positionChange_bfSUIo(indirectPointerInputChange3, this.node.getOrientationLock(), IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()));
            m498sendDragEventEu1f8Dk(indirectPointerInputChange3, IndirectPointerEventPrimaryDirectionalMotionAxis.m5591boximpl(indirectPointerEvent.mo5587getPrimaryDirectionalMotionAxisnZO2Niw()), m513positionChange_bfSUIo);
            indirectPointerInputChange3.consume();
        } else {
            sendDragCancelled();
        }
    }

    /* renamed from: sendDragStart-3f7A7Is  reason: not valid java name */
    private final void m499sendDragStart3f7A7Is(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerInputChange indirectPointerInputChange2, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        long m517primaryAxisPosition_bfSUIo;
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        this.nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();
        IndirectPointerInputDragCycleDetectorKt.m512addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), indirectPointerInputChange, this.node.getOrientationLock(), indirectPointerEventPrimaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
        m517primaryAxisPosition_bfSUIo = IndirectPointerInputDragCycleDetectorKt.m517primaryAxisPosition_bfSUIo(indirectPointerInputChange2, this.node.getOrientationLock(), indirectPointerEventPrimaryDirectionalMotionAxis);
        long m4531minusMKHz9U = Offset.m4531minusMKHz9U(m517primaryAxisPosition_bfSUIo, j);
        if (this.node.getCanDrag().invoke(PointerType.m6153boximpl(PointerType.Companion.m6163getTouchT8wyACA())).booleanValue()) {
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
            this.node.onDragEvent(new DragEvent.DragStarted(m4531minusMKHz9U, null));
        }
        this.offsetSmoother.reset();
    }

    /* renamed from: sendDragEvent-Eu1f8Dk  reason: not valid java name */
    private final void m498sendDragEventEu1f8Dk(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.node));
        if (!Offset.m4524equalsimpl0(this.previousPositionOnScreen, Offset.Companion.m4542getUnspecifiedF1C5BW0()) && !Offset.m4524equalsimpl0(positionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m4532plusMKHz9U(this.nodeOffset, Offset.m4531minusMKHz9U(positionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = positionOnScreen;
        Orientation orientationLock = this.node.getOrientationLock();
        Intrinsics.checkNotNull(orientationLock);
        if (Math.abs(DraggableKt.m486toFloat3MmeM6k(j, orientationLock)) > 2.0f) {
            IndirectPointerInputDragCycleDetectorKt.m512addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), indirectPointerInputChange, this.node.getOrientationLock(), indirectPointerEventPrimaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
            this.node.onDragEvent(new DragEvent.DragDelta(this.offsetSmoother.m532smoothEventPositionMKHz9U(j), true, null));
        }
    }

    /* renamed from: sendDragStopped-k92h6UU  reason: not valid java name */
    private final void m500sendDragStoppedk92h6UU(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        IndirectPointerInputDragCycleDetectorKt.m512addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), indirectPointerInputChange, this.node.getOrientationLock(), indirectPointerEventPrimaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.node, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long m6191calculateVelocityAH228Gc = requireVelocityTracker().m6191calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        this.node.onDragEvent(new DragEvent.DragStopped(DraggableKt.m488toValidVelocityTH1AsA0(m6191calculateVelocityAH228Gc), true, null));
    }

    private final void sendDragCancelled() {
        this.node.onDragEvent(DragEvent.DragCancelled.INSTANCE);
    }

    /* compiled from: IndirectPointerInputDragCycleDetector.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "", "<init>", "()V", "AwaitDown", "AwaitTouchSlop", "AwaitGesturePickup", "Dragging", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class DragDetectionState {
        public static final int $stable = 0;

        public /* synthetic */ DragDetectionState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DragDetectionState() {
        }

        /* compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "awaitTouchSlop", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "consumedOnInitial", "", "<init>", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;Z)V", "getAwaitTouchSlop", "()Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "setAwaitTouchSlop", "(Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;)V", "getConsumedOnInitial", "()Z", "setConsumedOnInitial", "(Z)V", "AwaitTouchSlop", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class AwaitDown extends DragDetectionState {
            public static final int $stable = 8;
            private AwaitTouchSlop awaitTouchSlop;
            private boolean consumedOnInitial;

            public AwaitDown() {
                this(null, false, 3, null);
            }

            public AwaitDown(AwaitTouchSlop awaitTouchSlop, boolean z) {
                super(null);
                this.awaitTouchSlop = awaitTouchSlop;
                this.consumedOnInitial = z;
            }

            public /* synthetic */ AwaitDown(AwaitTouchSlop awaitTouchSlop, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? AwaitTouchSlop.NotInitialized : awaitTouchSlop, (i & 2) != 0 ? false : z);
            }

            public final AwaitTouchSlop getAwaitTouchSlop() {
                return this.awaitTouchSlop;
            }

            public final void setAwaitTouchSlop(AwaitTouchSlop awaitTouchSlop) {
                this.awaitTouchSlop = awaitTouchSlop;
            }

            public final boolean getConsumedOnInitial() {
                return this.consumedOnInitial;
            }

            public final void setConsumedOnInitial(boolean z) {
                this.consumedOnInitial = z;
            }

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* compiled from: IndirectPointerInputDragCycleDetector.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown$AwaitTouchSlop;", "", "<init>", "(Ljava/lang/String;I)V", "Yes", "No", "NotInitialized", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
            /* loaded from: classes.dex */
            public static final class AwaitTouchSlop {
                private static final /* synthetic */ EnumEntries $ENTRIES;
                private static final /* synthetic */ AwaitTouchSlop[] $VALUES;
                public static final AwaitTouchSlop Yes = new AwaitTouchSlop("Yes", 0);
                public static final AwaitTouchSlop No = new AwaitTouchSlop("No", 1);
                public static final AwaitTouchSlop NotInitialized = new AwaitTouchSlop("NotInitialized", 2);

                private static final /* synthetic */ AwaitTouchSlop[] $values() {
                    return new AwaitTouchSlop[]{Yes, No, NotInitialized};
                }

                public static EnumEntries<AwaitTouchSlop> getEntries() {
                    return $ENTRIES;
                }

                public static AwaitTouchSlop valueOf(String str) {
                    return (AwaitTouchSlop) Enum.valueOf(AwaitTouchSlop.class, str);
                }

                public static AwaitTouchSlop[] values() {
                    return (AwaitTouchSlop[]) $VALUES.clone();
                }

                private AwaitTouchSlop(String str, int i) {
                }

                static {
                    AwaitTouchSlop[] $values = $values();
                    $VALUES = $values;
                    $ENTRIES = EnumEntriesKt.enumEntries($values);
                }
            }
        }

        /* compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "verifyConsumptionInFinalPass", "", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getVerifyConsumptionInFinalPass", "()Z", "setVerifyConsumptionInFinalPass", "(Z)V", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class AwaitTouchSlop extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private boolean verifyConsumptionInFinalPass;

            public /* synthetic */ AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
                this(indirectPointerInputChange, j, z);
            }

            private AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z) {
                super(null);
                this.initialDown = indirectPointerInputChange;
                this.pointerId = j;
                this.verifyConsumptionInFinalPass = z;
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final void setInitialDown(IndirectPointerInputChange indirectPointerInputChange) {
                this.initialDown = indirectPointerInputChange;
            }

            public /* synthetic */ AwaitTouchSlop(IndirectPointerInputChange indirectPointerInputChange, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : indirectPointerInputChange, (i & 2) != 0 ? PointerId.m6065constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? false : z, null);
            }

            /* renamed from: getPointerId-J3iCeTQ  reason: not valid java name */
            public final long m503getPointerIdJ3iCeTQ() {
                return this.pointerId;
            }

            /* renamed from: setPointerId-0FcD4WY  reason: not valid java name */
            public final void m504setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }

            public final boolean getVerifyConsumptionInFinalPass() {
                return this.verifyConsumptionInFinalPass;
            }

            public final void setVerifyConsumptionInFinalPass(boolean z) {
                this.verifyConsumptionInFinalPass = z;
            }
        }

        /* compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "initialDown", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "<init>", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialDown", "()Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "setInitialDown", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "getTouchSlopDetector", "()Landroidx/compose/foundation/gestures/TouchSlopDetector;", "setTouchSlopDetector", "(Landroidx/compose/foundation/gestures/TouchSlopDetector;)V", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class AwaitGesturePickup extends DragDetectionState {
            public static final int $stable = 8;
            private IndirectPointerInputChange initialDown;
            private long pointerId;
            private TouchSlopDetector touchSlopDetector;

            public /* synthetic */ AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector, DefaultConstructorMarker defaultConstructorMarker) {
                this(indirectPointerInputChange, j, touchSlopDetector);
            }

            private AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector) {
                super(null);
                this.initialDown = indirectPointerInputChange;
                this.pointerId = j;
                this.touchSlopDetector = touchSlopDetector;
            }

            public final IndirectPointerInputChange getInitialDown() {
                return this.initialDown;
            }

            public final void setInitialDown(IndirectPointerInputChange indirectPointerInputChange) {
                this.initialDown = indirectPointerInputChange;
            }

            public /* synthetic */ AwaitGesturePickup(IndirectPointerInputChange indirectPointerInputChange, long j, TouchSlopDetector touchSlopDetector, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : indirectPointerInputChange, (i & 2) != 0 ? PointerId.m6065constructorimpl(Long.MAX_VALUE) : j, (i & 4) != 0 ? null : touchSlopDetector, null);
            }

            /* renamed from: getPointerId-J3iCeTQ  reason: not valid java name */
            public final long m501getPointerIdJ3iCeTQ() {
                return this.pointerId;
            }

            /* renamed from: setPointerId-0FcD4WY  reason: not valid java name */
            public final void m502setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }

            public final TouchSlopDetector getTouchSlopDetector() {
                return this.touchSlopDetector;
            }

            public final void setTouchSlopDetector(TouchSlopDetector touchSlopDetector) {
                this.touchSlopDetector = touchSlopDetector;
            }
        }

        /* compiled from: IndirectPointerInputDragCycleDetector.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging;", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector$DragDetectionState;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPointerId-J3iCeTQ", "()J", "setPointerId-0FcD4WY", "(J)V", "J", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Dragging extends DragDetectionState {
            public static final int $stable = 8;
            private long pointerId;

            public /* synthetic */ Dragging(long j, DefaultConstructorMarker defaultConstructorMarker) {
                this(j);
            }

            private Dragging(long j) {
                super(null);
                this.pointerId = j;
            }

            public /* synthetic */ Dragging(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? PointerId.m6065constructorimpl(Long.MAX_VALUE) : j, null);
            }

            /* renamed from: getPointerId-J3iCeTQ  reason: not valid java name */
            public final long m505getPointerIdJ3iCeTQ() {
                return this.pointerId;
            }

            /* renamed from: setPointerId-0FcD4WY  reason: not valid java name */
            public final void m506setPointerId0FcD4WY(long j) {
                this.pointerId = j;
            }
        }
    }
}
