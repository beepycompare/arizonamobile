package com.miami.game.core.server.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: FavoriteServerDao.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@b\u0002\b\n¢\u0006\u0002\u0010\u0006J\"\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH'b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\rH§@b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u0003H§@b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014¢\u0006\u0002\u0010\u0012Ê\u0001\u0002\b\u0015¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/server/data/FavoriteServerDao;", "", "addFavorite", "", "server", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "(Lcom/miami/game/core/server/data/FavoriteServerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Insert;", "onConflict", "removeFromFavorite", "Landroidx/room/Delete;", "getAllFlowFavoriteServers", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/room/Query;", "value", "SELECT * FROM favorite_server_table", "getAllFavoriteServers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dropTable", "DELETE FROM favorite_server_table", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FavoriteServerDao {
    Object addFavorite(FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation);

    Object dropTable(Continuation<? super Unit> continuation);

    Object getAllFavoriteServers(Continuation<? super List<FavoriteServerEntity>> continuation);

    Flow<List<FavoriteServerEntity>> getAllFlowFavoriteServers();

    Object removeFromFavorite(FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation);
}
