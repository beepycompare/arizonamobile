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
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.common.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1<R> implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    /* compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $this_unsafeFlow;
        final /* synthetic */ Function2 $transform$inlined;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {217, 217}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
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
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
            this.$this_unsafeFlow = flowCollector;
            this.$transform$inlined = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object emit$$forInline(Object obj, Continuation continuation) {
            new AnonymousClass1(continuation);
            this.$this_unsafeFlow.emit(this.$transform$inlined.invoke(obj, continuation), continuation);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00b3, code lost:
            if (r8.emit(r9, r0) != r1) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1;
            int i;
            AnonymousClass1 anonymousClass12;
            Object obj;
            Object obj2;
            FlowCollector flowCollector;
            int i2;
            FlowCollector flowCollector2;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label -= Integer.MIN_VALUE;
                    Object obj3 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        FlowCollector flowCollector3 = this.$this_unsafeFlow;
                        anonymousClass12 = anonymousClass1;
                        Function2 function2 = this.$transform$inlined;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(t);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                        anonymousClass1.L$4 = flowCollector3;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        Object invoke = function2.invoke(t, anonymousClass1);
                        if (invoke != coroutine_suspended) {
                            obj = t;
                            obj2 = obj;
                            flowCollector = flowCollector3;
                            obj3 = invoke;
                            i2 = 0;
                            flowCollector2 = flowCollector;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            int i3 = anonymousClass1.I$0;
                            FlowCollector flowCollector4 = (FlowCollector) anonymousClass1.L$3;
                            Object obj4 = anonymousClass1.L$2;
                            Continuation continuation2 = (Continuation) anonymousClass1.L$1;
                            Object obj5 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        i2 = anonymousClass1.I$0;
                        flowCollector = (FlowCollector) anonymousClass1.L$4;
                        flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                        obj = anonymousClass1.L$2;
                        anonymousClass12 = (Continuation) anonymousClass1.L$1;
                        obj2 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj3);
                    }
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                    anonymousClass1.L$4 = null;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.label = 2;
                }
            }
            anonymousClass1 = new AnonymousClass1(continuation);
            Object obj32 = anonymousClass1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = anonymousClass1.label;
            if (i != 0) {
            }
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            anonymousClass1.L$4 = null;
            anonymousClass1.I$0 = i2;
            anonymousClass1.label = 2;
        }
    }

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined$1 = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$transform$inlined$1), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$map$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$transform$inlined$1), continuation);
        return Unit.INSTANCE;
    }
}
