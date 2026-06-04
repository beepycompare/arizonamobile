package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "value", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0, 0, 0, 0, 0}, l = {236}, m = "invokeSuspend", n = {"value", "$v$c$kotlinx-coroutines-channels-ChannelResult$-$this$onFailure$0$iv", "it", "$i$f$onFailure-WpGqRn0", "$i$a$-onFailure-WpGqRn0-FlowKt__DelayKt$debounceInternal$1$3$2$2"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = ((ChannelResult) obj).m11456unboximpl();
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return m11472invokeWpGqRn0(channelResult.m11456unboximpl(), continuation);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m11472invokeWpGqRn0(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.m11444boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        ?? r0 = this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<Object> objectRef3 = this.$lastValue;
            boolean z = r0 instanceof ChannelResult.Failed;
            if (!z) {
                objectRef3.element = r0;
            }
            objectRef = this.$lastValue;
            FlowCollector<T> flowCollector = this.$downstream;
            if (z) {
                Throwable m11448exceptionOrNullimpl = ChannelResult.m11448exceptionOrNullimpl(r0);
                if (m11448exceptionOrNullimpl != null) {
                    throw m11448exceptionOrNullimpl;
                }
                if (objectRef.element != null) {
                    Symbol symbol = NullSurrogateKt.NULL;
                    Object obj2 = objectRef.element;
                    if (obj2 == symbol) {
                        obj2 = null;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(r0);
                    this.L$1 = r0;
                    this.L$2 = objectRef;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(m11448exceptionOrNullimpl);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.element = NullSurrogateKt.DONE;
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Throwable th = (Throwable) this.L$3;
            objectRef2 = (Ref.ObjectRef) this.L$2;
            ResultKt.throwOnFailure(obj);
        }
        objectRef = objectRef2;
        objectRef.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
