package com.arizona.launcher;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.preference.PreferenceManager;
import com.arizona.game.R;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
/* compiled from: MessagingService.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onMessageReceived", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "topic", "", "getTopic", "()Ljava/lang/String;", "onNewToken", "p0", "saveNotificationData", "appDatabase", "Lcom/arizona/launcher/data/database/ArizonaDatabase;", "title", "text", "imageUrl", "Landroid/net/Uri;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessagingService extends FirebaseMessagingService {
    public static final int $stable = 8;
    private final String topic = "subscriber-updates";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.onMessageReceived(message);
        MessagingService messagingService = this;
        ArizonaDatabase companion = ArizonaDatabase.Companion.getInstance(messagingService);
        RemoteMessage.Notification notification = message.getNotification();
        String title = notification != null ? notification.getTitle() : null;
        String body = notification != null ? notification.getBody() : null;
        Uri imageUrl = notification != null ? notification.getImageUrl() : null;
        if (title != null && body != null && imageUrl != null) {
            saveNotificationData(companion, title, body, imageUrl);
        }
        PendingIntent activity = PendingIntent.getActivity(messagingService, 0, new Intent(messagingService, MainEntrench.class), 67108864);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(messagingService, "Default").setSmallIcon(R.mipmap.ic_launcher_foreground);
        RemoteMessage.Notification notification2 = message.getNotification();
        NotificationCompat.Builder contentTitle = smallIcon.setContentTitle(notification2 != null ? notification2.getTitle() : null);
        RemoteMessage.Notification notification3 = message.getNotification();
        NotificationCompat.Builder contentIntent = contentTitle.setContentText(notification3 != null ? notification3.getBody() : null).setAutoCancel(true).setContentIntent(activity);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("Default", "Default channel", 3));
        }
        notificationManager.notify(0, contentIntent.build());
    }

    public final String getTopic() {
        return this.topic;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        super.onNewToken(p0);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("token", p0).apply();
        Log.d("MESSAGING", "New token: " + p0);
        FirebaseMessaging.getInstance().subscribeToTopic(this.topic).addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.launcher.MessagingService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MessagingService.onNewToken$lambda$0(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onNewToken$lambda$0(Task task) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            str = "Subscribed";
        } else {
            str = "Subscribe failed";
        }
        Log.d("MESSAGING", str);
    }

    private final void saveNotificationData(ArizonaDatabase arizonaDatabase, String str, String str2, Uri uri) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new MessagingService$saveNotificationData$1(arizonaDatabase, str, str2, uri, null), 3, null);
    }
}
