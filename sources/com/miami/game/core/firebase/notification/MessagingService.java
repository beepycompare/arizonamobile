package com.miami.game.core.firebase.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.miami.game.core.firebase.notification.data.MessagingRepository;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: MessagingService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R#\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u0092\u0002\u0002\b\n¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012Ê\u0001\u0002\b\u0016¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/firebase/notification/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "messagingRepository", "Lcom/miami/game/core/firebase/notification/data/MessagingRepository;", "getMessagingRepository", "()Lcom/miami/game/core/firebase/notification/data/MessagingRepository;", "setMessagingRepository", "(Lcom/miami/game/core/firebase/notification/data/MessagingRepository;)V", "Ljavax/inject/Inject;", "onMessageReceived", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "topic", "", "getTopic", "()Ljava/lang/String;", "onNewToken", "p0", "firebase-notification", "Ldagger/hilt/android/AndroidEntryPoint;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class MessagingService extends Hilt_MessagingService {
    @Inject
    public MessagingRepository messagingRepository;
    private final String topic = "subscriber-updates";

    public final MessagingRepository getMessagingRepository() {
        MessagingRepository messagingRepository = this.messagingRepository;
        if (messagingRepository != null) {
            return messagingRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("messagingRepository");
        return null;
    }

    public final void setMessagingRepository(MessagingRepository messagingRepository) {
        Intrinsics.checkNotNullParameter(messagingRepository, "<set-?>");
        this.messagingRepository = messagingRepository;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Intent intent;
        Intrinsics.checkNotNullParameter(message, "message");
        super.onMessageReceived(message);
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        MessagingService messagingService = this;
        PendingIntent activity = PendingIntent.getActivity(messagingService, 0, (launchIntentForPackage == null || (intent = launchIntentForPackage.setPackage(null)) == null) ? null : intent.setFlags(270532608), 67108864);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(messagingService, com.arizona.launcher.MessagingService.CHANNEL_ID).setSmallIcon(com.miami.game.core.drawable.resources.R.mipmap.ic_launcher_foreground);
        RemoteMessage.Notification notification = message.getNotification();
        NotificationCompat.Builder contentTitle = smallIcon.setContentTitle(notification != null ? notification.getTitle() : null);
        RemoteMessage.Notification notification2 = message.getNotification();
        NotificationCompat.Builder contentIntent = contentTitle.setContentText(notification2 != null ? notification2.getBody() : null).setAutoCancel(true).setContentIntent(activity);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(com.arizona.launcher.MessagingService.CHANNEL_ID, "Default channel", 3));
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
        getMessagingRepository().saveToken(p0);
        Timber.Forest.d("New token: " + p0, new Object[0]);
        FirebaseMessaging.getInstance().subscribeToTopic(this.topic).addOnCompleteListener(new OnCompleteListener() { // from class: com.miami.game.core.firebase.notification.MessagingService$$ExternalSyntheticLambda0
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
        Timber.Forest.d(str, new Object[0]);
    }
}
