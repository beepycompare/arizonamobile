package com.arizona.launcher;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
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
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
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
import com.arizona.game.R;
import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveStorageEstimatorKt;
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
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.MutableStateFlow;
/* compiled from: UpdateActivity.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001C\b\u0007\u0018\u0000 S2\u00020\u0001:\u0002STB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0015b\u0010\b\u001e\u0012\f\b\u001f\u0012\b\b\fJ\u0004\b\b( J\b\u0010!\u001a\u00020\u001bH\u0014J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u001bH\u0014J\b\u0010%\u001a\u00020\u001bH\u0002J(\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u001a\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000bH\u0002J\"\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207H\u0003b\u0010\b\u001e\u0012\f\b\u001f\u0012\b\b\fJ\u0004\b\b(8J\u0010\u00109\u001a\u00020\u001b2\u0006\u00106\u001a\u000207H\u0002J\f\u0010:\u001a\u00020;*\u00020<H\u0002J\b\u0010=\u001a\u00020\u001bH\u0002J\b\u0010>\u001a\u00020\u001bH\u0002J\b\u0010?\u001a\u00020\u000fH\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020\u001bH\u0002J\b\u0010G\u001a\u00020\u001bH\u0002J\b\u0010H\u001a\u00020\u001bH\u0002J0\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010MH\u0015b\f\bN\u0012\b\bO\u0012\u0004\b\b(PJ\u0010\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u0005H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u0092\u0002\u0002\b\u0019¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DÊ\u0001\u0002\bVÊ\u0001\f\bW\u0012\b\bX\u0012\u0004\b\u0003\u0010\u0000¨\u0006U"}, d2 = {"Lcom/arizona/launcher/UpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "tag", "", "kotlin.jvm.PlatformType", "mService", "Landroid/os/Messenger;", "mMessenger", "SAMP_NEED_FREE_SPACE_BYTES", "", "exoplayer", "Landroidx/media3/exoplayer/ExoPlayer;", "mUpdateServiceBound", "", "mUpdateMode", "Lcom/arizona/launcher/UpdateMode;", "mIsStartingUpdate", "rootFactory", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "getRootFactory", "()Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "setRootFactory", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;)V", "Ljavax/inject/Inject;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Landroid/annotation/SuppressLint;", "value", "SourceLockedOrientationActivity", "onResume", "startUpdateService", "bindUpdateService", "onDestroy", "startDownloadLauncherUpdate", "checkFreeSpace", "combinedBytes", "gameBytes", "downloadBytes", "sameStorageDevice", "hasFreeSpace", "root", "Ljava/io/File;", "requiredBytes", "showInsufficientSpaceDialog", "needFreeSpaceSize", "showForegroundServiceUnavailableDialog", "retryCurrentOperation", "convertBytesToHumanReadable", "bytes", "updateViewInformation", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "SetTextI18n", "updateArchiveViewInformation", "labelRes", "", "Lcom/arizona/launcher/ArchiveProgressPresentation;", "requestUpdateGameData", "requestReUpdateGameData", "isOnline", "setUpdateServiceAsBackground", "resetProgress", "mConnection", "com/arizona/launcher/UpdateActivity$mConnection$1", "Lcom/arizona/launcher/UpdateActivity$mConnection$1;", "requestUpdateInfo", "requestUpdateStatus", "showDialog", "hideDialog", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Lkotlin/Deprecated;", "message", "Deprecated in Java", "installApk", "apkPath", "Companion", "IncomingHandler", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateActivity extends Hilt_UpdateActivity {
    private static final int INSTALL_LAUNCHER = 31;
    public static final String UPDATE_MODE = "mode";
    private ExoPlayer exoplayer;
    private boolean mIsStartingUpdate;
    private Messenger mService;
    private boolean mUpdateServiceBound;
    @Inject
    public DownloadScreenComponent.Factory rootFactory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String tag = UpdateActivity.class.getCanonicalName();
    private final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private final long SAMP_NEED_FREE_SPACE_BYTES = ArchiveStorageEstimatorKt.ARCHIVE_FREE_SPACE_RESERVE_BYTES;
    private UpdateMode mUpdateMode = UpdateMode.Undefined;
    private final UpdateActivity$mConnection$1 mConnection = new ServiceConnection() { // from class: com.arizona.launcher.UpdateActivity$mConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            UpdateMode updateMode;
            UpdateMode updateMode2;
            DownloadExternalUiState value;
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
                UpdateActivity.this.startDownloadLauncherUpdate();
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

        static {
            int[] iArr = new int[ArchiveProgressPresentation.values().length];
            try {
                iArr[ArchiveProgressPresentation.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveProgressPresentation.WAITING_FOR_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveProgressPresentation.VERIFYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveProgressPresentation.EXTRACTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveProgressPresentation.INSTALLING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: UpdateActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$Companion;", "", "<init>", "()V", "UPDATE_MODE", "", "INSTALL_LAUNCHER", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
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
        ComponentActivityKt.setContent$default(updateActivity, null, ComposableLambdaKt.composableLambdaInstance(-1020785817, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda1
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$0(final DownloadScreenComponent downloadScreenComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@3637L175,99@3612L200:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1020785817, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous> (UpdateActivity.kt:99)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[0], ComposableLambdaKt.rememberComposableLambda(-413695961, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda0
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
        ComposerKt.sourceInformation(composer, "C100@3674L124,100@3655L143:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-413695961, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous> (UpdateActivity.kt:100)");
            }
            ThemeKt.MyApplicationTheme(false, false, ComposableLambdaKt.rememberComposableLambda(-298306341, true, new Function2() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda2
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
        ComposerKt.sourceInformation(composer, "C101@3696L84:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-298306341, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (UpdateActivity.kt:101)");
            }
            DownloadScreenRouteKt.DownloadScreenRoute(downloadScreenComponent, composer, DownloadScreenComponent.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (startUpdateService() && bindUpdateService()) {
            return;
        }
        showForegroundServiceUnavailableDialog(false);
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
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda3
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
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$3(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda5
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
                            updateActivity.showInsufficientSpaceDialog(msg.getData().getLong("needFreeSpaceSize", 0L));
                            return;
                        } else if (serializable == UpdateService.Errno.ForegroundServiceUnavailable) {
                            updateActivity.showForegroundServiceUnavailableDialog(true);
                            return;
                        } else if (serializable == UpdateService.Errno.ArchiveRecoveryBlocked) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$6(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda7
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
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$9(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda9
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
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda10
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
                        if (msg.getData().getSerializable("errno") == UpdateService.Errno.UpdateServerUnreachable) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$19(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$20(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore10 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore10.compareAndSet(stateStore10.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        }
                        Log.d("HAVE_TO_CHECK_1", "We're waiting app-arizona-release.apk file");
                        String absolutePath = new File(updateActivity.getExternalFilesDir(null), "app-arizona-release.apk").getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        updateActivity.installApk(absolutePath);
                        return;
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$19(UpdateActivity updateActivity) {
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$20(UpdateActivity updateActivity) {
            updateActivity.startDownloadLauncherUpdate();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFreeSpace(long j, long j2, long j3, boolean z) {
        boolean z2;
        if (z) {
            z2 = hasFreeSpace(getExternalFilesDir(null), j);
        } else {
            z2 = hasFreeSpace(getExternalFilesDir(null), j2) && hasFreeSpace(getExternalCacheDir(), j3);
        }
        Log.d(this.tag, "Archive free space enough=" + z2 + " sameDevice=" + z + " gameRequired=" + j2 + " downloadRequired=" + j3);
        if (!z2) {
            showInsufficientSpaceDialog(j);
        } else {
            requestUpdateStatus();
        }
    }

    private final boolean hasFreeSpace(File file, long j) {
        if (file != null && j >= 0) {
            try {
                try {
                    return new StatFs(file.getAbsolutePath()).getAvailableBytes() >= Math.addExact(j, this.SAMP_NEED_FREE_SPACE_BYTES);
                } catch (RuntimeException e) {
                    Log.e(this.tag, "Unable to inspect free space at " + file.getAbsolutePath(), e);
                }
            } catch (ArithmeticException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInsufficientSpaceDialog(long j) {
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showInsufficientSpaceDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "", "Выйти", "Недостаточно места", "Недостаточно места для установки ресурсов игры. Требуется " + Formatter.formatFileSize(this, j))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showInsufficientSpaceDialog$lambda$0(UpdateActivity updateActivity) {
        updateActivity.setUpdateServiceAsBackground();
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showForegroundServiceUnavailableDialog(final boolean z) {
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdateActivity.showForegroundServiceUnavailableDialog$lambda$0(UpdateActivity.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda4
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
        int i = WhenMappings.$EnumSwitchMapping$0[archiveProgressPresentation.ordinal()];
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 31) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installApk(String str) {
        File file = new File(str);
        Uri.fromFile(file);
        Uri uriForFile = FileProvider.getUriForFile(this, "com.arizona21.game.fileprovider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.setFlags(268435456);
        intent.addFlags(1);
        startActivity(intent);
    }
}
