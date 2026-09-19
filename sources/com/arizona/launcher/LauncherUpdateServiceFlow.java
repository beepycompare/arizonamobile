package com.arizona.launcher;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.apk.LauncherApkDownloadError;
import com.arizona.launcher.updater.apk.LauncherApkDownloadObserver;
import com.arizona.launcher.updater.apk.LauncherApkDownloadRequest;
import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.apk.LauncherApkFailureClassification;
import com.arizona.launcher.updater.apk.LauncherApkFailurePolicy;
import com.arizona.launcher.updater.apk.LauncherApkLocalStorageFailure;
import com.arizona.launcher.updater.apk.LauncherApkOutcome;
import com.arizona.launcher.updater.apk.LauncherApkPreparation;
import com.arizona.launcher.updater.apk.LauncherApkProgress;
import com.arizona.launcher.updater.apk.LauncherUpdateCheckOutcome;
import com.arizona.launcher.updater.apk.LauncherUpdateConfig;
import com.arizona.launcher.updater.apk.LauncherUpdateController;
import com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks;
import com.arizona.launcher.updater.apk.LauncherUpdatePhase;
import com.arizona.launcher.updater.http.UpdateMetadataFetcher;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.HttpUrl;
/* compiled from: LauncherUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 e2\u00020\u0001:\u0002deBü\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\u0015\u0012B\u0010\u0018\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0015¢\u0006\u0004\b\u001e\u0010\u001fB¤\u0001\b\u0016\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007¢\u0006\u0004\b\u001e\u0010(Bê\u0001\b\u0010\u0012\u0006\u0010 \u001a\u00020!\u0012\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0012(\u0010,\u001a$\b\u0001\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002000*\u0012\u0006\u0012\u0004\u0018\u00010\u00010-\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u0012\u0006\u00101\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u00102J\u0006\u0010A\u001a\u00020\u000eJ\u0006\u0010B\u001a\u00020\u000eJ\u0006\u0010C\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020GH\u0002J8\u0010H\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010I\u001a\u00020J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010L\u001a\u00020\u00132\b\b\u0002\u0010M\u001a\u00020\bH\u0002J\u001a\u0010N\u001a\u00020\u000e2\b\u0010O\u001a\u0004\u0018\u0001052\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010P\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020QH\u0002J\u0018\u0010R\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0002J \u0010U\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\u0006\u0010I\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0018\u0010X\u001a\u00020\u00132\u0006\u0010I\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0018\u0010]\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010^\u001a\u00020;H\u0002J\u0010\u0010_\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0010\u0010`\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0010\u0010a\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u0019H\u0002J\b\u0010b\u001a\u00020\u000eH\u0002J\u0010\u0010c\u001a\u00020\b2\u0006\u0010I\u001a\u00020YH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b04X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bg\u0012\b\bh\u0012\u0004\b\u0003\u0010\u0000¨\u0006f"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceFlow;", "", "analyticsReporter", "Lcom/arizona/launcher/UpdateAnalyticsReporter;", "host", "Lcom/arizona/launcher/LauncherUpdateServiceHost;", "currentServer", "Lkotlin/Function0;", "", "markCurrentServerUnreachable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "failedServer", "", "postToMain", "mirrorCount", "", "hasValidatedNetwork", "", "logMetadataAttempt", "Lkotlin/Function2;", "message", FirebaseAnalytics.Param.SUCCESS, "controllerFactory", "", "isCurrent", "Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;", "callbacks", "Lcom/arizona/launcher/updater/apk/LauncherUpdateController;", "<init>", "(Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "metadataFetcher", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "launcherApkDownloader", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;", "config", "Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "metadataRequest", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "apkDownload", "Lkotlin/Function3;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "testSeam", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/Unit;)V", "checkServers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/arizona/launcher/LauncherUpdateServiceFlow$LauncherCheckAttempt;", "apkServers", "progressLock", "progressOperationToken", "Ljava/lang/Long;", "latestProgress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "lastPublishedProgress", "lastAcceptedAttempt", "Ljava/lang/Integer;", "lastAcceptedAtMs", "controller", "requestCheck", "requestApkDownload", "cancelApkDownload", "handleCheckOutcome", "token", "outcome", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "failLauncherCheck", "error", "Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "result", "allowFallback", "failureSubtype", "logLauncherMetadataAttempt", "context", "handleApkOutcome", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "handleCancellation", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/apk/LauncherUpdatePhase;", "handleUnexpectedFailure", "", "isCurrentControllerOperation", "shouldMarkLauncherServerUnreachable", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "classification", "Lcom/arizona/launcher/updater/apk/LauncherApkFailureClassification;", "resetProgressGate", "offerProgress", "progress", "consumeAcceptedProgress", "flushAndFenceProgress", "fenceProgress", "fenceProgressLocked", "describeFailureCause", "LauncherCheckAttempt", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateServiceFlow {
    @Deprecated
    public static final String JSON_INVALID_SUBTYPE = "JSON_INVALID";
    @Deprecated
    public static final long PROGRESS_INTERVAL_MS = 200;
    @Deprecated
    public static final String TAG = "LAUNCHER_UPDATE_FLOW";
    private final UpdateAnalyticsReporter analyticsReporter;
    private final ConcurrentHashMap<Long, String> apkServers;
    private final ConcurrentHashMap<Long, LauncherCheckAttempt> checkServers;
    private final LauncherUpdateController controller;
    private final Function0<String> currentServer;
    private final Function0<Boolean> hasValidatedNetwork;
    private final LauncherUpdateServiceHost host;
    private long lastAcceptedAtMs;
    private Integer lastAcceptedAttempt;
    private LauncherApkProgress lastPublishedProgress;
    private LauncherApkProgress latestProgress;
    private final Function2<String, Boolean, Unit> logMetadataAttempt;
    private final Function1<String, Unit> markCurrentServerUnreachable;
    private final Function0<Integer> mirrorCount;
    private final Function1<Function0<Unit>, Unit> postToMain;
    private final Object progressLock;
    private Long progressOperationToken;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: LauncherUpdateServiceFlow.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LauncherUpdatePhase.values().length];
            try {
                iArr[LauncherUpdatePhase.METADATA_CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LauncherUpdatePhase.APK_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int _init_$lambda$0() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean _init_$lambda$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int _init_$lambda$4() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean _init_$lambda$5() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LauncherUpdateServiceFlow(UpdateAnalyticsReporter updateAnalyticsReporter, LauncherUpdateServiceHost launcherUpdateServiceHost, Function0<String> function0, Function1<? super String, Unit> function1, Function1<? super Function0<Unit>, Unit> function12, Function0<Integer> function02, Function0<Boolean> function03, Function2<? super String, ? super Boolean, Unit> function2, Function2<? super Function1<? super Long, Boolean>, ? super LauncherUpdateControllerCallbacks, LauncherUpdateController> function22) {
        this.analyticsReporter = updateAnalyticsReporter;
        this.host = launcherUpdateServiceHost;
        this.currentServer = function0;
        this.markCurrentServerUnreachable = function1;
        this.postToMain = function12;
        this.mirrorCount = function02;
        this.hasValidatedNetwork = function03;
        this.logMetadataAttempt = function2;
        this.checkServers = new ConcurrentHashMap<>();
        this.apkServers = new ConcurrentHashMap<>();
        this.progressLock = new Object();
        this.controller = function22.invoke(new LauncherUpdateServiceFlow$controller$1(this), callbacks());
    }

    public /* synthetic */ LauncherUpdateServiceFlow(CoroutineScope coroutineScope, UpdateMetadataFetcher updateMetadataFetcher, LauncherApkDownloader launcherApkDownloader, LauncherUpdateConfig launcherUpdateConfig, UpdateAnalyticsReporter updateAnalyticsReporter, LauncherUpdateServiceHost launcherUpdateServiceHost, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, updateMetadataFetcher, launcherApkDownloader, launcherUpdateConfig, updateAnalyticsReporter, launcherUpdateServiceHost, function0, function1, function12, (i & 512) != 0 ? new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(LauncherUpdateServiceFlow._init_$lambda$0());
            }
        } : function02, (i & 1024) != 0 ? new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(LauncherUpdateServiceFlow._init_$lambda$1());
            }
        } : function03);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateServiceFlow(final CoroutineScope scope, final UpdateMetadataFetcher metadataFetcher, final LauncherApkDownloader launcherApkDownloader, final LauncherUpdateConfig config, UpdateAnalyticsReporter analyticsReporter, LauncherUpdateServiceHost host, Function0<String> currentServer, Function1<? super String, Unit> markCurrentServerUnreachable, Function1<? super Function0<Unit>, Unit> postToMain, Function0<Integer> mirrorCount, Function0<Boolean> hasValidatedNetwork) {
        this(analyticsReporter, host, currentServer, markCurrentServerUnreachable, postToMain, mirrorCount, hasValidatedNetwork, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$2((String) obj, ((Boolean) obj2).booleanValue());
            }
        }, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$3(CoroutineScope.this, metadataFetcher, launcherApkDownloader, config, (Function1) obj, (LauncherUpdateControllerCallbacks) obj2);
            }
        });
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(metadataFetcher, "metadataFetcher");
        Intrinsics.checkNotNullParameter(launcherApkDownloader, "launcherApkDownloader");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(analyticsReporter, "analyticsReporter");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(currentServer, "currentServer");
        Intrinsics.checkNotNullParameter(markCurrentServerUnreachable, "markCurrentServerUnreachable");
        Intrinsics.checkNotNullParameter(postToMain, "postToMain");
        Intrinsics.checkNotNullParameter(mirrorCount, "mirrorCount");
        Intrinsics.checkNotNullParameter(hasValidatedNetwork, "hasValidatedNetwork");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$2(String message, boolean z) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            Log.i(TAG, message);
        } else {
            Log.w(TAG, message);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LauncherUpdateController _init_$lambda$3(CoroutineScope coroutineScope, UpdateMetadataFetcher updateMetadataFetcher, LauncherApkDownloader launcherApkDownloader, LauncherUpdateConfig launcherUpdateConfig, Function1 isCurrent, LauncherUpdateControllerCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(isCurrent, "isCurrent");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        return new LauncherUpdateController(coroutineScope, updateMetadataFetcher, launcherApkDownloader, launcherUpdateConfig, isCurrent, callbacks);
    }

    public /* synthetic */ LauncherUpdateServiceFlow(CoroutineScope coroutineScope, Function2 function2, Function3 function3, LauncherUpdateConfig launcherUpdateConfig, UpdateAnalyticsReporter updateAnalyticsReporter, LauncherUpdateServiceHost launcherUpdateServiceHost, Function0 function0, Function1 function1, Function1 function12, Function0 function02, Function0 function03, Unit unit, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, function2, function3, launcherUpdateConfig, updateAnalyticsReporter, launcherUpdateServiceHost, function0, function1, function12, (i & 512) != 0 ? new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(LauncherUpdateServiceFlow._init_$lambda$4());
            }
        } : function02, (i & 1024) != 0 ? new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(LauncherUpdateServiceFlow._init_$lambda$5());
            }
        } : function03, unit);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateServiceFlow(final CoroutineScope scope, final Function2<? super String, ? super Continuation<? super UpdateMetadataHttpResult>, ? extends Object> metadataRequest, final Function3<? super LauncherApkDownloadRequest, ? super LauncherApkDownloadObserver, ? super Continuation<? super LauncherApkDownloadResult>, ? extends Object> apkDownload, final LauncherUpdateConfig config, UpdateAnalyticsReporter analyticsReporter, LauncherUpdateServiceHost host, Function0<String> currentServer, Function1<? super String, Unit> markCurrentServerUnreachable, Function1<? super Function0<Unit>, Unit> postToMain, Function0<Integer> mirrorCount, Function0<Boolean> hasValidatedNetwork, Unit testSeam) {
        this(analyticsReporter, host, currentServer, markCurrentServerUnreachable, postToMain, mirrorCount, hasValidatedNetwork, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$6((String) obj, ((Boolean) obj2).booleanValue());
            }
        }, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$7(CoroutineScope.this, metadataRequest, apkDownload, config, (Function1) obj, (LauncherUpdateControllerCallbacks) obj2);
            }
        });
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(metadataRequest, "metadataRequest");
        Intrinsics.checkNotNullParameter(apkDownload, "apkDownload");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(analyticsReporter, "analyticsReporter");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(currentServer, "currentServer");
        Intrinsics.checkNotNullParameter(markCurrentServerUnreachable, "markCurrentServerUnreachable");
        Intrinsics.checkNotNullParameter(postToMain, "postToMain");
        Intrinsics.checkNotNullParameter(mirrorCount, "mirrorCount");
        Intrinsics.checkNotNullParameter(hasValidatedNetwork, "hasValidatedNetwork");
        Intrinsics.checkNotNullParameter(testSeam, "testSeam");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$6(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LauncherUpdateController _init_$lambda$7(CoroutineScope coroutineScope, Function2 function2, Function3 function3, LauncherUpdateConfig launcherUpdateConfig, Function1 isCurrent, LauncherUpdateControllerCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(isCurrent, "isCurrent");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        return new LauncherUpdateController(coroutineScope, function2, function3, launcherUpdateConfig, isCurrent, callbacks, Unit.INSTANCE);
    }

    public final void requestCheck() {
        Long beginLauncherCheckOperation = this.host.beginLauncherCheckOperation();
        if (beginLauncherCheckOperation != null) {
            long longValue = beginLauncherCheckOperation.longValue();
            this.host.setLauncherOperationHealthy();
            String invoke = this.currentServer.invoke();
            this.checkServers.put(Long.valueOf(longValue), new LauncherCheckAttempt(invoke, 1, RangesKt.coerceAtLeast(this.mirrorCount.invoke().intValue(), 1), StringsKt.isBlank(invoke) ? SetsKt.emptySet() : SetsKt.setOf(invoke)));
            this.controller.checkLauncherUpdate(longValue, invoke);
        }
    }

    public final void requestApkDownload() {
        UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent;
        Long beginLauncherApkOperation = this.host.beginLauncherApkOperation();
        if (beginLauncherApkOperation != null) {
            long longValue = beginLauncherApkOperation.longValue();
            resetProgressGate(longValue);
            String invoke = this.currentServer.invoke();
            this.apkServers.put(Long.valueOf(longValue), invoke);
            LauncherApkPreparation prepareLauncherApkDownload = this.controller.prepareLauncherApkDownload(invoke, this.host.externalFilesRoot());
            if (Intrinsics.areEqual(prepareLauncherApkDownload, LauncherApkPreparation.ServerEmpty.INSTANCE) || Intrinsics.areEqual(prepareLauncherApkDownload, LauncherApkPreparation.ExternalStorageUnavailable.INSTANCE)) {
                boolean areEqual = Intrinsics.areEqual(prepareLauncherApkDownload, LauncherApkPreparation.ServerEmpty.INSTANCE);
                UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
                if (areEqual) {
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.LAUNCHER_APK_SERVER_EMPTY;
                } else {
                    updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED;
                }
                UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter, updateAnalyticsErrorEvent, null, invoke, null, 10, null);
                fenceProgress(longValue);
                this.host.completeLauncherApk(longValue, false, false, false, invoke, areEqual ? null : LauncherApkLocalStorageFailure.UNAVAILABLE);
                this.apkServers.remove(Long.valueOf(longValue));
            } else if (!(prepareLauncherApkDownload instanceof LauncherApkPreparation.Ready)) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (!this.host.promoteLauncherForeground()) {
                    UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, invoke, null, 10, null);
                    fenceProgress(longValue);
                    this.host.completeLauncherApk(longValue, false, false, false, invoke, null);
                    this.apkServers.remove(Long.valueOf(longValue));
                    return;
                }
                this.host.setLauncherOperationHealthy();
                this.host.beginLauncherProgress();
                this.controller.startLauncherApkDownload(longValue, (LauncherApkPreparation.Ready) prepareLauncherApkDownload);
            }
        }
    }

    public final boolean cancelApkDownload() {
        return this.controller.cancelLauncherApkDownload();
    }

    private final LauncherUpdateControllerCallbacks callbacks() {
        return new LauncherUpdateServiceFlow$callbacks$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCheckOutcome(long j, LauncherUpdateCheckOutcome launcherUpdateCheckOutcome) {
        String invoke;
        boolean isCurrentLauncherCheckOperation = this.host.isCurrentLauncherCheckOperation(j);
        ConcurrentHashMap<Long, LauncherCheckAttempt> concurrentHashMap = this.checkServers;
        if (!isCurrentLauncherCheckOperation) {
            concurrentHashMap.remove(Long.valueOf(j));
            return;
        }
        logLauncherMetadataAttempt(concurrentHashMap.get(Long.valueOf(j)), launcherUpdateCheckOutcome);
        if (launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.Success) {
            this.checkServers.remove(Long.valueOf(j));
            this.host.completeLauncherCheck(j, ((LauncherUpdateCheckOutcome.Success) launcherUpdateCheckOutcome).getNeedsUpdate(), true);
        } else if (Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.ServerEmpty.INSTANCE)) {
            LauncherCheckAttempt remove = this.checkServers.remove(Long.valueOf(j));
            if (remove == null || (invoke = remove.getServer()) == null) {
                invoke = this.currentServer.invoke();
            }
            String str = invoke;
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_SERVER_EMPTY, null, str, null, 10, null);
            this.markCurrentServerUnreachable.invoke(str);
            this.host.completeLauncherCheck(j, false, false);
        } else if (launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.RequestFailed) {
            LauncherUpdateCheckOutcome.RequestFailed requestFailed = (LauncherUpdateCheckOutcome.RequestFailed) launcherUpdateCheckOutcome;
            boolean z = requestFailed.getResult() instanceof UpdateMetadataHttpResult.InvalidRequest;
            UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent = UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED;
            UpdateMetadataHttpResult result = requestFailed.getResult();
            boolean z2 = true ^ z;
            DownloadFailureDetails metadataFailureDetails$app = this.analyticsReporter.metadataFailureDetails$app(requestFailed.getResult());
            String subtypeSuffix = metadataFailureDetails$app != null ? metadataFailureDetails$app.getSubtypeSuffix() : null;
            if (subtypeSuffix == null) {
                subtypeSuffix = "";
            }
            failLauncherCheck(j, updateAnalyticsErrorEvent, result, z2, subtypeSuffix);
        } else if (!Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.InvalidMetadata.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            failLauncherCheck$default(this, j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_JSON_INVALID, null, true, JSON_INVALID_SUBTYPE, 4, null);
        }
    }

    static /* synthetic */ void failLauncherCheck$default(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, UpdateMetadataHttpResult updateMetadataHttpResult, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            updateMetadataHttpResult = null;
        }
        UpdateMetadataHttpResult updateMetadataHttpResult2 = updateMetadataHttpResult;
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str = "";
        }
        launcherUpdateServiceFlow.failLauncherCheck(j, updateAnalyticsErrorEvent, updateMetadataHttpResult2, z2, str);
    }

    private final void failLauncherCheck(long j, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, UpdateMetadataHttpResult updateMetadataHttpResult, boolean z, String str) {
        String invoke;
        LauncherCheckAttempt launcherCheckAttempt = this.checkServers.get(Long.valueOf(j));
        if (launcherCheckAttempt == null || (invoke = launcherCheckAttempt.getServer()) == null) {
            invoke = this.currentServer.invoke();
        }
        String str2 = invoke;
        this.markCurrentServerUnreachable.invoke(str2);
        UpdateAnalyticsReporter updateAnalyticsReporter = this.analyticsReporter;
        if (updateMetadataHttpResult != null) {
            updateAnalyticsReporter.reportMetadataError(updateAnalyticsErrorEvent, updateMetadataHttpResult, str2);
        } else {
            UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter, updateAnalyticsErrorEvent, null, str2, null, 10, null);
        }
        String invoke2 = this.currentServer.invoke();
        if (z && this.hasValidatedNetwork.invoke().booleanValue() && this.host.isCurrentLauncherCheckOperation(j) && launcherCheckAttempt != null && launcherCheckAttempt.getAttempt() < launcherCheckAttempt.getBudget() && !StringsKt.isBlank(invoke2) && !launcherCheckAttempt.getTried().contains(invoke2)) {
            this.analyticsReporter.reportLauncherMetadataRetry(launcherCheckAttempt.getAttempt(), str, str2);
            this.checkServers.put(Long.valueOf(j), LauncherCheckAttempt.copy$default(launcherCheckAttempt, invoke2, launcherCheckAttempt.getAttempt() + 1, 0, SetsKt.plus(launcherCheckAttempt.getTried(), invoke2), 4, null));
            this.controller.checkLauncherUpdate(j, invoke2);
            return;
        }
        this.checkServers.remove(Long.valueOf(j));
        this.host.completeLauncherCheck(j, false, false);
    }

    private final void logLauncherMetadataAttempt(LauncherCheckAttempt launcherCheckAttempt, LauncherUpdateCheckOutcome launcherUpdateCheckOutcome) {
        String invoke;
        String str;
        int attempt = launcherCheckAttempt != null ? launcherCheckAttempt.getAttempt() : 1;
        Companion companion = Companion;
        if (launcherCheckAttempt == null || (invoke = launcherCheckAttempt.getServer()) == null) {
            invoke = this.currentServer.invoke();
        }
        String launcherMetadataHost = companion.launcherMetadataHost(invoke);
        boolean z = launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.Success;
        if (z) {
            str = "outcome=success";
        } else if (Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.ServerEmpty.INSTANCE)) {
            str = "outcome=server_empty code=" + UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_SERVER_EMPTY.getCode();
        } else if (launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.RequestFailed) {
            DownloadFailureDetails metadataFailureDetails$app = this.analyticsReporter.metadataFailureDetails$app(((LauncherUpdateCheckOutcome.RequestFailed) launcherUpdateCheckOutcome).getResult());
            String subtypeSuffix = metadataFailureDetails$app != null ? metadataFailureDetails$app.getSubtypeSuffix() : null;
            if (subtypeSuffix == null) {
                subtypeSuffix = "";
            }
            str = "outcome=request_failed subtype=" + subtypeSuffix + " code=" + UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED.getCode();
        } else if (!Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.InvalidMetadata.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = "outcome=invalid_json subtype=JSON_INVALID code=" + UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_JSON_INVALID.getCode();
        }
        this.logMetadataAttempt.invoke("stage=launcher_metadata attempt=" + attempt + " host=" + launcherMetadataHost + " " + str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleApkOutcome(long j, LauncherApkOutcome launcherApkOutcome) {
        boolean isCurrentLauncherApkOperation = this.host.isCurrentLauncherApkOperation(j);
        ConcurrentHashMap<Long, String> concurrentHashMap = this.apkServers;
        if (!isCurrentLauncherApkOperation) {
            concurrentHashMap.remove(Long.valueOf(j));
            fenceProgress(j);
            return;
        }
        String remove = concurrentHashMap.remove(Long.valueOf(j));
        if (remove == null) {
            remove = this.currentServer.invoke();
        }
        String str = remove;
        if (launcherApkOutcome instanceof LauncherApkOutcome.Success) {
            LauncherApkDownloadResult.Success result = ((LauncherApkOutcome.Success) launcherApkOutcome).getResult();
            flushAndFenceProgress(j);
            this.host.completeLauncherProgress(result.getTotalBytes());
            this.host.completeLauncherApk(j, true, false, true, null, null);
            long totalBytes = result.getTotalBytes();
            int attempts = result.getAttempts();
            Log.i(TAG, "Launcher APK ready: bytes=" + totalBytes + ", attempts=" + attempts + ", resumed=" + result.getResumedFromBytes());
        } else if (!(launcherApkOutcome instanceof LauncherApkOutcome.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, str, null, 10, null);
            LauncherApkOutcome.Failure failure = (LauncherApkOutcome.Failure) launcherApkOutcome;
            LauncherApkLocalStorageFailure localStorageFailure = LauncherApkFailurePolicy.INSTANCE.localStorageFailure(failure.getResult().getError());
            fenceProgress(j);
            this.host.completeLauncherApk(j, false, shouldMarkLauncherServerUnreachable(failure.getResult().getError(), failure.getClassification()), true, str, localStorageFailure);
            String label = failure.getClassification().getLabel();
            int attempts2 = failure.getResult().getAttempts();
            Log.e(TAG, "Launcher APK download failed: " + label + ", attempts=" + attempts2 + describeFailureCause(failure.getResult().getError()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCancellation(long j, LauncherUpdatePhase launcherUpdatePhase) {
        int i = WhenMappings.$EnumSwitchMapping$0[launcherUpdatePhase.ordinal()];
        if (i == 1) {
            if (this.host.isCurrentLauncherCheckOperation(j)) {
                failLauncherCheck$default(this, j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED, null, false, null, 28, null);
            } else {
                this.checkServers.remove(Long.valueOf(j));
            }
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            boolean isCurrentLauncherApkOperation = this.host.isCurrentLauncherApkOperation(j);
            ConcurrentHashMap<Long, String> concurrentHashMap = this.apkServers;
            if (!isCurrentLauncherApkOperation) {
                concurrentHashMap.remove(Long.valueOf(j));
                return;
            }
            String remove = concurrentHashMap.remove(Long.valueOf(j));
            if (remove == null) {
                remove = this.currentServer.invoke();
            }
            String str = remove;
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_CANCELED, null, str, null, 10, null);
            fenceProgress(j);
            this.host.completeLauncherApk(j, false, false, true, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleUnexpectedFailure(long j, LauncherUpdatePhase launcherUpdatePhase, Throwable th) {
        boolean isCurrentLauncherCheckOperation;
        int i = WhenMappings.$EnumSwitchMapping$0[launcherUpdatePhase.ordinal()];
        if (i == 1) {
            isCurrentLauncherCheckOperation = this.host.isCurrentLauncherCheckOperation(j);
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            isCurrentLauncherCheckOperation = this.host.isCurrentLauncherApkOperation(j);
        }
        if (!isCurrentLauncherCheckOperation) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[launcherUpdatePhase.ordinal()];
            if (i2 == 1) {
                this.checkServers.remove(Long.valueOf(j));
                return;
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                this.apkServers.remove(Long.valueOf(j));
                return;
            }
        }
        this.host.recordLauncherException(th);
        int i3 = WhenMappings.$EnumSwitchMapping$0[launcherUpdatePhase.ordinal()];
        if (i3 == 1) {
            failLauncherCheck$default(this, j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED, null, false, null, 28, null);
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            String remove = this.apkServers.remove(Long.valueOf(j));
            if (remove == null) {
                remove = this.currentServer.invoke();
            }
            String str = remove;
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, str, null, 10, null);
            fenceProgress(j);
            this.host.completeLauncherApk(j, false, true, true, str, null);
        }
        Log.e(TAG, "Unexpected launcher " + launcherUpdatePhase + " failure", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCurrentControllerOperation(long j) {
        return this.host.isCurrentLauncherCheckOperation(j) || this.host.isCurrentLauncherApkOperation(j);
    }

    private final boolean shouldMarkLauncherServerUnreachable(LauncherApkDownloadError launcherApkDownloadError, LauncherApkFailureClassification launcherApkFailureClassification) {
        if (launcherApkFailureClassification.isRemoteFailure()) {
            if (launcherApkDownloadError instanceof LauncherApkDownloadError.Network) {
                return this.hasValidatedNetwork.invoke().booleanValue();
            }
            return true;
        }
        return false;
    }

    private final void resetProgressGate(long j) {
        synchronized (this.progressLock) {
            this.progressOperationToken = Long.valueOf(j);
            this.latestProgress = null;
            this.lastPublishedProgress = null;
            this.lastAcceptedAttempt = null;
            this.lastAcceptedAtMs = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void offerProgress(final long j, LauncherApkProgress launcherApkProgress) {
        synchronized (this.progressLock) {
            Long l = this.progressOperationToken;
            if (l != null && l.longValue() == j) {
                if (this.host.isCurrentLauncherApkOperation(j)) {
                    this.latestProgress = launcherApkProgress;
                    Integer num = this.lastAcceptedAttempt;
                    boolean z = true;
                    boolean z2 = num == null;
                    int attempt = launcherApkProgress.getAttempt();
                    if (num != null && num.intValue() == attempt) {
                        z = false;
                    }
                    long progressClockMs = Companion.progressClockMs();
                    long coerceAtLeast = RangesKt.coerceAtLeast(progressClockMs - this.lastAcceptedAtMs, 0L);
                    if (z2 || z || coerceAtLeast >= 200) {
                        this.lastAcceptedAttempt = Integer.valueOf(launcherApkProgress.getAttempt());
                        this.lastAcceptedAtMs = progressClockMs;
                        this.postToMain.invoke(new Function0() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LauncherUpdateServiceFlow.offerProgress$lambda$1(LauncherUpdateServiceFlow.this, j);
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit offerProgress$lambda$1(LauncherUpdateServiceFlow launcherUpdateServiceFlow, long j) {
        launcherUpdateServiceFlow.consumeAcceptedProgress(j);
        return Unit.INSTANCE;
    }

    private final void consumeAcceptedProgress(long j) {
        synchronized (this.progressLock) {
            Long l = this.progressOperationToken;
            if (l != null && l.longValue() == j) {
                if (this.host.isCurrentLauncherApkOperation(j)) {
                    LauncherApkProgress launcherApkProgress = this.latestProgress;
                    if (launcherApkProgress == null) {
                        return;
                    }
                    if (Intrinsics.areEqual(launcherApkProgress, this.lastPublishedProgress)) {
                        return;
                    }
                    this.lastPublishedProgress = launcherApkProgress;
                    this.host.updateLauncherProgress(launcherApkProgress.getDownloadedBytes(), launcherApkProgress.getTotalBytes(), launcherApkProgress.getAttempt(), launcherApkProgress.getResumed());
                }
            }
        }
    }

    private final void flushAndFenceProgress(long j) {
        synchronized (this.progressLock) {
            Long l = this.progressOperationToken;
            if (l != null && l.longValue() == j) {
                LauncherApkProgress launcherApkProgress = this.latestProgress;
                if (launcherApkProgress == null || Intrinsics.areEqual(launcherApkProgress, this.lastPublishedProgress)) {
                    launcherApkProgress = null;
                }
                fenceProgressLocked();
                if (launcherApkProgress == null || !this.host.isCurrentLauncherApkOperation(j)) {
                    return;
                }
                this.host.updateLauncherProgress(launcherApkProgress.getDownloadedBytes(), launcherApkProgress.getTotalBytes(), launcherApkProgress.getAttempt(), launcherApkProgress.getResumed());
            }
        }
    }

    private final void fenceProgress(long j) {
        synchronized (this.progressLock) {
            Long l = this.progressOperationToken;
            if (l != null && l.longValue() == j) {
                fenceProgressLocked();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void fenceProgressLocked() {
        this.progressOperationToken = null;
        this.latestProgress = null;
        this.lastPublishedProgress = null;
        this.lastAcceptedAttempt = null;
        this.lastAcceptedAtMs = 0L;
    }

    private final String describeFailureCause(LauncherApkDownloadError launcherApkDownloadError) {
        if (launcherApkDownloadError instanceof LauncherApkDownloadError.Storage) {
            IOException cause = ((LauncherApkDownloadError.Storage) launcherApkDownloadError).getCause();
            String simpleName = cause.getClass().getSimpleName();
            return ", cause=" + simpleName + ": " + LauncherApkFailurePolicy.INSTANCE.redactForLog(cause.getMessage());
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceFlow$LauncherCheckAttempt;", "", "server", "", "attempt", "", "budget", "tried", "", "<init>", "(Ljava/lang/String;IILjava/util/Set;)V", "getServer", "()Ljava/lang/String;", "getAttempt", "()I", "getBudget", "getTried", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LauncherCheckAttempt {
        private final int attempt;
        private final int budget;
        private final String server;
        private final Set<String> tried;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LauncherCheckAttempt copy$default(LauncherCheckAttempt launcherCheckAttempt, String str, int i, int i2, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = launcherCheckAttempt.server;
            }
            if ((i3 & 2) != 0) {
                i = launcherCheckAttempt.attempt;
            }
            if ((i3 & 4) != 0) {
                i2 = launcherCheckAttempt.budget;
            }
            if ((i3 & 8) != 0) {
                set = launcherCheckAttempt.tried;
            }
            return launcherCheckAttempt.copy(str, i, i2, set);
        }

        public final String component1() {
            return this.server;
        }

        public final int component2() {
            return this.attempt;
        }

        public final int component3() {
            return this.budget;
        }

        public final Set<String> component4() {
            return this.tried;
        }

        public final LauncherCheckAttempt copy(String server, int i, int i2, Set<String> tried) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(tried, "tried");
            return new LauncherCheckAttempt(server, i, i2, tried);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LauncherCheckAttempt) {
                LauncherCheckAttempt launcherCheckAttempt = (LauncherCheckAttempt) obj;
                return Intrinsics.areEqual(this.server, launcherCheckAttempt.server) && this.attempt == launcherCheckAttempt.attempt && this.budget == launcherCheckAttempt.budget && Intrinsics.areEqual(this.tried, launcherCheckAttempt.tried);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.server.hashCode() * 31) + Integer.hashCode(this.attempt)) * 31) + Integer.hashCode(this.budget)) * 31) + this.tried.hashCode();
        }

        public String toString() {
            String str = this.server;
            int i = this.attempt;
            int i2 = this.budget;
            return "LauncherCheckAttempt(server=" + str + ", attempt=" + i + ", budget=" + i2 + ", tried=" + this.tried + ")";
        }

        public LauncherCheckAttempt(String server, int i, int i2, Set<String> tried) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(tried, "tried");
            this.server = server;
            this.attempt = i;
            this.budget = i2;
            this.tried = tried;
        }

        public final String getServer() {
            return this.server;
        }

        public final int getAttempt() {
            return this.attempt;
        }

        public final int getBudget() {
            return this.budget;
        }

        public final Set<String> getTried() {
            return this.tried;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceFlow$Companion;", "", "<init>", "()V", "TAG", "", "JSON_INVALID_SUBTYPE", "PROGRESS_INTERVAL_MS", "", "launcherMetadataHost", "url", "progressClockMs", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String launcherMetadataHost(String str) {
            HttpUrl parse;
            String host = (str == null || (parse = HttpUrl.Companion.parse(str)) == null) ? null : parse.host();
            return host == null ? "" : host;
        }

        public final long progressClockMs() {
            return System.nanoTime() / 1000000;
        }
    }
}
