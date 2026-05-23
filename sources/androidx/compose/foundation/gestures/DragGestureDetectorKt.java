package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001aV\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0080\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aè\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2M\b\u0002\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\"2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010'\u001a\u008e\u0001\u0010(\u001a\u00020\f*\u00020\u00022\u0006\u0010)\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\u001e\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\"2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0080@¢\u0006\u0002\u0010*\u001a\u0080\u0001\u0010+\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b.\u0010\u000e\u001a^\u0010/\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b3\u00104\u001a0\u00105\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b6\u0010\u0014\u001a\u001e\u00107\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b8\u0010\u0017\u001a\u0080\u0001\u00109\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010:\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010;\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b<\u0010\u000e\u001a^\u0010=\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020126\u00102\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b>\u00104\u001a0\u0010?\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b@\u0010\u0014\u001a\u001e\u0010A\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bB\u0010\u0017\u001a\u0080\u0001\u0010C\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010D\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00122\b\u0010E\u001a\u0004\u0018\u00010!2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0080H¢\u0006\u0004\bG\u0010H\u001a2\u0010I\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0082H¢\u0006\u0004\bK\u0010\u0014\u001aT\u0010L\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010M\u001a\u00020\n2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006H\u0080H¢\u0006\u0004\bN\u0010O\u001a$\u0010P\u001a\u00020\u0010*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\b\b\u0002\u0010Q\u001a\u00020RH\u0080@¢\u0006\u0002\u0010S\u001a\u001e\u0010T\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bU\u0010\u0017\u001a\u001b\u0010V\u001a\u00020\u0010*\u00020W2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\bX\u0010Y\u001a\u001b\u0010_\u001a\u00020-*\u00020`2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0004\ba\u0010b\"\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\\"\u0010\u0010]\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\\"\u000e\u0010^\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020dX\u0082T¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"awaitTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "Landroidx/compose/ui/geometry/Offset;", "overSlop", "", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "", "onDrag", "Lkotlin/Function1;", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragGesture", "initialDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "awaitVerticalTouchSlopOrCancellation", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verticalDrag", "verticalDrag-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "detectVerticalDragGestures", "onVerticalDrag", "awaitHorizontalTouchSlopOrCancellation", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalPointerSlopOrCancellation", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "horizontalDrag", "horizontalDrag-jO51t88", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "detectHorizontalDragGestures", "onHorizontalDrag", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "awaitDragOrUp-jO51t88", "awaitPointerSlopOrCancellation", "initialPositionChange", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllPointersUpWithSlopDetection", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "GestureAngleThreshold", "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final int GestureAngleThreshold = 30;
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean detectDragGestures$lambda$5() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean detectDragGestures$lambda$9() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0160 -> B:20:0x00aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017f -> B:61:0x0184). Please submit an issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m500awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        int i;
        float m509pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        int i3;
        PointerInputChange pointerInputChange3;
        int i4;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
                int i5 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int m6765getTouchT8wyACA = PointerType.Companion.m6765getTouchT8wyACA();
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m6765getTouchT8wyACA);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = j;
                    TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(null, m5119getZeroF1C5BW0, null);
                    function22 = function2;
                    longRef = longRef2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector3;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i5, null);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    float f2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
                    ResultKt.throwOnFailure(obj);
                    f = f2;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
                    function22 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i2 = 0;
                    while (true) {
                        if (i2 < size) {
                        }
                        i2 = i4 + 1;
                    }
                    pointerInputChange2 = pointerInputChange;
                    if (pointerInputChange2 != null) {
                        return null;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    }
                    i5 = i3;
                    touchSlopDetector = touchSlopDetector2;
                    m509pointerSlopE8SPZFQ = f;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i5, null);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 2) {
                    float f3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4;
                    TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
                    Function2<? super PointerInputChange, ? super Offset, Unit> function23 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector4;
                    char c = 2;
                    int i6 = 1;
                    m509pointerSlopE8SPZFQ = f3;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
                    if (pointerInputChange4.isConsumed()) {
                        i5 = i6;
                        function22 = function23;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i5;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i5, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            f = m509pointerSlopE8SPZFQ;
                            touchSlopDetector2 = touchSlopDetector;
                            obj = awaitPointerEvent$default;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            i2 = 0;
                            while (true) {
                                if (i2 < size) {
                                    pointerInputChange = null;
                                    break;
                                }
                                pointerInputChange = changes2.get(i2);
                                i4 = i2;
                                if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)) {
                                    break;
                                }
                                i2 = i4 + 1;
                            }
                            pointerInputChange2 = pointerInputChange;
                            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                                return null;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= size2) {
                                        pointerInputChange3 = null;
                                        break;
                                    }
                                    pointerInputChange3 = changes3.get(i7);
                                    if (pointerInputChange3.getPressed()) {
                                        break;
                                    }
                                    i7++;
                                }
                                PointerInputChange pointerInputChange5 = pointerInputChange3;
                                if (pointerInputChange5 == null) {
                                    return null;
                                }
                                longRef.element = pointerInputChange5.m6682getIdJ3iCeTQ();
                                i3 = 1;
                            } else {
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2), f, false, 4, null);
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function22.invoke(pointerInputChange2, Offset.m5092boximpl(m635getPostSlopOffsetqto3Fdw$default));
                                    if (pointerInputChange2.isConsumed()) {
                                        return pointerInputChange2;
                                    }
                                    i3 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, null);
                                } else {
                                    i6 = 1;
                                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerInputChange2;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                                    c = 2;
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 2;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12) != coroutine_suspended) {
                                        TouchSlopDetector touchSlopDetector5 = touchSlopDetector2;
                                        function23 = function22;
                                        pointerInputChange4 = pointerInputChange2;
                                        touchSlopDetector = touchSlopDetector5;
                                        m509pointerSlopE8SPZFQ = f;
                                        if (pointerInputChange4.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            i5 = i3;
                            touchSlopDetector = touchSlopDetector2;
                            m509pointerSlopE8SPZFQ = f;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i5, null);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
        int i52 = 1;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please submit an issue!!! */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m506dragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        int i;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            if ((dragGestureDetectorKt$drag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$drag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$drag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                    dragGestureDetectorKt$drag$1.L$1 = function1;
                    dragGestureDetectorKt$drag$1.label = 1;
                    obj = m491awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                    if (obj == coroutine_suspended) {
                    }
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    function1 = (Function1) dragGestureDetectorKt$drag$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            return Boxing.boxBoolean(true);
                        }
                        function1.invoke(pointerInputChange);
                        j = pointerInputChange.m6682getIdJ3iCeTQ();
                        dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                        dragGestureDetectorKt$drag$1.L$1 = function1;
                        dragGestureDetectorKt$drag$1.label = 1;
                        obj = m491awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange == null) {
                            return Boxing.boxBoolean(false);
                        }
                    }
                }
            }
        }
        dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
        Object obj2 = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$drag$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d1, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please submit an issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m491awaitDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
                if (i == 0) {
                    if (i == 1) {
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                pointerInputChange = null;
                                break;
                            }
                            pointerInputChange = changes.get(i3);
                            if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef2.element)) {
                                break;
                            }
                            i3++;
                        }
                        PointerInputChange pointerInputChange3 = pointerInputChange;
                        if (pointerInputChange3 == null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                int size2 = changes2.size();
                                while (true) {
                                    if (i2 >= size2) {
                                        pointerInputChange2 = null;
                                        break;
                                    }
                                    pointerInputChange2 = changes2.get(i2);
                                    if (pointerInputChange2.getPressed()) {
                                        break;
                                    }
                                    i2++;
                                }
                                PointerInputChange pointerInputChange4 = pointerInputChange2;
                                if (pointerInputChange4 != null) {
                                    longRef2.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                    longRef = longRef2;
                                }
                            }
                            dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                            dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Ref.LongRef longRef3 = longRef;
                            obj = awaitPointerEvent$default;
                            longRef2 = longRef3;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                            int size3 = changes3.size();
                            int i22 = 0;
                            int i32 = 0;
                            while (true) {
                                if (i32 < size3) {
                                }
                                i32++;
                            }
                            PointerInputChange pointerInputChange32 = pointerInputChange;
                            if (pointerInputChange32 == null) {
                                pointerInputChange32 = null;
                            }
                        }
                        if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                            return null;
                        }
                        return pointerInputChange32;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    Offset offset = (Offset) obj2;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object detectDragGestures = detectDragGestures(pointerInputScope, null, new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DragGestureDetectorKt.detectDragGestures$lambda$3(Function1.this, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
            }
        }, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragGestureDetectorKt.detectDragGestures$lambda$4(Function0.this, (PointerInputChange) obj);
            }
        }, function02, new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$5());
            }
        }, function2, continuation);
        return detectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectDragGestures$lambda$3(Function1 function1, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        function1.invoke(Offset.m5092boximpl(pointerInputChange2.m6685getPositionF1C5BW0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectDragGestures$lambda$4(Function0 function0, PointerInputChange pointerInputChange) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Orientation orientation, Function3 function3, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit unit;
                    PointerInputChange pointerInputChange = (PointerInputChange) obj2;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj3;
                    Offset offset = (Offset) obj4;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function3 function32 = function3;
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    PointerInputChange pointerInputChange = (PointerInputChange) obj2;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$9());
                }
            };
        }
        return detectDragGestures(pointerInputScope, orientation, function32, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$13(function02, orientation, function3, function2, function0, function1, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x0723, code lost:
        if (r1 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x023b, code lost:
        if (r2 == false) goto L74;
     */
    /* JADX WARN: Path cross not found for [B:188:0x06d0, B:199:0x06fd], limit reached: 235 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x044f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0525 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0422  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0446 -> B:90:0x03ec). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x049a -> B:161:0x0610). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x053c -> B:162:0x0612). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x05c0 -> B:116:0x04ba). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x05fa -> B:158:0x0602). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x0621 -> B:84:0x03c3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x0689 -> B:176:0x068c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0257 -> B:77:0x03a8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x02ed -> B:76:0x03a7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0359 -> B:77:0x03a8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0367 -> B:32:0x0277). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x039e -> B:73:0x03a0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object processDragGesture(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Function0<Boolean> function0, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Unit> continuation) {
        DragGestureDetectorKt$processDragGesture$1 dragGestureDetectorKt$processDragGesture$1;
        DragGestureDetectorKt$processDragGesture$1 dragGestureDetectorKt$processDragGesture$12;
        long j;
        long j2;
        PointerInputChange pointerInputChange2;
        Orientation orientation2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Function0<Unit> function03;
        Function1<? super PointerInputChange, Unit> function12;
        boolean z;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function32;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerInputChange pointerInputChange3;
        Ref.LongRef longRef;
        float f;
        Ref.LongRef longRef2;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function33;
        Ref.LongRef longRef3;
        AwaitPointerEventScope awaitPointerEventScope3;
        Function1<? super PointerInputChange, Unit> function13;
        Function0<Unit> function04;
        Object obj;
        TouchSlopDetector touchSlopDetector;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        TouchSlopDetector touchSlopDetector2;
        TouchSlopDetector touchSlopDetector3;
        Ref.LongRef longRef4;
        PointerInputChange pointerInputChange6;
        int i;
        int i2;
        Ref.LongRef longRef5;
        PointerInputChange pointerInputChange7;
        PointerInputChange pointerInputChange8;
        Function1<? super PointerInputChange, Unit> function14;
        Function0<Unit> function05;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function34;
        Orientation orientation3;
        AwaitPointerEventScope awaitPointerEventScope4;
        float f2;
        Ref.LongRef longRef6;
        Function0<Unit> function06;
        Orientation orientation4;
        TouchSlopDetector touchSlopDetector4;
        Ref.LongRef longRef7;
        AwaitPointerEventScope awaitPointerEventScope5;
        List<PointerInputChange> changes;
        int size;
        float f3;
        int i3;
        Object obj2;
        TouchSlopDetector touchSlopDetector5;
        PointerInputChange pointerInputChange9;
        PointerInputChange pointerInputChange10;
        TouchSlopDetector touchSlopDetector6;
        Object obj3;
        PointerInputChange pointerInputChange11;
        float f4;
        AwaitPointerEventScope awaitPointerEventScope6;
        PointerInputChange pointerInputChange12;
        PointerInputChange pointerInputChange13;
        List<PointerInputChange> list;
        int i4;
        int size2;
        int i5;
        int size3;
        int i6;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24;
        Function0<Unit> function07;
        Function1<? super PointerInputChange, Unit> function15;
        AwaitPointerEventScope awaitPointerEventScope7;
        AwaitPointerEventScope awaitPointerEventScope8;
        Orientation orientation5;
        Ref.LongRef longRef8;
        PointerInputChange pointerInputChange14;
        PointerEvent pointerEvent;
        int size4;
        int i7;
        PointerEvent pointerEvent2;
        Object obj4;
        PointerInputChange pointerInputChange15;
        PointerInputChange pointerInputChange16;
        boolean z2;
        PointerInputChange pointerInputChange17;
        if (continuation instanceof DragGestureDetectorKt$processDragGesture$1) {
            dragGestureDetectorKt$processDragGesture$1 = (DragGestureDetectorKt$processDragGesture$1) continuation;
            if ((dragGestureDetectorKt$processDragGesture$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$processDragGesture$1.label -= Integer.MIN_VALUE;
                dragGestureDetectorKt$processDragGesture$12 = dragGestureDetectorKt$processDragGesture$1;
                Object obj5 = dragGestureDetectorKt$processDragGesture$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dragGestureDetectorKt$processDragGesture$12.label) {
                    case 0:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        ResultKt.throwOnFailure(obj5);
                        boolean booleanValue = function0.invoke().booleanValue();
                        if (!booleanValue) {
                            pointerInputChange.consume();
                        }
                        dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        dragGestureDetectorKt$processDragGesture$12.L$1 = pointerInputChange2;
                        orientation2 = orientation;
                        dragGestureDetectorKt$processDragGesture$12.L$2 = orientation2;
                        dragGestureDetectorKt$processDragGesture$12.L$3 = function3;
                        function22 = function2;
                        dragGestureDetectorKt$processDragGesture$12.L$4 = function22;
                        function03 = function02;
                        dragGestureDetectorKt$processDragGesture$12.L$5 = function03;
                        function12 = function1;
                        dragGestureDetectorKt$processDragGesture$12.L$6 = function12;
                        dragGestureDetectorKt$processDragGesture$12.Z$0 = booleanValue;
                        dragGestureDetectorKt$processDragGesture$12.label = 1;
                        Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, dragGestureDetectorKt$processDragGesture$12, 2, null);
                        if (awaitFirstDown$default != coroutine_suspended) {
                            z = booleanValue;
                            obj5 = awaitFirstDown$default;
                            function32 = function3;
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerInputChange3 = (PointerInputChange) obj5;
                            longRef = new Ref.LongRef();
                            longRef.element = Offset.Companion.m5119getZeroF1C5BW0();
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        z = dragGestureDetectorKt$processDragGesture$12.Z$0;
                        function32 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$3;
                        PointerInputChange pointerInputChange18 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        orientation2 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$2;
                        pointerInputChange2 = pointerInputChange18;
                        function12 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$6;
                        function03 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$5;
                        function22 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$4;
                        pointerInputChange3 = (PointerInputChange) obj5;
                        longRef = new Ref.LongRef();
                        longRef.element = Offset.Companion.m5119getZeroF1C5BW0();
                        break;
                    case 2:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        f = dragGestureDetectorKt$processDragGesture$12.F$0;
                        TouchSlopDetector touchSlopDetector7 = (TouchSlopDetector) dragGestureDetectorKt$processDragGesture$12.L$10;
                        AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$8;
                        longRef2 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$7;
                        PointerInputChange pointerInputChange19 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$6;
                        function22 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$3;
                        function33 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$2;
                        ResultKt.throwOnFailure(obj5);
                        longRef3 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$9;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        function13 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$5;
                        orientation2 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$1;
                        function04 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$4;
                        awaitPointerEventScope2 = awaitPointerEventScope9;
                        PointerEvent pointerEvent3 = (PointerEvent) obj5;
                        List<PointerInputChange> changes2 = pointerEvent3.getChanges();
                        int size5 = changes2.size();
                        float f5 = f;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size5) {
                                PointerInputChange pointerInputChange20 = changes2.get(i8);
                                i = i8;
                                touchSlopDetector = touchSlopDetector7;
                                i2 = size5;
                                obj = coroutine_suspended;
                                if (PointerId.m6664equalsimpl0(pointerInputChange20.m6682getIdJ3iCeTQ(), longRef3.element)) {
                                    pointerInputChange4 = pointerInputChange20;
                                } else {
                                    i8 = i + 1;
                                    touchSlopDetector7 = touchSlopDetector;
                                    size5 = i2;
                                    coroutine_suspended = obj;
                                }
                            } else {
                                obj = coroutine_suspended;
                                touchSlopDetector = touchSlopDetector7;
                                pointerInputChange4 = null;
                            }
                        }
                        pointerInputChange5 = pointerInputChange4;
                        if (pointerInputChange5 != null && !pointerInputChange5.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                                TouchSlopDetector touchSlopDetector8 = touchSlopDetector;
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector8, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange5), f5, false, 4, null);
                                touchSlopDetector2 = touchSlopDetector8;
                                f = f5;
                                if ((m635getPostSlopOffsetqto3Fdw$default & j2) != j) {
                                    pointerInputChange5.consume();
                                    longRef2.element = m635getPostSlopOffsetqto3Fdw$default;
                                    if (pointerInputChange5.isConsumed()) {
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        pointerInputChange3 = pointerInputChange19;
                                        coroutine_suspended = obj;
                                        if (pointerInputChange5 != null || pointerInputChange5.isConsumed()) {
                                            pointerInputChange2 = pointerInputChange5;
                                            longRef = longRef2;
                                            function32 = function33;
                                            function03 = function04;
                                            function12 = function13;
                                            if (pointerInputChange2 == null) {
                                                List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                                int size6 = changes3.size();
                                                for (int i9 = 0; i9 < size6; i9++) {
                                                    if (changes3.get(i9).getPressed()) {
                                                        pointerInputChange8 = pointerInputChange3;
                                                        longRef5 = longRef;
                                                        pointerInputChange7 = pointerInputChange2;
                                                        function23 = function22;
                                                        function14 = function12;
                                                        awaitPointerEventScope4 = awaitPointerEventScope2;
                                                        orientation3 = orientation2;
                                                        function34 = function32;
                                                        function05 = function03;
                                                        PointerEventPass pointerEventPass = PointerEventPass.Final;
                                                        dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope4;
                                                        dragGestureDetectorKt$processDragGesture$12.L$1 = orientation3;
                                                        dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                                                        dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                                                        dragGestureDetectorKt$processDragGesture$12.L$4 = function05;
                                                        dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                                                        dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                                                        dragGestureDetectorKt$processDragGesture$12.L$7 = pointerInputChange7;
                                                        dragGestureDetectorKt$processDragGesture$12.L$8 = longRef5;
                                                        dragGestureDetectorKt$processDragGesture$12.L$9 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$10 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.label = 4;
                                                        obj5 = awaitPointerEventScope4.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$processDragGesture$12);
                                                        if (obj5 == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        PointerEvent pointerEvent4 = (PointerEvent) obj5;
                                                        List<PointerInputChange> changes4 = pointerEvent4.getChanges();
                                                        size2 = changes4.size();
                                                        i5 = 0;
                                                        while (true) {
                                                            if (i5 < size2) {
                                                                if (changes4.get(i5).isConsumed()) {
                                                                    List<PointerInputChange> changes5 = pointerEvent4.getChanges();
                                                                    int size7 = changes5.size();
                                                                    for (int i10 = 0; i10 < size7; i10++) {
                                                                        if (!changes5.get(i10).getPressed()) {
                                                                        }
                                                                    }
                                                                } else {
                                                                    i5++;
                                                                }
                                                            }
                                                        }
                                                        List<PointerInputChange> changes6 = pointerEvent4.getChanges();
                                                        size3 = changes6.size();
                                                        for (i6 = 0; i6 < size3; i6++) {
                                                            if (changes6.get(i6).getPressed()) {
                                                                PointerInputChange pointerInputChange21 = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) pointerEvent4.getChanges());
                                                                long m5107minusMKHz9U = Offset.m5107minusMKHz9U(pointerInputChange21 != null ? pointerInputChange21.m6685getPositionF1C5BW0() : Offset.Companion.m5119getZeroF1C5BW0(), pointerInputChange8.m6685getPositionF1C5BW0());
                                                                long m6682getIdJ3iCeTQ = pointerInputChange8.m6682getIdJ3iCeTQ();
                                                                int m6688getTypeT8wyACA = pointerInputChange8.m6688getTypeT8wyACA();
                                                                if (m508isPointerUpDmW0f2w(awaitPointerEventScope4.getCurrentEvent(), m6682getIdJ3iCeTQ)) {
                                                                    obj3 = coroutine_suspended;
                                                                    longRef = longRef5;
                                                                    pointerInputChange3 = pointerInputChange8;
                                                                    function12 = function14;
                                                                    function03 = function05;
                                                                    function32 = function34;
                                                                    orientation2 = orientation3;
                                                                    awaitPointerEventScope2 = awaitPointerEventScope4;
                                                                    function22 = function23;
                                                                    pointerInputChange2 = null;
                                                                    coroutine_suspended = obj3;
                                                                    if (pointerInputChange2 == null) {
                                                                    }
                                                                } else {
                                                                    f4 = m509pointerSlopE8SPZFQ(awaitPointerEventScope4.getViewConfiguration(), m6688getTypeT8wyACA);
                                                                    longRef7 = new Ref.LongRef();
                                                                    longRef7.element = m6682getIdJ3iCeTQ;
                                                                    touchSlopDetector4 = new TouchSlopDetector(orientation3, m5107minusMKHz9U, null);
                                                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope5;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$1 = orientation3;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$4 = function05;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$7 = longRef5;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope4;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$9 = longRef7;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector4;
                                                                    dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                                    dragGestureDetectorKt$processDragGesture$12.F$0 = f4;
                                                                    dragGestureDetectorKt$processDragGesture$12.label = 5;
                                                                    float f6 = f4;
                                                                    obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                                    if (obj5 != coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    orientation4 = orientation3;
                                                                    function06 = function05;
                                                                    longRef6 = longRef5;
                                                                    f2 = f6;
                                                                    PointerEvent pointerEvent5 = (PointerEvent) obj5;
                                                                    changes = pointerEvent5.getChanges();
                                                                    size = changes.size();
                                                                    f3 = f2;
                                                                    i3 = 0;
                                                                    while (true) {
                                                                        if (i3 >= size) {
                                                                            pointerInputChange9 = changes.get(i3);
                                                                            touchSlopDetector5 = touchSlopDetector4;
                                                                            list = changes;
                                                                            i4 = size;
                                                                            obj2 = coroutine_suspended;
                                                                            if (!PointerId.m6664equalsimpl0(pointerInputChange9.m6682getIdJ3iCeTQ(), longRef7.element)) {
                                                                                i3++;
                                                                                touchSlopDetector4 = touchSlopDetector5;
                                                                                changes = list;
                                                                                size = i4;
                                                                                coroutine_suspended = obj2;
                                                                            }
                                                                        } else {
                                                                            obj2 = coroutine_suspended;
                                                                            touchSlopDetector5 = touchSlopDetector4;
                                                                            pointerInputChange9 = null;
                                                                        }
                                                                    }
                                                                    pointerInputChange10 = pointerInputChange9;
                                                                    if (pointerInputChange10 != null && !pointerInputChange10.isConsumed()) {
                                                                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                                                                            TouchSlopDetector touchSlopDetector9 = touchSlopDetector5;
                                                                            touchSlopDetector6 = touchSlopDetector9;
                                                                            if ((TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector9, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange10), f3, false, 4, null) & j2) != j) {
                                                                                pointerInputChange10.consume();
                                                                                longRef6.element = PointerEventKt.positionChange(pointerInputChange10);
                                                                                if (pointerInputChange10.isConsumed()) {
                                                                                    AwaitPointerEventScope awaitPointerEventScope10 = awaitPointerEventScope5;
                                                                                    function03 = function06;
                                                                                    awaitPointerEventScope2 = awaitPointerEventScope10;
                                                                                    longRef = longRef6;
                                                                                    function22 = function23;
                                                                                    function32 = function34;
                                                                                    orientation2 = orientation4;
                                                                                    obj3 = obj2;
                                                                                    pointerInputChange2 = pointerInputChange10;
                                                                                    pointerInputChange3 = pointerInputChange8;
                                                                                    function12 = function14;
                                                                                    coroutine_suspended = obj3;
                                                                                    if (pointerInputChange2 == null) {
                                                                                    }
                                                                                } else {
                                                                                    f3 = f3;
                                                                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector6, 0L, 1, null);
                                                                                }
                                                                            } else {
                                                                                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope5;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$1 = orientation4;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$4 = function06;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$7 = longRef6;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope4;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$9 = longRef7;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector6;
                                                                                dragGestureDetectorKt$processDragGesture$12.L$11 = pointerInputChange10;
                                                                                dragGestureDetectorKt$processDragGesture$12.F$0 = f3;
                                                                                dragGestureDetectorKt$processDragGesture$12.label = 6;
                                                                                Object awaitPointerEvent = awaitPointerEventScope4.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$processDragGesture$12);
                                                                                obj3 = obj2;
                                                                                if (awaitPointerEvent == obj3) {
                                                                                    return obj3;
                                                                                }
                                                                                PointerInputChange pointerInputChange22 = pointerInputChange8;
                                                                                pointerInputChange11 = pointerInputChange10;
                                                                                f4 = f3;
                                                                                awaitPointerEventScope6 = awaitPointerEventScope4;
                                                                                pointerInputChange12 = pointerInputChange22;
                                                                                longRef5 = longRef6;
                                                                                function05 = function06;
                                                                                orientation3 = orientation4;
                                                                                if (pointerInputChange11.isConsumed()) {
                                                                                    pointerInputChange8 = pointerInputChange12;
                                                                                    awaitPointerEventScope4 = awaitPointerEventScope6;
                                                                                    coroutine_suspended = obj3;
                                                                                    touchSlopDetector4 = touchSlopDetector6;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope5;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$1 = orientation3;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$4 = function05;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$7 = longRef5;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope4;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$9 = longRef7;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector4;
                                                                                    dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                                                    dragGestureDetectorKt$processDragGesture$12.F$0 = f4;
                                                                                    dragGestureDetectorKt$processDragGesture$12.label = 5;
                                                                                    float f62 = f4;
                                                                                    obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                                                    if (obj5 != coroutine_suspended) {
                                                                                    }
                                                                                } else {
                                                                                    AwaitPointerEventScope awaitPointerEventScope11 = awaitPointerEventScope5;
                                                                                    function03 = function05;
                                                                                    function32 = function34;
                                                                                    orientation2 = orientation3;
                                                                                    awaitPointerEventScope2 = awaitPointerEventScope11;
                                                                                    longRef = longRef5;
                                                                                    function12 = function14;
                                                                                    pointerInputChange3 = pointerInputChange12;
                                                                                    function22 = function23;
                                                                                    pointerInputChange2 = null;
                                                                                    coroutine_suspended = obj3;
                                                                                    if (pointerInputChange2 == null) {
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            List<PointerInputChange> changes7 = pointerEvent5.getChanges();
                                                                            int size8 = changes7.size();
                                                                            int i11 = 0;
                                                                            while (true) {
                                                                                if (i11 < size8) {
                                                                                    pointerInputChange13 = changes7.get(i11);
                                                                                    if (!pointerInputChange13.getPressed()) {
                                                                                        i11++;
                                                                                    }
                                                                                } else {
                                                                                    pointerInputChange13 = null;
                                                                                }
                                                                            }
                                                                            PointerInputChange pointerInputChange23 = pointerInputChange13;
                                                                            if (pointerInputChange23 != null) {
                                                                                longRef7.element = pointerInputChange23.m6682getIdJ3iCeTQ();
                                                                                touchSlopDetector6 = touchSlopDetector5;
                                                                            }
                                                                        }
                                                                        f4 = f3;
                                                                        longRef5 = longRef6;
                                                                        function05 = function06;
                                                                        orientation3 = orientation4;
                                                                        touchSlopDetector4 = touchSlopDetector6;
                                                                        coroutine_suspended = obj2;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope5;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$1 = orientation3;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$4 = function05;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$7 = longRef5;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope4;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$9 = longRef7;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector4;
                                                                        dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                                        dragGestureDetectorKt$processDragGesture$12.F$0 = f4;
                                                                        dragGestureDetectorKt$processDragGesture$12.label = 5;
                                                                        float f622 = f4;
                                                                        obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                                        if (obj5 != coroutine_suspended) {
                                                                        }
                                                                    }
                                                                    AwaitPointerEventScope awaitPointerEventScope12 = awaitPointerEventScope5;
                                                                    function03 = function06;
                                                                    awaitPointerEventScope2 = awaitPointerEventScope12;
                                                                    pointerInputChange3 = pointerInputChange8;
                                                                    longRef = longRef6;
                                                                    function22 = function23;
                                                                    function32 = function34;
                                                                    orientation2 = orientation4;
                                                                    obj3 = obj2;
                                                                    pointerInputChange2 = null;
                                                                    function12 = function14;
                                                                    coroutine_suspended = obj3;
                                                                    if (pointerInputChange2 == null) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        pointerInputChange3 = pointerInputChange8;
                                                        function12 = function14;
                                                        function03 = function05;
                                                        function32 = function34;
                                                        orientation2 = orientation3;
                                                        awaitPointerEventScope2 = awaitPointerEventScope4;
                                                        function22 = function23;
                                                        pointerInputChange2 = pointerInputChange7;
                                                        longRef = longRef5;
                                                        if (pointerInputChange2 == null) {
                                                        }
                                                    }
                                                }
                                            }
                                            if (pointerInputChange2 != null) {
                                                function32.invoke(pointerInputChange3, pointerInputChange2, Offset.m5092boximpl(longRef.element));
                                                function22.invoke(pointerInputChange2, Offset.m5092boximpl(longRef.element));
                                                long m6682getIdJ3iCeTQ2 = pointerInputChange2.m6682getIdJ3iCeTQ();
                                                if (!m508isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), m6682getIdJ3iCeTQ2)) {
                                                    Orientation orientation6 = null;
                                                    Ref.LongRef longRef9 = new Ref.LongRef();
                                                    longRef9.element = m6682getIdJ3iCeTQ2;
                                                    orientation5 = orientation6;
                                                    longRef8 = longRef9;
                                                    awaitPointerEventScope8 = awaitPointerEventScope2;
                                                    awaitPointerEventScope7 = awaitPointerEventScope8;
                                                    function24 = function22;
                                                    function07 = function03;
                                                    function15 = function12;
                                                    dragGestureDetectorKt$processDragGesture$12.L$0 = function24;
                                                    dragGestureDetectorKt$processDragGesture$12.L$1 = function07;
                                                    dragGestureDetectorKt$processDragGesture$12.L$2 = function15;
                                                    dragGestureDetectorKt$processDragGesture$12.L$3 = awaitPointerEventScope7;
                                                    dragGestureDetectorKt$processDragGesture$12.L$4 = awaitPointerEventScope8;
                                                    dragGestureDetectorKt$processDragGesture$12.L$5 = longRef8;
                                                    dragGestureDetectorKt$processDragGesture$12.L$6 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.L$7 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.L$8 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.L$9 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.L$10 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                    dragGestureDetectorKt$processDragGesture$12.label = 7;
                                                    obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                    if (obj5 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    pointerEvent = (PointerEvent) obj5;
                                                    List<PointerInputChange> changes8 = pointerEvent.getChanges();
                                                    size4 = changes8.size();
                                                    i7 = 0;
                                                    while (true) {
                                                        if (i7 >= size4) {
                                                            pointerInputChange15 = changes8.get(i7);
                                                            pointerEvent2 = pointerEvent;
                                                            obj4 = coroutine_suspended;
                                                            if (!PointerId.m6664equalsimpl0(pointerInputChange15.m6682getIdJ3iCeTQ(), longRef8.element)) {
                                                                i7++;
                                                                pointerEvent = pointerEvent2;
                                                                coroutine_suspended = obj4;
                                                            }
                                                        } else {
                                                            pointerEvent2 = pointerEvent;
                                                            obj4 = coroutine_suspended;
                                                            pointerInputChange15 = null;
                                                        }
                                                    }
                                                    pointerInputChange16 = pointerInputChange15;
                                                    if (pointerInputChange16 == null) {
                                                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                            long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange16);
                                                            if ((orientation5 != null ? Float.intBitsToFloat((int) (orientation5 == Orientation.Vertical ? positionChangeIgnoreConsumed & 4294967295L : positionChangeIgnoreConsumed >> 32)) : Offset.m5101getDistanceimpl(positionChangeIgnoreConsumed)) == 0.0f) {
                                                                z2 = true;
                                                                break;
                                                            } else {
                                                                z2 = false;
                                                                break;
                                                            }
                                                        } else {
                                                            List<PointerInputChange> changes9 = pointerEvent2.getChanges();
                                                            int size9 = changes9.size();
                                                            int i12 = 0;
                                                            while (true) {
                                                                if (i12 < size9) {
                                                                    pointerInputChange17 = changes9.get(i12);
                                                                    if (!pointerInputChange17.getPressed()) {
                                                                        i12++;
                                                                    }
                                                                } else {
                                                                    pointerInputChange17 = null;
                                                                }
                                                            }
                                                            PointerInputChange pointerInputChange24 = pointerInputChange17;
                                                            if (pointerInputChange24 != null) {
                                                                longRef8.element = pointerInputChange24.m6682getIdJ3iCeTQ();
                                                                coroutine_suspended = obj4;
                                                                dragGestureDetectorKt$processDragGesture$12.L$0 = function24;
                                                                dragGestureDetectorKt$processDragGesture$12.L$1 = function07;
                                                                dragGestureDetectorKt$processDragGesture$12.L$2 = function15;
                                                                dragGestureDetectorKt$processDragGesture$12.L$3 = awaitPointerEventScope7;
                                                                dragGestureDetectorKt$processDragGesture$12.L$4 = awaitPointerEventScope8;
                                                                dragGestureDetectorKt$processDragGesture$12.L$5 = longRef8;
                                                                dragGestureDetectorKt$processDragGesture$12.L$6 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.L$7 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.L$8 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.L$9 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.L$10 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                                dragGestureDetectorKt$processDragGesture$12.label = 7;
                                                                obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                                if (obj5 == coroutine_suspended) {
                                                                }
                                                                pointerEvent = (PointerEvent) obj5;
                                                                List<PointerInputChange> changes82 = pointerEvent.getChanges();
                                                                size4 = changes82.size();
                                                                i7 = 0;
                                                                while (true) {
                                                                    if (i7 >= size4) {
                                                                    }
                                                                    i7++;
                                                                    pointerEvent = pointerEvent2;
                                                                    coroutine_suspended = obj4;
                                                                }
                                                                pointerInputChange16 = pointerInputChange15;
                                                                if (pointerInputChange16 == null) {
                                                                    pointerInputChange16 = null;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (pointerInputChange16 == null || pointerInputChange16.isConsumed()) {
                                                        function12 = function15;
                                                        function03 = function07;
                                                    } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                        function24.invoke(pointerInputChange16, Offset.m5092boximpl(PointerEventKt.positionChange(pointerInputChange16)));
                                                        pointerInputChange16.consume();
                                                        long m6682getIdJ3iCeTQ3 = pointerInputChange16.m6682getIdJ3iCeTQ();
                                                        orientation6 = orientation5;
                                                        m6682getIdJ3iCeTQ2 = m6682getIdJ3iCeTQ3;
                                                        awaitPointerEventScope2 = awaitPointerEventScope7;
                                                        function12 = function15;
                                                        function03 = function07;
                                                        function22 = function24;
                                                        coroutine_suspended = obj4;
                                                        Ref.LongRef longRef92 = new Ref.LongRef();
                                                        longRef92.element = m6682getIdJ3iCeTQ2;
                                                        orientation5 = orientation6;
                                                        longRef8 = longRef92;
                                                        awaitPointerEventScope8 = awaitPointerEventScope2;
                                                        awaitPointerEventScope7 = awaitPointerEventScope8;
                                                        function24 = function22;
                                                        function07 = function03;
                                                        function15 = function12;
                                                        dragGestureDetectorKt$processDragGesture$12.L$0 = function24;
                                                        dragGestureDetectorKt$processDragGesture$12.L$1 = function07;
                                                        dragGestureDetectorKt$processDragGesture$12.L$2 = function15;
                                                        dragGestureDetectorKt$processDragGesture$12.L$3 = awaitPointerEventScope7;
                                                        dragGestureDetectorKt$processDragGesture$12.L$4 = awaitPointerEventScope8;
                                                        dragGestureDetectorKt$processDragGesture$12.L$5 = longRef8;
                                                        dragGestureDetectorKt$processDragGesture$12.L$6 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$7 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$8 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$9 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$10 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                                        dragGestureDetectorKt$processDragGesture$12.label = 7;
                                                        obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope8, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                                        if (obj5 == coroutine_suspended) {
                                                        }
                                                        pointerEvent = (PointerEvent) obj5;
                                                        List<PointerInputChange> changes822 = pointerEvent.getChanges();
                                                        size4 = changes822.size();
                                                        i7 = 0;
                                                        while (true) {
                                                            if (i7 >= size4) {
                                                            }
                                                            i7++;
                                                            pointerEvent = pointerEvent2;
                                                            coroutine_suspended = obj4;
                                                        }
                                                        pointerInputChange16 = pointerInputChange15;
                                                        if (pointerInputChange16 == null) {
                                                        }
                                                        if (pointerInputChange16 == null) {
                                                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange16)) {
                                                            }
                                                        }
                                                        function12 = function15;
                                                        function03 = function07;
                                                    } else {
                                                        pointerInputChange14 = pointerInputChange16;
                                                        function12 = function15;
                                                        function03 = function07;
                                                        if (pointerInputChange14 == null) {
                                                            function03.invoke();
                                                        } else {
                                                            function12.invoke(pointerInputChange14);
                                                        }
                                                    }
                                                }
                                                pointerInputChange14 = null;
                                                if (pointerInputChange14 == null) {
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        longRef = longRef2;
                                        function32 = function33;
                                        function03 = function04;
                                        function12 = function13;
                                        long m6682getIdJ3iCeTQ4 = pointerInputChange3.m6682getIdJ3iCeTQ();
                                        int m6688getTypeT8wyACA2 = pointerInputChange3.m6688getTypeT8wyACA();
                                        Ref.LongRef longRef10 = longRef;
                                        long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                                        if (m508isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), m6682getIdJ3iCeTQ4)) {
                                            function13 = function12;
                                            pointerInputChange5 = null;
                                            function04 = function03;
                                            function33 = function32;
                                            longRef2 = longRef10;
                                            if (pointerInputChange5 != null) {
                                            }
                                            pointerInputChange2 = pointerInputChange5;
                                            longRef = longRef2;
                                            function32 = function33;
                                            function03 = function04;
                                            function12 = function13;
                                            if (pointerInputChange2 == null) {
                                            }
                                            if (pointerInputChange2 != null) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        f = m509pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), m6688getTypeT8wyACA2);
                                        longRef3 = new Ref.LongRef();
                                        longRef3.element = m6682getIdJ3iCeTQ4;
                                        touchSlopDetector3 = new TouchSlopDetector(orientation2, m5119getZeroF1C5BW0, null);
                                        longRef4 = longRef10;
                                        awaitPointerEventScope3 = awaitPointerEventScope2;
                                        dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope3;
                                        dragGestureDetectorKt$processDragGesture$12.L$1 = orientation2;
                                        dragGestureDetectorKt$processDragGesture$12.L$2 = function32;
                                        dragGestureDetectorKt$processDragGesture$12.L$3 = function22;
                                        dragGestureDetectorKt$processDragGesture$12.L$4 = function03;
                                        dragGestureDetectorKt$processDragGesture$12.L$5 = function12;
                                        dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange3;
                                        dragGestureDetectorKt$processDragGesture$12.L$7 = longRef4;
                                        dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope2;
                                        dragGestureDetectorKt$processDragGesture$12.L$9 = longRef3;
                                        dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector3;
                                        dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                        dragGestureDetectorKt$processDragGesture$12.F$0 = f;
                                        dragGestureDetectorKt$processDragGesture$12.label = 2;
                                        PointerInputChange pointerInputChange25 = pointerInputChange3;
                                        obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                        if (obj5 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        function13 = function12;
                                        function04 = function03;
                                        function33 = function32;
                                        longRef2 = longRef4;
                                        touchSlopDetector7 = touchSlopDetector3;
                                        pointerInputChange19 = pointerInputChange25;
                                        PointerEvent pointerEvent32 = (PointerEvent) obj5;
                                        List<PointerInputChange> changes22 = pointerEvent32.getChanges();
                                        int size52 = changes22.size();
                                        float f52 = f;
                                        int i82 = 0;
                                        while (true) {
                                            if (i82 >= size52) {
                                            }
                                            i82 = i + 1;
                                            touchSlopDetector7 = touchSlopDetector;
                                            size52 = i2;
                                            coroutine_suspended = obj;
                                        }
                                        pointerInputChange5 = pointerInputChange4;
                                        if (pointerInputChange5 != null) {
                                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                                            }
                                        }
                                    } else {
                                        f52 = f;
                                        TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, null);
                                    }
                                } else {
                                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                    dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope3;
                                    dragGestureDetectorKt$processDragGesture$12.L$1 = orientation2;
                                    dragGestureDetectorKt$processDragGesture$12.L$2 = function33;
                                    dragGestureDetectorKt$processDragGesture$12.L$3 = function22;
                                    dragGestureDetectorKt$processDragGesture$12.L$4 = function04;
                                    dragGestureDetectorKt$processDragGesture$12.L$5 = function13;
                                    dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange19;
                                    dragGestureDetectorKt$processDragGesture$12.L$7 = longRef2;
                                    dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$processDragGesture$12.L$9 = longRef3;
                                    dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector2;
                                    dragGestureDetectorKt$processDragGesture$12.L$11 = pointerInputChange5;
                                    dragGestureDetectorKt$processDragGesture$12.F$0 = f;
                                    dragGestureDetectorKt$processDragGesture$12.label = 3;
                                    coroutine_suspended = obj;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$processDragGesture$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    pointerInputChange3 = pointerInputChange19;
                                    touchSlopDetector3 = touchSlopDetector2;
                                    if (!pointerInputChange5.isConsumed()) {
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        pointerInputChange5 = null;
                                        if (pointerInputChange5 != null) {
                                        }
                                        pointerInputChange2 = pointerInputChange5;
                                        longRef = longRef2;
                                        function32 = function33;
                                        function03 = function04;
                                        function12 = function13;
                                        if (pointerInputChange2 == null) {
                                        }
                                        if (pointerInputChange2 != null) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    longRef4 = longRef2;
                                    function32 = function33;
                                    function03 = function04;
                                    function12 = function13;
                                    dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope3;
                                    dragGestureDetectorKt$processDragGesture$12.L$1 = orientation2;
                                    dragGestureDetectorKt$processDragGesture$12.L$2 = function32;
                                    dragGestureDetectorKt$processDragGesture$12.L$3 = function22;
                                    dragGestureDetectorKt$processDragGesture$12.L$4 = function03;
                                    dragGestureDetectorKt$processDragGesture$12.L$5 = function12;
                                    dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange3;
                                    dragGestureDetectorKt$processDragGesture$12.L$7 = longRef4;
                                    dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$processDragGesture$12.L$9 = longRef3;
                                    dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector3;
                                    dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                                    dragGestureDetectorKt$processDragGesture$12.F$0 = f;
                                    dragGestureDetectorKt$processDragGesture$12.label = 2;
                                    PointerInputChange pointerInputChange252 = pointerInputChange3;
                                    obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                                    if (obj5 == coroutine_suspended) {
                                    }
                                }
                            } else {
                                List<PointerInputChange> changes10 = pointerEvent32.getChanges();
                                int size10 = changes10.size();
                                int i13 = 0;
                                while (true) {
                                    if (i13 < size10) {
                                        pointerInputChange6 = changes10.get(i13);
                                        if (!pointerInputChange6.getPressed()) {
                                            i13++;
                                        }
                                    } else {
                                        pointerInputChange6 = null;
                                    }
                                }
                                PointerInputChange pointerInputChange26 = pointerInputChange6;
                                if (pointerInputChange26 != null) {
                                    longRef3.element = pointerInputChange26.m6682getIdJ3iCeTQ();
                                    touchSlopDetector2 = touchSlopDetector;
                                }
                            }
                            f = f52;
                            longRef4 = longRef2;
                            pointerInputChange3 = pointerInputChange19;
                            function32 = function33;
                            function03 = function04;
                            function12 = function13;
                            touchSlopDetector3 = touchSlopDetector2;
                            coroutine_suspended = obj;
                            dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope3;
                            dragGestureDetectorKt$processDragGesture$12.L$1 = orientation2;
                            dragGestureDetectorKt$processDragGesture$12.L$2 = function32;
                            dragGestureDetectorKt$processDragGesture$12.L$3 = function22;
                            dragGestureDetectorKt$processDragGesture$12.L$4 = function03;
                            dragGestureDetectorKt$processDragGesture$12.L$5 = function12;
                            dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange3;
                            dragGestureDetectorKt$processDragGesture$12.L$7 = longRef4;
                            dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope2;
                            dragGestureDetectorKt$processDragGesture$12.L$9 = longRef3;
                            dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector3;
                            dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                            dragGestureDetectorKt$processDragGesture$12.F$0 = f;
                            dragGestureDetectorKt$processDragGesture$12.label = 2;
                            PointerInputChange pointerInputChange2522 = pointerInputChange3;
                            obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                            if (obj5 == coroutine_suspended) {
                            }
                        }
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        pointerInputChange3 = pointerInputChange19;
                        coroutine_suspended = obj;
                        pointerInputChange5 = null;
                        if (pointerInputChange5 != null) {
                        }
                        pointerInputChange2 = pointerInputChange5;
                        longRef = longRef2;
                        function32 = function33;
                        function03 = function04;
                        function12 = function13;
                        if (pointerInputChange2 == null) {
                        }
                        if (pointerInputChange2 != null) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        f = dragGestureDetectorKt$processDragGesture$12.F$0;
                        pointerInputChange5 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$11;
                        longRef3 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$9;
                        Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function35 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$2;
                        ResultKt.throwOnFailure(obj5);
                        function04 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$4;
                        function22 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$3;
                        function33 = function35;
                        pointerInputChange3 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$6;
                        orientation2 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$1;
                        function13 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$5;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$8;
                        longRef2 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$7;
                        touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$processDragGesture$12.L$10;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        if (!pointerInputChange5.isConsumed()) {
                        }
                        break;
                    case 4:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        longRef5 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$8;
                        pointerInputChange7 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$7;
                        pointerInputChange8 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$6;
                        function14 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$5;
                        function05 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$4;
                        function23 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$3;
                        function34 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$2;
                        orientation3 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$1;
                        awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        PointerEvent pointerEvent42 = (PointerEvent) obj5;
                        List<PointerInputChange> changes42 = pointerEvent42.getChanges();
                        size2 = changes42.size();
                        i5 = 0;
                        while (true) {
                            if (i5 < size2) {
                            }
                            i5++;
                        }
                        List<PointerInputChange> changes62 = pointerEvent42.getChanges();
                        size3 = changes62.size();
                        while (i6 < size3) {
                        }
                        pointerInputChange3 = pointerInputChange8;
                        function12 = function14;
                        function03 = function05;
                        function32 = function34;
                        orientation2 = orientation3;
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        function22 = function23;
                        pointerInputChange2 = pointerInputChange7;
                        longRef = longRef5;
                        if (pointerInputChange2 == null) {
                        }
                        if (pointerInputChange2 != null) {
                        }
                        return Unit.INSTANCE;
                    case 5:
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        j2 = 9223372034707292159L;
                        f2 = dragGestureDetectorKt$processDragGesture$12.F$0;
                        longRef6 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$7;
                        function06 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$4;
                        orientation4 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$1;
                        AwaitPointerEventScope awaitPointerEventScope13 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$processDragGesture$12.L$10;
                        longRef7 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$9;
                        pointerInputChange8 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$6;
                        function23 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$3;
                        awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$8;
                        function14 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$5;
                        function34 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$2;
                        awaitPointerEventScope5 = awaitPointerEventScope13;
                        PointerEvent pointerEvent52 = (PointerEvent) obj5;
                        changes = pointerEvent52.getChanges();
                        size = changes.size();
                        f3 = f2;
                        i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                            }
                            i3++;
                            touchSlopDetector4 = touchSlopDetector5;
                            changes = list;
                            size = i4;
                            coroutine_suspended = obj2;
                        }
                        pointerInputChange10 = pointerInputChange9;
                        if (pointerInputChange10 != null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                            }
                            f4 = f3;
                            longRef5 = longRef6;
                            function05 = function06;
                            orientation3 = orientation4;
                            touchSlopDetector4 = touchSlopDetector6;
                            coroutine_suspended = obj2;
                            dragGestureDetectorKt$processDragGesture$12.L$0 = awaitPointerEventScope5;
                            dragGestureDetectorKt$processDragGesture$12.L$1 = orientation3;
                            dragGestureDetectorKt$processDragGesture$12.L$2 = function34;
                            dragGestureDetectorKt$processDragGesture$12.L$3 = function23;
                            dragGestureDetectorKt$processDragGesture$12.L$4 = function05;
                            dragGestureDetectorKt$processDragGesture$12.L$5 = function14;
                            dragGestureDetectorKt$processDragGesture$12.L$6 = pointerInputChange8;
                            dragGestureDetectorKt$processDragGesture$12.L$7 = longRef5;
                            dragGestureDetectorKt$processDragGesture$12.L$8 = awaitPointerEventScope4;
                            dragGestureDetectorKt$processDragGesture$12.L$9 = longRef7;
                            dragGestureDetectorKt$processDragGesture$12.L$10 = touchSlopDetector4;
                            dragGestureDetectorKt$processDragGesture$12.L$11 = null;
                            dragGestureDetectorKt$processDragGesture$12.F$0 = f4;
                            dragGestureDetectorKt$processDragGesture$12.label = 5;
                            float f6222 = f4;
                            obj5 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope4, null, dragGestureDetectorKt$processDragGesture$12, 1, null);
                            if (obj5 != coroutine_suspended) {
                            }
                            break;
                        }
                        AwaitPointerEventScope awaitPointerEventScope122 = awaitPointerEventScope5;
                        function03 = function06;
                        awaitPointerEventScope2 = awaitPointerEventScope122;
                        pointerInputChange3 = pointerInputChange8;
                        longRef = longRef6;
                        function22 = function23;
                        function32 = function34;
                        orientation2 = orientation4;
                        obj3 = obj2;
                        pointerInputChange2 = null;
                        function12 = function14;
                        coroutine_suspended = obj3;
                        if (pointerInputChange2 == null) {
                        }
                        if (pointerInputChange2 != null) {
                        }
                        return Unit.INSTANCE;
                    case 6:
                        float f7 = dragGestureDetectorKt$processDragGesture$12.F$0;
                        pointerInputChange11 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$11;
                        j = InlineClassHelperKt.UnspecifiedPackedFloats;
                        pointerInputChange12 = (PointerInputChange) dragGestureDetectorKt$processDragGesture$12.L$6;
                        j2 = 9223372034707292159L;
                        AwaitPointerEventScope awaitPointerEventScope14 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        touchSlopDetector6 = (TouchSlopDetector) dragGestureDetectorKt$processDragGesture$12.L$10;
                        function14 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$5;
                        awaitPointerEventScope5 = awaitPointerEventScope14;
                        f4 = f7;
                        longRef5 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$7;
                        orientation3 = (Orientation) dragGestureDetectorKt$processDragGesture$12.L$1;
                        function34 = (Function3) dragGestureDetectorKt$processDragGesture$12.L$2;
                        function23 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$3;
                        obj3 = coroutine_suspended;
                        awaitPointerEventScope6 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$8;
                        longRef7 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$9;
                        function05 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$4;
                        if (pointerInputChange11.isConsumed()) {
                        }
                        break;
                    case 7:
                        longRef8 = (Ref.LongRef) dragGestureDetectorKt$processDragGesture$12.L$5;
                        awaitPointerEventScope8 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$4;
                        awaitPointerEventScope7 = (AwaitPointerEventScope) dragGestureDetectorKt$processDragGesture$12.L$3;
                        function15 = (Function1) dragGestureDetectorKt$processDragGesture$12.L$2;
                        function07 = (Function0) dragGestureDetectorKt$processDragGesture$12.L$1;
                        function24 = (Function2) dragGestureDetectorKt$processDragGesture$12.L$0;
                        ResultKt.throwOnFailure(obj5);
                        orientation5 = null;
                        pointerEvent = (PointerEvent) obj5;
                        List<PointerInputChange> changes8222 = pointerEvent.getChanges();
                        size4 = changes8222.size();
                        i7 = 0;
                        while (true) {
                            if (i7 >= size4) {
                            }
                            i7++;
                            pointerEvent = pointerEvent2;
                            coroutine_suspended = obj4;
                        }
                        pointerInputChange16 = pointerInputChange15;
                        if (pointerInputChange16 == null) {
                        }
                        if (pointerInputChange16 == null) {
                        }
                        function12 = function15;
                        function03 = function07;
                        pointerInputChange14 = null;
                        if (pointerInputChange14 == null) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$processDragGesture$1 = new DragGestureDetectorKt$processDragGesture$1(continuation);
        dragGestureDetectorKt$processDragGesture$12 = dragGestureDetectorKt$processDragGesture$1;
        Object obj52 = dragGestureDetectorKt$processDragGesture$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dragGestureDetectorKt$processDragGesture$12.label) {
        }
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    Offset offset = (Offset) obj2;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0179 -> B:20:0x00ab). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0199 -> B:61:0x019e). Please submit an issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m503awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        int i;
        float m509pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        Object obj;
        Object obj2;
        PointerInputChange pointerInputChange;
        int i3;
        Object obj3;
        int i4;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj4 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
                int i5 = 1;
                PointerEventPass pointerEventPass = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    int m6765getTouchT8wyACA = PointerType.Companion.m6765getTouchT8wyACA();
                    Orientation orientation = Orientation.Vertical;
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m6765getTouchT8wyACA);
                    longRef = new Ref.LongRef();
                    longRef.element = j;
                    TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, m5119getZeroF1C5BW0, null);
                    function22 = function2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector3;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i5, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    float f2 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
                    ResultKt.throwOnFailure(obj4);
                    f = f2;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
                    function22 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                    PointerEvent pointerEvent = (PointerEvent) obj4;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    int i6 = 0;
                    i2 = 0;
                    while (true) {
                        if (i2 < size) {
                        }
                        i2++;
                        size = i4;
                        pointerEventPass = obj;
                    }
                    pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange != null) {
                        return obj;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    }
                    i5 = i3;
                    touchSlopDetector = touchSlopDetector2;
                    m509pointerSlopE8SPZFQ = f;
                    pointerEventPass = null;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i5, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 2) {
                    float f3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4;
                    TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector4;
                    char c = 2;
                    int i7 = 1;
                    m509pointerSlopE8SPZFQ = f3;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
                    if (pointerInputChange2.isConsumed()) {
                        i5 = i7;
                        function22 = function23;
                        pointerEventPass = null;
                        longRef = longRef2;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i5;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            f = m509pointerSlopE8SPZFQ;
                            touchSlopDetector2 = touchSlopDetector;
                            obj4 = awaitPointerEvent$default;
                            PointerEvent pointerEvent2 = (PointerEvent) obj4;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            int i62 = 0;
                            i2 = 0;
                            while (true) {
                                if (i2 < size) {
                                    obj = pointerEventPass;
                                    obj2 = obj;
                                    break;
                                }
                                obj2 = changes2.get(i2);
                                obj = pointerEventPass;
                                i4 = size;
                                if (PointerId.m6664equalsimpl0(((PointerInputChange) obj2).m6682getIdJ3iCeTQ(), longRef.element)) {
                                    break;
                                }
                                i2++;
                                size = i4;
                                pointerEventPass = obj;
                            }
                            pointerInputChange = (PointerInputChange) obj2;
                            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                                return obj;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                while (true) {
                                    if (i62 >= size2) {
                                        obj3 = obj;
                                        break;
                                    }
                                    obj3 = changes3.get(i62);
                                    if (((PointerInputChange) obj3).getPressed()) {
                                        break;
                                    }
                                    i62++;
                                }
                                PointerInputChange pointerInputChange3 = (PointerInputChange) obj3;
                                if (pointerInputChange3 == null) {
                                    return obj;
                                }
                                longRef.element = pointerInputChange3.m6682getIdJ3iCeTQ();
                                i3 = 1;
                            } else {
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (m635getPostSlopOffsetqto3Fdw$default & 4294967295L))));
                                    if (pointerInputChange.isConsumed()) {
                                        return pointerInputChange;
                                    }
                                    i3 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, obj);
                                } else {
                                    i7 = 1;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                                    c = 2;
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 2;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12) != coroutine_suspended) {
                                        longRef2 = longRef;
                                        m509pointerSlopE8SPZFQ = f;
                                        function23 = function22;
                                        pointerInputChange2 = pointerInputChange;
                                        touchSlopDetector = touchSlopDetector2;
                                        if (pointerInputChange2.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            i5 = i3;
                            touchSlopDetector = touchSlopDetector2;
                            m509pointerSlopE8SPZFQ = f;
                            pointerEventPass = null;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i5, pointerEventPass);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
        Object obj42 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
        int i52 = 1;
        PointerEventPass pointerEventPass3 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0170 -> B:20:0x00a2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0190 -> B:61:0x0194). Please submit an issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m502awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        int i2;
        float m509pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i3;
        Object obj;
        Object obj2;
        PointerInputChange pointerInputChange;
        int i4;
        Object obj3;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
                int i6 = 1;
                PointerEventPass pointerEventPass = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj4);
                    Orientation orientation = Orientation.Vertical;
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    longRef = new Ref.LongRef();
                    longRef.element = j;
                    function22 = function2;
                    touchSlopDetector = new TouchSlopDetector(orientation, m5119getZeroF1C5BW0, null);
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 1) {
                    float f2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
                    ResultKt.throwOnFailure(obj4);
                    f = f2;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
                    function22 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
                    PointerEvent pointerEvent = (PointerEvent) obj4;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    int i7 = 0;
                    i3 = 0;
                    while (true) {
                        if (i3 < size) {
                        }
                        i3++;
                        size = i5;
                        pointerEventPass = obj;
                    }
                    pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange != null) {
                        return obj;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    }
                    i6 = i4;
                    touchSlopDetector = touchSlopDetector2;
                    m509pointerSlopE8SPZFQ = f;
                    pointerEventPass = null;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 2) {
                    float f3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
                    int i8 = 1;
                    m509pointerSlopE8SPZFQ = f3;
                    char c = 2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
                    if (pointerInputChange2.isConsumed()) {
                        function22 = function23;
                        pointerEventPass = null;
                        i6 = i8;
                        longRef = longRef2;
                        touchSlopDetector = touchSlopDetector2;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i6;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i6, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            touchSlopDetector2 = touchSlopDetector;
                            f = m509pointerSlopE8SPZFQ;
                            obj4 = awaitPointerEvent$default;
                            PointerEvent pointerEvent2 = (PointerEvent) obj4;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            int i72 = 0;
                            i3 = 0;
                            while (true) {
                                if (i3 < size) {
                                    obj = pointerEventPass;
                                    obj2 = obj;
                                    break;
                                }
                                obj2 = changes2.get(i3);
                                obj = pointerEventPass;
                                i5 = size;
                                if (PointerId.m6664equalsimpl0(((PointerInputChange) obj2).m6682getIdJ3iCeTQ(), longRef.element)) {
                                    break;
                                }
                                i3++;
                                size = i5;
                                pointerEventPass = obj;
                            }
                            pointerInputChange = (PointerInputChange) obj2;
                            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                                return obj;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                while (true) {
                                    if (i72 >= size2) {
                                        obj3 = obj;
                                        break;
                                    }
                                    obj3 = changes3.get(i72);
                                    if (((PointerInputChange) obj3).getPressed()) {
                                        break;
                                    }
                                    i72++;
                                }
                                PointerInputChange pointerInputChange3 = (PointerInputChange) obj3;
                                if (pointerInputChange3 == null) {
                                    return obj;
                                }
                                longRef.element = pointerInputChange3.m6682getIdJ3iCeTQ();
                                i4 = 1;
                            } else {
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (m635getPostSlopOffsetqto3Fdw$default & 4294967295L))));
                                    if (pointerInputChange.isConsumed()) {
                                        return pointerInputChange;
                                    }
                                    i4 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, obj);
                                } else {
                                    i8 = 1;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector2;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = f;
                                    c = 2;
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = 2;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) != coroutine_suspended) {
                                        longRef2 = longRef;
                                        function23 = function22;
                                        pointerInputChange2 = pointerInputChange;
                                        m509pointerSlopE8SPZFQ = f;
                                        if (pointerInputChange2.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            i6 = i4;
                            touchSlopDetector = touchSlopDetector2;
                            m509pointerSlopE8SPZFQ = f;
                            pointerEventPass = null;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i6;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i6, pointerEventPass);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
        Object obj42 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
        int i62 = 1;
        PointerEventPass pointerEventPass3 = null;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
        if ((r0 == 0.0f) == false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please submit an issue!!! */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m510verticalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        int i;
        long j2;
        Orientation orientation;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object awaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float intBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            if ((dragGestureDetectorKt$verticalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$verticalDrag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$verticalDrag$1.label;
                int i2 = 1;
                PointerEventPass pointerEventPass = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Orientation orientation3 = Orientation.Vertical;
                    j2 = j;
                    if (!m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        orientation = orientation3;
                        dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        function12 = function1;
                        Ref.LongRef longRef2 = new Ref.LongRef();
                        longRef2.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        orientation2 = orientation;
                        longRef = longRef2;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                        dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                        dragGestureDetectorKt$verticalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerEventPass == null);
                } else if (i == 1) {
                    longRef = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$1.L$4;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$3;
                    orientation2 = (Orientation) dragGestureDetectorKt$verticalDrag$1.L$2;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$1;
                    Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$verticalDrag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$1;
                    function12 = function13;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            awaitPointerEventScope4 = awaitPointerEventScope3;
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i3);
                        awaitPointerEventScope4 = awaitPointerEventScope3;
                        if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)) {
                            break;
                        }
                        i3++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == 0) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(i4);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                i4++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                longRef.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                awaitPointerEventScope3 = awaitPointerEventScope4;
                                awaitPointerEventScope2 = awaitPointerEventScope5;
                                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
                                i2 = 1;
                                pointerEventPass = null;
                                dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                                dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                                dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                                dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                                dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                                dragGestureDetectorKt$verticalDrag$12.label = i2;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$14 = dragGestureDetectorKt$verticalDrag$12;
                                awaitPointerEventScope5 = awaitPointerEventScope2;
                                obj = awaitPointerEvent$default;
                                dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$14;
                            }
                        } else {
                            long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3);
                            if (orientation2 == null) {
                                intBitsToFloat = Offset.m5101getDistanceimpl(positionChangeIgnoreConsumed);
                            } else {
                                intBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? positionChangeIgnoreConsumed & 4294967295L : positionChangeIgnoreConsumed >> 32));
                            }
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i32 = 0;
                        while (true) {
                            if (i32 < size3) {
                            }
                            i32++;
                            awaitPointerEventScope3 = awaitPointerEventScope4;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == 0) {
                            pointerInputChange32 = 0;
                        }
                    }
                    if (pointerInputChange32 == 0 || pointerInputChange32.isConsumed()) {
                        pointerEventPass = null;
                    } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange32)) {
                        pointerEventPass = pointerInputChange32;
                    } else {
                        function12.invoke(pointerInputChange32);
                        orientation = orientation2;
                        j2 = pointerInputChange32.m6682getIdJ3iCeTQ();
                        awaitPointerEventScope2 = awaitPointerEventScope5;
                        dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
                        i2 = 1;
                        pointerEventPass = null;
                        Ref.LongRef longRef22 = new Ref.LongRef();
                        longRef22.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        orientation2 = orientation;
                        longRef = longRef22;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                        dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                        dragGestureDetectorKt$verticalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerEventPass == null);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
        Object obj2 = dragGestureDetectorKt$verticalDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$verticalDrag$1.label;
        int i22 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) & 4294967295L)) == 0.0f ? 1 : 0) == 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please submit an issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m501awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
                if (i == 0) {
                    if (i == 1) {
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 < size) {
                                pointerInputChange = null;
                                break;
                            }
                            pointerInputChange = changes.get(i2);
                            if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef2.element)) {
                                break;
                            }
                            i2++;
                        }
                        PointerInputChange pointerInputChange3 = pointerInputChange;
                        if (pointerInputChange3 == null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                int size2 = changes2.size();
                                while (true) {
                                    if (r9 >= size2) {
                                        pointerInputChange2 = null;
                                        break;
                                    }
                                    pointerInputChange2 = changes2.get(r9);
                                    if (pointerInputChange2.getPressed()) {
                                        break;
                                    }
                                    r9++;
                                }
                                PointerInputChange pointerInputChange4 = pointerInputChange2;
                                if (pointerInputChange4 != null) {
                                    longRef2.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                    longRef = longRef2;
                                }
                            }
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Ref.LongRef longRef3 = longRef;
                            obj = awaitPointerEvent$default;
                            longRef2 = longRef3;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                            int size3 = changes3.size();
                            int i22 = 0;
                            while (true) {
                                if (i22 < size3) {
                                }
                                i22++;
                            }
                            PointerInputChange pointerInputChange32 = pointerInputChange;
                            if (pointerInputChange32 == null) {
                                pointerInputChange32 = null;
                            }
                        }
                        if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                            return null;
                        }
                        return pointerInputChange32;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    Offset offset = (Offset) obj2;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0176 -> B:20:0x00ab). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0196 -> B:61:0x019b). Please submit an issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m495awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        int i;
        float m509pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i2;
        Object obj;
        Object obj2;
        PointerInputChange pointerInputChange;
        int i3;
        Object obj3;
        int i4;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj4 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
                int i5 = 1;
                PointerEventPass pointerEventPass = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    int m6765getTouchT8wyACA = PointerType.Companion.m6765getTouchT8wyACA();
                    Orientation orientation = Orientation.Horizontal;
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m6765getTouchT8wyACA);
                    longRef = new Ref.LongRef();
                    longRef.element = j;
                    TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, m5119getZeroF1C5BW0, null);
                    function22 = function2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector3;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i5, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    float f2 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
                    ResultKt.throwOnFailure(obj4);
                    f = f2;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
                    function22 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                    PointerEvent pointerEvent = (PointerEvent) obj4;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    int i6 = 0;
                    i2 = 0;
                    while (true) {
                        if (i2 < size) {
                        }
                        i2++;
                        size = i4;
                        pointerEventPass = obj;
                    }
                    pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange != null) {
                        return obj;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    }
                    i5 = i3;
                    touchSlopDetector = touchSlopDetector2;
                    m509pointerSlopE8SPZFQ = f;
                    pointerEventPass = null;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i5, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 2) {
                    float f3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4;
                    TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector4;
                    char c = 2;
                    int i7 = 1;
                    m509pointerSlopE8SPZFQ = f3;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
                    if (pointerInputChange2.isConsumed()) {
                        i5 = i7;
                        function22 = function23;
                        pointerEventPass = null;
                        longRef = longRef2;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i5;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i5, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            f = m509pointerSlopE8SPZFQ;
                            touchSlopDetector2 = touchSlopDetector;
                            obj4 = awaitPointerEvent$default;
                            PointerEvent pointerEvent2 = (PointerEvent) obj4;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            int i62 = 0;
                            i2 = 0;
                            while (true) {
                                if (i2 < size) {
                                    obj = pointerEventPass;
                                    obj2 = obj;
                                    break;
                                }
                                obj2 = changes2.get(i2);
                                obj = pointerEventPass;
                                i4 = size;
                                if (PointerId.m6664equalsimpl0(((PointerInputChange) obj2).m6682getIdJ3iCeTQ(), longRef.element)) {
                                    break;
                                }
                                i2++;
                                size = i4;
                                pointerEventPass = obj;
                            }
                            pointerInputChange = (PointerInputChange) obj2;
                            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                                return obj;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                while (true) {
                                    if (i62 >= size2) {
                                        obj3 = obj;
                                        break;
                                    }
                                    obj3 = changes3.get(i62);
                                    if (((PointerInputChange) obj3).getPressed()) {
                                        break;
                                    }
                                    i62++;
                                }
                                PointerInputChange pointerInputChange3 = (PointerInputChange) obj3;
                                if (pointerInputChange3 == null) {
                                    return obj;
                                }
                                longRef.element = pointerInputChange3.m6682getIdJ3iCeTQ();
                                i3 = 1;
                            } else {
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (m635getPostSlopOffsetqto3Fdw$default >> 32))));
                                    if (pointerInputChange.isConsumed()) {
                                        return pointerInputChange;
                                    }
                                    i3 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, obj);
                                } else {
                                    i7 = 1;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                                    c = 2;
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 2;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12) != coroutine_suspended) {
                                        longRef2 = longRef;
                                        m509pointerSlopE8SPZFQ = f;
                                        function23 = function22;
                                        pointerInputChange2 = pointerInputChange;
                                        touchSlopDetector = touchSlopDetector2;
                                        if (pointerInputChange2.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            i5 = i3;
                            touchSlopDetector = touchSlopDetector2;
                            m509pointerSlopE8SPZFQ = f;
                            pointerEventPass = null;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i5, pointerEventPass);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
        Object obj42 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
        int i52 = 1;
        PointerEventPass pointerEventPass3 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x016d -> B:20:0x00a2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x018d -> B:61:0x0191). Please submit an issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m494awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        int i2;
        float m509pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i3;
        Object obj;
        Object obj2;
        PointerInputChange pointerInputChange;
        int i4;
        Object obj3;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
                int i6 = 1;
                PointerEventPass pointerEventPass = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj4);
                    Orientation orientation = Orientation.Horizontal;
                    long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    longRef = new Ref.LongRef();
                    longRef.element = j;
                    function22 = function2;
                    touchSlopDetector = new TouchSlopDetector(orientation, m5119getZeroF1C5BW0, null);
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 1) {
                    float f2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
                    ResultKt.throwOnFailure(obj4);
                    f = f2;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
                    longRef = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
                    function22 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
                    PointerEvent pointerEvent = (PointerEvent) obj4;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    int i7 = 0;
                    i3 = 0;
                    while (true) {
                        if (i3 < size) {
                        }
                        i3++;
                        size = i5;
                        pointerEventPass = obj;
                    }
                    pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange != null) {
                        return obj;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    }
                    i6 = i4;
                    touchSlopDetector = touchSlopDetector2;
                    m509pointerSlopE8SPZFQ = f;
                    pointerEventPass = null;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 2) {
                    float f3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj4);
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
                    int i8 = 1;
                    m509pointerSlopE8SPZFQ = f3;
                    char c = 2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
                    if (pointerInputChange2.isConsumed()) {
                        function22 = function23;
                        pointerEventPass = null;
                        i6 = i8;
                        longRef = longRef2;
                        touchSlopDetector = touchSlopDetector2;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i6;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i6, pointerEventPass);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            touchSlopDetector2 = touchSlopDetector;
                            f = m509pointerSlopE8SPZFQ;
                            obj4 = awaitPointerEvent$default;
                            PointerEvent pointerEvent2 = (PointerEvent) obj4;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            int i72 = 0;
                            i3 = 0;
                            while (true) {
                                if (i3 < size) {
                                    obj = pointerEventPass;
                                    obj2 = obj;
                                    break;
                                }
                                obj2 = changes2.get(i3);
                                obj = pointerEventPass;
                                i5 = size;
                                if (PointerId.m6664equalsimpl0(((PointerInputChange) obj2).m6682getIdJ3iCeTQ(), longRef.element)) {
                                    break;
                                }
                                i3++;
                                size = i5;
                                pointerEventPass = obj;
                            }
                            pointerInputChange = (PointerInputChange) obj2;
                            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                                return obj;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                while (true) {
                                    if (i72 >= size2) {
                                        obj3 = obj;
                                        break;
                                    }
                                    obj3 = changes3.get(i72);
                                    if (((PointerInputChange) obj3).getPressed()) {
                                        break;
                                    }
                                    i72++;
                                }
                                PointerInputChange pointerInputChange3 = (PointerInputChange) obj3;
                                if (pointerInputChange3 == null) {
                                    return obj;
                                }
                                longRef.element = pointerInputChange3.m6682getIdJ3iCeTQ();
                                i4 = 1;
                            } else {
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange), f, false, 4, null);
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (m635getPostSlopOffsetqto3Fdw$default >> 32))));
                                    if (pointerInputChange.isConsumed()) {
                                        return pointerInputChange;
                                    }
                                    i4 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector2, 0L, 1, obj);
                                } else {
                                    i8 = 1;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector2;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = f;
                                    c = 2;
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = 2;
                                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) != coroutine_suspended) {
                                        longRef2 = longRef;
                                        function23 = function22;
                                        pointerInputChange2 = pointerInputChange;
                                        m509pointerSlopE8SPZFQ = f;
                                        if (pointerInputChange2.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            i6 = i4;
                            touchSlopDetector = touchSlopDetector2;
                            m509pointerSlopE8SPZFQ = f;
                            pointerEventPass = null;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i6;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i6, pointerEventPass);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
        Object obj42 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i62 = 1;
        PointerEventPass pointerEventPass3 = null;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
        if ((r0 == 0.0f) == false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please submit an issue!!! */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m507horizontalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        int i;
        long j2;
        Orientation orientation;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object awaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float intBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            if ((dragGestureDetectorKt$horizontalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$horizontalDrag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$horizontalDrag$1.label;
                int i2 = 1;
                PointerEventPass pointerEventPass = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Orientation orientation3 = Orientation.Horizontal;
                    j2 = j;
                    if (!m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        orientation = orientation3;
                        dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        function12 = function1;
                        Ref.LongRef longRef2 = new Ref.LongRef();
                        longRef2.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        orientation2 = orientation;
                        longRef = longRef2;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                        dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                        dragGestureDetectorKt$horizontalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerEventPass == null);
                } else if (i == 1) {
                    longRef = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$1.L$4;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$3;
                    orientation2 = (Orientation) dragGestureDetectorKt$horizontalDrag$1.L$2;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$1;
                    Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$horizontalDrag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$1;
                    function12 = function13;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            awaitPointerEventScope4 = awaitPointerEventScope3;
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i3);
                        awaitPointerEventScope4 = awaitPointerEventScope3;
                        if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)) {
                            break;
                        }
                        i3++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == 0) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(i4);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                i4++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                longRef.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                awaitPointerEventScope3 = awaitPointerEventScope4;
                                awaitPointerEventScope2 = awaitPointerEventScope5;
                                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
                                i2 = 1;
                                pointerEventPass = null;
                                dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                                dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                                dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                                dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                                dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                                dragGestureDetectorKt$horizontalDrag$12.label = i2;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$14 = dragGestureDetectorKt$horizontalDrag$12;
                                awaitPointerEventScope5 = awaitPointerEventScope2;
                                obj = awaitPointerEvent$default;
                                dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$14;
                            }
                        } else {
                            long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3);
                            if (orientation2 == null) {
                                intBitsToFloat = Offset.m5101getDistanceimpl(positionChangeIgnoreConsumed);
                            } else {
                                intBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? positionChangeIgnoreConsumed & 4294967295L : positionChangeIgnoreConsumed >> 32));
                            }
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i32 = 0;
                        while (true) {
                            if (i32 < size3) {
                            }
                            i32++;
                            awaitPointerEventScope3 = awaitPointerEventScope4;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == 0) {
                            pointerInputChange32 = 0;
                        }
                    }
                    if (pointerInputChange32 == 0 || pointerInputChange32.isConsumed()) {
                        pointerEventPass = null;
                    } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange32)) {
                        pointerEventPass = pointerInputChange32;
                    } else {
                        function12.invoke(pointerInputChange32);
                        orientation = orientation2;
                        j2 = pointerInputChange32.m6682getIdJ3iCeTQ();
                        awaitPointerEventScope2 = awaitPointerEventScope5;
                        dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
                        i2 = 1;
                        pointerEventPass = null;
                        Ref.LongRef longRef22 = new Ref.LongRef();
                        longRef22.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        orientation2 = orientation;
                        longRef = longRef22;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                        dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                        dragGestureDetectorKt$horizontalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerEventPass == null);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
        Object obj2 = dragGestureDetectorKt$horizontalDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$horizontalDrag$1.label;
        int i22 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) >> 32)) == 0.0f ? 1 : 0) == 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please submit an issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m493awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
                if (i == 0) {
                    if (i == 1) {
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 < size) {
                                pointerInputChange = null;
                                break;
                            }
                            pointerInputChange = changes.get(i2);
                            if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef2.element)) {
                                break;
                            }
                            i2++;
                        }
                        PointerInputChange pointerInputChange3 = pointerInputChange;
                        if (pointerInputChange3 == null) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                int size2 = changes2.size();
                                while (true) {
                                    if (r9 >= size2) {
                                        pointerInputChange2 = null;
                                        break;
                                    }
                                    pointerInputChange2 = changes2.get(r9);
                                    if (pointerInputChange2.getPressed()) {
                                        break;
                                    }
                                    r9++;
                                }
                                PointerInputChange pointerInputChange4 = pointerInputChange2;
                                if (pointerInputChange4 != null) {
                                    longRef2.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                    longRef = longRef2;
                                }
                            }
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Ref.LongRef longRef3 = longRef;
                            obj = awaitPointerEvent$default;
                            longRef2 = longRef3;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                            int size3 = changes3.size();
                            int i22 = 0;
                            while (true) {
                                if (i22 < size3) {
                                }
                                i22++;
                            }
                            PointerInputChange pointerInputChange32 = pointerInputChange;
                            if (pointerInputChange32 == null) {
                                pointerInputChange32 = null;
                            }
                        }
                        if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                            return null;
                        }
                        return pointerInputChange32;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit unit;
                    Offset offset = (Offset) obj2;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        if ((r0 == 0.0f) == false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008e -> B:23:0x0094). Please submit an issue!!! */
    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m504dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$2;
        int i;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope2;
        Orientation orientation2;
        Function1<? super PointerInputChange, Boolean> function13;
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$22;
        Function1<? super PointerInputChange, Unit> function14;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object awaitPointerEvent$default;
        Object obj;
        Object obj2;
        float intBitsToFloat;
        Object obj3;
        int i2;
        if (continuation instanceof DragGestureDetectorKt$drag$2) {
            dragGestureDetectorKt$drag$2 = (DragGestureDetectorKt$drag$2) continuation;
            if ((dragGestureDetectorKt$drag$2.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$2.label -= Integer.MIN_VALUE;
                Object obj4 = dragGestureDetectorKt$drag$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$drag$2.label;
                int i3 = 1;
                PointerEventPass pointerEventPass = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    j2 = j;
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        return null;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    orientation2 = orientation;
                    function13 = function12;
                    dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
                    function14 = function1;
                    longRef = new Ref.LongRef();
                    longRef.element = j2;
                    awaitPointerEventScope3 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$1 = function14;
                    dragGestureDetectorKt$drag$22.L$2 = orientation2;
                    dragGestureDetectorKt$drag$22.L$3 = function13;
                    dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                    dragGestureDetectorKt$drag$22.L$5 = longRef;
                    dragGestureDetectorKt$drag$22.label = i3;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$drag$22, i3, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$4;
                    Function1<? super PointerInputChange, Boolean> function15 = (Function1) dragGestureDetectorKt$drag$2.L$3;
                    Function1<? super PointerInputChange, Unit> function16 = (Function1) dragGestureDetectorKt$drag$2.L$1;
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$0;
                    ResultKt.throwOnFailure(obj4);
                    dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
                    function14 = function16;
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$drag$2.L$5;
                    orientation2 = (Orientation) dragGestureDetectorKt$drag$2.L$2;
                    function13 = function15;
                    PointerEvent pointerEvent = (PointerEvent) obj4;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size) {
                            obj = pointerEventPass;
                            obj2 = obj;
                            break;
                        }
                        obj2 = changes.get(i4);
                        obj = pointerEventPass;
                        i2 = i4;
                        if (PointerId.m6664equalsimpl0(((PointerInputChange) obj2).m6682getIdJ3iCeTQ(), longRef2.element)) {
                            break;
                        }
                        i4 = i2 + 1;
                        pointerEventPass = obj;
                    }
                    PointerInputChange pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange == 0) {
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange);
                            if (orientation2 == null) {
                                intBitsToFloat = Offset.m5101getDistanceimpl(positionChangeIgnoreConsumed);
                            } else if (orientation2 == Orientation.Vertical) {
                                intBitsToFloat = Float.intBitsToFloat((int) (positionChangeIgnoreConsumed & 4294967295L));
                            } else {
                                intBitsToFloat = Float.intBitsToFloat((int) (positionChangeIgnoreConsumed >> 32));
                            }
                        } else {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    obj3 = obj;
                                    break;
                                }
                                obj3 = changes2.get(i5);
                                if (((PointerInputChange) obj3).getPressed()) {
                                    break;
                                }
                                i5++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj3;
                            if (pointerInputChange2 != null) {
                                longRef2.element = pointerInputChange2.m6682getIdJ3iCeTQ();
                                awaitPointerEventScope2 = awaitPointerEventScope4;
                                pointerEventPass = obj;
                                i3 = 1;
                                longRef = longRef2;
                                dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                                dragGestureDetectorKt$drag$22.L$1 = function14;
                                dragGestureDetectorKt$drag$22.L$2 = orientation2;
                                dragGestureDetectorKt$drag$22.L$3 = function13;
                                dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                                dragGestureDetectorKt$drag$22.L$5 = longRef;
                                dragGestureDetectorKt$drag$22.label = i3;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$drag$22, i3, pointerEventPass);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Ref.LongRef longRef3 = longRef;
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                obj4 = awaitPointerEvent$default;
                                longRef2 = longRef3;
                            }
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) obj4;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i42 = 0;
                        while (true) {
                            if (i42 < size3) {
                            }
                            i42 = i2 + 1;
                            pointerEventPass = obj;
                        }
                        PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                        if (pointerInputChange3 == 0) {
                            pointerInputChange3 = obj;
                        }
                    }
                    if (pointerInputChange3 == 0 || function13.invoke(pointerInputChange3).booleanValue()) {
                        return obj;
                    }
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                        return pointerInputChange3;
                    }
                    function14.invoke(pointerInputChange3);
                    j2 = pointerInputChange3.m6682getIdJ3iCeTQ();
                    awaitPointerEventScope2 = awaitPointerEventScope4;
                    pointerEventPass = obj;
                    i3 = 1;
                    longRef = new Ref.LongRef();
                    longRef.element = j2;
                    awaitPointerEventScope3 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$1 = function14;
                    dragGestureDetectorKt$drag$22.L$2 = orientation2;
                    dragGestureDetectorKt$drag$22.L$3 = function13;
                    dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                    dragGestureDetectorKt$drag$22.L$5 = longRef;
                    dragGestureDetectorKt$drag$22.label = i3;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$drag$22, i3, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                }
            }
        }
        dragGestureDetectorKt$drag$2 = new DragGestureDetectorKt$drag$2(continuation);
        Object obj42 = dragGestureDetectorKt$drag$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$drag$2.label;
        int i32 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: drag-VnAYq1g$$forInline  reason: not valid java name */
    private static final Object m505dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long j2 = j;
        if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (r9 >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(r9);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        r9++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                } else {
                    long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(1 ^ ((orientation == null ? Offset.m5101getDistanceimpl(positionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Float.intBitsToFloat((int) (positionChangeIgnoreConsumed & 4294967295L)) : Float.intBitsToFloat((int) (positionChangeIgnoreConsumed >> 32))) == 0.0f ? 1 : 0)).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.m6682getIdJ3iCeTQ();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m492awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.m6682getIdJ3iCeTQ();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0174 -> B:66:0x01a1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0193 -> B:62:0x0197). Please submit an issue!!! */
    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m497awaitPointerSlopOrCancellation6ksA65w(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        int i2;
        float m509pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        TouchSlopDetector touchSlopDetector2;
        float f;
        Ref.LongRef longRef3;
        int size;
        int i3;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        TouchSlopDetector touchSlopDetector3;
        int i4;
        PointerInputChange pointerInputChange3;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
                int i6 = 1;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = j;
                    function22 = function2;
                    longRef = longRef4;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                    touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 1) {
                    f = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
                    touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
                    function23 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                    longRef3 = longRef2;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i3 = 0;
                    while (true) {
                        if (i3 < size) {
                        }
                        i3 = i5 + 1;
                    }
                    pointerInputChange2 = pointerInputChange;
                    if (pointerInputChange2 != null) {
                        return null;
                    }
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    }
                    function22 = function23;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    longRef = longRef3;
                    touchSlopDetector = touchSlopDetector3;
                    i6 = i4;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 2) {
                    float f2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
                    TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
                    ResultKt.throwOnFailure(obj);
                    pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$4;
                    char c = 2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                    touchSlopDetector = touchSlopDetector4;
                    m509pointerSlopE8SPZFQ = f2;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
                    i4 = 1;
                    Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
                    function23 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
                    if (pointerInputChange2.isConsumed()) {
                        function22 = function23;
                        longRef = longRef5;
                        i6 = i4;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            f = m509pointerSlopE8SPZFQ;
                            obj = awaitPointerEvent$default;
                            longRef2 = longRef;
                            function23 = function22;
                            touchSlopDetector2 = touchSlopDetector;
                            longRef3 = longRef2;
                            PointerEvent pointerEvent2 = (PointerEvent) obj;
                            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                            size = changes2.size();
                            i3 = 0;
                            while (true) {
                                if (i3 < size) {
                                    pointerInputChange = null;
                                    break;
                                }
                                pointerInputChange = changes2.get(i3);
                                i5 = i3;
                                if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef3.element)) {
                                    break;
                                }
                                i3 = i5 + 1;
                            }
                            pointerInputChange2 = pointerInputChange;
                            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                                return null;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                int size2 = changes3.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= size2) {
                                        pointerInputChange3 = null;
                                        break;
                                    }
                                    pointerInputChange3 = changes3.get(i7);
                                    if (pointerInputChange3.getPressed()) {
                                        break;
                                    }
                                    i7++;
                                }
                                PointerInputChange pointerInputChange4 = pointerInputChange3;
                                if (pointerInputChange4 == null) {
                                    return null;
                                }
                                longRef3.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                                m509pointerSlopE8SPZFQ = f;
                                touchSlopDetector3 = touchSlopDetector2;
                                i4 = 1;
                            } else {
                                float f3 = f;
                                TouchSlopDetector touchSlopDetector5 = touchSlopDetector2;
                                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector5, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2), f3, false, 4, null);
                                touchSlopDetector3 = touchSlopDetector5;
                                m509pointerSlopE8SPZFQ = f3;
                                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    function23.invoke(pointerInputChange2, Offset.m5092boximpl(m635getPostSlopOffsetqto3Fdw$default));
                                    if (pointerInputChange2.isConsumed()) {
                                        return pointerInputChange2;
                                    }
                                    i4 = 1;
                                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector3, 0L, 1, null);
                                } else {
                                    i4 = 1;
                                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope3;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function23;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef3;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector3;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerInputChange2;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                                    c = 2;
                                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 2;
                                    if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12) != coroutine_suspended) {
                                        longRef5 = longRef3;
                                        touchSlopDetector = touchSlopDetector3;
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        if (pointerInputChange2.isConsumed()) {
                                        }
                                    }
                                }
                            }
                            function22 = function23;
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            longRef = longRef3;
                            touchSlopDetector = touchSlopDetector3;
                            i6 = i4;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = m509pointerSlopE8SPZFQ;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return null;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
        int i62 = 1;
        if (i2 != 0) {
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w$default  reason: not valid java name */
    public static /* synthetic */ Object m499awaitPointerSlopOrCancellation6ksA65w$default(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2 function2, Continuation continuation, int i2, Object obj) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        long m5119getZeroF1C5BW0 = (i2 & 8) != 0 ? Offset.Companion.m5119getZeroF1C5BW0() : j2;
        long j3 = j;
        if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j3)) {
            return null;
        }
        float m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, m5119getZeroF1C5BW0, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), j3)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                j3 = pointerInputChange4.m6682getIdJ3iCeTQ();
            } else {
                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3), m509pointerSlopE8SPZFQ, false, 4, null);
                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m5092boximpl(m635getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w$$forInline  reason: not valid java name */
    private static final Object m498awaitPointerSlopOrCancellation6ksA65w$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                int i3 = i2;
                if (Boolean.valueOf(PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), longRef.element)).booleanValue()) {
                    break;
                }
                i2 = i3 + 1;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.m6682getIdJ3iCeTQ();
            } else {
                long m635getPostSlopOffsetqto3Fdw$default = TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3), m509pointerSlopE8SPZFQ, false, 4, null);
                if ((9223372034707292159L & m635getPostSlopOffsetqto3Fdw$default) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m5092boximpl(m635getPostSlopOffsetqto3Fdw$default));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m636resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011f A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009b -> B:23:0x00a1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUpWithSlopDetection(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1;
        int i;
        Ref.LongRef longRef;
        int i2;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12;
        PointerEventPass pointerEventPass2;
        Object awaitPointerEvent;
        float f2;
        PointerInputChange pointerInputChange2;
        float f3;
        int size;
        int i3;
        PointerInputChange pointerInputChange3;
        PointerInputChange pointerInputChange4;
        int size2;
        int i4;
        if (continuation instanceof DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1) {
            dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 = (DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1) continuation;
            if ((dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.label;
                int i5 = 0;
                int i6 = 1;
                if (i == 0) {
                    if (i == 1) {
                        float f4 = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.F$0;
                        int i7 = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.I$0;
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        float f5 = f4;
                        TouchSlopDetector touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.L$3;
                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12 = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1;
                        pointerEventPass2 = (PointerEventPass) dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.L$1;
                        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.L$2;
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size3 = changes.size();
                        int i8 = i5;
                        while (true) {
                            if (i8 < size3) {
                                f2 = f5;
                                pointerInputChange2 = null;
                                break;
                            }
                            pointerInputChange2 = changes.get(i8);
                            f2 = f5;
                            if (PointerId.m6664equalsimpl0(pointerInputChange2.m6682getIdJ3iCeTQ(), longRef.element)) {
                                break;
                            }
                            i8++;
                            f5 = f2;
                        }
                        PointerInputChange pointerInputChange5 = pointerInputChange2;
                        if (pointerInputChange5 != null || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange5)) {
                            f3 = f2;
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size = changes2.size();
                            i3 = 0;
                            while (true) {
                                if (i3 < size) {
                                    pointerInputChange3 = null;
                                    break;
                                }
                                PointerInputChange pointerInputChange6 = changes2.get(i3);
                                if (pointerInputChange6.getPressed()) {
                                    pointerInputChange3 = pointerInputChange6;
                                    break;
                                }
                                i3++;
                            }
                            pointerInputChange4 = pointerInputChange3;
                            if (pointerInputChange4 != null) {
                                return Boxing.boxBoolean(i7 != 0);
                            }
                            longRef.element = pointerInputChange4.m6682getIdJ3iCeTQ();
                        } else {
                            f3 = f2;
                            if ((TouchSlopDetector.m635getPostSlopOffsetqto3Fdw$default(touchSlopDetector2, PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange5), f3, false, 4, null) & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                i2 = 1;
                                List<PointerInputChange> changes3 = pointerEvent.getChanges();
                                size2 = changes3.size();
                                for (i4 = 0; i4 < size2; i4++) {
                                    if (changes3.get(i4).getPressed()) {
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        touchSlopDetector = touchSlopDetector2;
                                        f = f3;
                                        i5 = 0;
                                        i6 = 1;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$0 = awaitPointerEventScope2;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$1 = pointerEventPass2;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$2 = longRef;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$3 = touchSlopDetector;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.I$0 = i2;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.F$0 = f;
                                        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.label = i6;
                                        awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12);
                                        if (awaitPointerEvent != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        awaitPointerEventScope3 = awaitPointerEventScope2;
                                        obj = awaitPointerEvent;
                                        f5 = f;
                                        i7 = i2;
                                        touchSlopDetector2 = touchSlopDetector;
                                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                        int size32 = changes4.size();
                                        int i82 = i5;
                                        while (true) {
                                            if (i82 < size32) {
                                            }
                                            i82++;
                                            f5 = f2;
                                        }
                                        PointerInputChange pointerInputChange52 = pointerInputChange2;
                                        if (pointerInputChange52 != null) {
                                        }
                                        f3 = f2;
                                        List<PointerInputChange> changes22 = pointerEvent2.getChanges();
                                        size = changes22.size();
                                        i3 = 0;
                                        while (true) {
                                            if (i3 < size) {
                                            }
                                            i3++;
                                        }
                                        pointerInputChange4 = pointerInputChange3;
                                        if (pointerInputChange4 != null) {
                                        }
                                    }
                                }
                                return Boxing.boxBoolean(i2 == 0);
                            }
                        }
                        i2 = i7;
                        List<PointerInputChange> changes32 = pointerEvent2.getChanges();
                        size2 = changes32.size();
                        while (i4 < size2) {
                        }
                        return Boxing.boxBoolean(i2 == 0);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (ForEachGestureKt.allPointersUp(awaitPointerEventScope)) {
                    return Boxing.boxBoolean(false);
                }
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = pointerInputChange.m6682getIdJ3iCeTQ();
                float m509pointerSlopE8SPZFQ = m509pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.m6688getTypeT8wyACA());
                longRef = longRef2;
                i2 = 0;
                touchSlopDetector = new TouchSlopDetector(null, 0L, 3, null);
                awaitPointerEventScope2 = awaitPointerEventScope;
                f = m509pointerSlopE8SPZFQ;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12 = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1;
                pointerEventPass2 = pointerEventPass;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$1 = pointerEventPass2;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$2 = longRef;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.L$3 = touchSlopDetector;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.I$0 = i2;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.F$0 = f;
                dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12.label = i6;
                awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$12);
                if (awaitPointerEvent != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 = new DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1.label;
        int i52 = 0;
        int i62 = 1;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitAllPointersUpWithSlopDetection(awaitPointerEventScope, pointerInputChange, pointerEventPass, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0 A[Catch: PointerEventTimeoutCancellationException -> 0x00b9, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x00b9, blocks: (B:12:0x0033, B:34:0x00ac, B:36:0x00b0, B:30:0x0090), top: B:46:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[RETURN] */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v3, types: [androidx.compose.ui.input.pointer.PointerInputChange, T, java.lang.Object] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m496awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        int i;
        PointerInputChange pointerInputChange;
        Ref.BooleanRef booleanRef;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
                if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                    dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
                    Object obj = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (m508isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                            return null;
                        }
                        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                pointerInputChange = null;
                                break;
                            }
                            pointerInputChange = changes.get(i2);
                            if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), j)) {
                                break;
                            }
                            i2++;
                        }
                        PointerInputChange pointerInputChange3 = pointerInputChange;
                        if (pointerInputChange3 == 0) {
                            return null;
                        }
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = pointerInputChange3;
                        long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange3;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2 = booleanRef2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                        if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new DragGestureDetectorKt$awaitLongPressOrCancellation$2(booleanRef2, objectRef2, objectRef, null), dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef = booleanRef2;
                        j = objectRef;
                        pointerInputChange2 = pointerInputChange3;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        booleanRef = (Ref.BooleanRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        j = objectRef3;
                        pointerInputChange2 = pointerInputChange4;
                    }
                    if (booleanRef.element) {
                        return null;
                    }
                    PointerInputChange pointerInputChange5 = (PointerInputChange) j.element;
                    return pointerInputChange5 == null ? pointerInputChange2 : pointerInputChange5;
                }
            }
            if (i != 0) {
            }
            if (booleanRef.element) {
            }
        } catch (PointerEventTimeoutCancellationException unused) {
            PointerInputChange pointerInputChange6 = (PointerInputChange) j.element;
            return pointerInputChange6 == null ? pointerInputChange2 : pointerInputChange6;
        }
        dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m508isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m6664equalsimpl0(pointerInputChange.m6682getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m509pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m6758equalsimpl0(i, PointerType.Companion.m6763getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    static {
        float m8160constructorimpl = Dp.m8160constructorimpl(0.125f);
        mouseSlop = m8160constructorimpl;
        float m8160constructorimpl2 = Dp.m8160constructorimpl(18.0f);
        defaultTouchSlop = m8160constructorimpl2;
        mouseToTouchSlopRatio = m8160constructorimpl / m8160constructorimpl2;
    }
}
