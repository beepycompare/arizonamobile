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
public final class FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1<R> implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    /* compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $this_unsafeFlow;
        final /* synthetic */ Function2 $transform$inlined;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {217, 218}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1", "value", "$completion", "value", "$this$mapNotNull_u24lambda_u240", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
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
            FlowCollector flowCollector = this.$this_unsafeFlow;
            Object invoke = this.$transform$inlined.invoke(obj, continuation);
            if (invoke != null) {
                flowCollector.emit(invoke, continuation);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
            if (r7.emit(r8, r0) == r1) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1;
            Object obj;
            int i;
            Continuation continuation2;
            Object obj2;
            FlowCollector flowCollector;
            int i2;
            Object obj3;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label -= Integer.MIN_VALUE;
                    obj = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector2 = this.$this_unsafeFlow;
                        AnonymousClass1 anonymousClass12 = anonymousClass1;
                        Function2 function2 = this.$transform$inlined;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(t);
                        anonymousClass1.L$3 = flowCollector2;
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        Object invoke = function2.invoke(t, anonymousClass1);
                        if (invoke != coroutine_suspended) {
                            continuation2 = anonymousClass12;
                            obj2 = t;
                            flowCollector = flowCollector2;
                            obj = invoke;
                            i2 = 0;
                            obj3 = obj2;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            int i3 = anonymousClass1.I$0;
                            Object obj4 = anonymousClass1.L$4;
                            FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$3;
                            Object obj5 = anonymousClass1.L$2;
                            Continuation continuation3 = (Continuation) anonymousClass1.L$1;
                            Object obj6 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        i2 = anonymousClass1.I$0;
                        flowCollector = (FlowCollector) anonymousClass1.L$3;
                        obj2 = anonymousClass1.L$2;
                        continuation2 = (Continuation) anonymousClass1.L$1;
                        obj3 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    if (obj != null) {
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.I$0 = i2;
                        anonymousClass1.label = 2;
                    }
                    return Unit.INSTANCE;
                }
            }
            anonymousClass1 = new AnonymousClass1(continuation);
            obj = anonymousClass1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = anonymousClass1.label;
            if (i != 0) {
            }
            if (obj != null) {
            }
            return Unit.INSTANCE;
        }
    }

    public FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined$1 = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$transform$inlined$1), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$transform$inlined$1), continuation);
        return Unit.INSTANCE;
    }
}
