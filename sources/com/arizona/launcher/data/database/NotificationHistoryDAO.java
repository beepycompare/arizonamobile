package com.arizona.launcher.data.database;

import com.arizona.launcher.model.servers.NotificationHistoryData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* compiled from: NotificationHistoryDAO.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH§@b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000f\u001a\u00020\u0003H§@b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u000bÊ\u0001\u0002\b\u0012¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "", "addNotification", "", "notification", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "(Lcom/arizona/launcher/model/servers/NotificationHistoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Insert;", "onConflict", "getAllNotification", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Query;", "value", "SELECT * FROM notifications ORDER BY date LIMIT 5", "dropTable", "DELETE FROM notifications", "app", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NotificationHistoryDAO {
    Object addNotification(NotificationHistoryData notificationHistoryData, Continuation<? super Unit> continuation);

    Object dropTable(Continuation<? super Unit> continuation);

    Object getAllNotification(Continuation<? super List<NotificationHistoryData>> continuation);
}
