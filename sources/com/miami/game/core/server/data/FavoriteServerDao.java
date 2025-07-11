package com.miami.game.core.server.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: FavoriteServerDao.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH'J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH§@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\f¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/server/data/FavoriteServerDao;", "", "addFavorite", "", "server", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "(Lcom/miami/game/core/server/data/FavoriteServerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorite", "getAllFlowFavoriteServers", "Lkotlinx/coroutines/flow/Flow;", "", "getAllFavoriteServers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dropTable", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FavoriteServerDao {
    Object addFavorite(FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation);

    Object dropTable(Continuation<? super Unit> continuation);

    Object getAllFavoriteServers(Continuation<? super List<FavoriteServerEntity>> continuation);

    Flow<List<FavoriteServerEntity>> getAllFlowFavoriteServers();

    Object removeFromFavorite(FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation);
}
