package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.network.internal.UtilsKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020%J\u0010\u0010'\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020%J \u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\"H\u0002J\u0018\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\"H\u0002J\u001a\u00104\u001a\u0004\u0018\u0001052\u0006\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J \u00106\u001a\u00020%2\u0006\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00069"}, d2 = {"LLauncherBackgroundWriter;", "", "<init>", "()V", "PREFS_NAME", "", "DIR_NAME", "TARGET_FILENAME", "KEY_REMOTE", "PREF_LAST_URL", "DEFAULT_ASSET_PATH", "context", "Landroid/content/Context;", "isArizona", "", "prefs", "Landroid/content/SharedPreferences;", "assetPath", "scope", "Lkotlinx/coroutines/CoroutineScope;", "remoteConfigProvider", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteConfigProvider", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "setParams", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "LLauncherBackgroundState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "targetFile", "Ljava/io/File;", "loadLocal", "maxSidePx", "", "syncRemoteAndUpdate", TtmlNode.START, "emitNew", "file", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Ljava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDefaultExists", "writeAssetToTargetAtomically", TypedValues.AttributesType.S_TARGET, "downloadToFile", "urlString", "dest", "isDecodableImage", "decodeBitmapSafe", "Landroid/graphics/Bitmap;", "calculateInSampleSize", "w", CmcdData.STREAMING_FORMAT_HLS, "design-system"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* renamed from: LauncherBackgroundWriter  reason: default package */
/* loaded from: classes2.dex */
public final class LauncherBackgroundWriter {
    public static final int $stable;
    private static final String DEFAULT_ASSET_PATH = "background_home.webp";
    private static final String DIR_NAME = "launcher_bg";
    private static final String KEY_REMOTE = "launcher_background";
    private static final String PREFS_NAME = "launcher_bg_prefs";
    private static final String PREF_LAST_URL = "last_url";
    private static final String TARGET_FILENAME = "background_home.webp";
    private static final MutableStateFlow<LauncherBackgroundState> _state;
    private static Context context;
    private static boolean isArizona;
    private static SharedPreferences prefs;
    private static final FirebaseRemoteConfig remoteConfigProvider;
    private static final CoroutineScope scope;
    private static final StateFlow<LauncherBackgroundState> state;
    public static final LauncherBackgroundWriter INSTANCE = new LauncherBackgroundWriter();
    private static final String assetPath = "background_home.webp";

    private LauncherBackgroundWriter() {
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        scope = CoroutineScope;
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseRemoteConfig, "getInstance(...)");
        remoteConfigProvider = firebaseRemoteConfig;
        MutableStateFlow<LauncherBackgroundState> MutableStateFlow = StateFlowKt.MutableStateFlow(new LauncherBackgroundState(0, null, null, 7, null));
        _state = MutableStateFlow;
        state = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), CoroutineScope, SharingStarted.Companion.getEagerly(), new LauncherBackgroundState(0, null, null, 7, null));
        $stable = 8;
    }

    public final FirebaseRemoteConfig getRemoteConfigProvider() {
        return remoteConfigProvider;
    }

    public final void setParams(Context context2, boolean z) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        isArizona = z;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        prefs = sharedPreferences;
        start$default(this, 0, 1, null);
    }

    public final StateFlow<LauncherBackgroundState> getState() {
        return state;
    }

    public final File targetFile() {
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        File file = new File(context2.getFilesDir(), DIR_NAME);
        file.mkdirs();
        return new File(file, "background_home.webp");
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

    public static /* synthetic */ void start$default(LauncherBackgroundWriter launcherBackgroundWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3048;
        }
        launcherBackgroundWriter.start(i);
    }

    public final void start(int i) {
        loadLocal(i);
        syncRemoteAndUpdate(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitNew(File file, ImageBitmap imageBitmap, Continuation<? super Unit> continuation) {
        MutableStateFlow<LauncherBackgroundState> mutableStateFlow = _state;
        Object emit = mutableStateFlow.emit(new LauncherBackgroundState(mutableStateFlow.getValue().getVersion() + 1, file, imageBitmap), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureDefaultExists() {
        File targetFile = targetFile();
        if (!targetFile.exists() || targetFile.length() <= 0) {
            writeAssetToTargetAtomically(targetFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeAssetToTargetAtomically(File file) {
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        if (file2.exists()) {
            file2.delete();
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
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadToFile(String str, File file) {
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
            httpURLConnection.disconnect();
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDecodableImage(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return options.outWidth > 0 && options.outHeight > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap decodeBitmapSafe(File file, int i) {
        if (file.exists() && file.length() > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 > 0 && i3 > 0) {
                int calculateInSampleSize = calculateInSampleSize(i2, i3, i);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = calculateInSampleSize;
                options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
            }
        }
        return null;
    }

    private final int calculateInSampleSize(int i, int i2, int i3) {
        int max = Math.max(i, i2);
        int i4 = 1;
        if (max <= i3) {
            return 1;
        }
        while (max / i4 > i3) {
            i4 *= 2;
        }
        return i4;
    }
}
