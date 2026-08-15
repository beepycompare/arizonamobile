package com.miami.game.core.design.system.component.background;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.UtilsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010+\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020,H\u0082@¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020,H\u0082@¢\u0006\u0002\u00102J,\u00104\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0005062\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00109J\"\u0010:\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u0001002\b\u0010<\u001a\u0004\u0018\u00010=H\u0082@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000200H\u0002J\n\u0010@\u001a\u0004\u0018\u000100H\u0002J\n\u0010A\u001a\u0004\u0018\u000100H\u0002J\u0018\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\u0006\u00108\u001a\u00020\u0005H\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0002J\n\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u000200H\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\u0005062\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0018\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u000200H\u0002J\u0010\u0010P\u001a\u00020\u00152\u0006\u0010;\u001a\u000200H\u0002J\u0018\u0010Q\u001a\u00020,2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H\u0002J\u0018\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u0005H\u0002J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\rH\u0002J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\rH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010;\u001a\u000200H\u0002J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010;\u001a\u000200H\u0002J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*Ê\u0001\f\ba\u0012\b\bb\u0012\u0004\b\u0003\u0010\u0002¨\u0006`"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundWriter;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "DIR_NAME", "PREF_CURRENT_FILE_NAME", "PREF_CURRENT_FILE_HASH", "DEFAULT_ASSET_PATH", "DEFAULT_LOCAL_FILE_NAME", "DOWNLOAD_ATTEMPTS", "", "DOWNLOAD_RETRY_DELAY_MS", "", "MAX_BACKGROUND_BYTES", "MAX_BACKGROUND_SIDE_PX", "context", "Landroid/content/Context;", "isArizona", "", "prefs", "Landroid/content/SharedPreferences;", "assetPath", "scope", "Lkotlinx/coroutines/CoroutineScope;", "syncMutex", "Lkotlinx/coroutines/sync/Mutex;", "startJob", "Lkotlinx/coroutines/Job;", "remoteConfigUpdatesJob", "remoteConfigProvider", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfigProvider", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setParams", "", TtmlNode.START, "refresh", "currentTargetFile", "Ljava/io/File;", "loadLocal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncRemoteAndStore", "downloadAndValidateWithRetry", "remoteUrls", "", "tmp", "expectedHash", "(Ljava/util/List;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitNew", UtilsKt.SCHEME_FILE, "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Ljava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDir", "resolveLocalFile", "ensureValidDefaultFile", "forceRestoreDefaultFile", "defaultFile", "deleteStaleDownloadedFiles", "keep", "deleteTemporaryFiles", "clearCurrentFile", "calculateAssetHashOrNull", "writeAssetToFileAtomically", TypedValues.AttributesType.S_TARGET, "buildRemoteUrls", "remotePath", "downloadToFile", "urlString", "dest", "isDecodableImage", "persistCurrentFile", "fileName", "fileHash", "logRemoteConfigInfo", "pathKey", "hashKey", "sourceName", "source", "fetchStatusName", "status", "calculateFileHashOrEmpty", "calculateFileHash", "calculateHash", "input", "Ljava/io/InputStream;", "design-system", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LauncherBackgroundWriter {
    public static final int $stable = 0;
    private static final String DEFAULT_ASSET_PATH = "background_home.webp";
    private static final String DEFAULT_LOCAL_FILE_NAME = "background_home.webp";
    private static final String DIR_NAME = "launcher_bg";
    private static final int DOWNLOAD_ATTEMPTS = 3;
    private static final long DOWNLOAD_RETRY_DELAY_MS = 750;
    private static final long MAX_BACKGROUND_BYTES = 20971520;
    private static final int MAX_BACKGROUND_SIDE_PX = 8192;
    private static final String PREFS_NAME = "launcher_bg_prefs";
    private static final String PREF_CURRENT_FILE_HASH = "current_file_hash";
    private static final String PREF_CURRENT_FILE_NAME = "current_file_name";
    private static final String TAG = "LauncherBgWriter";
    private static final MutableStateFlow<LauncherBackgroundState> _state;
    private static Context context;
    private static boolean isArizona;
    private static SharedPreferences prefs;
    private static final FirebaseRemoteConfig remoteConfigProvider;
    private static Job remoteConfigUpdatesJob;
    private static Job startJob;
    private static final StateFlow<LauncherBackgroundState> state;
    public static final LauncherBackgroundWriter INSTANCE = new LauncherBackgroundWriter();
    private static final String assetPath = "background_home.webp";
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final Mutex syncMutex = MutexKt.Mutex$default(false, 1, null);

    private LauncherBackgroundWriter() {
    }

    static {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        remoteConfigProvider = firebaseRemoteConfig;
        MutableStateFlow<LauncherBackgroundState> MutableStateFlow = StateFlowKt.MutableStateFlow(new LauncherBackgroundState(0, null, null, 7, null));
        _state = MutableStateFlow;
        state = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final FirebaseRemoteConfig getRemoteConfigProvider() {
        return remoteConfigProvider;
    }

    public final StateFlow<LauncherBackgroundState> getState() {
        return state;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: all -> 0x00a6, TryCatch #0 {, blocks: (B:4:0x0007, B:7:0x0018, B:9:0x0020, B:14:0x0028, B:16:0x0054, B:17:0x005a, B:19:0x0074, B:21:0x007b, B:23:0x0095, B:26:0x00a1), top: B:32:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[Catch: all -> 0x00a6, TryCatch #0 {, blocks: (B:4:0x0007, B:7:0x0018, B:9:0x0020, B:14:0x0028, B:16:0x0054, B:17:0x005a, B:19:0x0074, B:21:0x007b, B:23:0x0095, B:26:0x00a1), top: B:32:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0007, B:7:0x0018, B:9:0x0020, B:14:0x0028, B:16:0x0054, B:17:0x005a, B:19:0x0074, B:21:0x007b, B:23:0x0095, B:26:0x00a1), top: B:32:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: all -> 0x00a6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0007, B:7:0x0018, B:9:0x0020, B:14:0x0028, B:16:0x0054, B:17:0x005a, B:19:0x0074, B:21:0x007b, B:23:0x0095, B:26:0x00a1), top: B:32:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void setParams(Context context2, boolean z) {
        boolean z2;
        Context context3;
        Context context4;
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Context context5 = context;
        Context context6 = null;
        if (context5 != null) {
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context5 = null;
            }
            if (context5 == applicationContext && isArizona == z) {
                z2 = false;
                Intrinsics.checkNotNull(applicationContext);
                context = applicationContext;
                isArizona = z;
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(PREFS_NAME, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
                prefs = sharedPreferences;
                Log.d(TAG, "setParams: isArizona=" + z);
                context3 = context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context3 = null;
                }
                Log.d(TAG, "setParams: packageName=" + context3.getPackageName());
                context4 = context;
                if (context4 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context6 = context4;
                }
                Log.d(TAG, "setParams: filesDir=" + context6.getFilesDir().getAbsolutePath());
                if (z2) {
                    Log.d(TAG, "setParams: already initialized with same params, request refresh");
                    refresh();
                    return;
                }
                start();
                return;
            }
        }
        z2 = true;
        Intrinsics.checkNotNull(applicationContext);
        context = applicationContext;
        isArizona = z;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getSharedPreferences(...)");
        prefs = sharedPreferences2;
        Log.d(TAG, "setParams: isArizona=" + z);
        context3 = context;
        if (context3 == null) {
        }
        Log.d(TAG, "setParams: packageName=" + context3.getPackageName());
        context4 = context;
        if (context4 != null) {
        }
        Log.d(TAG, "setParams: filesDir=" + context6.getFilesDir().getAbsolutePath());
        if (z2) {
        }
    }

    public final synchronized void start() {
        Job launch$default;
        Job launch$default2;
        Log.d(TAG, TtmlNode.START);
        Job job = startJob;
        if (job == null || !job.isActive()) {
            job = null;
        }
        CoroutineScope coroutineScope = scope;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LauncherBackgroundWriter$start$initialJob$1(job, null), 3, null);
        startJob = launch$default;
        Job job2 = remoteConfigUpdatesJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LauncherBackgroundWriter$start$1(launch$default, null), 3, null);
        remoteConfigUpdatesJob = launch$default2;
    }

    public final void refresh() {
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new LauncherBackgroundWriter$refresh$1(null), 3, null);
    }

    public final File currentTargetFile() {
        File ensureDir = ensureDir();
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString(PREF_CURRENT_FILE_NAME, null);
        Log.d(TAG, "currentTargetFile: savedName=" + string);
        String str = string;
        if (str != null && !StringsKt.isBlank(str)) {
            File file = new File(ensureDir, string);
            Log.d(TAG, "currentTargetFile: checking savedFile=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", size=" + file.length());
            if (file.exists() && file.length() > 0) {
                return file;
            }
        }
        File file2 = new File(ensureDir, "background_home.webp");
        Log.d(TAG, "currentTargetFile: fallback defaultFile=" + file2.getAbsolutePath());
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(2:20|(1:(2:23|24)(2:25|26))(2:27|28))(4:9|10|(1:12)(1:19)|13)|15|16))|43|6|7|(0)(0)|15|16|(2:(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (emitNew(r11, null, r2) == r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:
        android.util.Log.e(com.miami.game.core.design.system.component.background.LauncherBackgroundWriter.TAG, "loadLocal: error", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
        r0 = ensureValidDefaultFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r0 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        r4 = r0.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
        android.util.Log.d(com.miami.game.core.design.system.component.background.LauncherBackgroundWriter.TAG, "loadLocal: emergency fallback emit file=" + r4);
        r2.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r2.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0);
        r2.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b9, code lost:
        if (emitNew(r0, null, r2) != r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bb, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
        throw r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadLocal(Continuation<? super Unit> continuation) {
        LauncherBackgroundWriter$loadLocal$1 launcherBackgroundWriter$loadLocal$1;
        int i;
        if (continuation instanceof LauncherBackgroundWriter$loadLocal$1) {
            launcherBackgroundWriter$loadLocal$1 = (LauncherBackgroundWriter$loadLocal$1) continuation;
            if ((launcherBackgroundWriter$loadLocal$1.label & Integer.MIN_VALUE) != 0) {
                launcherBackgroundWriter$loadLocal$1.label -= Integer.MIN_VALUE;
                Object obj = launcherBackgroundWriter$loadLocal$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = launcherBackgroundWriter$loadLocal$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Log.d(TAG, "loadLocal: start");
                    File resolveLocalFile = resolveLocalFile();
                    Log.d(TAG, "loadLocal: emit file=" + (resolveLocalFile != null ? resolveLocalFile.getAbsolutePath() : null));
                    launcherBackgroundWriter$loadLocal$1.L$0 = SpillingKt.nullOutSpilledVariable(resolveLocalFile);
                    launcherBackgroundWriter$loadLocal$1.label = 1;
                } else {
                    try {
                        if (i == 1) {
                            File file = (File) launcherBackgroundWriter$loadLocal$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            File file2 = (File) launcherBackgroundWriter$loadLocal$1.L$1;
                            Throwable th = (Throwable) launcherBackgroundWriter$loadLocal$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th2) {
                        Boxing.boxInt(Log.e(TAG, "loadLocal: emergency fallback failed", th2));
                    }
                }
                return Unit.INSTANCE;
            }
        }
        launcherBackgroundWriter$loadLocal$1 = new LauncherBackgroundWriter$loadLocal$1(this, continuation);
        Object obj2 = launcherBackgroundWriter$loadLocal$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = launcherBackgroundWriter$loadLocal$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(13:5|6|7|(2:9|(2:11|(5:13|14|15|16|(2:18|19)(4:21|(1:23)|24|(3:26|27|28)(2:29|30)))(2:31|32))(2:33|34))(3:75|76|(2:78|79))|35|(1:37)|38|39|(2:41|42)(1:74)|43|(1:45)|46|(2:48|49)(2:50|(2:60|(2:70|(1:73)(3:72|16|(0)(0)))(2:68|69))(2:58|59))))|84|6|7|(0)(0)|35|(0)|38|39|(0)(0)|43|(0)|46|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x038e, code lost:
        android.util.Log.e(com.miami.game.core.design.system.component.background.LauncherBackgroundWriter.TAG, "syncRemoteAndStore: fatal error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0396, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0397, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113 A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0194 A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019c A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0320 A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0323 A[Catch: all -> 0x009b, CancellationException -> 0x0396, TryCatch #2 {CancellationException -> 0x0396, all -> 0x009b, blocks: (B:15:0x0085, B:67:0x0318, B:69:0x0320, B:71:0x0323, B:73:0x0329, B:74:0x033f, B:76:0x0357, B:77:0x0382, B:78:0x038d, B:19:0x0095, B:27:0x00b4, B:29:0x00bc, B:30:0x00c1, B:34:0x00f7, B:36:0x0107, B:38:0x0113, B:39:0x011e, B:41:0x0194, B:43:0x019c, B:45:0x01da, B:47:0x01e2, B:49:0x01e8, B:51:0x01f2, B:53:0x0204, B:55:0x0291, B:57:0x0299, B:59:0x029f, B:61:0x02ad, B:63:0x02c3, B:24:0x00a1), top: B:84:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncRemoteAndStore(Continuation<? super Unit> continuation) {
        LauncherBackgroundWriter$syncRemoteAndStore$1 launcherBackgroundWriter$syncRemoteAndStore$1;
        int i;
        Object awaitRemoteConfigReady;
        boolean booleanValue;
        FirebaseRemoteConfigValue firebaseRemoteConfigValue;
        LauncherBackgroundWriter$syncRemoteAndStore$1 launcherBackgroundWriter$syncRemoteAndStore$12;
        FirebaseRemoteConfigValue firebaseRemoteConfigValue2;
        LauncherBackgroundRemoteSpec remoteSpec;
        File file;
        LauncherBackgroundRemoteSpec launcherBackgroundRemoteSpec;
        Object obj;
        File file2;
        if (continuation instanceof LauncherBackgroundWriter$syncRemoteAndStore$1) {
            launcherBackgroundWriter$syncRemoteAndStore$1 = (LauncherBackgroundWriter$syncRemoteAndStore$1) continuation;
            if ((launcherBackgroundWriter$syncRemoteAndStore$1.label & Integer.MIN_VALUE) != 0) {
                launcherBackgroundWriter$syncRemoteAndStore$1.label -= Integer.MIN_VALUE;
                Object obj2 = launcherBackgroundWriter$syncRemoteAndStore$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = launcherBackgroundWriter$syncRemoteAndStore$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Log.d(TAG, "syncRemoteAndStore: start");
                    FirebaseConfigHelper firebaseConfigHelper = FirebaseConfigHelper.INSTANCE;
                    launcherBackgroundWriter$syncRemoteAndStore$1.label = 1;
                    awaitRemoteConfigReady = firebaseConfigHelper.awaitRemoteConfigReady(launcherBackgroundWriter$syncRemoteAndStore$1);
                    if (awaitRemoteConfigReady == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        boolean z = launcherBackgroundWriter$syncRemoteAndStore$1.Z$0;
                        List list = (List) launcherBackgroundWriter$syncRemoteAndStore$1.L$11;
                        File file3 = (File) launcherBackgroundWriter$syncRemoteAndStore$1.L$10;
                        file2 = (File) launcherBackgroundWriter$syncRemoteAndStore$1.L$9;
                        File file4 = (File) launcherBackgroundWriter$syncRemoteAndStore$1.L$8;
                        String str = (String) launcherBackgroundWriter$syncRemoteAndStore$1.L$7;
                        File file5 = (File) launcherBackgroundWriter$syncRemoteAndStore$1.L$6;
                        File file6 = (File) launcherBackgroundWriter$syncRemoteAndStore$1.L$5;
                        launcherBackgroundRemoteSpec = (LauncherBackgroundRemoteSpec) launcherBackgroundWriter$syncRemoteAndStore$1.L$4;
                        FirebaseRemoteConfigValue firebaseRemoteConfigValue3 = (FirebaseRemoteConfigValue) launcherBackgroundWriter$syncRemoteAndStore$1.L$3;
                        FirebaseRemoteConfigValue firebaseRemoteConfigValue4 = (FirebaseRemoteConfigValue) launcherBackgroundWriter$syncRemoteAndStore$1.L$2;
                        Map map = (Map) launcherBackgroundWriter$syncRemoteAndStore$1.L$1;
                        LauncherBackgroundRemoteKeys launcherBackgroundRemoteKeys = (LauncherBackgroundRemoteKeys) launcherBackgroundWriter$syncRemoteAndStore$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        file = file3;
                        obj = obj2;
                        if (((Boolean) obj).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        if (file2.exists()) {
                            Log.d(TAG, "syncRemoteAndStore: delete invalid target result=" + file2.delete());
                        }
                        boolean renameTo = file.renameTo(file2);
                        Log.d(TAG, "syncRemoteAndStore: rename tmp->target result=" + renameTo);
                        if (!renameTo) {
                            throw new IllegalStateException("Rename failed".toString());
                        }
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        persistCurrentFile(name, launcherBackgroundRemoteSpec.getSha256());
                        Log.d(TAG, "syncRemoteAndStore: staged=" + file2.getAbsolutePath() + "; display on next process start");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj2);
                    awaitRemoteConfigReady = obj2;
                }
                booleanValue = ((Boolean) awaitRemoteConfigReady).booleanValue();
                if (!booleanValue) {
                    Log.w(TAG, "syncRemoteAndStore: fresh Remote Config unavailable; use cached values");
                }
                LauncherBackgroundRemoteKeys remoteKeys = LauncherBackgroundPolicy.INSTANCE.remoteKeys(isArizona);
                logRemoteConfigInfo(remoteKeys.getPath(), remoteKeys.getHash());
                FirebaseRemoteConfig firebaseRemoteConfig = remoteConfigProvider;
                Map<String, FirebaseRemoteConfigValue> all = firebaseRemoteConfig.getAll();
                Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
                firebaseRemoteConfigValue = all.get(remoteKeys.getPath());
                if (firebaseRemoteConfigValue != null) {
                    launcherBackgroundWriter$syncRemoteAndStore$12 = launcherBackgroundWriter$syncRemoteAndStore$1;
                    FirebaseRemoteConfigValue value = firebaseRemoteConfig.getValue(remoteKeys.getPath());
                    Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                    firebaseRemoteConfigValue = value;
                } else {
                    launcherBackgroundWriter$syncRemoteAndStore$12 = launcherBackgroundWriter$syncRemoteAndStore$1;
                }
                firebaseRemoteConfigValue2 = all.get(remoteKeys.getHash());
                if (firebaseRemoteConfigValue2 == null) {
                    firebaseRemoteConfigValue2 = firebaseRemoteConfig.getValue(remoteKeys.getHash());
                    Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfigValue2, "getValue(...)");
                }
                FirebaseRemoteConfigValue firebaseRemoteConfigValue5 = firebaseRemoteConfigValue2;
                remoteSpec = LauncherBackgroundPolicy.INSTANCE.remoteSpec(firebaseRemoteConfigValue.asString(), firebaseRemoteConfigValue5.asString());
                String asString = firebaseRemoteConfigValue.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                Log.d(TAG, "syncRemoteAndStore: remotePath=[" + StringsKt.trim((CharSequence) asString).toString() + "], source=" + sourceName(firebaseRemoteConfigValue.getSource()));
                String asString2 = firebaseRemoteConfigValue5.asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
                Log.d(TAG, "syncRemoteAndStore: remoteHash=[" + StringsKt.trim((CharSequence) asString2).toString() + "], source=" + sourceName(firebaseRemoteConfigValue5.getSource()));
                if (remoteSpec != null) {
                    Log.e(TAG, "syncRemoteAndStore: path is empty or hash is not a SHA-256, skip");
                    return Unit.INSTANCE;
                }
                File ensureDir = ensureDir();
                File currentTargetFile = currentTargetFile();
                String calculateFileHashOrEmpty = calculateFileHashOrEmpty(currentTargetFile);
                Log.d(TAG, "syncRemoteAndStore: currentFile=" + currentTargetFile.getAbsolutePath());
                Log.d(TAG, "syncRemoteAndStore: currentHash=[" + calculateFileHashOrEmpty + "]");
                if (currentTargetFile.exists() && currentTargetFile.length() > 0 && isDecodableImage(currentTargetFile) && Intrinsics.areEqual(calculateFileHashOrEmpty, remoteSpec.getSha256())) {
                    Log.d(TAG, "syncRemoteAndStore: current file already matches remote hash, skip download");
                    String name2 = currentTargetFile.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    persistCurrentFile(name2, calculateFileHashOrEmpty);
                    return Unit.INSTANCE;
                }
                File file7 = new File(ensureDir, LauncherBackgroundPolicy.INSTANCE.buildLocalFileName(remoteSpec.getPath(), remoteSpec.getSha256()));
                File avoidDisplayedFile = LauncherBackgroundPolicy.INSTANCE.avoidDisplayedFile(file7, _state.getValue().getFile());
                file = new File(avoidDisplayedFile.getParentFile(), avoidDisplayedFile.getName() + ".tmp");
                List<String> buildRemoteUrls = buildRemoteUrls(remoteSpec.getPath());
                Log.d(TAG, "syncRemoteAndStore: remoteUrls=" + buildRemoteUrls);
                Log.d(TAG, "syncRemoteAndStore: target=" + avoidDisplayedFile.getAbsolutePath());
                Log.d(TAG, "syncRemoteAndStore: tmp=" + file.getAbsolutePath());
                if (avoidDisplayedFile.exists() && avoidDisplayedFile.length() > 0 && isDecodableImage(avoidDisplayedFile) && Intrinsics.areEqual(calculateFileHashOrEmpty(avoidDisplayedFile), remoteSpec.getSha256())) {
                    Log.d(TAG, "syncRemoteAndStore: validated target already exists, stage it");
                    String name3 = avoidDisplayedFile.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                    persistCurrentFile(name3, remoteSpec.getSha256());
                    return Unit.INSTANCE;
                }
                String sha256 = remoteSpec.getSha256();
                LauncherBackgroundWriter$syncRemoteAndStore$1 launcherBackgroundWriter$syncRemoteAndStore$13 = launcherBackgroundWriter$syncRemoteAndStore$12;
                launcherBackgroundWriter$syncRemoteAndStore$13.L$0 = SpillingKt.nullOutSpilledVariable(remoteKeys);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$1 = SpillingKt.nullOutSpilledVariable(all);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$2 = SpillingKt.nullOutSpilledVariable(firebaseRemoteConfigValue);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$3 = SpillingKt.nullOutSpilledVariable(firebaseRemoteConfigValue5);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$4 = remoteSpec;
                launcherBackgroundWriter$syncRemoteAndStore$13.L$5 = SpillingKt.nullOutSpilledVariable(ensureDir);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$6 = SpillingKt.nullOutSpilledVariable(currentTargetFile);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$7 = SpillingKt.nullOutSpilledVariable(calculateFileHashOrEmpty);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$8 = SpillingKt.nullOutSpilledVariable(file7);
                launcherBackgroundWriter$syncRemoteAndStore$13.L$9 = avoidDisplayedFile;
                launcherBackgroundWriter$syncRemoteAndStore$13.L$10 = file;
                launcherBackgroundWriter$syncRemoteAndStore$13.L$11 = SpillingKt.nullOutSpilledVariable(buildRemoteUrls);
                launcherBackgroundWriter$syncRemoteAndStore$13.Z$0 = booleanValue;
                launcherBackgroundWriter$syncRemoteAndStore$13.label = 2;
                Object downloadAndValidateWithRetry = downloadAndValidateWithRetry(buildRemoteUrls, file, sha256, launcherBackgroundWriter$syncRemoteAndStore$13);
                if (downloadAndValidateWithRetry == coroutine_suspended) {
                    return coroutine_suspended;
                }
                launcherBackgroundRemoteSpec = remoteSpec;
                obj = downloadAndValidateWithRetry;
                file2 = avoidDisplayedFile;
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        launcherBackgroundWriter$syncRemoteAndStore$1 = new LauncherBackgroundWriter$syncRemoteAndStore$1(this, continuation);
        Object obj22 = launcherBackgroundWriter$syncRemoteAndStore$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = launcherBackgroundWriter$syncRemoteAndStore$1.label;
        if (i != 0) {
        }
        booleanValue = ((Boolean) awaitRemoteConfigReady).booleanValue();
        if (!booleanValue) {
        }
        LauncherBackgroundRemoteKeys remoteKeys2 = LauncherBackgroundPolicy.INSTANCE.remoteKeys(isArizona);
        logRemoteConfigInfo(remoteKeys2.getPath(), remoteKeys2.getHash());
        FirebaseRemoteConfig firebaseRemoteConfig2 = remoteConfigProvider;
        Map<String, FirebaseRemoteConfigValue> all2 = firebaseRemoteConfig2.getAll();
        Intrinsics.checkNotNullExpressionValue(all2, "getAll(...)");
        firebaseRemoteConfigValue = all2.get(remoteKeys2.getPath());
        if (firebaseRemoteConfigValue != null) {
        }
        firebaseRemoteConfigValue2 = all2.get(remoteKeys2.getHash());
        if (firebaseRemoteConfigValue2 == null) {
        }
        FirebaseRemoteConfigValue firebaseRemoteConfigValue52 = firebaseRemoteConfigValue2;
        remoteSpec = LauncherBackgroundPolicy.INSTANCE.remoteSpec(firebaseRemoteConfigValue.asString(), firebaseRemoteConfigValue52.asString());
        String asString3 = firebaseRemoteConfigValue.asString();
        Intrinsics.checkNotNullExpressionValue(asString3, "asString(...)");
        Log.d(TAG, "syncRemoteAndStore: remotePath=[" + StringsKt.trim((CharSequence) asString3).toString() + "], source=" + sourceName(firebaseRemoteConfigValue.getSource()));
        String asString22 = firebaseRemoteConfigValue52.asString();
        Intrinsics.checkNotNullExpressionValue(asString22, "asString(...)");
        Log.d(TAG, "syncRemoteAndStore: remoteHash=[" + StringsKt.trim((CharSequence) asString22).toString() + "], source=" + sourceName(firebaseRemoteConfigValue52.getSource()));
        if (remoteSpec != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (r3.exists() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
        r3.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
        r0 = com.miami.game.core.design.system.component.background.LauncherBackgroundWriter.INSTANCE;
        r0.downloadToFile(r12, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
        if (r3.exists() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
        if (r3.length() <= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
        if (r0.isDecodableImage(r3) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
        r0 = r0.calculateFileHash(r3);
        android.util.Log.d(com.miami.game.core.design.system.component.background.LauncherBackgroundWriter.TAG, "downloadAndValidateWithRetry: downloadedHash=[" + r0 + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r7) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d6, code lost:
        throw new java.lang.IllegalStateException("Downloaded file hash mismatch".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e2, code lost:
        throw new java.lang.IllegalStateException("Downloaded file is not a supported image".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
        throw new java.lang.IllegalStateException("Downloaded file is empty".toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0127 -> B:55:0x015c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0144 -> B:54:0x0150). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadAndValidateWithRetry(List<String> list, File file, String str, Continuation<? super Boolean> continuation) {
        LauncherBackgroundWriter$downloadAndValidateWithRetry$1 launcherBackgroundWriter$downloadAndValidateWithRetry$1;
        int i;
        File file2;
        String str2;
        int i2;
        LauncherBackgroundWriter$downloadAndValidateWithRetry$1 launcherBackgroundWriter$downloadAndValidateWithRetry$12;
        int i3;
        List<String> list2;
        if (continuation instanceof LauncherBackgroundWriter$downloadAndValidateWithRetry$1) {
            launcherBackgroundWriter$downloadAndValidateWithRetry$1 = (LauncherBackgroundWriter$downloadAndValidateWithRetry$1) continuation;
            if ((launcherBackgroundWriter$downloadAndValidateWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                launcherBackgroundWriter$downloadAndValidateWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = launcherBackgroundWriter$downloadAndValidateWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = launcherBackgroundWriter$downloadAndValidateWithRetry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        Log.e(TAG, "downloadAndValidateWithRetry: no remote URL candidates");
                        return Boxing.boxBoolean(false);
                    }
                    file2 = file;
                    str2 = str;
                    i2 = 3;
                    launcherBackgroundWriter$downloadAndValidateWithRetry$12 = launcherBackgroundWriter$downloadAndValidateWithRetry$1;
                    i3 = 0;
                    list2 = list;
                    if (i3 < i2) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = launcherBackgroundWriter$downloadAndValidateWithRetry$1.I$2;
                    int i5 = launcherBackgroundWriter$downloadAndValidateWithRetry$1.I$1;
                    int i6 = launcherBackgroundWriter$downloadAndValidateWithRetry$1.I$0;
                    String str3 = (String) launcherBackgroundWriter$downloadAndValidateWithRetry$1.L$2;
                    File file3 = (File) launcherBackgroundWriter$downloadAndValidateWithRetry$1.L$1;
                    List<String> list3 = (List) launcherBackgroundWriter$downloadAndValidateWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    String str4 = str3;
                    launcherBackgroundWriter$downloadAndValidateWithRetry$12 = launcherBackgroundWriter$downloadAndValidateWithRetry$1;
                    list2 = list3;
                    i2 = i6;
                    str2 = str4;
                    File file4 = file3;
                    i3 = i5;
                    file2 = file4;
                    i3++;
                    if (i3 < i2) {
                        Iterator<String> it = list2.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            try {
                                break;
                            } catch (CancellationException e) {
                                file2.delete();
                                throw e;
                            } catch (Throwable th) {
                                Log.w(TAG, "downloadAndValidateWithRetry: attempt=" + (i3 + 1) + ", url=" + next + " failed: " + th.getMessage());
                                file2.delete();
                            }
                        }
                        if (i3 < 2) {
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.L$0 = list2;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.L$1 = file2;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.L$2 = str2;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.I$0 = i2;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.I$1 = i3;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.I$2 = i3;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12.label = 1;
                            if (DelayKt.delay((i3 + 1) * 750, launcherBackgroundWriter$downloadAndValidateWithRetry$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i7 = i2;
                            list3 = list2;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$1 = launcherBackgroundWriter$downloadAndValidateWithRetry$12;
                            str3 = str2;
                            i6 = i7;
                            int i8 = i3;
                            file3 = file2;
                            i5 = i8;
                            String str42 = str3;
                            launcherBackgroundWriter$downloadAndValidateWithRetry$12 = launcherBackgroundWriter$downloadAndValidateWithRetry$1;
                            list2 = list3;
                            i2 = i6;
                            str2 = str42;
                            File file42 = file3;
                            i3 = i5;
                            file2 = file42;
                        }
                        i3++;
                        if (i3 < i2) {
                            Log.e(TAG, "downloadAndValidateWithRetry: all attempts failed");
                            return Boxing.boxBoolean(false);
                        }
                    }
                }
            }
        }
        launcherBackgroundWriter$downloadAndValidateWithRetry$1 = new LauncherBackgroundWriter$downloadAndValidateWithRetry$1(this, continuation);
        Object obj2 = launcherBackgroundWriter$downloadAndValidateWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = launcherBackgroundWriter$downloadAndValidateWithRetry$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitNew(File file, ImageBitmap imageBitmap, Continuation<? super Unit> continuation) {
        MutableStateFlow<LauncherBackgroundState> mutableStateFlow = _state;
        int version = mutableStateFlow.getValue().getVersion() + 1;
        Log.d(TAG, "emitNew: version=" + version + ", file=" + (file != null ? file.getAbsolutePath() : null) + ", imageNull=" + (imageBitmap == null));
        return mutableStateFlow.emit(new LauncherBackgroundState(version, file, imageBitmap), continuation);
    }

    private final File ensureDir() {
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        File file = new File(context2.getFilesDir(), DIR_NAME);
        if (!file.exists()) {
            Log.d(TAG, "ensureDir: create dir=" + file.getAbsolutePath() + ", result=" + file.mkdirs());
            return file;
        }
        Log.d(TAG, "ensureDir: dir exists=" + file.getAbsolutePath());
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final File resolveLocalFile() {
        File file;
        String calculateFileHashOrEmpty;
        String str;
        File ensureValidDefaultFile = ensureValidDefaultFile();
        File ensureDir = ensureDir();
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString(PREF_CURRENT_FILE_NAME, null);
        SharedPreferences sharedPreferences2 = prefs;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences2 = null;
        }
        String string2 = sharedPreferences2.getString(PREF_CURRENT_FILE_HASH, null);
        String normalizeSha256 = LauncherBackgroundPolicy.INSTANCE.normalizeSha256(string2);
        if (string != null) {
            if (StringsKt.isBlank(string)) {
                string = null;
            }
            if (string != null) {
                file = new File(ensureDir, string);
                if (file != null && file.exists() && file.length() > 0 && isDecodableImage(file)) {
                    calculateFileHashOrEmpty = calculateFileHashOrEmpty(file);
                    if ((!Intrinsics.areEqual(file.getName(), "background_home.webp") || (str = string2) == null || StringsKt.isBlank(str) || Intrinsics.areEqual(normalizeSha256, calculateFileHashOrEmpty)) && !StringsKt.isBlank(calculateFileHashOrEmpty)) {
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        persistCurrentFile(name, calculateFileHashOrEmpty);
                        deleteStaleDownloadedFiles(file);
                        Log.d(TAG, "resolveLocalFile: use selected file=" + file.getAbsolutePath());
                        return file;
                    }
                    Log.w(TAG, "resolveLocalFile: selected file hash mismatch, stored=[" + string2 + "], actual=[" + calculateFileHashOrEmpty + "]");
                }
                if (file != null && file.exists() && !Intrinsics.areEqual(file.getName(), "background_home.webp")) {
                    Log.d(TAG, "resolveLocalFile: delete invalid current file result=" + file.delete());
                }
                if (ensureValidDefaultFile == null) {
                    String calculateFileHash = calculateFileHash(ensureValidDefaultFile);
                    String name2 = ensureValidDefaultFile.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    persistCurrentFile(name2, calculateFileHash);
                    deleteStaleDownloadedFiles(ensureValidDefaultFile);
                    Log.d(TAG, "resolveLocalFile: fallback default file=" + ensureValidDefaultFile.getAbsolutePath());
                    return ensureValidDefaultFile;
                }
                clearCurrentFile();
                deleteTemporaryFiles();
                Log.w(TAG, "resolveLocalFile: no file fallback; UI drawable remains active");
                return null;
            }
        }
        file = null;
        if (file != null) {
            calculateFileHashOrEmpty = calculateFileHashOrEmpty(file);
            if (!Intrinsics.areEqual(file.getName(), "background_home.webp")) {
            }
            String name3 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            persistCurrentFile(name3, calculateFileHashOrEmpty);
            deleteStaleDownloadedFiles(file);
            Log.d(TAG, "resolveLocalFile: use selected file=" + file.getAbsolutePath());
            return file;
        }
        if (file != null) {
            Log.d(TAG, "resolveLocalFile: delete invalid current file result=" + file.delete());
        }
        if (ensureValidDefaultFile == null) {
        }
    }

    private final File ensureValidDefaultFile() {
        File file = new File(ensureDir(), "background_home.webp");
        String calculateAssetHashOrNull = calculateAssetHashOrNull();
        if (calculateAssetHashOrNull == null) {
            boolean z = file.exists() && file.length() > 0 && isDecodableImage(file);
            Log.w(TAG, "ensureValidDefaultFile: asset=" + assetPath + " is absent, existingIsValid=" + z);
            if (z) {
                return file;
            }
            return null;
        } else if (!file.exists() || file.length() <= 0 || !isDecodableImage(file) || !Intrinsics.areEqual(calculateFileHashOrEmpty(file), calculateAssetHashOrNull)) {
            Log.d(TAG, "ensureValidDefaultFile: restore changed or invalid bundled asset");
            return forceRestoreDefaultFile(file, calculateAssetHashOrNull);
        } else {
            Log.d(TAG, "ensureValidDefaultFile: current default file matches bundled asset");
            return file;
        }
    }

    private final File forceRestoreDefaultFile(File file, String str) {
        Log.d(TAG, "forceRestoreDefaultFile: start file=" + file.getAbsolutePath());
        writeAssetToFileAtomically(file);
        String calculateFileHashOrEmpty = calculateFileHashOrEmpty(file);
        if (!file.exists() || file.length() <= 0 || !isDecodableImage(file) || !Intrinsics.areEqual(calculateFileHashOrEmpty, str)) {
            throw new IllegalStateException("Restored default background is not decodable".toString());
        }
        Log.d(TAG, "forceRestoreDefaultFile: restored file=" + file.getAbsolutePath());
        return file;
    }

    private final void deleteStaleDownloadedFiles(File file) {
        File[] listFiles = ensureDir().listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (!Intrinsics.areEqual(file2, file) && !Intrinsics.areEqual(file2.getName(), "background_home.webp")) {
                Log.d(TAG, "deleteStaleDownloadedFiles: file=" + file2.getAbsolutePath() + ", deleted=" + file2.delete());
            }
        }
    }

    private final void deleteTemporaryFiles() {
        File[] listFiles = ensureDir().listFiles();
        if (listFiles != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file : listFiles) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt.endsWith$default(name, ".tmp", false, 2, (Object) null)) {
                    arrayList.add(file);
                }
            }
            for (File file2 : arrayList) {
                Log.d(TAG, "deleteTemporaryFiles: file=" + file2.getAbsolutePath() + ", deleted=" + file2.delete());
            }
        }
    }

    private final void clearCurrentFile() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        Log.d(TAG, "clearCurrentFile: saved=" + sharedPreferences.edit().remove(PREF_CURRENT_FILE_NAME).remove(PREF_CURRENT_FILE_HASH).commit());
    }

    private final String calculateAssetHashOrNull() {
        try {
            Context context2 = context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            InputStream open = context2.getAssets().open(assetPath);
            String calculateHash = calculateHash(open);
            CloseableKt.closeFinally(open, null);
            return calculateHash;
        } catch (Throwable th) {
            Log.w(TAG, "calculateAssetHashOrNull: cannot open asset=" + assetPath + ": " + th.getMessage());
            return null;
        }
    }

    private final void writeAssetToFileAtomically(File file) {
        Log.d(TAG, "writeAssetToFileAtomically: target=" + file.getAbsolutePath());
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        if (file2.exists()) {
            Log.d(TAG, "writeAssetToFileAtomically: delete old tmp result=" + file2.delete());
        }
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        InputStream open = context2.getAssets().open(assetPath);
        try {
            InputStream inputStream = open;
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            Intrinsics.checkNotNull(inputStream);
            ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
            CloseableKt.closeFinally(open, null);
            Log.d(TAG, "writeAssetToFileAtomically: tmp written exists=" + file2.exists() + ", size=" + file2.length());
            if (file.exists()) {
                Log.d(TAG, "writeAssetToFileAtomically: delete old target result=" + file.delete());
            }
            boolean renameTo = file2.renameTo(file);
            Log.d(TAG, "writeAssetToFileAtomically: rename tmp->target result=" + renameTo);
            if (renameTo) {
                return;
            }
            file2.delete();
            throw new IllegalStateException("Failed to rename asset temp file".toString());
        } finally {
        }
    }

    private final List<String> buildRemoteUrls(String str) {
        if (StringsKt.startsWith(str, "http://", true) || StringsKt.startsWith(str, "https://", true)) {
            return CollectionsKt.listOf(str);
        }
        List projectResourceUrls$default = FirebaseConfigHelper.getProjectResourceUrls$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(projectResourceUrls$default, 10));
        Iterator it = projectResourceUrls$default.iterator();
        while (it.hasNext()) {
            arrayList.add(((String) it.next()) + StringsKt.removePrefix(str, (CharSequence) "/"));
        }
        return CollectionsKt.distinct(arrayList);
    }

    private final void downloadToFile(String str, File file) {
        Log.d(TAG, "downloadToFile: url=" + str);
        Log.d(TAG, "downloadToFile: dest=" + file.getAbsolutePath());
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        URLConnection openConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod(coil3.network.internal.UtilsKt.HTTP_METHOD_GET);
        try {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String contentType = httpURLConnection.getContentType();
            long contentLengthLong = httpURLConnection.getContentLengthLong();
            Log.d(TAG, "downloadToFile: responseCode=" + responseCode + ", contentType=" + contentType + ", contentLength=" + contentLengthLong);
            if (200 > responseCode || responseCode >= 300) {
                throw new IllegalStateException(("HTTP " + responseCode).toString());
            }
            if (contentLengthLong > MAX_BACKGROUND_BYTES) {
                throw new IllegalStateException(("Background is too large: " + contentLengthLong + " bytes").toString());
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStream inputStream2 = inputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                int read = inputStream2.read(bArr);
                if (read <= 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStream, null);
                    boolean exists = file.exists();
                    Log.d(TAG, "downloadToFile: finished destExists=" + exists + ", destSize=" + file.length());
                    return;
                }
                j += read;
                if (j > MAX_BACKGROUND_BYTES) {
                    throw new IllegalStateException("Background exceeded 20971520 bytes".toString());
                }
                fileOutputStream2.write(bArr, 0, read);
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private final boolean isDecodableImage(File file) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i2 = options.outWidth;
        z = (1 > i2 || i2 >= 8193 || 1 > (i = options.outHeight) || i >= 8193) ? false : false;
        Log.d(TAG, "isDecodableImage: file=" + file.getAbsolutePath() + ", outWidth=" + options.outWidth + ", outHeight=" + options.outHeight + ", result=" + z);
        return z;
    }

    private final void persistCurrentFile(String str, String str2) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        boolean commit = sharedPreferences.edit().putString(PREF_CURRENT_FILE_NAME, str).putString(PREF_CURRENT_FILE_HASH, str2).commit();
        Log.d(TAG, "persistCurrentFile: fileName=" + str + ", hash=[" + str2 + "], saved=" + commit);
        if (!commit) {
            throw new IllegalStateException("Failed to persist launcher background selection".toString());
        }
    }

    private final void logRemoteConfigInfo(String str, String str2) {
        FirebaseRemoteConfigInfo info = remoteConfigProvider.getInfo();
        Intrinsics.checkNotNullExpressionValue(info, "getInfo(...)");
        String fetchStatusName = fetchStatusName(info.getLastFetchStatus());
        long fetchTimeMillis = info.getFetchTimeMillis();
        Log.d(TAG, "remoteConfig: pathKey=" + str + ", hashKey=" + str2 + ", lastFetchStatus=" + fetchStatusName + ", fetchTimeMillis=" + fetchTimeMillis + ", minimumFetchIntervalSeconds=" + info.getConfigSettings().getMinimumFetchIntervalInSeconds());
    }

    private final String sourceName(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "remote";
                }
                return "unknown(" + i + ")";
            }
            return "default";
        }
        return "static";
    }

    private final String fetchStatusName(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return "throttled";
                    }
                    return "unknown(" + i + ")";
                }
                return "failure";
            }
            return "no_fetch_yet";
        }
        return FirebaseAnalytics.Param.SUCCESS;
    }

    private final String calculateFileHashOrEmpty(File file) {
        Object m9916constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            LauncherBackgroundWriter launcherBackgroundWriter = this;
            m9916constructorimpl = Result.m9916constructorimpl(calculateFileHash(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
        if (m9919exceptionOrNullimpl != null) {
            Log.e(TAG, "calculateFileHashOrEmpty: failed for " + file.getAbsolutePath(), m9919exceptionOrNullimpl);
        }
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
            m9916constructorimpl = "";
        }
        return (String) m9916constructorimpl;
    }

    private final String calculateFileHash(File file) {
        if (!file.exists() || file.length() <= 0) {
            throw new IllegalStateException(("Cannot hash missing or empty file: " + file.getAbsolutePath()).toString());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String calculateHash = calculateHash(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return calculateHash;
        } finally {
        }
    }

    private final String calculateHash(InputStream inputStream) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
            } else {
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LauncherBackgroundWriter.calculateHash$lambda$0(((Byte) obj).byteValue());
                    }
                }, 30, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence calculateHash$lambda$0(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
