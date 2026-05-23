package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0}, l = {434}, m = "any", n = {"$this$any", "$this$consume$iv", "$this$any_u24lambda_u240", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$any$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$any$1(Continuation<? super ChannelsKt__DeprecatedKt$any$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object any;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        any = ChannelsKt__DeprecatedKt.any(null, this);
        return any;
    }
}
