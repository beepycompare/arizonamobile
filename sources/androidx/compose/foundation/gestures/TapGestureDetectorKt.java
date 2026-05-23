package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0093\u0001\u0010\u0011\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2-\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001d\u001a[\u0010\u001e\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"H\u0087@¢\u0006\u0002\u0010#\u001a&\u0010 \u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&\u001a&\u0010'\u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010&\u001a\u001e\u0010(\u001a\u00020\"*\u00020)2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\"H\u0000\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010+\u001a\u0004\u0018\u00010\u001b*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010,\u001a\u001c\u0010-\u001a\u00020.*\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%H\u0080@¢\u0006\u0002\u0010,\u001aL\u0010/\u001a\u000200*\u00020\u00142\u0006\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002032'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000605¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u00106\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u00067"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTapGesture", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pressScope", "Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/PressGestureScopeImpl;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "resetJob", TtmlNode.START, "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3 function3, Function1 function13, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        return detectTapGestures(pointerInputScope, function1, function12, function3, function13, continuation);
    }

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2(pointerInputScope, function1, function12, function3, function13, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x041f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object processTapGesture(AwaitPointerEventScope awaitPointerEventScope, CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        TapGestureDetectorKt$processTapGesture$1 tapGestureDetectorKt$processTapGesture$1;
        TapGestureDetectorKt$processTapGesture$1 tapGestureDetectorKt$processTapGesture$12;
        Function1<? super Offset, Unit> function14;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function32;
        Function1<? super Offset, Unit> function15;
        PressGestureScopeImpl pressGestureScopeImpl2;
        Function1<? super Offset, Unit> function16;
        AwaitPointerEventScope awaitPointerEventScope2;
        CoroutineScope coroutineScope2;
        PointerInputChange pointerInputChange;
        Job launch$default;
        Job job;
        Function1<? super Offset, Unit> function17;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function33;
        AwaitPointerEventScope awaitPointerEventScope3;
        PressGestureScopeImpl pressGestureScopeImpl3;
        Function1<? super Offset, Unit> function18;
        Function1<? super Offset, Unit> function19;
        Function1<? super Offset, Unit> function110;
        Function1<? super Offset, Unit> function111;
        AwaitPointerEventScope awaitPointerEventScope4;
        CoroutineScope coroutineScope3;
        PressGestureScopeImpl pressGestureScopeImpl4;
        Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function34;
        Function1<? super Offset, Unit> function112;
        PointerInputChange pointerInputChange2;
        Job launchAwaitingReset$default;
        PointerInputChange pointerInputChange3;
        AwaitPointerEventScope awaitPointerEventScope5;
        CoroutineScope coroutineScope4;
        Function1<? super Offset, Unit> function113;
        Function1<? super Offset, Unit> function114;
        Function1<? super Offset, Unit> function115;
        PressGestureScopeImpl pressGestureScopeImpl5;
        LongPressResult longPressResult;
        Job job2;
        CoroutineScope coroutineScope5;
        PressGestureScopeImpl pressGestureScopeImpl6;
        PointerInputChange pointerInputChange4;
        Job launch$default2;
        PointerInputChange pointerInputChange5;
        PointerInputChange pointerInputChange6;
        PressGestureScopeImpl pressGestureScopeImpl7;
        Function1<? super Offset, Unit> function116;
        Function1<? super Offset, Unit> function117;
        Function1<? super Offset, Unit> function118;
        CoroutineScope coroutineScope6;
        AwaitPointerEventScope awaitPointerEventScope6;
        PointerInputChange pointerInputChange7;
        Function1<? super Offset, Unit> function119;
        Function1<? super Offset, Unit> function120;
        CoroutineScope coroutineScope7;
        PointerInputChange pointerInputChange8;
        LongPressResult longPressResult2;
        Job job3;
        PressGestureScopeImpl pressGestureScopeImpl8;
        CoroutineScope coroutineScope8;
        if (continuation instanceof TapGestureDetectorKt$processTapGesture$1) {
            tapGestureDetectorKt$processTapGesture$1 = (TapGestureDetectorKt$processTapGesture$1) continuation;
            if ((tapGestureDetectorKt$processTapGesture$1.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$processTapGesture$1.label -= Integer.MIN_VALUE;
                tapGestureDetectorKt$processTapGesture$12 = tapGestureDetectorKt$processTapGesture$1;
                Object obj = tapGestureDetectorKt$processTapGesture$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tapGestureDetectorKt$processTapGesture$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        tapGestureDetectorKt$processTapGesture$12.L$0 = awaitPointerEventScope;
                        tapGestureDetectorKt$processTapGesture$12.L$1 = coroutineScope;
                        tapGestureDetectorKt$processTapGesture$12.L$2 = pressGestureScopeImpl;
                        tapGestureDetectorKt$processTapGesture$12.L$3 = function1;
                        function14 = function12;
                        tapGestureDetectorKt$processTapGesture$12.L$4 = function14;
                        function32 = function3;
                        tapGestureDetectorKt$processTapGesture$12.L$5 = function32;
                        function15 = function13;
                        tapGestureDetectorKt$processTapGesture$12.L$6 = function15;
                        tapGestureDetectorKt$processTapGesture$12.label = 1;
                        Object awaitFirstDown$default = awaitFirstDown$default(awaitPointerEventScope, false, null, tapGestureDetectorKt$processTapGesture$12, 3, null);
                        if (awaitFirstDown$default != coroutine_suspended) {
                            pressGestureScopeImpl2 = pressGestureScopeImpl;
                            function16 = function1;
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            coroutineScope2 = coroutineScope;
                            obj = awaitFirstDown$default;
                            pointerInputChange = (PointerInputChange) obj;
                            pointerInputChange.consume();
                            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                            if (function32 == NoPressGesture) {
                                launchAwaitingReset$default(coroutineScope2, launch$default, null, new TapGestureDetectorKt$processTapGesture$2(function32, pressGestureScopeImpl2, pointerInputChange, null), 2, null);
                                job = launch$default;
                            } else {
                                job = launch$default;
                            }
                            if (function14 != null) {
                                tapGestureDetectorKt$processTapGesture$12.L$0 = awaitPointerEventScope2;
                                tapGestureDetectorKt$processTapGesture$12.L$1 = coroutineScope2;
                                tapGestureDetectorKt$processTapGesture$12.L$2 = pressGestureScopeImpl2;
                                tapGestureDetectorKt$processTapGesture$12.L$3 = function16;
                                tapGestureDetectorKt$processTapGesture$12.L$4 = function14;
                                tapGestureDetectorKt$processTapGesture$12.L$5 = function32;
                                tapGestureDetectorKt$processTapGesture$12.L$6 = function15;
                                tapGestureDetectorKt$processTapGesture$12.L$7 = job;
                                tapGestureDetectorKt$processTapGesture$12.label = 2;
                                obj = waitForUpOrCancellation$default(awaitPointerEventScope2, null, tapGestureDetectorKt$processTapGesture$12, 1, null);
                                if (obj != coroutine_suspended) {
                                    PressGestureScopeImpl pressGestureScopeImpl9 = pressGestureScopeImpl2;
                                    function110 = function16;
                                    function111 = function14;
                                    awaitPointerEventScope4 = awaitPointerEventScope2;
                                    coroutineScope3 = coroutineScope2;
                                    pressGestureScopeImpl4 = pressGestureScopeImpl9;
                                    function34 = function32;
                                    function112 = function15;
                                    pointerInputChange2 = (PointerInputChange) obj;
                                    if (pointerInputChange2 == null) {
                                        launchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new TapGestureDetectorKt$processTapGesture$4(pressGestureScopeImpl4, null), 2, null);
                                    } else {
                                        pointerInputChange2.consume();
                                        launchAwaitingReset$default = launchAwaitingReset$default(coroutineScope3, job, null, new TapGestureDetectorKt$processTapGesture$5(pressGestureScopeImpl4, null), 2, null);
                                    }
                                    if (pointerInputChange2 != null) {
                                        if (function110 != null) {
                                            tapGestureDetectorKt$processTapGesture$12.L$0 = awaitPointerEventScope4;
                                            tapGestureDetectorKt$processTapGesture$12.L$1 = coroutineScope3;
                                            tapGestureDetectorKt$processTapGesture$12.L$2 = pressGestureScopeImpl4;
                                            tapGestureDetectorKt$processTapGesture$12.L$3 = function110;
                                            tapGestureDetectorKt$processTapGesture$12.L$4 = function111;
                                            tapGestureDetectorKt$processTapGesture$12.L$5 = function34;
                                            tapGestureDetectorKt$processTapGesture$12.L$6 = function112;
                                            tapGestureDetectorKt$processTapGesture$12.L$7 = pointerInputChange2;
                                            tapGestureDetectorKt$processTapGesture$12.L$8 = launchAwaitingReset$default;
                                            tapGestureDetectorKt$processTapGesture$12.label = 5;
                                            Object awaitSecondDown = awaitSecondDown(awaitPointerEventScope4, pointerInputChange2, tapGestureDetectorKt$processTapGesture$12);
                                            if (awaitSecondDown != coroutine_suspended) {
                                                Function1<? super Offset, Unit> function121 = function112;
                                                pointerInputChange3 = pointerInputChange2;
                                                obj = awaitSecondDown;
                                                awaitPointerEventScope5 = awaitPointerEventScope4;
                                                coroutineScope4 = coroutineScope3;
                                                function113 = function110;
                                                function114 = function121;
                                                PressGestureScopeImpl pressGestureScopeImpl10 = pressGestureScopeImpl4;
                                                function115 = function111;
                                                pressGestureScopeImpl5 = pressGestureScopeImpl10;
                                                pointerInputChange4 = (PointerInputChange) obj;
                                                if (pointerInputChange4 == null) {
                                                    launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$6(launchAwaitingReset$default, pressGestureScopeImpl5, null), 1, null);
                                                    if (function34 != NoPressGesture) {
                                                        launchAwaitingReset$default(coroutineScope4, launch$default2, null, new TapGestureDetectorKt$processTapGesture$7(function34, pressGestureScopeImpl5, pointerInputChange4, null), 2, null);
                                                    }
                                                    if (function115 == null) {
                                                        tapGestureDetectorKt$processTapGesture$12.L$0 = coroutineScope4;
                                                        tapGestureDetectorKt$processTapGesture$12.L$1 = pressGestureScopeImpl5;
                                                        tapGestureDetectorKt$processTapGesture$12.L$2 = function113;
                                                        tapGestureDetectorKt$processTapGesture$12.L$3 = function114;
                                                        tapGestureDetectorKt$processTapGesture$12.L$4 = launch$default2;
                                                        tapGestureDetectorKt$processTapGesture$12.L$5 = pointerInputChange3;
                                                        tapGestureDetectorKt$processTapGesture$12.L$6 = null;
                                                        tapGestureDetectorKt$processTapGesture$12.L$7 = null;
                                                        tapGestureDetectorKt$processTapGesture$12.L$8 = null;
                                                        tapGestureDetectorKt$processTapGesture$12.label = 6;
                                                        obj = waitForUpOrCancellation$default(awaitPointerEventScope5, null, tapGestureDetectorKt$processTapGesture$12, 1, null);
                                                        if (obj != coroutine_suspended) {
                                                            pointerInputChange7 = pointerInputChange3;
                                                            function119 = function114;
                                                            function120 = function113;
                                                            coroutineScope7 = coroutineScope4;
                                                            pointerInputChange8 = (PointerInputChange) obj;
                                                            if (pointerInputChange8 != null) {
                                                                pointerInputChange8.consume();
                                                                launchAwaitingReset$default(coroutineScope7, launch$default2, null, new TapGestureDetectorKt$processTapGesture$8(pressGestureScopeImpl5, null), 2, null);
                                                                function120.invoke(Offset.m5092boximpl(pointerInputChange8.m6685getPositionF1C5BW0()));
                                                            } else {
                                                                launchAwaitingReset$default(coroutineScope7, launch$default2, null, new TapGestureDetectorKt$processTapGesture$9(pressGestureScopeImpl5, null), 2, null);
                                                                if (function119 != null) {
                                                                    function119.invoke(Offset.m5092boximpl(pointerInputChange7.m6685getPositionF1C5BW0()));
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        tapGestureDetectorKt$processTapGesture$12.L$0 = awaitPointerEventScope5;
                                                        tapGestureDetectorKt$processTapGesture$12.L$1 = coroutineScope4;
                                                        tapGestureDetectorKt$processTapGesture$12.L$2 = pressGestureScopeImpl5;
                                                        tapGestureDetectorKt$processTapGesture$12.L$3 = function113;
                                                        tapGestureDetectorKt$processTapGesture$12.L$4 = function115;
                                                        tapGestureDetectorKt$processTapGesture$12.L$5 = function114;
                                                        tapGestureDetectorKt$processTapGesture$12.L$6 = launch$default2;
                                                        tapGestureDetectorKt$processTapGesture$12.L$7 = pointerInputChange3;
                                                        tapGestureDetectorKt$processTapGesture$12.L$8 = pointerInputChange4;
                                                        tapGestureDetectorKt$processTapGesture$12.label = 7;
                                                        Object waitForLongPress$default = waitForLongPress$default(awaitPointerEventScope5, null, tapGestureDetectorKt$processTapGesture$12, 1, null);
                                                        if (waitForLongPress$default != coroutine_suspended) {
                                                            PointerInputChange pointerInputChange9 = pointerInputChange3;
                                                            pointerInputChange5 = pointerInputChange4;
                                                            obj = waitForLongPress$default;
                                                            pointerInputChange6 = pointerInputChange9;
                                                            Function1<? super Offset, Unit> function122 = function115;
                                                            pressGestureScopeImpl7 = pressGestureScopeImpl5;
                                                            function116 = function114;
                                                            function117 = function122;
                                                            function118 = function113;
                                                            coroutineScope6 = coroutineScope4;
                                                            awaitPointerEventScope6 = awaitPointerEventScope5;
                                                            longPressResult2 = (LongPressResult) obj;
                                                            if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                                    pointerInputChange8 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                                                    pointerInputChange7 = pointerInputChange6;
                                                                    function119 = function116;
                                                                    function120 = function118;
                                                                } else if (!(longPressResult2 instanceof LongPressResult.Canceled)) {
                                                                    throw new NoWhenBranchMatchedException();
                                                                } else {
                                                                    pointerInputChange7 = pointerInputChange6;
                                                                    function119 = function116;
                                                                    function120 = function118;
                                                                    pointerInputChange8 = null;
                                                                }
                                                                pressGestureScopeImpl5 = pressGestureScopeImpl7;
                                                                coroutineScope7 = coroutineScope6;
                                                                if (pointerInputChange8 != null) {
                                                                }
                                                            } else {
                                                                function117.invoke(Offset.m5092boximpl(pointerInputChange5.m6685getPositionF1C5BW0()));
                                                                tapGestureDetectorKt$processTapGesture$12.L$0 = coroutineScope6;
                                                                tapGestureDetectorKt$processTapGesture$12.L$1 = pressGestureScopeImpl7;
                                                                tapGestureDetectorKt$processTapGesture$12.L$2 = launch$default2;
                                                                tapGestureDetectorKt$processTapGesture$12.L$3 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.L$4 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.L$5 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.L$6 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.L$7 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.L$8 = null;
                                                                tapGestureDetectorKt$processTapGesture$12.label = 8;
                                                                if (consumeUntilUp(awaitPointerEventScope6, tapGestureDetectorKt$processTapGesture$12) != coroutine_suspended) {
                                                                    job3 = launch$default2;
                                                                    pressGestureScopeImpl8 = pressGestureScopeImpl7;
                                                                    coroutineScope8 = coroutineScope6;
                                                                    launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (function114 != null) {
                                                    function114.invoke(Offset.m5092boximpl(pointerInputChange3.m6685getPositionF1C5BW0()));
                                                }
                                            }
                                        } else if (function112 != null) {
                                            function112.invoke(Offset.m5092boximpl(pointerInputChange2.m6685getPositionF1C5BW0()));
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else {
                                tapGestureDetectorKt$processTapGesture$12.L$0 = awaitPointerEventScope2;
                                tapGestureDetectorKt$processTapGesture$12.L$1 = coroutineScope2;
                                tapGestureDetectorKt$processTapGesture$12.L$2 = pressGestureScopeImpl2;
                                tapGestureDetectorKt$processTapGesture$12.L$3 = function16;
                                tapGestureDetectorKt$processTapGesture$12.L$4 = function14;
                                tapGestureDetectorKt$processTapGesture$12.L$5 = function32;
                                tapGestureDetectorKt$processTapGesture$12.L$6 = function15;
                                tapGestureDetectorKt$processTapGesture$12.L$7 = pointerInputChange;
                                tapGestureDetectorKt$processTapGesture$12.L$8 = job;
                                tapGestureDetectorKt$processTapGesture$12.label = 3;
                                obj = waitForLongPress$default(awaitPointerEventScope2, null, tapGestureDetectorKt$processTapGesture$12, 1, null);
                                if (obj != coroutine_suspended) {
                                    Function1<? super Offset, Unit> function123 = function14;
                                    function17 = function16;
                                    function33 = function32;
                                    awaitPointerEventScope3 = awaitPointerEventScope2;
                                    pressGestureScopeImpl3 = pressGestureScopeImpl2;
                                    function18 = function123;
                                    function19 = function15;
                                    longPressResult = (LongPressResult) obj;
                                    if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                                        if (longPressResult instanceof LongPressResult.Released) {
                                            pointerInputChange2 = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                                        } else if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                            throw new NoWhenBranchMatchedException();
                                        } else {
                                            pointerInputChange2 = null;
                                        }
                                        PressGestureScopeImpl pressGestureScopeImpl11 = pressGestureScopeImpl3;
                                        coroutineScope3 = coroutineScope2;
                                        pressGestureScopeImpl4 = pressGestureScopeImpl11;
                                        function112 = function19;
                                        function34 = function33;
                                        function111 = function18;
                                        function110 = function17;
                                        awaitPointerEventScope4 = awaitPointerEventScope3;
                                        if (pointerInputChange2 == null) {
                                        }
                                        if (pointerInputChange2 != null) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    function18.invoke(Offset.m5092boximpl(pointerInputChange.m6685getPositionF1C5BW0()));
                                    tapGestureDetectorKt$processTapGesture$12.L$0 = coroutineScope2;
                                    tapGestureDetectorKt$processTapGesture$12.L$1 = pressGestureScopeImpl3;
                                    tapGestureDetectorKt$processTapGesture$12.L$2 = job;
                                    tapGestureDetectorKt$processTapGesture$12.L$3 = null;
                                    tapGestureDetectorKt$processTapGesture$12.L$4 = null;
                                    tapGestureDetectorKt$processTapGesture$12.L$5 = null;
                                    tapGestureDetectorKt$processTapGesture$12.L$6 = null;
                                    tapGestureDetectorKt$processTapGesture$12.L$7 = null;
                                    tapGestureDetectorKt$processTapGesture$12.L$8 = null;
                                    tapGestureDetectorKt$processTapGesture$12.label = 4;
                                    if (consumeUntilUp(awaitPointerEventScope3, tapGestureDetectorKt$processTapGesture$12) != coroutine_suspended) {
                                        job2 = job;
                                        coroutineScope5 = coroutineScope2;
                                        pressGestureScopeImpl6 = pressGestureScopeImpl3;
                                        launchAwaitingReset$default(coroutineScope5, job2, null, new TapGestureDetectorKt$processTapGesture$3(pressGestureScopeImpl6, null), 2, null);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        function16 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        pressGestureScopeImpl2 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$2;
                        coroutineScope2 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        function15 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$6;
                        function32 = (Function3) tapGestureDetectorKt$processTapGesture$12.L$5;
                        function14 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$4;
                        pointerInputChange = (PointerInputChange) obj;
                        pointerInputChange.consume();
                        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, null), 1, null);
                        if (function32 == NoPressGesture) {
                        }
                        if (function14 != null) {
                        }
                        return coroutine_suspended;
                    case 2:
                        job = (Job) tapGestureDetectorKt$processTapGesture$12.L$7;
                        function112 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$6;
                        function34 = (Function3) tapGestureDetectorKt$processTapGesture$12.L$5;
                        function111 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$4;
                        function110 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        pressGestureScopeImpl4 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$2;
                        coroutineScope3 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$1;
                        awaitPointerEventScope4 = (AwaitPointerEventScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange2 = (PointerInputChange) obj;
                        if (pointerInputChange2 == null) {
                        }
                        if (pointerInputChange2 != null) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        job = (Job) tapGestureDetectorKt$processTapGesture$12.L$8;
                        pointerInputChange = (PointerInputChange) tapGestureDetectorKt$processTapGesture$12.L$7;
                        function19 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$6;
                        function33 = (Function3) tapGestureDetectorKt$processTapGesture$12.L$5;
                        function18 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$4;
                        pressGestureScopeImpl3 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$2;
                        CoroutineScope coroutineScope9 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$1;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        function17 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        coroutineScope2 = coroutineScope9;
                        longPressResult = (LongPressResult) obj;
                        if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                        }
                        break;
                    case 4:
                        job2 = (Job) tapGestureDetectorKt$processTapGesture$12.L$2;
                        pressGestureScopeImpl6 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$1;
                        coroutineScope5 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        launchAwaitingReset$default(coroutineScope5, job2, null, new TapGestureDetectorKt$processTapGesture$3(pressGestureScopeImpl6, null), 2, null);
                        return Unit.INSTANCE;
                    case 5:
                        launchAwaitingReset$default = (Job) tapGestureDetectorKt$processTapGesture$12.L$8;
                        pointerInputChange3 = (PointerInputChange) tapGestureDetectorKt$processTapGesture$12.L$7;
                        Function1<? super Offset, Unit> function124 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$4;
                        coroutineScope4 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$1;
                        awaitPointerEventScope5 = (AwaitPointerEventScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        function114 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$6;
                        function34 = (Function3) tapGestureDetectorKt$processTapGesture$12.L$5;
                        pressGestureScopeImpl5 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$2;
                        function113 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        function115 = function124;
                        pointerInputChange4 = (PointerInputChange) obj;
                        if (pointerInputChange4 == null) {
                        }
                        break;
                    case 6:
                        pointerInputChange7 = (PointerInputChange) tapGestureDetectorKt$processTapGesture$12.L$5;
                        launch$default2 = (Job) tapGestureDetectorKt$processTapGesture$12.L$4;
                        function119 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        function120 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$2;
                        pressGestureScopeImpl5 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$1;
                        coroutineScope7 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange8 = (PointerInputChange) obj;
                        if (pointerInputChange8 != null) {
                        }
                        return Unit.INSTANCE;
                    case 7:
                        PointerInputChange pointerInputChange10 = (PointerInputChange) tapGestureDetectorKt$processTapGesture$12.L$7;
                        function116 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$5;
                        function117 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$4;
                        function118 = (Function1) tapGestureDetectorKt$processTapGesture$12.L$3;
                        pressGestureScopeImpl7 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$2;
                        coroutineScope6 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$1;
                        awaitPointerEventScope6 = (AwaitPointerEventScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange5 = (PointerInputChange) tapGestureDetectorKt$processTapGesture$12.L$8;
                        launch$default2 = (Job) tapGestureDetectorKt$processTapGesture$12.L$6;
                        pointerInputChange6 = pointerInputChange10;
                        longPressResult2 = (LongPressResult) obj;
                        if (Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                        }
                        break;
                    case 8:
                        job3 = (Job) tapGestureDetectorKt$processTapGesture$12.L$2;
                        pressGestureScopeImpl8 = (PressGestureScopeImpl) tapGestureDetectorKt$processTapGesture$12.L$1;
                        coroutineScope8 = (CoroutineScope) tapGestureDetectorKt$processTapGesture$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        launchAwaitingReset$default(coroutineScope8, job3, null, new TapGestureDetectorKt$processTapGesture$secondUp$1(pressGestureScopeImpl8, null), 2, null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$processTapGesture$1 = new TapGestureDetectorKt$processTapGesture$1(continuation);
        tapGestureDetectorKt$processTapGesture$12 = tapGestureDetectorKt$processTapGesture$1;
        Object obj2 = tapGestureDetectorKt$processTapGesture$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tapGestureDetectorKt$processTapGesture$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[LOOP:0: B:19:0x0054->B:20:0x0056, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeUntilUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        TapGestureDetectorKt$consumeUntilUp$1 tapGestureDetectorKt$consumeUntilUp$1;
        int i;
        int size;
        int i2;
        int i3;
        int size2;
        if (continuation instanceof TapGestureDetectorKt$consumeUntilUp$1) {
            tapGestureDetectorKt$consumeUntilUp$1 = (TapGestureDetectorKt$consumeUntilUp$1) continuation;
            if ((tapGestureDetectorKt$consumeUntilUp$1.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$consumeUntilUp$1.label -= Integer.MIN_VALUE;
                Object obj = tapGestureDetectorKt$consumeUntilUp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tapGestureDetectorKt$consumeUntilUp$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tapGestureDetectorKt$consumeUntilUp$1.L$0 = awaitPointerEventScope;
                    tapGestureDetectorKt$consumeUntilUp$1.label = 1;
                    obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, tapGestureDetectorKt$consumeUntilUp$1, 1, null);
                    if (obj == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i2 = 0;
                    while (i3 < size) {
                    }
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    size2 = changes2.size();
                    while (i2 < size2) {
                    }
                    return Unit.INSTANCE;
                } else if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) tapGestureDetectorKt$consumeUntilUp$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    size = changes3.size();
                    i2 = 0;
                    for (i3 = 0; i3 < size; i3++) {
                        changes3.get(i3).consume();
                    }
                    List<PointerInputChange> changes22 = pointerEvent2.getChanges();
                    size2 = changes22.size();
                    while (i2 < size2) {
                        if (changes22.get(i2).getPressed()) {
                            tapGestureDetectorKt$consumeUntilUp$1.L$0 = awaitPointerEventScope;
                            tapGestureDetectorKt$consumeUntilUp$1.label = 1;
                            obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, tapGestureDetectorKt$consumeUntilUp$1, 1, null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerEvent pointerEvent22 = (PointerEvent) obj;
                            List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                            size = changes32.size();
                            i2 = 0;
                            while (i3 < size) {
                            }
                            List<PointerInputChange> changes222 = pointerEvent22.getChanges();
                            size2 = changes222.size();
                            while (i2 < size2) {
                            }
                        } else {
                            i2++;
                        }
                    }
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$consumeUntilUp$1 = new TapGestureDetectorKt$consumeUntilUp$1(continuation);
        Object obj2 = tapGestureDetectorKt$consumeUntilUp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tapGestureDetectorKt$consumeUntilUp$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange, null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapAndPress$2(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation) {
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, boolean r8, androidx.compose.ui.input.pointer.PointerEventPass r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r8 = (androidx.compose.ui.input.pointer.PointerEventPass) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L52
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.ResultKt.throwOnFailure(r10)
        L43:
            r0.L$0 = r7
            r0.L$1 = r9
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r10 = r7.awaitPointerEvent(r9, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = isChangedToDown$default(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L43
            java.util.List r7 = r10.getChanges()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:18:0x0052). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            boolean r5 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r6 = (androidx.compose.ui.input.pointer.PointerEventPass) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L52
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
        L43:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            boolean r2 = isChangedToDown(r8, r6, r3)
            if (r2 == 0) goto L43
            java.util.List r5 = r8.getChanges()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitPrimaryFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent pointerEvent, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
        }
        return isChangedToDown(pointerEvent, z, z2);
    }

    public static final boolean isChangedToDown(PointerEvent pointerEvent, boolean z, boolean z2) {
        if (z2) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (!PointerType.m6758equalsimpl0(changes.get(i).m6688getTypeT8wyACA(), PointerType.Companion.m6763getMouseT8wyACA())) {
                        break;
                    }
                    i++;
                } else if (!PointerEvent_androidKt.m6655isPrimaryPressedaHzCxE(pointerEvent.m6616getButtonsry648PA())) {
                    return false;
                }
            }
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = changes2.get(i2);
            if (!(z ? PointerEventKt.changedToDown(pointerInputChange) : PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
        if (r0 == r2) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c7 -> B:13:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super PointerInputChange> continuation) {
        TapGestureDetectorKt$waitForUpOrCancellation$2 tapGestureDetectorKt$waitForUpOrCancellation$2;
        int i;
        AwaitPointerEventScope awaitPointerEventScope2;
        TapGestureDetectorKt$waitForUpOrCancellation$2 tapGestureDetectorKt$waitForUpOrCancellation$22;
        PointerEventPass pointerEventPass2;
        AwaitPointerEventScope awaitPointerEventScope3;
        PointerEventPass pointerEventPass3;
        int size;
        int i2;
        Object awaitPointerEvent;
        if (continuation instanceof TapGestureDetectorKt$waitForUpOrCancellation$2) {
            tapGestureDetectorKt$waitForUpOrCancellation$2 = (TapGestureDetectorKt$waitForUpOrCancellation$2) continuation;
            if ((tapGestureDetectorKt$waitForUpOrCancellation$2.label & Integer.MIN_VALUE) != 0) {
                tapGestureDetectorKt$waitForUpOrCancellation$2.label -= Integer.MIN_VALUE;
                Object obj = tapGestureDetectorKt$waitForUpOrCancellation$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tapGestureDetectorKt$waitForUpOrCancellation$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    tapGestureDetectorKt$waitForUpOrCancellation$22 = tapGestureDetectorKt$waitForUpOrCancellation$2;
                    pointerEventPass2 = pointerEventPass;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.L$0 = awaitPointerEventScope2;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.L$1 = pointerEventPass2;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.label = 1;
                    awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, tapGestureDetectorKt$waitForUpOrCancellation$22);
                    if (awaitPointerEvent != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    pointerEventPass3 = (PointerEventPass) tapGestureDetectorKt$waitForUpOrCancellation$2.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) tapGestureDetectorKt$waitForUpOrCancellation$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    while (i2 < size) {
                    }
                    return pointerEvent.getChanges().get(0);
                } else if (i == 2) {
                    pointerEventPass3 = (PointerEventPass) tapGestureDetectorKt$waitForUpOrCancellation$2.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) tapGestureDetectorKt$waitForUpOrCancellation$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerEventPass pointerEventPass4 = pointerEventPass3;
                    tapGestureDetectorKt$waitForUpOrCancellation$22 = tapGestureDetectorKt$waitForUpOrCancellation$2;
                    pointerEventPass2 = pointerEventPass4;
                    List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                    int size2 = changes2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        if (changes2.get(i3).isConsumed()) {
                            return null;
                        }
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.L$0 = awaitPointerEventScope2;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.L$1 = pointerEventPass2;
                    tapGestureDetectorKt$waitForUpOrCancellation$22.label = 1;
                    awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, tapGestureDetectorKt$waitForUpOrCancellation$22);
                    if (awaitPointerEvent != coroutine_suspended) {
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        obj = awaitPointerEvent;
                        TapGestureDetectorKt$waitForUpOrCancellation$2 tapGestureDetectorKt$waitForUpOrCancellation$23 = tapGestureDetectorKt$waitForUpOrCancellation$22;
                        pointerEventPass3 = pointerEventPass2;
                        tapGestureDetectorKt$waitForUpOrCancellation$2 = tapGestureDetectorKt$waitForUpOrCancellation$23;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        size = changes3.size();
                        for (i2 = 0; i2 < size; i2++) {
                            if (!PointerEventKt.changedToUp(changes3.get(i2))) {
                                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                int size3 = changes4.size();
                                for (int i4 = 0; i4 < size3; i4++) {
                                    PointerInputChange pointerInputChange = changes4.get(i4);
                                    if (pointerInputChange.isConsumed() || PointerEventKt.m6621isOutOfBoundsjwHxaWs(pointerInputChange, awaitPointerEventScope3.mo6570getSizeYbymL2g(), awaitPointerEventScope3.mo6569getExtendedTouchPaddingNHjbRc())) {
                                        break;
                                    }
                                }
                                PointerEventPass pointerEventPass5 = PointerEventPass.Final;
                                tapGestureDetectorKt$waitForUpOrCancellation$2.L$0 = awaitPointerEventScope3;
                                tapGestureDetectorKt$waitForUpOrCancellation$2.L$1 = pointerEventPass3;
                                tapGestureDetectorKt$waitForUpOrCancellation$2.label = 2;
                                obj = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass5, tapGestureDetectorKt$waitForUpOrCancellation$2);
                            }
                        }
                        return pointerEvent2.getChanges().get(0);
                    }
                    return coroutine_suspended;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tapGestureDetectorKt$waitForUpOrCancellation$2 = new TapGestureDetectorKt$waitForUpOrCancellation$2(continuation);
        Object obj2 = tapGestureDetectorKt$waitForUpOrCancellation$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tapGestureDetectorKt$waitForUpOrCancellation$2.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object waitForLongPress(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super LongPressResult> continuation) {
        TapGestureDetectorKt$waitForLongPress$1 tapGestureDetectorKt$waitForLongPress$1;
        int i;
        Ref.ObjectRef objectRef;
        try {
            if (continuation instanceof TapGestureDetectorKt$waitForLongPress$1) {
                tapGestureDetectorKt$waitForLongPress$1 = (TapGestureDetectorKt$waitForLongPress$1) continuation;
                if ((tapGestureDetectorKt$waitForLongPress$1.label & Integer.MIN_VALUE) != 0) {
                    tapGestureDetectorKt$waitForLongPress$1.label -= Integer.MIN_VALUE;
                    Object obj = tapGestureDetectorKt$waitForLongPress$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = tapGestureDetectorKt$waitForLongPress$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = LongPressResult.Canceled.INSTANCE;
                        tapGestureDetectorKt$waitForLongPress$1.L$0 = objectRef2;
                        tapGestureDetectorKt$waitForLongPress$1.label = 1;
                        if (awaitPointerEventScope.withTimeout(awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis(), new TapGestureDetectorKt$waitForLongPress$2(pointerEventPass, objectRef2, null), tapGestureDetectorKt$waitForLongPress$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        objectRef = (Ref.ObjectRef) tapGestureDetectorKt$waitForLongPress$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return objectRef.element;
                }
            }
            if (i != 0) {
            }
            return objectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
        tapGestureDetectorKt$waitForLongPress$1 = new TapGestureDetectorKt$waitForLongPress$1(continuation);
        Object obj2 = tapGestureDetectorKt$waitForLongPress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tapGestureDetectorKt$waitForLongPress$1.label;
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForLongPress(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return launchAwaitingReset(coroutineScope, job, coroutineStart, function2);
    }

    private static final Job launchAwaitingReset(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, coroutineStart, new TapGestureDetectorKt$launchAwaitingReset$1(job, function2, null), 1, null);
        return launch$default;
    }
}
