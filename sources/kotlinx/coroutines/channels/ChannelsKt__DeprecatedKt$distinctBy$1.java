package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, TypedValues.CycleType.TYPE_EASING}, m = "invokeSuspend", n = {"$this$produce", UserMetadata.KEYDATA_FILENAME, "$this$produce", UserMetadata.KEYDATA_FILENAME, "e", "$this$produce", UserMetadata.KEYDATA_FILENAME, "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
    final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0079, code lost:
        if (r11 != r0) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a4 -> B:29:0x00c3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ba -> B:28:0x00bc). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HashSet hashSet;
        ChannelIterator<E> it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        HashSet hashSet2;
        E e;
        ChannelIterator<E> channelIterator;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashSet hashSet3 = new HashSet();
            hashSet = hashSet3;
            it = this.$this_distinctBy.iterator();
            producerScope = (ProducerScope) this.L$0;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = it;
            this.L$3 = null;
            this.label = 1;
            obj = it.hasNext(this);
        } else if (i == 1) {
            it = (ChannelIterator) this.L$2;
            hashSet = (HashSet) this.L$1;
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                E next = it.next();
                Function2<E, Continuation<? super K>, Object> function2 = this.$selector;
                this.L$0 = producerScope;
                this.L$1 = hashSet;
                this.L$2 = it;
                this.L$3 = next;
                this.label = 2;
                Object invoke = function2.invoke(next, this);
                if (invoke != coroutine_suspended) {
                    HashSet hashSet4 = hashSet;
                    e = next;
                    obj = invoke;
                    producerScope2 = producerScope;
                    hashSet2 = hashSet4;
                    if (!hashSet2.contains(obj)) {
                    }
                    hashSet = hashSet2;
                    producerScope = producerScope2;
                    this.L$0 = producerScope;
                    this.L$1 = hashSet;
                    this.L$2 = it;
                    this.L$3 = null;
                    this.label = 1;
                    obj = it.hasNext(this);
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (i == 2) {
            Object obj3 = this.L$3;
            ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$2;
            hashSet2 = (HashSet) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            e = obj3;
            it = channelIterator2;
            if (!hashSet2.contains(obj)) {
                this.L$0 = producerScope2;
                this.L$1 = hashSet2;
                this.L$2 = it;
                this.L$3 = obj;
                this.label = 3;
                if (producerScope2.send(e, this) != coroutine_suspended) {
                    channelIterator = it;
                    obj2 = obj;
                    hashSet2.add(obj2);
                    it = channelIterator;
                }
                return coroutine_suspended;
            }
            hashSet = hashSet2;
            producerScope = producerScope2;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = it;
            this.L$3 = null;
            this.label = 1;
            obj = it.hasNext(this);
        } else if (i != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            obj2 = this.L$3;
            channelIterator = (ChannelIterator) this.L$2;
            hashSet2 = (HashSet) this.L$1;
            producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            hashSet2.add(obj2);
            it = channelIterator;
            hashSet = hashSet2;
            producerScope = producerScope2;
            this.L$0 = producerScope;
            this.L$1 = hashSet;
            this.L$2 = it;
            this.L$3 = null;
            this.label = 1;
            obj = it.hasNext(this);
        }
    }
}
