package com.miami.game.core.gamefiles.info.domain;

import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.domain.GamefilesInfoInteractor$saveGameInfoFiles$2", f = "GamefilesInfoInteractor.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class GamefilesInfoInteractor$saveGameInfoFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GameInfoFile> $gameInfoFileData;
    int label;
    final /* synthetic */ GamefilesInfoInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamefilesInfoInteractor$saveGameInfoFiles$2(GamefilesInfoInteractor gamefilesInfoInteractor, List<GameInfoFile> list, Continuation<? super GamefilesInfoInteractor$saveGameInfoFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = gamefilesInfoInteractor;
        this.$gameInfoFileData = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GamefilesInfoInteractor$saveGameInfoFiles$2(this.this$0, this.$gameInfoFileData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GamefilesInfoInteractor$saveGameInfoFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GamefilesInfoRepository gamefilesInfoRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            gamefilesInfoRepository = this.this$0.repository;
            this.label = 1;
            if (gamefilesInfoRepository.saveGameInfoFiles(this.$gameInfoFileData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
