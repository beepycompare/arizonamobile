package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.ServerEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
/* compiled from: ServersDAO.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H'J\b\u0010\t\u001a\u00020\nH'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/ServersDAO;", "", "addServer", "Lio/reactivex/Completable;", "server", "Lcom/arizona/launcher/model/servers/ServerEntity;", "getAllServers", "Lio/reactivex/Observable;", "", "deleteTable", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServersDAO {
    Completable addServer(ServerEntity serverEntity);

    void deleteTable();

    Observable<List<ServerEntity>> getAllServers();
}
