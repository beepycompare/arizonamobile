package com.miami.game.core.server;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor", f = "ServersInteractor.kt", i = {0, 0, 0, 2, 2, 2}, l = {397, 373, 377}, m = "getServersVcList", n = {"$this$getSuspend$iv", "key$iv", "$i$f$getSuspend", "serverList", "it", "$i$a$-let-ServersInteractor$getServersVcList$4"}, nl = {340, 421, 379}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
/* loaded from: classes4.dex */
public final class ServersInteractor$getServersVcList$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$getServersVcList$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$getServersVcList$1> continuation) {
        super(continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object serversVcList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        serversVcList = this.this$0.getServersVcList(this);
        return serversVcList;
    }
}
