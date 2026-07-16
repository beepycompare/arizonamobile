package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6}, l = {146, 148, 154, 155, 156, 159, 163}, m = "executeSteps", n = {"steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "steps", "$this$forEach$iv", "element$iv", "step", "it"}, nl = {147, 149, 155, 156, 157, 160, 164}, s = {"L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "I$2"}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$executeSteps$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$executeSteps$1(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$executeSteps$1> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeSteps;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeSteps = this.this$0.executeSteps(null, this);
        return executeSteps;
    }
}
