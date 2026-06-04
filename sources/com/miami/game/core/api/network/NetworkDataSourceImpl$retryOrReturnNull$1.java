package com.miami.game.core.api.network;

import androidx.compose.ui.spatial.RectListKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.api.network.NetworkDataSourceImpl", f = "NetworkDataSourceImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {61, RectListKt.BitOffsetForGesturable}, m = "retryOrReturnNull", n = {"channelType", "fetcher", "idx", "attempt", "channelType", "fetcher", "idx", "attempt"}, nl = {RectListKt.BitOffsetForGesturable, 64}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 2)
/* loaded from: classes5.dex */
public final class NetworkDataSourceImpl$retryOrReturnNull$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkDataSourceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceImpl$retryOrReturnNull$1(NetworkDataSourceImpl networkDataSourceImpl, Continuation<? super NetworkDataSourceImpl$retryOrReturnNull$1> continuation) {
        super(continuation);
        this.this$0 = networkDataSourceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object retryOrReturnNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        retryOrReturnNull = this.this$0.retryOrReturnNull(null, null, this);
        return retryOrReturnNull;
    }
}
