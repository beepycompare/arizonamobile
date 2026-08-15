package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.GameUpdateServiceFlow$request$job$1$preflightBlock$1", f = "GameUpdateServiceFlow.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
final class GameUpdateServiceFlow$request$job$1$preflightBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveUpdateCheckDecision.Block>, Object> {
    final /* synthetic */ long $token;
    int label;
    final /* synthetic */ GameUpdateServiceFlow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameUpdateServiceFlow$request$job$1$preflightBlock$1(GameUpdateServiceFlow gameUpdateServiceFlow, long j, Continuation<? super GameUpdateServiceFlow$request$job$1$preflightBlock$1> continuation) {
        super(2, continuation);
        this.this$0 = gameUpdateServiceFlow;
        this.$token = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameUpdateServiceFlow$request$job$1$preflightBlock$1(this.this$0, this.$token, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveUpdateCheckDecision.Block> continuation) {
        return ((GameUpdateServiceFlow$request$job$1$preflightBlock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function2 function2;
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
        function2 = this.this$0.primaryCheckPreflight;
        Long boxLong = Boxing.boxLong(this.$token);
        this.label = 1;
        Object invoke = function2.invoke(boxLong, this);
        return invoke == coroutine_suspended ? coroutine_suspended : invoke;
    }
}
