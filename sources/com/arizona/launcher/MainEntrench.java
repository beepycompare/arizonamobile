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
import android.support.v4.media.session.PlaybackStateCompat;
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
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
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
import com.arizona.game.GTASAInternal;
import com.arizona.game.R;
import com.arizona.launcher.LogcatHelper;
import com.arizona.launcher.MainEntrench;
import com.arizona.launcher.UpdateService;
import com.arizona.launcher.model.servers.ServerType;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.arizona.launcher.ui.notifications.NotificationsViewModel;
import com.arizona.launcher.util.FlavorUtilKt;
import com.arizona.launcher.util.ProjectLocale;
import com.arkivanov.decompose.RetainedComponentKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.miami.game.core.app.root.nav.main.DialogMainState;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.core.app.root.nav.main.MainExternalUiStateHolder;
import com.miami.game.core.app.root.nav.main.MainState;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.miami.game.core.firebase.notification.NotificationIntentExtras;
import com.miami.game.core.firebase.notification.NotificationInteractionEvent;
import com.miami.game.core.firebase.notification.NotificationInteractionType;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import com.miami.game.core.firebase.notification.NotificationStatsTracker;
import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.download.dialog.ui.connection.ServerModel;
import com.miami.game.feature.download.dialog.ui.connection.SettingsData;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiState;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogType;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.home.ui.model.HomeExternalUiState;
import com.miami.game.feature.home.ui.model.HomeExternalUiStateHolder;
import com.miami.game.feature.notifications.NotificationStateHolder;
import com.miami.game.ui.app.root.MainRouteKt;
import com.miami.game.ui.theme.ThemeKt;
import dagger.hilt.android.AndroidEntryPoint;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
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
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.metrics.MetricsFunsKt;
import ru.mrlargha.huawei.CheckHuaweiVersionImpl;
import ru.rustore.sdk.appupdate.manager.factory.RuStoreAppUpdateManagerFactory;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.core.tasks.OnFailureListener;
import ru.rustore.sdk.core.tasks.OnSuccessListener;
/* compiled from: MainEntrench.kt */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002\u009d\u0001\b\u0007\u0018\u0000 \u009f\u00012\u00020\u0001:\u0006\u009f\u0001 \u0001¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0014J*\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0015b\u0016\b;\u0012\u0012\b<\u0012\u000e\b\fJ\u0004\b\b(=J\u0004\b\b(>J\u0010\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020:H\u0014J\u0010\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u000205H\u0014J\u001f\u0010E\u001a\u000205H\u0007b\u0002\bGb\f\bH\u0012\b\bI\u0012\u0004\b\b(J¢\u0006\u0002\u0010FJ\u0010\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020\u0019H\u0002J\u001e\u0010M\u001a\u0002052\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u0002050OH\u0002J\b\u0010P\u001a\u000205H\u0002J\b\u0010Q\u001a\u000205H\u0002J\b\u0010R\u001a\u000205H\u0002J\b\u0010S\u001a\u000205H\u0002J\b\u0010T\u001a\u000205H\u0002J\b\u0010U\u001a\u000205H\u0002J\u0010\u0010V\u001a\u00020\u00152\u0006\u0010W\u001a\u000207H\u0002J\u0010\u0010X\u001a\u0002052\u0006\u0010W\u001a\u000207H\u0002J\b\u0010Y\u001a\u000205H\u0002J\b\u0010Z\u001a\u000205H\u0002J\b\u0010[\u001a\u000205H\u0002J\u0018\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020 2\u0006\u0010^\u001a\u00020 H\u0002J\b\u0010_\u001a\u000205H\u0002J\b\u0010`\u001a\u000205H\u0014J\b\u0010a\u001a\u000205H\u0014J\b\u0010b\u001a\u000205H\u0014J\b\u0010c\u001a\u000205H\u0002J\b\u0010d\u001a\u000205H\u0002J\b\u0010e\u001a\u00020\u0015H\u0002J\b\u0010f\u001a\u000205H\u0002J\u000e\u0010g\u001a\u00020\u00152\u0006\u0010W\u001a\u000207J\u0010\u0010h\u001a\u0002052\u0006\u0010i\u001a\u00020\u0015H\u0002J\b\u0010j\u001a\u000205H\u0002J\u0016\u0010k\u001a\u0002052\f\u0010l\u001a\b\u0012\u0004\u0012\u0002050mH\u0002J\b\u0010n\u001a\u000205H\u0002J\b\u0010o\u001a\u000205H\u0002J\b\u0010p\u001a\u000205H\u0002J\b\u0010q\u001a\u000205H\u0002J\u0010\u0010r\u001a\u0002052\u0006\u0010s\u001a\u00020tH\u0002J\b\u0010u\u001a\u000205H\u0002J&\u0010v\u001a\u00020w*\u00020x2\u0006\u0010^\u001a\u00020 2\u0006\u0010y\u001a\u00020z2\b\b\u0002\u0010{\u001a\u00020|H\u0002J\b\u0010}\u001a\u000205H\u0002J\u001f\u0010~\u001a\u0002052\u0015\b\u0002\u0010\u007f\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0080\u0001H\u0002J\u0013\u0010\u0081\u0001\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0013\u0010\u0082\u0001\u001a\u0002052\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J-\u0010\u0083\u0001\u001a\u0002052\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0080\u00012\f\b\u0002\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\f\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\f\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\t\u0010\u0089\u0001\u001a\u000205H\u0002J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\u0013\u0010\u008b\u0001\u001a\u0002052\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u000205H\u0002J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\u0013\u0010\u008e\u0001\u001a\u0002052\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u000205H\u0002J\u0018\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0019*\u0005\u0018\u00010\u0091\u0001H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0019\u0010\u0093\u0001\u001a\u00020\u0015*\u00030\u0086\u00012\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0019H\u0002J \u0010\u0095\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0080\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J \u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0080\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010 H\u0002J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010 H\u0002J\t\u0010\u009b\u0001\u001a\u000205H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010&\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.\u0092\u0002\u0002\b-¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R#\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.\u0092\u0002\u0002\b-¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009e\u0001Ê\u0001\u0003\b£\u0001Ê\u0001\u000e\b¤\u0001\u0012\t\b¥\u0001\u0012\u0004\b\u0003\u0010\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/arizona/launcher/MainEntrench;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mService", "Landroid/os/Messenger;", "mMessenger", "mainViewModel", "Lcom/arizona/launcher/MainViewModel;", "getMainViewModel", "()Lcom/arizona/launcher/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "notificationsViewModel", "Lcom/arizona/launcher/ui/notifications/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/arizona/launcher/ui/notifications/NotificationsViewModel;", "notificationsViewModel$delegate", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "isStartApp", "", "didRunStartupDebugAutoConnect", "permissionAsk", "lastStartGameTime", "", "notificationStatsTracker", "Lcom/miami/game/core/firebase/notification/NotificationStatsTracker;", "getNotificationStatsTracker", "()Lcom/miami/game/core/firebase/notification/NotificationStatsTracker;", "notificationStatsTracker$delegate", "handledNotificationOpenKey", "", "notificationLaunchRef", "notificationLaunchSentAt", "notificationLaunchReceivedAtMillis", "Ljava/lang/Long;", "notificationLaunchOpenedAtMillis", "didReportNotificationGameLaunch", "rootFactory", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;", "getRootFactory", "()Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;", "setRootFactory", "(Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;)V", "Ljavax/inject/Inject;", "notificationStateHolder", "Lcom/miami/game/feature/notifications/NotificationStateHolder;", "getNotificationStateHolder", "()Lcom/miami/game/feature/notifications/NotificationStateHolder;", "setNotificationStateHolder", "(Lcom/miami/game/feature/notifications/NotificationStateHolder;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Landroid/annotation/SuppressLint;", "value", "SourceLockedOrientationActivity", "SetTextI18n", "onSaveInstanceState", "outState", "onNewIntent", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "onStart", "GLView", "(Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "convertBytesToHumanReadable", "bytes", "getCurrentToken", "callback", "Lkotlin/Function1;", "checkHuaweiUpdate", "checkRUStoreUpdate", "saveGameType", "getBuildType", "initTracking", "obtainReferrerDetails", "checkNotificationPermission", "context", "openNotificationSettings", "askPermission", "checkUpdate", "observeData", "createDialog", "message", "url", "startApp", "onResume", "onPause", "onDestroy", "check", "checkLauncherUpdate", "getFirstOpen", "checkGameUpdate", "isOnline", "setProgressVisible", "visible", "showDialog", "showUpdateServerConnectionErrorDialog", "onRetry", "Lkotlin/Function0;", "hideDialog", "checkGame", "connectToTestServer", "tryAutoConnectToSavedDebugServer", "syncConnectionHolderSettings", "sharedPreferences", "Landroid/content/SharedPreferences;", "shareLogs", "sendRequests", "Lkotlinx/coroutines/Job;", "Landroidx/activity/ComponentActivity;", "iterations", "", "queue", "Lcom/android/volley/RequestQueue;", "startGame", "launchGameActivity", "notificationMetadata", "", "restoreNotificationLaunchState", "handleNotificationIntent", "trackNotificationGameLaunchIfNeeded", TtmlNode.TAG_METADATA, "attribution", "Lcom/arizona/launcher/MainEntrench$NotificationLaunchAttribution;", "currentActiveNotificationLaunchAttribution", "currentNotificationLaunchAttribution", "restoreStoredNotificationLaunchAttribution", "activeStoredNotificationLaunchAttribution", "applyNotificationLaunchAttribution", "clearNotificationLaunchState", "readStoredNotificationLaunchAttribution", "saveNotificationLaunchAttribution", "clearStoredNotificationLaunchAttribution", "toLongOrNull", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "isActive", "nowMillis", "notificationSelectedServerGameLaunchMetadata", "serverType", "Lcom/arizona/launcher/model/servers/ServerType;", "notificationTestServerGameLaunchMetadata", "getNotificationStatsNickname", "getSavedAuthorizationNickname", "flushPendingNotificationStats", "mConnection", "com/arizona/launcher/MainEntrench$mConnection$1", "Lcom/arizona/launcher/MainEntrench$mConnection$1;", "Companion", "IncomingHandler", "NotificationLaunchAttribution", "app", "Ldagger/hilt/android/AndroidEntryPoint;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@AndroidEntryPoint
/* loaded from: classes3.dex */
public final class MainEntrench extends Hilt_MainEntrench {
    private static final String AUTH_PREFS_NAME = "UI_ELEMENTS_SP";
    private static final String AUTH_REG_DATA_KEY = "REGDATA";
    private static final String AUTH_SERVER_ID_KEY = "SERVER_ID";
    private static final String AUTH_USERNAME_KEY = "username";
    private static final String NOTIFICATION_ATTRIBUTION_PREFS_NAME = "notification_attribution";
    private static final long NOTIFICATION_GAME_ENTRY_WINDOW_MS = 300000;
    private static final String PREF_NOTIFICATION_DID_REPORT_GAME_LAUNCH = "did_report_game_launch";
    private static final String PREF_NOTIFICATION_OPENED_AT_MILLIS = "opened_at_millis";
    private static final String PREF_NOTIFICATION_OPEN_KEY = "open_key";
    private static final String PREF_NOTIFICATION_RECEIVED_AT_MILLIS = "received_at_millis";
    private static final String PREF_NOTIFICATION_REF = "notif_ref";
    private static final String PREF_NOTIFICATION_SENT_AT = "sent_at";
    private static final String STATE_DID_REPORT_NOTIFICATION_GAME_LAUNCH = "state_did_report_notification_game_launch";
    private static final String STATE_DID_RUN_STARTUP_DEBUG_AUTO_CONNECT = "state_did_run_startup_debug_auto_connect";
    private static final String STATE_NOTIFICATION_OPENED_AT_MILLIS = "state_notification_opened_at_millis";
    private static final String STATE_NOTIFICATION_OPEN_KEY = "state_notification_open_key";
    private static final String STATE_NOTIFICATION_OPEN_REF = "state_notification_open_ref";
    private static final String STATE_NOTIFICATION_RECEIVED_AT_MILLIS = "state_notification_received_at_millis";
    private static final String STATE_NOTIFICATION_SENT_AT = "state_notification_sent_at";
    private static final String TAG = "MainEntrench";
    private boolean didReportNotificationGameLaunch;
    private boolean didRunStartupDebugAutoConnect;
    private String handledNotificationOpenKey;
    private boolean isStartApp;
    private long lastStartGameTime;
    private Messenger mService;
    private final Lazy mainViewModel$delegate;
    private Long notificationLaunchOpenedAtMillis;
    private Long notificationLaunchReceivedAtMillis;
    private String notificationLaunchRef;
    private String notificationLaunchSentAt;
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
    private final Lazy notificationStatsTracker$delegate = LazyKt.lazy(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MainEntrench.notificationStatsTracker_delegate$lambda$0(MainEntrench.this);
        }
    });
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
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
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
    public static final GLSurfaceViewForExtensions GLView$lambda$2$0(GLSurfaceViewForExtensions gLSurfaceViewForExtensions, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return gLSurfaceViewForExtensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GLView$lambda$3(MainEntrench mainEntrench, int i, Composer composer, int i2) {
        mainEntrench.GLView(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private final void tryAutoConnectToSavedDebugServer() {
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.arizona.launcher.MainEntrench$mConnection$1] */
    public MainEntrench() {
        final MainEntrench mainEntrench = this;
        this.mainViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? mainEntrench.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.notificationsViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0<ViewModelStore>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.arizona.launcher.MainEntrench$special$$inlined$viewModels$default$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = Function0.this;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? mainEntrench.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* compiled from: MainEntrench.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/MainEntrench$Companion;", "", "<init>", "()V", "TAG", "", "STATE_DID_RUN_STARTUP_DEBUG_AUTO_CONNECT", "STATE_NOTIFICATION_OPEN_KEY", "STATE_NOTIFICATION_OPEN_REF", "STATE_NOTIFICATION_SENT_AT", "STATE_NOTIFICATION_RECEIVED_AT_MILLIS", "STATE_DID_REPORT_NOTIFICATION_GAME_LAUNCH", "AUTH_PREFS_NAME", "AUTH_REG_DATA_KEY", "AUTH_SERVER_ID_KEY", "AUTH_USERNAME_KEY", "STATE_NOTIFICATION_OPENED_AT_MILLIS", "NOTIFICATION_ATTRIBUTION_PREFS_NAME", "PREF_NOTIFICATION_OPEN_KEY", "PREF_NOTIFICATION_REF", "PREF_NOTIFICATION_SENT_AT", "PREF_NOTIFICATION_RECEIVED_AT_MILLIS", "PREF_NOTIFICATION_OPENED_AT_MILLIS", "PREF_NOTIFICATION_DID_REPORT_GAME_LAUNCH", "NOTIFICATION_GAME_ENTRY_WINDOW_MS", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel$delegate.getValue();
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationStatsTracker getNotificationStatsTracker() {
        return (NotificationStatsTracker) this.notificationStatsTracker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final NotificationStatsTracker notificationStatsTracker_delegate$lambda$0(MainEntrench mainEntrench) {
        Context applicationContext = mainEntrench.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new NotificationStatsTracker(applicationContext, null, 2, null);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        super.attachBaseContext(ProjectLocale.wrap(newBase));
    }

    @Override // com.arizona.launcher.Hilt_MainEntrench, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        ProjectLocale.applyDefault();
        super.onCreate(bundle);
        this.didRunStartupDebugAutoConnect = bundle != null && bundle.getBoolean(STATE_DID_RUN_STARTUP_DEBUG_AUTO_CONNECT, false);
        restoreNotificationLaunchState(bundle);
        handleNotificationIntent(getIntent());
        try {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MainEntrench$onCreate$1(null), 3, null);
            EdgeToEdge.enable$default(this, null, null, 3, null);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
            Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
            insetsController.setSystemBarsBehavior(2);
            insetsController.hide(WindowInsetsCompat.Type.systemBars());
            SplashScreen.Companion.installSplashScreen(this);
            ConnectionHolder.INSTANCE.setOnConnectTest(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainEntrench.onCreate$lambda$0(MainEntrench.this);
                }
            });
            ConnectionHolder.INSTANCE.setOnShareLogs(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainEntrench.onCreate$lambda$1(MainEntrench.this);
                }
            });
            ConnectionHolder.INSTANCE.setOnStartGame(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainEntrench.onCreate$lambda$2(MainEntrench.this);
                }
            });
            ConnectionHolder.INSTANCE.setOnCheckGame(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainEntrench.onCreate$lambda$3(MainEntrench.this);
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
            final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            saveGameType();
            String string = defaultSharedPreferences.getString("token", "");
            if (string != null && string.length() == 0) {
                getCurrentToken(new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainEntrench.onCreate$lambda$4(defaultSharedPreferences, (String) obj);
                    }
                });
            }
            String string2 = defaultSharedPreferences.getString("referrerUrl", "");
            if (string2 != null && string2.length() == 0) {
                initTracking();
            }
            String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
            String str = (String) ArraysKt.firstOrNull(SUPPORTED_ABIS);
            if (str == null) {
                str = "unknown";
            }
            Toast.makeText(getApplicationContext(), str + " v17.2.7 release", 1).show();
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
        ComponentActivityKt.setContent$default(mainEntrench, null, ComposableLambdaKt.composableLambdaInstance(1553775207, true, new Function2() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainEntrench.onCreate$lambda$5(MainEntrench.this, mainComponent, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        File externalFilesDir = getExternalFilesDir(null);
        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/app-arizona-release.apk");
        if (file.exists()) {
            file.delete();
        }
        tryAutoConnectToSavedDebugServer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$0(MainEntrench mainEntrench) {
        if (UtilsKt.getZipFileIcons() == null) {
            com.arizona.launcher.util.UtilsKt.initZip(mainEntrench);
        }
        mainEntrench.connectToTestServer();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$1(MainEntrench mainEntrench) {
        mainEntrench.shareLogs();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$2(MainEntrench mainEntrench) {
        Context applicationContext = mainEntrench.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        com.arizona.launcher.util.UtilsKt.checkItemsNameLauncher(applicationContext, FlavorUtilKt.isArizona());
        if (UtilsKt.getZipFileIcons() == null) {
            Context applicationContext2 = mainEntrench.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            com.arizona.launcher.util.UtilsKt.initZip(applicationContext2);
        }
        mainEntrench.startGame();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$3(MainEntrench mainEntrench) {
        HomeExternalUiState value;
        MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
        do {
            value = homeStateStore.getValue();
        } while (!homeStateStore.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, true, false, false, 7, null)));
        mainEntrench.checkGame();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$4(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            sharedPreferences.edit().putString("token", str).apply();
            System.out.println((Object) ("Current token: " + str));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$5(final MainEntrench mainEntrench, final MainComponent mainComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C302@12619L269,302@12600L288:MainEntrench.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1553775207, i, -1, "com.arizona.launcher.MainEntrench.onCreate.<anonymous> (MainEntrench.kt:302)");
            }
            ThemeKt.MyApplicationTheme(false, false, ComposableLambdaKt.rememberComposableLambda(783987227, true, new Function2() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$5$0;
                    onCreate$lambda$5$0 = MainEntrench.onCreate$lambda$5$0(MainEntrench.this, mainComponent, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$5$0;
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$0(MainEntrench mainEntrench, MainComponent mainComponent, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C303@12637L237:MainEntrench.kt#5ji0rp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(783987227, i, -1, "com.arizona.launcher.MainEntrench.onCreate.<anonymous>.<anonymous> (MainEntrench.kt:303)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1707295508, "C304@12666L8,308@12791L43,306@12696L160:MainEntrench.kt#5ji0rp");
            mainEntrench.GLView(composer, 0);
            MainRouteKt.MainRoute(mainComponent, AndroidWindowSizeClass_androidKt.calculateWindowSizeClass(mainEntrench, composer, 0), composer, MainComponent.$stable);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
        outState.putBoolean(STATE_DID_RUN_STARTUP_DEBUG_AUTO_CONNECT, this.didRunStartupDebugAutoConnect);
        outState.putString(STATE_NOTIFICATION_OPEN_KEY, this.handledNotificationOpenKey);
        outState.putString(STATE_NOTIFICATION_OPEN_REF, this.notificationLaunchRef);
        outState.putString(STATE_NOTIFICATION_SENT_AT, this.notificationLaunchSentAt);
        Long l = this.notificationLaunchReceivedAtMillis;
        if (l != null) {
            outState.putLong(STATE_NOTIFICATION_RECEIVED_AT_MILLIS, l.longValue());
        }
        Long l2 = this.notificationLaunchOpenedAtMillis;
        if (l2 != null) {
            outState.putLong(STATE_NOTIFICATION_OPENED_AT_MILLIS, l2.longValue());
        }
        outState.putBoolean(STATE_DID_REPORT_NOTIFICATION_GAME_LAUNCH, this.didReportNotificationGameLaunch);
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        handleNotificationIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        flushPendingNotificationStats();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void GLView(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(163249873);
        ComposerKt.sourceInformation(startRestartGroup, "C(GLView)360@14420L7,361@14477L7,363@14507L48,365@14598L464,365@14565L497,380@15107L10,379@15072L150:MainEntrench.kt#5ji0rp");
        int i2 = i & 1;
        if (!startRestartGroup.shouldExecute(i2 != 0, i2)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163249873, i, -1, "com.arizona.launcher.MainEntrench.GLView (MainEntrench.kt:359)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2030657567, "CC(remember):MainEntrench.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new GLSurfaceViewForExtensions(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final GLSurfaceViewForExtensions gLSurfaceViewForExtensions = (GLSurfaceViewForExtensions) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2030654239, "CC(remember):MainEntrench.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(gLSurfaceViewForExtensions) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult GLView$lambda$1$0;
                        GLView$lambda$1$0 = MainEntrench.GLView$lambda$1$0(LifecycleOwner.this, gLSurfaceViewForExtensions, (DisposableEffectScope) obj);
                        return GLView$lambda$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) rememberedValue2, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2030638405, "CC(remember):MainEntrench.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(gLSurfaceViewForExtensions);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        GLSurfaceViewForExtensions GLView$lambda$2$0;
                        GLView$lambda$2$0 = MainEntrench.GLView$lambda$2$0(GLSurfaceViewForExtensions.this, (Context) obj);
                        return GLView$lambda$2$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidView_androidKt.AndroidView(rememberedValue3, SizeKt.m1103height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(1.0f)), null, startRestartGroup, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainEntrench.GLView$lambda$3(MainEntrench.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult GLView$lambda$1$0(final LifecycleOwner lifecycleOwner, final GLSurfaceViewForExtensions gLSurfaceViewForExtensions, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MainEntrench.GLView$lambda$1$0$0(GLSurfaceViewForExtensions.this, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: com.arizona.launcher.MainEntrench$GLView$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GLView$lambda$1$0$0(GLSurfaceViewForExtensions gLSurfaceViewForExtensions, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
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
            String format = String.format("%.2f Gb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1.073741824E9d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f Mb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else if (j >= 1024) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f Kb.", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        } else {
            return j + " Byte";
        }
    }

    private final void getCurrentToken(final Function1<? super String, Unit> function1) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda23
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MainEntrench.getCurrentToken$lambda$0(Function1.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void getCurrentToken$lambda$0(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            function1.invoke(null);
        } else {
            function1.invoke((String) task.getResult());
        }
    }

    private final void checkHuaweiUpdate() {
        new CheckHuaweiVersionImpl(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.checkHuaweiUpdate$lambda$0(MainEntrench.this);
            }
        }, new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.checkHuaweiUpdate$lambda$1(MainEntrench.this);
            }
        }).start(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit checkHuaweiUpdate$lambda$0(final MainEntrench mainEntrench) {
        mainEntrench.setProgressVisible(false);
        mainEntrench.showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit checkHuaweiUpdate$lambda$0$0;
                checkHuaweiUpdate$lambda$0$0 = MainEntrench.checkHuaweiUpdate$lambda$0$0(MainEntrench.this);
                return checkHuaweiUpdate$lambda$0$0;
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit checkHuaweiUpdate$lambda$0$1;
                checkHuaweiUpdate$lambda$0$1 = MainEntrench.checkHuaweiUpdate$lambda$0$1(MainEntrench.this);
                return checkHuaweiUpdate$lambda$0$1;
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Обновить", "Выйти", "Доступна новая версия приложения", "Для того чтобы обновить приложение, Вам необходимо нажать кнопку \"Обновить\".\nПосле чего обновить версию в AppGallery.\nЖелаете ли Вы обновить версию?")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkHuaweiUpdate$lambda$0$0(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkHuaweiUpdate$lambda$0$1(MainEntrench mainEntrench) {
        if (FlavorUtilKt.isArizona()) {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://appgallery.huawei.com/app/C113309931")));
        } else {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://appgallery.huawei.com/app/C113859383")));
        }
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit checkHuaweiUpdate$lambda$1(MainEntrench mainEntrench) {
        if (!mainEntrench.isStartApp) {
            mainEntrench.startApp();
        }
        return Unit.INSTANCE;
    }

    private final void checkRUStoreUpdate() {
        RuStoreAppUpdateManagerFactory.create$default(RuStoreAppUpdateManagerFactory.INSTANCE, this, null, 2, null).getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda15
            @Override // ru.rustore.sdk.core.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainEntrench.checkRUStoreUpdate$lambda$0(MainEntrench.this, (AppUpdateInfo) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda16
            @Override // ru.rustore.sdk.core.tasks.OnFailureListener
            public final void onFailure(Throwable th) {
                MainEntrench.checkRUStoreUpdate$lambda$1(MainEntrench.this, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkRUStoreUpdate$lambda$0(final MainEntrench mainEntrench, AppUpdateInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getUpdateAvailability() == 2) {
            mainEntrench.setProgressVisible(false);
            mainEntrench.showDialog();
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkRUStoreUpdate$lambda$0$0;
                    checkRUStoreUpdate$lambda$0$0 = MainEntrench.checkRUStoreUpdate$lambda$0$0(MainEntrench.this);
                    return checkRUStoreUpdate$lambda$0$0;
                }
            });
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkRUStoreUpdate$lambda$0$1;
                    checkRUStoreUpdate$lambda$0$1 = MainEntrench.checkRUStoreUpdate$lambda$0$1(MainEntrench.this);
                    return checkRUStoreUpdate$lambda$0$1;
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
    public static final Unit checkRUStoreUpdate$lambda$0$0(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkRUStoreUpdate$lambda$0$1(MainEntrench mainEntrench) {
        if (FlavorUtilKt.isArizona()) {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://apps.rustore.ru/app/com.arizona21.game.ru")));
        } else {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://apps.rustore.ru/app/com.rodina21.game.ru")));
        }
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkRUStoreUpdate$lambda$1(MainEntrench mainEntrench, Throwable it) {
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
        UtilsKt.set_isArizonaType(FlavorUtilKt.isArizona());
        UtilsKt.set_isBrazilType(FlavorUtilKt.isBrazil());
        UtilsKt.set_isDebug(false);
        FirebaseConfigHelper.INSTANCE.setDebug(false, FlavorUtilKt.isArizona(), sharedPreferences, FlavorUtilKt.isBrazil());
        if (FlavorUtilKt.isArizona()) {
            edit.putBoolean("isArizonaType", true);
        } else {
            edit.putBoolean("isArizonaType", false);
        }
        edit.apply();
    }

    private final void getBuildType() {
        if (Intrinsics.areEqual("release", getString(R.string.release)) || Intrinsics.areEqual("release", getString(R.string.release_ru)) || Intrinsics.areEqual("release", getString(R.string.release_hw))) {
            observeData();
        } else if (Intrinsics.areEqual("release", getString(R.string.debug)) || Intrinsics.areEqual("release", getString(R.string.staging)) || Intrinsics.areEqual("release", getString(R.string.release_web)) || Intrinsics.areEqual("release", getString(R.string.public_debug)) || Intrinsics.areEqual("release", getString(R.string.release_old))) {
            startApp();
        }
    }

    private final void initTracking() {
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
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
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(privacyInteractor.SP_NAME, 0);
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
            String normalReferrer = MetricsFunsKt.toNormalReferrer(installReferrer2);
            Log.d("REFERRER_TAG", "referrerUrlraw - " + installReferrer2);
            Log.d("REFERRER_TAG", "referrerUrl - " + normalReferrer);
            sharedPreferences.edit().putString("referrerUrl", normalReferrer).apply();
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
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.askPermission$lambda$0(MainEntrench.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.askPermission$lambda$1(MainEntrench.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "Разрешить", "Пропустить", "Разрешите уведомления", "Для оптимальной функциональности приложения требуется \nпредоставление разрешения на отправку уведомлений.")));
        this.permissionAsk = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit askPermission$lambda$0(MainEntrench mainEntrench) {
        mainEntrench.hideDialog();
        mainEntrench.permissionAsk = false;
        mainEntrench.getBuildType();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit askPermission$lambda$1(MainEntrench mainEntrench) {
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
        final Function1 function1 = new Function1() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainEntrench.checkUpdate$lambda$0(MainEntrench.this, (com.google.android.play.core.appupdate.AppUpdateInfo) obj);
            }
        };
        appUpdateInfo.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Function1.this.invoke(obj);
            }
        }).addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MainEntrench.checkUpdate$lambda$2(MainEntrench.this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit checkUpdate$lambda$0(final MainEntrench mainEntrench, com.google.android.play.core.appupdate.AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2) {
            mainEntrench.setProgressVisible(false);
            mainEntrench.showDialog();
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkUpdate$lambda$0$0;
                    checkUpdate$lambda$0$0 = MainEntrench.checkUpdate$lambda$0$0(MainEntrench.this);
                    return checkUpdate$lambda$0$0;
                }
            });
            ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit checkUpdate$lambda$0$1;
                    checkUpdate$lambda$0$1 = MainEntrench.checkUpdate$lambda$0$1(MainEntrench.this);
                    return checkUpdate$lambda$0$1;
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
    public static final Unit checkUpdate$lambda$0$0(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUpdate$lambda$0$1(MainEntrench mainEntrench) {
        if (FlavorUtilKt.isArizona()) {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.arizona21.game&hl=ru&gl=US")));
        } else {
            mainEntrench.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.rodina21.game&hl=ru&gl=US")));
        }
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void checkUpdate$lambda$2(MainEntrench mainEntrench, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (mainEntrench.isStartApp) {
            return;
        }
        mainEntrench.startApp();
    }

    private final void observeData() {
        if (Intrinsics.areEqual("release", getString(R.string.release_hw))) {
            checkHuaweiUpdate();
        } else if (Intrinsics.areEqual("release", getString(R.string.release))) {
            checkUpdate();
        } else {
            checkRUStoreUpdate();
        }
    }

    private final void createDialog(final String str, final String str2) {
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(this).setMessage((CharSequence) str).setPositiveButton((CharSequence) getString(R.string.open_website), new DialogInterface.OnClickListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainEntrench.createDialog$lambda$0(MainEntrench.this, str, str2, dialogInterface, i);
            }
        });
        positiveButton.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda29
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainEntrench.createDialog$lambda$1$0(MainEntrench.this, dialogInterface, i);
            }
        });
        AlertDialog create = positiveButton.create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void createDialog$lambda$0(MainEntrench mainEntrench, String str, String str2, DialogInterface dialogInterface, int i) {
        mainEntrench.createDialog(str, str2);
        StringKt.openLink(str2, mainEntrench);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1$0(MainEntrench mainEntrench, DialogInterface dialogInterface, int i) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    private final void startApp() {
        this.isStartApp = true;
        bindService(new Intent(this, UpdateService.class), this.mConnection, 1);
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
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.check$lambda$0(MainEntrench.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.check$lambda$1(MainEntrench.this);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
        } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.ConnectionError, "Повторить", "Выйти", "Нет подключения к сети", "Проверьте ваше интернет соединение и попробуйте снова")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit check$lambda$0(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit check$lambda$1(MainEntrench mainEntrench) {
        mainEntrench.hideDialog();
        mainEntrench.check();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkLauncherUpdate() {
        if (!Intrinsics.areEqual("release", getString(R.string.release)) && !Intrinsics.areEqual("release", getString(R.string.release_hw)) && !Intrinsics.areEqual("release", getString(R.string.release_ru))) {
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
        return getApplicationContext().getSharedPreferences(privacyInteractor.SP_NAME, 0).getBoolean("firstOpen", false);
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/MainEntrench$IncomingHandler;", "Landroid/os/Handler;", "ref", "Lcom/arizona/launcher/MainEntrench;", "<init>", "(Lcom/arizona/launcher/MainEntrench;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class IncomingHandler extends Handler {
        private final WeakReference<MainEntrench> activityRef;

        /* compiled from: MainEntrench.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class WhenMappings {
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
            HomeExternalUiState value5;
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
                    mainEntrench.showUpdateServerConnectionErrorDialog(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$4(MainEntrench.this);
                        }
                    });
                } else if (!msg.getData().getBoolean(NotificationCompat.CATEGORY_STATUS, false)) {
                    Log.e(MainEntrench.TAG, "Error check update");
                    mainEntrench.setProgressVisible(false);
                    MutableStateFlow<HomeExternalUiState> homeStateStore = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                    do {
                        value3 = homeStateStore.getValue();
                    } while (!homeStateStore.compareAndSet(value3, HomeExternalUiState.copy$default(value3, false, null, null, false, false, false, 7, null)));
                    mainEntrench.showUpdateServerConnectionErrorDialog(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$6(MainEntrench.this);
                        }
                    });
                } else {
                    boolean z = msg.getData().getBoolean("isGameDataUpdateExists", true);
                    String convertBytesToHumanReadable = mainEntrench.convertBytesToHumanReadable(msg.getData().getLong("total_size", 0L));
                    mainEntrench.setProgressVisible(false);
                    if (z) {
                        MutableStateFlow<HomeExternalUiState> homeStateStore2 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                        do {
                            value2 = homeStateStore2.getValue();
                        } while (!homeStateStore2.compareAndSet(value2, HomeExternalUiState.copy$default(value2, false, null, convertBytesToHumanReadable, false, true, false, 11, null)));
                        DownloadExternalUiStateHolder.INSTANCE.setOnStartDownload(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainEntrench.IncomingHandler.handleMessage$lambda$8(MainEntrench.this);
                            }
                        });
                        return;
                    }
                    MutableStateFlow<HomeExternalUiState> homeStateStore3 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                    do {
                        value = homeStateStore3.getValue();
                    } while (!homeStateStore3.compareAndSet(value, HomeExternalUiState.copy$default(value, false, null, null, false, false, true, 15, null)));
                }
            } else if (i == 3) {
                Serializable serializable2 = msg.getData().getSerializable(UpdateService.ERRNO_MSG);
                Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type com.arizona.launcher.UpdateService.Errno");
                if (WhenMappings.$EnumSwitchMapping$0[((UpdateService.Errno) serializable2).ordinal()] == 1) {
                    mainEntrench.showUpdateServerConnectionErrorDialog(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$0(MainEntrench.this);
                        }
                    });
                } else if (msg.getData().getBoolean(UpdateService.NEED_UPDATE_MSG, false)) {
                    mainEntrench.setProgressVisible(false);
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$1(MainEntrench.this);
                        }
                    });
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$2(MainEntrench.this);
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore.compareAndSet(stateStore.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Download, "Обновить", "Выйти", "Требуется обновление клиента", "Данная версия устарела, необходимо загрузить новую")));
                } else {
                    mainEntrench.checkGameUpdate();
                    mainEntrench.setProgressVisible(true);
                }
            } else if (i != 8) {
            } else {
                if (msg.getData().getBoolean(NotificationCompat.CATEGORY_STATUS, true)) {
                    mainEntrench.showDialog();
                    ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainEntrench.IncomingHandler.handleMessage$lambda$10(MainEntrench.this);
                        }
                    });
                    MutableStateFlow<ErrorDialogExternalUiState> stateStore2 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                    do {
                    } while (!stateStore2.compareAndSet(stateStore2.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Repair, "", "Закрыть", "ФАЙЛЫ ПРОВЕРЕНЫ", "Все файлы успешно прошли проверку")));
                    MutableStateFlow<HomeExternalUiState> homeStateStore4 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                    do {
                        value5 = homeStateStore4.getValue();
                    } while (!homeStateStore4.compareAndSet(value5, HomeExternalUiState.copy$default(value5, false, null, null, false, false, true, 7, null)));
                    return;
                }
                MutableStateFlow<HomeExternalUiState> homeStateStore5 = HomeExternalUiStateHolder.INSTANCE.getHomeStateStore();
                do {
                    value4 = homeStateStore5.getValue();
                } while (!homeStateStore5.compareAndSet(value4, HomeExternalUiState.copy$default(value4, false, null, null, false, true, false, 7, null)));
                ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$IncomingHandler$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainEntrench.IncomingHandler.handleMessage$lambda$14(MainEntrench.this);
                    }
                });
                MutableStateFlow<ErrorDialogExternalUiState> stateStore3 = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
                do {
                } while (!stateStore3.compareAndSet(stateStore3.getValue(), new ErrorDialogExternalUiState(ErrorDialogType.Alert, "Закрыть", "", "ТРЕБУЕТСЯ ПЕРЕЗАПУСК", "Проверка файлов выполнена, требуется перезапуск")));
                mainEntrench.showDialog();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$0(MainEntrench mainEntrench) {
            mainEntrench.checkLauncherUpdate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$1(MainEntrench mainEntrench) {
            mainEntrench.finishAffinity();
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$2(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            Intent intent = new Intent(mainEntrench, UpdateActivity.class);
            intent.putExtra(UpdateActivity.UPDATE_MODE, "LauncherUpdate");
            mainEntrench.startActivity(intent);
            mainEntrench.finish();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$4(MainEntrench mainEntrench) {
            mainEntrench.checkGameUpdate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$6(MainEntrench mainEntrench) {
            mainEntrench.checkGameUpdate();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$8(MainEntrench mainEntrench) {
            Intent intent = new Intent(mainEntrench, UpdateActivity.class);
            intent.putExtra(UpdateActivity.UPDATE_MODE, "GameUpdate");
            mainEntrench.startActivity(intent);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$10(MainEntrench mainEntrench) {
            mainEntrench.hideDialog();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Unit handleMessage$lambda$14(MainEntrench mainEntrench) {
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
    public final void showUpdateServerConnectionErrorDialog(final Function0<Unit> function0) {
        ErrorDialogExternalUiState value;
        ErrorDialogType errorDialogType;
        String string;
        String string2;
        String string3;
        String string4;
        setProgressVisible(false);
        showDialog();
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnNegative(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.showUpdateServerConnectionErrorDialog$lambda$0(MainEntrench.this);
            }
        });
        ErrorDialogExternalUiStateHolder.INSTANCE.setOnPositive(new Function0() { // from class: com.arizona.launcher.MainEntrench$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainEntrench.showUpdateServerConnectionErrorDialog$lambda$1(MainEntrench.this, function0);
            }
        });
        MutableStateFlow<ErrorDialogExternalUiState> stateStore = ErrorDialogExternalUiStateHolder.INSTANCE.getStateStore();
        do {
            value = stateStore.getValue();
            errorDialogType = ErrorDialogType.ConnectionError;
            string = getString(R.string.update_server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = getString(R.string.update_server_error_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            string3 = getString(R.string.exit);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            string4 = getString(R.string.repeat);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        } while (!stateStore.compareAndSet(value, new ErrorDialogExternalUiState(errorDialogType, string4, string3, string, string2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showUpdateServerConnectionErrorDialog$lambda$0(MainEntrench mainEntrench) {
        mainEntrench.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showUpdateServerConnectionErrorDialog$lambda$1(MainEntrench mainEntrench, Function0 function0) {
        mainEntrench.hideDialog();
        function0.invoke();
        return Unit.INSTANCE;
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
        Intrinsics.checkNotNull(edit);
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
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ServerType serverType = FlavorUtilKt.isArizona() ? ServerType.ARIZONA : ServerType.RODINA;
        if (defaultSharedPreferences != null && (edit = defaultSharedPreferences.edit()) != null && (putInt = edit.putInt(SettingsConstants.PROJECT_ID, serverType.getBackendLaunchCode())) != null) {
            putInt.apply();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        JSONObject jSONObject = new JSONObject();
        JSONObject put = new JSONObject().put("server", new JSONObject().put("id", defaultSharedPreferences != null ? Integer.valueOf(defaultSharedPreferences.getInt(SettingsConstants.PROJECT_ID, 0)) : null).put("serverid", 0));
        JSONObject put2 = new JSONObject().put("ip", ConnectionHolder.INSTANCE.getSettingsData().getIp());
        Integer intOrNull = StringsKt.toIntOrNull(ConnectionHolder.INSTANCE.getSettingsData().getPort());
        bufferedWriter.write(jSONObject.put("client", put.put("test", put2.put("port", intOrNull != null ? intOrNull.intValue() : 1).put("pass", ConnectionHolder.INSTANCE.getSettingsData().getPassword()))).put("launcher", new JSONObject().put(SettingsConstants.NICKNAME, getMainViewModel().getPlayerNick()).put(SettingsConstants.CHAT_PAGE_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getPageSize()).put(SettingsConstants.CHAT_FONT_SIZE, Float.valueOf(ConnectionHolder.INSTANCE.getSettingsData().getChatFontSize())).put(SettingsConstants.CHAT_PRINT_TIMESTAMP, ConnectionHolder.INSTANCE.getSettingsData().getShowChatTime()).put(SettingsConstants.AMBIENT_SOUNDS, ConnectionHolder.INSTANCE.getSettingsData().getAmbientSounds()).put(SettingsConstants.STREAMER_MODE, ConnectionHolder.INSTANCE.getSettingsData().getStreamerMode()).put(SettingsConstants.IS_HEAD_MOVING, defaultSharedPreferences != null ? Boolean.valueOf(defaultSharedPreferences.getBoolean(SettingsConstants.IS_HEAD_MOVING, false)) : null)).toString());
        bufferedWriter.close();
        LogcatHelper.Companion companion = LogcatHelper.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        LogcatHelper companion2 = companion.getInstance(applicationContext);
        if (companion2 != null) {
            companion2.clean(false);
        }
        launchGameActivity(notificationTestServerGameLaunchMetadata(serverType));
    }

    private static final void tryAutoConnectToSavedDebugServer$lambda$0(MainEntrench mainEntrench) {
        if (mainEntrench.isFinishing() || mainEntrench.isDestroyed()) {
            return;
        }
        ConnectionHolder.INSTANCE.getOnConnectTest().invoke();
    }

    private final void syncConnectionHolderSettings(SharedPreferences sharedPreferences) {
        ConnectionHolder connectionHolder = ConnectionHolder.INSTANCE;
        SettingsData settingsData = ConnectionHolder.INSTANCE.getSettingsData();
        int i = sharedPreferences.getInt(SettingsConstants.CHAT_PAGE_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getPageSize());
        float f = sharedPreferences.getFloat(SettingsConstants.CHAT_FONT_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getChatFontSize());
        boolean z = sharedPreferences.getBoolean(SettingsConstants.CHAT_PRINT_TIMESTAMP, ConnectionHolder.INSTANCE.getSettingsData().getShowChatTime());
        boolean z2 = sharedPreferences.getBoolean(SettingsConstants.AMBIENT_SOUNDS, ConnectionHolder.INSTANCE.getSettingsData().getAmbientSounds());
        boolean z3 = sharedPreferences.getBoolean(SettingsConstants.SHOW_FPS, ConnectionHolder.INSTANCE.getSettingsData().getShowFps());
        boolean z4 = sharedPreferences.getBoolean(SettingsConstants.USE_FULLSCREEN, ConnectionHolder.INSTANCE.getSettingsData().getFullScreen());
        boolean z5 = sharedPreferences.getBoolean(SettingsConstants.STREAMER_MODE, ConnectionHolder.INSTANCE.getSettingsData().getStreamerMode());
        String string = sharedPreferences.getString(SettingsConstants.DEBUG_TEST_SERVER_IP, ConnectionHolder.INSTANCE.getSettingsData().getIp());
        if (string == null) {
            string = "";
        }
        String str = string;
        if (StringsKt.isBlank(str)) {
            str = ConnectionHolder.INSTANCE.getSettingsData().getIp();
        }
        String str2 = str;
        String string2 = sharedPreferences.getString(SettingsConstants.DEBUG_TEST_SERVER_PORT, ConnectionHolder.INSTANCE.getSettingsData().getPort());
        if (string2 == null) {
            string2 = "";
        }
        String str3 = string2;
        if (StringsKt.isBlank(str3)) {
            str3 = ConnectionHolder.INSTANCE.getSettingsData().getPort();
        }
        String str4 = str3;
        String string3 = sharedPreferences.getString(SettingsConstants.DEBUG_TEST_SERVER_PASSWORD, ConnectionHolder.INSTANCE.getSettingsData().getPassword());
        connectionHolder.setSettingsData(SettingsData.copy$default(settingsData, i, f, false, z5, z, z2, z3, z4, str2, str4, string3 == null ? "" : string3, 4, null));
    }

    private final void shareLogs() {
        LogShareHelper.shareAllLogs(this);
    }

    static /* synthetic */ Job sendRequests$default(MainEntrench mainEntrench, ComponentActivity componentActivity, String str, int i, RequestQueue requestQueue, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            requestQueue = Volley.newRequestQueue(componentActivity.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(requestQueue, "newRequestQueue(...)");
        }
        return mainEntrench.sendRequests(componentActivity, str, i, requestQueue);
    }

    private final Job sendRequests(ComponentActivity componentActivity, String str, int i, RequestQueue requestQueue) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(componentActivity), Dispatchers.getIO(), null, new MainEntrench$sendRequests$1(i, requestQueue, str, null), 2, null);
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
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
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
            bufferedWriter.write(new JSONObject().put("client", new JSONObject().put("server", new JSONObject().put("id", serverType2.getBackendLaunchCode()).put("serverid", ConnectionHolder.INSTANCE.getSelectedServer().getNumber()))).put("launcher", new JSONObject().put(SettingsConstants.NICKNAME, getMainViewModel().getPlayerNick()).put(SettingsConstants.CHAT_PAGE_SIZE, ConnectionHolder.INSTANCE.getSettingsData().getPageSize()).put(SettingsConstants.CHAT_FONT_SIZE, Float.valueOf(ConnectionHolder.INSTANCE.getSettingsData().getChatFontSize())).put(SettingsConstants.CHAT_PRINT_TIMESTAMP, ConnectionHolder.INSTANCE.getSettingsData().getShowChatTime()).put(SettingsConstants.AMBIENT_SOUNDS, ConnectionHolder.INSTANCE.getSettingsData().getAmbientSounds()).put(SettingsConstants.STREAMER_MODE, ConnectionHolder.INSTANCE.getSettingsData().getStreamerMode()).put(SettingsConstants.IS_HEAD_MOVING, defaultSharedPreferences != null ? Boolean.valueOf(defaultSharedPreferences.getBoolean(SettingsConstants.IS_HEAD_MOVING, false)) : null)).toString());
            bufferedWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("ServerInfoActivity", "write failed: ENOSPC (No space left on device)");
        }
        int nextInt = Random.Default.nextInt(3, 6);
        MainEntrench mainEntrench = this;
        sendRequests$default(this, mainEntrench, "http://" + ConnectionHolder.INSTANCE.getSelectedServer().getIp() + ":825/", nextInt, null, 4, null);
        sendRequests$default(this, mainEntrench, "http://" + ConnectionHolder.INSTANCE.getSelectedServer().getIp() + "/", nextInt, null, 4, null);
        getMainViewModel().setNotFirstRun();
        LogcatHelper.Companion companion = LogcatHelper.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        LogcatHelper companion2 = companion.getInstance(applicationContext);
        if (companion2 != null) {
            companion2.clean(false);
        }
        launchGameActivity(notificationSelectedServerGameLaunchMetadata(serverType2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void launchGameActivity$default(MainEntrench mainEntrench, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        mainEntrench.launchGameActivity(map);
    }

    private final void launchGameActivity(Map<String, String> map) {
        Long receivedAtMillis;
        String sentAt;
        String notifRef;
        if (!GTASAInternal.areNativeLibrariesLoaded()) {
            Log.e(TAG, "Native libraries are not loaded", GTASAInternal.getNativeLibraryLoadError());
            GTASAInternal.recordNativeLibraryLoadFailure(getApplicationContext());
            Toast.makeText(getApplicationContext(), R.string.unsupported_native_abi, 1).show();
            return;
        }
        NotificationLaunchAttribution currentActiveNotificationLaunchAttribution = currentActiveNotificationLaunchAttribution();
        Intent intent = new Intent(this, GTASA.class);
        if (currentActiveNotificationLaunchAttribution != null && (notifRef = currentActiveNotificationLaunchAttribution.getNotifRef()) != null) {
            intent.putExtra("notif_ref", notifRef);
        }
        if (currentActiveNotificationLaunchAttribution != null && (sentAt = currentActiveNotificationLaunchAttribution.getSentAt()) != null) {
            intent.putExtra("sent_at", sentAt);
        }
        if (currentActiveNotificationLaunchAttribution != null && (receivedAtMillis = currentActiveNotificationLaunchAttribution.getReceivedAtMillis()) != null) {
            intent.putExtra(NotificationIntentExtras.RECEIVED_AT_MILLIS, receivedAtMillis.longValue());
        }
        trackNotificationGameLaunchIfNeeded(map, currentActiveNotificationLaunchAttribution);
        startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (r0.longValue() > 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void restoreNotificationLaunchState(Bundle bundle) {
        Long l;
        if (bundle == null) {
            restoreStoredNotificationLaunchAttribution();
            return;
        }
        this.handledNotificationOpenKey = bundle.getString(STATE_NOTIFICATION_OPEN_KEY);
        this.notificationLaunchRef = bundle.getString(STATE_NOTIFICATION_OPEN_REF);
        this.notificationLaunchSentAt = bundle.getString(STATE_NOTIFICATION_SENT_AT);
        Long l2 = null;
        if (bundle.containsKey(STATE_NOTIFICATION_RECEIVED_AT_MILLIS)) {
            l = Long.valueOf(bundle.getLong(STATE_NOTIFICATION_RECEIVED_AT_MILLIS));
        }
        l = null;
        this.notificationLaunchReceivedAtMillis = l;
        if (bundle.containsKey(STATE_NOTIFICATION_OPENED_AT_MILLIS)) {
            Long valueOf = Long.valueOf(bundle.getLong(STATE_NOTIFICATION_OPENED_AT_MILLIS));
            if (valueOf.longValue() > 0) {
                l2 = valueOf;
            }
        }
        this.notificationLaunchOpenedAtMillis = l2;
        this.didReportNotificationGameLaunch = bundle.getBoolean(STATE_DID_REPORT_NOTIFICATION_GAME_LAUNCH, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.getOpenKey(), r1) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        r2 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleNotificationIntent(Intent intent) {
        NotificationInteractionEvent openedEventFrom = NotificationIntentExtras.INSTANCE.openedEventFrom(intent);
        if (openedEventFrom == null) {
            return;
        }
        String attributionKey = openedEventFrom.getAttributionKey();
        NotificationLaunchAttribution readStoredNotificationLaunchAttribution = readStoredNotificationLaunchAttribution();
        NotificationLaunchAttribution notificationLaunchAttribution = null;
        if (readStoredNotificationLaunchAttribution != null) {
            if (!Intrinsics.areEqual(readStoredNotificationLaunchAttribution.getOpenKey(), attributionKey)) {
                readStoredNotificationLaunchAttribution = null;
            }
        }
        readStoredNotificationLaunchAttribution = currentNotificationLaunchAttribution();
        if (readStoredNotificationLaunchAttribution != null) {
        }
        if (notificationLaunchAttribution == null) {
            notificationLaunchAttribution = new NotificationLaunchAttribution(attributionKey, openedEventFrom.getNotifRef(), openedEventFrom.getSentAt(), openedEventFrom.getReceivedAtMillis(), openedEventFrom.getOccurredAtMillis(), false);
        }
        boolean areEqual = Intrinsics.areEqual(this.handledNotificationOpenKey, attributionKey);
        applyNotificationLaunchAttribution(notificationLaunchAttribution);
        saveNotificationLaunchAttribution(notificationLaunchAttribution);
        if (areEqual) {
            return;
        }
        this.handledNotificationOpenKey = attributionKey;
        getNotificationStatsTracker().recordAndFlush(openedEventFrom);
    }

    static /* synthetic */ void trackNotificationGameLaunchIfNeeded$default(MainEntrench mainEntrench, Map map, NotificationLaunchAttribution notificationLaunchAttribution, int i, Object obj) {
        if ((i & 2) != 0) {
            notificationLaunchAttribution = mainEntrench.currentActiveNotificationLaunchAttribution();
        }
        mainEntrench.trackNotificationGameLaunchIfNeeded(map, notificationLaunchAttribution);
    }

    private final void trackNotificationGameLaunchIfNeeded(Map<String, String> map, NotificationLaunchAttribution notificationLaunchAttribution) {
        if (notificationLaunchAttribution == null || notificationLaunchAttribution.getDidReportGameLaunch() || this.didReportNotificationGameLaunch) {
            return;
        }
        this.didReportNotificationGameLaunch = true;
        NotificationLaunchAttribution copy$default = NotificationLaunchAttribution.copy$default(notificationLaunchAttribution, null, null, null, null, 0L, true, 31, null);
        applyNotificationLaunchAttribution(copy$default);
        saveNotificationLaunchAttribution(copy$default);
        getNotificationStatsTracker().recordAndFlush(new NotificationInteractionEvent(NotificationInteractionType.GAME_LAUNCHED, notificationLaunchAttribution.getNotifRef(), notificationLaunchAttribution.getSentAt(), 0L, notificationLaunchAttribution.getReceivedAtMillis(), map, 8, null));
    }

    private final NotificationLaunchAttribution currentActiveNotificationLaunchAttribution() {
        MainEntrench mainEntrench;
        NotificationLaunchAttribution currentNotificationLaunchAttribution = currentNotificationLaunchAttribution();
        if (currentNotificationLaunchAttribution != null) {
            mainEntrench = this;
            if (isActive$default(mainEntrench, currentNotificationLaunchAttribution, 0L, 1, null)) {
                return currentNotificationLaunchAttribution;
            }
        } else {
            mainEntrench = this;
        }
        if (currentNotificationLaunchAttribution != null) {
            mainEntrench.clearNotificationLaunchState();
        }
        return mainEntrench.activeStoredNotificationLaunchAttribution();
    }

    private final NotificationLaunchAttribution currentNotificationLaunchAttribution() {
        String str = this.notificationLaunchRef;
        if (str != null) {
            String str2 = !StringsKt.isBlank(str) ? str : null;
            if (str2 != null) {
                String str3 = this.handledNotificationOpenKey;
                if (str3 == null) {
                    String str4 = this.notificationLaunchSentAt;
                    if (str4 == null) {
                        str4 = "";
                    }
                    str3 = "OPENED:" + str2 + StringUtils.PROCESS_POSTFIX_DELIMITER + str4;
                }
                String str5 = str3;
                String str6 = this.notificationLaunchSentAt;
                Long l = this.notificationLaunchReceivedAtMillis;
                Long l2 = this.notificationLaunchOpenedAtMillis;
                return new NotificationLaunchAttribution(str5, str2, str6, l, l2 != null ? l2.longValue() : 0L, this.didReportNotificationGameLaunch);
            }
        }
        return null;
    }

    private final void restoreStoredNotificationLaunchAttribution() {
        NotificationLaunchAttribution activeStoredNotificationLaunchAttribution = activeStoredNotificationLaunchAttribution();
        if (activeStoredNotificationLaunchAttribution != null) {
            applyNotificationLaunchAttribution(activeStoredNotificationLaunchAttribution);
        }
    }

    private final NotificationLaunchAttribution activeStoredNotificationLaunchAttribution() {
        NotificationLaunchAttribution readStoredNotificationLaunchAttribution = readStoredNotificationLaunchAttribution();
        if (readStoredNotificationLaunchAttribution == null) {
            return null;
        }
        if (isActive$default(this, readStoredNotificationLaunchAttribution, 0L, 1, null)) {
            return readStoredNotificationLaunchAttribution;
        }
        clearStoredNotificationLaunchAttribution();
        return null;
    }

    private final void applyNotificationLaunchAttribution(NotificationLaunchAttribution notificationLaunchAttribution) {
        this.handledNotificationOpenKey = notificationLaunchAttribution.getOpenKey();
        this.notificationLaunchRef = notificationLaunchAttribution.getNotifRef();
        this.notificationLaunchSentAt = notificationLaunchAttribution.getSentAt();
        this.notificationLaunchReceivedAtMillis = notificationLaunchAttribution.getReceivedAtMillis();
        this.notificationLaunchOpenedAtMillis = Long.valueOf(notificationLaunchAttribution.getOpenedAtMillis());
        this.didReportNotificationGameLaunch = notificationLaunchAttribution.getDidReportGameLaunch();
    }

    private final void clearNotificationLaunchState() {
        this.handledNotificationOpenKey = null;
        this.notificationLaunchRef = null;
        this.notificationLaunchSentAt = null;
        this.notificationLaunchReceivedAtMillis = null;
        this.notificationLaunchOpenedAtMillis = null;
        this.didReportNotificationGameLaunch = false;
    }

    private final NotificationLaunchAttribution readStoredNotificationLaunchAttribution() {
        Object m9898constructorimpl;
        Map<String, ?> all;
        String str;
        Long longOrNull;
        try {
            Result.Companion companion = Result.Companion;
            MainEntrench mainEntrench = this;
            all = getSharedPreferences(NOTIFICATION_ATTRIBUTION_PREFS_NAME, 0).getAll();
            Object obj = all.get(PREF_NOTIFICATION_OPEN_KEY);
            str = obj instanceof String ? (String) obj : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        if (str == null) {
            return null;
        }
        Object obj2 = all.get("notif_ref");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null || (longOrNull = toLongOrNull(all.get(PREF_NOTIFICATION_OPENED_AT_MILLIS))) == null) {
            return null;
        }
        long longValue = longOrNull.longValue();
        Object obj3 = all.get("sent_at");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Long longOrNull2 = toLongOrNull(all.get(PREF_NOTIFICATION_RECEIVED_AT_MILLIS));
        Object obj4 = all.get(PREF_NOTIFICATION_DID_REPORT_GAME_LAUNCH);
        Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
        m9898constructorimpl = Result.m9898constructorimpl(new NotificationLaunchAttribution(str, str2, str3, longOrNull2, longValue, bool != null ? bool.booleanValue() : false));
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Log.w(TAG, "Failed to read notification launch attribution", m9901exceptionOrNullimpl);
        }
        return Result.m9904isFailureimpl(m9898constructorimpl) ? null : m9898constructorimpl;
    }

    private final void saveNotificationLaunchAttribution(NotificationLaunchAttribution notificationLaunchAttribution) {
        Object m9898constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            MainEntrench mainEntrench = this;
            SharedPreferences.Editor putBoolean = getSharedPreferences(NOTIFICATION_ATTRIBUTION_PREFS_NAME, 0).edit().putString(PREF_NOTIFICATION_OPEN_KEY, notificationLaunchAttribution.getOpenKey()).putString("notif_ref", notificationLaunchAttribution.getNotifRef()).putString("sent_at", notificationLaunchAttribution.getSentAt()).putLong(PREF_NOTIFICATION_OPENED_AT_MILLIS, notificationLaunchAttribution.getOpenedAtMillis()).putBoolean(PREF_NOTIFICATION_DID_REPORT_GAME_LAUNCH, notificationLaunchAttribution.getDidReportGameLaunch());
            Long receivedAtMillis = notificationLaunchAttribution.getReceivedAtMillis();
            if (receivedAtMillis == null || putBoolean.putLong(PREF_NOTIFICATION_RECEIVED_AT_MILLIS, receivedAtMillis.longValue()) == null) {
                putBoolean.remove(PREF_NOTIFICATION_RECEIVED_AT_MILLIS);
            }
            putBoolean.apply();
            m9898constructorimpl = Result.m9898constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Log.w(TAG, "Failed to save notification launch attribution", m9901exceptionOrNullimpl);
        }
    }

    private final void clearStoredNotificationLaunchAttribution() {
        Object m9898constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            MainEntrench mainEntrench = this;
            getSharedPreferences(NOTIFICATION_ATTRIBUTION_PREFS_NAME, 0).edit().clear().apply();
            m9898constructorimpl = Result.m9898constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
        if (m9901exceptionOrNullimpl != null) {
            Log.w(TAG, "Failed to clear notification launch attribution", m9901exceptionOrNullimpl);
        }
    }

    private final Long toLongOrNull(Object obj) {
        Long longOrNull;
        if (obj instanceof Long) {
            longOrNull = (Long) obj;
        } else if (obj instanceof Integer) {
            longOrNull = Long.valueOf(((Number) obj).intValue());
        } else if (obj instanceof Number) {
            longOrNull = Long.valueOf(((Number) obj).longValue());
        } else {
            longOrNull = obj instanceof String ? toLongOrNull(obj) : null;
        }
        if (longOrNull == null || longOrNull.longValue() <= 0) {
            return null;
        }
        return longOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainEntrench.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/arizona/launcher/MainEntrench$NotificationLaunchAttribution;", "", "openKey", "", "notifRef", "sentAt", "receivedAtMillis", "", "openedAtMillis", "didReportGameLaunch", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JZ)V", "getOpenKey", "()Ljava/lang/String;", "getNotifRef", "getSentAt", "getReceivedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOpenedAtMillis", "()J", "getDidReportGameLaunch", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JZ)Lcom/arizona/launcher/MainEntrench$NotificationLaunchAttribution;", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NotificationLaunchAttribution {
        private final boolean didReportGameLaunch;
        private final String notifRef;
        private final String openKey;
        private final long openedAtMillis;
        private final Long receivedAtMillis;
        private final String sentAt;

        public static /* synthetic */ NotificationLaunchAttribution copy$default(NotificationLaunchAttribution notificationLaunchAttribution, String str, String str2, String str3, Long l, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notificationLaunchAttribution.openKey;
            }
            if ((i & 2) != 0) {
                str2 = notificationLaunchAttribution.notifRef;
            }
            if ((i & 4) != 0) {
                str3 = notificationLaunchAttribution.sentAt;
            }
            if ((i & 8) != 0) {
                l = notificationLaunchAttribution.receivedAtMillis;
            }
            if ((i & 16) != 0) {
                j = notificationLaunchAttribution.openedAtMillis;
            }
            if ((i & 32) != 0) {
                z = notificationLaunchAttribution.didReportGameLaunch;
            }
            boolean z2 = z;
            long j2 = j;
            return notificationLaunchAttribution.copy(str, str2, str3, l, j2, z2);
        }

        public final String component1() {
            return this.openKey;
        }

        public final String component2() {
            return this.notifRef;
        }

        public final String component3() {
            return this.sentAt;
        }

        public final Long component4() {
            return this.receivedAtMillis;
        }

        public final long component5() {
            return this.openedAtMillis;
        }

        public final boolean component6() {
            return this.didReportGameLaunch;
        }

        public final NotificationLaunchAttribution copy(String openKey, String notifRef, String str, Long l, long j, boolean z) {
            Intrinsics.checkNotNullParameter(openKey, "openKey");
            Intrinsics.checkNotNullParameter(notifRef, "notifRef");
            return new NotificationLaunchAttribution(openKey, notifRef, str, l, j, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotificationLaunchAttribution) {
                NotificationLaunchAttribution notificationLaunchAttribution = (NotificationLaunchAttribution) obj;
                return Intrinsics.areEqual(this.openKey, notificationLaunchAttribution.openKey) && Intrinsics.areEqual(this.notifRef, notificationLaunchAttribution.notifRef) && Intrinsics.areEqual(this.sentAt, notificationLaunchAttribution.sentAt) && Intrinsics.areEqual(this.receivedAtMillis, notificationLaunchAttribution.receivedAtMillis) && this.openedAtMillis == notificationLaunchAttribution.openedAtMillis && this.didReportGameLaunch == notificationLaunchAttribution.didReportGameLaunch;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.openKey.hashCode() * 31) + this.notifRef.hashCode()) * 31;
            String str = this.sentAt;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.receivedAtMillis;
            return ((((hashCode2 + (l != null ? l.hashCode() : 0)) * 31) + Long.hashCode(this.openedAtMillis)) * 31) + Boolean.hashCode(this.didReportGameLaunch);
        }

        public String toString() {
            String str = this.openKey;
            String str2 = this.notifRef;
            String str3 = this.sentAt;
            Long l = this.receivedAtMillis;
            long j = this.openedAtMillis;
            return "NotificationLaunchAttribution(openKey=" + str + ", notifRef=" + str2 + ", sentAt=" + str3 + ", receivedAtMillis=" + l + ", openedAtMillis=" + j + ", didReportGameLaunch=" + this.didReportGameLaunch + ")";
        }

        public NotificationLaunchAttribution(String openKey, String notifRef, String str, Long l, long j, boolean z) {
            Intrinsics.checkNotNullParameter(openKey, "openKey");
            Intrinsics.checkNotNullParameter(notifRef, "notifRef");
            this.openKey = openKey;
            this.notifRef = notifRef;
            this.sentAt = str;
            this.receivedAtMillis = l;
            this.openedAtMillis = j;
            this.didReportGameLaunch = z;
        }

        public final String getOpenKey() {
            return this.openKey;
        }

        public final String getNotifRef() {
            return this.notifRef;
        }

        public final String getSentAt() {
            return this.sentAt;
        }

        public final Long getReceivedAtMillis() {
            return this.receivedAtMillis;
        }

        public final long getOpenedAtMillis() {
            return this.openedAtMillis;
        }

        public final boolean getDidReportGameLaunch() {
            return this.didReportGameLaunch;
        }
    }

    static /* synthetic */ boolean isActive$default(MainEntrench mainEntrench, NotificationLaunchAttribution notificationLaunchAttribution, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return mainEntrench.isActive(notificationLaunchAttribution, j);
    }

    private final boolean isActive(NotificationLaunchAttribution notificationLaunchAttribution, long j) {
        if (!StringsKt.isBlank(notificationLaunchAttribution.getNotifRef()) && notificationLaunchAttribution.getOpenedAtMillis() > 0) {
            long openedAtMillis = j - notificationLaunchAttribution.getOpenedAtMillis();
            if (0 <= openedAtMillis && openedAtMillis < 300001) {
                return true;
            }
        }
        return false;
    }

    private final Map<String, String> notificationSelectedServerGameLaunchMetadata(ServerType serverType) {
        ServerModel selectedServer = ConnectionHolder.INSTANCE.getSelectedServer();
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("server_type", StringsKt.replace$default(serverType.getServerName(), '\n', ' ', false, 4, (Object) null));
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_CODE, String.valueOf(serverType.getBackendLaunchCode()));
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_NUMBER, String.valueOf(selectedServer.getNumber()));
        String ip = selectedServer.getIp();
        if (StringsKt.isBlank(ip)) {
            ip = null;
        }
        if (ip != null) {
            String str = (String) createMapBuilder.put("server_ip", ip);
        }
        String port = selectedServer.getPort();
        String str2 = StringsKt.isBlank(port) ? null : port;
        if (str2 != null) {
            String str3 = (String) createMapBuilder.put("server_port", str2);
        }
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_IS_MOBILE, String.valueOf(selectedServer.isMobile()));
        String notificationStatsNickname = getNotificationStatsNickname();
        if (notificationStatsNickname != null) {
            createMapBuilder.put(SettingsConstants.NICKNAME, notificationStatsNickname);
        }
        return MapsKt.build(createMapBuilder);
    }

    private final Map<String, String> notificationTestServerGameLaunchMetadata(ServerType serverType) {
        SettingsData settingsData = ConnectionHolder.INSTANCE.getSettingsData();
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("server_type", StringsKt.replace$default(serverType.getServerName(), '\n', ' ', false, 4, (Object) null));
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_CODE, String.valueOf(serverType.getBackendLaunchCode()));
        String ip = settingsData.getIp();
        if (StringsKt.isBlank(ip)) {
            ip = null;
        }
        if (ip != null) {
            String str = (String) createMapBuilder.put("server_ip", ip);
        }
        String port = settingsData.getPort();
        String str2 = StringsKt.isBlank(port) ? null : port;
        if (str2 != null) {
            String str3 = (String) createMapBuilder.put("server_port", str2);
        }
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_IS_MOBILE, "false");
        createMapBuilder.put(NotificationStatsPayloadFactory.KEY_SERVER_IS_TEST, "true");
        String notificationStatsNickname = getNotificationStatsNickname();
        if (notificationStatsNickname != null) {
            createMapBuilder.put(SettingsConstants.NICKNAME, notificationStatsNickname);
        }
        return MapsKt.build(createMapBuilder);
    }

    private final String getNotificationStatsNickname() {
        return getSavedAuthorizationNickname();
    }

    private final String getSavedAuthorizationNickname() {
        Object m9898constructorimpl;
        SharedPreferences sharedPreferences;
        Object obj;
        String obj2;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            MainEntrench mainEntrench = this;
            sharedPreferences = getSharedPreferences("UI_ELEMENTS_SP", 0);
            obj = sharedPreferences.getAll().get(AUTH_SERVER_ID_KEY);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
        }
        if (obj != null && (obj2 = obj.toString()) != null) {
            if (StringsKt.isBlank(obj2)) {
                obj2 = null;
            }
            if (obj2 != null) {
                Object obj3 = sharedPreferences.getAll().get("REGDATA");
                String str2 = obj3 instanceof String ? (String) obj3 : null;
                if (str2 == null) {
                    return null;
                }
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(obj2);
                if (optJSONObject == null || (str = optJSONObject.optString("username")) == null || StringsKt.isBlank(str)) {
                    str = null;
                }
                m9898constructorimpl = Result.m9898constructorimpl(str);
                Throwable m9901exceptionOrNullimpl = Result.m9901exceptionOrNullimpl(m9898constructorimpl);
                if (m9901exceptionOrNullimpl != null) {
                    Log.w(TAG, "Failed to read saved authorization nickname", m9901exceptionOrNullimpl);
                }
                return Result.m9904isFailureimpl(m9898constructorimpl) ? null : m9898constructorimpl;
            }
        }
        return null;
    }

    private final void flushPendingNotificationStats() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MainEntrench$flushPendingNotificationStats$1(this, null), 2, null);
    }
}
