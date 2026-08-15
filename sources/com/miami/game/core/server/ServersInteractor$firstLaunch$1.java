package com.miami.game.core.server;

import com.miami.game.core.privacy.privacyInteractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor", f = "ServersInteractor.kt", i = {}, l = {109}, m = privacyInteractor.FIRST_LAUNCH_KEY, n = {}, nl = {110}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class ServersInteractor$firstLaunch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$firstLaunch$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$firstLaunch$1> continuation) {
        super(continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object firstLaunch;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        firstLaunch = this.this$0.firstLaunch(this);
        return firstLaunch;
    }
}
