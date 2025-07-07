package com.miami.game.core.gamefiles.info.data.api;

import com.miami.game.core.api.model.response.game_info.GameInfoResponseApiModel;
import com.miami.game.core.api.network.NetworkDataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: GamefilesInfoApiRepository.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/miami/game/core/gamefiles/info/data/api/GamefilesInfoApiRepository;", "", "networkDataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "<init>", "(Lcom/miami/game/core/api/network/NetworkDataSource;)V", "getGameInfo", "Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gamefiles-info_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GamefilesInfoApiRepository {
    private final NetworkDataSource networkDataSource;

    @Inject
    public GamefilesInfoApiRepository(NetworkDataSource networkDataSource) {
        Intrinsics.checkNotNullParameter(networkDataSource, "networkDataSource");
        this.networkDataSource = networkDataSource;
    }

    public final Object getGameInfo(Continuation<? super GameInfoResponseApiModel> continuation) throws Exception {
        return BuildersKt.withContext(Dispatchers.getIO(), new GamefilesInfoApiRepository$getGameInfo$2(this, null), continuation);
    }
}
