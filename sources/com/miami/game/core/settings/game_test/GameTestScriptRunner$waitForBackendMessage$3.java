package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {347, 349}, m = "waitForBackendMessage", n = {"timeoutMs", "description", "predicate", "deferred", "waiter", "includePast", "failOnTimeout", "timeoutMs", "description", "predicate", "deferred", "waiter", "includePast", "failOnTimeout"}, nl = {349, 354}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1"}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$waitForBackendMessage$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$waitForBackendMessage$3(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$waitForBackendMessage$3> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForBackendMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitForBackendMessage = this.this$0.waitForBackendMessage(null, false, false, null, null, this);
        return waitForBackendMessage;
    }
}
