package com.arizona.launcher;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.adjust.sdk.Constants;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arizona.game.R;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.util.FileServers;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.liulishuo.okdownload.DownloadContext;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.LauncherBreakpointStoreOnSQLite;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.dispatcher.DownloadDispatcher;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener1ExtensionKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001#\b\u0007\u0018\u0000 q2\u00020\u0001:\u0005qrstuB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\"\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020&H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020&H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00106\u001a\u0002022\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00107\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0012\u00109\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010+H\u0016J\u000e\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u0012J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0006\u0010?\u001a\u00020&J\b\u0010@\u001a\u00020&H\u0002J \u0010A\u001a\u0002022\u0006\u0010B\u001a\u0002022\u0006\u0010C\u001a\u0002022\u0006\u0010D\u001a\u000202H\u0002J\u0018\u0010E\u001a\u0012\u0012\u0004\u0012\u00020)0Fj\b\u0012\u0004\u0012\u00020)`GH\u0002J \u0010H\u001a\u00020&2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020)0Fj\b\u0012\u0004\u0012\u00020)`GH\u0002J\b\u0010J\u001a\u00020&H\u0002J\u0010\u0010K\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0014H\u0002J\b\u0010P\u001a\u00020\u0012H\u0002J\u0010\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020\bH\u0002J(\u0010S\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00140T2\u0006\u0010U\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010VJ8\u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140T0\u00112\u0006\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010[JD\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120]2\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010B\u001a\u0002022\u0006\u0010_\u001a\u0002022\u0006\u0010D\u001a\u000202H\u0002J(\u0010`\u001a\u0002022\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010B\u001a\u0002022\u0006\u0010D\u001a\u000202H\u0002J\u0018\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020bH\u0002J\f\u0010h\u001a\u00020\u0012*\u00020iH\u0002J\u0010\u0010j\u001a\u00020&2\u0006\u0010<\u001a\u00020\u0012H\u0002J\b\u0010k\u001a\u00020&H\u0002J\u0010\u0010m\u001a\u00020&2\u0006\u0010<\u001a\u00020\u0012H\u0002J\u001c\u0010n\u001a\u00020&2\u0006\u0010<\u001a\u00020\u00122\f\u0010o\u001a\b\u0012\u0004\u0012\u00020&0pR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010l\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/arizona/launcher/UpdateService;", "Landroid/app/Service;", "<init>", "()V", "updatePreferences", "Landroid/content/SharedPreferences;", "mUpdateStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/arizona/launcher/UpdateService$UpdateStatus;", "mGameStatus", "Lcom/arizona/launcher/UpdateService$GameStatus;", "mMessenger", "Landroid/os/Messenger;", "mActivityMessenger", "mInHandler", "Lcom/arizona/launcher/UpdateService$IncomingHandler;", "mUpdateFiles", "", "", "mUpdateFilesNeedSize", "", "mDownloadContext", "Lcom/liulishuo/okdownload/DownloadContext;", "mTotalLength", "mDownloadedLength", "mSpeedCalculator", "Lcom/liulishuo/okdownload/SpeedCalculator;", "mLastOperationStatus", "Lcom/arizona/launcher/UpdateService$Errno;", "mDataInfo", "Lorg/json/JSONArray;", "mainHandler", "Landroid/os/Handler;", "lastDownloadedBytes", "checkTimeoutRunnable", "com/arizona/launcher/UpdateService$checkTimeoutRunnable$1", "Lcom/arizona/launcher/UpdateService$checkTimeoutRunnable$1;", "onCreate", "", "createNotificationChannel", "onStartCommand", "", "intent", "Landroid/content/Intent;", DownloaderServiceMarshaller.PARAMS_FLAGS, "startId", "startForegroundService", "createNotification", "Landroid/app/Notification;", "indeterminate", "", "stopForegroundService", "onBind", "Landroid/os/IBinder;", "onUnbind", "onRebind", "onDestroy", "onTaskRemoved", "rootIntent", "checkUpdate", "server", "isGameDataUpdateExists", "resetGameStatus", "updateGameData", "downloadGameData", "isAllFilesOk", "checkHash", "purgeExtraFiles", "forceFileEditDate", "notFinishedTaskIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "saveDownloadTaskIdList", "list", "removeDownloadTaskIdList", "updateStatusInfoAndProgress", "calcSpeed", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "currentOffset", "timeLeft", "setUpdateStatus", NotificationCompat.CATEGORY_STATUS, "checkGameDataUpdate", "Lkotlin/Pair;", "dataInfo", "(Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilesToDownload", "sources", "dir", "destDir", "(Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDamagedFiles", "", "fileSourceJson", "addExtraFilesToPurgeList", "checkSingleFile", "file", "Ljava/io/File;", "fileJson", "Lorg/json/JSONObject;", "getFileChecksum", "digest", "Ljava/security/MessageDigest;", "toHex", "", "checkLauncherUpdate", "notifyServerUnreachable", "retry", "startDownloadNewLauncherApk", "checkUpdateAndDownload", "onFinish", "Lkotlin/Function0;", "Companion", "Errno", "UpdateStatus", "GameStatus", "IncomingHandler", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateService extends Hilt_UpdateService {
    public static final String ACTION_START_FOREGROUND_SERVICE = "Start foreground";
    public static final String ACTION_STOP_FOREGROUND_SERVICE = "Stop foreground";
    private static final int BYTE_TO_KILOBYTE_DIVIDER = 1024;
    public static final int CHECK_AND_UPDATE = 10;
    public static final int CHECK_LAUNCHER_UPDATE = 3;
    public static final int CHECK_STATE_ERROR = 9;
    public static final int CHECK_UPDATE = 0;
    private static final int CURRENT_PROGRESS = 2;
    public static final String ERRNO_MSG = "errno";
    private static final int FOREGROUND_NOTIFICATION_ID = 1;
    public static final int FULL_CHECK = 8;
    public static final int GAME_STATUS = 5;
    public static final String NEED_UPDATE_MSG = "needUpdateMsg";
    private static final String PREFERENCE_FILE_KEY = "downloadPreference";
    private static final String TAG = "UPDATE_SERVICE";
    private static final String TASK_ID_LIST_KEY = "taskIdList";
    private static final long TIMEOUT_DOWNLOADER = 5000;
    public static final int UPDATE_GAME_DATA = 2;
    public static final int UPDATE_INFO = 7;
    public static final int UPDATE_LAUNCHER = 6;
    private static final String UPDATE_SERVICE_CHANNEL_ID = "UpdateServiceChannelID";
    public static final int UPDATE_STATUS = 4;
    private long lastDownloadedBytes;
    private Messenger mActivityMessenger;
    private DownloadContext mDownloadContext;
    private long mDownloadedLength;
    private IncomingHandler mInHandler;
    private Messenger mMessenger;
    private SpeedCalculator mSpeedCalculator;
    private long mTotalLength;
    private long mUpdateFilesNeedSize;
    private int retry;
    private SharedPreferences updatePreferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final List<String> excludeFromCheck = CollectionsKt.listOf("settings.json");
    private AtomicReference<UpdateStatus> mUpdateStatus = new AtomicReference<>(UpdateStatus.Undefined);
    private AtomicReference<GameStatus> mGameStatus = new AtomicReference<>(GameStatus.Undefined);
    private List<String> mUpdateFiles = new ArrayList();
    private Errno mLastOperationStatus = Errno.NoError;
    private JSONArray mDataInfo = new JSONArray();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final UpdateService$checkTimeoutRunnable$1 checkTimeoutRunnable = new Runnable() { // from class: com.arizona.launcher.UpdateService$checkTimeoutRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            Handler handler;
            long j3;
            long j4;
            DownloadContext downloadContext;
            j = UpdateService.this.lastDownloadedBytes;
            if (j != 0) {
                j3 = UpdateService.this.mDownloadedLength;
                j4 = UpdateService.this.lastDownloadedBytes;
                if (j3 <= j4) {
                    DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
                    Intrinsics.checkNotNullExpressionValue(downloadDispatcher, "downloadDispatcher(...)");
                    synchronized (downloadDispatcher) {
                        OkDownload.with().downloadDispatcher().cancelAll();
                        Unit unit = Unit.INSTANCE;
                    }
                    downloadContext = UpdateService.this.mDownloadContext;
                    if (downloadContext != null) {
                        downloadContext.stop();
                    }
                    UpdateService.this.mDownloadContext = null;
                    return;
                }
            }
            UpdateService updateService = UpdateService.this;
            j2 = updateService.mDownloadedLength;
            updateService.lastDownloadedBytes = j2 + 1;
            handler = UpdateService.this.mainHandler;
            handler.postDelayed(this, 5000L);
        }
    };

    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/arizona/launcher/UpdateService$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_START_FOREGROUND_SERVICE", "ACTION_STOP_FOREGROUND_SERVICE", "CHECK_UPDATE", "", "UPDATE_GAME_DATA", "CHECK_LAUNCHER_UPDATE", "UPDATE_STATUS", "GAME_STATUS", "UPDATE_LAUNCHER", "UPDATE_INFO", "FULL_CHECK", "CHECK_STATE_ERROR", "CHECK_AND_UPDATE", "BYTE_TO_KILOBYTE_DIVIDER", "CURRENT_PROGRESS", "TIMEOUT_DOWNLOADER", "", "NEED_UPDATE_MSG", "ERRNO_MSG", "UPDATE_SERVICE_CHANNEL_ID", "FOREGROUND_NOTIFICATION_ID", "PREFERENCE_FILE_KEY", "TASK_ID_LIST_KEY", "excludeFromCheck", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateService$Errno;", "", "<init>", "(Ljava/lang/String;I)V", "NoError", "UpdateServerUnreachable", "ConnectionRefused", "CorruptedFilesFound", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Errno {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Errno[] $VALUES;
        public static final Errno NoError = new Errno("NoError", 0);
        public static final Errno UpdateServerUnreachable = new Errno("UpdateServerUnreachable", 1);
        public static final Errno ConnectionRefused = new Errno("ConnectionRefused", 2);
        public static final Errno CorruptedFilesFound = new Errno("CorruptedFilesFound", 3);

        private static final /* synthetic */ Errno[] $values() {
            return new Errno[]{NoError, UpdateServerUnreachable, ConnectionRefused, CorruptedFilesFound};
        }

        public static EnumEntries<Errno> getEntries() {
            return $ENTRIES;
        }

        private Errno(String str, int i) {
        }

        static {
            Errno[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Errno valueOf(String str) {
            return (Errno) Enum.valueOf(Errno.class, str);
        }

        public static Errno[] values() {
            return (Errno[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/UpdateService$UpdateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "CheckUpdate", "CheckFiles", "DownloadGame", "DownloadGameData", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UpdateStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UpdateStatus[] $VALUES;
        public static final UpdateStatus Undefined = new UpdateStatus("Undefined", 0);
        public static final UpdateStatus CheckUpdate = new UpdateStatus("CheckUpdate", 1);
        public static final UpdateStatus CheckFiles = new UpdateStatus("CheckFiles", 2);
        public static final UpdateStatus DownloadGame = new UpdateStatus("DownloadGame", 3);
        public static final UpdateStatus DownloadGameData = new UpdateStatus("DownloadGameData", 4);

        private static final /* synthetic */ UpdateStatus[] $values() {
            return new UpdateStatus[]{Undefined, CheckUpdate, CheckFiles, DownloadGame, DownloadGameData};
        }

        public static EnumEntries<UpdateStatus> getEntries() {
            return $ENTRIES;
        }

        private UpdateStatus(String str, int i) {
        }

        static {
            UpdateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static UpdateStatus valueOf(String str) {
            return (UpdateStatus) Enum.valueOf(UpdateStatus.class, str);
        }

        public static UpdateStatus[] values() {
            return (UpdateStatus[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateService$GameStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "UnsupportedVersion", "UpdateRequired", "Updated", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GameStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GameStatus[] $VALUES;
        public static final GameStatus Undefined = new GameStatus("Undefined", 0);
        public static final GameStatus UnsupportedVersion = new GameStatus("UnsupportedVersion", 1);
        public static final GameStatus UpdateRequired = new GameStatus("UpdateRequired", 2);
        public static final GameStatus Updated = new GameStatus("Updated", 3);

        private static final /* synthetic */ GameStatus[] $values() {
            return new GameStatus[]{Undefined, UnsupportedVersion, UpdateRequired, Updated};
        }

        public static EnumEntries<GameStatus> getEntries() {
            return $ENTRIES;
        }

        private GameStatus(String str, int i) {
        }

        static {
            GameStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static GameStatus valueOf(String str) {
            return (GameStatus) Enum.valueOf(GameStatus.class, str);
        }

        public static GameStatus[] values() {
            return (GameStatus[]) $VALUES.clone();
        }
    }

    @Override // com.arizona.launcher.Hilt_UpdateService, android.app.Service
    public void onCreate() {
        LauncherBreakpointStoreOnSQLite launcherBreakpointStoreOnSQLite = new LauncherBreakpointStoreOnSQLite(this);
        this.updatePreferences = getSharedPreferences("update_data", 0);
        try {
            OkDownload.setSingletonInstance(new OkDownload.Builder(getApplicationContext()).downloadStore(launcherBreakpointStoreOnSQLite).build());
            Log.d(TAG, "Init OkDownload instance");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
        handlerThread.start();
        createNotificationChannel();
        resetGameStatus();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.mInHandler = new IncomingHandler(this, looper);
        this.mMessenger = new Messenger(this.mInHandler);
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(UPDATE_SERVICE_CHANNEL_ID, "Update Service", 2);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(TAG, "onStartCommand");
        int onStartCommand = super.onStartCommand(intent, i, i2);
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != 880218081) {
                if (hashCode == 1443478529 && action.equals(ACTION_STOP_FOREGROUND_SERVICE)) {
                    Log.d(TAG, "Receive ACTION_STOP_FOREGROUND_SERVICE");
                    stopForegroundService();
                    return onStartCommand;
                }
            } else if (action.equals(ACTION_START_FOREGROUND_SERVICE)) {
                Log.d(TAG, "Receive ACTION_START_FOREGROUND_SERVICE");
                startForegroundService();
                return 2;
            }
        }
        return onStartCommand;
    }

    private final void startForegroundService() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Log.i(TAG, "startForegroundService");
                Notification createNotification = createNotification(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    startForeground(1, createNotification, 1);
                } else {
                    startForeground(1, createNotification);
                }
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
                e.printStackTrace();
                if (Build.VERSION.SDK_INT >= 31 && (e instanceof ForegroundServiceStartNotAllowedException)) {
                    Log.e(TAG, "Foreground service cannot be started: " + e.getMessage());
                    return;
                }
                Log.e(TAG, "An error occurred: " + e.getMessage());
            }
        }
    }

    private final Notification createNotification(boolean z) {
        Intent intent;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        Intent intent2 = null;
        if (launchIntentForPackage != null && (intent = launchIntentForPackage.setPackage(null)) != null) {
            intent2 = intent.setFlags(270532608);
        }
        UpdateService updateService = this;
        long j = 1024;
        Notification build = new NotificationCompat.Builder(updateService, UPDATE_SERVICE_CHANNEL_ID).setContentTitle(getString(R.string.update)).setContentText("Осталось времени: " + timeLeft()).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(PendingIntent.getActivity(updateService, 0, intent2, 67108864)).setProgress((int) (this.mTotalLength / j), (int) (this.mDownloadedLength / j), z).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopForegroundService() {
        Log.i(TAG, "stopForegroundService");
        stopForeground(2);
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.v(TAG, "onBind");
        Messenger messenger = this.mMessenger;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.i(TAG, "onUnbind");
        return false;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Log.i(TAG, "onRebind");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        Log.i(TAG, "onTaskRemoved");
        stopSelf();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final void checkUpdate(String server) {
        Intrinsics.checkNotNullParameter(server, "server");
        Log.i(TAG, "checkUpdate: requesting server for update json");
        startForegroundService();
        setUpdateStatus(UpdateStatus.CheckUpdate);
        RequestQueue newRequestQueue = Volley.newRequestQueue(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(newRequestQueue, "newRequestQueue(...)");
        this.mLastOperationStatus = Errno.NoError;
        if (server.length() == 0) {
            this.mLastOperationStatus = Errno.UpdateServerUnreachable;
            Message obtain = Message.obtain(this.mInHandler, 0);
            obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Messenger messenger = this.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
            Log.w(TAG, "Send message server unreachable " + obtain);
            stopForegroundService();
            return;
        }
        StringRequest stringRequest = new StringRequest(0, server + UpdateJsonProvider.INSTANCE.getJsonName(this), new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda3
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkUpdate$lambda$1(UpdateService.this, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.checkUpdate$lambda$2(UpdateService.this, volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        newRequestQueue.add(stringRequest);
        Log.v(TAG, "Add to queue " + stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUpdate$lambda$1(UpdateService updateService, final String str) {
        final JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = (JSONArray) new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                JSONArray checkUpdate$lambda$1$lambda$0;
                checkUpdate$lambda$1$lambda$0 = UpdateService.checkUpdate$lambda$1$lambda$0(jSONObject, str, (String) obj);
                return checkUpdate$lambda$1$lambda$0;
            }
        }.invoke("files");
        updateService.mDataInfo = jSONArray;
        Log.v(TAG, "mDataInfo " + jSONArray);
        updateService.mUpdateFiles = new ArrayList();
        updateService.mUpdateFilesNeedSize = 0L;
        updateService.setUpdateStatus(UpdateStatus.CheckFiles);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UpdateService$checkUpdate$stringRequest$1$1(updateService, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray checkUpdate$lambda$1$lambda$0(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("data");
        int length = jSONArray.length();
        if (length >= 0) {
            int i = 0;
            while (!Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("name"), str2)) {
                if (i != length) {
                    i++;
                }
            }
            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
            return jSONArray2;
        }
        throw new Exception("JSON Corrupted " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUpdate$lambda$2(UpdateService updateService, VolleyError volleyError) {
        FileServers.INSTANCE.currentServerIsUnreachable();
        updateService.mLastOperationStatus = Errno.UpdateServerUnreachable;
        updateService.setUpdateStatus(UpdateStatus.Undefined);
        Message obtain = Message.obtain(updateService.mInHandler, 0);
        obtain.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, false);
        obtain.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
        obtain.replyTo = updateService.mMessenger;
        Messenger messenger = updateService.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
        Log.w(TAG, "Send message server unreachable " + obtain);
        updateService.stopForegroundService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isGameDataUpdateExists() {
        return !this.mUpdateFiles.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGameStatus() {
        Log.i(TAG, "resetGameStatus");
        this.mGameStatus.set(isGameDataUpdateExists() ? GameStatus.UpdateRequired : GameStatus.Updated);
        Log.d(TAG, "Installed game status: " + this.mGameStatus.get());
    }

    public final void updateGameData() {
        if (isGameDataUpdateExists()) {
            Log.d(TAG, "updateGameData: game data update exists, downloading game data...");
            setUpdateStatus(UpdateStatus.DownloadGameData);
            downloadGameData();
            return;
        }
        Log.d(TAG, "updateGameData: game update status: undefined");
        setUpdateStatus(UpdateStatus.Undefined);
        Message obtain = Message.obtain(this.mInHandler, 2);
        obtain.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, true);
        obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
        Log.v(TAG, "Send message game data updated " + obtain);
    }

    private final void downloadGameData() {
        File externalFilesDir;
        Log.i(TAG, "Downloading game data...");
        startForegroundService();
        DownloadContext.Builder commit = new DownloadContext.QueueSet().setMinIntervalMillisCallbackProcess(100).commit();
        this.mDownloadedLength = 0L;
        this.lastDownloadedBytes = 0L;
        this.mTotalLength = 0L;
        String currentServer = FileServers.INSTANCE.getCurrentServer();
        this.mLastOperationStatus = Errno.NoError;
        if (currentServer.length() == 0) {
            this.mLastOperationStatus = Errno.UpdateServerUnreachable;
            Message obtain = Message.obtain(this.mInHandler, 2);
            obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Messenger messenger = this.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
            Log.w(TAG, "Server unreachable: " + currentServer);
            stopForegroundService();
            return;
        }
        final ArrayList<Integer> arrayList = new ArrayList<>();
        int size = this.mUpdateFiles.size();
        for (int i = 0; i < size; i++) {
            String str = currentServer + "data/files" + this.mUpdateFiles.get(i);
            SharedPreferences sharedPreferences = null;
            File file = new File((getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + this.mUpdateFiles.get(i));
            if (!file.isDirectory() && file.exists()) {
                SharedPreferences sharedPreferences2 = this.updatePreferences;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                } else {
                    sharedPreferences = sharedPreferences2;
                }
                sharedPreferences.edit().remove(file.getAbsolutePath()).apply();
                file.delete();
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                Log.e(TAG, "Error make directory " + parentFile.getAbsolutePath());
            }
            Iterator<Integer> it = notFinishedTaskIdList().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Integer next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                int intValue = next.intValue();
                BreakpointInfo breakpointInfo = OkDownload.with().breakpointStore().get(intValue);
                if (breakpointInfo != null && Intrinsics.areEqual(breakpointInfo.getFile(), file)) {
                    BreakpointInfo copyWithReplaceIdAndUrl = breakpointInfo.copyWithReplaceIdAndUrl(intValue, str);
                    OkDownload.with().breakpointStore().update(copyWithReplaceIdAndUrl);
                    Log.i(TAG, "Update breakPoint " + copyWithReplaceIdAndUrl + " " + intValue);
                }
            }
            DownloadTask build = new DownloadTask.Builder(str, file).setPriority(5).setMinIntervalMillisCallbackProcess(300).setConnectionCount(1).setPreAllocateLength(true).build();
            commit.bindSetTask(build);
            Log.v(TAG, "Create download " + build);
            arrayList.add(Integer.valueOf(build.getId()));
        }
        this.mDownloadContext = commit.build();
        this.mSpeedCalculator = new SpeedCalculator();
        saveDownloadTaskIdList(arrayList);
        this.mLastOperationStatus = Errno.NoError;
        long j = this.mUpdateFilesNeedSize;
        this.mTotalLength = j;
        Log.v(TAG, "Get contentLength " + j);
        DownloadContext downloadContext = this.mDownloadContext;
        if (downloadContext != null) {
            downloadContext.start(DownloadListener1ExtensionKt.createListener1$default(null, null, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit downloadGameData$lambda$3;
                    downloadGameData$lambda$3 = UpdateService.downloadGameData$lambda$3((DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                    return downloadGameData$lambda$3;
                }
            }, new Function3() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit downloadGameData$lambda$4;
                    downloadGameData$lambda$4 = UpdateService.downloadGameData$lambda$4(UpdateService.this, (DownloadTask) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                    return downloadGameData$lambda$4;
                }
            }, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit downloadGameData$lambda$6;
                    downloadGameData$lambda$6 = UpdateService.downloadGameData$lambda$6(UpdateService.this, arrayList, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                    return downloadGameData$lambda$6;
                }
            }, 3, null), false);
        }
        this.mainHandler.postDelayed(this.checkTimeoutRunnable, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadGameData$lambda$3(DownloadTask connectTask, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(connectTask, "connectTask");
        Log.v(TAG, "Downloading " + connectTask);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadGameData$lambda$4(UpdateService updateService, DownloadTask progressTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressTask, "progressTask");
        updateService.calcSpeed(progressTask, j);
        progressTask.addTag(2, Long.valueOf(j));
        updateService.updateStatusInfoAndProgress(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit downloadGameData$lambda$6(UpdateService updateService, ArrayList arrayList, DownloadTask task, EndCause p1, Exception exc, Listener1Assist.Listener1Model p3) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p3, "p3");
        updateService.mainHandler.removeCallbacks(updateService.checkTimeoutRunnable);
        Log.v(TAG, "End download " + task + " " + p1 + " " + exc + " " + p3);
        if (p1 != EndCause.COMPLETED && p1 != EndCause.SAME_TASK_BUSY) {
            Log.w(TAG, "Status operation after error " + updateService.mLastOperationStatus);
            if (updateService.mLastOperationStatus == Errno.ConnectionRefused) {
                Log.v(TAG, "Repeat already requested");
                return Unit.INSTANCE;
            }
            Log.v(TAG, "Request repeat download");
            FileServers.INSTANCE.currentServerIsUnreachable();
            updateService.mLastOperationStatus = Errno.ConnectionRefused;
            DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
            Intrinsics.checkNotNullExpressionValue(downloadDispatcher, "downloadDispatcher(...)");
            synchronized (downloadDispatcher) {
                OkDownload.with().downloadDispatcher().cancelAll();
                Unit unit = Unit.INSTANCE;
            }
            Log.v(TAG, "Cancel all download");
            DownloadContext downloadContext = updateService.mDownloadContext;
            if (downloadContext != null) {
                downloadContext.stop();
            }
            Log.v(TAG, "Stop download context");
            arrayList.clear();
            updateService.resetGameStatus();
            updateService.updateStatusInfoAndProgress(true);
            updateService.setUpdateStatus(UpdateStatus.Undefined);
            Message obtain = Message.obtain(updateService.mInHandler, 2);
            obtain.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, false);
            obtain.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
            obtain.replyTo = updateService.mMessenger;
            Messenger messenger = updateService.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
            Log.w(TAG, "Send message download canceled " + obtain);
            updateService.stopForegroundService();
            return Unit.INSTANCE;
        }
        arrayList.remove(Integer.valueOf(task.getId()));
        if (!arrayList.isEmpty()) {
            return Unit.INSTANCE;
        }
        Log.v(TAG, "taskIdList empty");
        updateService.updateStatusInfoAndProgress(true);
        updateService.removeDownloadTaskIdList();
        if (!updateService.isAllFilesOk(false, false, true)) {
            updateService.resetGameStatus();
            updateService.updateStatusInfoAndProgress(true);
            updateService.setUpdateStatus(UpdateStatus.Undefined);
            updateService.mLastOperationStatus = Errno.CorruptedFilesFound;
            Message obtain2 = Message.obtain(updateService.mInHandler, 2);
            obtain2.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, false);
            obtain2.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
            obtain2.replyTo = updateService.mMessenger;
            Messenger messenger2 = updateService.mActivityMessenger;
            if (messenger2 != null) {
                messenger2.send(obtain2);
            }
            Log.w(TAG, "Send message file broken " + obtain2);
            return Unit.INSTANCE;
        }
        updateService.mUpdateFiles.clear();
        updateService.mUpdateFilesNeedSize = 0L;
        updateService.resetGameStatus();
        updateService.setUpdateStatus(UpdateStatus.Undefined);
        Message obtain3 = Message.obtain(updateService.mInHandler, 2);
        obtain3.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, true);
        obtain3.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
        obtain3.replyTo = updateService.mMessenger;
        Messenger messenger3 = updateService.mActivityMessenger;
        if (messenger3 != null) {
            messenger3.send(obtain3);
        }
        Log.i(TAG, "Send message download done " + obtain3);
        DownloadContext downloadContext2 = updateService.mDownloadContext;
        if (downloadContext2 != null) {
            downloadContext2.stop();
        }
        updateService.stopForegroundService();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAllFilesOk(boolean z, boolean z2, boolean z3) {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new UpdateService$isAllFilesOk$1(this, z, z2, z3, null), 1, null);
        return ((Boolean) runBlocking$default).booleanValue();
    }

    private final ArrayList<Integer> notFinishedTaskIdList() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<String> stringSet = sharedPreferences.getStringSet(TASK_ID_LIST_KEY, new LinkedHashSet());
        if (stringSet != null) {
            for (String str : stringSet) {
                Intrinsics.checkNotNull(str);
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    private final void saveDownloadTaskIdList(ArrayList<Integer> arrayList) {
        Log.i(TAG, "saveDownloadTaskIdList");
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Log.i(TAG, "Save list " + arrayList.size());
        Iterator<Integer> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Integer next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            linkedHashSet.add(String.valueOf(next.intValue()));
        }
        if (edit != null) {
            edit.remove(TASK_ID_LIST_KEY);
        }
        if (edit != null) {
            edit.putStringSet(TASK_ID_LIST_KEY, linkedHashSet);
        }
        if (edit != null) {
            edit.apply();
        }
    }

    private final void removeDownloadTaskIdList() {
        Log.i(TAG, "removeDownloadTaskIdList");
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        SharedPreferences.Editor edit = sharedPreferences != null ? sharedPreferences.edit() : null;
        if (edit != null) {
            edit.remove(TASK_ID_LIST_KEY);
        }
        if (edit != null) {
            edit.apply();
        }
    }

    private final void updateStatusInfoAndProgress(boolean z) {
        NotificationManagerCompat from = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT >= 26 && ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
            from.notify(1, createNotification(z));
        }
        Message obtain = Message.obtain(this.mInHandler, 4);
        obtain.getData().putString(NotificationCompat.CATEGORY_STATUS, "DownloadGameData");
        obtain.getData().putBoolean("withProgress", !z);
        long j = 1024;
        obtain.getData().putInt("current", ((int) (this.mDownloadedLength / j)) + 1);
        obtain.getData().putInt("total", (int) (this.mTotalLength / j));
        obtain.getData().putLong("total_all", this.mTotalLength - this.mDownloadedLength);
        obtain.getData().putLong("current_len", this.mDownloadedLength);
        obtain.getData().putString("timeLeft", timeLeft());
        Bundle data = obtain.getData();
        SpeedCalculator speedCalculator = this.mSpeedCalculator;
        Intrinsics.checkNotNull(speedCalculator);
        data.putString("speed", speedCalculator.speed());
        obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    private final void calcSpeed(DownloadTask downloadTask, long j) {
        Object tag = downloadTask.getTag(2);
        long longValue = j - (tag == null ? 0L : ((Long) tag).longValue());
        SpeedCalculator speedCalculator = this.mSpeedCalculator;
        if (speedCalculator != null) {
            speedCalculator.downloading(longValue);
        }
        this.mDownloadedLength += longValue;
    }

    private final String timeLeft() {
        SpeedCalculator speedCalculator;
        double d;
        String str;
        SpeedCalculator speedCalculator2 = this.mSpeedCalculator;
        if (speedCalculator2 == null) {
            return "Расчет времени...";
        }
        Intrinsics.checkNotNull(speedCalculator2);
        if (speedCalculator2.getBytesPerSecondAndFlush() <= 0.1d) {
            return "0 sec";
        }
        Intrinsics.checkNotNull(this.mSpeedCalculator);
        double d2 = 1000;
        double bytesPerSecondAndFlush = ((this.mTotalLength - this.mDownloadedLength) / (speedCalculator.getBytesPerSecondAndFlush() + 1.0E-5d)) * d2;
        double d3 = 60;
        double d4 = (bytesPerSecondAndFlush / d2) % d3;
        double d5 = (bytesPerSecondAndFlush / 60000) % d3;
        String str2 = (bytesPerSecondAndFlush / ((double) Constants.ONE_HOUR)) % 24 >= 1.0d ? ((int) d) + " h, " : "";
        String str3 = d5 >= 1.0d ? ((int) d5) + " min, " : "";
        if (d4 < 1.0d) {
            str = "";
        } else {
            str = ((int) d4) + " sec";
        }
        String str4 = str2 + str3 + str;
        return Intrinsics.areEqual(str4, "") ? "0 sec" : str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpdateStatus(UpdateStatus updateStatus) {
        Log.i(TAG, "setUpdateStatus");
        if (this.mUpdateStatus.get() == updateStatus) {
            return;
        }
        this.mUpdateStatus.set(updateStatus);
        Message obtain = Message.obtain(this.mInHandler, 4);
        obtain.getData().putString(NotificationCompat.CATEGORY_STATUS, this.mUpdateStatus.get().name());
        obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkGameDataUpdate(JSONArray jSONArray, Continuation<? super Pair<? extends List<String>, Long>> continuation) {
        UpdateService$checkGameDataUpdate$1 updateService$checkGameDataUpdate$1;
        int i;
        List list;
        if (continuation instanceof UpdateService$checkGameDataUpdate$1) {
            updateService$checkGameDataUpdate$1 = (UpdateService$checkGameDataUpdate$1) continuation;
            if ((updateService$checkGameDataUpdate$1.label & Integer.MIN_VALUE) != 0) {
                updateService$checkGameDataUpdate$1.label -= Integer.MIN_VALUE;
                Object obj = updateService$checkGameDataUpdate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateService$checkGameDataUpdate$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Log.i(TAG, "checkGameDataUpdate");
                    updateService$checkGameDataUpdate$1.label = 1;
                    obj = getFilesToDownload(jSONArray, "", "", updateService$checkGameDataUpdate$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                long j = 0;
                Pair pair = new Pair(new ArrayList(), Boxing.boxLong(0L));
                for (Pair pair2 : (List) obj) {
                    if (!excludeFromCheck.contains(CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) pair2.getFirst(), new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null)))) {
                        ((List) pair.getFirst()).add(pair2.getFirst());
                        j += ((Number) pair2.getSecond()).longValue();
                    }
                }
                Pair copy$default = Pair.copy$default(pair, null, Boxing.boxLong(j), 1, null);
                Log.d(TAG, "need download data (" + list.size() + ")) sum " + j);
                return copy$default;
            }
        }
        updateService$checkGameDataUpdate$1 = new UpdateService$checkGameDataUpdate$1(this, continuation);
        Object obj2 = updateService$checkGameDataUpdate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$checkGameDataUpdate$1.label;
        if (i != 0) {
        }
        long j2 = 0;
        Pair pair3 = new Pair(new ArrayList(), Boxing.boxLong(0L));
        while (r3.hasNext()) {
        }
        Pair copy$default2 = Pair.copy$default(pair3, null, Boxing.boxLong(j2), 1, null);
        Log.d(TAG, "need download data (" + list.size() + ")) sum " + j2);
        return copy$default2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFilesToDownload(JSONArray jSONArray, String str, String str2, Continuation<? super List<Pair<String, Long>>> continuation) {
        UpdateService$getFilesToDownload$1 updateService$getFilesToDownload$1;
        int i;
        if (continuation instanceof UpdateService$getFilesToDownload$1) {
            updateService$getFilesToDownload$1 = (UpdateService$getFilesToDownload$1) continuation;
            if ((updateService$getFilesToDownload$1.label & Integer.MIN_VALUE) != 0) {
                updateService$getFilesToDownload$1.label -= Integer.MIN_VALUE;
                Object obj = updateService$getFilesToDownload$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateService$getFilesToDownload$1.label;
                if (i == 0) {
                    if (i == 1) {
                        List list = (List) updateService$getFilesToDownload$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                updateService$getFilesToDownload$1.L$0 = arrayList;
                updateService$getFilesToDownload$1.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), new UpdateService$getFilesToDownload$2(jSONArray, this, str, str2, arrayList, null), updateService$getFilesToDownload$1) == coroutine_suspended ? coroutine_suspended : arrayList;
            }
        }
        updateService$getFilesToDownload$1 = new UpdateService$getFilesToDownload$1(this, continuation);
        Object obj2 = updateService$getFilesToDownload$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateService$getFilesToDownload$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005a, code lost:
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, String> getAllDamagedFiles(JSONArray jSONArray, String str, String str2, boolean z, boolean z2, boolean z3) {
        File externalFilesDir;
        ArrayList arrayList;
        File externalFilesDir2;
        File[] listFiles = new File((getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + str2 + RemoteSettings.FORWARD_SLASH_STRING + str).listFiles();
        if (listFiles != null) {
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                arrayList2.add(file.getName());
            }
            arrayList = CollectionsKt.toMutableList((Collection) arrayList2);
        }
        arrayList = new ArrayList();
        List list = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (Intrinsics.areEqual(jSONObject.getString("type"), "dir")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("data");
                String string = jSONObject.getString("name");
                Intrinsics.checkNotNull(jSONArray2);
                linkedHashMap.putAll(getAllDamagedFiles(jSONArray2, str + RemoteSettings.FORWARD_SLASH_STRING + string, str2, z, z2, z3));
                list.remove(string);
            } else {
                if (Intrinsics.areEqual(jSONObject.getString("type"), "file")) {
                    String string2 = jSONObject.getString("name");
                    File file2 = new File((getExternalFilesDir(null) != null ? externalFilesDir2.getPath() : null) + str2 + str + RemoteSettings.FORWARD_SLASH_STRING + string2);
                    String string3 = jSONObject.getString("hash");
                    list.remove(string2);
                    if (!excludeFromCheck.contains(file2.getName())) {
                        Intrinsics.checkNotNull(jSONObject);
                        if (!checkSingleFile(file2, jSONObject, z, z3)) {
                            linkedHashMap.put(str2 + str + RemoteSettings.FORWARD_SLASH_STRING + string2, string3);
                        }
                    }
                } else if (Intrinsics.areEqual(jSONObject.getString("type"), "res") && z2) {
                    linkedHashMap.put(str2 + str + RemoteSettings.FORWARD_SLASH_STRING + jSONObject.getString("name"), jSONObject.getString("hash"));
                }
            }
        }
        if (z2) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashMap.put(str2 + str + RemoteSettings.FORWARD_SLASH_STRING + ((String) it.next()), "");
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkSingleFile(File file, JSONObject jSONObject, boolean z, boolean z2) {
        long length = file.getAbsoluteFile().length();
        String name = file.getName();
        long j = jSONObject.getLong("size");
        String string = jSONObject.getString("hash");
        long j2 = jSONObject.getLong("date_change") * 1000;
        if (z2) {
            SharedPreferences sharedPreferences = this.updatePreferences;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                sharedPreferences = null;
            }
            sharedPreferences.edit().putLong(file.getAbsolutePath(), j2).apply();
        }
        if (j == 0) {
            try {
                Log.d(TAG, "checkSingleFile: created new empty file " + name);
                file.createNewFile();
                SharedPreferences sharedPreferences2 = this.updatePreferences;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                    sharedPreferences2 = null;
                }
                sharedPreferences2.edit().putLong(file.getAbsolutePath(), j2).apply();
            } catch (IOException unused) {
                Log.d(TAG, "checkSingleFile: cannot create " + file);
            }
            return true;
        }
        SharedPreferences sharedPreferences3 = this.updatePreferences;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
            sharedPreferences3 = null;
        }
        long j3 = sharedPreferences3.getLong(file.getAbsolutePath(), 0L);
        boolean z3 = j3 != j2;
        if (!file.exists() || length != j) {
            Log.v(TAG, name + " exists: " + file.exists() + ", device size: " + length + ", expected size " + j);
            return false;
        }
        if (z3) {
            Log.v(TAG, name + " date mismatch, current: " + j3 + ", expected: " + j2 + " ");
        }
        if (!z && !z3) {
            Log.v(TAG, name + " - good");
            return true;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Intrinsics.checkNotNull(messageDigest);
        String fileChecksum = getFileChecksum(messageDigest, file);
        Log.v(TAG, "Hash of: " + file + " is: " + fileChecksum + ", expected: " + string);
        boolean areEqual = Intrinsics.areEqual(fileChecksum, string);
        if (areEqual && z3) {
            SharedPreferences sharedPreferences4 = this.updatePreferences;
            if (sharedPreferences4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                sharedPreferences4 = null;
            }
            sharedPreferences4.edit().putLong(file.getAbsolutePath(), j2).apply();
            Log.d(TAG, "Force date update after hash check, new file date: " + j3 + "}");
        }
        if (areEqual) {
            Log.v(TAG, name + " - good, after hash check");
            return areEqual;
        }
        Log.v(TAG, name + " - bad, after hash check");
        return areEqual;
    }

    private final String getFileChecksum(MessageDigest messageDigest, File file) throws IOException {
        try {
            InputStream openInputStream = getContentResolver().openInputStream(Uri.fromFile(file));
            if (openInputStream != null) {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        openInputStream.close();
                        byte[] digest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                        return toHex(digest);
                    }
                }
            } else {
                return "";
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            return "";
        }
    }

    private final String toHex(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence hex$lambda$13;
                hex$lambda$13 = UpdateService.toHex$lambda$13(((Byte) obj).byteValue());
                return hex$lambda$13;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$13(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkLauncherUpdate(String str) {
        RequestQueue newRequestQueue = Volley.newRequestQueue(this);
        Intrinsics.checkNotNullExpressionValue(newRequestQueue, "newRequestQueue(...)");
        String str2 = str + "app_version.json";
        this.mLastOperationStatus = Errno.NoError;
        if (str2.length() == 0) {
            FileServers.INSTANCE.currentServerIsUnreachable();
            this.mLastOperationStatus = Errno.UpdateServerUnreachable;
            Message obtain = Message.obtain(this.mInHandler, 3);
            obtain.getData().putBoolean(NEED_UPDATE_MSG, false);
            obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Messenger messenger = this.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
                return;
            }
            return;
        }
        this.mLastOperationStatus = Errno.NoError;
        StringRequest stringRequest = new StringRequest(0, str2, new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkLauncherUpdate$lambda$14(UpdateService.this, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda6
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.this.notifyServerUnreachable();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        newRequestQueue.add(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLauncherUpdate$lambda$14(UpdateService updateService, String str) {
        try {
            boolean z = new JSONObject(str).getInt("launcherVersion") > 1637;
            Message obtain = Message.obtain(updateService.mInHandler, 3);
            obtain.getData().putBoolean(NEED_UPDATE_MSG, z);
            obtain.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
            obtain.replyTo = updateService.mMessenger;
            Messenger messenger = updateService.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
        } catch (JSONException unused) {
            updateService.notifyServerUnreachable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyServerUnreachable() {
        FileServers.INSTANCE.currentServerIsUnreachable();
        this.mLastOperationStatus = Errno.UpdateServerUnreachable;
        Message obtain = Message.obtain(this.mInHandler, 3);
        obtain.getData().putBoolean(NEED_UPDATE_MSG, false);
        obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDownloadNewLauncherApk(String str) {
        File externalFilesDir;
        this.retry++;
        Log.i(TAG, "startDownloadLauncherUpdate");
        String str2 = "app-arizona-release_web-" + this.retry + ".apk";
        Log.d(TAG, "We're waiting " + str2 + " / app-arizona-release_web.apk file");
        final File file = new File((getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + RemoteSettings.FORWARD_SLASH_STRING + str2);
        if (file.exists()) {
            file.delete();
        }
        this.mLastOperationStatus = Errno.NoError;
        if (str.length() == 0) {
            this.mLastOperationStatus = Errno.UpdateServerUnreachable;
            Message obtain = Message.obtain(this.mInHandler, 6);
            obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Messenger messenger = this.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
                return;
            }
            return;
        }
        startForegroundService();
        DownloadContext.Builder commit = new DownloadContext.QueueSet().setMinIntervalMillisCallbackProcess(100).commit();
        this.mDownloadedLength = 0L;
        this.mTotalLength = 0L;
        this.lastDownloadedBytes = 0L;
        commit.bindSetTask(new DownloadTask.Builder(str + "launcher_new/app-arizona-release_web.apk", file).setPriority(5).setMinIntervalMillisCallbackProcess(300).setConnectionCount(1).setPreAllocateLength(true).build());
        this.mDownloadContext = commit.build();
        this.mSpeedCalculator = new SpeedCalculator();
        this.mLastOperationStatus = Errno.NoError;
        long j = this.mUpdateFilesNeedSize;
        this.mTotalLength = j;
        Log.v(TAG, "Get contentLength " + j);
        DownloadContext downloadContext = this.mDownloadContext;
        if (downloadContext != null) {
            downloadContext.start(DownloadListener1ExtensionKt.createListener1$default(null, null, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit startDownloadNewLauncherApk$lambda$16;
                    startDownloadNewLauncherApk$lambda$16 = UpdateService.startDownloadNewLauncherApk$lambda$16((DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                    return startDownloadNewLauncherApk$lambda$16;
                }
            }, new Function3() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit startDownloadNewLauncherApk$lambda$17;
                    startDownloadNewLauncherApk$lambda$17 = UpdateService.startDownloadNewLauncherApk$lambda$17(UpdateService.this, (DownloadTask) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                    return startDownloadNewLauncherApk$lambda$17;
                }
            }, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit startDownloadNewLauncherApk$lambda$19;
                    startDownloadNewLauncherApk$lambda$19 = UpdateService.startDownloadNewLauncherApk$lambda$19(UpdateService.this, file, r3, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                    return startDownloadNewLauncherApk$lambda$19;
                }
            }, 3, null), false);
        }
        this.mainHandler.postDelayed(this.checkTimeoutRunnable, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDownloadNewLauncherApk$lambda$16(DownloadTask connectTask, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(connectTask, "connectTask");
        Log.v(TAG, "Downloading " + connectTask);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDownloadNewLauncherApk$lambda$17(UpdateService updateService, DownloadTask progressTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressTask, "progressTask");
        updateService.mTotalLength = j2;
        updateService.calcSpeed(progressTask, j);
        progressTask.addTag(2, Long.valueOf(j));
        updateService.updateStatusInfoAndProgress(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDownloadNewLauncherApk$lambda$19(final UpdateService updateService, File file, String str, DownloadTask errorTask, EndCause errorCode, Exception exc, Listener1Assist.Listener1Model exception) {
        Intrinsics.checkNotNullParameter(errorTask, "errorTask");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Log.e(TAG, "Download error in task: " + errorTask + ", errorCode: " + errorCode + ", errorMessage: " + exc + " - " + exception);
        updateService.mainHandler.removeCallbacks(updateService.checkTimeoutRunnable);
        if (errorCode == EndCause.ERROR || errorCode == EndCause.CANCELED) {
            updateService.mLastOperationStatus = Errno.UpdateServerUnreachable;
            FileServers.INSTANCE.currentServerIsUnreachable();
            if (file.exists()) {
                file.delete();
            }
        } else {
            File file2 = new File(file.getParent(), str);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UpdateService.startDownloadNewLauncherApk$lambda$19$lambda$18(UpdateService.this);
            }
        }, 1250L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDownloadNewLauncherApk$lambda$19$lambda$18(UpdateService updateService) {
        Message obtain = Message.obtain(updateService.mInHandler, 6);
        obtain.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
        obtain.replyTo = updateService.mMessenger;
        Messenger messenger = updateService.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
        updateService.stopForegroundService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/UpdateService$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateService;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/arizona/launcher/UpdateService;Landroid/os/Looper;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class IncomingHandler extends Handler {
        private final WeakReference<UpdateService> activityRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomingHandler(UpdateService ref, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(ref, "ref");
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.activityRef = new WeakReference<>(ref);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            final UpdateService updateService = this.activityRef.get();
            if (updateService != null) {
                updateService.mActivityMessenger = msg.replyTo;
                Log.i("UpdateService", String.valueOf(msg.what));
                int i = msg.what;
                if (i == 0) {
                    updateService.checkUpdate(FileServers.INSTANCE.getCurrentServer());
                    return;
                }
                switch (i) {
                    case 2:
                        updateService.updateGameData();
                        return;
                    case 3:
                        updateService.checkLauncherUpdate(FileServers.INSTANCE.getCurrentServer());
                        return;
                    case 4:
                        Message obtain = Message.obtain(updateService.mInHandler, 4);
                        obtain.getData().putString(NotificationCompat.CATEGORY_STATUS, ((UpdateStatus) updateService.mUpdateStatus.get()).name());
                        obtain.getData().putSerializable(UpdateService.ERRNO_MSG, updateService.mLastOperationStatus);
                        obtain.replyTo = updateService.mMessenger;
                        Messenger messenger = updateService.mActivityMessenger;
                        if (messenger != null) {
                            messenger.send(obtain);
                            return;
                        }
                        return;
                    case 5:
                        updateService.resetGameStatus();
                        Message obtain2 = Message.obtain(updateService.mInHandler, 5);
                        obtain2.getData().putString(NotificationCompat.CATEGORY_STATUS, ((GameStatus) updateService.mGameStatus.get()).name());
                        obtain2.getData().putSerializable(UpdateService.ERRNO_MSG, updateService.mLastOperationStatus);
                        obtain2.replyTo = updateService.mMessenger;
                        Messenger messenger2 = updateService.mActivityMessenger;
                        if (messenger2 != null) {
                            messenger2.send(obtain2);
                            return;
                        }
                        return;
                    case 6:
                        updateService.startDownloadNewLauncherApk(FileServers.INSTANCE.getCurrentServer());
                        return;
                    case 7:
                        Message obtain3 = Message.obtain(updateService.mInHandler, 7);
                        obtain3.getData().putLong("needFreeSpaceSize", updateService.mUpdateFilesNeedSize);
                        obtain3.replyTo = updateService.mMessenger;
                        Messenger messenger3 = updateService.mActivityMessenger;
                        if (messenger3 != null) {
                            messenger3.send(obtain3);
                            return;
                        }
                        return;
                    case 8:
                        Message obtain4 = Message.obtain(updateService.mInHandler, 8);
                        SharedPreferences sharedPreferences = updateService.updatePreferences;
                        if (sharedPreferences == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                            sharedPreferences = null;
                        }
                        sharedPreferences.edit().clear().apply();
                        obtain4.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, updateService.isAllFilesOk(true, true, false));
                        BuildersKt__BuildersKt.runBlocking$default(null, new UpdateService$IncomingHandler$handleMessage$2(updateService, null), 1, null);
                        obtain4.replyTo = updateService.mMessenger;
                        Messenger messenger4 = updateService.mActivityMessenger;
                        if (messenger4 != null) {
                            messenger4.send(obtain4);
                            return;
                        }
                        return;
                    case 9:
                        Message obtain5 = Message.obtain(updateService.mInHandler, 8);
                        SharedPreferences sharedPreferences2 = updateService.updatePreferences;
                        if (sharedPreferences2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                            sharedPreferences2 = null;
                        }
                        sharedPreferences2.edit().clear().apply();
                        obtain5.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, updateService.isAllFilesOk(true, true, false));
                        BuildersKt__BuildersKt.runBlocking$default(null, new UpdateService$IncomingHandler$handleMessage$3(updateService, null), 1, null);
                        obtain5.replyTo = updateService.mMessenger;
                        Messenger messenger5 = updateService.mActivityMessenger;
                        if (messenger5 != null) {
                            messenger5.send(obtain5);
                            return;
                        }
                        return;
                    case 10:
                        updateService.checkUpdateAndDownload(FileServers.INSTANCE.getCurrentServer(), new Function0() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit handleMessage$lambda$0;
                                handleMessage$lambda$0 = UpdateService.IncomingHandler.handleMessage$lambda$0(UpdateService.this);
                                return handleMessage$lambda$0;
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
            Log.d("UpdateService", "activity is null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$0(UpdateService updateService) {
            updateService.updateGameData();
            return Unit.INSTANCE;
        }
    }

    public final void checkUpdateAndDownload(String server, final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
        Intrinsics.checkNotNullExpressionValue(downloadDispatcher, "downloadDispatcher(...)");
        synchronized (downloadDispatcher) {
            OkDownload.with().downloadDispatcher().cancelAll();
            Unit unit = Unit.INSTANCE;
        }
        Log.d(TAG, "checkUpdate");
        startForegroundService();
        setUpdateStatus(UpdateStatus.CheckUpdate);
        RequestQueue newRequestQueue = Volley.newRequestQueue(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(newRequestQueue, "newRequestQueue(...)");
        this.mLastOperationStatus = Errno.NoError;
        if (server.length() == 0) {
            this.mLastOperationStatus = Errno.UpdateServerUnreachable;
            Message obtain = Message.obtain(this.mInHandler, 0);
            obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain.replyTo = this.mMessenger;
            Messenger messenger = this.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
            Log.w(TAG, "Send message server unreachable " + obtain);
            stopForegroundService();
            return;
        }
        Log.i(TAG, "checkUpdate: requesting server for update json");
        StringRequest stringRequest = new StringRequest(0, server + UpdateJsonProvider.INSTANCE.getJsonName(this), new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda13
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkUpdateAndDownload$lambda$22(UpdateService.this, onFinish, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda14
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.checkUpdateAndDownload$lambda$24(UpdateService.this, volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        newRequestQueue.add(stringRequest);
        Log.v(TAG, "Add to queue " + stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUpdateAndDownload$lambda$22(UpdateService updateService, Function0 function0, final String str) {
        final JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = (JSONArray) new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                JSONArray checkUpdateAndDownload$lambda$22$lambda$21;
                checkUpdateAndDownload$lambda$22$lambda$21 = UpdateService.checkUpdateAndDownload$lambda$22$lambda$21(jSONObject, str, (String) obj);
                return checkUpdateAndDownload$lambda$22$lambda$21;
            }
        }.invoke("files");
        updateService.mDataInfo = jSONArray;
        Log.v(TAG, "mDataInfo " + jSONArray);
        updateService.mUpdateFiles = new ArrayList();
        updateService.mUpdateFilesNeedSize = 0L;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UpdateService$checkUpdateAndDownload$stringRequest$1$1(updateService, function0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray checkUpdateAndDownload$lambda$22$lambda$21(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("data");
        int length = jSONArray.length();
        if (length >= 0) {
            int i = 0;
            while (!Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("name"), str2)) {
                if (i != length) {
                    i++;
                }
            }
            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
            return jSONArray2;
        }
        throw new Exception("JSON Corrupted " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUpdateAndDownload$lambda$24(final UpdateService updateService, VolleyError volleyError) {
        FileServers.INSTANCE.currentServerIsUnreachable();
        updateService.checkUpdateAndDownload(FileServers.INSTANCE.getCurrentServer(), new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit checkUpdateAndDownload$lambda$24$lambda$23;
                checkUpdateAndDownload$lambda$24$lambda$23 = UpdateService.checkUpdateAndDownload$lambda$24$lambda$23(UpdateService.this);
                return checkUpdateAndDownload$lambda$24$lambda$23;
            }
        });
        updateService.stopForegroundService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUpdateAndDownload$lambda$24$lambda$23(UpdateService updateService) {
        updateService.updateGameData();
        return Unit.INSTANCE;
    }
}
