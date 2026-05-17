package com.miami.game.core.settings.game_test;

import androidx.compose.runtime.ComposerImplKt;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {114, 120, 121, 124, 128}, m = "executeSteps", n = {"steps", "$this$forEach$iv", "element$iv", "step", "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$executeSteps$2", "steps", "$this$forEach$iv", "element$iv", "step", "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$executeSteps$2", "steps", "$this$forEach$iv", "element$iv", "step", "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$executeSteps$2", "steps", "$this$forEach$iv", "element$iv", "step", "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$executeSteps$2", "steps", "$this$forEach$iv", "element$iv", "step", "$i$f$forEach", "$i$a$-forEach-GameTestScriptRunner$executeSteps$2", "it", "$i$a$-repeat-GameTestScriptRunner$executeSteps$2$1"}, nl = {115, 121, 122, ComposerImplKt.nodeKey, TsExtractor.TS_STREAM_TYPE_AC3}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "I$4", "I$5"}, v = 2)
/* loaded from: classes4.dex */
public final class GameTestScriptRunner$executeSteps$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
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
