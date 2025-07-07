package com.miami.game.feature.notifications;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
/* compiled from: notificationStateHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&R\u001e\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/miami/game/feature/notifications/INotificationViewModel;", "", "getAllNotificationHistory", "", "notificationsLiveDataCompose", "Landroidx/lifecycle/LiveData;", "", "Lcom/miami/game/feature/notifications/NotificationModel;", "getNotificationsLiveDataCompose", "()Landroidx/lifecycle/LiveData;", "viewAllNotifications", "notificationsUnViewed", "", "getNotificationsUnViewed", "notifications_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface INotificationViewModel {
    void getAllNotificationHistory();

    LiveData<List<NotificationModel>> getNotificationsLiveDataCompose();

    LiveData<Integer> getNotificationsUnViewed();

    void viewAllNotifications();
}
