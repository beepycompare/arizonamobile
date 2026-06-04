package com.miami.game.core.foreground.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: DownloadService.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002R#\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u0092\u0002\u0002\b\n¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u001f¨\u0006\u001e"}, d2 = {"Lcom/miami/game/core/foreground/service/DownloadService;", "Landroid/app/Service;", "<init>", "()V", "filesUpdaterInteractor", "Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "getFilesUpdaterInteractor", "()Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "setFilesUpdaterInteractor", "(Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;)V", "Ljavax/inject/Inject;", "notificationManager", "Landroid/app/NotificationManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onCreate", "", "onBind", "Landroid/os/IBinder;", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "createNotificationChannel", "updateNotification", "createNotification", "Landroid/app/Notification;", "progress", "", "remainingTime", "", "Companion", "foreground-service", "Ldagger/hilt/android/AndroidEntryPoint;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes5.dex */
public final class DownloadService extends Hilt_DownloadService {
    private static final String CHANNEL_ID = "channel_id_update_notification";
    private static final String CHANNEL_NAME = "Обновления";
    public static final Companion Companion = new Companion(null);
    private static final int NOTIFICATION_ID = 1;
    @Inject
    public FilesUpdaterInteractor filesUpdaterInteractor;
    private NotificationManager notificationManager;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    public final FilesUpdaterInteractor getFilesUpdaterInteractor() {
        FilesUpdaterInteractor filesUpdaterInteractor = this.filesUpdaterInteractor;
        if (filesUpdaterInteractor != null) {
            return filesUpdaterInteractor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filesUpdaterInteractor");
        return null;
    }

    public final void setFilesUpdaterInteractor(FilesUpdaterInteractor filesUpdaterInteractor) {
        Intrinsics.checkNotNullParameter(filesUpdaterInteractor, "<set-?>");
        this.filesUpdaterInteractor = filesUpdaterInteractor;
    }

    @Override // com.miami.game.core.foreground.service.Hilt_DownloadService, android.app.Service
    public void onCreate() {
        Log.d(NotificationCompat.CATEGORY_SERVICE, " created ");
        super.onCreate();
        createNotificationChannel();
        startForeground(1, createNotification$default(this, 0, null, 3, null));
        updateNotification();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        throw new NotImplementedError("An operation is not implemented: Return the communication channel to the service.");
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 2);
            Object systemService = getSystemService(NotificationManager.class);
            Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
            NotificationManager notificationManager = (NotificationManager) systemService;
            this.notificationManager = notificationManager;
            if (notificationManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                notificationManager = null;
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final void updateNotification() {
        FlowKt.launchIn(FlowKt.onEach(getFilesUpdaterInteractor().getInteractorStateFlow(), new DownloadService$updateNotification$1(this, null)), this.scope);
    }

    static /* synthetic */ Notification createNotification$default(DownloadService downloadService, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        return downloadService.createNotification(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Notification createNotification(int i, String str) {
        Intent intent;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        Intent intent2 = null;
        if (launchIntentForPackage != null && (intent = launchIntentForPackage.setPackage(null)) != null) {
            intent2 = intent.setFlags(270532608);
        }
        DownloadService downloadService = this;
        Notification build = new NotificationCompat.Builder(downloadService, CHANNEL_ID).setContentTitle("Обновление").setContentText("Осталось времени " + str).setSmallIcon(17301540).setProgress(100, i, false).setContentIntent(PendingIntent.getActivity(downloadService, 0, intent2, 67108864)).setOngoing(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* compiled from: DownloadService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/miami/game/core/foreground/service/DownloadService$Companion;", "", "<init>", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "NOTIFICATION_ID", "", "newIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "foreground-service"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, DownloadService.class);
        }
    }
}
