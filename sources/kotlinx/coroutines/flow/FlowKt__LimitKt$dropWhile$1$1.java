package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Limit.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.BooleanRef $matched;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$matched = booleanRef;
        this.$this_flow = flowCollector;
        this.$predicate = function2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r8.emit(r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r2.$this_flow.emit(r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        int i;
        FlowKt__LimitKt$dropWhile$1$1<T> flowKt__LimitKt$dropWhile$1$1;
        if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
            flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
            if ((flowKt__LimitKt$dropWhile$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$dropWhile$1$1$emit$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$matched.element) {
                        FlowCollector<T> flowCollector = this.$this_flow;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 1;
                    } else {
                        Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = this;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = t;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 2;
                        obj = function2.invoke(t, flowKt__LimitKt$dropWhile$1$1$emit$1);
                        if (obj != coroutine_suspended) {
                            flowKt__LimitKt$dropWhile$1$1 = this;
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    t = (T) flowKt__LimitKt$dropWhile$1$1$emit$1.L$1;
                    flowKt__LimitKt$dropWhile$1$1 = (FlowKt__LimitKt$dropWhile$1$1) flowKt__LimitKt$dropWhile$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    flowKt__LimitKt$dropWhile$1$1.$matched.element = true;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = null;
                    flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                }
            }
        }
        flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
        Object obj2 = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
        if (i != 0) {
        }
    }
}
