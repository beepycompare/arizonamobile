package kotlinx.coroutines.channels;

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
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 2, 3, 4, 4}, l = {211, 212, 213, 217, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "e", "$this$produce", "$this$produce", "e"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1", "L$0", "L$0", "L$2"}, v = 1)
/* loaded from: classes5.dex */
final class ChannelsKt__DeprecatedKt$dropWhile$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
        if (r12 == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
        if (r0.send(r2, r11) == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e4, code lost:
        if (r0.send(r12, r11) == r1) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0087 -> B:27:0x008a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e4 -> B:10:0x0023). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<E> it;
        ChannelIterator<E> channelIterator;
        Object hasNext;
        ChannelIterator<E> it2;
        ChannelIterator<E> channelIterator2;
        Object hasNext2;
        ProducerScope producerScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$this_dropWhile.iterator();
            this.L$0 = producerScope;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            hasNext = it.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            channelIterator = (ChannelIterator) this.L$1;
            if (((Boolean) obj).booleanValue()) {
            }
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.L$2 = null;
            this.label = 4;
            hasNext2 = it2.hasNext(this);
            if (hasNext2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i == 2) {
            Object next = this.L$2;
            channelIterator = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                it = channelIterator;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        next = channelIterator.next();
                        this.L$0 = producerScope;
                        this.L$1 = channelIterator;
                        this.L$2 = next;
                        this.label = 2;
                        obj = this.$predicate.invoke(next, this);
                    }
                    it2 = this.$this_dropWhile.iterator();
                    this.L$0 = producerScope;
                    this.L$1 = it2;
                    this.L$2 = null;
                    this.label = 4;
                    hasNext2 = it2.hasNext(this);
                    if (hasNext2 != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            this.L$0 = producerScope;
            this.L$1 = SpillingKt.nullOutSpilledVariable(next);
            this.L$2 = null;
            this.label = 3;
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.L$2 = null;
            this.label = 4;
            hasNext2 = it2.hasNext(this);
            if (hasNext2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i != 4) {
            if (i == 5) {
                channelIterator2 = (ChannelIterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                it2 = channelIterator2;
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.L$2 = null;
                this.label = 4;
                hasNext2 = it2.hasNext(this);
                if (hasNext2 != coroutine_suspended) {
                    channelIterator2 = it2;
                    obj = hasNext2;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next2 = channelIterator2.next();
                    this.L$0 = producerScope;
                    this.L$1 = channelIterator2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(next2);
                    this.label = 5;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            channelIterator2 = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }
}
