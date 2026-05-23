package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Emitters.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1", f = "Share.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ShareKt$asFlow$$inlined$transform$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$asFlow$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$asFlow$$inlined$transform$1 flowKt__ShareKt$asFlow$$inlined$transform$1 = new FlowKt__ShareKt$asFlow$$inlined$transform$1(this.$this_transform, continuation);
        flowKt__ShareKt$asFlow$$inlined$transform$1.L$0 = obj;
        return flowKt__ShareKt$asFlow$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$asFlow$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $$this$flow;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1", f = "Share.kt", i = {0, 0, 0, 0, 0}, l = {39}, m = "emit", n = {"value", "$completion", "value", "$this$asFlow_u24lambda_u240", "$i$a$-transform-FlowKt__ShareKt$asFlow$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C00781 extends ContinuationImpl {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            public C00781(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            C00781 c00781;
            int i;
            if (continuation instanceof C00781) {
                c00781 = (C00781) continuation;
                if ((c00781.label & Integer.MIN_VALUE) != 0) {
                    c00781.label -= Integer.MIN_VALUE;
                    Object obj = c00781.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c00781.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<T> flowCollector = this.$$this$flow;
                        c00781.L$0 = SpillingKt.nullOutSpilledVariable(t);
                        c00781.L$1 = SpillingKt.nullOutSpilledVariable(c00781);
                        c00781.L$2 = SpillingKt.nullOutSpilledVariable(t);
                        c00781.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        c00781.I$0 = 0;
                        c00781.label = 1;
                        if (flowCollector.emit(t, c00781) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i2 = c00781.I$0;
                        FlowCollector flowCollector2 = (FlowCollector) c00781.L$3;
                        Object obj2 = c00781.L$2;
                        Continuation continuation2 = (Continuation) c00781.L$1;
                        Object obj3 = c00781.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
            c00781 = new C00781(continuation);
            Object obj4 = c00781.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = c00781.label;
            if (i != 0) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.$this_transform.collect(new AnonymousClass1(flowCollector), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
