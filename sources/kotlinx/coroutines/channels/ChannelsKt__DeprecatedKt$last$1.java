package kotlinx.coroutines.channels;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {127, TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "last", n = {"$this$last", "$this$consume$iv", "$this$last_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$last$2", "$this$last", "$this$consume$iv", "$this$last_u24lambda_u240", "iterator", "last", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$last$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$last$1(Continuation<? super ChannelsKt__DeprecatedKt$last$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object last;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        last = ChannelsKt__DeprecatedKt.last(null, this);
        return last;
    }
}
