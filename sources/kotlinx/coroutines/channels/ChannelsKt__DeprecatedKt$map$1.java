package kotlinx.coroutines.channels;

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
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {667, 363, 363}, m = "invokeSuspend", n = {"$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$map$1$1", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$map$1$1"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$map$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_map;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
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
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.$this_map = receiveChannel;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, continuation);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ed A[Catch: all -> 0x017b, TryCatch #1 {all -> 0x017b, blocks: (B:8:0x0032, B:22:0x00bc, B:25:0x00e5, B:27:0x00ed, B:31:0x0134, B:36:0x0173, B:18:0x00a1, B:21:0x00b0), top: B:47:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0173 A[Catch: all -> 0x017b, TRY_LEAVE, TryCatch #1 {all -> 0x017b, blocks: (B:8:0x0032, B:22:0x00bc, B:25:0x00e5, B:27:0x00ed, B:31:0x0134, B:36:0x0173, B:18:0x00a1, B:21:0x00b0), top: B:47:0x0010 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0169 -> B:35:0x016f). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        ReceiveChannel receiveChannel;
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
        Object obj3;
        Object obj4;
        ChannelIterator channelIterator;
        int i4;
        int i5;
        ProducerScope producerScope;
        Throwable th3;
        int i6;
        Object obj5;
        ProducerScope producerScope2 = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        Object obj6 = null;
        try {
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                receiveChannel = this.$this_map;
                function2 = this.$transform;
                it = receiveChannel.iterator();
                th2 = null;
                receiveChannel2 = receiveChannel;
                receiveChannel3 = receiveChannel2;
                i = 0;
                i2 = 0;
                i3 = 0;
                this.L$0 = producerScope2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                this.L$2 = function2;
                this.L$3 = receiveChannel;
                this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                this.L$5 = it;
                this.L$6 = obj6;
                this.L$7 = obj6;
                this.I$0 = i3;
                this.I$1 = i2;
                this.I$2 = i;
                this.label = 1;
                obj5 = it.hasNext(this);
                if (obj5 == coroutine_suspended) {
                }
                if (!((Boolean) obj5).booleanValue()) {
                }
            } else if (i7 == 1) {
                i = this.I$2;
                i2 = this.I$1;
                i3 = this.I$0;
                it = (ChannelIterator) this.L$5;
                receiveChannel2 = (ReceiveChannel) this.L$4;
                receiveChannel = (ReceiveChannel) this.L$3;
                function2 = (Function2) this.L$2;
                receiveChannel3 = (ReceiveChannel) this.L$1;
                ResultKt.throwOnFailure(obj);
                obj5 = obj;
                th2 = null;
                if (!((Boolean) obj5).booleanValue()) {
                }
            } else if (i7 == 2) {
                int i8 = this.I$3;
                int i9 = this.I$2;
                int i10 = this.I$1;
                int i11 = this.I$0;
                ProducerScope producerScope3 = (ProducerScope) this.L$8;
                Object obj7 = this.L$7;
                Object obj8 = this.L$6;
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$5;
                ReceiveChannel receiveChannel5 = (ReceiveChannel) this.L$4;
                ReceiveChannel receiveChannel6 = (ReceiveChannel) this.L$3;
                Function2 function23 = (Function2) this.L$2;
                ReceiveChannel receiveChannel7 = (ReceiveChannel) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    i6 = i8;
                    i = i9;
                    i5 = i10;
                    i4 = i11;
                    channelIterator = channelIterator2;
                    function22 = function23;
                    receiveChannel2 = receiveChannel5;
                    receiveChannel4 = receiveChannel7;
                    producerScope = producerScope3;
                    obj2 = obj8;
                    obj4 = obj;
                    obj3 = obj7;
                    receiveChannel = receiveChannel6;
                    th3 = null;
                    this.L$0 = producerScope2;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    this.L$2 = function22;
                    this.L$3 = receiveChannel;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$5 = channelIterator;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(obj3);
                    obj6 = null;
                    this.L$8 = null;
                    this.I$0 = i4;
                    this.I$1 = i5;
                    this.I$2 = i;
                    this.I$3 = i6;
                    this.label = 3;
                    if (producerScope.send(obj4, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    receiveChannel = receiveChannel6;
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
                int i12 = this.I$0;
                ChannelIterator channelIterator3 = (ChannelIterator) this.L$5;
                ReceiveChannel receiveChannel8 = (ReceiveChannel) this.L$4;
                receiveChannel = (ReceiveChannel) this.L$3;
                Function2 function24 = (Function2) this.L$2;
                ReceiveChannel receiveChannel9 = (ReceiveChannel) this.L$1;
                ResultKt.throwOnFailure(obj);
                i3 = i12;
                it = channelIterator3;
                receiveChannel2 = receiveChannel8;
                receiveChannel3 = receiveChannel9;
                th2 = null;
                i2 = i5;
                function2 = function24;
                this.L$0 = producerScope2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                this.L$2 = function2;
                this.L$3 = receiveChannel;
                this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                this.L$5 = it;
                this.L$6 = obj6;
                this.L$7 = obj6;
                this.I$0 = i3;
                this.I$1 = i2;
                this.I$2 = i;
                this.label = 1;
                obj5 = it.hasNext(this);
                if (obj5 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!((Boolean) obj5).booleanValue()) {
                    obj3 = it.next();
                    this.L$0 = producerScope2;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                    this.L$2 = function2;
                    this.L$3 = receiveChannel;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$5 = it;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(obj3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(obj3);
                    this.L$8 = producerScope2;
                    this.I$0 = i3;
                    this.I$1 = i2;
                    this.I$2 = i;
                    this.I$3 = 0;
                    this.label = 2;
                    obj4 = function2.invoke(obj3, this);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function2 function25 = function2;
                    i5 = i2;
                    i6 = 0;
                    function22 = function25;
                    receiveChannel4 = receiveChannel3;
                    obj2 = obj3;
                    i4 = i3;
                    th3 = th2;
                    channelIterator = it;
                    producerScope = producerScope2;
                    this.L$0 = producerScope2;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                    this.L$2 = function22;
                    this.L$3 = receiveChannel;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$5 = channelIterator;
                    this.L$6 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(obj3);
                    obj6 = null;
                    this.L$8 = null;
                    this.I$0 = i4;
                    this.I$1 = i5;
                    this.I$2 = i;
                    this.I$3 = i6;
                    this.label = 3;
                    if (producerScope.send(obj4, this) != coroutine_suspended) {
                        it = channelIterator;
                        function24 = function22;
                        th2 = th3;
                        i3 = i4;
                        receiveChannel3 = receiveChannel4;
                        i2 = i5;
                        function2 = function24;
                        this.L$0 = producerScope2;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        this.L$2 = function2;
                        this.L$3 = receiveChannel;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                        this.L$5 = it;
                        this.L$6 = obj6;
                        this.L$7 = obj6;
                        this.I$0 = i3;
                        this.I$1 = i2;
                        this.I$2 = i;
                        this.label = 1;
                        obj5 = it.hasNext(this);
                        if (obj5 == coroutine_suspended) {
                        }
                        if (!((Boolean) obj5).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel, th2);
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
