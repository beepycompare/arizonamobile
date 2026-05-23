package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {BuiltInsProtoBuf.PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER, 156}, m = "lastOrNull", n = {"$this$lastOrNull", "$this$consume$iv", "$this$lastOrNull_u24lambda_u240", "iterator", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$lastOrNull$2", "$this$lastOrNull", "$this$consume$iv", "$this$lastOrNull_u24lambda_u240", "iterator", "last", "$i$f$consume", "$i$a$-consume-ChannelsKt__DeprecatedKt$lastOrNull$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$lastOrNull$1<E> extends ContinuationImpl {
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
    public ChannelsKt__DeprecatedKt$lastOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$lastOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object lastOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lastOrNull = ChannelsKt__DeprecatedKt.lastOrNull(null, this);
        return lastOrNull;
    }
}
