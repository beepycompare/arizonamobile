package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0, 0, 0, 0, 0}, l = {113}, m = "collect", n = {"collector", "$completion", "$this$flowOf_u24lambda_u240", "element", "$i$a$-unsafeFlow-FlowKt__BuildersKt$flowOf$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0083 -> B:20:0x0086). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        int i2;
        Object obj;
        int i3;
        int length;
        AnonymousClass1 anonymousClass12;
        FlowCollector<? super T> flowCollector2;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i2 = 0;
                    obj = anonymousClass1;
                    i3 = 0;
                    FlowCollector<? super T> flowCollector4 = flowCollector;
                    length = this.$elements$inlined.length;
                    anonymousClass12 = anonymousClass1;
                    flowCollector2 = flowCollector4;
                    flowCollector3 = flowCollector4;
                    if (i2 < length) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    length = anonymousClass1.I$2;
                    int i4 = anonymousClass1.I$1;
                    int i5 = anonymousClass1.I$0;
                    Object obj3 = anonymousClass1.L$3;
                    obj = (Continuation) anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj2);
                    FlowCollector<? super T> flowCollector5 = (FlowCollector) anonymousClass1.L$2;
                    i3 = i5;
                    AnonymousClass1 anonymousClass13 = anonymousClass1;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                    AnonymousClass1 anonymousClass14 = anonymousClass13;
                    i2 = i4 + 1;
                    anonymousClass12 = anonymousClass14;
                    flowCollector3 = flowCollector5;
                    if (i2 < length) {
                        Object obj4 = this.$elements$inlined[i2];
                        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass12.L$2 = flowCollector3;
                        anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                        anonymousClass12.I$0 = i3;
                        anonymousClass12.I$1 = i2;
                        anonymousClass12.I$2 = length;
                        anonymousClass12.label = 1;
                        if (flowCollector3.emit(obj4, anonymousClass12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i6 = i2;
                        anonymousClass13 = anonymousClass12;
                        i4 = i6;
                        flowCollector5 = flowCollector3;
                        AnonymousClass1 anonymousClass142 = anonymousClass13;
                        i2 = i4 + 1;
                        anonymousClass12 = anonymousClass142;
                        flowCollector3 = flowCollector5;
                        if (i2 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
    }
}
