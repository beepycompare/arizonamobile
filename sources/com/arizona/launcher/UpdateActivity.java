package com.arizona.launcher;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RendererCapabilities;
import coil3.util.UtilsKt;
import com.arizona.game.R;
import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.apk.LauncherVersionPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageEstimatorKt;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageRequirementsSnapshot;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceCheckResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageSpaceChecker;
import com.arkivanov.decompose.RetainedComponentKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiState;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogType;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiState;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.home.ui.model.HomeExternalUiState;
import com.miami.game.feature.home.ui.model.HomeExternalUiStateHolder;
import com.miami.game.ui.download.screen.DownloadScreenRouteKt;
import com.miami.game.ui.theme.ThemeKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: UpdateActivity.kt */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001V\b\u0007\u0018\u0000 \u007f2\u00020\u0001:\u0003\u007f\u0080\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0015b\u0010\b)\u0012\f\b*\u0012\b\b\fJ\u0004\b\b(+J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020(H\u0014J\b\u0010.\u001a\u00020&H\u0014J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u000fH\u0002J\b\u00104\u001a\u00020&H\u0014J\b\u00105\u001a\u00020&H\u0002J(\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u000fH\u0002J7\u0010;\u001a\u00020&2\u0006\u00107\u001a\u00020\u00172\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010:\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J3\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u00172\b\u00109\u001a\u0004\u0018\u00010\u00172\u0006\u0010:\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010@J\u0019\u0010A\u001a\u0004\u0018\u00010\u00172\b\u0010B\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0017H\u0002J\"\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020JH\u0003b\u0010\b)\u0012\f\b*\u0012\b\b\fJ\u0004\b\b(KJ\u0010\u0010L\u001a\u00020&2\u0006\u0010I\u001a\u00020JH\u0002J\f\u0010M\u001a\u00020N*\u00020OH\u0002J\b\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u00020&H\u0002J\b\u0010R\u001a\u00020\u000fH\u0002J\b\u0010S\u001a\u00020&H\u0002J\b\u0010T\u001a\u00020&H\u0002J\b\u0010X\u001a\u00020&H\u0002J\b\u0010Y\u001a\u00020&H\u0002J\b\u0010Z\u001a\u00020&H\u0002J\b\u0010[\u001a\u00020&H\u0002J\b\u0010\\\u001a\u00020\u000fH\u0002J\b\u0010]\u001a\u00020\u0005H\u0002J\u0012\u0010^\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010_\u001a\u00020&2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u000fH\u0002J\b\u0010c\u001a\u00020&H\u0002J\b\u0010d\u001a\u00020&H\u0002J\b\u0010e\u001a\u00020&H\u0002J\u0010\u0010f\u001a\u00020&2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020&2\u0006\u0010j\u001a\u00020NH\u0002J\b\u0010k\u001a\u00020&H\u0002J\b\u0010l\u001a\u00020&H\u0002J\b\u0010m\u001a\u00020&H\u0002J\b\u0010n\u001a\u00020&H\u0002J\u0018\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020N2\u0006\u0010q\u001a\u00020NH\u0002J\b\u0010r\u001a\u00020&H\u0002J\b\u0010s\u001a\u00020&H\u0002J\b\u0010t\u001a\u00020&H\u0002J\n\u0010u\u001a\u0004\u0018\u00010hH\u0002J\u001c\u0010v\u001a\u00020a2\b\u0010g\u001a\u0004\u0018\u00010h2\b\b\u0002\u0010w\u001a\u00020\u000fH\u0002J\b\u0010x\u001a\u00020&H\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020hH\u0002J\u0010\u0010|\u001a\u00020\u00172\u0006\u0010}\u001a\u00020zH\u0002J\n\u0010~\u001a\u0004\u0018\u00010zH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u0092\u0002\u0002\b$¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WÊ\u0001\u0003\b\u0082\u0001Ê\u0001\u000e\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0081\u0001"}, d2 = {"Lcom/arizona/launcher/UpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "tag", "", "kotlin.jvm.PlatformType", "mService", "Landroid/os/Messenger;", "mMessenger", "archiveStorageSpaceChecker", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceChecker;", "exoplayer", "Landroidx/media3/exoplayer/ExoPlayer;", "mUpdateServiceBound", "", "mUpdateMode", "Lcom/arizona/launcher/UpdateMode;", "mIsStartingUpdate", "launcherApkUiPhase", "Lcom/arizona/launcher/LauncherApkUiPhase;", "launcherReadyFileName", "launcherReadyFileLength", "", "launcherReadyLastModified", "autoLaunchLauncherInstaller", "launcherInstallLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "unknownSourcesLauncher", "rootFactory", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "getRootFactory", "()Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "setRootFactory", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;)V", "Ljavax/inject/Inject;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Landroid/annotation/SuppressLint;", "value", "SourceLockedOrientationActivity", "onSaveInstanceState", "outState", "onResume", "onWindowFocusChanged", "hasFocus", "restoreLauncherApkDialogIfNeeded", "startUpdateService", "bindUpdateService", "onDestroy", "startDownloadLauncherUpdate", "checkFreeSpace", "combinedBytes", "gameBytes", "downloadBytes", "sameStorageDevice", "showInsufficientSpaceDialog", "(JLjava/lang/Long;Ljava/lang/Long;Z)V", "showStorageInspectionFailedDialog", "retryStoragePrecheck", "insufficientSpaceDescription", "(JLjava/lang/Long;Ljava/lang/Long;Z)Ljava/lang/String;", "requiredBytesForDisplay", "requiredBytes", "(Ljava/lang/Long;)Ljava/lang/Long;", "showForegroundServiceUnavailableDialog", "retryCurrentOperation", "convertBytesToHumanReadable", "bytes", "updateViewInformation", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "SetTextI18n", "updateArchiveViewInformation", "labelRes", "", "Lcom/arizona/launcher/ArchiveProgressPresentation;", "requestUpdateGameData", "requestReUpdateGameData", "isOnline", "setUpdateServiceAsBackground", "resetProgress", "mConnection", "com/arizona/launcher/UpdateActivity$mConnection$1", "Lcom/arizona/launcher/UpdateActivity$mConnection$1;", "requestUpdateInfo", "requestUpdateStatus", "showDialog", "hideDialog", "shouldStartLauncherTransport", "expectedLauncherApkFileName", "restoreLauncherApkState", "applyPersistedLauncherApkInspection", "inspection", "Lcom/arizona/launcher/PersistedLauncherApkInspection;", "awaitingUnknownSources", "markLauncherApkProgressComplete", "onLauncherApkDownloadSucceeded", "proceedLauncherInstall", "launchLauncherInstaller", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "handleLauncherInstallResult", "resultCode", "handleUnknownSourcesResult", "showLauncherInstallRetryDialog", "showLauncherApkInvalidPackageDialog", "showLauncherApkConnectionErrorDialog", "showLauncherApkStorageDialog", "titleRes", "descriptionRes", "retryLauncherApkDownload", "recoverLauncherApkDownload", "clearLauncherApkReadyState", "launcherReadyApkFile", "inspectPersistedLauncherApk", "allowAlreadyInstalled", "returnToNormalLauncherEntry", "packageArchiveInfo", "Landroid/content/pm/PackageInfo;", "apk", "packageVersionCode", "info", "installedPackageInfo", "Companion", "IncomingHandler", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateActivity extends Hilt_UpdateActivity {
    private static final String STATE_LAUNCHER_APK_LENGTH = "launcher_apk_length";
    private static final String STATE_LAUNCHER_APK_MODIFIED = "launcher_apk_modified";
    private static final String STATE_LAUNCHER_APK_NAME = "launcher_apk_name";
    private static final String STATE_LAUNCHER_APK_PHASE = "launcher_apk_phase";
    public static final String UPDATE_MODE = "mode";
    private boolean autoLaunchLauncherInstaller;
    private ExoPlayer exoplayer;
    private String launcherReadyFileName;
    private boolean mIsStartingUpdate;
    private Messenger mService;
    private boolean mUpdateServiceBound;
    @Inject
    public DownloadScreenComponent.Factory rootFactory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final byte[] APK_ZIP_MAGIC = {80, 75, 3, 4};
    private final String tag = UpdateActivity.class.getCanonicalName();
    private final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private final ArchiveStorageSpaceChecker archiveStorageSpaceChecker = ArchiveStorageSpaceChecker.Companion.android(new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return UpdateActivity.archiveStorageSpaceChecker$lambda$0(UpdateActivity.this, (String) obj, (Exception) obj2);
        }
    });
    private UpdateMode mUpdateMode = UpdateMode.Undefined;
    private LauncherApkUiPhase launcherApkUiPhase = LauncherApkUiPhase.Idle;
    private long launcherReadyFileLength = -1;
    private long launcherReadyLastModified = -1;
    private final ActivityResultLauncher<Intent> launcherInstallLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda17
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            UpdateActivity.launcherInstallLauncher$lambda$0(UpdateActivity.this, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<Intent> unknownSourcesLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda18
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            UpdateActivity.unknownSourcesLauncher$lambda$0(UpdateActivity.this, (ActivityResult) obj);
        }
    });
    private final UpdateActivity$mConnection$1 mConnection = new ServiceConnection() { // from class: com.arizona.launcher.UpdateActivity$mConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            UpdateMode updateMode;
            UpdateMode updateMode2;
            DownloadExternalUiState value;
            boolean shouldStartLauncherTransport;
            String str;
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(service, "service");
            UpdateActivity.this.mService = new Messenger(service);
            updateMode = UpdateActivity.this.mUpdateMode;
            UpdateMode updateMode3 = UpdateMode.GameUpdate;
            UpdateActivity updateActivity = UpdateActivity.this;
            if (updateMode == updateMode3) {
                updateActivity.requestUpdateInfo();
                return;
            }
            updateMode2 = updateActivity.mUpdateMode;
            if (updateMode2 == UpdateMode.LauncherUpdate) {
                MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                    value = stateStore.getValue();
                } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, true, 255, null)));
                shouldStartLauncherTransport = UpdateActivity.this.shouldStartLauncherTransport();
                UpdateActivity updateActivity2 = UpdateActivity.this;
                if (shouldStartLauncherTransport) {
                    updateActivity2.launcherApkUiPhase = LauncherApkUiPhase.Downloading;
                    UpdateActivity.this.startDownloadLauncherUpdate();
                    return;
                }
                str = updateActivity2.tag;
                Log.i(str, "Launcher APK ready or installing; skipping transport restart");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            UpdateActivity.this.mService = null;
            UpdateActivity.this.mUpdateServiceBound = false;
        }
    };

    /* compiled from: UpdateActivity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ArchiveStorageSpaceCheckResult.values().length];
            try {
                iArr[ArchiveStorageSpaceCheckResult.ENOUGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveStorageSpaceCheckResult.INSUFFICIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveStorageSpaceCheckResult.UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ArchiveProgressPresentation.values().length];
            try {
                iArr2[ArchiveProgressPresentation.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ArchiveProgressPresentation.WAITING_FOR_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ArchiveProgressPresentation.VERIFYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ArchiveProgressPresentation.EXTRACTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ArchiveProgressPresentation.INSTALLING.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PersistedLauncherApkInspection.values().length];
            try {
                iArr3[PersistedLauncherApkInspection.MissingOrChanged.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[PersistedLauncherApkInspection.AlreadyInstalled.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[PersistedLauncherApkInspection.Invalid.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[PersistedLauncherApkInspection.Ready.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit archiveStorageSpaceChecker$lambda$0(UpdateActivity updateActivity, String message, Exception error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        Log.e(updateActivity.tag, message, error);
        return Unit.INSTANCE;
    }

    /* compiled from: UpdateActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$Companion;", "", "<init>", "()V", "UPDATE_MODE", "", "STATE_LAUNCHER_APK_PHASE", "STATE_LAUNCHER_APK_NAME", "STATE_LAUNCHER_APK_LENGTH", "STATE_LAUNCHER_APK_MODIFIED", "APK_ZIP_MAGIC", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void launcherInstallLauncher$lambda$0(UpdateActivity updateActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        updateActivity.handleLauncherInstallResult(result.getResultCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void unknownSourcesLauncher$lambda$0(UpdateActivity updateActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        updateActivity.handleUnknownSourcesResult();
    }

    public final DownloadScreenComponent.Factory getRootFactory() {
        DownloadScreenComponent.Factory factory = this.rootFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootFactory");
        return null;
    }

    public final void setRootFactory(DownloadScreenComponent.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.rootFactory = factory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arizona.launcher.Hilt_UpdateActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        UpdateMode updateMode;
        super.onCreate(bundle);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        UpdateActivity updateActivity = this;
        final DownloadScreenComponent downloadScreenComponent = (DownloadScreenComponent) RetainedComponentKt.retainedComponent$default((ComponentActivity) updateActivity, (String) null, false, false, (Function0) null, (Function1) new UpdateActivity$onCreate$root$1(getRootFactory()), 15, (Object) null);
        EdgeToEdge.enable$default(updateActivity, null, null, 3, null);
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
        getWindow().addFlags(128);
        ComponentActivityKt.setContent$default(updateActivity, null, ComposableLambdaKt.composableLambdaInstance(-1020785817, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UpdateActivity.onCreate$lambda$0(DownloadScreenComponent.this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        String stringExtra = getIntent().getStringExtra(UPDATE_MODE);
        if (stringExtra != null) {
            updateMode = UpdateMode.valueOf(stringExtra);
        } else {
            Log.d("updateActivity", "onCreate: Update mode returned error: mode");
            updateMode = UpdateMode.GameUpdate;
        }
        this.mUpdateMode = updateMode;
        restoreLauncherApkState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$0(final DownloadScreenComponent downloadScreenComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C127@5294L175,127@5269L200:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1020785817, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous> (UpdateActivity.kt:127)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[0], ComposableLambdaKt.rememberComposableLambda(-413695961, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = UpdateActivity.onCreate$lambda$0$0(DownloadScreenComponent.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final DownloadScreenComponent downloadScreenComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C128@5331L124,128@5312L143:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-413695961, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous> (UpdateActivity.kt:128)");
            }
            ThemeKt.MyApplicationTheme(false, false, ComposableLambdaKt.rememberComposableLambda(-298306341, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0$0;
                    onCreate$lambda$0$0$0 = UpdateActivity.onCreate$lambda$0$0$0(DownloadScreenComponent.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0$0;
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0(DownloadScreenComponent downloadScreenComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C129@5353L84:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-298306341, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (UpdateActivity.kt:129)");
            }
            DownloadScreenRouteKt.DownloadScreenRoute(downloadScreenComponent, composer, DownloadScreenComponent.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.launcherApkUiPhase == LauncherApkUiPhase.Ready || this.launcherApkUiPhase == LauncherApkUiPhase.Installing || this.launcherApkUiPhase == LauncherApkUiPhase.AwaitingUnknownSources || this.launcherApkUiPhase == LauncherApkUiPhase.Invalid) {
            outState.putString(STATE_LAUNCHER_APK_PHASE, this.launcherApkUiPhase.name());
            outState.putString(STATE_LAUNCHER_APK_NAME, this.launcherReadyFileName);
            outState.putLong(STATE_LAUNCHER_APK_LENGTH, this.launcherReadyFileLength);
            outState.putLong(STATE_LAUNCHER_APK_MODIFIED, this.launcherReadyLastModified);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (shouldStartLauncherTransport() && (!startUpdateService() || !bindUpdateService())) {
            showForegroundServiceUnavailableDialog(false);
        }
        restoreLauncherApkDialogIfNeeded();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            restoreLauncherApkDialogIfNeeded();
        }
    }

    private final void restoreLauncherApkDialogIfNeeded() {
        if (this.mUpdateMode != UpdateMode.LauncherUpdate) {
            return;
        }
        if (this.launcherApkUiPhase == LauncherApkUiPhase.Ready && !this.autoLaunchLauncherInstaller) {
            showLauncherInstallRetryDialog();
        } else if (this.launcherApkUiPhase == LauncherApkUiPhase.Invalid) {
            showLauncherApkInvalidPackageDialog();
        }
    }

    private final boolean startUpdateService() {
        Intent intent = new Intent(this, UpdateService.class);
        intent.setAction(UpdateService.ACTION_START_FOREGROUND_SERVICE);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
                return true;
            }
            startService(intent);
            return true;
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT >= 31 && (e instanceof ForegroundServiceStartNotAllowedException)) {
                RuntimeException runtimeException = e;
                Log.w(this.tag, "Foreground update service start was denied", runtimeException);
                FirebaseCrashlytics.getInstance().recordException(runtimeException);
                return false;
            }
            throw e;
        }
    }

    private final boolean bindUpdateService() {
        if (this.mUpdateServiceBound) {
            return true;
        }
        boolean bindService = bindService(new Intent(this, UpdateService.class), this.mConnection, 0);
        this.mUpdateServiceBound = bindService;
        if (!bindService) {
            Log.w(this.tag, "UpdateService is not running, bindService returned false");
        }
        return this.mUpdateServiceBound;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arizona.launcher.Hilt_UpdateActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mUpdateServiceBound) {
            unbindService(this.mConnection);
            this.mUpdateServiceBound = false;
        }
        getWindow().clearFlags(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDownloadLauncherUpdate() {
        Message obtain = Message.obtain((Handler) null, 6);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* compiled from: UpdateActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017b\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\b(\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateActivity;", "<init>", "(Lcom/arizona/launcher/UpdateActivity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class IncomingHandler extends Handler {
        private final WeakReference<UpdateActivity> activityRef;

        /* compiled from: UpdateActivity.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[UpdateService.UpdateStatus.values().length];
                try {
                    iArr[UpdateService.UpdateStatus.Undefined.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[UpdateService.UpdateStatus.CheckUpdate.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[UpdateService.UpdateStatus.CheckFiles.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[UpdateService.UpdateStatus.DownloadGame.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[UpdateService.UpdateStatus.DownloadGameData.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomingHandler(UpdateActivity ref) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.activityRef = new WeakReference<>(ref);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HomeExternalUiState value;
            DownloadExternalUiState value2;
            DownloadExternalUiState value3;
            DownloadExternalUiState value4;
            DownloadExternalUiState value5;
            Intrinsics.checkNotNullParameter(msg, "msg");
            final UpdateActivity updateActivity = this.activityRef.get();
            if (updateActivity == null) {
                Log.d("UpdateActivity", "activity is null");
            } else if (updateActivity.isFinishing() || updateActivity.isDestroyed()) {
            } else {
                switch (msg.what) {
                    case 2:
                        Serializable serializable = msg.getData().getSerializable("errno");
                        if (serializable == UpdateService.Errno.UpdateServerUnreachable) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$0(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$1(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        } else if (serializable == UpdateService.Errno.ConnectionRefused) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$3(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$4(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore2 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore2.compareAndSet(stateStore2.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка", "Соединение с сервером оборвано, \nпроверьте ваше интернет соединение")));
                            return;
                        } else if (serializable == UpdateService.Errno.InsufficientStorage) {
                            UpdateActivity.showInsufficientSpaceDialog$default(updateActivity, msg.getData().getLong("needFreeSpaceSize", 0L), null, null, false, 14, null);
                            return;
                        } else if (serializable == UpdateService.Errno.StorageUnavailable) {
                            updateActivity.showStorageInspectionFailedDialog();
                            return;
                        } else if (serializable == UpdateService.Errno.ForegroundServiceUnavailable) {
                            updateActivity.showForegroundServiceUnavailableDialog(true);
                            return;
                        } else if (serializable == UpdateService.Errno.ArchiveRecoveryBlocked) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$6(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit unit;
                                    unit = Unit.INSTANCE;
                                    return unit;
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore3 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore3.compareAndSet(stateStore3.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "", "Выйти", "Требуется восстановление", "Архивную установку нельзя безопасно восстановить автоматически. Переустановите игру или обратитесь в поддержку.")));
                            return;
                        } else if (serializable == UpdateService.Errno.CorruptedFilesFound) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$9(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$10(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore4 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore4.compareAndSet(stateStore4.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Повторить", "Выйти", "Загрузка", "Удалены временные и поврежденные файлы")));
                            return;
                        } else if (!msg.getData().getBoolean("status", false)) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$12(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore5 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore5.compareAndSet(stateStore5.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        } else {
                            updateActivity.setUpdateServiceAsBackground();
                            MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                            do {
                                value = homeStateStore.getValue();
                            } while (!homeStateStore.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, false, false, true, 15, null)));
                            updateActivity.finish();
                            return;
                        }
                    case 3:
                    default:
                        return;
                    case 4:
                        String string = msg.getData().getString("status", "");
                        Intrinsics.checkNotNull(string);
                        int i = WhenMappings.$EnumSwitchMapping$0[UpdateService.UpdateStatus.valueOf(string).ordinal()];
                        if (i == 1) {
                            MutableStateFlow<DownloadExternalUiState> stateStore6 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value2 = stateStore6.getValue();
                            } while (!stateStore6.compareAndSet(value2, DownloadExternalUiState.copy$default(value2, "Ожидание...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.requestUpdateGameData();
                            return;
                        } else if (i == 2) {
                            MutableStateFlow<DownloadExternalUiState> stateStore7 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value3 = stateStore7.getValue();
                            } while (!stateStore7.compareAndSet(value3, DownloadExternalUiState.copy$default(value3, "Проверка обновления...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.resetProgress();
                            return;
                        } else if (i == 3) {
                            MutableStateFlow<DownloadExternalUiState> stateStore8 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value4 = stateStore8.getValue();
                            } while (!stateStore8.compareAndSet(value4, DownloadExternalUiState.copy$default(value4, "Проверка файлов...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.resetProgress();
                            return;
                        } else if (i != 4) {
                            if (i == 5) {
                                updateActivity.updateArchiveViewInformation(msg);
                                return;
                            }
                            throw new NoWhenBranchMatchedException();
                        } else {
                            MutableStateFlow<DownloadExternalUiState> stateStore9 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value5 = stateStore9.getValue();
                            } while (!stateStore9.compareAndSet(value5, DownloadExternalUiState.copy$default(value5, "Обновление...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            if (msg.getData().getBoolean(UpdateServiceContract.BundleKey.WITH_PROGRESS, false)) {
                                updateActivity.updateViewInformation(msg);
                                return;
                            }
                            return;
                        }
                    case 5:
                        String string2 = msg.getData().getString("status", "");
                        Intrinsics.checkNotNull(string2);
                        UpdateService.GameStatus.valueOf(string2);
                        updateActivity.requestUpdateGameData();
                        return;
                    case 6:
                        Serializable serializable2 = msg.getData().getSerializable("errno");
                        if (serializable2 == UpdateService.Errno.UpdateServerUnreachable) {
                            updateActivity.showLauncherApkConnectionErrorDialog();
                            return;
                        } else if (serializable2 == UpdateService.Errno.InsufficientStorage) {
                            updateActivity.showLauncherApkStorageDialog(R.string.launcher_apk_insufficient_storage_title, R.string.launcher_apk_insufficient_storage_description);
                            return;
                        } else if (serializable2 == UpdateService.Errno.StorageUnavailable) {
                            updateActivity.showLauncherApkStorageDialog(R.string.launcher_apk_storage_unavailable_title, R.string.launcher_apk_storage_unavailable_description);
                            return;
                        } else {
                            updateActivity.onLauncherApkDownloadSucceeded();
                            return;
                        }
                    case 7:
                        if (msg.getData().getBoolean(UpdateServiceContract.BundleKey.ARCHIVE_UPDATE_ACTIVE, false)) {
                            updateActivity.requestUpdateStatus();
                            return;
                        }
                        long j = msg.getData().getLong("needFreeSpaceSize", 0L);
                        updateActivity.checkFreeSpace(j, msg.getData().getLong("needGameFreeSpaceSize", j), msg.getData().getLong("needDownloadFreeSpaceSize", 0L), msg.getData().getBoolean("archiveStorageSameDevice", true));
                        return;
                    case 8:
                        updateActivity.recreate();
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$0(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$1(UpdateActivity updateActivity) {
            DownloadExternalUiState value;
            if (updateActivity.isOnline()) {
                MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                    value = stateStore.getValue();
                } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, "Проверка игровых файлов...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                updateActivity.resetProgress();
                updateActivity.mIsStartingUpdate = false;
                updateActivity.requestReUpdateGameData();
                updateActivity.hideDialog();
            } else {
                Toast.makeText(updateActivity, "Нет подключения к интернету", 1).show();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$3(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$4(UpdateActivity updateActivity) {
            DownloadExternalUiState value;
            if (updateActivity.isOnline()) {
                MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                    value = stateStore.getValue();
                } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, "Проверка игровых файлов...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                updateActivity.resetProgress();
                updateActivity.mIsStartingUpdate = false;
                updateActivity.requestReUpdateGameData();
                updateActivity.hideDialog();
            } else {
                Toast.makeText(updateActivity, "Нет подключения к интернету", 1).show();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$6(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$9(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$10(UpdateActivity updateActivity) {
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$12(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFreeSpace(long j, long j2, long j3, boolean z) {
        File externalFilesDir = getExternalFilesDir(null);
        File externalCacheDir = getExternalCacheDir();
        ArchiveStorageSpaceCheckResult check = this.archiveStorageSpaceChecker.check(externalFilesDir, externalCacheDir, new ArchiveStorageRequirementsSnapshot(0L, j, j2, j3));
        Boolean usesSingleStorageDevice = this.archiveStorageSpaceChecker.usesSingleStorageDevice(externalFilesDir, externalCacheDir);
        Log.d(this.tag, "Archive free space result=" + check + " wireSameDevice=" + z + " inspectedSameDevice=" + usesSingleStorageDevice + " gameRequired=" + j2 + " downloadRequired=" + j3);
        int i = WhenMappings.$EnumSwitchMapping$0[check.ordinal()];
        if (i == 1) {
            requestUpdateStatus();
        } else if (i == 2) {
            showInsufficientSpaceDialog(j, Long.valueOf(j2), Long.valueOf(j3), !Intrinsics.areEqual((Object) usesSingleStorageDevice, (Object) false));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            showStorageInspectionFailedDialog();
        }
    }

    static /* synthetic */ void showInsufficientSpaceDialog$default(UpdateActivity updateActivity, long j, Long l, Long l2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            l2 = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        updateActivity.showInsufficientSpaceDialog(j, l, l2, z);
    }

    private final void showInsufficientSpaceDialog(long j, Long l, Long l2, boolean z) {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String insufficientSpaceDescription = insufficientSpaceDescription(j, l, l2, z);
        if (insufficientSpaceDescription == null) {
            showStorageInspectionFailedDialog();
            return;
        }
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showInsufficientSpaceDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showInsufficientSpaceDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.Alert;
            string = getString(R.string.need_free_space_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.repeat);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string3, string2, string, insufficientSpaceDescription)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showInsufficientSpaceDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.setUpdateServiceAsBackground();
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showInsufficientSpaceDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.retryStoragePrecheck();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStorageInspectionFailedDialog() {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String string4;
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showStorageInspectionFailedDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showStorageInspectionFailedDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.Alert;
            string = getString(R.string.storage_inspection_failed_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(R.string.storage_inspection_failed_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            string4 = getString(R.string.repeat);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string4, string3, string, string2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showStorageInspectionFailedDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.setUpdateServiceAsBackground();
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showStorageInspectionFailedDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.retryStoragePrecheck();
        return Unit.INSTANCE;
    }

    private final void retryStoragePrecheck() {
        this.mIsStartingUpdate = false;
        hideDialog();
        if (this.mService != null) {
            requestUpdateInfo();
        } else if (startUpdateService() && bindUpdateService()) {
        } else {
            showForegroundServiceUnavailableDialog(false);
        }
    }

    private final String insufficientSpaceDescription(long j, Long l, Long l2, boolean z) {
        if (!z) {
            Long requiredBytesForDisplay = requiredBytesForDisplay(l);
            Long requiredBytesForDisplay2 = requiredBytesForDisplay(l2);
            if (requiredBytesForDisplay != null && requiredBytesForDisplay2 != null) {
                UpdateActivity updateActivity = this;
                return getString(R.string.need_free_space_split, new Object[]{Formatter.formatFileSize(updateActivity, requiredBytesForDisplay.longValue()), Formatter.formatFileSize(updateActivity, requiredBytesForDisplay2.longValue())});
            }
        }
        Long requiredBytesForDisplay3 = requiredBytesForDisplay(Long.valueOf(j));
        if (requiredBytesForDisplay3 != null) {
            return getString(R.string.need_free_space, new Object[]{Formatter.formatFileSize(this, requiredBytesForDisplay3.longValue())});
        }
        return null;
    }

    private final Long requiredBytesForDisplay(Long l) {
        if (l != null && l.longValue() >= 0) {
            try {
                Long valueOf = Long.valueOf(Math.addExact(l.longValue(), (long) ArchiveStorageEstimatorKt.ARCHIVE_FREE_SPACE_RESERVE_BYTES));
                if (valueOf.longValue() > 0) {
                    return valueOf;
                }
            } catch (ArithmeticException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showForegroundServiceUnavailableDialog(final boolean z) {
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showForegroundServiceUnavailableDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showForegroundServiceUnavailableDialog$lambda$1(UpdateActivity.this, z);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Повторить", "Выйти", "Обновление приостановлено", "Не удалось безопасно продолжить загрузку в фоне. Оставьте лаунчер открытым и повторите.")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showForegroundServiceUnavailableDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.setUpdateServiceAsBackground();
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showForegroundServiceUnavailableDialog$lambda$1(UpdateActivity updateActivity, boolean z) {
        updateActivity.hideDialog();
        if (!updateActivity.startUpdateService() || !updateActivity.bindUpdateService()) {
            updateActivity.showForegroundServiceUnavailableDialog(z);
        } else if (z) {
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
        }
        return Unit.INSTANCE;
    }

    private final String convertBytesToHumanReadable(long j) {
        if (j >= LauncherApkDownloader.DEFAULT_MAX_APK_BYTES) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f Gb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1.073741824E9d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f Mb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else if (j >= 1024) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f Kb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        } else {
            return j + " Byte";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewInformation(Message message) {
        long j = 0;
        long j2 = message.getData().getLong(UpdateServiceContract.BundleKey.CURRENT_LENGTH, 0L);
        long j3 = message.getData().getLong(UpdateServiceContract.BundleKey.TOTAL_ALL, 0L);
        message.getData().getInt(UpdateServiceContract.BundleKey.TOTAL, 0);
        message.getData().getInt(UpdateServiceContract.BundleKey.CURRENT, 0);
        String string = message.getData().getString(UpdateServiceContract.BundleKey.TIME_LEFT, "0 sec");
        message.getData().getString(UpdateServiceContract.BundleKey.SPEED, "");
        long j4 = j3 + j2;
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        while (true) {
            DownloadExternalUiState value = stateStore.getValue();
            DownloadExternalUiState downloadExternalUiState = value;
            String string2 = getString(R.string.archive_phase_downloading);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Intrinsics.checkNotNull(string);
            if (stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(downloadExternalUiState, string2, string, convertBytesToHumanReadable(j2) + " / " + convertBytesToHumanReadable(j4), j4 > j ? j2 / j4 : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null))) {
                return;
            }
            j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateArchiveViewInformation(Message message) {
        DownloadExternalUiState value;
        DownloadExternalUiState downloadExternalUiState;
        String string;
        ArchiveProgressPresentation fromWirePhase = ArchiveProgressPresentation.Companion.fromWirePhase(message.getData().getString(UpdateServiceContract.BundleKey.ARCHIVE_PHASE));
        if (fromWirePhase != null) {
            MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
            do {
                value = stateStore.getValue();
                downloadExternalUiState = value;
                string = getString(labelRes(fromWirePhase));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(downloadExternalUiState, string, fromWirePhase.getShowsTransferDetails() ? downloadExternalUiState.getTimeRemainingString() : "", fromWirePhase.getShowsTransferDetails() ? downloadExternalUiState.getDownloadingStringState() : "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null)));
            if (message.getData().getBoolean(UpdateServiceContract.BundleKey.WITH_PROGRESS, false)) {
                return;
            }
            if (fromWirePhase == null || fromWirePhase.getShowsTransferDetails()) {
                updateViewInformation(message);
            }
        } else if (message.getData().getBoolean(UpdateServiceContract.BundleKey.WITH_PROGRESS, false)) {
        }
    }

    private final int labelRes(ArchiveProgressPresentation archiveProgressPresentation) {
        int i = WhenMappings.$EnumSwitchMapping$1[archiveProgressPresentation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return R.string.archive_phase_installing;
                    }
                    return R.string.archive_phase_extracting;
                }
                return R.string.archive_phase_verifying;
            }
            return R.string.archive_phase_waiting_for_network;
        }
        return R.string.archive_phase_downloading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestUpdateGameData() {
        if (this.mIsStartingUpdate) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 2);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
            this.mIsStartingUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestReUpdateGameData() {
        Log.d("test", "requestReUpdateGameData: requestReUpdateGameData");
        if (this.mIsStartingUpdate) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 10);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
            this.mIsStartingUpdate = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOnline() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpdateServiceAsBackground() {
        Intent intent = new Intent(this, UpdateService.class);
        intent.setAction(UpdateService.ACTION_STOP_FOREGROUND_SERVICE);
        stopService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetProgress() {
        DownloadExternalUiState value;
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, TypedValues.PositionType.TYPE_PERCENT_WIDTH, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestUpdateInfo() {
        Message obtain = Message.obtain((Handler) null, 7);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestUpdateStatus() {
        Message obtain = Message.obtain((Handler) null, 4);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog() {
        DownloadExternalUiState value;
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, true, false, 383, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideDialog() {
        DownloadExternalUiState value;
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 383, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldStartLauncherTransport() {
        if (isFinishing() || isDestroyed()) {
            return false;
        }
        return this.mUpdateMode != UpdateMode.LauncherUpdate || this.launcherApkUiPhase == LauncherApkUiPhase.Idle || this.launcherApkUiPhase == LauncherApkUiPhase.Downloading;
    }

    private final String expectedLauncherApkFileName() {
        return "app-arizona-release.apk";
    }

    private final void restoreLauncherApkState(Bundle bundle) {
        Object obj;
        if (this.mUpdateMode == UpdateMode.LauncherUpdate && bundle != null) {
            String string = bundle.getString(STATE_LAUNCHER_APK_PHASE);
            if (string != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    UpdateActivity updateActivity = this;
                    obj = Result.m9921constructorimpl(LauncherApkUiPhase.valueOf(string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m9921constructorimpl(ResultKt.createFailure(th));
                }
                r1 = (LauncherApkUiPhase) (Result.m9927isFailureimpl(obj) ? null : obj);
            }
            if (r1 == LauncherApkUiPhase.Ready || r1 == LauncherApkUiPhase.Installing || r1 == LauncherApkUiPhase.AwaitingUnknownSources || r1 == LauncherApkUiPhase.Invalid) {
                this.launcherReadyFileName = bundle.getString(STATE_LAUNCHER_APK_NAME);
                this.launcherReadyFileLength = bundle.getLong(STATE_LAUNCHER_APK_LENGTH, -1L);
                this.launcherReadyLastModified = bundle.getLong(STATE_LAUNCHER_APK_MODIFIED, -1L);
                this.autoLaunchLauncherInstaller = false;
                applyPersistedLauncherApkInspection(inspectPersistedLauncherApk(launcherReadyApkFile(), r1 != LauncherApkUiPhase.Invalid), r1 == LauncherApkUiPhase.AwaitingUnknownSources);
            }
        }
    }

    private final void applyPersistedLauncherApkInspection(PersistedLauncherApkInspection persistedLauncherApkInspection, boolean z) {
        LauncherApkUiPhase launcherApkUiPhase;
        int i = WhenMappings.$EnumSwitchMapping$2[persistedLauncherApkInspection.ordinal()];
        if (i == 1) {
            clearLauncherApkReadyState();
        } else if (i == 2) {
            returnToNormalLauncherEntry();
        } else if (i == 3) {
            markLauncherApkProgressComplete();
            showLauncherApkInvalidPackageDialog();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (z) {
                launcherApkUiPhase = LauncherApkUiPhase.AwaitingUnknownSources;
            } else {
                launcherApkUiPhase = LauncherApkUiPhase.Ready;
            }
            this.launcherApkUiPhase = launcherApkUiPhase;
            this.autoLaunchLauncherInstaller = false;
            markLauncherApkProgressComplete();
        }
    }

    private final void markLauncherApkProgressComplete() {
        DownloadExternalUiState value;
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, 1.0d, false, null, false, false, true, 247, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLauncherApkDownloadSucceeded() {
        DownloadExternalUiState value;
        String expectedLauncherApkFileName = expectedLauncherApkFileName();
        File file = new File(getExternalFilesDir(null), expectedLauncherApkFileName);
        this.launcherReadyFileName = expectedLauncherApkFileName;
        this.launcherReadyFileLength = file.length();
        this.launcherReadyLastModified = file.lastModified();
        int i = WhenMappings.$EnumSwitchMapping$2[inspectPersistedLauncherApk(file, false).ordinal()];
        if (i != 1) {
            if (i == 2) {
                returnToNormalLauncherEntry();
                return;
            } else if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                this.launcherApkUiPhase = LauncherApkUiPhase.Ready;
                this.autoLaunchLauncherInstaller = true;
                MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                    value = stateStore.getValue();
                } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, null, null, null, 1.0d, false, null, false, false, true, 247, null)));
                proceedLauncherInstall();
                return;
            }
        }
        Log.w(this.tag, "Downloaded launcher APK failed identity or version checks");
        showLauncherApkInvalidPackageDialog();
    }

    private final void proceedLauncherInstall() {
        File launcherReadyApkFile = launcherReadyApkFile();
        int i = WhenMappings.$EnumSwitchMapping$2[inspectPersistedLauncherApk(launcherReadyApkFile, true).ordinal()];
        if (i == 1) {
            recoverLauncherApkDownload();
        } else if (i == 2) {
            returnToNormalLauncherEntry();
        } else if (i == 3) {
            showLauncherApkInvalidPackageDialog();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (launcherReadyApkFile == null) {
                recoverLauncherApkDownload();
            } else if (Build.VERSION.SDK_INT >= 26 && !getPackageManager().canRequestPackageInstalls()) {
                this.launcherApkUiPhase = LauncherApkUiPhase.AwaitingUnknownSources;
                this.unknownSourcesLauncher.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
            } else {
                launchLauncherInstaller(launcherReadyApkFile);
            }
        }
    }

    private final void launchLauncherInstaller(File file) {
        Uri uriForFile = FileProvider.getUriForFile(this, "com.arizona21.game.fileprovider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.addFlags(1);
        List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "queryIntentActivities(...)");
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 1);
        }
        this.launcherApkUiPhase = LauncherApkUiPhase.Installing;
        this.launcherInstallLauncher.launch(intent);
    }

    private final void handleLauncherInstallResult(int i) {
        if (inspectPersistedLauncherApk(launcherReadyApkFile(), true) == PersistedLauncherApkInspection.AlreadyInstalled) {
            returnToNormalLauncherEntry();
            return;
        }
        this.launcherApkUiPhase = LauncherApkUiPhase.Ready;
        this.autoLaunchLauncherInstaller = false;
        if (i == -1) {
            Log.i(this.tag, "Launcher installer returned OK; waiting for package replacement");
        }
        showLauncherInstallRetryDialog();
    }

    private final void handleUnknownSourcesResult() {
        int i = WhenMappings.$EnumSwitchMapping$2[inspectPersistedLauncherApk(launcherReadyApkFile(), true).ordinal()];
        if (i == 1) {
            recoverLauncherApkDownload();
        } else if (i == 2) {
            returnToNormalLauncherEntry();
        } else if (i == 3) {
            showLauncherApkInvalidPackageDialog();
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.launcherApkUiPhase = LauncherApkUiPhase.Ready;
            if (Build.VERSION.SDK_INT >= 26 && getPackageManager().canRequestPackageInstalls()) {
                proceedLauncherInstall();
                return;
            }
            this.autoLaunchLauncherInstaller = false;
            showLauncherInstallRetryDialog();
        }
    }

    private final void showLauncherInstallRetryDialog() {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String string4;
        if (this.launcherApkUiPhase != LauncherApkUiPhase.Ready) {
            return;
        }
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherInstallRetryDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherInstallRetryDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.Alert;
            string = getString(R.string.launcher_apk_install_ready_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(R.string.launcher_apk_install_ready_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            string4 = getString(R.string.launcher_apk_install);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string4, string3, string, string2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherInstallRetryDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherInstallRetryDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.hideDialog();
        updateActivity.proceedLauncherInstall();
        return Unit.INSTANCE;
    }

    private final void showLauncherApkInvalidPackageDialog() {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String string4;
        this.launcherApkUiPhase = LauncherApkUiPhase.Invalid;
        this.autoLaunchLauncherInstaller = false;
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkInvalidPackageDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkInvalidPackageDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.Alert;
            string = getString(R.string.launcher_apk_invalid_package_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(R.string.launcher_apk_invalid_package_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            string4 = getString(R.string.repeat);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string4, string3, string, string2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkInvalidPackageDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkInvalidPackageDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.hideDialog();
        updateActivity.retryLauncherApkDownload();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLauncherApkConnectionErrorDialog() {
        clearLauncherApkReadyState();
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkConnectionErrorDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkConnectionErrorDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkConnectionErrorDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkConnectionErrorDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.hideDialog();
        updateActivity.retryLauncherApkDownload();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLauncherApkStorageDialog(int i, int i2) {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String string4;
        clearLauncherApkReadyState();
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkStorageDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showLauncherApkStorageDialog$lambda$1(UpdateActivity.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.Alert;
            string = getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(i2);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            string4 = getString(R.string.repeat);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string4, string3, string, string2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkStorageDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showLauncherApkStorageDialog$lambda$1(UpdateActivity updateActivity) {
        updateActivity.hideDialog();
        updateActivity.retryLauncherApkDownload();
        return Unit.INSTANCE;
    }

    private final void retryLauncherApkDownload() {
        recoverLauncherApkDownload();
    }

    private final void recoverLauncherApkDownload() {
        clearLauncherApkReadyState();
        this.launcherApkUiPhase = LauncherApkUiPhase.Idle;
        if (this.mService != null) {
            this.launcherApkUiPhase = LauncherApkUiPhase.Downloading;
            startDownloadLauncherUpdate();
        } else if (startUpdateService() && bindUpdateService()) {
        } else {
            showForegroundServiceUnavailableDialog(false);
        }
    }

    private final void clearLauncherApkReadyState() {
        this.launcherApkUiPhase = LauncherApkUiPhase.Idle;
        this.launcherReadyFileName = null;
        this.launcherReadyFileLength = -1L;
        this.launcherReadyLastModified = -1L;
        this.autoLaunchLauncherInstaller = false;
    }

    private final File launcherReadyApkFile() {
        File externalFilesDir;
        String str = this.launcherReadyFileName;
        if (str == null || !Intrinsics.areEqual(str, expectedLauncherApkFileName()) || (externalFilesDir = getExternalFilesDir(null)) == null) {
            return null;
        }
        return new File(externalFilesDir, str);
    }

    static /* synthetic */ PersistedLauncherApkInspection inspectPersistedLauncherApk$default(UpdateActivity updateActivity, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return updateActivity.inspectPersistedLauncherApk(file, z);
    }

    private final PersistedLauncherApkInspection inspectPersistedLauncherApk(File file, boolean z) {
        Integer m9921constructorimpl;
        PackageInfo installedPackageInfo;
        if (file == null || !file.isFile()) {
            return PersistedLauncherApkInspection.MissingOrChanged;
        }
        if (!Intrinsics.areEqual(file.getName(), expectedLauncherApkFileName())) {
            return PersistedLauncherApkInspection.MissingOrChanged;
        }
        if (this.launcherReadyFileLength <= 0 || file.length() != this.launcherReadyFileLength) {
            return PersistedLauncherApkInspection.MissingOrChanged;
        }
        if (file.lastModified() != this.launcherReadyLastModified) {
            return PersistedLauncherApkInspection.MissingOrChanged;
        }
        byte[] bArr = new byte[APK_ZIP_MAGIC.length];
        try {
            Result.Companion companion = Result.Companion;
            UpdateActivity updateActivity = this;
            FileInputStream fileInputStream = new FileInputStream(file);
            int read = fileInputStream.read(bArr);
            CloseableKt.closeFinally(fileInputStream, null);
            m9921constructorimpl = Result.m9921constructorimpl(Integer.valueOf(read));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9927isFailureimpl(m9921constructorimpl)) {
            m9921constructorimpl = -1;
        }
        int intValue = ((Number) m9921constructorimpl).intValue();
        byte[] bArr2 = APK_ZIP_MAGIC;
        if (intValue != bArr2.length || !Arrays.equals(bArr, bArr2)) {
            return PersistedLauncherApkInspection.MissingOrChanged;
        }
        PackageInfo packageArchiveInfo = packageArchiveInfo(file);
        if (packageArchiveInfo != null && Intrinsics.areEqual(packageArchiveInfo.packageName, getPackageName()) && (installedPackageInfo = installedPackageInfo()) != null) {
            LauncherVersionPolicy launcherVersionPolicy = LauncherVersionPolicy.INSTANCE;
            int packageVersionCode = (int) packageVersionCode(packageArchiveInfo);
            String str = packageArchiveInfo.versionName;
            int packageVersionCode2 = (int) packageVersionCode(installedPackageInfo);
            String str2 = installedPackageInfo.versionName;
            if (str2 == null) {
                str2 = "";
            }
            if (launcherVersionPolicy.isCandidateNewerThanInstalled(packageVersionCode, str, packageVersionCode2, str2, "release")) {
                return PersistedLauncherApkInspection.Ready;
            }
            if (z) {
                return PersistedLauncherApkInspection.AlreadyInstalled;
            }
            return PersistedLauncherApkInspection.Invalid;
        }
        return PersistedLauncherApkInspection.Invalid;
    }

    private final void returnToNormalLauncherEntry() {
        clearLauncherApkReadyState();
        hideDialog();
        startActivity(new Intent(this, MainEntrench.class));
        finish();
    }

    private final PackageInfo packageArchiveInfo(File file) {
        if (Build.VERSION.SDK_INT >= 33) {
            return getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), PackageManager.PackageInfoFlags.of(0L));
        }
        return getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
    }

    private final long packageVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }

    private final PackageInfo installedPackageInfo() {
        Object m9921constructorimpl;
        PackageInfo packageInfo;
        try {
            Result.Companion companion = Result.Companion;
            UpdateActivity updateActivity = this;
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            }
            m9921constructorimpl = Result.m9921constructorimpl(packageInfo);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9927isFailureimpl(m9921constructorimpl)) {
            m9921constructorimpl = null;
        }
        return (PackageInfo) m9921constructorimpl;
    }
}
