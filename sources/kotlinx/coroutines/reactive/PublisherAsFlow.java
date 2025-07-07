package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.reactivestreams.Publisher;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0082@¢\u0006\u0002\u0010\u0019J$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0082@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0094@¢\u0006\u0002\u0010!R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "publisher", "Lorg/reactivestreams/Publisher;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "requestSize", "", "getRequestSize$annotations", "()V", "getRequestSize", "()J", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSlowPath", "collectImpl", "injectContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-reactive"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PublisherAsFlow<T> extends ChannelFlow<T> {
    private final Publisher<T> publisher;

    private static /* synthetic */ void getRequestSize$annotations() {
    }

    public /* synthetic */ PublisherAsFlow(Publisher publisher, EmptyCoroutineContext emptyCoroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(publisher, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public PublisherAsFlow(Publisher<T> publisher, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.publisher = publisher;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> create(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new PublisherAsFlow(this.publisher, coroutineContext, i, bufferOverflow);
    }

    private final long getRequestSize() {
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            return Long.MAX_VALUE;
        }
        int i = this.capacity;
        if (i != -2) {
            if (i != 0) {
                if (i != Integer.MAX_VALUE) {
                    long j = this.capacity;
                    if (j >= 1) {
                        return j;
                    }
                    throw new IllegalStateException("Check failed.");
                }
                return Long.MAX_VALUE;
            }
            return 1L;
        }
        return Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        CoroutineContext context = continuation.getContext();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) this.context.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null || Intrinsics.areEqual(continuationInterceptor, context.get(ContinuationInterceptor.Key))) {
            Object collectImpl = collectImpl(context.plus(this.context), flowCollector, continuation);
            return collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
        }
        Object collectSlowPath = collectSlowPath(flowCollector, continuation);
        return collectSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectSlowPath : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b6, code lost:
        if (r0 == r3) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #0 {all -> 0x005d, blocks: (B:13:0x003d, B:33:0x00b9, B:35:0x00c5, B:23:0x0083, B:30:0x00a1, B:18:0x0059), top: B:40:0x0029 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.reactive.ReactiveSubscriber] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b6 -> B:14:0x0040). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImpl(CoroutineContext coroutineContext, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$1;
        ReactiveSubscriber reactiveSubscriber;
        ReactiveSubscriber reactiveSubscriber2;
        PublisherAsFlow<T> publisherAsFlow;
        long j;
        FlowCollector<? super T> flowCollector2;
        PublisherAsFlow<T> publisherAsFlow2;
        FlowCollector flowCollector3;
        long j2;
        ReactiveSubscriber reactiveSubscriber3;
        Object takeNextOrNull;
        try {
            if (continuation instanceof PublisherAsFlow$collectImpl$1) {
                publisherAsFlow$collectImpl$1 = (PublisherAsFlow$collectImpl$1) continuation;
                if ((publisherAsFlow$collectImpl$1.label & Integer.MIN_VALUE) != 0) {
                    publisherAsFlow$collectImpl$1.label -= Integer.MIN_VALUE;
                    Object obj = publisherAsFlow$collectImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
                    if (reactiveSubscriber != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReactiveSubscriber reactiveSubscriber4 = new ReactiveSubscriber(this.capacity, this.onBufferOverflow, getRequestSize());
                        ReactiveFlowKt.injectCoroutineContext(this.publisher, coroutineContext).subscribe(reactiveSubscriber4);
                        reactiveSubscriber2 = reactiveSubscriber4;
                        publisherAsFlow = this;
                        j = 0;
                        flowCollector2 = flowCollector;
                        publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                        publisherAsFlow$collectImpl$1.L$1 = flowCollector2;
                        publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber2;
                        publisherAsFlow$collectImpl$1.J$0 = j;
                        publisherAsFlow$collectImpl$1.label = 1;
                        takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                        if (takeNextOrNull != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    } else if (reactiveSubscriber != 1) {
                        if (reactiveSubscriber == 2) {
                            j2 = publisherAsFlow$collectImpl$1.J$0;
                            ReactiveSubscriber reactiveSubscriber5 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$2;
                            FlowCollector<? super T> flowCollector4 = (FlowCollector) publisherAsFlow$collectImpl$1.L$1;
                            publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            reactiveSubscriber = reactiveSubscriber5;
                            FlowCollector<? super T> flowCollector5 = flowCollector4;
                            flowCollector2 = flowCollector5;
                            j = j2 + 1;
                            if (j == publisherAsFlow2.getRequestSize()) {
                                reactiveSubscriber.makeRequest();
                                j = 0;
                            }
                            publisherAsFlow = publisherAsFlow2;
                            reactiveSubscriber2 = reactiveSubscriber;
                            publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                            publisherAsFlow$collectImpl$1.L$1 = flowCollector2;
                            publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber2;
                            publisherAsFlow$collectImpl$1.J$0 = j;
                            publisherAsFlow$collectImpl$1.label = 1;
                            takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                            if (takeNextOrNull != coroutine_suspended) {
                                flowCollector3 = flowCollector2;
                                obj = takeNextOrNull;
                                publisherAsFlow2 = publisherAsFlow;
                                j2 = j;
                                reactiveSubscriber3 = reactiveSubscriber2;
                                if (obj == null) {
                                    JobKt.ensureActive(publisherAsFlow$collectImpl$1.getContext());
                                    publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow2;
                                    publisherAsFlow$collectImpl$1.L$1 = flowCollector3;
                                    publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber3;
                                    publisherAsFlow$collectImpl$1.J$0 = j2;
                                    publisherAsFlow$collectImpl$1.label = 2;
                                    Object emit = flowCollector3.emit(obj, publisherAsFlow$collectImpl$1);
                                    reactiveSubscriber = reactiveSubscriber3;
                                    flowCollector5 = flowCollector3;
                                } else {
                                    reactiveSubscriber3.cancel();
                                    return Unit.INSTANCE;
                                }
                            }
                            return coroutine_suspended;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j2 = publisherAsFlow$collectImpl$1.J$0;
                        ReactiveSubscriber reactiveSubscriber6 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$2;
                        FlowCollector flowCollector6 = (FlowCollector) publisherAsFlow$collectImpl$1.L$1;
                        publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        reactiveSubscriber3 = reactiveSubscriber6;
                        flowCollector3 = flowCollector6;
                        if (obj == null) {
                        }
                    }
                }
            }
            if (reactiveSubscriber != 0) {
            }
        } catch (Throwable th) {
            reactiveSubscriber.cancel();
            throw th;
        }
        publisherAsFlow$collectImpl$1 = new PublisherAsFlow$collectImpl$1(this, continuation);
        Object obj2 = publisherAsFlow$collectImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        return collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
    }
}
