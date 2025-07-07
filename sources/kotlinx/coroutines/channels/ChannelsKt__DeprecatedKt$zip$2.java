package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {514, 499, TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<R> $other;
    final /* synthetic */ ReceiveChannel<E> $this_zip;
    final /* synthetic */ Function2<E, R, V> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fc, code lost:
        if (r11.send(r14, r13) == r0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:27:0x00b0, B:29:0x00b8, B:41:0x0108, B:13:0x0049), top: B:55:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2 A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #2 {all -> 0x0105, blocks: (B:33:0x00da, B:35:0x00e2), top: B:53:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108 A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0056, blocks: (B:27:0x00b0, B:29:0x00b8, B:41:0x0108, B:13:0x0049), top: B:55:0x0049 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ff -> B:23:0x0092). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel receiveChannel;
        Function2 function2;
        ChannelIterator channelIterator;
        ChannelIterator it;
        ProducerScope producerScope;
        ReceiveChannel receiveChannel2;
        Throwable th;
        ProducerScope producerScope2;
        ChannelIterator channelIterator2;
        Function2 function22;
        ChannelIterator channelIterator3;
        Throwable th2;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope3 = (ProducerScope) this.L$0;
                ChannelIterator it2 = this.$other.iterator();
                receiveChannel = this.$this_zip;
                function2 = this.$transform;
                channelIterator = it2;
                it = receiveChannel.iterator();
                producerScope = producerScope3;
            } else if (i == 1) {
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$4;
                ReceiveChannel receiveChannel3 = (ReceiveChannel) this.L$3;
                Function2 function23 = (Function2) this.L$2;
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$1;
                ProducerScope producerScope4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope2 = producerScope4;
                channelIterator2 = channelIterator5;
                function22 = function23;
                receiveChannel2 = receiveChannel3;
                channelIterator3 = channelIterator4;
                th2 = null;
                if (!((Boolean) obj).booleanValue()) {
                }
            } else if (i == 2) {
                Object obj2 = this.L$5;
                ChannelIterator channelIterator6 = (ChannelIterator) this.L$4;
                receiveChannel2 = (ReceiveChannel) this.L$3;
                Function2 function24 = (Function2) this.L$2;
                ChannelIterator channelIterator7 = (ChannelIterator) this.L$1;
                ProducerScope producerScope5 = (ProducerScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Object obj3 = obj2;
                    it = channelIterator6;
                    ProducerScope producerScope6 = producerScope5;
                    ChannelIterator channelIterator8 = channelIterator7;
                    Function2 function25 = function24;
                    ReceiveChannel receiveChannel4 = receiveChannel2;
                    Throwable th3 = null;
                    try {
                        if (((Boolean) obj).booleanValue()) {
                            Object invoke = function25.invoke(obj3, channelIterator8.next());
                            this.L$0 = producerScope6;
                            this.L$1 = channelIterator8;
                            this.L$2 = function25;
                            this.L$3 = receiveChannel4;
                            this.L$4 = it;
                            this.L$5 = null;
                            this.label = 3;
                        }
                        th = th3;
                        receiveChannel = receiveChannel4;
                        function2 = function25;
                        channelIterator = channelIterator8;
                        producerScope = producerScope6;
                        this.L$0 = producerScope;
                        this.L$1 = channelIterator;
                        this.L$2 = function2;
                        this.L$3 = receiveChannel;
                        this.L$4 = it;
                        this.L$5 = null;
                        this.label = 1;
                        hasNext = it.hasNext(this);
                        if (hasNext != coroutine_suspended) {
                            ChannelIterator channelIterator9 = it;
                            th2 = th;
                            obj = hasNext;
                            producerScope2 = producerScope;
                            channelIterator2 = channelIterator;
                            function22 = function2;
                            receiveChannel2 = receiveChannel;
                            channelIterator3 = channelIterator9;
                            if (!((Boolean) obj).booleanValue()) {
                                Object next = channelIterator3.next();
                                this.L$0 = producerScope2;
                                this.L$1 = channelIterator2;
                                this.L$2 = function22;
                                this.L$3 = receiveChannel2;
                                this.L$4 = channelIterator3;
                                this.L$5 = next;
                                this.label = 2;
                                Object hasNext2 = channelIterator2.hasNext(this);
                                if (hasNext2 != coroutine_suspended) {
                                    ChannelIterator channelIterator10 = channelIterator3;
                                    obj3 = next;
                                    obj = hasNext2;
                                    producerScope6 = producerScope2;
                                    channelIterator8 = channelIterator2;
                                    function25 = function22;
                                    receiveChannel4 = receiveChannel2;
                                    th3 = th2;
                                    it = channelIterator10;
                                    if (((Boolean) obj).booleanValue()) {
                                    }
                                    th = th3;
                                    receiveChannel = receiveChannel4;
                                    function2 = function25;
                                    channelIterator = channelIterator8;
                                    producerScope = producerScope6;
                                    this.L$0 = producerScope;
                                    this.L$1 = channelIterator;
                                    this.L$2 = function2;
                                    this.L$3 = receiveChannel;
                                    this.L$4 = it;
                                    this.L$5 = null;
                                    this.label = 1;
                                    hasNext = it.hasNext(this);
                                    if (hasNext != coroutine_suspended) {
                                    }
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel = receiveChannel4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    receiveChannel = receiveChannel2;
                    throw th;
                }
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                it = (ChannelIterator) this.L$4;
                receiveChannel = (ReceiveChannel) this.L$3;
                function2 = (Function2) this.L$2;
                channelIterator = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            th = null;
            this.L$0 = producerScope;
            this.L$1 = channelIterator;
            this.L$2 = function2;
            this.L$3 = receiveChannel;
            this.L$4 = it;
            this.L$5 = null;
            this.label = 1;
            hasNext = it.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
