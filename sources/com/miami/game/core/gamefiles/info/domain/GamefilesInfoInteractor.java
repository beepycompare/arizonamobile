package com.miami.game.core.gamefiles.info.domain;

import com.miami.game.core.domain.model.GameInfoFile;
import com.miami.game.core.gamefiles.info.data.GamefilesInfoRepository;
import com.miami.game.core.gamefiles.info.domain.model.GameInfoFileData;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: GamefilesInfoInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/miami/game/core/gamefiles/info/domain/GamefilesInfoInteractor;", "", "repository", "Lcom/miami/game/core/gamefiles/info/data/GamefilesInfoRepository;", "<init>", "(Lcom/miami/game/core/gamefiles/info/data/GamefilesInfoRepository;)V", "getGameInfoFiles", "Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveGameInfoFiles", "", "gameInfoFileData", "", "Lcom/miami/game/core/domain/model/GameInfoFile;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamefiles-info_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GamefilesInfoInteractor {
    private final GamefilesInfoRepository repository;

    @Inject
    public GamefilesInfoInteractor(GamefilesInfoRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Object getGameInfoFiles(Continuation<? super GameInfoFileData> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GamefilesInfoInteractor$getGameInfoFiles$2(this, null), continuation);
    }

    public final Object saveGameInfoFiles(List<GameInfoFile> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new GamefilesInfoInteractor$saveGameInfoFiles$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
