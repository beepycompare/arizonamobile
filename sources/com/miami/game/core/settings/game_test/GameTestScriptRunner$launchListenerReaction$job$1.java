package com.miami.game.core.settings.game_test;

import android.util.Log;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner$launchListenerReaction$job$1", f = "GameTestScriptRunner.kt", i = {}, l = {447}, m = "invokeSuspend", n = {}, nl = {448}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class GameTestScriptRunner$launchListenerReaction$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GameTestBackendEvent $event;
    final /* synthetic */ GameTestBackendMessageListener $listener;
    int label;
    final /* synthetic */ GameTestScriptRunner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$launchListenerReaction$job$1(GameTestScriptRunner gameTestScriptRunner, GameTestBackendMessageListener gameTestBackendMessageListener, GameTestBackendEvent gameTestBackendEvent, Continuation<? super GameTestScriptRunner$launchListenerReaction$job$1> continuation) {
        super(2, continuation);
        this.this$0 = gameTestScriptRunner;
        this.$listener = gameTestBackendMessageListener;
        this.$event = gameTestBackendEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameTestScriptRunner$launchListenerReaction$job$1(this.this$0, this.$listener, this.$event, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GameTestScriptRunner$launchListenerReaction$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v19 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GameTestRuntime gameTestRuntime;
        GameTestRuntime gameTestRuntime2;
        GameTestRuntime gameTestRuntime3;
        Object executeSteps;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                gameTestRuntime3 = this.this$0.runtime;
                String name = this.$listener.getName();
                String describe = this.$event.describe();
                gameTestRuntime3.log("Backend listener '" + name + "' matched: " + describe + " for " + this.$listener.getMatcher().describe());
                this.label = 1;
                executeSteps = this.this$0.executeSteps(this.$listener.getSteps(), this);
                this = executeSteps;
                if (executeSteps == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Throwable th) {
            if (th instanceof CancellationException) {
                gameTestRuntime2 = this.this$0.runtime;
                gameTestRuntime2.log("Backend listener '" + this.$listener.getName() + "' reaction was cancelled");
                return Unit.INSTANCE;
            }
            Log.e("GameTestScriptRunner", "Backend listener '" + this.$listener.getName() + "' reaction failed", th);
            gameTestRuntime = this.this$0.runtime;
            String name2 = this.$listener.getName();
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            gameTestRuntime.log("Backend listener '" + name2 + "' reaction failed: " + message);
        }
        return Unit.INSTANCE;
    }
}
