package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.FavoriteServer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
/* compiled from: FavoriteDAO.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002J\u0014\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'b\u0002\b\tJ\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH'b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fJ\u0016\u0010\u0010\u001a\u00020\u0011H'b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012Ê\u0001\u0002\b\u0014¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/FavoriteDAO;", "", "addFavorite", "Lio/reactivex/Completable;", "server", "Lcom/arizona/launcher/model/servers/FavoriteServer;", "Landroidx/room/Insert;", "onConflict", "removeFromFavorite", "Landroidx/room/Delete;", "getAllFavoriteServers", "Lio/reactivex/Observable;", "", "Landroidx/room/Query;", "value", "SELECT * FROM favoriteserver", "dropTable", "", "DELETE FROM lastplayed", "app", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FavoriteDAO {
    Completable addFavorite(FavoriteServer favoriteServer);

    void dropTable();

    Observable<List<FavoriteServer>> getAllFavoriteServers();

    Completable removeFromFavorite(FavoriteServer favoriteServer);
}
