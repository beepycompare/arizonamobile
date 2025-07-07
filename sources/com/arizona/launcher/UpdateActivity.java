package com.arizona.launcher;

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
import android.util.Log;
import android.widget.TextView;
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
import com.arizona.game.databinding.ActivityUpdateBinding;
import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.util.UtilsKt;
import com.arkivanov.decompose.RetainedComponentKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.liulishuo.okdownload.core.Util;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiState;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogType;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiState;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.home.ui.model.HomeExternalUiState;
import com.miami.game.feature.home.ui.model.HomeExternalUiStateHolder;
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
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00011\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0015J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0003J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002J\"\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<H\u0015J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0005H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u0006A"}, d2 = {"Lcom/arizona/launcher/UpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "tag", "", "kotlin.jvm.PlatformType", "mService", "Landroid/os/Messenger;", "mMessenger", "SAMP_NEED_FREE_SPACE_BYTES", "", "exoplayer", "Landroidx/media3/exoplayer/ExoPlayer;", "mUpdateMode", "Lcom/arizona/launcher/UpdateMode;", "mIsStartingUpdate", "", "binding", "Lcom/arizona/game/databinding/ActivityUpdateBinding;", "rootFactory", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "getRootFactory", "()Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "setRootFactory", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "startDownloadLauncherUpdate", "checkFreeSpace", "needFreeSpaceSize", "freeSpace", "convertBytesToHumanReadable", "bytes", "downloadInfoVisibility", "isVisible", "updateViewInformation", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "requestUpdateGameData", "requestReUpdateGameData", "isOnline", "setUpdateServiceAsBackground", "resetProgress", "mConnection", "com/arizona/launcher/UpdateActivity$mConnection$1", "Lcom/arizona/launcher/UpdateActivity$mConnection$1;", "requestUpdateInfo", "requestUpdateStatus", "showDialog", "hideDialog", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "installApk", "apkPath", "Companion", "IncomingHandler", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class UpdateActivity extends Hilt_UpdateActivity {
    private static final int INSTALL_LAUNCHER = 31;
    public static final String UPDATE_MODE = "mode";
    private ActivityUpdateBinding binding;
    private ExoPlayer exoplayer;
    private boolean mIsStartingUpdate;
    private Messenger mService;
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
            if (updateMode == UpdateMode.GameUpdate) {
                UpdateActivity.this.requestUpdateInfo();
                return;
            }
            updateMode2 = UpdateActivity.this.mUpdateMode;
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
        }
    };

    /* compiled from: UpdateActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$Companion;", "", "<init>", "()V", "UPDATE_MODE", "", "INSTALL_LAUNCHER", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        super.onCreate(bundle);
        this.binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        UpdateActivity updateActivity = this;
        final DownloadScreenComponent downloadScreenComponent = (DownloadScreenComponent) RetainedComponentKt.retainedComponent$default((ComponentActivity) updateActivity, (String) null, false, false, (Function0) null, (Function1) new UpdateActivity$onCreate$root$1(getRootFactory()), 15, (Object) null);
        EdgeToEdge.enable$default(updateActivity, null, null, 3, null);
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
        getWindow().addFlags(128);
        ComponentActivityKt.setContent$default(updateActivity, null, ComposableLambdaKt.composableLambdaInstance(-1020785817, true, new Function2<Composer, Integer, Unit>() { // from class: com.arizona.launcher.UpdateActivity$onCreate$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C108@4089L175,108@4064L200:UpdateActivity.kt#5ji0rp");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1020785817, i, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous> (UpdateActivity.kt:108)");
                    }
                    final DownloadScreenComponent downloadScreenComponent2 = DownloadScreenComponent.this;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[0], ComposableLambdaKt.rememberComposableLambda(-413695961, true, new Function2<Composer, Integer, Unit>() { // from class: com.arizona.launcher.UpdateActivity$onCreate$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C109@4126L124,109@4107L143:UpdateActivity.kt#5ji0rp");
                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-413695961, i2, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous> (UpdateActivity.kt:109)");
                                }
                                final DownloadScreenComponent downloadScreenComponent3 = DownloadScreenComponent.this;
                                ThemeKt.MyApplicationTheme(false, false, ComposableLambdaKt.rememberComposableLambda(-298306341, true, new Function2<Composer, Integer, Unit>() { // from class: com.arizona.launcher.UpdateActivity.onCreate.1.1.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i3) {
                                        ComposerKt.sourceInformation(composer3, "C110@4148L84:UpdateActivity.kt#5ji0rp");
                                        if ((i3 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-298306341, i3, -1, "com.arizona.launcher.UpdateActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (UpdateActivity.kt:110)");
                                            }
                                            DownloadScreenKt.DownloadScreenRoute(DownloadScreenComponent.this, composer3, DownloadScreenComponent.$stable);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54), composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 1, null);
        String stringExtra = getIntent().getStringExtra(UPDATE_MODE);
        if (stringExtra != null) {
            this.mUpdateMode = UpdateMode.valueOf(stringExtra);
            String stringExtra2 = getIntent().getStringExtra(UPDATE_MODE);
            Intrinsics.checkNotNull(stringExtra2);
            this.mUpdateMode = UpdateMode.valueOf(stringExtra2);
            return;
        }
        throw new RuntimeException("Update mode returned error: mode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent(this, UpdateService.class);
            intent.setAction(UpdateService.ACTION_START_FOREGROUND_SERVICE);
            startForegroundService(intent);
        } else {
            startService(new Intent(this, UpdateService.class));
        }
        bindService(new Intent(this, UpdateService.class), this.mConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arizona.launcher.Hilt_UpdateActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unbindService(this.mConnection);
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/UpdateActivity$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/UpdateActivity;", "<init>", "(Lcom/arizona/launcher/UpdateActivity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class IncomingHandler extends Handler {
        private final WeakReference<UpdateActivity> activityRef;

        /* compiled from: UpdateActivity.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
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
                ActivityUpdateBinding activityUpdateBinding = null;
                switch (msg.what) {
                    case 2:
                        Serializable serializable = msg.getData().getSerializable(UpdateService.ERRNO_MSG);
                        if (serializable == UpdateService.Errno.UpdateServerUnreachable) {
                            try {
                                UtilsKt.sendDataAnalytics(updateActivity, "download_error", 3);
                            } catch (Exception e) {
                                Log.e("sendDataAnalytics", "ERROR");
                                FirebaseCrashlytics.getInstance().recordException(e);
                                e.printStackTrace();
                            }
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$0;
                                    handleMessage$lambda$0 = UpdateActivity.IncomingHandler.handleMessage$lambda$0(UpdateActivity.this);
                                    return handleMessage$lambda$0;
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$1;
                                    handleMessage$lambda$1 = UpdateActivity.IncomingHandler.handleMessage$lambda$1(UpdateActivity.this);
                                    return handleMessage$lambda$1;
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        } else if (serializable == UpdateService.Errno.ConnectionRefused) {
                            try {
                                UtilsKt.sendDataAnalytics(updateActivity, "download_error", 3);
                            } catch (Exception e2) {
                                Log.e("sendDataAnalytics", "ERROR");
                                FirebaseCrashlytics.getInstance().recordException(e2);
                                e2.printStackTrace();
                            }
                            updateActivity.showDialog();
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$3;
                                    handleMessage$lambda$3 = UpdateActivity.IncomingHandler.handleMessage$lambda$3(UpdateActivity.this);
                                    return handleMessage$lambda$3;
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$5;
                                    handleMessage$lambda$5 = UpdateActivity.IncomingHandler.handleMessage$lambda$5(UpdateActivity.this);
                                    return handleMessage$lambda$5;
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
                                    Unit handleMessage$lambda$7;
                                    handleMessage$lambda$7 = UpdateActivity.IncomingHandler.handleMessage$lambda$7(UpdateActivity.this);
                                    return handleMessage$lambda$7;
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$8;
                                    handleMessage$lambda$8 = UpdateActivity.IncomingHandler.handleMessage$lambda$8(UpdateActivity.this);
                                    return handleMessage$lambda$8;
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
                                    Unit handleMessage$lambda$10;
                                    handleMessage$lambda$10 = UpdateActivity.IncomingHandler.handleMessage$lambda$10(UpdateActivity.this);
                                    return handleMessage$lambda$10;
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
                        } else if (i == 4) {
                            MutableStateFlow<DownloadExternalUiState> stateStore8 = DownloadExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                                value5 = stateStore8.getValue();
                            } while (!stateStore8.compareAndSet(value5, DownloadExternalUiState.copy$default(value5, "Обновление...", "рассчитываем...", "", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 496, null)));
                            if (msg.getData().getBoolean("withProgress", false)) {
                                updateActivity.updateViewInformation(msg);
                                return;
                            }
                            return;
                        } else if (i == 5) {
                            ActivityUpdateBinding activityUpdateBinding2 = updateActivity.binding;
                            if (activityUpdateBinding2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            } else {
                                activityUpdateBinding = activityUpdateBinding2;
                            }
                            activityUpdateBinding.updateState.setText(updateActivity.getString(R.string.update_game_data));
                            if (msg.getData().getBoolean("withProgress", false)) {
                                updateActivity.updateViewInformation(msg);
                                return;
                            }
                            return;
                        } else {
                            throw new NoWhenBranchMatchedException();
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
                                    Unit handleMessage$lambda$17;
                                    handleMessage$lambda$17 = UpdateActivity.IncomingHandler.handleMessage$lambda$17(UpdateActivity.this);
                                    return handleMessage$lambda$17;
                                }
                            });
                            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.UpdateActivity$IncomingHandler$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit handleMessage$lambda$18;
                                    handleMessage$lambda$18 = UpdateActivity.IncomingHandler.handleMessage$lambda$18(UpdateActivity.this);
                                    return handleMessage$lambda$18;
                                }
                            });
                            MutableStateFlow<ErrorDialogExternalUiState> stateStore9 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                            do {
                            } while (!stateStore9.compareAndSet(stateStore9.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения", "Ошибка подключения к серверу обновления, \nпроверьте ваше интернет соединение")));
                            return;
                        }
                        Log.d("HAVE_TO_CHECK_1", "We're waiting app-arizona-release_web.apk file");
                        String absolutePath = new File(updateActivity.getExternalFilesDir(null), "app-arizona-release_web.apk").getAbsolutePath();
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$0(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$1(UpdateActivity updateActivity) {
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$3(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$5(UpdateActivity updateActivity) {
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
                updateActivity.downloadInfoVisibility(false);
                updateActivity.mIsStartingUpdate = false;
                updateActivity.requestReUpdateGameData();
            }
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$7(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$8(UpdateActivity updateActivity) {
            updateActivity.mIsStartingUpdate = false;
            updateActivity.requestUpdateGameData();
            updateActivity.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$10(UpdateActivity updateActivity) {
            updateActivity.setUpdateServiceAsBackground();
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$17(UpdateActivity updateActivity) {
            updateActivity.finishAffinity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$18(UpdateActivity updateActivity) {
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
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.UpdateActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkFreeSpace$lambda$0;
                    checkFreeSpace$lambda$0 = UpdateActivity.checkFreeSpace$lambda$0(UpdateActivity.this);
                    return checkFreeSpace$lambda$0;
                }
            });
            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
            do {
            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "", "Выйти", "Недостаточно места", "Недостаточно места для установки ресурсов игры. Требуется " + Util.humanReadableBytes(j, true))));
            return;
        }
        requestUpdateStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            String format = String.format("%.2f Gb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1073741824)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (j >= 1048576) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f Mb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else if (j >= 1024) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f Kb", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        } else {
            return j + " Byte";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadInfoVisibility(boolean z) {
        ActivityUpdateBinding activityUpdateBinding = this.binding;
        ActivityUpdateBinding activityUpdateBinding2 = null;
        if (activityUpdateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding = null;
        }
        TextView textView15 = activityUpdateBinding.textView15;
        Intrinsics.checkNotNullExpressionValue(textView15, "textView15");
        textView15.setVisibility(z ? 0 : 8);
        ActivityUpdateBinding activityUpdateBinding3 = this.binding;
        if (activityUpdateBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding3 = null;
        }
        TextView textView16 = activityUpdateBinding3.textView16;
        Intrinsics.checkNotNullExpressionValue(textView16, "textView16");
        textView16.setVisibility(z ? 0 : 8);
        ActivityUpdateBinding activityUpdateBinding4 = this.binding;
        if (activityUpdateBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding4 = null;
        }
        TextView speedDownloaded = activityUpdateBinding4.speedDownloaded;
        Intrinsics.checkNotNullExpressionValue(speedDownloaded, "speedDownloaded");
        speedDownloaded.setVisibility(z ? 0 : 8);
        ActivityUpdateBinding activityUpdateBinding5 = this.binding;
        if (activityUpdateBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding5 = null;
        }
        TextView bytesDownloaded = activityUpdateBinding5.bytesDownloaded;
        Intrinsics.checkNotNullExpressionValue(bytesDownloaded, "bytesDownloaded");
        bytesDownloaded.setVisibility(z ? 0 : 8);
        ActivityUpdateBinding activityUpdateBinding6 = this.binding;
        if (activityUpdateBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding6 = null;
        }
        TextView currentLen = activityUpdateBinding6.currentLen;
        Intrinsics.checkNotNullExpressionValue(currentLen, "currentLen");
        currentLen.setVisibility(z ? 0 : 8);
        ActivityUpdateBinding activityUpdateBinding7 = this.binding;
        if (activityUpdateBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUpdateBinding2 = activityUpdateBinding7;
        }
        TextView currentSpeed = activityUpdateBinding2.currentSpeed;
        Intrinsics.checkNotNullExpressionValue(currentSpeed, "currentSpeed");
        currentSpeed.setVisibility(z ? 0 : 8);
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
        Uri uriForFile = FileProvider.getUriForFile(this, "com.arizona21.game.web.fileprovider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.setFlags(268435456);
        intent.addFlags(1);
        startActivity(intent);
    }
}
