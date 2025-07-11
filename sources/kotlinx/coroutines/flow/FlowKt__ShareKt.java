package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\b\f\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002H\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0019\u001a,\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001a\u001aG\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00180\u001f0\u001eH\u0002¢\u0006\u0002\b \u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013\u001a\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020#\u001aP\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010%\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0(\u0012\u0006\u0012\u0004\u0018\u00010)0&¢\u0006\u0002\b*¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"shareIn", "Lkotlinx/coroutines/flow/SharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "replay", "", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "stateIn", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "launchSharingDeferred$FlowKt__ShareKt", "asSharedFlow", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ShareKt {
    public static /* synthetic */ SharedFlow shareIn$default(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return FlowKt.shareIn(flow, coroutineScope, sharingStarted, i);
    }

    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i) {
        SharingConfig configureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(flow, i);
        MutableSharedFlow MutableSharedFlow = SharedFlowKt.MutableSharedFlow(i, configureSharing$FlowKt__ShareKt.extraBufferCapacity, configureSharing$FlowKt__ShareKt.onBufferOverflow);
        return new ReadonlySharedFlow(MutableSharedFlow, launchSharing$FlowKt__ShareKt(coroutineScope, configureSharing$FlowKt__ShareKt.context, configureSharing$FlowKt__ShareKt.upstream, MutableSharedFlow, sharingStarted, SharedFlowKt.NO_VALUE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x003f, code lost:
        if (r1.capacity == 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> SharingConfig<T> configureSharing$FlowKt__ShareKt(Flow<? extends T> flow, int i) {
        ChannelFlow channelFlow;
        Flow<T> dropChannelOperators;
        if (!DebugKt.getASSERTIONS_ENABLED() || i >= 0) {
            int coerceAtLeast = RangesKt.coerceAtLeast(i, Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - i;
            if ((flow instanceof ChannelFlow) && (dropChannelOperators = (channelFlow = (ChannelFlow) flow).dropChannelOperators()) != null) {
                int i2 = channelFlow.capacity;
                if (i2 != -3 && i2 != -2 && i2 != 0) {
                    coerceAtLeast = channelFlow.capacity;
                } else if (channelFlow.onBufferOverflow != BufferOverflow.SUSPEND) {
                    if (i == 0) {
                        coerceAtLeast = 1;
                    }
                    coerceAtLeast = 0;
                }
                return new SharingConfig<>(dropChannelOperators, coerceAtLeast, channelFlow.onBufferOverflow, channelFlow.context);
            }
            return new SharingConfig<>(flow, coerceAtLeast, BufferOverflow.SUSPEND, EmptyCoroutineContext.INSTANCE);
        }
        throw new AssertionError();
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
        return BuildersKt.launch(coroutineScope, coroutineContext, Intrinsics.areEqual(sharingStarted, SharingStarted.Companion.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(sharingStarted, flow, mutableSharedFlow, t, null));
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, T t) {
        SharingConfig configureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(flow, 1);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(t);
        return new ReadonlyStateFlow(MutableStateFlow, launchSharing$FlowKt__ShareKt(coroutineScope, configureSharing$FlowKt__ShareKt.context, configureSharing$FlowKt__ShareKt.upstream, MutableStateFlow, sharingStarted, t));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object stateIn(Flow<? extends T> flow, CoroutineScope coroutineScope, Continuation<? super StateFlow<? extends T>> continuation) {
        FlowKt__ShareKt$stateIn$1 flowKt__ShareKt$stateIn$1;
        int i;
        if (continuation instanceof FlowKt__ShareKt$stateIn$1) {
            flowKt__ShareKt$stateIn$1 = (FlowKt__ShareKt$stateIn$1) continuation;
            if ((flowKt__ShareKt$stateIn$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ShareKt$stateIn$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ShareKt$stateIn$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ShareKt$stateIn$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    SharingConfig configureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(flow, 1);
                    CompletableDeferred CompletableDeferred = CompletableDeferredKt.CompletableDeferred((Job) coroutineScope.getCoroutineContext().get(Job.Key));
                    launchSharingDeferred$FlowKt__ShareKt(coroutineScope, configureSharing$FlowKt__ShareKt.context, configureSharing$FlowKt__ShareKt.upstream, CompletableDeferred);
                    flowKt__ShareKt$stateIn$1.label = 1;
                    obj = CompletableDeferred.await(flowKt__ShareKt$stateIn$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                Object m8480unboximpl = ((Result) obj).m8480unboximpl();
                ResultKt.throwOnFailure(m8480unboximpl);
                return m8480unboximpl;
            }
        }
        flowKt__ShareKt$stateIn$1 = new FlowKt__ShareKt$stateIn$1(continuation);
        Object obj2 = flowKt__ShareKt$stateIn$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ShareKt$stateIn$1.label;
        if (i != 0) {
        }
        Object m8480unboximpl2 = ((Result) obj2).m8480unboximpl();
        ResultKt.throwOnFailure(m8480unboximpl2);
        return m8480unboximpl2;
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow<? extends T> flow, CompletableDeferred<Result<StateFlow<T>>> completableDeferred) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(flow, completableDeferred, null), 2, null);
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SubscribedSharedFlow(sharedFlow, function2);
    }
}
