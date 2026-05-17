package com.miami.game.core.settings.game_test;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameTestScriptRunner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner$start$1", f = "GameTestScriptRunner.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend", n = {}, nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, s = {}, v = 2)
/* loaded from: classes4.dex */
public final class GameTestScriptRunner$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $displayName;
    final /* synthetic */ GameTestScript $script;
    int label;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$start$1(GameTestScriptRunner gameTestScriptRunner, String str, GameTestScript gameTestScript, Continuation<? super GameTestScriptRunner$start$1> continuation) {
        super(2, continuation);
        this.this$0 = gameTestScriptRunner;
        this.$displayName = str;
        this.$script = gameTestScript;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameTestScriptRunner$start$1(this.this$0, this.$displayName, this.$script, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GameTestScriptRunner$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GameTestRuntime gameTestRuntime;
        GameTestRuntime gameTestRuntime2;
        GameTestRuntime gameTestRuntime3;
        Object executeSteps;
        GameTestRuntime gameTestRuntime4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gameTestRuntime3 = this.this$0.runtime;
                gameTestRuntime3.log("Starting test script '" + this.$displayName + "'");
                GameTestScriptRunner gameTestScriptRunner = this.this$0;
                for (GameTestBackendMessageListener gameTestBackendMessageListener : this.$script.getListeners()) {
                    gameTestScriptRunner.registerBackendMessageListener(gameTestBackendMessageListener);
                }
                this.label = 1;
                executeSteps = this.this$0.executeSteps(this.$script.getSteps(), this);
                if (executeSteps == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            gameTestRuntime4 = this.this$0.runtime;
            gameTestRuntime4.log("Finished test script '" + this.$displayName + "'");
        } catch (Throwable th) {
            try {
                if (th instanceof CancellationException) {
                    gameTestRuntime2 = this.this$0.runtime;
                    gameTestRuntime2.log("Test script '" + this.$displayName + "' was cancelled");
                    return Unit.INSTANCE;
                }
                Log.e("GameTestScriptRunner", "Failed to execute test script '" + this.$displayName + "'", th);
                gameTestRuntime = this.this$0.runtime;
                String str = this.$displayName;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                gameTestRuntime.log("Test script '" + str + "' failed: " + message);
            } finally {
                this.this$0.clearScriptRuntimeState(false);
            }
        }
        return Unit.INSTANCE;
    }
}
