package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0}, l = {267}, m = "executeWaitBackendMessage", n = {"step"}, nl = {268}, s = {"L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$executeWaitBackendMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$executeWaitBackendMessage$1(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$executeWaitBackendMessage$1> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeWaitBackendMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWaitBackendMessage = this.this$0.executeWaitBackendMessage(null, this);
        return executeWaitBackendMessage;
    }
}
