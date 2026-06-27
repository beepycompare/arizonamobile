package com.arizona.launcher;

import android.app.ActivityManager;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import coil3.util.UtilsKt;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arizona.game.R;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.downloader.FilesChek;
import com.arizona.launcher.util.FileServers;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.liulishuo.okdownload.DownloadContext;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.LauncherBreakpointStoreOnSQLite;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.connection.DownloadOkHttp3Connection;
import com.liulishuo.okdownload.core.dispatcher.DownloadDispatcher;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.liulishuo.okdownload.kotlin.listener.DownloadListener1ExtensionKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001+\b\u0007\u0018\u0000 u2\u00020\u0001:\u0007uvwxyz{B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020.H\u0002J\"\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u000206H\u0016J\b\u0010;\u001a\u00020.H\u0002J\b\u0010<\u001a\u000203H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u00020.H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010D\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010E\u001a\u00020.2\u0006\u00107\u001a\u000208H\u0016J\b\u0010F\u001a\u00020.H\u0016J\u0012\u0010G\u001a\u00020.2\b\u0010H\u001a\u0004\u0018\u000108H\u0016J\u000e\u0010I\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0012J\b\u0010K\u001a\u000203H\u0002J\b\u0010L\u001a\u00020.H\u0002J\u0006\u0010M\u001a\u00020.JF\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020P0O2\u0006\u0010Q\u001a\u00020\u001e2\b\b\u0002\u0010R\u001a\u00020\u00122\b\b\u0002\u0010S\u001a\u00020\u00122\u0014\b\u0002\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020P0OH\u0002J\u0014\u0010U\u001a\u0004\u0018\u00010\u00122\b\u0010V\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010W\u001a\u0002032\b\u0010X\u001a\u0004\u0018\u00010\u00122\b\u0010Y\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010Z\u001a\u00020.H\u0002J\u0018\u0010[\u001a\u0012\u0012\u0004\u0012\u0002060\\j\b\u0012\u0004\u0012\u000206`]H\u0002J \u0010^\u001a\u00020.2\u0016\u0010_\u001a\u0012\u0012\u0004\u0012\u0002060\\j\b\u0012\u0004\u0012\u000206`]H\u0002J\b\u0010`\u001a\u00020.H\u0002J\u0010\u0010a\u001a\u00020.2\u0006\u0010@\u001a\u000203H\u0002J\u0018\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u0014H\u0002J\b\u0010f\u001a\u00020\u0012H\u0002J\u0010\u0010g\u001a\u00020.2\u0006\u0010h\u001a\u00020\bH\u0002J\u0010\u0010i\u001a\u0002032\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0012H\u0002J\u0010\u0010m\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010o\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0012H\u0002J&\u0010p\u001a\u00020.2\u0006\u0010J\u001a\u00020\u00122\b\b\u0002\u0010q\u001a\u0002062\f\u0010r\u001a\b\u0012\u0004\u0012\u00020.0sJ\u0010\u0010t\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010n\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\u0002\b}Ê\u0001\f\b~\u0012\b\b\u007f\u0012\u0004\b\u0003\u0010\u0000¨\u0006|"}, d2 = {"Lcom/arizona/launcher/UpdateService;", "Landroid/app/Service;", "<init>", "()V", "updatePreferences", "Landroid/content/SharedPreferences;", "mUpdateStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/arizona/launcher/UpdateService$UpdateStatus;", "mGameStatus", "Lcom/arizona/launcher/UpdateService$GameStatus;", "mMessenger", "Landroid/os/Messenger;", "mActivityMessenger", "mInHandler", "Lcom/arizona/launcher/UpdateService$IncomingHandler;", "mUpdateFiles", "", "", "mUpdateFilesNeedSize", "", "mDownloadContext", "Lcom/liulishuo/okdownload/DownloadContext;", "mTotalLength", "mDownloadedLength", "mSpeedCalculator", "Lcom/liulishuo/okdownload/SpeedCalculator;", "mLastOperationStatus", "Lcom/arizona/launcher/UpdateService$Errno;", "mDataInfo", "Lorg/json/JSONArray;", "mainHandler", "Landroid/os/Handler;", "lastDownloadedBytes", "sharedRequestQueue", "Lcom/android/volley/RequestQueue;", "getSharedRequestQueue", "()Lcom/android/volley/RequestQueue;", "sharedRequestQueue$delegate", "Lkotlin/Lazy;", "filesChek", "Lcom/arizona/launcher/downloader/FilesChek;", "checkTimeoutRunnable", "com/arizona/launcher/UpdateService$checkTimeoutRunnable$1", "Lcom/arizona/launcher/UpdateService$checkTimeoutRunnable$1;", "onCreate", "", "logDownloadError", "error", "Lcom/arizona/launcher/UpdateService$DownloadErrorEvent;", "isFirstLauncherStartErrorSession", "", "createNotificationChannel", "onStartCommand", "", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", DownloaderServiceMarshaller.PARAMS_FLAGS, "startId", "startForegroundService", "isDeviceOnline", "isAppInForeground", "createNotification", "Landroid/app/Notification;", "indeterminate", "stopForegroundService", "onBind", "Landroid/os/IBinder;", "onUnbind", "onRebind", "onDestroy", "onTaskRemoved", "rootIntent", "checkUpdate", "server", "isGameDataUpdateExists", "resetGameStatus", "updateGameData", "buildExpectedFileInfo", "", "Lcom/arizona/launcher/UpdateService$ExpectedFile;", "sources", "dir", "destDir", "out", "hostOf", "url", "sameHost", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "downloadGameData", "notFinishedTaskIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "saveDownloadTaskIdList", "list", "removeDownloadTaskIdList", "updateStatusInfoAndProgress", "calcSpeed", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "currentOffset", "timeLeft", "setUpdateStatus", NotificationCompat.CATEGORY_STATUS, "deleteExistingDownloadTarget", "destFile", "Ljava/io/File;", "checkLauncherUpdate", "notifyServerUnreachable", "retry", "startDownloadNewLauncherApk", "checkUpdateAndDownload", "attemptsLeft", "onFinish", "Lkotlin/Function0;", "notifyCheckUpdateAndDownloadUnreachable", "Companion", "Errno", "DownloadErrorEvent", "UpdateStatus", "GameStatus", "ExpectedFile", "IncomingHandler", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    private static final String DOWNLOAD_ERROR_EVENT = "error_download";
    private static final String DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT = "error_download_first_launch";
    private static final String ERRNO_CODE_PARAM = "errno_code";
    public static final String ERRNO_MSG = "errno";
    private static final String ERRNO_NAME_PARAM = "errno_name";
    private static final String ERROR_CODE_PARAM = "error_code";
    private static final String ERROR_CONTEXT_PARAM = "error_context";
    private static final String ERROR_TYPE_PARAM = "error_type";
    private static final String EVENT_TAG_PARAM = "event_tag";
    private static final String FIRST_LAUNCH_EVENT_TAG = "first_launch";
    private static final String FIRST_LAUNCH_PARAM = "first_launch";
    private static final String FIRST_START_ERROR_SESSION_KEY = "firstStartErrorSession";
    private static final String FIRST_START_KEY = "firstStart";
    private static final int FOREGROUND_NOTIFICATION_ID = 1;
    public static final int FULL_CHECK = 8;
    public static final int GAME_STATUS = 5;
    private static final String LAUNCHER_PREFERENCE_FILE_KEY = "SP_NAME";
    private static final String LEGACY_CALL_SITE_PARAM = ".kt";
    public static final String NEED_UPDATE_MSG = "needUpdateMsg";
    private static final String PREFERENCE_FILE_KEY = "downloadPreference";
    private static final String SOURCE_LINE_PARAM = "source_line";
    private static final String TAG = "UPDATE_SERVICE";
    private static final String TASK_ID_LIST_KEY = "taskIdList";
    private static final long TIMEOUT_DOWNLOADER = 15000;
    public static final int UPDATE_GAME_DATA = 2;
    public static final int UPDATE_INFO = 7;
    public static final int UPDATE_LAUNCHER = 6;
    private static final String UPDATE_SERVICE_CHANNEL_ID = "UpdateServiceChannelID";
    public static final int UPDATE_STATUS = 4;
    private FilesChek filesChek;
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
    private AtomicReference<UpdateStatus> mUpdateStatus = new AtomicReference<>(UpdateStatus.Undefined);
    private AtomicReference<GameStatus> mGameStatus = new AtomicReference<>(GameStatus.Undefined);
    private List<String> mUpdateFiles = new ArrayList();
    private Errno mLastOperationStatus = Errno.NoError;
    private JSONArray mDataInfo = new JSONArray();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Lazy sharedRequestQueue$delegate = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            RequestQueue newRequestQueue;
            newRequestQueue = Volley.newRequestQueue(UpdateService.this.getApplicationContext());
            return newRequestQueue;
        }
    });
    private final UpdateService$checkTimeoutRunnable$1 checkTimeoutRunnable = new Runnable() { // from class: com.arizona.launcher.UpdateService$checkTimeoutRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            long j3;
            long j4;
            Handler handler;
            long j5;
            long j6;
            DownloadContext downloadContext;
            j = UpdateService.this.lastDownloadedBytes;
            j2 = UpdateService.this.lastDownloadedBytes;
            Log.d("checkTimeoutRunnable", j + " / " + j2);
            j3 = UpdateService.this.lastDownloadedBytes;
            if (j3 != 0) {
                j5 = UpdateService.this.mDownloadedLength;
                j6 = UpdateService.this.lastDownloadedBytes;
                if (j5 <= j6) {
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
            j4 = updateService.mDownloadedLength;
            updateService.lastDownloadedBytes = j4 + 1;
            handler = UpdateService.this.mainHandler;
            handler.postDelayed(this, 15000L);
        }
    };

    /* compiled from: UpdateService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndCause.values().length];
            try {
                iArr[EndCause.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EndCause.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/arizona/launcher/UpdateService$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_START_FOREGROUND_SERVICE", "ACTION_STOP_FOREGROUND_SERVICE", "CHECK_UPDATE", "", "UPDATE_GAME_DATA", "CHECK_LAUNCHER_UPDATE", "UPDATE_STATUS", "GAME_STATUS", "UPDATE_LAUNCHER", "UPDATE_INFO", "FULL_CHECK", "CHECK_STATE_ERROR", "CHECK_AND_UPDATE", "BYTE_TO_KILOBYTE_DIVIDER", "CURRENT_PROGRESS", "TIMEOUT_DOWNLOADER", "", "NEED_UPDATE_MSG", "ERRNO_MSG", "UPDATE_SERVICE_CHANNEL_ID", "FOREGROUND_NOTIFICATION_ID", "PREFERENCE_FILE_KEY", "TASK_ID_LIST_KEY", "LAUNCHER_PREFERENCE_FILE_KEY", "FIRST_START_KEY", "FIRST_START_ERROR_SESSION_KEY", "DOWNLOAD_ERROR_EVENT", "DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT", "LEGACY_CALL_SITE_PARAM", "SOURCE_LINE_PARAM", "ERROR_CODE_PARAM", "ERROR_TYPE_PARAM", "ERROR_CONTEXT_PARAM", "ERRNO_CODE_PARAM", "ERRNO_NAME_PARAM", "EVENT_TAG_PARAM", "FIRST_LAUNCH_PARAM", "FIRST_LAUNCH_EVENT_TAG", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/UpdateService$Errno;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "NoError", "UpdateServerUnreachable", "ConnectionRefused", "CorruptedFilesFound", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Errno {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Errno[] $VALUES;
        private final int code;
        private final String description;
        public static final Errno NoError = new Errno("NoError", 0, 0, "Ошибки нет");
        public static final Errno UpdateServerUnreachable = new Errno("UpdateServerUnreachable", 1, 1, "Сервер обновления недоступен или не найден");
        public static final Errno ConnectionRefused = new Errno("ConnectionRefused", 2, 2, "Соединение с сервером было прервано во время загрузки");
        public static final Errno CorruptedFilesFound = new Errno("CorruptedFilesFound", 3, 3, "Найдены поврежденные или неудаляемые игровые файлы");

        private static final /* synthetic */ Errno[] $values() {
            return new Errno[]{NoError, UpdateServerUnreachable, ConnectionRefused, CorruptedFilesFound};
        }

        public static EnumEntries<Errno> getEntries() {
            return $ENTRIES;
        }

        public static Errno valueOf(String str) {
            return (Errno) Enum.valueOf(Errno.class, str);
        }

        public static Errno[] values() {
            return (Errno[]) $VALUES.clone();
        }

        private Errno(String str, int i, int i2, String str2) {
            this.code = i2;
            this.description = str2;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        static {
            Errno[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/arizona/launcher/UpdateService$DownloadErrorEvent;", "", "code", "", UpdateService.ERRNO_MSG, "Lcom/arizona/launcher/UpdateService$Errno;", "legacyCallSite", "context", "", "<init>", "(Ljava/lang/String;IILcom/arizona/launcher/UpdateService$Errno;ILjava/lang/String;)V", "getCode", "()I", "getErrno", "()Lcom/arizona/launcher/UpdateService$Errno;", "getLegacyCallSite", "getContext", "()Ljava/lang/String;", "GAME_UPDATE_SERVER_EMPTY", "GAME_UPDATE_REQUEST_FAILED", "GAME_DATA_SERVER_EMPTY", "GAME_DATA_FILE_LIST_EMPTY", "GAME_DATA_DELETE_TARGET_FAILED", "GAME_DATA_DOWNLOAD_FAILED", "GAME_DATA_DOWNLOAD_CANCELED", "GAME_DATA_DOWNLOAD_NOT_COMPLETED", "GAME_DATA_VALIDATION_FAILED", "LAUNCHER_UPDATE_CHECK_SERVER_EMPTY", "LAUNCHER_UPDATE_CHECK_JSON_INVALID", "LAUNCHER_UPDATE_CHECK_REQUEST_FAILED", "LAUNCHER_APK_SERVER_EMPTY", "LAUNCHER_APK_DOWNLOAD_FAILED", "LAUNCHER_APK_DOWNLOAD_CANCELED", "CHECK_AND_DOWNLOAD_SERVER_EMPTY", "CHECK_AND_DOWNLOAD_REQUEST_FAILED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DownloadErrorEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DownloadErrorEvent[] $VALUES;
        private final int code;
        private final String context;
        private final Errno errno;
        private final int legacyCallSite;
        public static final DownloadErrorEvent GAME_UPDATE_SERVER_EMPTY = new DownloadErrorEvent("GAME_UPDATE_SERVER_EMPTY", 0, 1001, Errno.UpdateServerUnreachable, 337, "Не найден URL сервера для проверки игровых файлов");
        public static final DownloadErrorEvent GAME_UPDATE_REQUEST_FAILED = new DownloadErrorEvent("GAME_UPDATE_REQUEST_FAILED", 1, 1002, Errno.UpdateServerUnreachable, 404, "Запрос update json для игровых файлов завершился ошибкой");
        public static final DownloadErrorEvent GAME_DATA_SERVER_EMPTY = new DownloadErrorEvent("GAME_DATA_SERVER_EMPTY", 2, 1003, Errno.UpdateServerUnreachable, 478, "Не найден URL сервера перед скачиванием игровых файлов");
        public static final DownloadErrorEvent GAME_DATA_FILE_LIST_EMPTY = new DownloadErrorEvent("GAME_DATA_FILE_LIST_EMPTY", 3, 1004, Errno.ConnectionRefused, 495, "Запуск скачивания без списка файлов для обновления");
        public static final DownloadErrorEvent GAME_DATA_DELETE_TARGET_FAILED = new DownloadErrorEvent("GAME_DATA_DELETE_TARGET_FAILED", 4, 1005, Errno.CorruptedFilesFound, 536, "Не удалось удалить старый файл перед повторной загрузкой");
        public static final DownloadErrorEvent GAME_DATA_DOWNLOAD_FAILED = new DownloadErrorEvent("GAME_DATA_DOWNLOAD_FAILED", 5, 1006, Errno.ConnectionRefused, 592, "Скачивание игровых файлов завершилось ошибкой");
        public static final DownloadErrorEvent GAME_DATA_DOWNLOAD_CANCELED = new DownloadErrorEvent("GAME_DATA_DOWNLOAD_CANCELED", 6, 1007, Errno.ConnectionRefused, 592, "Скачивание игровых файлов было отменено");
        public static final DownloadErrorEvent GAME_DATA_DOWNLOAD_NOT_COMPLETED = new DownloadErrorEvent("GAME_DATA_DOWNLOAD_NOT_COMPLETED", 7, 1008, Errno.ConnectionRefused, 592, "Скачивание игровых файлов завершилось без успешного статуса");
        public static final DownloadErrorEvent GAME_DATA_VALIDATION_FAILED = new DownloadErrorEvent("GAME_DATA_VALIDATION_FAILED", 8, 1009, Errno.CorruptedFilesFound, 644, "После скачивания проверка файлов нашла повреждения");
        public static final DownloadErrorEvent LAUNCHER_UPDATE_CHECK_SERVER_EMPTY = new DownloadErrorEvent("LAUNCHER_UPDATE_CHECK_SERVER_EMPTY", 9, 1010, Errno.UpdateServerUnreachable, 807, "Не найден URL сервера для проверки обновления лаунчера");
        public static final DownloadErrorEvent LAUNCHER_UPDATE_CHECK_JSON_INVALID = new DownloadErrorEvent("LAUNCHER_UPDATE_CHECK_JSON_INVALID", 10, 1011, Errno.UpdateServerUnreachable, 868, "Ответ app_version json не удалось разобрать");
        public static final DownloadErrorEvent LAUNCHER_UPDATE_CHECK_REQUEST_FAILED = new DownloadErrorEvent("LAUNCHER_UPDATE_CHECK_REQUEST_FAILED", 11, 1012, Errno.UpdateServerUnreachable, 868, "Запрос app_version json завершился ошибкой");
        public static final DownloadErrorEvent LAUNCHER_APK_SERVER_EMPTY = new DownloadErrorEvent("LAUNCHER_APK_SERVER_EMPTY", 12, 1013, Errno.UpdateServerUnreachable, 900, "Не найден URL сервера перед скачиванием APK лаунчера");
        public static final DownloadErrorEvent LAUNCHER_APK_DOWNLOAD_FAILED = new DownloadErrorEvent("LAUNCHER_APK_DOWNLOAD_FAILED", 13, 1014, Errno.UpdateServerUnreachable, 960, "Скачивание APK лаунчера завершилось ошибкой");
        public static final DownloadErrorEvent LAUNCHER_APK_DOWNLOAD_CANCELED = new DownloadErrorEvent("LAUNCHER_APK_DOWNLOAD_CANCELED", 14, 1015, Errno.UpdateServerUnreachable, 960, "Скачивание APK лаунчера было отменено");
        public static final DownloadErrorEvent CHECK_AND_DOWNLOAD_SERVER_EMPTY = new DownloadErrorEvent("CHECK_AND_DOWNLOAD_SERVER_EMPTY", 15, 1016, Errno.UpdateServerUnreachable, 1110, "Не найден URL сервера в combined flow проверки и загрузки");
        public static final DownloadErrorEvent CHECK_AND_DOWNLOAD_REQUEST_FAILED = new DownloadErrorEvent("CHECK_AND_DOWNLOAD_REQUEST_FAILED", 16, 1017, Errno.UpdateServerUnreachable, 1238, "Combined flow не получил update json после доступных попыток");

        private static final /* synthetic */ DownloadErrorEvent[] $values() {
            return new DownloadErrorEvent[]{GAME_UPDATE_SERVER_EMPTY, GAME_UPDATE_REQUEST_FAILED, GAME_DATA_SERVER_EMPTY, GAME_DATA_FILE_LIST_EMPTY, GAME_DATA_DELETE_TARGET_FAILED, GAME_DATA_DOWNLOAD_FAILED, GAME_DATA_DOWNLOAD_CANCELED, GAME_DATA_DOWNLOAD_NOT_COMPLETED, GAME_DATA_VALIDATION_FAILED, LAUNCHER_UPDATE_CHECK_SERVER_EMPTY, LAUNCHER_UPDATE_CHECK_JSON_INVALID, LAUNCHER_UPDATE_CHECK_REQUEST_FAILED, LAUNCHER_APK_SERVER_EMPTY, LAUNCHER_APK_DOWNLOAD_FAILED, LAUNCHER_APK_DOWNLOAD_CANCELED, CHECK_AND_DOWNLOAD_SERVER_EMPTY, CHECK_AND_DOWNLOAD_REQUEST_FAILED};
        }

        public static EnumEntries<DownloadErrorEvent> getEntries() {
            return $ENTRIES;
        }

        public static DownloadErrorEvent valueOf(String str) {
            return (DownloadErrorEvent) Enum.valueOf(DownloadErrorEvent.class, str);
        }

        public static DownloadErrorEvent[] values() {
            return (DownloadErrorEvent[]) $VALUES.clone();
        }

        private DownloadErrorEvent(String str, int i, int i2, Errno errno, int i3, String str2) {
            this.code = i2;
            this.errno = errno;
            this.legacyCallSite = i3;
            this.context = str2;
        }

        public final int getCode() {
            return this.code;
        }

        public final Errno getErrno() {
            return this.errno;
        }

        public final int getLegacyCallSite() {
            return this.legacyCallSite;
        }

        public final String getContext() {
            return this.context;
        }

        static {
            DownloadErrorEvent[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/UpdateService$UpdateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "CheckUpdate", "CheckFiles", "DownloadGame", "DownloadGameData", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        public static UpdateStatus valueOf(String str) {
            return (UpdateStatus) Enum.valueOf(UpdateStatus.class, str);
        }

        public static UpdateStatus[] values() {
            return (UpdateStatus[]) $VALUES.clone();
        }

        private UpdateStatus(String str, int i) {
        }

        static {
            UpdateStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateService$GameStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "UnsupportedVersion", "UpdateRequired", "Updated", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        public static GameStatus valueOf(String str) {
            return (GameStatus) Enum.valueOf(GameStatus.class, str);
        }

        public static GameStatus[] values() {
            return (GameStatus[]) $VALUES.clone();
        }

        private GameStatus(String str, int i) {
        }

        static {
            GameStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    private final RequestQueue getSharedRequestQueue() {
        return (RequestQueue) this.sharedRequestQueue$delegate.getValue();
    }

    @Override // com.arizona.launcher.Hilt_UpdateService, android.app.Service
    public void onCreate() {
        UpdateService updateService = this;
        LauncherBreakpointStoreOnSQLite launcherBreakpointStoreOnSQLite = new LauncherBreakpointStoreOnSQLite(updateService);
        SharedPreferences sharedPreferences = getSharedPreferences("update_data", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.updatePreferences = sharedPreferences;
        try {
            OkDownload.setSingletonInstance(new OkDownload.Builder(getApplicationContext()).downloadStore(launcherBreakpointStoreOnSQLite).connectionFactory(new DownloadOkHttp3Connection.Factory().setBuilder(new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true).connectionPool(new ConnectionPool(5, 10L, TimeUnit.SECONDS)).build().newBuilder())).build());
            Log.d(TAG, "Init OkDownload instance with OkHttp backend");
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
        SharedPreferences sharedPreferences2 = this.updatePreferences;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
            sharedPreferences2 = null;
        }
        this.filesChek = new FilesChek(TAG, sharedPreferences2, updateService);
    }

    private final void logDownloadError(DownloadErrorEvent downloadErrorEvent) {
        Bundle bundle = new Bundle();
        bundle.putInt(LEGACY_CALL_SITE_PARAM, downloadErrorEvent.getLegacyCallSite());
        bundle.putInt(SOURCE_LINE_PARAM, downloadErrorEvent.getLegacyCallSite());
        bundle.putInt(ERRNO_MSG, downloadErrorEvent.getErrno().getCode());
        bundle.putInt(ERRNO_CODE_PARAM, downloadErrorEvent.getErrno().getCode());
        bundle.putString(ERRNO_NAME_PARAM, downloadErrorEvent.getErrno().name());
        bundle.putInt(ERROR_CODE_PARAM, downloadErrorEvent.getCode());
        bundle.putString(ERROR_TYPE_PARAM, downloadErrorEvent.name());
        bundle.putString(ERROR_CONTEXT_PARAM, downloadErrorEvent.getContext());
        UpdateService updateService = this;
        FirebaseAnalytics.getInstance(updateService).logEvent(DOWNLOAD_ERROR_EVENT, bundle);
        if (isFirstLauncherStartErrorSession()) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.putString(EVENT_TAG_PARAM, "first_launch");
            bundle2.putBoolean("first_launch", true);
            FirebaseAnalytics.getInstance(updateService).logEvent(DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT, bundle2);
        }
    }

    private final boolean isFirstLauncherStartErrorSession() {
        SharedPreferences sharedPreferences = getSharedPreferences("SP_NAME", 0);
        return sharedPreferences.getBoolean("firstStartErrorSession", false) || sharedPreferences.getBoolean("firstStart", true);
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
                if (isAppInForeground()) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        startForeground(1, createNotification, 1);
                    } else {
                        startForeground(1, createNotification);
                    }
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

    private final boolean isDeviceOnline() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    private final boolean isAppInForeground() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Intrinsics.areEqual(runningAppProcessInfo.processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    private final Notification createNotification(boolean z) {
        Intent intent;
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        Intent intent2 = null;
        if (launchIntentForPackage != null && (intent = launchIntentForPackage.setPackage(null)) != null) {
            intent2 = intent.setFlags(270532608);
        }
        UpdateService updateService = this;
        Notification build = new NotificationCompat.Builder(updateService, UPDATE_SERVICE_CHANNEL_ID).setContentTitle(getString(R.string.update)).setContentText("Осталось времени: " + timeLeft()).setSmallIcon(R.mipmap.ic_launcher_foreground).setContentIntent(PendingIntent.getActivity(updateService, 0, intent2, 67108864)).setProgress((int) (this.mTotalLength / 1024), (int) (this.mDownloadedLength / 1024), z).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopForegroundService() {
        Log.i(TAG, "stopForegroundService");
        stopForeground(true);
        stopForeground(1);
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
        RequestQueue sharedRequestQueue = getSharedRequestQueue();
        this.mLastOperationStatus = Errno.NoError;
        if (server.length() == 0) {
            logDownloadError(DownloadErrorEvent.GAME_UPDATE_SERVER_EMPTY);
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
        StringRequest stringRequest = new StringRequest(0, server + UpdateJsonProvider.INSTANCE.getJsonName(this), new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda15
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkUpdate$lambda$0(UpdateService.this, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda1
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.checkUpdate$lambda$1(UpdateService.this, volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        sharedRequestQueue.add(stringRequest);
        Log.v(TAG, "Add to queue " + stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkUpdate$lambda$0(UpdateService updateService, final String str) {
        final JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = (JSONArray) new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                JSONArray checkUpdate$lambda$0$0;
                checkUpdate$lambda$0$0 = UpdateService.checkUpdate$lambda$0$0(jSONObject, str, (String) obj);
                return checkUpdate$lambda$0$0;
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
    public static final JSONArray checkUpdate$lambda$0$0(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("data");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("name"), str2)) {
                JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
                return jSONArray2;
            }
        }
        throw new Exception("JSON Corrupted " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkUpdate$lambda$1(UpdateService updateService, VolleyError volleyError) {
        FileServers.INSTANCE.currentServerIsUnreachable();
        updateService.logDownloadError(DownloadErrorEvent.GAME_UPDATE_REQUEST_FAILED);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UpdateService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/UpdateService$ExpectedFile;", "", "size", "", "dateMillis", "<init>", "(JJ)V", "getSize", "()J", "getDateMillis", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ExpectedFile {
        private final long dateMillis;
        private final long size;

        public static /* synthetic */ ExpectedFile copy$default(ExpectedFile expectedFile, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = expectedFile.size;
            }
            if ((i & 2) != 0) {
                j2 = expectedFile.dateMillis;
            }
            return expectedFile.copy(j, j2);
        }

        public final long component1() {
            return this.size;
        }

        public final long component2() {
            return this.dateMillis;
        }

        public final ExpectedFile copy(long j, long j2) {
            return new ExpectedFile(j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExpectedFile) {
                ExpectedFile expectedFile = (ExpectedFile) obj;
                return this.size == expectedFile.size && this.dateMillis == expectedFile.dateMillis;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.size) * 31) + Long.hashCode(this.dateMillis);
        }

        public String toString() {
            long j = this.size;
            return "ExpectedFile(size=" + j + ", dateMillis=" + this.dateMillis + ")";
        }

        public ExpectedFile(long j, long j2) {
            this.size = j;
            this.dateMillis = j2;
        }

        public final long getDateMillis() {
            return this.dateMillis;
        }

        public final long getSize() {
            return this.size;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Map buildExpectedFileInfo$default(UpdateService updateService, JSONArray jSONArray, String str, String str2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            map = new LinkedHashMap();
        }
        return updateService.buildExpectedFileInfo(jSONArray, str, str2, map);
    }

    private final Map<String, ExpectedFile> buildExpectedFileInfo(JSONArray jSONArray, String str, String str2, Map<String, ExpectedFile> map) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("type");
            if (string != null) {
                int hashCode = string.hashCode();
                if (hashCode != 99469) {
                    if (hashCode == 112800) {
                        if (!string.equals("res")) {
                        }
                        map.put(str2 + str + "/" + jSONObject.getString("name"), new ExpectedFile(jSONObject.getLong("size"), jSONObject.optLong("date_change", 0L) * 1000));
                    } else if (hashCode == 3143036) {
                        if (!string.equals(UtilsKt.SCHEME_FILE)) {
                        }
                        map.put(str2 + str + "/" + jSONObject.getString("name"), new ExpectedFile(jSONObject.getLong("size"), jSONObject.optLong("date_change", 0L) * 1000));
                    }
                } else if (string.equals("dir")) {
                    String string2 = jSONObject.getString("name");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("data");
                    Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
                    buildExpectedFileInfo(jSONArray2, str + "/" + string2, str2, map);
                }
            }
        }
        return map;
    }

    private final String hostOf(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        String substringAfter = StringsKt.substringAfter(str, "://", "");
        if (substringAfter.length() == 0) {
            return null;
        }
        String lowerCase = StringsKt.substringBefore$default(StringsKt.substringBefore$default(substringAfter, '/', (String) null, 2, (Object) null), (char) AbstractJsonLexerKt.COLON, (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str3 = lowerCase;
        return StringsKt.isBlank(str3) ? null : str3;
    }

    private final boolean sameHost(String str, String str2) {
        String hostOf;
        String hostOf2 = hostOf(str);
        if (hostOf2 == null || (hostOf = hostOf(str2)) == null) {
            return false;
        }
        return Intrinsics.areEqual(hostOf2, hostOf);
    }

    private final void downloadGameData() {
        String str;
        File externalFilesDir;
        Map map;
        ExpectedFile expectedFile;
        int i;
        String str2;
        Log.i(TAG, "Downloading game data...");
        startForegroundService();
        DownloadContext.Builder commit = new DownloadContext.QueueSet().setMinIntervalMillisCallbackProcess(100).commit();
        long j = 0;
        this.mDownloadedLength = 0L;
        this.lastDownloadedBytes = 0L;
        this.mTotalLength = 0L;
        String currentServer = FileServers.INSTANCE.getCurrentServer();
        this.mLastOperationStatus = Errno.NoError;
        if (currentServer.length() == 0) {
            logDownloadError(DownloadErrorEvent.GAME_DATA_SERVER_EMPTY);
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
        if (this.mUpdateFiles.isEmpty()) {
            logDownloadError(DownloadErrorEvent.GAME_DATA_FILE_LIST_EMPTY);
            this.mLastOperationStatus = Errno.ConnectionRefused;
            Message obtain2 = Message.obtain(this.mInHandler, 2);
            obtain2.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
            obtain2.replyTo = this.mMessenger;
            Messenger messenger2 = this.mActivityMessenger;
            if (messenger2 != null) {
                messenger2.send(obtain2);
            }
            Log.w(TAG, "Server unreachable: " + currentServer);
            stopForegroundService();
            return;
        }
        Map buildExpectedFileInfo$default = buildExpectedFileInfo$default(this, this.mDataInfo, null, null, null, 14, null);
        final HashMap hashMap = new HashMap();
        int size = this.mUpdateFiles.size();
        int i2 = 0;
        while (i2 < size) {
            String str3 = (String) CollectionsKt.getOrNull(this.mUpdateFiles, i2);
            if (str3 == null || (str = (String) CollectionsKt.getOrNull(this.mUpdateFiles, i2)) == null) {
                return;
            }
            long j2 = j;
            String str4 = currentServer + "data/files" + str3;
            File file = new File((getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + str);
            ExpectedFile expectedFile2 = (ExpectedFile) buildExpectedFileInfo$default.get(str3);
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                map = buildExpectedFileInfo$default;
            } else {
                map = buildExpectedFileInfo$default;
                Log.e(TAG, "Error make directory " + parentFile.getAbsolutePath());
            }
            ArrayList<Integer> notFinishedTaskIdList = notFinishedTaskIdList();
            Long valueOf = expectedFile2 != null ? Long.valueOf(expectedFile2.getSize()) : null;
            Iterator<Integer> it = notFinishedTaskIdList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            boolean z = false;
            while (true) {
                Iterator<Integer> it2 = it;
                if (!it.hasNext()) {
                    break;
                }
                Integer next = it2.next();
                int i3 = size;
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                BreakpointInfo breakpointInfo = OkDownload.with().breakpointStore().get(next.intValue());
                if (breakpointInfo == null || !Intrinsics.areEqual(breakpointInfo.getFile(), file)) {
                    expectedFile = expectedFile2;
                    i = i2;
                    str2 = currentServer;
                } else {
                    if (sameHost(breakpointInfo.getUrl(), str4) && valueOf != null && breakpointInfo.getTotalLength() == valueOf.longValue() && file.exists()) {
                        long totalLength = breakpointInfo.getTotalLength();
                        long length = file.length();
                        if (1 <= length && length <= totalLength) {
                            it = it2;
                            size = i3;
                            z = true;
                        }
                    }
                    expectedFile = expectedFile2;
                    i = i2;
                    str2 = currentServer;
                    Log.w(TAG, "Discard partial " + str + " (bp=" + breakpointInfo.getUrl() + " now=" + str4 + ", bpLen=" + breakpointInfo.getTotalLength() + " expected=" + valueOf + ")");
                }
                it = it2;
                size = i3;
                i2 = i;
                expectedFile2 = expectedFile;
                currentServer = str2;
            }
            int i4 = size;
            ExpectedFile expectedFile3 = expectedFile2;
            int i5 = i2;
            String str5 = currentServer;
            if (!z && !deleteExistingDownloadTarget(file)) {
                this.mLastOperationStatus = Errno.CorruptedFilesFound;
                resetGameStatus();
                setUpdateStatus(UpdateStatus.Undefined);
                logDownloadError(DownloadErrorEvent.GAME_DATA_DELETE_TARGET_FAILED);
                Message obtain3 = Message.obtain(this.mInHandler, 2);
                obtain3.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, false);
                obtain3.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
                obtain3.replyTo = this.mMessenger;
                Messenger messenger3 = this.mActivityMessenger;
                if (messenger3 != null) {
                    messenger3.send(obtain3);
                }
                stopForegroundService();
                return;
            }
            DownloadTask build = new DownloadTask.Builder(str4, file).setPriority(5).setMinIntervalMillisCallbackProcess(300).setConnectionCount(1).setPreAllocateLength(true).build();
            commit.bindSetTask(build);
            Log.v(TAG, "Create download " + build);
            arrayList.add(Integer.valueOf(build.getId()));
            if (expectedFile3 != null) {
                ExpectedFile expectedFile4 = expectedFile3.getDateMillis() > j2 ? expectedFile3 : null;
                if (expectedFile4 != null) {
                    hashMap.put(Integer.valueOf(build.getId()), Long.valueOf(expectedFile4.getDateMillis()));
                }
            }
            i2 = i5 + 1;
            j = j2;
            buildExpectedFileInfo$default = map;
            size = i4;
            currentServer = str5;
        }
        this.mDownloadContext = commit.build();
        this.mSpeedCalculator = new SpeedCalculator();
        saveDownloadTaskIdList(arrayList);
        this.mLastOperationStatus = Errno.NoError;
        long j3 = this.mUpdateFilesNeedSize;
        this.mTotalLength = j3;
        Log.v(TAG, "Get contentLength " + j3);
        this.mainHandler.postDelayed(this.checkTimeoutRunnable, 15000L);
        DownloadContext downloadContext = this.mDownloadContext;
        if (downloadContext != null) {
            downloadContext.start(DownloadListener1ExtensionKt.createListener1$default(null, null, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return UpdateService.downloadGameData$lambda$2((DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                }
            }, new Function3() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return UpdateService.downloadGameData$lambda$3(UpdateService.this, (DownloadTask) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                }
            }, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return UpdateService.downloadGameData$lambda$4(UpdateService.this, arrayList, hashMap, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                }
            }, 3, null), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit downloadGameData$lambda$2(DownloadTask connectTask, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(connectTask, "connectTask");
        Log.v(TAG, "Downloading " + connectTask);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit downloadGameData$lambda$3(UpdateService updateService, DownloadTask progressTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressTask, "progressTask");
        updateService.calcSpeed(progressTask, j);
        progressTask.addTag(2, Long.valueOf(j));
        updateService.updateStatusInfoAndProgress(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit downloadGameData$lambda$4(UpdateService updateService, ArrayList arrayList, HashMap hashMap, DownloadTask task, EndCause p1, Exception exc, Listener1Assist.Listener1Model p3) {
        FilesChek filesChek;
        DownloadErrorEvent downloadErrorEvent;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(p1, "p1");
        Intrinsics.checkNotNullParameter(p3, "p3");
        Log.v(TAG, "End download " + task + " " + p1 + " " + exc + " " + p3);
        if (p1 != EndCause.COMPLETED && p1 != EndCause.SAME_TASK_BUSY) {
            updateService.mainHandler.removeCallbacks(updateService.checkTimeoutRunnable);
            Log.w(TAG, "Status operation after error " + updateService.mLastOperationStatus);
            if (updateService.mLastOperationStatus == Errno.ConnectionRefused) {
                Log.v(TAG, "Repeat already requested");
                return Unit.INSTANCE;
            }
            Log.v(TAG, "Request repeat download");
            if (updateService.isDeviceOnline()) {
                FileServers.INSTANCE.currentServerIsUnreachable();
            } else {
                Log.w(TAG, "Device offline, keep current file server");
            }
            int i = WhenMappings.$EnumSwitchMapping$0[p1.ordinal()];
            if (i == 1) {
                downloadErrorEvent = DownloadErrorEvent.GAME_DATA_DOWNLOAD_FAILED;
            } else if (i == 2) {
                downloadErrorEvent = DownloadErrorEvent.GAME_DATA_DOWNLOAD_CANCELED;
            } else {
                downloadErrorEvent = DownloadErrorEvent.GAME_DATA_DOWNLOAD_NOT_COMPLETED;
            }
            updateService.logDownloadError(downloadErrorEvent);
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
        if (p1 == EndCause.COMPLETED) {
            Long l = (Long) hashMap.get(Integer.valueOf(task.getId()));
            File file = task.getFile();
            if (l != null && file != null) {
                SharedPreferences sharedPreferences = updateService.updatePreferences;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                    sharedPreferences = null;
                }
                sharedPreferences.edit().putLong(file.getAbsolutePath(), l.longValue()).apply();
            }
        }
        arrayList.remove(Integer.valueOf(task.getId()));
        if (!arrayList.isEmpty()) {
            return Unit.INSTANCE;
        }
        Log.v(TAG, "taskIdList empty");
        updateService.mainHandler.removeCallbacks(updateService.checkTimeoutRunnable);
        updateService.updateStatusInfoAndProgress(true);
        updateService.removeDownloadTaskIdList();
        FilesChek filesChek2 = updateService.filesChek;
        if (filesChek2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filesChek");
            filesChek = null;
        } else {
            filesChek = filesChek2;
        }
        if (!filesChek.isAllFilesOk(false, false, true, false, updateService.mDataInfo)) {
            updateService.resetGameStatus();
            updateService.updateStatusInfoAndProgress(true);
            updateService.setUpdateStatus(UpdateStatus.Undefined);
            updateService.mLastOperationStatus = Errno.CorruptedFilesFound;
            updateService.logDownloadError(DownloadErrorEvent.GAME_DATA_VALIDATION_FAILED);
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
        obtain.getData().putInt("current", ((int) (this.mDownloadedLength / 1024)) + 1);
        obtain.getData().putInt("total", (int) (this.mTotalLength / 1024));
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
        long j2 = this.mDownloadedLength + longValue;
        this.mDownloadedLength = j2;
        Log.d("calcSpeed", String.valueOf(j2));
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
        double bytesPerSecondAndFlush = ((this.mTotalLength - this.mDownloadedLength) / (speedCalculator.getBytesPerSecondAndFlush() + 1.0E-5d)) * 1000.0d;
        double d2 = (bytesPerSecondAndFlush / 1000.0d) % 60.0d;
        double d3 = (bytesPerSecondAndFlush / 60000.0d) % 60.0d;
        String str2 = (bytesPerSecondAndFlush / 3600000.0d) % 24.0d >= 1.0d ? ((int) d) + " h, " : "";
        String str3 = d3 >= 1.0d ? ((int) d3) + " min, " : "";
        if (d2 < 1.0d) {
            str = "";
        } else {
            str = ((int) d2) + " sec";
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

    private final boolean deleteExistingDownloadTarget(File file) {
        if (!file.isDirectory() && file.exists()) {
            SharedPreferences sharedPreferences = this.updatePreferences;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                sharedPreferences = null;
            }
            sharedPreferences.edit().remove(file.getAbsolutePath()).apply();
            if (!file.delete() && file.exists()) {
                IOException iOException = new IOException("Unable to delete existing file before download: " + file.getAbsolutePath());
                String message = iOException.getMessage();
                IOException iOException2 = iOException;
                Log.e(TAG, message, iOException2);
                FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                firebaseCrashlytics.setCustomKey("download_delete_failed_path", file.getAbsolutePath());
                firebaseCrashlytics.setCustomKey("download_delete_failed_exists", file.exists());
                firebaseCrashlytics.setCustomKey("download_delete_failed_can_read", file.canRead());
                firebaseCrashlytics.setCustomKey("download_delete_failed_can_write", file.canWrite());
                firebaseCrashlytics.setCustomKey("download_delete_failed_size", file.length());
                firebaseCrashlytics.recordException(iOException2);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkLauncherUpdate(String str) {
        RequestQueue sharedRequestQueue = getSharedRequestQueue();
        String str2 = str + "app_version.json";
        this.mLastOperationStatus = Errno.NoError;
        if (str.length() == 0) {
            logDownloadError(DownloadErrorEvent.LAUNCHER_UPDATE_CHECK_SERVER_EMPTY);
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
        StringRequest stringRequest = new StringRequest(0, str2, new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda3
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkLauncherUpdate$lambda$0(UpdateService.this, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.this.notifyServerUnreachable(UpdateService.DownloadErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        sharedRequestQueue.add(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkLauncherUpdate$lambda$0(UpdateService updateService, String str) {
        try {
            boolean z = new JSONObject(str).getInt("launcherVersion") > 1726;
            Message obtain = Message.obtain(updateService.mInHandler, 3);
            obtain.getData().putBoolean(NEED_UPDATE_MSG, z);
            obtain.getData().putSerializable(ERRNO_MSG, updateService.mLastOperationStatus);
            obtain.replyTo = updateService.mMessenger;
            Messenger messenger = updateService.mActivityMessenger;
            if (messenger != null) {
                messenger.send(obtain);
            }
        } catch (JSONException unused) {
            updateService.notifyServerUnreachable(DownloadErrorEvent.LAUNCHER_UPDATE_CHECK_JSON_INVALID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyServerUnreachable(DownloadErrorEvent downloadErrorEvent) {
        FileServers.INSTANCE.currentServerIsUnreachable();
        logDownloadError(downloadErrorEvent);
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
        String str2 = "app-arizona-release-" + this.retry + ".apk";
        Log.d(TAG, "We're waiting " + str2 + " / app-arizona-release.apk file");
        final File file = new File((getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + "/" + str2);
        if (file.exists()) {
            file.delete();
        }
        this.mLastOperationStatus = Errno.NoError;
        if (str.length() == 0) {
            logDownloadError(DownloadErrorEvent.LAUNCHER_APK_SERVER_EMPTY);
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
        commit.bindSetTask(new DownloadTask.Builder(str + "launcher_new/app-arizona-release.apk", file).setPriority(5).setMinIntervalMillisCallbackProcess(300).setConnectionCount(1).setPreAllocateLength(true).build());
        this.mDownloadContext = commit.build();
        this.mSpeedCalculator = new SpeedCalculator();
        this.mLastOperationStatus = Errno.NoError;
        long j = this.mUpdateFilesNeedSize;
        this.mTotalLength = j;
        Log.v(TAG, "Get contentLength " + j);
        this.mainHandler.postDelayed(this.checkTimeoutRunnable, 15000L);
        DownloadContext downloadContext = this.mDownloadContext;
        if (downloadContext != null) {
            downloadContext.start(DownloadListener1ExtensionKt.createListener1$default(null, null, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return UpdateService.startDownloadNewLauncherApk$lambda$0((DownloadTask) obj, ((Integer) obj2).intValue(), ((Long) obj3).longValue(), ((Long) obj4).longValue());
                }
            }, new Function3() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return UpdateService.startDownloadNewLauncherApk$lambda$1(UpdateService.this, (DownloadTask) obj, ((Long) obj2).longValue(), ((Long) obj3).longValue());
                }
            }, new Function4() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return UpdateService.startDownloadNewLauncherApk$lambda$2(UpdateService.this, file, r3, (DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (Listener1Assist.Listener1Model) obj4);
                }
            }, 3, null), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startDownloadNewLauncherApk$lambda$0(DownloadTask connectTask, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(connectTask, "connectTask");
        Log.v(TAG, "Downloading " + connectTask);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startDownloadNewLauncherApk$lambda$1(UpdateService updateService, DownloadTask progressTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(progressTask, "progressTask");
        updateService.mTotalLength = j2;
        updateService.calcSpeed(progressTask, j);
        progressTask.addTag(2, Long.valueOf(j));
        updateService.updateStatusInfoAndProgress(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startDownloadNewLauncherApk$lambda$2(final UpdateService updateService, File file, String str, DownloadTask errorTask, EndCause errorCode, Exception exc, Listener1Assist.Listener1Model exception) {
        DownloadErrorEvent downloadErrorEvent;
        Intrinsics.checkNotNullParameter(errorTask, "errorTask");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Log.e(TAG, "Download error in task: " + errorTask + ", errorCode: " + errorCode + ", errorMessage: " + exc + " - " + exception);
        updateService.mainHandler.removeCallbacks(updateService.checkTimeoutRunnable);
        if (errorCode == EndCause.ERROR || errorCode == EndCause.CANCELED) {
            updateService.mLastOperationStatus = Errno.UpdateServerUnreachable;
            if (WhenMappings.$EnumSwitchMapping$0[errorCode.ordinal()] == 2) {
                downloadErrorEvent = DownloadErrorEvent.LAUNCHER_APK_DOWNLOAD_CANCELED;
            } else {
                downloadErrorEvent = DownloadErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED;
            }
            updateService.logDownloadError(downloadErrorEvent);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                UpdateService.startDownloadNewLauncherApk$lambda$2$0(UpdateService.this);
            }
        }, 3750L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDownloadNewLauncherApk$lambda$2$0(UpdateService updateService) {
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/UpdateService$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateService;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/arizona/launcher/UpdateService;Landroid/os/Looper;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            FilesChek filesChek;
            FilesChek filesChek2;
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
                        Bundle data = obtain4.getData();
                        FilesChek filesChek3 = updateService.filesChek;
                        if (filesChek3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filesChek");
                            filesChek = null;
                        } else {
                            filesChek = filesChek3;
                        }
                        data.putBoolean(NotificationCompat.CATEGORY_STATUS, FilesChek.isAllFilesOk$default(filesChek, true, true, false, false, updateService.mDataInfo, 8, null));
                        BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new UpdateService$IncomingHandler$handleMessage$2(updateService, null), 1, null);
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
                        Bundle data2 = obtain5.getData();
                        FilesChek filesChek4 = updateService.filesChek;
                        if (filesChek4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filesChek");
                            filesChek2 = null;
                        } else {
                            filesChek2 = filesChek4;
                        }
                        data2.putBoolean(NotificationCompat.CATEGORY_STATUS, FilesChek.isAllFilesOk$default(filesChek2, true, true, false, false, updateService.mDataInfo, 8, null));
                        BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new UpdateService$IncomingHandler$handleMessage$3(updateService, null), 1, null);
                        obtain5.replyTo = updateService.mMessenger;
                        Messenger messenger5 = updateService.mActivityMessenger;
                        if (messenger5 != null) {
                            messenger5.send(obtain5);
                            return;
                        }
                        return;
                    case 10:
                        UpdateService.checkUpdateAndDownload$default(updateService, FileServers.INSTANCE.getCurrentServer(), 0, new Function0() { // from class: com.arizona.launcher.UpdateService$IncomingHandler$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UpdateService.IncomingHandler.handleMessage$lambda$0(UpdateService.this);
                            }
                        }, 2, null);
                        return;
                    default:
                        return;
                }
            }
            Log.d("UpdateService", "activity is null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$0(UpdateService updateService) {
            updateService.updateGameData();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void checkUpdateAndDownload$default(UpdateService updateService, String str, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = FileServers.INSTANCE.getGame_servers().length;
        }
        updateService.checkUpdateAndDownload(str, i, function0);
    }

    public final void checkUpdateAndDownload(String server, final int i, final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
        Intrinsics.checkNotNullExpressionValue(downloadDispatcher, "downloadDispatcher(...)");
        synchronized (downloadDispatcher) {
            OkDownload.with().downloadDispatcher().cancelAll();
            Unit unit = Unit.INSTANCE;
        }
        Log.d(TAG, "checkUpdate (attemptsLeft=" + i + ")");
        startForegroundService();
        setUpdateStatus(UpdateStatus.CheckUpdate);
        RequestQueue sharedRequestQueue = getSharedRequestQueue();
        this.mLastOperationStatus = Errno.NoError;
        if (server.length() == 0) {
            notifyCheckUpdateAndDownloadUnreachable(DownloadErrorEvent.CHECK_AND_DOWNLOAD_SERVER_EMPTY);
            return;
        }
        Log.i(TAG, "checkUpdate: requesting server for update json");
        StringRequest stringRequest = new StringRequest(0, server + UpdateJsonProvider.INSTANCE.getJsonName(this), new Response.Listener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                UpdateService.checkUpdateAndDownload$lambda$1(UpdateService.this, onFinish, (String) obj);
            }
        }, new Response.ErrorListener() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda6
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                UpdateService.checkUpdateAndDownload$lambda$2(UpdateService.this, i, onFinish, volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        stringRequest.setShouldCache(false);
        sharedRequestQueue.add(stringRequest);
        Log.v(TAG, "Add to queue " + stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkUpdateAndDownload$lambda$1(UpdateService updateService, Function0 function0, final String str) {
        final JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = (JSONArray) new Function1() { // from class: com.arizona.launcher.UpdateService$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                JSONArray checkUpdateAndDownload$lambda$1$0;
                checkUpdateAndDownload$lambda$1$0 = UpdateService.checkUpdateAndDownload$lambda$1$0(jSONObject, str, (String) obj);
                return checkUpdateAndDownload$lambda$1$0;
            }
        }.invoke("files");
        updateService.mDataInfo = jSONArray;
        Log.v(TAG, "mDataInfo " + jSONArray);
        updateService.mUpdateFiles = new ArrayList();
        updateService.mUpdateFilesNeedSize = 0L;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UpdateService$checkUpdateAndDownload$stringRequest$1$1(updateService, function0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray checkUpdateAndDownload$lambda$1$0(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("data");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(jSONArray.getJSONObject(i).getString("name"), str2)) {
                JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("data");
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
                return jSONArray2;
            }
        }
        throw new Exception("JSON Corrupted " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkUpdateAndDownload$lambda$2(UpdateService updateService, int i, Function0 function0, VolleyError volleyError) {
        if (!updateService.isDeviceOnline()) {
            Log.w(TAG, "Device offline, skip mirror rotation in checkUpdateAndDownload");
            updateService.notifyCheckUpdateAndDownloadUnreachable(DownloadErrorEvent.CHECK_AND_DOWNLOAD_REQUEST_FAILED);
            return;
        }
        FileServers.INSTANCE.currentServerIsUnreachable();
        if (i > 1) {
            updateService.checkUpdateAndDownload(FileServers.INSTANCE.getCurrentServer(), i - 1, function0);
        } else {
            updateService.notifyCheckUpdateAndDownloadUnreachable(DownloadErrorEvent.CHECK_AND_DOWNLOAD_REQUEST_FAILED);
        }
    }

    private final void notifyCheckUpdateAndDownloadUnreachable(DownloadErrorEvent downloadErrorEvent) {
        logDownloadError(downloadErrorEvent);
        this.mLastOperationStatus = Errno.UpdateServerUnreachable;
        setUpdateStatus(UpdateStatus.Undefined);
        Message obtain = Message.obtain(this.mInHandler, 2);
        obtain.getData().putBoolean(NotificationCompat.CATEGORY_STATUS, false);
        obtain.getData().putSerializable(ERRNO_MSG, this.mLastOperationStatus);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mActivityMessenger;
        if (messenger != null) {
            messenger.send(obtain);
        }
        Log.w(TAG, "Send message server unreachable " + obtain);
        stopForegroundService();
    }
}
