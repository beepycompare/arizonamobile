package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {DownloaderService.STATUS_WAITING_TO_RETRY, 199, 200}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
/* loaded from: classes5.dex */
final class ChannelsKt__DeprecatedKt$drop$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_drop;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (r9 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (r1 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (r4.send(r1.next(), r8) == r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:23:0x006c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ae -> B:8:0x001c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        int i;
        ChannelIterator<E> it;
        ProducerScope producerScope2;
        ChannelIterator<E> it2;
        ProducerScope producerScope3;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            i = this.$n;
            if (!(i >= 0)) {
                throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
            }
            if (i > 0) {
                it = this.$this_drop.iterator();
                producerScope2 = producerScope;
                this.L$0 = producerScope2;
                this.L$1 = it;
                this.I$0 = i;
                this.label = 1;
                obj = it.hasNext(this);
            }
            it2 = this.$this_drop.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.label = 2;
            hasNext = it2.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i2 == 1) {
            i = this.I$0;
            it = (ChannelIterator) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                it.next();
                i--;
            }
            producerScope = producerScope2;
            it2 = this.$this_drop.iterator();
            this.L$0 = producerScope;
            this.L$1 = it2;
            this.label = 2;
            hasNext = it2.hasNext(this);
            if (hasNext != coroutine_suspended) {
            }
            return coroutine_suspended;
        } else if (i2 != 2) {
            if (i2 == 3) {
                it2 = (ChannelIterator) this.L$1;
                producerScope3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                producerScope = producerScope3;
                this.L$0 = producerScope;
                this.L$1 = it2;
                this.label = 2;
                hasNext = it2.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    producerScope3 = producerScope;
                    obj = hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = producerScope3;
                    this.L$1 = it2;
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it2 = (ChannelIterator) this.L$1;
            producerScope3 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }
}
