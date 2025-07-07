package com.miami.game.core.gamefiles.info.data.api;

import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.api.network.NetworkDataSource;
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
/* compiled from: GamefilesInfoApiRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.data.api.GamefilesInfoApiRepository$getGameInfo$2", f = "GamefilesInfoApiRepository.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class GamefilesInfoApiRepository$getGameInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GameInfoResponseApiModel>, Object> {
    int label;
    final /* synthetic */ GamefilesInfoApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamefilesInfoApiRepository$getGameInfo$2(GamefilesInfoApiRepository gamefilesInfoApiRepository, Continuation<? super GamefilesInfoApiRepository$getGameInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = gamefilesInfoApiRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GamefilesInfoApiRepository$getGameInfo$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GameInfoResponseApiModel> continuation) {
        return ((GamefilesInfoApiRepository$getGameInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NetworkDataSource networkDataSource;
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
        networkDataSource = this.this$0.networkDataSource;
        this.label = 1;
        Object gameInfo = networkDataSource.getGameInfo(this);
        return gameInfo == coroutine_suspended ? coroutine_suspended : gameInfo;
    }
}
