package com.miami.game.core.api.network;

import androidx.media3.container.MdtaMetadataEntry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.api.network.NetworkDataSourceImpl", f = "NetworkDataSourceImpl.kt", i = {1, 1, 2, 2, 2}, l = {70, MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64}, m = "getServersMobile", n = {"url", "channel", "url", "e", "channel"}, nl = {72, 76, 74}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class NetworkDataSourceImpl$getServersMobile$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkDataSourceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceImpl$getServersMobile$1(NetworkDataSourceImpl networkDataSourceImpl, Continuation<? super NetworkDataSourceImpl$getServersMobile$1> continuation) {
        super(continuation);
        this.this$0 = networkDataSourceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getServersMobile(this);
    }
}
