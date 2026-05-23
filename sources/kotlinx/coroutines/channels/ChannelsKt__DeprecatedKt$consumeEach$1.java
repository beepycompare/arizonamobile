package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {41}, m = "consumeEach", n = {"$this$consumeEach", "action", "$this$consume$iv", "channel$iv", "$this$consumeEach_u24lambda_u240", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$consumeEach$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$consumeEach$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$consumeEach$1(Continuation<? super ChannelsKt__DeprecatedKt$consumeEach$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.consumeEach(null, null, this);
    }
}
