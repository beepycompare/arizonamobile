package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxChannel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxChannelKt", f = "RxChannel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {96}, m = "collect", n = {"$this$collect", "action", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$collect", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
/* loaded from: classes5.dex */
public final class RxChannelKt$collect$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxChannelKt$collect$1(Continuation<? super RxChannelKt$collect$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxChannelKt.collect((MaybeSource) null, (Function1) null, this);
    }
}
