package com.arizona.launcher.model.notificatoins;

import com.arizona.launcher.model.servers.NotificationHistoryData;
import com.miami.game.feature.notifications.NotificationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaNotification.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0002*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¨\u0006\u0005"}, d2 = {"toUi", "Lcom/miami/game/feature/notifications/NotificationModel;", "Lcom/arizona/launcher/model/notificatoins/ArizonaNotification;", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "toDb", "app_arizonaRelease_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArizonaNotificationKt {
    public static final NotificationModel toUi(ArizonaNotification arizonaNotification) {
        Intrinsics.checkNotNullParameter(arizonaNotification, "<this>");
        return new NotificationModel(arizonaNotification.getDate(), arizonaNotification.getTitle(), arizonaNotification.getText(), arizonaNotification.getImageUrl(), arizonaNotification.isViewed());
    }

    public static final ArizonaNotification toUi(NotificationHistoryData notificationHistoryData) {
        Intrinsics.checkNotNullParameter(notificationHistoryData, "<this>");
        return new ArizonaNotification(notificationHistoryData.getDate(), notificationHistoryData.getTitle(), notificationHistoryData.getText(), notificationHistoryData.getImageUrl(), notificationHistoryData.isViewed());
    }

    public static final NotificationHistoryData toDb(ArizonaNotification arizonaNotification) {
        Intrinsics.checkNotNullParameter(arizonaNotification, "<this>");
        return new NotificationHistoryData(0, arizonaNotification.getDate(), arizonaNotification.getTitle(), arizonaNotification.getText(), arizonaNotification.getImageUrl(), arizonaNotification.isViewed(), 1, null);
    }
}
