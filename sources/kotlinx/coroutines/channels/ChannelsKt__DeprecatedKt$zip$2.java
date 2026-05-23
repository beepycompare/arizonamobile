package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {667, 499, TypedValues.PositionType.TYPE_TRANSITION_EASING}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "element1", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$zip$2$1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "element1", "element2", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$zip$2$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<R> $other;
    final /* synthetic */ ReceiveChannel<E> $this_zip;
    final /* synthetic */ Function2<E, R, V> $transform;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0101 A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:8:0x0036, B:22:0x00cc, B:25:0x00f9, B:27:0x0101, B:31:0x0143, B:33:0x014b, B:41:0x01ab, B:18:0x00aa, B:21:0x00bf), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b A[Catch: all -> 0x01b3, TryCatch #0 {all -> 0x01b3, blocks: (B:8:0x0036, B:22:0x00cc, B:25:0x00f9, B:27:0x0101, B:31:0x0143, B:33:0x014b, B:41:0x01ab, B:18:0x00aa, B:21:0x00bf), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ab A[Catch: all -> 0x01b3, TRY_LEAVE, TryCatch #0 {all -> 0x01b3, blocks: (B:8:0x0036, B:22:0x00cc, B:25:0x00f9, B:27:0x0101, B:31:0x0143, B:33:0x014b, B:41:0x01ab, B:18:0x00aa, B:21:0x00bf), top: B:50:0x0010 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0191 -> B:37:0x0193). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x019c -> B:38:0x0198). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        ReceiveChannel receiveChannel;
        ChannelIterator channelIterator;
        Function2 function2;
        ChannelIterator it;
        Throwable th2;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        int i;
        int i2;
        int i3;
        ReceiveChannel receiveChannel4;
        Object obj2;
        Function2 function22;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator2;
        int i4;
        int i5;
        Object obj3;
        Throwable th3;
        ChannelIterator channelIterator3;
        Object obj4;
        int i6;
        Object obj5;
        ProducerScope producerScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        Object obj6 = null;
        try {
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelIterator it2 = this.$other.iterator();
                receiveChannel = this.$this_zip;
                channelIterator = it2;
                function2 = this.$transform;
                it = receiveChannel.iterator();
                th2 = null;
                receiveChannel2 = receiveChannel;
                receiveChannel3 = receiveChannel2;
                i = 0;
                i2 = 0;
                i3 = 0;
                this.L$0 = producerScope;
                this.L$1 = channelIterator;
                this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                this.L$3 = function2;
                this.L$4 = receiveChannel;
                this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                this.L$6 = it;
                this.L$7 = obj6;
                this.L$8 = obj6;
                this.L$9 = obj6;
                this.I$0 = i3;
                this.I$1 = i2;
                this.I$2 = i;
                this.label = 1;
                obj5 = it.hasNext(this);
                if (obj5 == coroutine_suspended) {
                }
                if (((Boolean) obj5).booleanValue()) {
                }
            } else if (i7 == 1) {
                i = this.I$2;
                i2 = this.I$1;
                i3 = this.I$0;
                it = (ChannelIterator) this.L$6;
                receiveChannel2 = (ReceiveChannel) this.L$5;
                receiveChannel = (ReceiveChannel) this.L$4;
                function2 = (Function2) this.L$3;
                receiveChannel3 = (ReceiveChannel) this.L$2;
                channelIterator = (ChannelIterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                obj5 = obj;
                th2 = null;
                if (((Boolean) obj5).booleanValue()) {
                }
            } else if (i7 == 2) {
                int i8 = this.I$3;
                int i9 = this.I$2;
                i5 = this.I$1;
                i4 = this.I$0;
                Object obj7 = this.L$8;
                Object obj8 = this.L$7;
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$6;
                ReceiveChannel receiveChannel6 = (ReceiveChannel) this.L$5;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) this.L$4;
                Function2 function23 = (Function2) this.L$3;
                ReceiveChannel receiveChannel8 = (ReceiveChannel) this.L$2;
                channelIterator3 = (ChannelIterator) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    i6 = i8;
                    i = i9;
                    function22 = function23;
                    obj4 = obj8;
                    receiveChannel5 = receiveChannel6;
                    obj2 = obj7;
                    channelIterator2 = channelIterator4;
                    receiveChannel = receiveChannel7;
                    receiveChannel4 = receiveChannel8;
                    th3 = null;
                    obj3 = obj;
                    if (!((Boolean) obj3).booleanValue()) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    receiveChannel = receiveChannel7;
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        throw th5;
                    }
                }
            } else if (i7 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                i = this.I$2;
                i5 = this.I$1;
                i4 = this.I$0;
                channelIterator2 = (ChannelIterator) this.L$6;
                receiveChannel5 = (ReceiveChannel) this.L$5;
                receiveChannel = (ReceiveChannel) this.L$4;
                function22 = (Function2) this.L$3;
                ReceiveChannel receiveChannel9 = (ReceiveChannel) this.L$2;
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                ChannelIterator channelIterator6 = channelIterator5;
                th3 = null;
                ReceiveChannel receiveChannel10 = receiveChannel5;
                th2 = th3;
                receiveChannel2 = receiveChannel10;
                i3 = i4;
                receiveChannel3 = receiveChannel9;
                it = channelIterator2;
                channelIterator = channelIterator6;
                i2 = i5;
                function2 = function22;
                obj6 = null;
                this.L$0 = producerScope;
                this.L$1 = channelIterator;
                this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                this.L$3 = function2;
                this.L$4 = receiveChannel;
                this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                this.L$6 = it;
                this.L$7 = obj6;
                this.L$8 = obj6;
                this.L$9 = obj6;
                this.I$0 = i3;
                this.I$1 = i2;
                this.I$2 = i;
                this.label = 1;
                obj5 = it.hasNext(this);
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) obj5).booleanValue()) {
                    obj2 = it.next();
                    this.L$0 = producerScope;
                    this.L$1 = channelIterator;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.L$3 = function2;
                    this.L$4 = receiveChannel;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$6 = it;
                    this.L$7 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$8 = obj2;
                    this.I$0 = i3;
                    this.I$1 = i2;
                    this.I$2 = i;
                    this.I$3 = 0;
                    this.label = 2;
                    obj3 = channelIterator.hasNext(this);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ChannelIterator channelIterator7 = channelIterator;
                    channelIterator2 = it;
                    channelIterator3 = channelIterator7;
                    Throwable th6 = th2;
                    receiveChannel5 = receiveChannel2;
                    th3 = th6;
                    function22 = function2;
                    receiveChannel4 = receiveChannel3;
                    i5 = i2;
                    i4 = i3;
                    obj4 = obj2;
                    i6 = 0;
                    if (!((Boolean) obj3).booleanValue()) {
                        Object next = channelIterator3.next();
                        Object obj9 = obj4;
                        Object invoke = function22.invoke(obj2, next);
                        this.L$0 = producerScope;
                        this.L$1 = channelIterator3;
                        channelIterator6 = channelIterator3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        this.L$3 = function22;
                        this.L$4 = receiveChannel;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        this.L$6 = channelIterator2;
                        this.L$7 = SpillingKt.nullOutSpilledVariable(obj9);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(next);
                        this.I$0 = i4;
                        this.I$1 = i5;
                        this.I$2 = i;
                        this.I$3 = i6;
                        this.label = 3;
                        if (producerScope.send(invoke, this) != coroutine_suspended) {
                            receiveChannel9 = receiveChannel4;
                            ReceiveChannel receiveChannel102 = receiveChannel5;
                            th2 = th3;
                            receiveChannel2 = receiveChannel102;
                            i3 = i4;
                            receiveChannel3 = receiveChannel9;
                            it = channelIterator2;
                            channelIterator = channelIterator6;
                            i2 = i5;
                            function2 = function22;
                            obj6 = null;
                            this.L$0 = producerScope;
                            this.L$1 = channelIterator;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                            this.L$3 = function2;
                            this.L$4 = receiveChannel;
                            this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                            this.L$6 = it;
                            this.L$7 = obj6;
                            this.L$8 = obj6;
                            this.L$9 = obj6;
                            this.I$0 = i3;
                            this.I$1 = i2;
                            this.I$2 = i;
                            this.label = 1;
                            obj5 = it.hasNext(this);
                            if (obj5 == coroutine_suspended) {
                            }
                            if (((Boolean) obj5).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed(receiveChannel, th2);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    }
                    channelIterator6 = channelIterator3;
                    ReceiveChannel receiveChannel11 = receiveChannel5;
                    th2 = th3;
                    receiveChannel2 = receiveChannel11;
                    i3 = i4;
                    receiveChannel3 = receiveChannel4;
                    it = channelIterator2;
                    channelIterator = channelIterator6;
                    i2 = i5;
                    function2 = function22;
                    obj6 = null;
                    this.L$0 = producerScope;
                    this.L$1 = channelIterator;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.L$3 = function2;
                    this.L$4 = receiveChannel;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$6 = it;
                    this.L$7 = obj6;
                    this.L$8 = obj6;
                    this.L$9 = obj6;
                    this.I$0 = i3;
                    this.I$1 = i2;
                    this.I$2 = i;
                    this.label = 1;
                    obj5 = it.hasNext(this);
                    if (obj5 == coroutine_suspended) {
                    }
                    if (((Boolean) obj5).booleanValue()) {
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
