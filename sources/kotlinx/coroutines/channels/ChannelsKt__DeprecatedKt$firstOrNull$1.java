package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0}, l = {105}, m = "firstOrNull", n = {"$this$firstOrNull", "$this$consume$iv", "$this$firstOrNull_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$firstOrNull$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$firstOrNull$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$firstOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$firstOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object firstOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        firstOrNull = ChannelsKt__DeprecatedKt.firstOrNull(null, this);
        return firstOrNull;
    }
}
