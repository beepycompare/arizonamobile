package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {DownloaderService.STATUS_WAITING_TO_RETRY, 199, 200}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "e", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$2", "I$0"}, v = 1)
/* loaded from: classes5.dex */
final class ChannelsKt__DeprecatedKt$drop$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$drop$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$drop$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_drop = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, continuation);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        if (r10 == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
        if (r2 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
        if (r0.send(r10, r9) == r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0063 -> B:23:0x0066). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b6 -> B:8:0x001e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        ChannelIterator<E> it;
        int i2;
        ChannelIterator<E> it2;
        ChannelIterator<E> channelIterator;
        int i3;
        Object hasNext;
        ProducerScope producerScope = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.$n;
            if (!(i >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
            if (i > 0) {
                it = this.$this_drop.iterator();
                i2 = i;
                this.L$0 = producerScope;
                this.L$1 = it;
                this.I$0 = i2;
                this.label = 1;
                obj = it.hasNext(this);
            }
            it2 = this.$this_drop.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.L$2 = null;
            this.I$0 = i;
            this.label = 2;
            hasNext = it2.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i4 == 1) {
            i2 = this.I$0;
            it = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                it.next();
                i2--;
            }
            i = i2;
            it2 = this.$this_drop.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.L$2 = null;
            this.I$0 = i;
            this.label = 2;
            hasNext = it2.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i4 != 2) {
            if (i4 == 3) {
                i3 = this.I$0;
                channelIterator = (ChannelIterator) this.L$1;
                ResultKt.throwOnFailure(obj);
                i = i3;
                it2 = channelIterator;
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.L$2 = null;
                this.I$0 = i;
                this.label = 2;
                hasNext = it2.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    ChannelIterator<E> channelIterator2 = it2;
                    i3 = i;
                    obj = hasNext;
                    channelIterator = channelIterator2;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = channelIterator.next();
                    this.L$0 = producerScope;
                    this.L$1 = channelIterator;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(next);
                    this.I$0 = i3;
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i3 = this.I$0;
            channelIterator = (ChannelIterator) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }
}
