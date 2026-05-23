package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Errors.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$2<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> $collector;
    final /* synthetic */ Ref.ObjectRef<Throwable> $fromDownstream;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2(FlowCollector<? super T> flowCollector, Ref.ObjectRef<Throwable> objectRef) {
        this.$collector = flowCollector;
        this.$fromDownstream = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Throwable, T] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__ErrorsKt$catchImpl$2$emit$1 flowKt__ErrorsKt$catchImpl$2$emit$1;
        int i;
        try {
            if (continuation instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) {
                flowKt__ErrorsKt$catchImpl$2$emit$1 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) continuation;
                if ((flowKt__ErrorsKt$catchImpl$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ErrorsKt$catchImpl$2$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = flowKt__ErrorsKt$catchImpl$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<T> flowCollector = this.$collector;
                        flowKt__ErrorsKt$catchImpl$2$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        flowKt__ErrorsKt$catchImpl$2$emit$1.label = 1;
                        if (flowCollector.emit(t, flowKt__ErrorsKt$catchImpl$2$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = flowKt__ErrorsKt$catchImpl$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    this = (FlowKt__ErrorsKt$catchImpl$2<T>) Unit.INSTANCE;
                    return this;
                }
            }
            if (i != 0) {
            }
            this = (FlowKt__ErrorsKt$catchImpl$2<T>) Unit.INSTANCE;
            return this;
        } catch (Throwable r5) {
            r5 = (T) th;
            this.$fromDownstream.element = r5;
            throw r5;
        }
        flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, continuation);
        Object obj3 = flowKt__ErrorsKt$catchImpl$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ErrorsKt$catchImpl$2$emit$1.label;
    }
}
