package com.miami.game.core.design.system.component.background;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020'H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020'H\u0082@¢\u0006\u0002\u0010,J \u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u000101H\u0082@¢\u0006\u0002\u00102J\b\u00103\u001a\u00020*H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020*H\u0002J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020*H\u0002J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010/\u001a\u00020*H\u0002J\u0018\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005H\u0002J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010/\u001a\u00020*H\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010/\u001a\u00020*H\u0002J\u0012\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006I"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundWriter;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "DIR_NAME", "KEY_REMOTE", "KEY_REMOTE_RODINA", "KEY_REMOTE_HASH", "KEY_REMOTE_HASH_RODINA", "PREF_CURRENT_FILE_NAME", "PREF_CURRENT_FILE_HASH", "DEFAULT_ASSET_PATH", "DEFAULT_LOCAL_FILE_NAME", "context", "Landroid/content/Context;", "isArizona", "", "prefs", "Landroid/content/SharedPreferences;", "assetPath", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startJob", "Lkotlinx/coroutines/Job;", "remoteConfigProvider", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfigProvider", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setParams", "", TtmlNode.START, "currentTargetFile", "Ljava/io/File;", "loadLocal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncRemoteAndStore", "emitNew", "file", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Ljava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDir", "ensureDefaultExists", "resolveLocalFile", "ensureValidDefaultFile", "forceRestoreDefaultFile", "writeAssetToFileAtomically", TypedValues.AttributesType.S_TARGET, "buildLocalFileName", "remotePath", "remoteHash", "buildRemoteUrl", "downloadToFile", "urlString", "dest", "isDecodableImage", "persistCurrentFile", "fileName", "fileHash", "calculateFileHashOrEmpty", "calculateFileHash", "normalizeHash", "rawHash", "design-system"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LauncherBackgroundWriter {
    public static final int $stable;
    private static final String DEFAULT_ASSET_PATH = "background_home.webp";
    private static final String DEFAULT_LOCAL_FILE_NAME = "background_home.webp";
    private static final String DIR_NAME = "launcher_bg";
    private static final String KEY_REMOTE = "launcher_background";
    private static final String KEY_REMOTE_HASH = "launcher_background_hash";
    private static final String KEY_REMOTE_HASH_RODINA = "launcher_background_hash_rodina";
    private static final String KEY_REMOTE_RODINA = "launcher_background_rodina";
    private static final String PREFS_NAME = "launcher_bg_prefs";
    private static final String PREF_CURRENT_FILE_HASH = "current_file_hash";
    private static final String PREF_CURRENT_FILE_NAME = "current_file_name";
    private static final String TAG = "LauncherBgWriter";
    private static final MutableStateFlow<LauncherBackgroundState> _state;
    private static Context context;
    private static boolean isArizona;
    private static SharedPreferences prefs;
    private static final FirebaseRemoteConfig remoteConfigProvider;
    private static Job startJob;
    private static final StateFlow<LauncherBackgroundState> state;
    public static final LauncherBackgroundWriter INSTANCE = new LauncherBackgroundWriter();
    private static final String assetPath = "background_home.webp";
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    private LauncherBackgroundWriter() {
    }

    static {
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        remoteConfigProvider = firebaseRemoteConfig;
        MutableStateFlow<LauncherBackgroundState> MutableStateFlow = StateFlowKt.MutableStateFlow(new LauncherBackgroundState(0, null, null, 7, null));
        _state = MutableStateFlow;
        state = FlowKt.asStateFlow(MutableStateFlow);
        $stable = 8;
    }

    public final FirebaseRemoteConfig getRemoteConfigProvider() {
        return remoteConfigProvider;
    }

    public final StateFlow<LauncherBackgroundState> getState() {
        return state;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setParams(Context context2, boolean z) {
        boolean z2;
        Context context3;
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Context context4 = context;
        Context context5 = null;
        if (context4 != null) {
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context4 = null;
            }
            if (context4 == applicationContext && isArizona == z) {
                z2 = false;
                Intrinsics.checkNotNull(applicationContext);
                context = applicationContext;
                isArizona = z;
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(PREFS_NAME, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
                prefs = sharedPreferences;
                Log.d(TAG, "setParams: isArizona=" + z);
                context3 = context;
                if (context3 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context5 = context3;
                }
                Log.d(TAG, "setParams: filesDir=" + context5.getFilesDir().getAbsolutePath());
                if (z2) {
                    Log.d(TAG, "setParams: already initialized with same params, skip restart");
                    return;
                } else {
                    start();
                    return;
                }
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
        if (context3 != null) {
        }
        Log.d(TAG, "setParams: filesDir=" + context5.getFilesDir().getAbsolutePath());
        if (z2) {
        }
    }

    public final synchronized void start() {
        Job launch$default;
        Log.d(TAG, TtmlNode.START);
        Job job = startJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new LauncherBackgroundWriter$start$1(null), 3, null);
        startJob = launch$default;
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
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(5:11|12|13|14|(1:16))(2:20|21))(2:22|23))(3:24|25|(1:27))|17|18))|30|6|7|(0)(0)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cc, code lost:
        r11 = kotlin.Result.Companion;
        r10 = kotlin.Result.m9183constructorimpl(kotlin.ResultKt.createFailure(r10));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
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
                    Log.d(TAG, "loadLocal: emit file=" + resolveLocalFile.getAbsolutePath());
                    launcherBackgroundWriter$loadLocal$1.L$0 = SpillingKt.nullOutSpilledVariable(resolveLocalFile);
                    launcherBackgroundWriter$loadLocal$1.label = 1;
                    if (emitNew(resolveLocalFile, null, launcherBackgroundWriter$loadLocal$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    File file = (File) launcherBackgroundWriter$loadLocal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = launcherBackgroundWriter$loadLocal$1.I$0;
                    File file2 = (File) launcherBackgroundWriter$loadLocal$1.L$2;
                    LauncherBackgroundWriter launcherBackgroundWriter = (LauncherBackgroundWriter) launcherBackgroundWriter$loadLocal$1.L$1;
                    Throwable th = (Throwable) launcherBackgroundWriter$loadLocal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object m9183constructorimpl = Result.m9183constructorimpl(Unit.INSTANCE);
                    Throwable m9186exceptionOrNullimpl = Result.m9186exceptionOrNullimpl(m9183constructorimpl);
                    if (m9186exceptionOrNullimpl != null) {
                        Log.e(TAG, "loadLocal: emergency fallback failed", m9186exceptionOrNullimpl);
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
    public final Object syncRemoteAndStore(Continuation<? super Unit> continuation) {
        String obj;
        String normalizeHash;
        try {
            Log.d(TAG, "syncRemoteAndStore: start");
            ensureDefaultExists();
            boolean z = isArizona;
            String str = z ? KEY_REMOTE : KEY_REMOTE_RODINA;
            String str2 = z ? KEY_REMOTE_HASH : KEY_REMOTE_HASH_RODINA;
            FirebaseRemoteConfig firebaseRemoteConfig = remoteConfigProvider;
            String string = firebaseRemoteConfig.getString(str);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            obj = StringsKt.trim((CharSequence) string).toString();
            normalizeHash = normalizeHash(firebaseRemoteConfig.getString(str2));
            Log.d(TAG, "syncRemoteAndStore: remotePath=[" + obj + "]");
            Log.d(TAG, "syncRemoteAndStore: remoteHash=[" + normalizeHash + "]");
        } catch (Throwable th) {
            Log.e(TAG, "syncRemoteAndStore: fatal error", th);
        }
        if (obj.length() == 0) {
            Log.e(TAG, "syncRemoteAndStore: remotePath is empty, skip");
            return Unit.INSTANCE;
        } else if (StringsKt.isBlank(normalizeHash)) {
            Log.e(TAG, "syncRemoteAndStore: remoteHash is empty, skip");
            return Unit.INSTANCE;
        } else {
            File ensureDir = ensureDir();
            File currentTargetFile = currentTargetFile();
            SharedPreferences sharedPreferences = prefs;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                sharedPreferences = null;
            }
            String normalizeHash2 = normalizeHash(sharedPreferences.getString(PREF_CURRENT_FILE_HASH, null));
            if (StringsKt.isBlank(normalizeHash2)) {
                normalizeHash2 = INSTANCE.calculateFileHashOrEmpty(currentTargetFile);
            }
            String str3 = normalizeHash2;
            Log.d(TAG, "syncRemoteAndStore: currentFile=" + currentTargetFile.getAbsolutePath());
            Log.d(TAG, "syncRemoteAndStore: currentHash=[" + str3 + "]");
            if (currentTargetFile.exists() && currentTargetFile.length() > 0 && StringsKt.equals(str3, normalizeHash, true)) {
                Log.d(TAG, "syncRemoteAndStore: current file already matches remote hash, skip download");
                String name = currentTargetFile.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                persistCurrentFile(name, str3);
                return Unit.INSTANCE;
            }
            String buildRemoteUrl = buildRemoteUrl(obj);
            File file = new File(ensureDir, buildLocalFileName(obj, normalizeHash));
            File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
            Log.d(TAG, "syncRemoteAndStore: fullUrl=" + buildRemoteUrl);
            Log.d(TAG, "syncRemoteAndStore: target=" + file.getAbsolutePath());
            Log.d(TAG, "syncRemoteAndStore: tmp=" + file2.getAbsolutePath());
            Result.Companion companion = Result.Companion;
            LauncherBackgroundWriter launcherBackgroundWriter = this;
            if (file2.exists()) {
                Log.d(TAG, "syncRemoteAndStore: delete old tmp result=" + file2.delete());
            }
            downloadToFile(buildRemoteUrl, file2);
            if (!file2.exists() || file2.length() <= 0) {
                throw new IllegalStateException("Downloaded file is empty".toString());
            }
            if (!isDecodableImage(file2)) {
                throw new IllegalStateException("Downloaded file is not decodable image".toString());
            }
            String calculateFileHash = calculateFileHash(file2);
            Log.d(TAG, "syncRemoteAndStore: downloadedHash=[" + calculateFileHash + "]");
            if (!StringsKt.equals(calculateFileHash, normalizeHash, true)) {
                throw new IllegalStateException("Downloaded file hash mismatch".toString());
            }
            if (currentTargetFile.exists() && currentTargetFile.length() > 0 && StringsKt.equals(calculateFileHashOrEmpty(currentTargetFile), calculateFileHash, true)) {
                Log.d(TAG, "syncRemoteAndStore: downloaded file equals current content, refresh prefs only");
                String name2 = currentTargetFile.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                persistCurrentFile(name2, calculateFileHash);
                file2.delete();
                return Unit.INSTANCE;
            }
            if (file.exists()) {
                Log.d(TAG, "syncRemoteAndStore: delete old target result=" + file.delete());
            }
            boolean renameTo = file2.renameTo(file);
            Log.d(TAG, "syncRemoteAndStore: rename tmp->target result=" + renameTo);
            if (!renameTo) {
                throw new IllegalStateException("Rename failed".toString());
            }
            String name3 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            persistCurrentFile(name3, calculateFileHash);
            if (currentTargetFile.exists() && !Intrinsics.areEqual(currentTargetFile.getName(), "background_home.webp") && !Intrinsics.areEqual(currentTargetFile.getName(), file.getName())) {
                Log.d(TAG, "syncRemoteAndStore: delete old current file result=" + currentTargetFile.delete());
            }
            Throwable m9186exceptionOrNullimpl = Result.m9186exceptionOrNullimpl(Result.m9183constructorimpl(Unit.INSTANCE));
            if (m9186exceptionOrNullimpl != null) {
                Log.e(TAG, "syncRemoteAndStore: update failed", m9186exceptionOrNullimpl);
                if (file2.exists()) {
                    Log.d(TAG, "syncRemoteAndStore: tmp delete after fail result=" + file2.delete());
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitNew(File file, ImageBitmap imageBitmap, Continuation<? super Unit> continuation) {
        MutableStateFlow<LauncherBackgroundState> mutableStateFlow = _state;
        int version = mutableStateFlow.getValue().getVersion() + 1;
        Log.d(TAG, "emitNew: version=" + version + ", file=" + file.getAbsolutePath() + ", imageNull=" + (imageBitmap == null));
        Object emit = mutableStateFlow.emit(new LauncherBackgroundState(version, file, imageBitmap), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
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

    private final void ensureDefaultExists() {
        File file = new File(ensureDir(), "background_home.webp");
        String absolutePath = file.getAbsolutePath();
        boolean exists = file.exists();
        Log.d(TAG, "ensureDefaultExists: defaultFile=" + absolutePath + ", exists=" + exists + ", size=" + file.length());
        if (!file.exists() || file.length() <= 0) {
            Log.d(TAG, "ensureDefaultExists: writing default asset");
            writeAssetToFileAtomically(file);
            return;
        }
        Log.d(TAG, "ensureDefaultExists: default already exists");
    }

    private final File resolveLocalFile() {
        File ensureValidDefaultFile = ensureValidDefaultFile();
        File currentTargetFile = currentTargetFile();
        if (currentTargetFile.exists() && currentTargetFile.length() > 0 && isDecodableImage(currentTargetFile)) {
            Log.d(TAG, "resolveLocalFile: use current file=" + currentTargetFile.getAbsolutePath());
            return currentTargetFile;
        }
        if (currentTargetFile.exists() && !Intrinsics.areEqual(currentTargetFile.getName(), "background_home.webp")) {
            Log.d(TAG, "resolveLocalFile: delete invalid current file result=" + currentTargetFile.delete());
        }
        String name = ensureValidDefaultFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        persistCurrentFile(name, calculateFileHashOrEmpty(ensureValidDefaultFile));
        Log.d(TAG, "resolveLocalFile: fallback default file=" + ensureValidDefaultFile.getAbsolutePath());
        return ensureValidDefaultFile;
    }

    private final File ensureValidDefaultFile() {
        File file = new File(ensureDir(), "background_home.webp");
        if (file.exists() && file.length() > 0 && isDecodableImage(file)) {
            Log.d(TAG, "ensureValidDefaultFile: current default file is valid");
            return file;
        }
        Log.d(TAG, "ensureValidDefaultFile: current default file invalid, restoring from assets");
        return forceRestoreDefaultFile();
    }

    private final File forceRestoreDefaultFile() {
        File file = new File(ensureDir(), "background_home.webp");
        Log.d(TAG, "forceRestoreDefaultFile: start file=" + file.getAbsolutePath());
        writeAssetToFileAtomically(file);
        if (!file.exists() || file.length() <= 0 || !isDecodableImage(file)) {
            throw new IllegalStateException("Restored default background is not decodable".toString());
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        persistCurrentFile(name, calculateFileHash(file));
        Log.d(TAG, "forceRestoreDefaultFile: restored file=" + file.getAbsolutePath());
        return file;
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

    private final String buildLocalFileName(String str, String str2) {
        String str3;
        String str4;
        String substringAfterLast = StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(str, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null), '/', "background_home.webp");
        String str5 = StringsKt.isBlank(substringAfterLast) ? "background_home.webp" : substringAfterLast;
        String replace = new Regex("[^\\w.\\-]").replace(str5, "_");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) replace, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default >= 0) {
            str3 = replace.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
        } else {
            str3 = replace;
        }
        if (lastIndexOf$default >= 0) {
            str4 = replace.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
        } else {
            str4 = ".webp";
        }
        String normalizeHash = normalizeHash(str2);
        if (StringsKt.isBlank(normalizeHash)) {
            normalizeHash = UStringsKt.m10525toStringV7xB4Y4(UInt.m9283constructorimpl(str.hashCode()), 16);
        }
        String str6 = str3 + "_" + StringsKt.take(normalizeHash, 16) + str4;
        Log.d(TAG, "buildLocalFileName: remotePath=" + str + ", rawName=" + str5 + ", result=" + str6);
        return str6;
    }

    private final String buildRemoteUrl(String str) {
        if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + (isArizona ? "projects/arizona-rp" : "projects/rodina-rp") + str;
        }
        Log.d(TAG, "buildRemoteUrl: result=" + str);
        return str;
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
        httpURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String contentType = httpURLConnection.getContentType();
        Log.d(TAG, "downloadToFile: responseCode=" + responseCode + ", contentType=" + contentType + ", contentLength=" + httpURLConnection.getContentLengthLong());
        if (200 > responseCode || responseCode >= 300) {
            httpURLConnection.disconnect();
            throw new IllegalStateException(("HTTP " + responseCode).toString());
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            InputStream inputStream2 = inputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Intrinsics.checkNotNull(inputStream2);
            ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
            CloseableKt.closeFinally(inputStream, null);
            boolean exists = file.exists();
            Log.d(TAG, "downloadToFile: finished destExists=" + exists + ", destSize=" + file.length());
            httpURLConnection.disconnect();
        } finally {
        }
    }

    private final boolean isDecodableImage(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        z = (options.outWidth <= 0 || options.outHeight <= 0) ? false : false;
        String absolutePath = file.getAbsolutePath();
        Log.d(TAG, "isDecodableImage: file=" + absolutePath + ", outWidth=" + options.outWidth + ", outHeight=" + options.outHeight + ", result=" + z);
        return z;
    }

    private final void persistCurrentFile(String str, String str2) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        Log.d(TAG, "persistCurrentFile: fileName=" + str + ", hash=[" + str2 + "], saved=" + sharedPreferences.edit().putString(PREF_CURRENT_FILE_NAME, str).putString(PREF_CURRENT_FILE_HASH, str2).commit());
    }

    private final String calculateFileHashOrEmpty(File file) {
        Object m9183constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            LauncherBackgroundWriter launcherBackgroundWriter = this;
            m9183constructorimpl = Result.m9183constructorimpl(calculateFileHash(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9183constructorimpl = Result.m9183constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9186exceptionOrNullimpl = Result.m9186exceptionOrNullimpl(m9183constructorimpl);
        if (m9186exceptionOrNullimpl != null) {
            Log.e(TAG, "calculateFileHashOrEmpty: failed for " + file.getAbsolutePath(), m9186exceptionOrNullimpl);
        }
        if (Result.m9189isFailureimpl(m9183constructorimpl)) {
            m9183constructorimpl = "";
        }
        return (String) m9183constructorimpl;
    }

    private final String calculateFileHash(File file) {
        if (!file.exists() || file.length() <= 0) {
            throw new IllegalStateException(("Cannot hash missing or empty file: " + file.getAbsolutePath()).toString());
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream2.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    byte[] digest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                    return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LauncherBackgroundWriter.calculateFileHash$lambda$1(((Byte) obj).byteValue());
                        }
                    }, 30, (Object) null);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence calculateFileHash$lambda$1(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String normalizeHash(String str) {
        String str2;
        String obj;
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null) {
            String lowerCase = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                str2 = new Regex("[^0-9a-f]").replace(lowerCase, "");
                return str2 != null ? "" : str2;
            }
        }
        str2 = null;
        if (str2 != null) {
        }
    }
}
