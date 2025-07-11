package com.miami.game.core.gamefiles.info.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.gamefiles.info.data.store.GameInfoPrefRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GamefilesInfoRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository$saveGameInfoFiles$2", f = "GamefilesInfoRepository.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {"gameInfoFiles"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class GamefilesInfoRepository$saveGameInfoFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<GameInfoFile> $gameInfoFileData;
    Object L$0;
    int label;
    final /* synthetic */ GamefilesInfoRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamefilesInfoRepository$saveGameInfoFiles$2(List<GameInfoFile> list, GamefilesInfoRepository gamefilesInfoRepository, Continuation<? super GamefilesInfoRepository$saveGameInfoFiles$2> continuation) {
        super(2, continuation);
        this.$gameInfoFileData = list;
        this.this$0 = gamefilesInfoRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GamefilesInfoRepository$saveGameInfoFiles$2(this.$gameInfoFileData, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GamefilesInfoRepository$saveGameInfoFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GameInfoPrefRepository gameInfoPrefRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("saveGameInfoFiles", new Object[0]);
            List<GameInfoFile> list = this.$gameInfoFileData;
            gameInfoPrefRepository = this.this$0.gameInfoPrefRepository;
            this.L$0 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 1;
            if (gameInfoPrefRepository.saveCache(list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            List list2 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
