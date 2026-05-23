package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.common.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {157}, m = "consumeEach", n = {"$this$consumeEach", "action", "$this$consume$iv", "$this$consumeEach_u24lambda_u240", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__Channels_commonKt$consumeEach$1(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach(null, null, this);
    }
}
