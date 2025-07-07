package com.arizona.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
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
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.windowsizeclass.AndroidWindowSizeClass_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.arizona.game.GTASA;
import com.arizona.game.R;
import com.arizona.launcher.LogcatHelper;
import com.arizona.launcher.MainEntrench;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.model.servers.ServerType;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.arizona.launcher.ui.notifications.NotificationsViewModel;
import com.arizona.launcher.util.FlavorUtilKt;
import com.arkivanov.decompose.RetainedComponentKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.miami.game.core.app.root.nav.main.DialogMainState;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.core.app.root.nav.main.MainExternalUiStateHolder;
import com.miami.game.core.app.root.nav.main.MainState;
import com.miami.game.core.app.root.nav.main.compose.MainRouteKt;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiState;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogType;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.home.ui.model.HomeExternalUiState;
import com.miami.game.feature.home.ui.model.HomeExternalUiStateHolder;
import com.miami.game.feature.notifications.NotificationStateHolder;
import com.miami.game.ui.theme.ThemeKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.json.JSONObject;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.rustore.sdk.appupdate.manager.factory.RuStoreAppUpdateManagerFactory;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.core.tasks.OnFailureListener;
import ru.rustore.sdk.core.tasks.OnSuccessListener;
import timber.log.Timber;
/* compiled from: MainEntrench.kt */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001Z\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0002\\]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0015J\b\u0010)\u001a\u00020&H\u0014J\r\u0010*\u001a\u00020&H\u0007¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0018H\u0002J\u001e\u0010/\u001a\u00020&2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020&01H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\u0018\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0014J\b\u0010C\u001a\u00020&H\u0014J\b\u0010D\u001a\u00020&H\u0014J\b\u0010E\u001a\u00020&H\u0002J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020\u0015H\u0002J\b\u0010H\u001a\u00020&H\u0002J\u000e\u0010I\u001a\u00020\u00152\u0006\u00108\u001a\u000209J\u0010\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0015H\u0002J\b\u0010L\u001a\u00020&H\u0002J\b\u0010M\u001a\u00020&H\u0002J\b\u0010N\u001a\u00020&H\u0002J\b\u0010O\u001a\u00020&H\u0002J\b\u0010P\u001a\u00020&H\u0002J&\u0010Q\u001a\u00020R*\u00020S2\u0006\u0010@\u001a\u00020-2\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020&H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[¨\u0006^"}, d2 = {"Lcom/arizona/launcher/MainEntrench;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mService", "Landroid/os/Messenger;", "mMessenger", "mainViewModel", "Lcom/arizona/launcher/MainViewModel;", "getMainViewModel", "()Lcom/arizona/launcher/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "notificationsViewModel", "Lcom/arizona/launcher/ui/notifications/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/arizona/launcher/ui/notifications/NotificationsViewModel;", "notificationsViewModel$delegate", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "isStartApp", "", "permissionAsk", "lastStartGameTime", "", "rootFactory", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;", "getRootFactory", "()Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;", "setRootFactory", "(Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;)V", "notificationStateHolder", "Lcom/miami/game/feature/notifications/NotificationStateHolder;", "getNotificationStateHolder", "()Lcom/miami/game/feature/notifications/NotificationStateHolder;", "setNotificationStateHolder", "(Lcom/miami/game/feature/notifications/NotificationStateHolder;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "GLView", "(Landroidx/compose/runtime/Composer;I)V", "convertBytesToHumanReadable", "", "bytes", "getCurrentToken", "callback", "Lkotlin/Function1;", "checkRUStoreUpdate", "saveGameType", "getBuildType", "initTracking", "obtainReferrerDetails", "checkNotificationPermission", "context", "Landroid/content/Context;", "openNotificationSettings", "askPermission", "checkUpdate", "observeData", "createDialog", "message", "url", "startApp", "onResume", "onPause", "onDestroy", "check", "checkLauncherUpdate", "getFirstOpen", "checkGameUpdate", "isOnline", "setProgressVisible", "visible", "showDialog", "hideDialog", "checkGame", "connectToTestServer", "shareLogs", "sendRequests", "Lkotlinx/coroutines/Job;", "Landroidx/activity/ComponentActivity;", "iterations", "", "queue", "Lcom/android/volley/RequestQueue;", "startGame", "mConnection", "com/arizona/launcher/MainEntrench$mConnection$1", "Lcom/arizona/launcher/MainEntrench$mConnection$1;", "Companion", "IncomingHandler", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class MainEntrench extends Hilt_MainEntrench {
    private static final String TAG = "MainEntrench";
    private boolean isStartApp;
    private long lastStartGameTime;
    private Messenger mService;
    private final Lazy mainViewModel$delegate;
    @Inject
    public NotificationStateHolder notificationStateHolder;
    private final Lazy notificationsViewModel$delegate;
    private boolean permissionAsk;
    private InstallReferrerClient referrerClient;
    @Inject
    public MainComponent.Factory rootFactory;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private final MainEntrench$mConnection$1 mConnection = new ServiceConnection() { // from class: com.arizona.launcher.MainEntrench$mConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(service, "service");
            MainEntrench.this.mService = new Messenger(service);
            MainEntrench.this.check();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            MainEntrench.this.mService = null;
        }
    };

    /* compiled from: MainEntrench.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GLSurfaceViewForExtensions GLView$lambda$13$lambda$12(GLSurfaceViewForExtensions gLSurfaceViewForExtensions, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return gLSurfaceViewForExtensions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GLView$lambda$14(MainEntrench mainEntrench, int i, Composer composer, int i2) {
        mainEntrench.GLView(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* compiled from: MainEntrench.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/MainEntrench$Companion;", "", "<init>", "()V", "TAG", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.arizona.launcher.MainEntrench$mConnection$1] */
    public MainEntrench() {
        final MainEntrench mainEntrench = this;
        this.mainViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? mainEntrench.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.notificationsViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? mainEntrench.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel$delegate.getValue();
    }

    public final MainComponent.Factory getRootFactory() {
        MainComponent.Factory factory = this.rootFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootFactory");
        return null;
    }

    public final void setRootFactory(MainComponent.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.rootFactory = factory;
    }

    public final NotificationStateHolder getNotificationStateHolder() {
        NotificationStateHolder notificationStateHolder = this.notificationStateHolder;
        if (notificationStateHolder != null) {
            return notificationStateHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationStateHolder");
        return null;
    }

    public final void setNotificationStateHolder(NotificationStateHolder notificationStateHolder) {
        Intrinsics.checkNotNullParameter(notificationStateHolder, "<set-?>");
        this.notificationStateHolder = notificationStateHolder;
    }

    @Override // com.arizona.launcher.Hilt_MainEntrench, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MainEntrench$onCreate$1(null), 3, null);
            EdgeToEdge.enable$default(this, null, null, 3, null);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
            Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
            insetsController.setSystemBarsBehavior(2);
            insetsController.hide(WindowInsetsCompat.Type.systemBars());
            SplashScreen.Companion.installSplashScreen(this);
            ConnectionHolder.INSTANCE.setOnConnectTest(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onCreate$lambda$0;
                    onCreate$lambda$0 = MainEntrench.onCreate$lambda$0(MainEntrench.this);
                    return onCreate$lambda$0;
                }
            });
            ConnectionHolder.INSTANCE.setOnShareLogs(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onCreate$lambda$1;
                    onCreate$lambda$1 = MainEntrench.onCreate$lambda$1(MainEntrench.this);
                    return onCreate$lambda$1;
                }
            });
            ConnectionHolder.INSTANCE.setOnStartGame(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onCreate$lambda$2;
                    onCreate$lambda$2 = MainEntrench.onCreate$lambda$2(MainEntrench.this);
                    return onCreate$lambda$2;
                }
            });
            ConnectionHolder.INSTANCE.setOnCheckGame(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onCreate$lambda$4;
                    onCreate$lambda$4 = MainEntrench.onCreate$lambda$4(MainEntrench.this);
                    return onCreate$lambda$4;
                }
            });
            getNotificationStateHolder().setViewModel(getNotificationsViewModel());
            LogcatHelper.Companion companion = LogcatHelper.Companion;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            LogcatHelper companion2 = companion.getInstance(applicationContext);
            if (companion2 != null) {
                companion2.start();
            }
            final SharedPreferences sharedPreferences = getSharedPreferences("myAppPreference", 0);
            saveGameType();
            String string = sharedPreferences.getString("token", "");
            if (string != null && string.length() == 0) {
                getCurrentToken(new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit onCreate$lambda$6;
                        onCreate$lambda$6 = MainEntrench.onCreate$lambda$6(sharedPreferences, (String) obj);
                        return onCreate$lambda$6;
                    }
                });
            }
            String string2 = sharedPreferences.getString("referrerUrl", "");
            if (string2 != null && string2.length() == 0) {
                initTracking();
            }
            String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
            String str = (String) ArraysKt.firstOrNull(SUPPORTED_ABIS);
            if (str == null) {
                str = "unknown";
            }
            Toast.makeText(this, str + " v16.3.7 release_web", 1).show();
            if (Build.VERSION.SDK_INT >= 26) {
                if (!getFirstOpen()) {
                    Context applicationContext2 = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                    if (!checkNotificationPermission(applicationContext2)) {
                        askPermission();
                    } else {
                        getBuildType();
                    }
                } else {
                    getBuildType();
                }
            } else {
                getBuildType();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MainEntrench$onCreate$7(this, null), 3, null);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        MainEntrench mainEntrench = this;
        final MainComponent mainComponent = (MainComponent) RetainedComponentKt.retainedComponent$default((ComponentActivity) mainEntrench, (String) null, false, false, (Function0) null, (Function1) new MainEntrench$onCreate$root$1(getRootFactory()), 15, (Object) null);
        ComponentActivityKt.setContent$default(mainEntrench, null, ComposableLambdaKt.composableLambdaInstance(1553775207, true, new Function2<Composer, Integer, Unit>() { // from class: com.arizona.launcher.MainEntrench$onCreate$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C240@9266L269,240@9247L288:MainEntrench.kt#5ji0rp");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1553775207, i, -1, "com.arizona.launcher.MainEntrench.onCreate.<anonymous> (MainEntrench.kt:240)");
                    }
                    final MainEntrench mainEntrench2 = MainEntrench.this;
                    final MainComponent mainComponent2 = mainComponent;
                    ThemeKt.MyApplicationTheme(false, false, ComposableLambdaKt.rememberComposableLambda(783987227, true, new Function2<Composer, Integer, Unit>() { // from class: com.arizona.launcher.MainEntrench$onCreate$8.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C241@9284L237:MainEntrench.kt#5ji0rp");
                            if ((i2 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(783987227, i2, -1, "com.arizona.launcher.MainEntrench.onCreate.<anonymous>.<anonymous> (MainEntrench.kt:241)");
                                }
                                MainEntrench mainEntrench3 = MainEntrench.this;
                                MainComponent mainComponent3 = mainComponent2;
                                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1707295508, "C242@9313L8,246@9438L43,244@9343L160:MainEntrench.kt#5ji0rp");
                                mainEntrench3.GLView(composer2, 0);
                                MainRouteKt.MainRoute(mainComponent3, AndroidWindowSizeClass_androidKt.calculateWindowSizeClass(mainEntrench3, composer2, 0), composer2, MainComponent.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 1, null);
        File externalFilesDir = getExternalFilesDir(null);
        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/app-arizona-release_web.apk");
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(MainEntrench mainEntrench) {
        if (UtilsKt.getZipFileIcons() == null) {
            com.arizona.launcher.util.UtilsKt.initZip(mainEntrench);
        }
        mainEntrench.connectToTestServer();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(MainEntrench mainEntrench) {
        mainEntrench.shareLogs();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(MainEntrench mainEntrench) {
        Context applicationContext = mainEntrench.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        com.arizona.launcher.util.UtilsKt.checkItemsName(applicationContext, FlavorUtilKt.isArizona());
        if (UtilsKt.getZipFileIcons() == null) {
            Context applicationContext2 = mainEntrench.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            com.arizona.launcher.util.UtilsKt.initZip(applicationContext2);
        }
        mainEntrench.startGame();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4(MainEntrench mainEntrench) {
        HomeExternalUiState value;
        MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
        do {
            value = homeStateStore.getValue();
        } while (!homeStateStore.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, true, false, false, 7, null)));
        mainEntrench.checkGame();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            sharedPreferences.edit().putString("token", str).apply();
            System.out.println((Object) ("Current token: " + str));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void GLView(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(163249873);
        ComposerKt.sourceInformation(startRestartGroup, "C(GLView)268@9943L7,269@10000L7,271@10030L48,273@10121L464,273@10088L497,288@10630L10,287@10595L150:MainEntrench.kt#5ji0rp");
        if ((i & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163249873, i, -1, "com.arizona.launcher.MainEntrench.GLView (MainEntrench.kt:267)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
            startRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):MainEntrench.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new GLSurfaceViewForExtensions(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final GLSurfaceViewForExtensions gLSurfaceViewForExtensions = (GLSurfaceViewForExtensions) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):MainEntrench.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(gLSurfaceViewForExtensions) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult GLView$lambda$11$lambda$10;
                        GLView$lambda$11$lambda$10 = MainEntrench.GLView$lambda$11$lambda$10(LifecycleOwner.this, gLSurfaceViewForExtensions, (DisposableEffectScope) obj);
                        return GLView$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) rememberedValue2, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):MainEntrench.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(gLSurfaceViewForExtensions);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        GLSurfaceViewForExtensions GLView$lambda$13$lambda$12;
                        GLView$lambda$13$lambda$12 = MainEntrench.GLView$lambda$13$lambda$12(GLSurfaceViewForExtensions.this, (Context) obj);
                        return GLView$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView(rememberedValue3, SizeKt.m771height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(1)), null, startRestartGroup, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GLView$lambda$14;
                    GLView$lambda$14 = MainEntrench.GLView$lambda$14(MainEntrench.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GLView$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult GLView$lambda$11$lambda$10(final LifecycleOwner lifecycleOwner, final GLSurfaceViewForExtensions gLSurfaceViewForExtensions, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MainEntrench.GLView$lambda$11$lambda$10$lambda$8(GLSurfaceViewForExtensions.this, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: com.arizona.launcher.MainEntrench$GLView$lambda$11$lambda$10$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GLView$lambda$11$lambda$10$lambda$8(GLSurfaceViewForExtensions gLSurfaceViewForExtensions, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            gLSurfaceViewForExtensions.onResume();
        } else if (i != 2) {
        } else {
            gLSurfaceViewForExtensions.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertBytesToHumanReadable(long j) {
        if (j >= 1073741824) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f Gb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1073741824)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (j >= 1048576) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f Mb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else if (j >= 1024) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f Kb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        } else {
            return j + " Byte";
        }
    }

    private final void getCurrentToken(final Function1<? super String, Unit> function1) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MainEntrench.getCurrentToken$lambda$15(Function1.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrentToken$lambda$15(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            function1.invoke(null);
        } else {
            function1.invoke((String) task.getResult());
        }
    }

    private final void checkRUStoreUpdate() {
        RuStoreAppUpdateManagerFactory.create$default(RuStoreAppUpdateManagerFactory.INSTANCE, this, null, 2, null).getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda6
            @Override // ru.rustore.sdk.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainEntrench.checkRUStoreUpdate$lambda$19(MainEntrench.this, (AppUpdateInfo) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda7
            @Override // ru.rustore.sdk.core.tasks.OnFailureListener
            public final void onFailure(Throwable th) {
                MainEntrench.checkRUStoreUpdate$lambda$20(MainEntrench.this, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkRUStoreUpdate$lambda$19(final MainEntrench mainEntrench, AppUpdateInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getUpdateAvailability() == 2) {
            mainEntrench.setProgressVisible(false);
            mainEntrench.showDialog();
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkRUStoreUpdate$lambda$19$lambda$16;
                    checkRUStoreUpdate$lambda$19$lambda$16 = MainEntrench.checkRUStoreUpdate$lambda$19$lambda$16(MainEntrench.this);
                    return checkRUStoreUpdate$lambda$19$lambda$16;
                }
            });
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkRUStoreUpdate$lambda$19$lambda$17;
                    checkRUStoreUpdate$lambda$19$lambda$17 = MainEntrench.checkRUStoreUpdate$lambda$19$lambda$17(MainEntrench.this);
                    return checkRUStoreUpdate$lambda$19$lambda$17;
                }
            });
            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
            do {
            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Обновить", "Выйти", "Доступна новая версия приложения", "Для того чтобы обновить приложение, Вам необходимо нажать кнопку \"Обновить\".\nПосле чего обновить версию в RuStore.\nЖелаете ли Вы обновить версию?")));
        } else if (mainEntrench.isStartApp) {
        } else {
            mainEntrench.startApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkRUStoreUpdate$lambda$19$lambda$16(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkRUStoreUpdate$lambda$19$lambda$17(MainEntrench mainEntrench) {
        if (FlavorUtilKt.isArizona()) {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://apps.rustore.ru/app/com.arizona21.game.ru")));
        } else {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://apps.rustore.ru/app/com.rodina21.game.ru")));
        }
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkRUStoreUpdate$lambda$20(MainEntrench mainEntrench, Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (mainEntrench.isStartApp) {
            return;
        }
        mainEntrench.startApp();
    }

    private final void saveGameType() {
        SharedPreferences sharedPreferences = getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (FlavorUtilKt.isArizona()) {
            edit.putBoolean("isArizonaType", true);
        } else {
            edit.putBoolean("isArizonaType", false);
        }
        edit.apply();
    }

    private final void getBuildType() {
        if (Intrinsics.areEqual("release_web", getString(R.string.release)) || Intrinsics.areEqual("release_web", getString(R.string.release_ru))) {
            observeData();
        } else if (Intrinsics.areEqual("release_web", getString(R.string.release_hw))) {
            startApp();
        } else if (Intrinsics.areEqual("release_web", getString(R.string.debug)) || Intrinsics.areEqual("release_web", getString(R.string.staging)) || Intrinsics.areEqual("release_web", getString(R.string.release_web)) || Intrinsics.areEqual("release_web", getString(R.string.public_debug)) || Intrinsics.areEqual("release_web", getString(R.string.release_old))) {
            startApp();
        }
    }

    private final void initTracking() {
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this).build();
            this.referrerClient = build;
            if (build == null) {
                Intrinsics.throwUninitializedPropertyAccessException("referrerClient");
                build = null;
            }
            build.startConnection(new InstallReferrerStateListener() { // from class: com.arizona.launcher.MainEntrench$initTracking$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i) {
                    if (i == 0) {
                        Log.d("REFERRER", "RESPONSE_OK");
                        MainEntrench.this.obtainReferrerDetails();
                    } else if (i == 1) {
                        Log.d("REFERRER", "SERVICE_UNAVAILABLE");
                    } else if (i != 2) {
                    } else {
                        Log.d("REFERRER", "FEATURE_NOT_SUPPORTED");
                    }
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    Log.d("REFERRER", "SERVICE_DISCONNECTED");
                }
            });
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void obtainReferrerDetails() {
        try {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SP_NAME", 0);
            InstallReferrerClient installReferrerClient = this.referrerClient;
            InstallReferrerClient installReferrerClient2 = null;
            if (installReferrerClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("referrerClient");
                installReferrerClient = null;
            }
            ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
            Intrinsics.checkNotNullExpressionValue(installReferrer, "getInstallReferrer(...)");
            Log.d("REFERRER_TAG", "KEY_REFERRER_CLICK_TIMESTAMP - " + installReferrer.getReferrerClickTimestampSeconds());
            Log.d("REFERRER_TAG", "KEY_GOOGLE_PLAY_INSTANT - " + installReferrer.getGooglePlayInstantParam());
            Log.d("REFERRER_TAG", "KEY_INSTALL_VERSION - " + installReferrer.getInstallVersion());
            String installReferrer2 = installReferrer.getInstallReferrer();
            Intrinsics.checkNotNullExpressionValue(installReferrer2, "getInstallReferrer(...)");
            Log.d("REFERRER_TAG", "referrerUrl - " + installReferrer2);
            sharedPreferences.edit().putString("referrerUrl", installReferrer2).apply();
            InstallReferrerClient installReferrerClient3 = this.referrerClient;
            if (installReferrerClient3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("referrerClient");
            } else {
                installReferrerClient2 = installReferrerClient3;
            }
            installReferrerClient2.endConnection();
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
        }
    }

    private final boolean checkNotificationPermission(Context context) {
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return from.areNotificationsEnabled();
    }

    private final void openNotificationSettings(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private final void askPermission() {
        if (this.permissionAsk) {
            return;
        }
        setProgressVisible(false);
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit askPermission$lambda$21;
                askPermission$lambda$21 = MainEntrench.askPermission$lambda$21(MainEntrench.this);
                return askPermission$lambda$21;
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit askPermission$lambda$22;
                askPermission$lambda$22 = MainEntrench.askPermission$lambda$22(MainEntrench.this);
                return askPermission$lambda$22;
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "Разрешить", "Пропустить", "Разрешите уведомления", "Для оптимальной функциональности приложения требуется \nпредоставление разрешения на отправку уведомлений.")));
        this.permissionAsk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askPermission$lambda$21(MainEntrench mainEntrench) {
        mainEntrench.hideDialog();
        mainEntrench.permissionAsk = false;
        mainEntrench.getBuildType();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askPermission$lambda$22(MainEntrench mainEntrench) {
        Context applicationContext = mainEntrench.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        mainEntrench.openNotificationSettings(applicationContext);
        mainEntrench.permissionAsk = true;
        mainEntrench.askPermission();
        mainEntrench.hideDialog();
        return Unit.INSTANCE;
    }

    private final void checkUpdate() {
        AppUpdateManager create = AppUpdateManagerFactory.create(this);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        Task<com.google.android.play.core.appupdate.AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
        Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "getAppUpdateInfo(...)");
        final Function1 function1 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit checkUpdate$lambda$27;
                checkUpdate$lambda$27 = MainEntrench.checkUpdate$lambda$27(MainEntrench.this, (com.google.android.play.core.appupdate.AppUpdateInfo) obj);
                return checkUpdate$lambda$27;
            }
        };
        appUpdateInfo.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Function1.this.invoke(obj);
            }
        }).addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MainEntrench.checkUpdate$lambda$29(MainEntrench.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUpdate$lambda$27(final MainEntrench mainEntrench, com.google.android.play.core.appupdate.AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2) {
            mainEntrench.setProgressVisible(false);
            mainEntrench.showDialog();
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkUpdate$lambda$27$lambda$24;
                    checkUpdate$lambda$27$lambda$24 = MainEntrench.checkUpdate$lambda$27$lambda$24(MainEntrench.this);
                    return checkUpdate$lambda$27$lambda$24;
                }
            });
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkUpdate$lambda$27$lambda$25;
                    checkUpdate$lambda$27$lambda$25 = MainEntrench.checkUpdate$lambda$27$lambda$25(MainEntrench.this);
                    return checkUpdate$lambda$27$lambda$25;
                }
            });
            MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
            do {
            } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Обновить", "Выйти", "Доступна новая версия приложения", "Для того чтобы обновить приложение, Вам необходимо нажать кнопку \"Обновить\".\nПосле чего обновить версию в Play Market.\nЖелаете ли Вы обновить версию?")));
        } else if (!mainEntrench.isStartApp) {
            mainEntrench.startApp();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUpdate$lambda$27$lambda$24(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUpdate$lambda$27$lambda$25(MainEntrench mainEntrench) {
        if (FlavorUtilKt.isArizona()) {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.arizona21.game&hl=ru&gl=US")));
        } else {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.rodina21.game&hl=ru&gl=US")));
        }
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkUpdate$lambda$29(MainEntrench mainEntrench, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (mainEntrench.isStartApp) {
            return;
        }
        mainEntrench.startApp();
    }

    private final void observeData() {
        if (Intrinsics.areEqual("release_web", getString(R.string.release))) {
            checkUpdate();
        } else {
            checkRUStoreUpdate();
        }
    }

    private final void createDialog(final String str, final String str2) {
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(this).setMessage((CharSequence) str).setPositiveButton((CharSequence) getString(R.string.open_website), new DialogInterface.OnClickListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainEntrench.createDialog$lambda$30(MainEntrench.this, str, str2, dialogInterface, i);
            }
        });
        positiveButton.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainEntrench.createDialog$lambda$32$lambda$31(MainEntrench.this, dialogInterface, i);
            }
        });
        AlertDialog create = positiveButton.create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$30(MainEntrench mainEntrench, String str, String str2, DialogInterface dialogInterface, int i) {
        mainEntrench.createDialog(str, str2);
        mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$32$lambda$31(MainEntrench mainEntrench, DialogInterface dialogInterface, int i) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final void startApp() {
        this.isStartApp = true;
        bindService(new Intent(this, UpdateService.class), this.mConnection, 1);
        try {
            com.arizona.launcher.util.UtilsKt.sendDataAnalytics(this, "launch", 3);
        } catch (Exception e) {
            Log.e("sendDataAnalytics", "ERROR");
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.permissionAsk) {
            hideDialog();
            this.permissionAsk = false;
            getBuildType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.arizona.launcher.Hilt_MainEntrench, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mService != null) {
            unbindService(this.mConnection);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void check() {
        setProgressVisible(true);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (isOnline(applicationContext)) {
            checkLauncherUpdate();
            return;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
        if (isFinishing()) {
            return;
        }
        setProgressVisible(false);
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit check$lambda$34;
                check$lambda$34 = MainEntrench.check$lambda$34(MainEntrench.this);
                return check$lambda$34;
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit check$lambda$35;
                check$lambda$35 = MainEntrench.check$lambda$35(MainEntrench.this);
                return check$lambda$35;
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Нет подключения к сети", "Проверьте ваше интернет соединение и попробуйте снова")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit check$lambda$34(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit check$lambda$35(MainEntrench mainEntrench) {
        mainEntrench.hideDialog();
        mainEntrench.check();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkLauncherUpdate() {
        if (!Intrinsics.areEqual("release_web", getString(R.string.release)) && !Intrinsics.areEqual("release_web", getString(R.string.release_hw)) && !Intrinsics.areEqual("release_web", getString(R.string.release_ru))) {
            if (this.mService == null) {
                return;
            }
            Message obtain = Message.obtain((Handler) null, 3);
            obtain.replyTo = this.mMessenger;
            try {
                Messenger messenger = this.mService;
                Intrinsics.checkNotNull(messenger);
                messenger.send(obtain);
                return;
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
                e.printStackTrace();
                return;
            }
        }
        checkGameUpdate();
    }

    private final boolean getFirstOpen() {
        return getApplicationContext().getSharedPreferences("SP_NAME", 0).getBoolean("firstOpen", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkGameUpdate() {
        if (this.mService == null) {
            return;
        }
        setProgressVisible(true);
        Message obtain = Message.obtain((Handler) null, 0);
        obtain.replyTo = this.mMessenger;
        try {
            Messenger messenger = this.mService;
            Intrinsics.checkNotNull(messenger);
            messenger.send(obtain);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
        }
    }

    public final boolean isOnline(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProgressVisible(boolean z) {
        Timber.Forest.d("mainStateStore " + z, new Object[0]);
        MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
        while (true) {
            HomeExternalUiState value = homeStateStore.getValue();
            boolean z2 = z;
            if (homeStateStore.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, z2, false, false, 55, null))) {
                return;
            }
            z = z2;
        }
    }

    /* compiled from: MainEntrench.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/MainEntrench$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/MainEntrench;", "<init>", "(Lcom/arizona/launcher/MainEntrench;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class IncomingHandler extends Handler {
        private final WeakReference<MainEntrench> activityRef;

        /* compiled from: MainEntrench.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[UpdateService.Errno.values().length];
                try {
                    iArr[UpdateService.Errno.UpdateServerUnreachable.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomingHandler(MainEntrench ref) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.activityRef = new WeakReference<>(ref);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            HomeExternalUiState value;
            HomeExternalUiState value2;
            HomeExternalUiState value3;
            HomeExternalUiState value4;
            Intrinsics.checkNotNullParameter(msg, "msg");
            final MainEntrench mainEntrench = this.activityRef.get();
            if (mainEntrench == null || mainEntrench.isFinishing() || mainEntrench.isDestroyed()) {
                return;
            }
            int i = msg.what;
            if (i == 0) {
                Serializable serializable = msg.getData().getSerializable(UpdateService.ERRNO_MSG);
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.arizona.launcher.UpdateService.Errno");
                if (WhenMappings.$EnumSwitchMapping$0[((UpdateService.Errno) serializable).ordinal()] == 1) {
                    mainEntrench.setProgressVisible(false);
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$6;
                            handleMessage$lambda$6 = MainEntrench.IncomingHandler.handleMessage$lambda$6(MainEntrench.this);
                            return handleMessage$lambda$6;
                        }
                    });
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$7;
                            handleMessage$lambda$7 = MainEntrench.IncomingHandler.handleMessage$lambda$7(MainEntrench.this);
                            return handleMessage$lambda$7;
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения к серверу обновления", "Проверьте ваше интернет соединение и попробуйте снова")));
                } else if (!msg.getData().getBoolean(NotificationCompat.CATEGORY_STATUS, false)) {
                    Log.e(MainEntrench.TAG, "Error check update");
                } else {
                    boolean z = msg.getData().getBoolean("isGameDataUpdateExists", true);
                    String convertBytesToHumanReadable = mainEntrench.convertBytesToHumanReadable(msg.getData().getLong("total_size", 0L));
                    mainEntrench.setProgressVisible(false);
                    if (z) {
                        MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                        do {
                            value2 = homeStateStore.getValue();
                        } while (!homeStateStore.compareAndSet(value2, HomeExternalUiState.copy$default(value2, false, null, convertBytesToHumanReadable, false, true, false, 11, null)));
                        DownloadExternalUiStateHolder.INSTANCE.setOnStartDownload(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit handleMessage$lambda$10;
                                handleMessage$lambda$10 = MainEntrench.IncomingHandler.handleMessage$lambda$10(MainEntrench.this);
                                return handleMessage$lambda$10;
                            }
                        });
                        return;
                    }
                    MutableStateFlow<HomeExternalUiState> homeStateStore2 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                    do {
                        value = homeStateStore2.getValue();
                    } while (!homeStateStore2.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, false, false, true, 15, null)));
                }
            } else if (i != 3) {
                if (i != 8) {
                    return;
                }
                if (msg.getData().getBoolean(NotificationCompat.CATEGORY_STATUS, true)) {
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$12;
                            handleMessage$lambda$12 = MainEntrench.IncomingHandler.handleMessage$lambda$12(MainEntrench.this);
                            return handleMessage$lambda$12;
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore2 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore2.compareAndSet(stateStore2.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Repair, "", "Закрыть", "ФАЙЛЫ ПРОВЕРЕНЫ", "Все файлы успешно прошли проверку")));
                    MutableStateFlow<HomeExternalUiState> homeStateStore3 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                    do {
                        value4 = homeStateStore3.getValue();
                    } while (!homeStateStore3.compareAndSet(value4, HomeExternalUiState.copy$default(value4, false, null, null, false, false, true, 7, null)));
                    return;
                }
                MutableStateFlow<HomeExternalUiState> homeStateStore4 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                do {
                    value3 = homeStateStore4.getValue();
                } while (!homeStateStore4.compareAndSet(value3, HomeExternalUiState.copy$default(value3, false, null, null, false, true, false, 7, null)));
                ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit handleMessage$lambda$16;
                        handleMessage$lambda$16 = MainEntrench.IncomingHandler.handleMessage$lambda$16(MainEntrench.this);
                        return handleMessage$lambda$16;
                    }
                });
                MutableStateFlow<ErrorDialogExternalUiState> stateStore3 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                } while (!stateStore3.compareAndSet(stateStore3.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "Закрыть", "", "ТРЕБУЕТСЯ ПЕРЕЗАПУСК", "Проверка файлов выполнена, требуется перезапуск")));
                mainEntrench.showDialog();
            } else {
                Serializable serializable2 = msg.getData().getSerializable(UpdateService.ERRNO_MSG);
                Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type com.arizona.launcher.UpdateService.Errno");
                if (WhenMappings.$EnumSwitchMapping$0[((UpdateService.Errno) serializable2).ordinal()] == 1) {
                    mainEntrench.setProgressVisible(false);
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$0;
                            handleMessage$lambda$0 = MainEntrench.IncomingHandler.handleMessage$lambda$0(MainEntrench.this);
                            return handleMessage$lambda$0;
                        }
                    });
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$1;
                            handleMessage$lambda$1 = MainEntrench.IncomingHandler.handleMessage$lambda$1(MainEntrench.this);
                            return handleMessage$lambda$1;
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore4 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore4.compareAndSet(stateStore4.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Ошибка подключения к серверу обновления", "Проверьте ваше интернет соединение и попробуйте снова")));
                } else if (msg.getData().getBoolean(UpdateService.NEED_UPDATE_MSG, false)) {
                    mainEntrench.setProgressVisible(false);
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$3;
                            handleMessage$lambda$3 = MainEntrench.IncomingHandler.handleMessage$lambda$3(MainEntrench.this);
                            return handleMessage$lambda$3;
                        }
                    });
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit handleMessage$lambda$4;
                            handleMessage$lambda$4 = MainEntrench.IncomingHandler.handleMessage$lambda$4(MainEntrench.this);
                            return handleMessage$lambda$4;
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore5 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore5.compareAndSet(stateStore5.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Обновить", "Выйти", "Требуется обновление клиента", "Данная версия устарела, необходимо загрузить новую")));
                } else {
                    mainEntrench.checkGameUpdate();
                    mainEntrench.setProgressVisible(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$0(MainEntrench mainEntrench) {
            mainEntrench.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$1(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            mainEntrench.checkLauncherUpdate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$3(MainEntrench mainEntrench) {
            mainEntrench.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$4(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            Intent intent = new Intent(mainEntrench, UpdateActivity.class);
            intent.putExtra(UpdateActivity.UPDATE_MODE, "LauncherUpdate");
            mainEntrench.startActivity(intent);
            mainEntrench.finish();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$6(MainEntrench mainEntrench) {
            mainEntrench.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$7(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            mainEntrench.checkGameUpdate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$10(MainEntrench mainEntrench) {
            try {
                com.arizona.launcher.util.UtilsKt.sendDataAnalytics(mainEntrench, "start_download", 3);
            } catch (Exception e) {
                Log.e("sendDataAnalytics", "ERROR");
                FirebaseCrashlytics.getInstance().recordException(e);
                e.printStackTrace();
            }
            Intent intent = new Intent(mainEntrench, UpdateActivity.class);
            intent.putExtra(UpdateActivity.UPDATE_MODE, "GameUpdate");
            mainEntrench.startActivity(intent);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$12(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit handleMessage$lambda$16(MainEntrench mainEntrench) {
            mainEntrench.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog() {
        MainState value;
        MutableStateFlow<MainState> stateStore = MainExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, MainState.copy$default(value, DialogMainState.Error.INSTANCE, null, 2, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideDialog() {
        MainState value;
        MutableStateFlow<MainState> stateStore = MainExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
        } while (!stateStore.compareAndSet(value, MainState.copy$default(value, DialogMainState.Empty.INSTANCE, null, 2, null)));
    }

    private final void checkGame() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.clear();
        edit.commit();
        Message obtain = Message.obtain((Handler) null, 8);
        obtain.replyTo = this.mMessenger;
        Messenger messenger = this.mService;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    private final void connectToTestServer() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putInt2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.lastStartGameTime < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            return;
        }
        this.lastStartGameTime = elapsedRealtime;
        Log.d("onConnectGame", TtmlNode.START);
        File externalFilesDir = getExternalFilesDir(null);
        new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/SAMP/").mkdirs();
        File externalFilesDir2 = getExternalFilesDir(null);
        File file = new File((externalFilesDir2 != null ? externalFilesDir2.getPath() : null) + "/SAMP/settings.json");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        MainEntrench mainEntrench = this;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainEntrench);
        if (FlavorUtilKt.isArizona()) {
            if (defaultSharedPreferences != null && (edit2 = defaultSharedPreferences.edit()) != null && (putInt2 = edit2.putInt(SettingsConstants.PROJECT_ID, ServerType.ARIZONA.getBackendLaunchCode())) != null) {
                putInt2.apply();
            }
        } else if (defaultSharedPreferences != null && (edit = defaultSharedPreferences.edit()) != null && (putInt = edit.putInt(SettingsConstants.PROJECT_ID, ServerType.RODINA.getBackendLaunchCode())) != null) {
            putInt.apply();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        JSONObject jSONObject = new JSONObject();
        JSONObject put = new JSONObject().put("server", new JSONObject().put("id", defaultSharedPreferences != null ? Integer.valueOf(defaultSharedPreferences.getInt(SettingsConstants.PROJECT_ID, 0)) : null).put("serverid", 0));
        JSONObject put2 = new JSONObject().put("ip", ConnectionHolder.INSTANCE.getSettingsData().getIp());
        Integer intOrNull = StringsKt.toIntOrNull(ConnectionHolder.INSTANCE.getSettingsData().getPort());
        bufferedWriter.write(jSONObject.put("client", put.put("test", put2.put("port", intOrNull != null ? intOrNull.intValue() : 1).put("pass", ConnectionHolder.INSTANCE.getSettingsData().getPassword()))).put("launcher", new JSONObject().put(SettingsConstants.NICKNAME, getMainViewModel().getPlayerNick()).put(SettingsConstants.CHAT_PAGE_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getPageSize()).put(SettingsConstants.CHAT_FONT_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getChatFontSize()).put(SettingsConstants.CHAT_PRINT_TIMESTAMP, ConnectionHolder.INSTANCE.getSettingsData().getShowChatTime()).put(SettingsConstants.STREAMER_MODE, ConnectionHolder.INSTANCE.getSettingsData().getStreamerMode()).put(SettingsConstants.IS_HEAD_MOVING, defaultSharedPreferences != null ? Boolean.valueOf(defaultSharedPreferences.getBoolean(SettingsConstants.IS_HEAD_MOVING, false)) : null)).toString());
        bufferedWriter.close();
        startActivity(new Intent(mainEntrench, GTASA.class));
    }

    private final void shareLogs() {
        File externalFilesDir = getExternalFilesDir(null);
        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/logcat/samp.log");
        File externalFilesDir2 = getExternalFilesDir(null);
        File file2 = new File((externalFilesDir2 != null ? externalFilesDir2.getPath() : null) + "/AZVoice/azvoice.log");
        File externalFilesDir3 = getExternalFilesDir(null);
        File file3 = new File((externalFilesDir3 != null ? externalFilesDir3.getPath() : null) + "/logcat/client.log");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        File[] fileArr = {file, file2, file3};
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.arrayListOf(fileArr)) {
            File file4 = (File) obj;
            if (file4.exists() && file4.length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList<File> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (File file5 : arrayList3) {
            arrayList4.add(FileProvider.getUriForFile(this, "com.arizona21.game.web.fileprovider", file5));
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList4);
        intent.setType("*/*");
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, "Отправить логи"));
    }

    static /* synthetic */ Job sendRequests$default(MainEntrench mainEntrench, ComponentActivity componentActivity, String str, int i, RequestQueue requestQueue, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            requestQueue = Volley.newRequestQueue(componentActivity.getApplicationContext());
        }
        return mainEntrench.sendRequests(componentActivity, str, i, requestQueue);
    }

    private final Job sendRequests(ComponentActivity componentActivity, String str, int i, RequestQueue requestQueue) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), Dispatchers.getIO(), null, new MainEntrench$sendRequests$1(i, str, requestQueue, null), 2, null);
        return launch$default;
    }

    private final void startGame() {
        ServerType serverType;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.lastStartGameTime < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            return;
        }
        this.lastStartGameTime = elapsedRealtime;
        if (ConnectionHolder.INSTANCE.getSelectedServer().isMobile() && FlavorUtilKt.isArizona()) {
            serverType = ServerType.ARIZONA_MOBILE;
        } else if (!ConnectionHolder.INSTANCE.getSelectedServer().isMobile() && FlavorUtilKt.isArizona()) {
            serverType = ServerType.ARIZONA;
        } else if (ConnectionHolder.INSTANCE.getSelectedServer().isMobile() || FlavorUtilKt.isArizona()) {
            serverType = (!ConnectionHolder.INSTANCE.getSelectedServer().isMobile() || FlavorUtilKt.isArizona()) ? ServerType.ARIZONA : ServerType.RODINA_MOBILE;
        } else {
            serverType = ServerType.RODINA;
        }
        ServerType serverType2 = serverType;
        MainEntrench mainEntrench = this;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainEntrench);
        if (defaultSharedPreferences != null && (edit = defaultSharedPreferences.edit()) != null && (putInt = edit.putInt(SettingsConstants.PROJECT_ID, serverType2.getBackendLaunchCode())) != null) {
            putInt.apply();
        }
        File externalFilesDir = getExternalFilesDir(null);
        new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/SAMP/").mkdirs();
        File externalFilesDir2 = getExternalFilesDir(null);
        File file = new File((externalFilesDir2 != null ? externalFilesDir2.getPath() : null) + "/SAMP/settings.json");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(new JSONObject().put("client", new JSONObject().put("server", new JSONObject().put("id", serverType2.getBackendLaunchCode()).put("serverid", ConnectionHolder.INSTANCE.getSelectedServer().getNumber()))).put("launcher", new JSONObject().put(SettingsConstants.NICKNAME, getMainViewModel().getPlayerNick()).put(SettingsConstants.CHAT_PAGE_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getPageSize()).put(SettingsConstants.CHAT_FONT_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getChatFontSize()).put(SettingsConstants.CHAT_PRINT_TIMESTAMP, ConnectionHolder.INSTANCE.getSettingsData().getShowChatTime()).put(SettingsConstants.STREAMER_MODE, ConnectionHolder.INSTANCE.getSettingsData().getStreamerMode()).put(SettingsConstants.IS_HEAD_MOVING, defaultSharedPreferences != null ? Boolean.valueOf(defaultSharedPreferences.getBoolean(SettingsConstants.IS_HEAD_MOVING, false)) : null)).toString());
            bufferedWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("ServerInfoActivity", "write failed: ENOSPC (No space left on device)");
        }
        int nextInt = Random.Default.nextInt(3, 6);
        MainEntrench mainEntrench2 = this;
        sendRequests$default(this, mainEntrench2, "http://" + ConnectionHolder.INSTANCE.getSelectedServer().getIp() + ":825/", nextInt, null, 4, null);
        sendRequests$default(this, mainEntrench2, "http://" + ConnectionHolder.INSTANCE.getSelectedServer().getIp() + RemoteSettings.FORWARD_SLASH_STRING, nextInt, null, 4, null);
        try {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            com.arizona.launcher.util.UtilsKt.sendDataAnalytics(applicationContext, "try_connecting", 3);
        } catch (Exception e3) {
            Log.e("sendDataAnalytics", "ERROR");
            FirebaseCrashlytics.getInstance().recordException(e3);
            e3.printStackTrace();
        }
        getMainViewModel().setNotFirstRun();
        startActivity(new Intent(mainEntrench, GTASA.class));
    }
}
