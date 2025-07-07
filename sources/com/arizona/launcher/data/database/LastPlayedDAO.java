package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.LastPlayedServer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
/* compiled from: LastPlayedDAO.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H'J\b\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/data/database/LastPlayedDAO;", "", "addLastPlayed", "Lio/reactivex/Completable;", "server", "Lcom/arizona/launcher/model/servers/LastPlayedServer;", "getLastPlayedServers", "Lio/reactivex/Observable;", "", "dropTable", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LastPlayedDAO {
    Completable addLastPlayed(LastPlayedServer lastPlayedServer);

    void dropTable();

    Observable<List<LastPlayedServer>> getLastPlayedServers();
}
