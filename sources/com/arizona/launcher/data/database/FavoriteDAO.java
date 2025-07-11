package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.FavoriteServer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
/* compiled from: FavoriteDAO.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\b\u0010\n\u001a\u00020\u000bH'¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/FavoriteDAO;", "", "addFavorite", "Lio/reactivex/Completable;", "server", "Lcom/arizona/launcher/model/servers/FavoriteServer;", "removeFromFavorite", "getAllFavoriteServers", "Lio/reactivex/Observable;", "", "dropTable", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FavoriteDAO {
    Completable addFavorite(FavoriteServer favoriteServer);

    void dropTable();

    Observable<List<FavoriteServer>> getAllFavoriteServers();

    Completable removeFromFavorite(FavoriteServer favoriteServer);
}
