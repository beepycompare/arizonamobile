package com.miami.game.core.api.network;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.api.network.NetworkDataSourceImpl", f = "NetworkDataSourceImpl.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "getHwVersion", n = {}, nl = {131}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class NetworkDataSourceImpl$getHwVersion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkDataSourceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceImpl$getHwVersion$1(NetworkDataSourceImpl networkDataSourceImpl, Continuation<? super NetworkDataSourceImpl$getHwVersion$1> continuation) {
        super(continuation);
        this.this$0 = networkDataSourceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getHwVersion(this);
    }
}
