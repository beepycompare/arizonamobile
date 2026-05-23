package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.NopCollector;
/* compiled from: Collect.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00022\u0006\u0010\u0007\u001a\u00020\b\u001ah\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00022H\b\u0004\u0010\n\u001aB\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bH\u0086H¢\u0006\u0002\u0010\u0013\u001aQ\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000221\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0086@¢\u0006\u0002\u0010\u0016\u001a,\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0002H\u0086@¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000223\b\u0004\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0087H¢\u0006\u0002\u0010\u0016\u001aS\u0010\u0014\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u001c23\b\b\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\u0086H¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"collect", "", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchIn", "Lkotlinx/coroutines/Job;", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectIndexed", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "value", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatest", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAll", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/SharedFlow;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object collect(Flow<?> flow, Continuation<? super Unit> continuation) {
        Object collect = flow.collect(NopCollector.INSTANCE, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final <T> Job launchIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FlowKt__CollectKt$launchIn$1(flow, null), 3, null);
        return launch$default;
    }

    public static final <T> Object collectIndexed(Flow<? extends T> flow, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object collect = flow.collect(new FlowKt__CollectKt$collectIndexed$2(function3), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    private static final <T> Object collectIndexed$$forInline(Flow<? extends T> flow, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        flow.collect(new FlowKt__CollectKt$collectIndexed$2(function3), continuation);
        return Unit.INSTANCE;
    }

    public static final <T> Object collectLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Flow buffer$default;
        buffer$default = FlowKt__ContextKt.buffer$default(FlowKt.mapLatest(flow, function2), 0, null, 2, null);
        Object collect = FlowKt.collect(buffer$default, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        FlowKt.ensureActive(flowCollector);
        Object collect = flow.collect(flowCollector, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object collect = flow.collect(new FlowKt__CollectKt$collect$3(function2), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object collect$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        flow.collect(new FlowKt__CollectKt$collect$3(function2), continuation);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collectLatest(SharedFlow<? extends T> sharedFlow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<?> continuation) {
        FlowKt__CollectKt$collectLatest$2 flowKt__CollectKt$collectLatest$2;
        int i;
        if (continuation instanceof FlowKt__CollectKt$collectLatest$2) {
            flowKt__CollectKt$collectLatest$2 = (FlowKt__CollectKt$collectLatest$2) continuation;
            if ((flowKt__CollectKt$collectLatest$2.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectKt$collectLatest$2.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectKt$collectLatest$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectKt$collectLatest$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
                    SharedFlow<? extends T> sharedFlow2 = sharedFlow;
                    flowKt__CollectKt$collectLatest$2.L$0 = SpillingKt.nullOutSpilledVariable(sharedFlow);
                    flowKt__CollectKt$collectLatest$2.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                    flowKt__CollectKt$collectLatest$2.I$0 = 0;
                    flowKt__CollectKt$collectLatest$2.label = 1;
                    if (FlowKt.collectLatest((Flow) sharedFlow2, (Function2) function2, (Continuation<? super Unit>) flowKt__CollectKt$collectLatest$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = flowKt__CollectKt$collectLatest$2.I$0;
                    Function2 function22 = (Function2) flowKt__CollectKt$collectLatest$2.L$1;
                    SharedFlow sharedFlow3 = (SharedFlow) flowKt__CollectKt$collectLatest$2.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("SharedFlow never completes, this call should never return.");
            }
        }
        flowKt__CollectKt$collectLatest$2 = new FlowKt__CollectKt$collectLatest$2(continuation);
        Object obj2 = flowKt__CollectKt$collectLatest$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectKt$collectLatest$2.label;
        if (i != 0) {
        }
        throw new IllegalStateException("SharedFlow never completes, this call should never return.");
    }

    private static final <T> Object collectLatest$$forInline(SharedFlow<? extends T> sharedFlow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<?> continuation) {
        Intrinsics.checkNotNull(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.FlowKt__CollectKt.collectLatest>");
        FlowKt.collectLatest((Flow) sharedFlow, (Function2) function2, (Continuation<? super Unit>) continuation);
        throw new IllegalStateException("SharedFlow never completes, this call should never return.");
    }
}
