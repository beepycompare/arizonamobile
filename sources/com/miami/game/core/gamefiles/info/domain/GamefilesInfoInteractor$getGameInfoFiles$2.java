package com.miami.game.core.gamefiles.info.domain;

import com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository;
import com.miami.game.core.gamefiles.info.domain.model.GameInfoFileData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: GamefilesInfoInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.domain.GamefilesInfoInteractor$getGameInfoFiles$2", f = "GamefilesInfoInteractor.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class GamefilesInfoInteractor$getGameInfoFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GameInfoFileData>, Object> {
    int label;
    final /* synthetic */ GamefilesInfoInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamefilesInfoInteractor$getGameInfoFiles$2(GamefilesInfoInteractor gamefilesInfoInteractor, Continuation<? super GamefilesInfoInteractor$getGameInfoFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = gamefilesInfoInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GamefilesInfoInteractor$getGameInfoFiles$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GameInfoFileData> continuation) {
        return ((GamefilesInfoInteractor$getGameInfoFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GamefilesInfoRepository gamefilesInfoRepository;
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
        gamefilesInfoRepository = this.this$0.repository;
        this.label = 1;
        Object gameInfoFiles = gamefilesInfoRepository.getGameInfoFiles(this);
        return gameInfoFiles == coroutine_suspended ? coroutine_suspended : gameInfoFiles;
    }
}
