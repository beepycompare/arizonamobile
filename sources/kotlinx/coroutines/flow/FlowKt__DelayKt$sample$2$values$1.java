package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_sample;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$values$1(Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2$values$1> continuation) {
        super(2, continuation);
        this.$this_sample = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, continuation);
        flowKt__DelayKt$sample$2$values$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$values$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<Object>) producerScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<Object> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$values$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Delay.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<Object> $$this$produce;

        AnonymousClass1(ProducerScope<Object> producerScope) {
            this.$$this$produce = producerScope;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            FlowKt__DelayKt$sample$2$values$1$1$emit$1 flowKt__DelayKt$sample$2$values$1$1$emit$1;
            int i;
            if (continuation instanceof FlowKt__DelayKt$sample$2$values$1$1$emit$1) {
                flowKt__DelayKt$sample$2$values$1$1$emit$1 = (FlowKt__DelayKt$sample$2$values$1$1$emit$1) continuation;
                if ((flowKt__DelayKt$sample$2$values$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__DelayKt$sample$2$values$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object obj = flowKt__DelayKt$sample$2$values$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__DelayKt$sample$2$values$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ProducerScope<Object> producerScope = this.$$this$produce;
                        if (t == null) {
                            t = (T) NullSurrogateKt.NULL;
                        }
                        flowKt__DelayKt$sample$2$values$1$1$emit$1.label = 1;
                        if (producerScope.send(t, flowKt__DelayKt$sample$2$values$1$1$emit$1) == coroutine_suspended) {
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
            flowKt__DelayKt$sample$2$values$1$1$emit$1 = new FlowKt__DelayKt$sample$2$values$1$1$emit$1(this, continuation);
            Object obj2 = flowKt__DelayKt$sample$2$values$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = flowKt__DelayKt$sample$2$values$1$1$emit$1.label;
            if (i != 0) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$this_sample.collect(new AnonymousClass1((ProducerScope) this.L$0), this) == coroutine_suspended) {
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
