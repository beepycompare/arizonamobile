package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transform.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.$accumulator = objectRef;
        this.$operation = function3;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
        if (r9.emit(r8, r0) == r1) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        int i;
        Ref.ObjectRef<Object> objectRef;
        T t2;
        Ref.ObjectRef<Object> objectRef2;
        T t3;
        if (continuation instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) continuation;
            if ((flowKt__TransformKt$runningReduce$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.$accumulator;
                    if (objectRef.element == NullSurrogateKt.NULL) {
                        t3 = t;
                        objectRef.element = t;
                        FlowCollector<T> flowCollector = this.$this_flow;
                        T t4 = this.$accumulator.element;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t3);
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
                    } else {
                        Function3<T, T, Continuation<? super T>, Object> function3 = this.$operation;
                        T t5 = this.$accumulator.element;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = objectRef;
                        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 1;
                        Object invoke = function3.invoke(t5, t, flowKt__TransformKt$runningReduce$1$1$emit$1);
                        if (invoke != coroutine_suspended) {
                            t2 = t;
                            objectRef2 = objectRef;
                            obj = invoke;
                        }
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        Object obj2 = flowKt__TransformKt$runningReduce$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    objectRef2 = (Ref.ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$1.L$1;
                    ?? r2 = flowKt__TransformKt$runningReduce$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    t2 = r2;
                }
                T t6 = obj;
                objectRef = objectRef2;
                t = t6;
                t3 = t2;
                objectRef.element = t;
                FlowCollector<T> flowCollector2 = this.$this_flow;
                T t42 = this.$accumulator.element;
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t3);
                flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
            }
        }
        flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, continuation);
        Object obj3 = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
        if (i != 0) {
        }
        T t62 = obj3;
        objectRef = objectRef2;
        t = t62;
        t3 = t2;
        objectRef.element = t;
        FlowCollector<T> flowCollector22 = this.$this_flow;
        T t422 = this.$accumulator.element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t3);
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
    }
}
