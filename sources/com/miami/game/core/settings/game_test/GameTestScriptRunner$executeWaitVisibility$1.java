package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0}, l = {277}, m = "executeWaitVisibility", n = {"step"}, nl = {278}, s = {"L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$executeWaitVisibility$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$executeWaitVisibility$1(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$executeWaitVisibility$1> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeWaitVisibility;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWaitVisibility = this.this$0.executeWaitVisibility(null, this);
        return executeWaitVisibility;
    }
}
