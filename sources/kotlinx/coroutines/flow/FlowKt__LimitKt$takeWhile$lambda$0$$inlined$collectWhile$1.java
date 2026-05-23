package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Limit.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ FlowCollector $this_flow$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {142, 143}, m = "emit", n = {"value", "$completion", "value", "$i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1", "value", "$completion", "value", "$i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1.this.emit(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
        if (r7.emit(r8, r0) == r1) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        Object invoke;
        Continuation continuation2;
        int i2;
        Object obj;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    Function2 function2 = this.$predicate$inlined;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.L$2 = t;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    invoke = function2.invoke(t, anonymousClass1);
                    if (invoke != coroutine_suspended) {
                        continuation2 = anonymousClass12;
                        i2 = 0;
                        obj = t;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        int i3 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Continuation continuation3 = (Continuation) anonymousClass1.L$1;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = anonymousClass1.I$0;
                    Object obj5 = anonymousClass1.L$2;
                    continuation2 = (Continuation) anonymousClass1.L$1;
                    obj = anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    i2 = i4;
                    t = obj5;
                    invoke = obj2;
                }
                if (((Boolean) invoke).booleanValue()) {
                    throw new AbortFlowException(this);
                }
                FlowCollector flowCollector = this.$this_flow$inlined;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(t);
                anonymousClass1.I$0 = i2;
                anonymousClass1.label = 2;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        if (((Boolean) invoke).booleanValue()) {
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.$predicate$inlined = function2;
        this.$this_flow$inlined = flowCollector;
    }
}
