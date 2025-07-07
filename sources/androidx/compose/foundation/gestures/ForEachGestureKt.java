package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
/* compiled from: ForEachGesture.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\bH\u0080@¢\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u0004*\u00020\b2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010\u001a;\u0010\u0011\u001a\u00020\u0004*\u00020\b2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0087@¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ForEachGestureKt {
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(4:(1:(1:12)(2:35|36))(2:37|38)|13|14|(4:19|20|(2:22|23)|26)(2:16|17))(3:39|40|23))(3:41|14|(0)(0))))|43|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
        if (r10 != r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
        if (r10 == r1) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0092 -> B:18:0x0053). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ac -> B:18:0x0053). Please submit an issue!!! */
    @Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachGesture(PointerInputScope pointerInputScope, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ForEachGestureKt$forEachGesture$1 forEachGestureKt$forEachGesture$1;
        PointerInputScope pointerInputScope2;
        CoroutineContext coroutineContext;
        PointerInputScope pointerInputScope3;
        CoroutineContext coroutineContext2;
        PointerInputScope pointerInputScope4;
        if (continuation instanceof ForEachGestureKt$forEachGesture$1) {
            forEachGestureKt$forEachGesture$1 = (ForEachGestureKt$forEachGesture$1) continuation;
            if ((forEachGestureKt$forEachGesture$1.label & Integer.MIN_VALUE) != 0) {
                forEachGestureKt$forEachGesture$1.label -= Integer.MIN_VALUE;
                Object obj = forEachGestureKt$forEachGesture$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                pointerInputScope2 = forEachGestureKt$forEachGesture$1.label;
                if (pointerInputScope2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineContext = forEachGestureKt$forEachGesture$1.getContext();
                    pointerInputScope3 = pointerInputScope;
                    if (!JobKt.isActive(coroutineContext)) {
                    }
                } else if (pointerInputScope2 != 1) {
                    if (pointerInputScope2 == 2) {
                        CoroutineContext coroutineContext3 = (CoroutineContext) forEachGestureKt$forEachGesture$1.L$2;
                        function2 = (Function2) forEachGestureKt$forEachGesture$1.L$1;
                        PointerInputScope pointerInputScope5 = (PointerInputScope) forEachGestureKt$forEachGesture$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputScope4 = pointerInputScope5;
                        coroutineContext2 = coroutineContext3;
                    } else if (pointerInputScope2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        function2 = (Function2) forEachGestureKt$forEachGesture$1.L$1;
                        ResultKt.throwOnFailure(obj);
                        pointerInputScope4 = (PointerInputScope) forEachGestureKt$forEachGesture$1.L$0;
                        coroutineContext2 = (CoroutineContext) forEachGestureKt$forEachGesture$1.L$2;
                    }
                    coroutineContext = coroutineContext2;
                    pointerInputScope3 = pointerInputScope4;
                    if (!JobKt.isActive(coroutineContext)) {
                        try {
                        } catch (CancellationException e) {
                            pointerInputScope2 = pointerInputScope3;
                            pointerInputScope = coroutineContext;
                            e = e;
                            if (!JobKt.isActive(pointerInputScope)) {
                                forEachGestureKt$forEachGesture$1.L$0 = pointerInputScope2;
                                forEachGestureKt$forEachGesture$1.L$1 = function2;
                                forEachGestureKt$forEachGesture$1.L$2 = pointerInputScope;
                                forEachGestureKt$forEachGesture$1.label = 3;
                                Object awaitAllPointersUp = awaitAllPointersUp(pointerInputScope2, forEachGestureKt$forEachGesture$1);
                                pointerInputScope4 = pointerInputScope2;
                                coroutineContext2 = pointerInputScope;
                            } else {
                                throw e;
                            }
                        }
                        forEachGestureKt$forEachGesture$1.L$0 = pointerInputScope3;
                        forEachGestureKt$forEachGesture$1.L$1 = function2;
                        forEachGestureKt$forEachGesture$1.L$2 = coroutineContext;
                        forEachGestureKt$forEachGesture$1.label = 1;
                        if (function2.invoke(pointerInputScope3, forEachGestureKt$forEachGesture$1) != coroutine_suspended) {
                            pointerInputScope2 = pointerInputScope3;
                            pointerInputScope = coroutineContext;
                            forEachGestureKt$forEachGesture$1.L$0 = pointerInputScope2;
                            forEachGestureKt$forEachGesture$1.L$1 = function2;
                            forEachGestureKt$forEachGesture$1.L$2 = pointerInputScope;
                            forEachGestureKt$forEachGesture$1.label = 2;
                            Object awaitAllPointersUp2 = awaitAllPointersUp(pointerInputScope2, forEachGestureKt$forEachGesture$1);
                            pointerInputScope4 = pointerInputScope2;
                            coroutineContext2 = pointerInputScope;
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } else {
                    CoroutineContext coroutineContext4 = (CoroutineContext) forEachGestureKt$forEachGesture$1.L$2;
                    function2 = (Function2) forEachGestureKt$forEachGesture$1.L$1;
                    PointerInputScope pointerInputScope6 = (PointerInputScope) forEachGestureKt$forEachGesture$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    pointerInputScope2 = pointerInputScope6;
                    pointerInputScope = coroutineContext4;
                    forEachGestureKt$forEachGesture$1.L$0 = pointerInputScope2;
                    forEachGestureKt$forEachGesture$1.L$1 = function2;
                    forEachGestureKt$forEachGesture$1.L$2 = pointerInputScope;
                    forEachGestureKt$forEachGesture$1.label = 2;
                    Object awaitAllPointersUp22 = awaitAllPointersUp(pointerInputScope2, forEachGestureKt$forEachGesture$1);
                    pointerInputScope4 = pointerInputScope2;
                    coroutineContext2 = pointerInputScope;
                }
            }
        }
        forEachGestureKt$forEachGesture$1 = new ForEachGestureKt$forEachGesture$1(continuation);
        Object obj2 = forEachGestureKt$forEachGesture$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        pointerInputScope2 = forEachGestureKt$forEachGesture$1.label;
        if (pointerInputScope2 != 0) {
        }
    }

    public static final boolean allPointersUp(AwaitPointerEventScope awaitPointerEventScope) {
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (changes.get(i).getPressed()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    public static final Object awaitAllPointersUp(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new ForEachGestureKt$awaitAllPointersUp$2(null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (allPointersUp(r7) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0050 -> B:19:0x0053). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUp(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation<? super Unit> continuation) {
        ForEachGestureKt$awaitAllPointersUp$3 forEachGestureKt$awaitAllPointersUp$3;
        int i;
        if (continuation instanceof ForEachGestureKt$awaitAllPointersUp$3) {
            forEachGestureKt$awaitAllPointersUp$3 = (ForEachGestureKt$awaitAllPointersUp$3) continuation;
            if ((forEachGestureKt$awaitAllPointersUp$3.label & Integer.MIN_VALUE) != 0) {
                forEachGestureKt$awaitAllPointersUp$3.label -= Integer.MIN_VALUE;
                Object obj = forEachGestureKt$awaitAllPointersUp$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = forEachGestureKt$awaitAllPointersUp$3.label;
                if (i == 0) {
                    if (i == 1) {
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) forEachGestureKt$awaitAllPointersUp$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerEventPass = (PointerEventPass) forEachGestureKt$awaitAllPointersUp$3.L$1;
                        awaitPointerEventScope = awaitPointerEventScope2;
                        List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                        int size = changes.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (changes.get(i2).getPressed()) {
                                forEachGestureKt$awaitAllPointersUp$3.L$0 = awaitPointerEventScope;
                                forEachGestureKt$awaitAllPointersUp$3.L$1 = pointerEventPass;
                                forEachGestureKt$awaitAllPointersUp$3.label = 1;
                                obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, forEachGestureKt$awaitAllPointersUp$3);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                                int size2 = changes2.size();
                                int i22 = 0;
                                while (i22 < size2) {
                                }
                            } else {
                                i22++;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        forEachGestureKt$awaitAllPointersUp$3 = new ForEachGestureKt$awaitAllPointersUp$3(continuation);
        Object obj2 = forEachGestureKt$awaitAllPointersUp$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = forEachGestureKt$awaitAllPointersUp$3.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object awaitAllPointersUp$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Final;
        }
        return awaitAllPointersUp(awaitPointerEventScope, pointerEventPass, continuation);
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
