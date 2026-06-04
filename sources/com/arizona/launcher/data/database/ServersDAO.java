package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.ServerEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ServersDAO.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\tH'b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rJ\u0016\u0010\u000e\u001a\u00020\u000fH'b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010Ê\u0001\u0002\b\u0012¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/ServersDAO;", "", "addServer", "Lio/reactivex/Completable;", "server", "Lcom/arizona/launcher/model/servers/ServerEntity;", "Landroidx/room/Insert;", "onConflict", "getAllServers", "Lio/reactivex/Observable;", "", "Landroidx/room/Query;", "value", "SELECT * FROM allservers", "deleteTable", "", "DELETE FROM allservers", "app", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServersDAO {
    Completable addServer(ServerEntity serverEntity);

    void deleteTable();

    Observable<List<ServerEntity>> getAllServers();
}
