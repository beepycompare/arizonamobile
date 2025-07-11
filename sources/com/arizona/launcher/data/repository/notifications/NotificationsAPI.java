package com.arizona.launcher.data.repository.notifications;

import com.arizona.launcher.model.notificatoins.ArizonaNotification;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
/* compiled from: NotificationsAPI.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/data/repository/notifications/NotificationsAPI;", "", "getAllNotifications", "", "Lcom/arizona/launcher/model/notificatoins/ArizonaNotification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface NotificationsAPI {
    @GET("notifications")
    Object getAllNotifications(Continuation<? super List<ArizonaNotification>> continuation);
}
