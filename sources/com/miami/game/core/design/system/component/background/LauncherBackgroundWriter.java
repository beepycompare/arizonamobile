package com.miami.game.core.design.system.component.background;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%J\u0010\u0010)\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020%J \u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0082@¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020'H\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J\u0018\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020'H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u0010+\u001a\u00020'H\u0002J\u001a\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010+\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0002J \u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006?"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundWriter;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "DIR_NAME", "KEY_REMOTE", "KEY_REMOTE_RODINA", "PREF_CURRENT_FILE_NAME", "DEFAULT_ASSET_PATH", "DEFAULT_LOCAL_FILE_NAME", "context", "Landroid/content/Context;", "isArizona", "", "prefs", "Landroid/content/SharedPreferences;", "assetPath", "scope", "Lkotlinx/coroutines/CoroutineScope;", "remoteConfigProvider", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfigProvider", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setParams", "", TtmlNode.START, "maxSidePx", "", "currentTargetFile", "Ljava/io/File;", "loadLocal", "syncRemoteAndUpdate", "emitNew", "file", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Ljava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDir", "ensureDefaultExists", "writeAssetToFileAtomically", TypedValues.AttributesType.S_TARGET, "buildLocalFileName", "remotePath", "buildRemoteUrl", "downloadToFile", "urlString", "dest", "isDecodableImage", "decodeBitmapSafe", "Landroid/graphics/Bitmap;", "calculateInSampleSize", "w", CmcdData.STREAMING_FORMAT_HLS, "design-system"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LauncherBackgroundWriter {
    public static final int $stable;
    private static final String DEFAULT_ASSET_PATH = "background_home.webp";
    private static final String DEFAULT_LOCAL_FILE_NAME = "background_home.webp";
    private static final String DIR_NAME = "launcher_bg";
    private static final String KEY_REMOTE = "launcher_background";
    private static final String KEY_REMOTE_RODINA = "launcher_background_rodina";
    private static final String PREFS_NAME = "launcher_bg_prefs";
    private static final String PREF_CURRENT_FILE_NAME = "current_file_name";
    private static final String TAG = "LauncherBgWriter";
    private static final MutableStateFlow<LauncherBackgroundState> _state;
    private static Context context;
    private static boolean isArizona;
    private static SharedPreferences prefs;
    private static final FirebaseRemoteConfig remoteConfigProvider;
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

    public final void setParams(Context context2, boolean z) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        context = applicationContext;
        isArizona = z;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        prefs = sharedPreferences;
        Log.d(TAG, "setParams: isArizona=" + z);
        Context context3 = context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        Log.d(TAG, "setParams: filesDir=" + context3.getFilesDir().getAbsolutePath());
        start$default(this, 0, 1, null);
    }

    public static /* synthetic */ void start$default(LauncherBackgroundWriter launcherBackgroundWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3048;
        }
        launcherBackgroundWriter.start(i);
    }

    public final void start(int i) {
        Log.d(TAG, "start: maxSidePx=" + i);
        loadLocal(i);
        syncRemoteAndUpdate(i);
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

    public static /* synthetic */ void loadLocal$default(LauncherBackgroundWriter launcherBackgroundWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3048;
        }
        launcherBackgroundWriter.loadLocal(i);
    }

    public final void loadLocal(int i) {
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new LauncherBackgroundWriter$loadLocal$1(i, null), 2, null);
    }

    public static /* synthetic */ void syncRemoteAndUpdate$default(LauncherBackgroundWriter launcherBackgroundWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3048;
        }
        launcherBackgroundWriter.syncRemoteAndUpdate(i);
    }

    public final void syncRemoteAndUpdate(int i) {
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new LauncherBackgroundWriter$syncRemoteAndUpdate$1(i, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitNew(File file, ImageBitmap imageBitmap, Continuation<? super Unit> continuation) {
        MutableStateFlow<LauncherBackgroundState> mutableStateFlow = _state;
        int version = mutableStateFlow.getValue().getVersion() + 1;
        Log.d(TAG, "emitNew: version=" + version + ", file=" + file.getAbsolutePath() + ", imageNull=" + (imageBitmap == null));
        Object emit = mutableStateFlow.emit(new LauncherBackgroundState(version, file, imageBitmap), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File ensureDir() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureDefaultExists() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeAssetToFileAtomically(File file) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildLocalFileName(String str) {
        String str2;
        String str3;
        String substringAfterLast = StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(str, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null), '/', "background_home.webp");
        String str4 = StringsKt.isBlank(substringAfterLast) ? "background_home.webp" : substringAfterLast;
        String replace = new Regex("[^\\w.\\-]").replace(str4, "_");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) replace, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default >= 0) {
            str2 = replace.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
        } else {
            str2 = replace;
        }
        if (lastIndexOf$default >= 0) {
            str3 = replace.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
        } else {
            str3 = ".webp";
        }
        String str5 = str2 + "_" + UStringsKt.m10525toStringV7xB4Y4(UInt.m9283constructorimpl(str.hashCode()), 16) + str3;
        Log.d(TAG, "buildLocalFileName: remotePath=" + str + ", rawName=" + str4 + ", result=" + str5);
        return str5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildRemoteUrl(String str) {
        if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + (isArizona ? "projects/arizona-rp" : "projects/rodina-rp") + str;
        }
        Log.d(TAG, "buildRemoteUrl: result=" + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadToFile(String str, File file) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDecodableImage(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        z = (options.outWidth <= 0 || options.outHeight <= 0) ? false : false;
        String absolutePath = file.getAbsolutePath();
        Log.d(TAG, "isDecodableImage: file=" + absolutePath + ", outWidth=" + options.outWidth + ", outHeight=" + options.outHeight + ", result=" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap decodeBitmapSafe(File file, int i) {
        Log.d(TAG, "decodeBitmapSafe: file=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", size=" + file.length() + ", maxSidePx=" + i);
        if (!file.exists() || file.length() <= 0) {
            Log.e(TAG, "decodeBitmapSafe: file missing or empty");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        Log.d(TAG, "decodeBitmapSafe: bounds width=" + i2 + ", height=" + i3);
        if (i2 <= 0 || i3 <= 0) {
            Log.e(TAG, "decodeBitmapSafe: invalid bounds");
            return null;
        }
        int calculateInSampleSize = calculateInSampleSize(i2, i3, i);
        Log.d(TAG, "decodeBitmapSafe: sample=" + calculateInSampleSize);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = false;
        options2.inSampleSize = calculateInSampleSize;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
        boolean z = decodeFile == null;
        Log.d(TAG, "decodeBitmapSafe: bitmap decoded resultNull=" + z + ", finalWidth=" + (decodeFile != null ? Integer.valueOf(decodeFile.getWidth()) : null) + ", finalHeight=" + (decodeFile != null ? Integer.valueOf(decodeFile.getHeight()) : null));
        return decodeFile;
    }

    private final int calculateInSampleSize(int i, int i2, int i3) {
        int max = Math.max(i, i2);
        int i4 = 1;
        if (max <= i3) {
            Log.d(TAG, "calculateInSampleSize: maxSide=" + max + " <= maxSidePx=" + i3 + ", sample=1");
            return 1;
        }
        while (max / i4 > i3) {
            i4 *= 2;
        }
        Log.d(TAG, "calculateInSampleSize: width=" + i + ", height=" + i2 + ", maxSidePx=" + i3 + ", result=" + i4);
        return i4;
    }
}
