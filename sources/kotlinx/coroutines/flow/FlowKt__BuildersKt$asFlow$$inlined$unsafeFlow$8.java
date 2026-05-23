package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {
    final /* synthetic */ long[] $this_asFlow$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {114}, m = "collect", n = {"collector", "$completion", "$this$asFlow_u24lambda_u247", "$this$forEach$iv", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$8", "$i$f$forEach", "element$iv", "value", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$8$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "J$0", "J$1", "I$4"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.$this_asFlow$inlined = jArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0095 -> B:19:0x0098). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        long[] jArr;
        Object obj;
        int length;
        int i2;
        int i3;
        AnonymousClass1 anonymousClass12;
        FlowCollector<? super Long> flowCollector2;
        int i4;
        FlowCollector<? super Long> flowCollector3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    long[] jArr2 = this.$this_asFlow$inlined;
                    jArr = jArr2;
                    obj = anonymousClass1;
                    length = jArr2.length;
                    i2 = 0;
                    i3 = 0;
                    FlowCollector<? super Long> flowCollector4 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    flowCollector2 = flowCollector4;
                    i4 = 0;
                    flowCollector3 = flowCollector4;
                    if (i4 < length) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = anonymousClass1.I$4;
                    long j = anonymousClass1.J$1;
                    long j2 = anonymousClass1.J$0;
                    length = anonymousClass1.I$3;
                    i4 = anonymousClass1.I$2;
                    int i6 = anonymousClass1.I$1;
                    int i7 = anonymousClass1.I$0;
                    obj = (Continuation) anonymousClass1.L$1;
                    ResultKt.throwOnFailure(obj2);
                    FlowCollector<? super Long> flowCollector5 = (FlowCollector) anonymousClass1.L$2;
                    jArr = (long[]) anonymousClass1.L$3;
                    i3 = i7;
                    i2 = i6;
                    anonymousClass12 = anonymousClass1;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                    i4++;
                    flowCollector3 = flowCollector5;
                    if (i4 < length) {
                        long j3 = jArr[i4];
                        Long boxLong = Boxing.boxLong(j3);
                        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass12.L$2 = flowCollector3;
                        anonymousClass12.L$3 = jArr;
                        anonymousClass12.I$0 = i3;
                        anonymousClass12.I$1 = i2;
                        anonymousClass12.I$2 = i4;
                        anonymousClass12.I$3 = length;
                        anonymousClass12.J$0 = j3;
                        anonymousClass12.J$1 = j3;
                        anonymousClass12.I$4 = 0;
                        anonymousClass12.label = 1;
                        Object emit = flowCollector3.emit(boxLong, anonymousClass12);
                        flowCollector5 = flowCollector3;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i4++;
                        flowCollector3 = flowCollector5;
                        if (i4 < length) {
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
