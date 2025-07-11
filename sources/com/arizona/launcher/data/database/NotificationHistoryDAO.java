package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.NotificationHistoryData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: NotificationHistoryDAO.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH§@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "", "addNotification", "", "notification", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "(Lcom/arizona/launcher/model/servers/NotificationHistoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotification", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dropTable", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NotificationHistoryDAO {
    Object addNotification(NotificationHistoryData notificationHistoryData, Continuation<? super Unit> continuation);

    Object dropTable(Continuation<? super Unit> continuation);

    Object getAllNotification(Continuation<? super List<NotificationHistoryData>> continuation);
}
