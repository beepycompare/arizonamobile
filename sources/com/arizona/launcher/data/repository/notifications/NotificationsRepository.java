package com.arizona.launcher.data.repository.notifications;

import com.arizona.launcher.data.database.NotificationHistoryDAO;
import com.arizona.launcher.model.notificatoins.ArizonaNotification;
import com.arizona.launcher.model.servers.NotificationHistoryData;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NotificationsRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/data/repository/notifications/NotificationsRepository;", "", "notificationsAPI", "Lcom/arizona/launcher/data/repository/notifications/NotificationsAPI;", "notificationHistoryDAO", "Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "<init>", "(Lcom/arizona/launcher/data/repository/notifications/NotificationsAPI;Lcom/arizona/launcher/data/database/NotificationHistoryDAO;)V", "getAllNotifications", "", "Lcom/arizona/launcher/model/notificatoins/ArizonaNotification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addNotificationToDB", "", "notification", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "(Lcom/arizona/launcher/model/servers/NotificationHistoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotificationFromDB", "clearDataFromDB", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationsRepository {
    public static final int $stable = 0;
    private final NotificationHistoryDAO notificationHistoryDAO;
    private final NotificationsAPI notificationsAPI;

    @Inject
    public NotificationsRepository(NotificationsAPI notificationsAPI, NotificationHistoryDAO notificationHistoryDAO) {
        Intrinsics.checkNotNullParameter(notificationsAPI, "notificationsAPI");
        Intrinsics.checkNotNullParameter(notificationHistoryDAO, "notificationHistoryDAO");
        this.notificationsAPI = notificationsAPI;
        this.notificationHistoryDAO = notificationHistoryDAO;
    }

    public final Object getAllNotifications(Continuation<? super List<ArizonaNotification>> continuation) {
        return this.notificationsAPI.getAllNotifications(continuation);
    }

    public final Object addNotificationToDB(NotificationHistoryData notificationHistoryData, Continuation<? super Unit> continuation) {
        Object addNotification = this.notificationHistoryDAO.addNotification(notificationHistoryData, continuation);
        return addNotification == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addNotification : Unit.INSTANCE;
    }

    public final Object getAllNotificationFromDB(Continuation<? super List<NotificationHistoryData>> continuation) {
        return this.notificationHistoryDAO.getAllNotification(continuation);
    }

    public final Object clearDataFromDB(Continuation<? super Unit> continuation) {
        Object dropTable = this.notificationHistoryDAO.dropTable(continuation);
        return dropTable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dropTable : Unit.INSTANCE;
    }
}
