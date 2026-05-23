package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {464, 466}, m = "minWith", n = {"$this$minWith", "comparator", "$this$consume$iv", "$this$minWith_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$minWith$2", "$this$minWith", "comparator", "$this$consume$iv", "$this$minWith_u24lambda_u240", "iterator", "min", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$minWith$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object minWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        minWith = ChannelsKt__DeprecatedKt.minWith(null, null, this);
        return minWith;
    }
}
