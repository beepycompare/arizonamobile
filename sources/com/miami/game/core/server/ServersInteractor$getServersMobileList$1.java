package com.miami.game.core.server;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor", f = "ServersInteractor.kt", i = {2}, l = {364, 284, 289, 298}, m = "getServersMobileList", n = {"serverList"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class ServersInteractor$getServersMobileList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$getServersMobileList$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$getServersMobileList$1> continuation) {
        super(continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object serversMobileList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        serversMobileList = this.this$0.getServersMobileList(this);
        return serversMobileList;
    }
}
