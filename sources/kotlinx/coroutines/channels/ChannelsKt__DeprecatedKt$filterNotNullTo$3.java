package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {667, 272}, m = "filterNotNullTo", n = {"$this$filterNotNullTo", FirebaseAnalytics.Param.DESTINATION, "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$this$filterNotNullTo", FirebaseAnalytics.Param.DESTINATION, "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "e$iv", "it", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv", "$i$a$-consumeEach-ChannelsKt__DeprecatedKt$filterNotNullTo$4"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
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
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$filterNotNullTo$3(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNullTo$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object filterNotNullTo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        filterNotNullTo = ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, this);
        return filterNotNullTo;
    }
}
