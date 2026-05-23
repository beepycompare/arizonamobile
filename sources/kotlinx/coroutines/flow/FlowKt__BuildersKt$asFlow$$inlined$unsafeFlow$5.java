package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.sequences.Sequence;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5<T> implements Flow<T> {
    final /* synthetic */ Sequence $this_asFlow$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {114}, m = "collect", n = {"collector", "$completion", "$this$asFlow_u24lambda_u244", "$this$forEach$iv", "element$iv", "value", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$5", "$i$f$forEach", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$5$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5.this.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        Sequence sequence;
        Continuation continuation2;
        Iterator<T> it;
        int i2;
        FlowCollector<? super T> flowCollector2;
        AnonymousClass1 anonymousClass12;
        int i3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Sequence sequence2 = this.$this_asFlow$inlined;
                    sequence = sequence2;
                    continuation2 = anonymousClass1;
                    it = sequence2.iterator();
                    i2 = 0;
                    flowCollector2 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    i3 = 0;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = anonymousClass1.I$2;
                    i2 = anonymousClass1.I$1;
                    int i5 = anonymousClass1.I$0;
                    Object obj2 = anonymousClass1.L$6;
                    Object obj3 = anonymousClass1.L$5;
                    continuation2 = (Continuation) anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass13 = anonymousClass1;
                    i3 = i5;
                    flowCollector = (FlowCollector) anonymousClass1.L$2;
                    sequence = (Sequence) anonymousClass1.L$3;
                    it = (Iterator) anonymousClass1.L$4;
                    anonymousClass12 = anonymousClass13;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                }
                while (it.hasNext()) {
                    T next = it.next();
                    anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                    anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                    anonymousClass12.L$2 = flowCollector;
                    anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(sequence);
                    anonymousClass12.L$4 = it;
                    anonymousClass12.L$5 = SpillingKt.nullOutSpilledVariable(next);
                    anonymousClass12.L$6 = SpillingKt.nullOutSpilledVariable(next);
                    anonymousClass12.I$0 = i3;
                    anonymousClass12.I$1 = i2;
                    anonymousClass12.I$2 = 0;
                    anonymousClass12.label = 1;
                    if (flowCollector.emit(next, anonymousClass12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj4 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(Sequence sequence) {
        this.$this_asFlow$inlined = sequence;
    }
}
