package com.miami.game.core.settings.game_test;

import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner", f = "GameTestScriptRunner.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {RendererCapabilities.DECODER_SUPPORT_MASK, 386}, m = "waitForVisibility", n = {"step", "predicate", "deferred", "waiter", "step", "predicate", "deferred", "waiter"}, nl = {386, 391}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$waitForVisibility$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$waitForVisibility$1(GameTestScriptRunner gameTestScriptRunner, Continuation<? super GameTestScriptRunner$waitForVisibility$1> continuation) {
        super(continuation);
        this.this$0 = gameTestScriptRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForVisibility;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitForVisibility = this.this$0.waitForVisibility(null, this);
        return waitForVisibility;
    }
}
