package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transform.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<R> $accumulator;
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
    final /* synthetic */ FlowCollector<R> $this_flow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r7.emit(r8, r0) != r1) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$runningFold$1$1$emit$1 flowKt__TransformKt$runningFold$1$1$emit$1;
        int i;
        Ref.ObjectRef objectRef;
        FlowKt__TransformKt$runningFold$1$1<T> flowKt__TransformKt$runningFold$1$1;
        if (continuation instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) {
            flowKt__TransformKt$runningFold$1$1$emit$1 = (FlowKt__TransformKt$runningFold$1$1$emit$1) continuation;
            if ((flowKt__TransformKt$runningFold$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningFold$1$1$emit$1.label -= Integer.MIN_VALUE;
                T t2 = (T) flowKt__TransformKt$runningFold$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(t2);
                    Ref.ObjectRef objectRef2 = this.$accumulator;
                    Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                    T t3 = objectRef2.element;
                    flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = this;
                    flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = objectRef2;
                    flowKt__TransformKt$runningFold$1$1$emit$1.label = 1;
                    Object invoke = function3.invoke(t3, t, flowKt__TransformKt$runningFold$1$1$emit$1);
                    if (invoke != coroutine_suspended) {
                        t2 = (T) invoke;
                        objectRef = objectRef2;
                        flowKt__TransformKt$runningFold$1$1 = this;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(t2);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    objectRef = (Ref.ObjectRef) flowKt__TransformKt$runningFold$1$1$emit$1.L$1;
                    flowKt__TransformKt$runningFold$1$1 = (FlowKt__TransformKt$runningFold$1$1) flowKt__TransformKt$runningFold$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(t2);
                }
                objectRef.element = t2;
                FlowCollector<R> flowCollector = flowKt__TransformKt$runningFold$1$1.$this_flow;
                T t4 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
                flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
                flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
                flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
            }
        }
        flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, continuation);
        T t22 = (T) flowKt__TransformKt$runningFold$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
        if (i != 0) {
        }
        objectRef.element = t22;
        FlowCollector<R> flowCollector2 = flowKt__TransformKt$runningFold$1$1.$this_flow;
        T t42 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
    }
}
