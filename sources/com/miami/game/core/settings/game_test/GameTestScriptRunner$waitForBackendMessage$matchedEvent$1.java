package com.miami.game.core.settings.game_test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: GameTestScriptRunner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/settings/game_test/GameTestBackendEvent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.settings.game_test.GameTestScriptRunner$waitForBackendMessage$matchedEvent$1", f = "GameTestScriptRunner.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes5.dex */
final class GameTestScriptRunner$waitForBackendMessage$matchedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GameTestBackendEvent>, Object> {
    final /* synthetic */ CompletableDeferred<GameTestBackendEvent> $deferred;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameTestScriptRunner$waitForBackendMessage$matchedEvent$1(CompletableDeferred<GameTestBackendEvent> completableDeferred, Continuation<? super GameTestScriptRunner$waitForBackendMessage$matchedEvent$1> continuation) {
        super(2, continuation);
        this.$deferred = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameTestScriptRunner$waitForBackendMessage$matchedEvent$1(this.$deferred, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GameTestBackendEvent> continuation) {
        return ((GameTestScriptRunner$waitForBackendMessage$matchedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object await = this.$deferred.await(this);
        return await == coroutine_suspended ? coroutine_suspended : await;
    }
}
