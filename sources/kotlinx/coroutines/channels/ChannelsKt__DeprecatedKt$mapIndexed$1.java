package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {374, 375, 375}, m = "invokeSuspend", n = {"$this$produce", FirebaseAnalytics.Param.INDEX, "$this$produce", "e", FirebaseAnalytics.Param.INDEX, "$this$produce", "e", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "L$2", "I$0"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        if (r12 == r1) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a9 -> B:13:0x004d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        ChannelIterator it;
        ChannelIterator channelIterator;
        Object obj2;
        ProducerScope producerScope;
        ProducerScope producerScope2 = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            it = this.$this_mapIndexed.iterator();
        } else if (i2 == 1) {
            i = this.I$0;
            it = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                obj2 = it.next();
                Function3<Integer, E, Continuation<? super R>, Object> function3 = this.$transform;
                int i3 = i + 1;
                Integer boxInt = Boxing.boxInt(i);
                this.L$0 = producerScope2;
                this.L$1 = it;
                this.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$3 = producerScope2;
                this.I$0 = i3;
                this.label = 2;
                obj = function3.invoke(boxInt, obj2, this);
                if (obj != coroutine_suspended) {
                    i = i3;
                    channelIterator = it;
                    producerScope = producerScope2;
                    this.L$0 = producerScope2;
                    this.L$1 = channelIterator;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.L$3 = null;
                    this.I$0 = i;
                    this.label = 3;
                    if (producerScope.send(obj, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (i2 == 2) {
            i = this.I$0;
            producerScope = (ProducerScope) this.L$3;
            obj2 = this.L$2;
            channelIterator = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            this.L$0 = producerScope2;
            this.L$1 = channelIterator;
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$3 = null;
            this.I$0 = i;
            this.label = 3;
            if (producerScope.send(obj, this) != coroutine_suspended) {
                it = channelIterator;
            }
            return coroutine_suspended;
        } else if (i2 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$0;
            it = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = producerScope2;
        this.L$1 = it;
        this.L$2 = null;
        this.I$0 = i;
        this.label = 1;
        obj = it.hasNext(this);
    }
}
