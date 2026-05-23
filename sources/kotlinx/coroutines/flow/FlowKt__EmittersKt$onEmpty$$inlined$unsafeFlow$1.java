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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {113, 121}, m = "collect", n = {"collector", "$completion", "$this$onEmpty_u24lambda_u240", "isEmpty", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1", "collector", "$completion", "$this$onEmpty_u24lambda_u240", "isEmpty", "collector", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onEmpty$inlined = flow;
        this.$action$inlined = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        AnonymousClass1 anonymousClass12;
        Ref.BooleanRef booleanRef;
        int i2;
        FlowCollector<? super T> flowCollector2;
        SafeCollector safeCollector;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass12 = anonymousClass1;
                    booleanRef = new Ref.BooleanRef();
                    booleanRef.element = true;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.L$2 = flowCollector;
                    anonymousClass1.L$3 = booleanRef;
                    i2 = 0;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    if (this.$this_onEmpty$inlined.collect(new FlowKt__EmittersKt$onEmpty$1$1(booleanRef, flowCollector), anonymousClass1) != coroutine_suspended) {
                        flowCollector2 = flowCollector;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        int i3 = anonymousClass1.I$0;
                        safeCollector = (SafeCollector) anonymousClass1.L$4;
                        Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) anonymousClass1.L$3;
                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$2;
                        Continuation continuation2 = (Continuation) anonymousClass1.L$1;
                        FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            safeCollector.releaseIntercepted();
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            safeCollector.releaseIntercepted();
                            throw th;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = anonymousClass1.I$0;
                    booleanRef = (Ref.BooleanRef) anonymousClass1.L$3;
                    anonymousClass12 = (Continuation) anonymousClass1.L$1;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i4;
                    flowCollector = (FlowCollector) anonymousClass1.L$2;
                }
                if (booleanRef.element) {
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector, anonymousClass1.getContext());
                    try {
                        Function2 function2 = this.$action$inlined;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(booleanRef);
                        anonymousClass1.L$4 = safeCollector2;
                        anonymousClass1.I$0 = i2;
                        anonymousClass1.label = 2;
                        if (function2.invoke(safeCollector2, anonymousClass1) != coroutine_suspended) {
                            safeCollector = safeCollector2;
                            safeCollector.releaseIntercepted();
                        }
                        return coroutine_suspended;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        if (booleanRef.element) {
        }
        return Unit.INSTANCE;
    }
}
