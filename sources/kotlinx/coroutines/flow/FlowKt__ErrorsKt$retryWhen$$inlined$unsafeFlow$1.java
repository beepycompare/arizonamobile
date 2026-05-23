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
import kotlin.jvm.functions.Function4;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {116, 118}, m = "collect", n = {"collector", "$completion", "$this$retryWhen_u24lambda_u240", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1", "attempt", "shallRetry", "collector", "$completion", "$this$retryWhen_u24lambda_u240", "cause", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1", "attempt", "shallRetry"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "I$1"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
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
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a8 -> B:31:0x00e1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cf -> B:27:0x00d2). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        Object obj;
        int i2;
        long j;
        FlowCollector<? super T> flowCollector2;
        AnonymousClass1 anonymousClass12;
        FlowCollector<? super T> flowCollector3;
        FlowCollector<? super T> flowCollector4;
        Object obj2;
        FlowCollector<? super T> flowCollector5;
        int i3;
        int i4;
        Throwable th;
        Object catchImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj3 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                int i5 = 0;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    obj = anonymousClass1;
                    i2 = 0;
                    j = 0;
                    flowCollector2 = flowCollector;
                    anonymousClass12 = anonymousClass1;
                    flowCollector3 = flowCollector2;
                    Flow flow = this.$this_retryWhen$inlined;
                    anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                    anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                    anonymousClass12.L$2 = flowCollector2;
                    anonymousClass12.L$3 = null;
                    anonymousClass12.I$0 = i2;
                    anonymousClass12.J$0 = j;
                    anonymousClass12.I$1 = i5;
                    anonymousClass12.label = 1;
                    catchImpl = FlowKt.catchImpl(flow, flowCollector2, anonymousClass12);
                    if (catchImpl != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    int i6 = anonymousClass1.I$1;
                    long j2 = anonymousClass1.J$0;
                    int i7 = anonymousClass1.I$0;
                    flowCollector5 = (FlowCollector) anonymousClass1.L$2;
                    obj2 = (Continuation) anonymousClass1.L$1;
                    flowCollector4 = (FlowCollector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    i3 = i6;
                    i4 = i7;
                    j = j2;
                    th = (Throwable) obj3;
                    if (th != null) {
                    }
                    AnonymousClass1 anonymousClass13 = anonymousClass1;
                    flowCollector2 = flowCollector5;
                    flowCollector3 = flowCollector4;
                    i2 = i4;
                    obj = obj2;
                    if (i3 == 0) {
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i8 = anonymousClass1.I$1;
                    long j3 = anonymousClass1.J$0;
                    i4 = anonymousClass1.I$0;
                    Throwable th2 = (Throwable) anonymousClass1.L$3;
                    flowCollector5 = (FlowCollector) anonymousClass1.L$2;
                    obj2 = (Continuation) anonymousClass1.L$1;
                    flowCollector4 = (FlowCollector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    if (!((Boolean) obj3).booleanValue()) {
                        j = j3 + 1;
                        i3 = 1;
                        AnonymousClass1 anonymousClass132 = anonymousClass1;
                        flowCollector2 = flowCollector5;
                        flowCollector3 = flowCollector4;
                        i2 = i4;
                        obj = obj2;
                        if (i3 == 0) {
                            return Unit.INSTANCE;
                        }
                        anonymousClass12 = anonymousClass132;
                        i5 = 0;
                        Flow flow2 = this.$this_retryWhen$inlined;
                        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass12.L$2 = flowCollector2;
                        anonymousClass12.L$3 = null;
                        anonymousClass12.I$0 = i2;
                        anonymousClass12.J$0 = j;
                        anonymousClass12.I$1 = i5;
                        anonymousClass12.label = 1;
                        catchImpl = FlowKt.catchImpl(flow2, flowCollector2, anonymousClass12);
                        if (catchImpl != coroutine_suspended) {
                            int i9 = i2;
                            flowCollector5 = flowCollector2;
                            obj3 = catchImpl;
                            obj2 = obj;
                            i4 = i9;
                            flowCollector4 = flowCollector3;
                            anonymousClass1 = anonymousClass12;
                            i3 = i5;
                            th = (Throwable) obj3;
                            if (th != null) {
                                Function4 function4 = this.$predicate$inlined;
                                Long boxLong = Boxing.boxLong(j);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector4);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                                anonymousClass1.L$2 = flowCollector5;
                                anonymousClass1.L$3 = th;
                                anonymousClass1.I$0 = i4;
                                anonymousClass1.J$0 = j;
                                anonymousClass1.I$1 = i3;
                                anonymousClass1.label = 2;
                                Object invoke = function4.invoke(flowCollector5, th, boxLong, anonymousClass1);
                                if (invoke != coroutine_suspended) {
                                    j3 = j;
                                    th2 = th;
                                    obj3 = invoke;
                                    if (!((Boolean) obj3).booleanValue()) {
                                        throw th2;
                                    }
                                }
                            }
                            AnonymousClass1 anonymousClass1322 = anonymousClass1;
                            flowCollector2 = flowCollector5;
                            flowCollector3 = flowCollector4;
                            i2 = i4;
                            obj = obj2;
                            if (i3 == 0) {
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj32 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        int i52 = 0;
        if (i != 0) {
        }
    }
}
