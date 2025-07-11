package com.miami.game.core.api.network;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkDataSourceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.api.network.NetworkDataSourceImpl", f = "NetworkDataSourceImpl.kt", i = {1}, l = {64, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "getGameInfo", n = {"url"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class NetworkDataSourceImpl$getGameInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkDataSourceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceImpl$getGameInfo$1(NetworkDataSourceImpl networkDataSourceImpl, Continuation<? super NetworkDataSourceImpl$getGameInfo$1> continuation) {
        super(continuation);
        this.this$0 = networkDataSourceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getGameInfo(this);
    }
}
