package com.arizona.launcher;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
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
import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.UpdateService;
import com.arkivanov.decompose.RetainedComponentKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.liulishuo.okdownload.core.Util;
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
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00010\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0015J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0014J\b\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0003J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\"\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010;H\u0015J\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0005H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101¨\u0006@"}, d2 = {"Lcom/arizona/launcher/UpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "tag", "", "kotlin.jvm.PlatformType", "mService", "Landroid/os/Messenger;", "mMessenger", "SAMP_NEED_FREE_SPACE_BYTES", "", "exoplayer", "Landroidx/media3/exoplayer/ExoPlayer;", "mUpdateServiceBound", "", "mUpdateMode", "Lcom/arizona/launcher/UpdateMode;", "mIsStartingUpdate", "rootFactory", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "getRootFactory", "()Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "setRootFactory", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "startUpdateService", "bindUpdateService", "onDestroy", "startDownloadLauncherUpdate", "checkFreeSpace", "needFreeSpaceSize", "freeSpace", "convertBytesToHumanReadable", "bytes", "updateViewInformation", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "requestUpdateGameData", "requestReUpdateGameData", "isOnline", "setUpdateServiceAsBackground", "resetProgress", "mConnection", "com/arizona/launcher/UpdateActivity$mConnection$1", "Lcom/arizona/launcher/UpdateActivity$mConnection$1;", "requestUpdateInfo", "requestUpdateStatus", "showDialog", "hideDialog", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "installApk", "apkPath", "Companion", "IncomingHandler", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    private final long SAMP_NEED_FREE_SPACE_BYTES = 524288000;
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$Companion;", "", "<init>", "()V", "UPDATE_MODE", "", "INSTALL_LAUNCHER", "", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
        ComposerKt.sourceInformation(composer, "C100@3754L175,100@3729L200:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1020785817, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous> (UpdateActivity.kt:100)");
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
        ComposerKt.sourceInformation(composer, "C101@3791L124,101@3772L143:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-413695961, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous> (UpdateActivity.kt:101)");
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
        ComposerKt.sourceInformation(composer, "C102@3813L84:UpdateActivity.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-298306341, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (UpdateActivity.kt:102)");
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
        startUpdateService();
        bindUpdateService();
    }

    private final void startUpdateService() {
        Intent intent = new Intent(this, UpdateService.class);
        intent.setAction(UpdateService.ACTION_START_FOREGROUND_SERVICE);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT >= 31 && (e instanceof ForegroundServiceStartNotAllowedException)) {
                RuntimeException runtimeException = e;
                Log.w(this.tag, "Foreground update service start was denied", runtimeException);
                FirebaseCrashlytics.getInstance().recordException(runtimeException);
                return;
            }
            throw e;
        }
    }

    private final void bindUpdateService() {
        if (this.mUpdateServiceBound) {
            return;
        }
        boolean bindService = bindService(new Intent(this, UpdateService.class), this.mConnection, 0);
        this.mUpdateServiceBound = bindService;
        if (bindService) {
            return;
        }
        Log.w(this.tag, "UpdateService is not running, bindService returned false");
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateActivity;", "<init>", "(Lcom/arizona/launcher/UpdateActivity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class IncomingHandler extends Handler {
        private final WeakReference<UpdateActivity> activityRef;

        /* compiled from: UpdateActivity.kt */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
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
                        Serializable serializable = msg.getData().getSerializable(UpdateService.ERRNO_MSG);
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
                        } else if (serializable == UpdateService.Errno.CorruptedFilesFound) {
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
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$7(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore3 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore3.compareAndSet(stateStore3.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Повторить", "Выйти", "Загрузка", "Удалены временные и поврежденные файлы")));
                            return;
                        } else if (!msg.getData().getBoolean(NotificationCompat.CATEGORY_STATUS, false)) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$9(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore4 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore4.compareAndSet(stateStore4.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
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
                        String string = msg.getData().getString(NotificationCompat.CATEGORY_STATUS, "");
                        Intrinsics.checkNotNull(string);
                        int i = WhenMappings.$EnumSwitchMapping$0[UpdateService.UpdateStatus.valueOf(string).ordinal()];
                        if (i == 1) {
                            MutableStateFlow<DownloadExternalUiState> stateStore5 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value2 = stateStore5.getValue();
                            } while (!stateStore5.compareAndSet(value2, DownloadExternalUiState.copy$default(value2, "Ожидание...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.requestUpdateGameData();
                            return;
                        } else if (i == 2) {
                            MutableStateFlow<DownloadExternalUiState> stateStore6 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value3 = stateStore6.getValue();
                            } while (!stateStore6.compareAndSet(value3, DownloadExternalUiState.copy$default(value3, "Проверка обновления...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.resetProgress();
                            return;
                        } else if (i == 3) {
                            MutableStateFlow<DownloadExternalUiState> stateStore7 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value4 = stateStore7.getValue();
                            } while (!stateStore7.compareAndSet(value4, DownloadExternalUiState.copy$default(value4, "Проверка файлов...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            updateActivity.resetProgress();
                            return;
                        } else if (i != 4) {
                            if (i != 5) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (msg.getData().getBoolean("withProgress", false)) {
                                updateActivity.updateViewInformation(msg);
                                return;
                            }
                            return;
                        } else {
                            MutableStateFlow<DownloadExternalUiState> stateStore8 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value5 = stateStore8.getValue();
                            } while (!stateStore8.compareAndSet(value5, DownloadExternalUiState.copy$default(value5, "Обновление...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            if (msg.getData().getBoolean("withProgress", false)) {
                                updateActivity.updateViewInformation(msg);
                                return;
                            }
                            return;
                        }
                    case 5:
                        String string2 = msg.getData().getString(NotificationCompat.CATEGORY_STATUS, "");
                        Intrinsics.checkNotNull(string2);
                        UpdateService.GameStatus.valueOf(string2);
                        updateActivity.requestUpdateGameData();
                        return;
                    case 6:
                        if (msg.getData().getSerializable(UpdateService.ERRNO_MSG) == UpdateService.Errno.UpdateServerUnreachable) {
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$16(UpdateActivity.this);
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return UpdateActivity.IncomingHandler.handleMessage$lambda$17(UpdateActivity.this);
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore9 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore9.compareAndSet(stateStore9.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        }
                        Log.d("HAVE_TO_CHECK_1", "We're waiting app-arizona-release.apk file");
                        String absolutePath = new File(updateActivity.getExternalFilesDir(null), "app-arizona-release.apk").getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        updateActivity.installApk(absolutePath);
                        return;
                    case 7:
                        updateActivity.checkFreeSpace(msg.getData().getLong("needFreeSpaceSize", 0L));
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
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
            updateActivity.hideDialog();
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
            if (!updateActivity.isOnline()) {
                updateActivity.mIsStartingUpdate = false;
                updateActivity.requestUpdateGameData();
            } else {
                MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                    value = stateStore.getValue();
                } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, "Проверка игровых файлов...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                updateActivity.resetProgress();
                updateActivity.mIsStartingUpdate = false;
                updateActivity.requestReUpdateGameData();
            }
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$6(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$7(UpdateActivity updateActivity) {
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$9(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$16(UpdateActivity updateActivity) {
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$17(UpdateActivity updateActivity) {
            updateActivity.startDownloadLauncherUpdate();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFreeSpace(long j) {
        long freeSpace = freeSpace();
        Log.d(this.tag, "Free space " + freeSpace);
        if (freeSpace < this.SAMP_NEED_FREE_SPACE_BYTES + j) {
            showDialog();
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UpdateActivity.checkFreeSpace$lambda$0(UpdateActivity.this);
                }
            });
            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
            do {
            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "", "Выйти", "Недостаточно места", "Недостаточно места для установки ресурсов игры. Требуется " + Util.humanReadableBytes(j, true))));
            return;
        }
        requestUpdateStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit checkFreeSpace$lambda$0(UpdateActivity updateActivity) {
        updateActivity.finishAffinity();
        return Unit.INSTANCE;
    }

    private final long freeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    private final String convertBytesToHumanReadable(long j) {
        if (j >= 1073741824) {
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
        DownloadExternalUiState value;
        String convertBytesToHumanReadable;
        long j;
        long j2 = message.getData().getLong("current_len", 0L);
        long j3 = message.getData().getLong("total_all", 0L);
        message.getData().getInt("total", 0);
        message.getData().getInt("current", 0);
        String string = message.getData().getString("timeLeft", "0 sec");
        message.getData().getString("speed", "");
        MutableStateFlow<DownloadExternalUiState> stateStore = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            Intrinsics.checkNotNull(string);
            convertBytesToHumanReadable = convertBytesToHumanReadable(j2);
            j = j3 + j2;
        } while (!stateStore.compareAndSet(value, DownloadExternalUiState.copy$default(value, "Скачивание файлов..", string, convertBytesToHumanReadable + " / " + convertBytesToHumanReadable(j), j2 / j, false, null, false, false, false, 496, null)));
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
        Object systemService = getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
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

    private final void requestUpdateStatus() {
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
