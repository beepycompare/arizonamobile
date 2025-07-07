package com.miami.game.core.gamefiles.info.data;

import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.gamefiles.info.data.api.GamefilesInfoApiRepository;
import com.miami.game.core.gamefiles.info.data.store.GameInfoPrefRepository;
import com.miami.game.core.gamefiles.info.domain.model.GameInfoFileData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GamefilesInfoRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository$getGameInfoFiles$2", f = "GamefilesInfoRepository.kt", i = {1}, l = {34, 40}, m = "invokeSuspend", n = {"gameInfoFiles"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class GamefilesInfoRepository$getGameInfoFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GameInfoFileData>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GamefilesInfoRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamefilesInfoRepository$getGameInfoFiles$2(GamefilesInfoRepository gamefilesInfoRepository, Continuation<? super GamefilesInfoRepository$getGameInfoFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = gamefilesInfoRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GamefilesInfoRepository$getGameInfoFiles$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GameInfoFileData> continuation) {
        return ((GamefilesInfoRepository$getGameInfoFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (r7 == r0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        GamefilesInfoApiRepository gamefilesInfoApiRepository;
        List makeFilesList;
        GameInfoPrefRepository gameInfoPrefRepository;
        List list;
        String name;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.d("getGameInfoFiles", new Object[0]);
            gamefilesInfoApiRepository = this.this$0.gamefilesInfoApiRepository;
            this.label = 1;
            obj = gamefilesInfoApiRepository.getGameInfo(this);
        } else if (i != 1) {
            if (i == 2) {
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list2 = (List) obj;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                return new GameInfoFileData(list, list2);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        makeFilesList = this.this$0.makeFilesList((GameInfoResponseApiModel) obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : makeFilesList) {
            GameInfoFile gameInfoFile = (GameInfoFile) obj2;
            if (gameInfoFile.getPath().length() != 0 || ((name = gameInfoFile.getName()) != null && name.length() != 0)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        gameInfoPrefRepository = this.this$0.gameInfoPrefRepository;
        this.L$0 = arrayList2;
        this.label = 2;
        Object cache = gameInfoPrefRepository.getCache(this);
        if (cache != coroutine_suspended) {
            list = arrayList2;
            obj = cache;
            list2 = (List) obj;
            if (list2 == null) {
            }
            return new GameInfoFileData(list, list2);
        }
        return coroutine_suspended;
    }
}
