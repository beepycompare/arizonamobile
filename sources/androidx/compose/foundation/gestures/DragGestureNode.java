package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.DragDetectionState;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.app.NotificationCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010H\u001a\u00020I2=\u0010J\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110L¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020I0\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0P\u0012\u0006\u0012\u0004\u0018\u00010Q0KH¦@¢\u0006\u0002\u0010RJ\u0017\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020AH&¢\u0006\u0004\bU\u0010VJ\u0010\u0010W\u001a\u00020I2\u0006\u0010X\u001a\u00020YH&J\b\u0010Z\u001a\u00020\bH&J\b\u0010[\u001a\u00020?H\u0002J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010]\u001a\u00020DH\u0002J\b\u0010^\u001a\u00020IH\u0002J\b\u0010a\u001a\u00020IH\u0016J'\u0010b\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0016¢\u0006\u0004\bi\u0010jJ\u0018\u0010k\u001a\u00020I2\u0006\u0010X\u001a\u00020l2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010m\u001a\u00020IH\u0016J\b\u0010n\u001a\u00020`H\u0002J\b\u0010o\u001a\u00020IH\u0016J\u0016\u0010p\u001a\u00020I2\u0006\u0010X\u001a\u00020qH\u0082@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020I2\u0006\u0010X\u001a\u00020YH\u0082@¢\u0006\u0002\u0010tJ\u000e\u0010u\u001a\u00020IH\u0082@¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020IJH\u0010x\u001a\u00020I2\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010y\u001a\u00020\bJ\u0018\u0010z\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010{\u001a\u00020IH\u0002J8\u0010|\u001a\u00020I2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\t\b\u0002\u0010\u0081\u0001\u001a\u00020A2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0085\u0001\u001a\u00020I2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002¢\u0006\u0005\b\u0086\u0001\u0010VJ\t\u0010\u0087\u0001\u001a\u00020IH\u0002J+\u0010\u0088\u0001\u001a\u00020I2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\"\u0010\u008b\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u00020)H\u0002J\"\u0010\u008d\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u000203H\u0002J\"\u0010\u008e\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u000208H\u0002J\"\u0010\u008f\u0001\u001a\u00020I2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0007\u0010\u008c\u0001\u001a\u00020.H\u0002J-\u0010\u0090\u0001\u001a\u00020I2\u0007\u0010\u0091\u0001\u001a\u00020~2\u0007\u0010\u0092\u0001\u001a\u00020~2\u0007\u0010\u0093\u0001\u001a\u00020AH\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J$\u0010\u0096\u0001\u001a\u00020I2\u0007\u0010\u0097\u0001\u001a\u00020~2\u0007\u0010\u0098\u0001\u001a\u00020AH\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0012\u0010\u009b\u0001\u001a\u00020I2\u0007\u0010\u0097\u0001\u001a\u00020~H\u0002J\t\u0010\u009c\u0001\u001a\u00020IH\u0002J\u000f\u0010\u009d\u0001\u001a\u00020I2\u0006\u0010X\u001a\u00020\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010$R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientationLock", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientationLock", "(Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "isListeningForEvents$foundation", "setListeningForEvents$foundation", "(Z)V", "isListeningForPointerInputEvents", "isListeningForPointerInputEvents$foundation", "setListeningForPointerInputEvents$foundation", "_awaitDownState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "awaitDownState", "getAwaitDownState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitDown;", "_draggingState", "Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "draggingState", "getDraggingState", "()Landroidx/compose/foundation/gestures/DragDetectionState$Dragging;", "_awaitTouchSlopState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "awaitTouchSlopState", "getAwaitTouchSlopState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitTouchSlop;", "_awaitGesturePickupState", "Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "awaitGesturePickupState", "getAwaitGesturePickupState", "()Landroidx/compose/foundation/gestures/DragDetectionState$AwaitGesturePickup;", "currentDragState", "Landroidx/compose/foundation/gestures/DragDetectionState;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "previousPositionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "J", "touchSlopDetector", "Landroidx/compose/foundation/gestures/TouchSlopDetector;", "indirectPointerInputDragCycleDetector", "Landroidx/compose/foundation/gestures/IndirectPointerInputDragCycleDetector;", "nodeOffset", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "requireVelocityTracker", "requireChannel", "requireTouchSlopDetector", "startListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "onCancelIndirectPointerInput", "initializePointerInputNode", "onCancelPointerInput", "processDragStart", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", "update", "shouldResetPointerInputHandling", "processRawPointerEvent", "resetDragDetectionState", "moveToAwaitTouchSlopState", "initialDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "initialTouchSlopPositionChange", "verifyConsumptionInFinalPass", "moveToAwaitTouchSlopState-aWI9W7U", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJZ)V", "moveToDraggingState", "moveToDraggingState-0FcD4WY", "moveToAwaitDownState", "moveToAwaitGesturePickupState", "moveToAwaitGesturePickupState-rnUCldI", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/foundation/gestures/TouchSlopDetector;)V", "processInitialDownState", RemoteConfigConstants.ResponseFieldKey.STATE, "processAwaitTouchSlop", "processAwaitGesturePickup", "processDraggingState", "sendDragStart", "down", "slopTriggerChange", "overSlopOffset", "sendDragStart-0AR0LA0", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragEvent", "change", "dragAmount", "sendDragEvent-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "sendDragStopped", "sendDragCancelled", "onDragEvent", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private DragDetectionState.AwaitDown _awaitDownState;
    private DragDetectionState.AwaitGesturePickup _awaitGesturePickupState;
    private DragDetectionState.AwaitTouchSlop _awaitTouchSlopState;
    private DragDetectionState.Dragging _draggingState;
    private Function1<? super PointerType, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragDetectionState currentDragState;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private boolean isListeningForPointerInputEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private TouchSlopDetector touchSlopDetector;
    private VelocityTracker velocityTracker;
    private final Function1<PointerType, Boolean> _canDrag = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            boolean booleanValue;
            booleanValue = DragGestureNode.this.canDrag.invoke((PointerType) obj).booleanValue();
            return Boolean.valueOf(booleanValue);
        }
    };
    private long previousPositionOnScreen = Offset.Companion.m4542getUnspecifiedF1C5BW0();
    private long nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();

    /* compiled from: Draggable.kt */
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

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo423onDragStartedk4lQ0M(long j);

    public abstract void onDragStopped(DragEvent.DragStopped dragStopped);

    public abstract boolean startDragImmediately();

    public DragGestureNode(Function1<? super PointerType, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
    }

    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    public final void setOrientationLock(Orientation orientation) {
        this.orientationLock = orientation;
    }

    public final Function1<PointerType, Boolean> getCanDrag() {
        return this.canDrag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final boolean isListeningForEvents$foundation() {
        return this.isListeningForEvents;
    }

    public final void setListeningForEvents$foundation(boolean z) {
        this.isListeningForEvents = z;
    }

    public final boolean isListeningForPointerInputEvents$foundation() {
        return this.isListeningForPointerInputEvents;
    }

    public final void setListeningForPointerInputEvents$foundation(boolean z) {
        this.isListeningForPointerInputEvents = z;
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

    private final VelocityTracker requireVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            return velocityTracker;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.".toString());
    }

    private final Channel<DragEvent> requireChannel() {
        Channel<DragEvent> channel = this.channel;
        if (channel != null) {
            return channel;
        }
        throw new IllegalArgumentException("Events channel not initialized.".toString());
    }

    private final TouchSlopDetector requireTouchSlopDetector() {
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector != null) {
            return touchSlopDetector;
        }
        throw new IllegalArgumentException("Touch slop detector not initialized.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        if (this.channel == null) {
            this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new DragGestureNode$startListeningForEvents$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
        this.nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo233onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.isListeningForPointerInputEvents = true;
        boolean z = ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled;
        boolean z2 = this.enabled;
        if (z) {
            if (z2) {
                if (this.currentDragState == null) {
                    this.currentDragState = getAwaitDownState();
                }
                processRawPointerEvent(pointerEvent, pointerEventPass);
                return;
            }
            return;
        }
        if (z2 && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo233onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass) {
        if (this.enabled) {
            if (this.indirectPointerInputDragCycleDetector == null) {
                this.indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.processIndirectPointerInputEvent(indirectPointerEvent, pointerEventPass);
            }
        }
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.resetDragDetectionState();
        }
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DragGestureNode$initializePointerInputNode$1(this));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
        if (ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled && this.isListeningForPointerInputEvents) {
            resetDragDetectionState();
        }
        this.isListeningForPointerInputEvents = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        if (r2.emit(new androidx.compose.foundation.interaction.DragInteraction.Cancel(r8), r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStart(DragEvent.DragStarted dragStarted, Continuation<? super Unit> continuation) {
        DragGestureNode$processDragStart$1 dragGestureNode$processDragStart$1;
        int i;
        DragInteraction.Start start;
        MutableInteractionSource mutableInteractionSource;
        DragEvent.DragStarted dragStarted2;
        DragInteraction.Start start2;
        if (continuation instanceof DragGestureNode$processDragStart$1) {
            dragGestureNode$processDragStart$1 = (DragGestureNode$processDragStart$1) continuation;
            if ((dragGestureNode$processDragStart$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStart$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragStart$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureNode$processDragStart$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction.Start start3 = this.dragInteraction;
                    if (start3 != null && (r2 = this.interactionSource) != null) {
                        dragGestureNode$processDragStart$1.L$0 = dragStarted;
                        dragGestureNode$processDragStart$1.label = 1;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        start2 = (DragInteraction.Start) dragGestureNode$processDragStart$1.L$1;
                        dragStarted2 = (DragEvent.DragStarted) dragGestureNode$processDragStart$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        start = start2;
                        dragStarted = dragStarted2;
                        this.dragInteraction = start;
                        mo423onDragStartedk4lQ0M(dragStarted.m455getStartPointF1C5BW0());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    dragStarted = (DragEvent.DragStarted) dragGestureNode$processDragStart$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                start = new DragInteraction.Start();
                mutableInteractionSource = this.interactionSource;
                if (mutableInteractionSource != null) {
                    dragGestureNode$processDragStart$1.L$0 = dragStarted;
                    dragGestureNode$processDragStart$1.L$1 = start;
                    dragGestureNode$processDragStart$1.label = 2;
                    if (mutableInteractionSource.emit(start, dragGestureNode$processDragStart$1) != coroutine_suspended) {
                        dragStarted2 = dragStarted;
                        start2 = start;
                        start = start2;
                        dragStarted = dragStarted2;
                    }
                    return coroutine_suspended;
                }
                this.dragInteraction = start;
                mo423onDragStartedk4lQ0M(dragStarted.m455getStartPointF1C5BW0());
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(this, continuation);
        Object obj2 = dragGestureNode$processDragStart$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureNode$processDragStart$1.label;
        if (i != 0) {
        }
        start = new DragInteraction.Start();
        mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
        }
        this.dragInteraction = start;
        mo423onDragStartedk4lQ0M(dragStarted.m455getStartPointF1C5BW0());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStop(DragEvent.DragStopped dragStopped, Continuation<? super Unit> continuation) {
        DragGestureNode$processDragStop$1 dragGestureNode$processDragStop$1;
        int i;
        if (continuation instanceof DragGestureNode$processDragStop$1) {
            dragGestureNode$processDragStop$1 = (DragGestureNode$processDragStop$1) continuation;
            if ((dragGestureNode$processDragStop$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStop$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragStop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureNode$processDragStop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction.Start start = this.dragInteraction;
                    if (start != null) {
                        MutableInteractionSource mutableInteractionSource = this.interactionSource;
                        if (mutableInteractionSource != null) {
                            dragGestureNode$processDragStop$1.L$0 = dragStopped;
                            dragGestureNode$processDragStop$1.label = 1;
                            if (mutableInteractionSource.emit(new DragInteraction.Stop(start), dragGestureNode$processDragStop$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    onDragStopped(dragStopped);
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    dragStopped = (DragEvent.DragStopped) dragGestureNode$processDragStop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.dragInteraction = null;
                onDragStopped(dragStopped);
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(this, continuation);
        Object obj2 = dragGestureNode$processDragStop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureNode$processDragStop$1.label;
        if (i != 0) {
        }
        this.dragInteraction = null;
        onDragStopped(dragStopped);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragCancel(Continuation<? super Unit> continuation) {
        DragGestureNode$processDragCancel$1 dragGestureNode$processDragCancel$1;
        int i;
        if (continuation instanceof DragGestureNode$processDragCancel$1) {
            dragGestureNode$processDragCancel$1 = (DragGestureNode$processDragCancel$1) continuation;
            if ((dragGestureNode$processDragCancel$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragCancel$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragCancel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureNode$processDragCancel$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction.Start start = this.dragInteraction;
                    if (start != null) {
                        MutableInteractionSource mutableInteractionSource = this.interactionSource;
                        if (mutableInteractionSource != null) {
                            dragGestureNode$processDragCancel$1.label = 1;
                            if (mutableInteractionSource.emit(new DragInteraction.Cancel(start), dragGestureNode$processDragCancel$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    onDragStopped(new DragEvent.DragStopped(Velocity.Companion.m7804getZero9UxMQ8M(), false, null));
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                this.dragInteraction = null;
                onDragStopped(new DragEvent.DragStopped(Velocity.Companion.m7804getZero9UxMQ8M(), false, null));
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(this, continuation);
        Object obj2 = dragGestureNode$processDragCancel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureNode$processDragCancel$1.label;
        if (i != 0) {
        }
        this.dragInteraction = null;
        onDragStopped(new DragEvent.DragStopped(Velocity.Companion.m7804getZero9UxMQ8M(), false, null));
        return Unit.INSTANCE;
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        Function1<? super PointerType, Boolean> function12 = function1;
        if ((i & 1) != 0) {
            function12 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function1 function13 = function12;
        dragGestureNode.update(function13, z, mutableInteractionSource2, orientation, z3);
    }

    public final void update(Function1<? super PointerType, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2) {
        this.canDrag = function1;
        boolean z3 = true;
        if (this.enabled != z) {
            this.enabled = z;
            if (!z) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
                if (suspendingPointerInputModifierNode != null) {
                    undelegate(suspendingPointerInputModifierNode);
                }
                this.pointerInputNode = null;
                this.indirectPointerInputDragCycleDetector = null;
            }
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, mutableInteractionSource)) {
            disposeInteractionSource();
            this.interactionSource = mutableInteractionSource;
        }
        if (this.orientationLock != orientation) {
            this.orientationLock = orientation;
        } else {
            z3 = z2;
        }
        if (z3) {
            if (ComposeFoundationFlags.isNonSuspendingPointerInputInDraggableEnabled && this.isListeningForPointerInputEvents) {
                resetDragDetectionState();
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.resetDragDetectionState();
            }
            SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.pointerInputNode;
            if (suspendingPointerInputModifierNode2 != null) {
                suspendingPointerInputModifierNode2.resetPointerInputHandler();
            }
        }
    }

    private final void processRawPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        DragDetectionState dragDetectionState = this.currentDragState;
        if (dragDetectionState == null) {
            throw new IllegalArgumentException("currentDragState should not be null".toString());
        }
        if (dragDetectionState instanceof DragDetectionState.AwaitDown) {
            processInitialDownState(pointerEvent, pointerEventPass, (DragDetectionState.AwaitDown) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitTouchSlop) {
            processAwaitTouchSlop(pointerEvent, pointerEventPass, (DragDetectionState.AwaitTouchSlop) dragDetectionState);
        } else if (dragDetectionState instanceof DragDetectionState.AwaitGesturePickup) {
            processAwaitGesturePickup(pointerEvent, pointerEventPass, (DragDetectionState.AwaitGesturePickup) dragDetectionState);
        } else if (!(dragDetectionState instanceof DragDetectionState.Dragging)) {
            throw new NoWhenBranchMatchedException();
        } else {
            processDraggingState(pointerEvent, pointerEventPass, (DragDetectionState.Dragging) dragDetectionState);
        }
    }

    private final void resetDragDetectionState() {
        moveToAwaitDownState();
        if (this.isListeningForEvents) {
            sendDragCancelled();
        }
        this.velocityTracker = null;
    }

    /* renamed from: moveToAwaitTouchSlopState-aWI9W7U$default  reason: not valid java name */
    static /* synthetic */ void m480moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToAwaitTouchSlopState-aWI9W7U");
        }
        if ((i & 4) != 0) {
            j2 = Offset.Companion.m4543getZeroF1C5BW0();
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            z = false;
        }
        dragGestureNode.m479moveToAwaitTouchSlopStateaWI9W7U(pointerInputChange, j, j3, z);
    }

    /* renamed from: moveToAwaitTouchSlopState-aWI9W7U  reason: not valid java name */
    private final void m479moveToAwaitTouchSlopStateaWI9W7U(PointerInputChange pointerInputChange, long j, long j2, boolean z) {
        DragDetectionState.AwaitTouchSlop awaitTouchSlopState = getAwaitTouchSlopState();
        awaitTouchSlopState.setInitialDown(pointerInputChange);
        awaitTouchSlopState.m451setPointerId0FcD4WY(j);
        TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
        if (touchSlopDetector == null) {
            this.touchSlopDetector = new TouchSlopDetector(this.orientationLock, 0L, 2, null);
        } else {
            if (touchSlopDetector != null) {
                touchSlopDetector.setOrientation(this.orientationLock);
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
    private final void m481moveToDraggingState0FcD4WY(long j) {
        DragDetectionState.Dragging draggingState = getDraggingState();
        draggingState.m453setPointerId0FcD4WY(j);
        this.currentDragState = draggingState;
    }

    private final void moveToAwaitDownState() {
        DragDetectionState.AwaitDown awaitDownState = getAwaitDownState();
        awaitDownState.setAwaitTouchSlop(DragDetectionState.AwaitDown.AwaitTouchSlop.NotInitialized);
        awaitDownState.setConsumedOnInitial(false);
        this.currentDragState = awaitDownState;
    }

    /* renamed from: moveToAwaitGesturePickupState-rnUCldI  reason: not valid java name */
    private final void m478moveToAwaitGesturePickupStaternUCldI(PointerInputChange pointerInputChange, long j, TouchSlopDetector touchSlopDetector) {
        DragDetectionState.AwaitGesturePickup awaitGesturePickupState = getAwaitGesturePickupState();
        awaitGesturePickupState.setInitialDown(pointerInputChange);
        awaitGesturePickupState.m449setPointerId0FcD4WY(j);
        TouchSlopDetector.m603resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
        awaitGesturePickupState.setTouchSlopDetector(touchSlopDetector);
        this.currentDragState = awaitGesturePickupState;
    }

    private final void processInitialDownState(PointerEvent pointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitDown awaitDown) {
        DragDetectionState.AwaitDown.AwaitTouchSlop awaitTouchSlop;
        if (!pointerEvent.getChanges().isEmpty() && TapGestureDetectorKt.isChangedToDown$default(pointerEvent, false, false, 2, null)) {
            PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List<? extends Object>) pointerEvent.getChanges());
            if (WhenMappings.$EnumSwitchMapping$0[awaitDown.getAwaitTouchSlop().ordinal()] == 1) {
                if (!startDragImmediately()) {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.Yes;
                } else {
                    awaitTouchSlop = DragDetectionState.AwaitDown.AwaitTouchSlop.No;
                }
            } else {
                awaitTouchSlop = awaitDown.getAwaitTouchSlop();
            }
            awaitDown.setAwaitTouchSlop(awaitTouchSlop);
            if (pointerEventPass == PointerEventPass.Initial && awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.No) {
                pointerInputChange.consume();
                awaitDown.setConsumedOnInitial(true);
            }
            if (pointerEventPass == PointerEventPass.Main) {
                if (awaitTouchSlop == DragDetectionState.AwaitDown.AwaitTouchSlop.Yes) {
                    m480moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.m6083getIdJ3iCeTQ(), 0L, false, 12, null);
                } else if (awaitDown.getConsumedOnInitial()) {
                    m483sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, Offset.Companion.m4543getZeroF1C5BW0());
                    m482sendDragEventUv8p0NA(pointerInputChange, Offset.Companion.m4543getZeroF1C5BW0());
                    m481moveToDraggingState0FcD4WY(pointerInputChange.m6083getIdJ3iCeTQ());
                }
            }
        }
    }

    private final void processAwaitTouchSlop(PointerEvent pointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitTouchSlop awaitTouchSlop) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (pointerEventPass == PointerEventPass.Initial) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            pointerInputChange = null;
            if (i >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i);
            if (PointerId.m6067equalsimpl0(pointerInputChange2.m6083getIdJ3iCeTQ(), awaitTouchSlop.m450getPointerIdJ3iCeTQ())) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange2;
        if (pointerInputChange4 == null) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    pointerInputChange3 = null;
                    break;
                }
                pointerInputChange3 = changes2.get(i2);
                if (pointerInputChange3.getPressed()) {
                    break;
                }
                i2++;
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 == null) {
                moveToAwaitDownState();
                return;
            }
            awaitTouchSlop.m451setPointerId0FcD4WY(pointerInputChange4.m6083getIdJ3iCeTQ());
        }
        if (pointerEventPass == PointerEventPass.Main) {
            if (!pointerInputChange4.isConsumed()) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            break;
                        }
                        PointerInputChange pointerInputChange5 = changes3.get(i3);
                        if (pointerInputChange5.getPressed()) {
                            pointerInputChange = pointerInputChange5;
                            break;
                        }
                        i3++;
                    }
                    PointerInputChange pointerInputChange6 = pointerInputChange;
                    if (pointerInputChange6 == null) {
                        moveToAwaitDownState();
                    } else {
                        awaitTouchSlop.m451setPointerId0FcD4WY(pointerInputChange6.m6083getIdJ3iCeTQ());
                    }
                } else {
                    long m604addPositionsakrDWew = requireTouchSlopDetector().m604addPositionsakrDWew(pointerInputChange4.m6085getPositionF1C5BW0(), pointerInputChange4.m6086getPreviousPositionF1C5BW0(), DragGestureDetectorKt.m476pointerSlopE8SPZFQ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration()), pointerInputChange4.m6088getTypeT8wyACA()));
                    if ((9223372034707292159L & m604addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                        pointerInputChange4.consume();
                        PointerInputChange initialDown = awaitTouchSlop.getInitialDown();
                        Intrinsics.checkNotNull(initialDown);
                        m483sendDragStart0AR0LA0(initialDown, pointerInputChange4, m604addPositionsakrDWew);
                        m482sendDragEventUv8p0NA(pointerInputChange4, m604addPositionsakrDWew);
                        m481moveToDraggingState0FcD4WY(pointerInputChange4.m6083getIdJ3iCeTQ());
                    } else {
                        awaitTouchSlop.setVerifyConsumptionInFinalPass(true);
                    }
                }
            } else {
                PointerInputChange initialDown2 = awaitTouchSlop.getInitialDown();
                if (initialDown2 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long m450getPointerIdJ3iCeTQ = awaitTouchSlop.m450getPointerIdJ3iCeTQ();
                TouchSlopDetector touchSlopDetector = this.touchSlopDetector;
                if (touchSlopDetector != null) {
                    m478moveToAwaitGesturePickupStaternUCldI(initialDown2, m450getPointerIdJ3iCeTQ, touchSlopDetector);
                } else {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
                }
            }
        }
        if (pointerEventPass == PointerEventPass.Final && awaitTouchSlop.getVerifyConsumptionInFinalPass()) {
            if (pointerInputChange4.isConsumed()) {
                PointerInputChange initialDown3 = awaitTouchSlop.getInitialDown();
                if (initialDown3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized".toString());
                }
                long m450getPointerIdJ3iCeTQ2 = awaitTouchSlop.m450getPointerIdJ3iCeTQ();
                TouchSlopDetector touchSlopDetector2 = this.touchSlopDetector;
                if (touchSlopDetector2 != null) {
                    m478moveToAwaitGesturePickupStaternUCldI(initialDown3, m450getPointerIdJ3iCeTQ2, touchSlopDetector2);
                    return;
                }
                throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized".toString());
            }
            awaitTouchSlop.setVerifyConsumptionInFinalPass(false);
        }
    }

    private final void processAwaitGesturePickup(PointerEvent pointerEvent, PointerEventPass pointerEventPass, DragDetectionState.AwaitGesturePickup awaitGesturePickup) {
        boolean z;
        if (pointerEventPass != PointerEventPass.Final) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
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
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        while (true) {
            if (i >= size2) {
                break;
            } else if (!changes2.get(i).getPressed()) {
                i++;
            } else if (!pointerEvent.getChanges().isEmpty()) {
                if (z) {
                    long m6085getPositionF1C5BW0 = ((PointerInputChange) CollectionsKt.first((List<? extends Object>) pointerEvent.getChanges())).m6085getPositionF1C5BW0();
                    PointerInputChange initialDown = awaitGesturePickup.getInitialDown();
                    Intrinsics.checkNotNull(initialDown);
                    long m4531minusMKHz9U = Offset.m4531minusMKHz9U(m6085getPositionF1C5BW0, initialDown.m6085getPositionF1C5BW0());
                    PointerInputChange initialDown2 = awaitGesturePickup.getInitialDown();
                    if (initialDown2 != null) {
                        m480moveToAwaitTouchSlopStateaWI9W7U$default(this, initialDown2, awaitGesturePickup.m448getPointerIdJ3iCeTQ(), m4531minusMKHz9U, false, 8, null);
                        return;
                    }
                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.".toString());
                }
                return;
            }
        }
        moveToAwaitDownState();
    }

    private final void processDraggingState(PointerEvent pointerEvent, PointerEventPass pointerEventPass, DragDetectionState.Dragging dragging) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (pointerEventPass != PointerEventPass.Main) {
            return;
        }
        long m452getPointerIdJ3iCeTQ = dragging.m452getPointerIdJ3iCeTQ();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            pointerInputChange = null;
            if (i2 >= size) {
                pointerInputChange2 = null;
                break;
            }
            pointerInputChange2 = changes.get(i2);
            if (PointerId.m6067equalsimpl0(pointerInputChange2.m6083getIdJ3iCeTQ(), m452getPointerIdJ3iCeTQ)) {
                break;
            }
            i2++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange2;
        if (pointerInputChange3 == null) {
            return;
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                PointerInputChange pointerInputChange4 = changes2.get(i);
                if (pointerInputChange4.getPressed()) {
                    pointerInputChange = pointerInputChange4;
                    break;
                }
                i++;
            }
            PointerInputChange pointerInputChange5 = pointerInputChange;
            if (pointerInputChange5 == null) {
                if (!pointerInputChange3.isConsumed() && PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    sendDragStopped(pointerInputChange3);
                } else {
                    sendDragCancelled();
                }
                moveToAwaitDownState();
                return;
            }
            dragging.m453setPointerId0FcD4WY(pointerInputChange5.m6083getIdJ3iCeTQ());
        } else if (pointerInputChange3.isConsumed()) {
            sendDragCancelled();
        } else if (Offset.m4525getDistanceimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3)) == 0.0f) {
        } else {
            m482sendDragEventUv8p0NA(pointerInputChange3, PointerEventKt.positionChange(pointerInputChange3));
            pointerInputChange3.consume();
        }
    }

    /* renamed from: sendDragStart-0AR0LA0  reason: not valid java name */
    private final void m483sendDragStart0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new VelocityTracker();
        }
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), pointerInputChange);
        long m4531minusMKHz9U = Offset.m4531minusMKHz9U(pointerInputChange2.m6085getPositionF1C5BW0(), j);
        this.nodeOffset = Offset.Companion.m4543getZeroF1C5BW0();
        if (this.canDrag.invoke(PointerType.m6153boximpl(pointerInputChange.m6088getTypeT8wyACA())).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                }
                startListeningForEvents();
            }
            this.previousPositionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this));
            requireChannel().mo8396trySendJP2dKIU(new DragEvent.DragStarted(m4531minusMKHz9U, null));
        }
    }

    /* renamed from: sendDragEvent-Uv8p0NA  reason: not valid java name */
    private final void m482sendDragEventUv8p0NA(PointerInputChange pointerInputChange, long j) {
        long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(getNode()));
        if (!Offset.m4524equalsimpl0(this.previousPositionOnScreen, Offset.Companion.m4542getUnspecifiedF1C5BW0()) && !Offset.m4524equalsimpl0(positionOnScreen, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m4532plusMKHz9U(this.nodeOffset, Offset.m4531minusMKHz9U(positionOnScreen, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = positionOnScreen;
        VelocityTrackerKt.m6192addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange, this.nodeOffset);
        requireChannel().mo8396trySendJP2dKIU(new DragEvent.DragDelta(j, false, null));
    }

    private final void sendDragStopped(PointerInputChange pointerInputChange) {
        VelocityTrackerKt.addPointerInputChange(requireVelocityTracker(), pointerInputChange);
        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
        long m6191calculateVelocityAH228Gc = requireVelocityTracker().m6191calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        requireVelocityTracker().resetTracking();
        requireChannel().mo8396trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m488toValidVelocityTH1AsA0(m6191calculateVelocityAH228Gc), false, null));
        this.isListeningForPointerInputEvents = false;
    }

    private final void sendDragCancelled() {
        requireChannel().mo8396trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
    }

    public final void onDragEvent(DragEvent dragEvent) {
        if ((dragEvent instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo8396trySendJP2dKIU(dragEvent);
    }
}
