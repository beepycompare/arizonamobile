package com.miami.game.core.server;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor", f = "ServersInteractor.kt", i = {0}, l = {160}, m = "selectServerInternal", n = {"serverModel"}, nl = {161}, s = {"L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class ServersInteractor$selectServerInternal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$selectServerInternal$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$selectServerInternal$1> continuation) {
        super(continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object selectServerInternal;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        selectServerInternal = this.this$0.selectServerInternal(null, this);
        return selectServerInternal;
    }
}
