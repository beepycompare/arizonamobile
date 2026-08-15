package com.arizona.launcher;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.collection.SieveCacheKt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.preference.PreferenceManager;
import coil3.util.UtilsKt;
import com.adjust.sdk.Constants;
import com.arizona.game.R;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.miami.game.core.firebase.notification.NotificationIntentExtras;
import com.miami.game.core.firebase.notification.NotificationInteractionEvent;
import com.miami.game.core.firebase.notification.NotificationInteractionType;
import com.miami.game.core.firebase.notification.NotificationStatsTracker;
import com.miami.game.core.firebase.notification.PushNotificationPayload;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
/* compiled from: MessagingService.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\f\u0010\"\u001a\u00020\u001a*\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u000fH\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010%2\u0006\u0010.\u001a\u00020)H\u0002J(\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020%H\u0002J\u0014\u00105\u001a\u00020%*\u0002062\u0006\u00107\u001a\u00020\u001aH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b:\u0012\b\b;\u0012\u0004\b\u0003\u0010\u0000¨\u00069"}, d2 = {"Lcom/arizona/launcher/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "notificationStatsTracker", "Lcom/miami/game/core/firebase/notification/NotificationStatsTracker;", "getNotificationStatsTracker", "()Lcom/miami/game/core/firebase/notification/NotificationStatsTracker;", "notificationStatsTracker$delegate", "Lkotlin/Lazy;", "onMessageReceived", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "topic", "", "getTopic", "()Ljava/lang/String;", "onNewToken", "p0", "saveNotificationData", "appDatabase", "Lcom/arizona/launcher/data/database/ArizonaDatabase;", "payload", "Lcom/miami/game/core/firebase/notification/PushNotificationPayload;", "pendingIntentFlags", "", "canDisplayNotification", "", "manager", "Landroid/app/NotificationManager;", "trackNotificationReceived", "receivedAtMillis", "", "notificationId", "defaultNotificationImageUrl", "loadNotificationImage", "Landroid/graphics/Bitmap;", "imageUrl", "loadRemoteBitmap", "readBytesWithLimit", "", "inputStream", "Ljava/io/InputStream;", "maxBytes", "decodeSampledBitmap", "bytes", "calculateInSampleSize", "width", "height", "maxWidth", "maxHeight", "loadAppIconBitmap", "toBitmap", "Landroid/graphics/drawable/Drawable;", "sizePx", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessagingService extends FirebaseMessagingService {
    @Deprecated
    public static final int APP_ICON_SIZE_PX = 512;
    @Deprecated
    public static final String CHANNEL_ID = "Default";
    @Deprecated
    public static final int IMAGE_CONNECT_TIMEOUT_MS = 2000;
    @Deprecated
    public static final int IMAGE_READ_TIMEOUT_MS = 2500;
    @Deprecated
    public static final int MAX_BIG_PICTURE_SIZE_PX = 1024;
    @Deprecated
    public static final int MAX_IMAGE_BYTES = 3145728;
    @Deprecated
    public static final String TAG = "MESSAGING";
    private final Lazy notificationStatsTracker$delegate = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.MessagingService$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MessagingService.notificationStatsTracker_delegate$lambda$0(MessagingService.this);
        }
    });
    private final String topic = "subscriber-updates";
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final IntRange HTTP_OK_RANGE = new IntRange(200, 299);

    private final int pendingIntentFlags() {
        return 201326592;
    }

    private final NotificationStatsTracker getNotificationStatsTracker() {
        return (NotificationStatsTracker) this.notificationStatsTracker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NotificationStatsTracker notificationStatsTracker_delegate$lambda$0(MessagingService messagingService) {
        Context applicationContext = messagingService.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new NotificationStatsTracker(applicationContext, null, 2, null);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Object m9916constructorimpl;
        Boolean m9916constructorimpl2;
        Object m9916constructorimpl3;
        Intrinsics.checkNotNullParameter(message, "message");
        super.onMessageReceived(message);
        PushNotificationPayload fromRemoteMessage = PushNotificationPayload.Companion.fromRemoteMessage(message);
        if (fromRemoteMessage == null) {
            Log.d(TAG, "FCM message ignored: no title/body in data payload");
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            MessagingService messagingService = this;
            saveNotificationData(ArizonaDatabase.Companion.getInstance(this), fromRemoteMessage);
            m9916constructorimpl = Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
        if (m9919exceptionOrNullimpl != null) {
            Log.w(TAG, "Failed to save notification history", m9919exceptionOrNullimpl);
        }
        long currentTimeMillis = System.currentTimeMillis();
        MessagingService messagingService2 = this;
        Intent intent = new Intent(messagingService2, MainEntrench.class);
        intent.setFlags(270532608);
        NotificationIntentExtras.INSTANCE.putInto(intent, fromRemoteMessage, Long.valueOf(currentTimeMillis));
        int notificationId = notificationId(fromRemoteMessage);
        PendingIntent activity = PendingIntent.getActivity(messagingService2, notificationId, intent, pendingIntentFlags());
        Bitmap loadAppIconBitmap = loadAppIconBitmap();
        Bitmap loadNotificationImage = loadNotificationImage(fromRemoteMessage.getImageUrl());
        if (loadNotificationImage == null) {
            loadNotificationImage = loadAppIconBitmap;
        }
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(messagingService2, CHANNEL_ID).setSmallIcon(R.mipmap.ic_launcher_foreground).setLargeIcon(loadAppIconBitmap).setContentTitle(fromRemoteMessage.getTitle()).setContentText(fromRemoteMessage.getBody()).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(loadNotificationImage).bigLargeIcon(loadAppIconBitmap).setBigContentTitle(fromRemoteMessage.getTitle()).setSummaryText(fromRemoteMessage.getBody())).setAutoCancel(true).setContentIntent(activity);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Default channel", 3));
        }
        try {
            Result.Companion companion3 = Result.Companion;
            MessagingService messagingService3 = this;
            m9916constructorimpl2 = Result.m9916constructorimpl(Boolean.valueOf(canDisplayNotification(notificationManager)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m9916constructorimpl2 = Result.m9916constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable m9919exceptionOrNullimpl2 = Result.m9919exceptionOrNullimpl(m9916constructorimpl2);
        if (m9919exceptionOrNullimpl2 != null) {
            Log.w(TAG, "Failed to check notification display availability", m9919exceptionOrNullimpl2);
        }
        if (Result.m9922isFailureimpl(m9916constructorimpl2)) {
            m9916constructorimpl2 = false;
        }
        if (!((Boolean) m9916constructorimpl2).booleanValue()) {
            Log.w(TAG, "Notification display skipped: notifications are disabled");
            return;
        }
        try {
            Result.Companion companion5 = Result.Companion;
            MessagingService messagingService4 = this;
            notificationManager.notify(notificationId, contentIntent.build());
            m9916constructorimpl3 = Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            m9916constructorimpl3 = Result.m9916constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable m9919exceptionOrNullimpl3 = Result.m9919exceptionOrNullimpl(m9916constructorimpl3);
        if (m9919exceptionOrNullimpl3 != null) {
            Log.w(TAG, "Failed to post notification", m9919exceptionOrNullimpl3);
        }
        if (Result.m9923isSuccessimpl(m9916constructorimpl3)) {
            trackNotificationReceived(fromRemoteMessage, currentTimeMillis);
        }
    }

    public final String getTopic() {
        return this.topic;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        super.onNewToken(p0);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("token", p0).apply();
        Log.d(TAG, "New token: " + p0);
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
        Log.d(TAG, str);
    }

    private final void saveNotificationData(ArizonaDatabase arizonaDatabase, PushNotificationPayload pushNotificationPayload) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new MessagingService$saveNotificationData$1(arizonaDatabase, pushNotificationPayload, this, null), 3, null);
    }

    private final boolean canDisplayNotification(NotificationManager notificationManager) {
        NotificationChannel notificationChannel;
        if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return Build.VERSION.SDK_INT < 26 || (notificationChannel = notificationManager.getNotificationChannel(CHANNEL_ID)) == null || notificationChannel.getImportance() != 0;
        }
        return false;
    }

    private final void trackNotificationReceived(PushNotificationPayload pushNotificationPayload, long j) {
        String notifRef = pushNotificationPayload.getNotifRef();
        if (notifRef != null) {
            String str = !StringsKt.isBlank(notifRef) ? notifRef : null;
            if (str == null) {
                return;
            }
            NotificationStatsTracker notificationStatsTracker = getNotificationStatsTracker();
            NotificationInteractionType notificationInteractionType = NotificationInteractionType.RECEIVED;
            String sentAt = pushNotificationPayload.getSentAt();
            Long valueOf = Long.valueOf(j);
            Map createMapBuilder = MapsKt.createMapBuilder();
            String messageId = pushNotificationPayload.getMessageId();
            if (messageId != null) {
                String str2 = StringsKt.isBlank(messageId) ? null : messageId;
                if (str2 != null) {
                    createMapBuilder.put("fcm_message_id", str2);
                }
            }
            Unit unit = Unit.INSTANCE;
            notificationStatsTracker.recordAndFlush(new NotificationInteractionEvent(notificationInteractionType, str, sentAt, j, valueOf, MapsKt.build(createMapBuilder)));
        }
    }

    private final int notificationId(PushNotificationPayload pushNotificationPayload) {
        String notifRef = pushNotificationPayload.getNotifRef();
        if (notifRef == null) {
            notifRef = pushNotificationPayload.getMessageId();
        }
        return notifRef != null ? notifRef.hashCode() >>> 1 : (int) (System.currentTimeMillis() % SieveCacheKt.NodeLinkMask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String defaultNotificationImageUrl() {
        String packageName = getPackageName();
        return "android.resource://" + packageName + "/" + R.mipmap.ic_launcher;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #2 {all -> 0x0091, blocks: (B:7:0x000e, B:9:0x001d, B:12:0x002d, B:13:0x0031, B:15:0x0035, B:31:0x0067, B:33:0x0071, B:35:0x0080, B:43:0x008c, B:18:0x003e, B:24:0x0050, B:21:0x0047, B:25:0x0055, B:28:0x005e, B:34:0x0073), top: B:56:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap loadNotificationImage(String str) {
        Object m9916constructorimpl;
        Throwable m9919exceptionOrNullimpl;
        Uri parse;
        String str2;
        Bitmap bitmap;
        InputStream openInputStream;
        String str3 = str;
        if (str3 == null || StringsKt.isBlank(str3)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            MessagingService messagingService = this;
            parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null) {
                str2 = scheme.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
            } else {
                str2 = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -368816979:
                    if (!str2.equals("android.resource")) {
                        break;
                    }
                    openInputStream = getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                        InputStream inputStream = openInputStream;
                        bitmap = decodeSampledBitmap(readBytesWithLimit(inputStream, MAX_IMAGE_BYTES));
                        CloseableKt.closeFinally(inputStream, null);
                        break;
                    }
                    break;
                case 3143036:
                    if (!str2.equals(UtilsKt.SCHEME_FILE)) {
                        break;
                    }
                    openInputStream = getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                    }
                    break;
                case 3213448:
                    if (!str2.equals("http")) {
                        break;
                    }
                    bitmap = loadRemoteBitmap(str);
                    break;
                case 99617003:
                    if (!str2.equals(Constants.SCHEME)) {
                        break;
                    }
                    bitmap = loadRemoteBitmap(str);
                    break;
                case 951530617:
                    if (!str2.equals(FirebaseAnalytics.Param.CONTENT)) {
                        break;
                    }
                    openInputStream = getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                    }
                    break;
            }
            m9916constructorimpl = Result.m9916constructorimpl(bitmap);
            m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
            if (m9919exceptionOrNullimpl != null) {
                Log.w(TAG, "Failed to load notification image: " + str, m9919exceptionOrNullimpl);
            }
            return Result.m9922isFailureimpl(m9916constructorimpl) ? null : m9916constructorimpl;
        }
        bitmap = null;
        m9916constructorimpl = Result.m9916constructorimpl(bitmap);
        m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
        if (m9919exceptionOrNullimpl != null) {
        }
        return Result.m9922isFailureimpl(m9916constructorimpl) ? null : m9916constructorimpl;
    }

    private final Bitmap loadRemoteBitmap(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(2500);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "image/*");
        try {
            IntRange intRange = HTTP_OK_RANGE;
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int responseCode = httpURLConnection.getResponseCode();
            if (first > responseCode || responseCode > last) {
                Log.w(TAG, "Notification image request failed: " + httpURLConnection.getResponseCode());
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            Bitmap decodeSampledBitmap = decodeSampledBitmap(readBytesWithLimit(bufferedInputStream, MAX_IMAGE_BYTES));
            CloseableKt.closeFinally(bufferedInputStream, null);
            return decodeSampledBitmap;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private final byte[] readBytesWithLimit(InputStream inputStream, int i) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                return byteArray;
            }
            i2 += read;
            if (i2 > i) {
                throw new IllegalArgumentException("Notification image is larger than " + i + " bytes");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private final Bitmap decodeSampledBitmap(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int calculateInSampleSize = calculateInSampleSize(options.outWidth, options.outHeight, 1024, 1024);
        int length = bArr.length;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = calculateInSampleSize;
        Unit unit = Unit.INSTANCE;
        return BitmapFactory.decodeByteArray(bArr, 0, length, options2);
    }

    private final int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 <= 0 || i <= 0) {
            return 1;
        }
        while (true) {
            if (i2 / i5 <= i4 && i / i5 <= i3) {
                return i5;
            }
            i5 *= 2;
        }
    }

    private final Bitmap loadAppIconBitmap() {
        Object m9916constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            MessagingService messagingService = this;
            Drawable applicationIcon = getPackageManager().getApplicationIcon(getApplicationInfo());
            Intrinsics.checkNotNullExpressionValue(applicationIcon, "getApplicationIcon(...)");
            m9916constructorimpl = Result.m9916constructorimpl(toBitmap(applicationIcon, 512));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
        if (m9919exceptionOrNullimpl != null) {
            Log.w(TAG, "Failed to load application icon for notification", m9919exceptionOrNullimpl);
        }
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
            m9916constructorimpl = null;
        }
        Bitmap bitmap = (Bitmap) m9916constructorimpl;
        if (bitmap == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            if (decodeResource == null) {
                Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                return createBitmap;
            }
            return decodeResource;
        }
        return bitmap;
    }

    private final Bitmap toBitmap(Drawable drawable, int i) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                return bitmap;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* compiled from: MessagingService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/MessagingService$Companion;", "", "<init>", "()V", "TAG", "", "CHANNEL_ID", "IMAGE_CONNECT_TIMEOUT_MS", "", "IMAGE_READ_TIMEOUT_MS", "MAX_IMAGE_BYTES", "MAX_BIG_PICTURE_SIZE_PX", "APP_ICON_SIZE_PX", "HTTP_OK_RANGE", "Lkotlin/ranges/IntRange;", "getHTTP_OK_RANGE", "()Lkotlin/ranges/IntRange;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntRange getHTTP_OK_RANGE() {
            return MessagingService.HTTP_OK_RANGE;
        }
    }
}
