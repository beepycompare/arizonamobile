package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> implements Flow<T> {
    final /* synthetic */ Function1 $this_asFlow$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {112, 112}, m = "collect", n = {"collector", "$completion", "$this$asFlow_u24lambda_u241", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2", "collector", "$completion", "$this$asFlow_u24lambda_u241", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.collect(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
        if (r7.emit(r8, r0) != r1) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        FlowCollector<? super T> flowCollector2;
        Continuation continuation2;
        int i2;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass12 = anonymousClass1;
                    Function1 function1 = this.$this_asFlow$inlined;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.L$3 = flowCollector;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    Object invoke = function1.invoke(anonymousClass1);
                    if (invoke != coroutine_suspended) {
                        flowCollector2 = flowCollector;
                        continuation2 = anonymousClass12;
                        obj = invoke;
                        i2 = 0;
                        flowCollector3 = flowCollector2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        int i3 = anonymousClass1.I$0;
                        FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$2;
                        Continuation continuation3 = (Continuation) anonymousClass1.L$1;
                        FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i2 = anonymousClass1.I$0;
                    flowCollector = (FlowCollector) anonymousClass1.L$3;
                    flowCollector3 = (FlowCollector) anonymousClass1.L$2;
                    continuation2 = (Continuation) anonymousClass1.L$1;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                anonymousClass1.L$3 = null;
                anonymousClass1.I$0 = i2;
                anonymousClass1.label = 2;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(flowCollector3);
        anonymousClass1.L$3 = null;
        anonymousClass1.I$0 = i2;
        anonymousClass1.label = 2;
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }
}
