package com.arizona.launcher;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.apk.LauncherApkDownloadObserver;
import com.arizona.launcher.updater.apk.LauncherApkDownloadRequest;
import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.arizona.launcher.updater.apk.LauncherApkOutcome;
import com.arizona.launcher.updater.apk.LauncherApkPreparation;
import com.arizona.launcher.updater.apk.LauncherUpdateCheckOutcome;
import com.arizona.launcher.updater.apk.LauncherUpdateConfig;
import com.arizona.launcher.updater.apk.LauncherUpdateController;
import com.arizona.launcher.updater.apk.LauncherUpdateControllerCallbacks;
import com.arizona.launcher.updater.apk.LauncherUpdatePhase;
import com.arizona.launcher.updater.http.UpdateMetadataFetcher;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LauncherUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 C2\u00020\u0001:\u0001CB¨\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n\u0012B\u0010\u0010\u001a>\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0011¢\u0006\u0004\b\u0018\u0010\u0019B\u0084\u0001\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b\u0018\u0010\"BÊ\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\"\u0010#\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011\u0012(\u0010&\u001a$\b\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0$\u0012\u0006\u0012\u0004\u0018\u00010\u00010'\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0010+\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010,J\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ\u0006\u00103\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020<H\u0002J\u0018\u0010=\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?H\u0002J \u0010@\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bE\u0012\b\bF\u0012\u0004\b\u0003\u0010\u0000¨\u0006D"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceFlow;", "", "analyticsReporter", "Lcom/arizona/launcher/UpdateAnalyticsReporter;", "host", "Lcom/arizona/launcher/LauncherUpdateServiceHost;", "currentServer", "Lkotlin/Function0;", "", "markCurrentServerUnreachable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "failedServer", "", "postToMain", "controllerFactory", "Lkotlin/Function2;", "", "", "isCurrent", "Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;", "callbacks", "Lcom/arizona/launcher/updater/apk/LauncherUpdateController;", "<init>", "(Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "metadataFetcher", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "launcherApkDownloader", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;", "config", "Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "metadataRequest", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "apkDownload", "Lkotlin/Function3;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "testSeam", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lcom/arizona/launcher/UpdateAnalyticsReporter;Lcom/arizona/launcher/LauncherUpdateServiceHost;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/Unit;)V", "checkServers", "Ljava/util/concurrent/ConcurrentHashMap;", "apkServers", "controller", "requestCheck", "requestApkDownload", "cancelApkDownload", "handleCheckOutcome", "token", "outcome", "Lcom/arizona/launcher/updater/apk/LauncherUpdateCheckOutcome;", "failLauncherCheck", "error", "Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "handleApkOutcome", "Lcom/arizona/launcher/updater/apk/LauncherApkOutcome;", "handleCancellation", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/arizona/launcher/updater/apk/LauncherUpdatePhase;", "handleUnexpectedFailure", "", "isCurrentControllerOperation", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateServiceFlow {
    @Deprecated
    public static final String TAG = "LAUNCHER_UPDATE_FLOW";
    private final UpdateAnalyticsReporter analyticsReporter;
    private final ConcurrentHashMap<Long, String> apkServers;
    private final ConcurrentHashMap<Long, String> checkServers;
    private final LauncherUpdateController controller;
    private final Function0<String> currentServer;
    private final LauncherUpdateServiceHost host;
    private final Function1<String, Unit> markCurrentServerUnreachable;
    private final Function1<Function0<Unit>, Unit> postToMain;
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

    /* JADX WARN: Multi-variable type inference failed */
    private LauncherUpdateServiceFlow(UpdateAnalyticsReporter updateAnalyticsReporter, LauncherUpdateServiceHost launcherUpdateServiceHost, Function0<String> function0, Function1<? super String, Unit> function1, Function1<? super Function0<Unit>, Unit> function12, Function2<? super Function1<? super Long, Boolean>, ? super LauncherUpdateControllerCallbacks, LauncherUpdateController> function2) {
        this.analyticsReporter = updateAnalyticsReporter;
        this.host = launcherUpdateServiceHost;
        this.currentServer = function0;
        this.markCurrentServerUnreachable = function1;
        this.postToMain = function12;
        this.checkServers = new ConcurrentHashMap<>();
        this.apkServers = new ConcurrentHashMap<>();
        this.controller = function2.invoke(new LauncherUpdateServiceFlow$controller$1(this), callbacks());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateServiceFlow(final CoroutineScope scope, final UpdateMetadataFetcher metadataFetcher, final LauncherApkDownloader launcherApkDownloader, final LauncherUpdateConfig config, UpdateAnalyticsReporter analyticsReporter, LauncherUpdateServiceHost host, Function0<String> currentServer, Function1<? super String, Unit> markCurrentServerUnreachable, Function1<? super Function0<Unit>, Unit> postToMain) {
        this(analyticsReporter, host, currentServer, markCurrentServerUnreachable, postToMain, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$0(CoroutineScope.this, metadataFetcher, launcherApkDownloader, config, (Function1) obj, (LauncherUpdateControllerCallbacks) obj2);
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LauncherUpdateController _init_$lambda$0(CoroutineScope coroutineScope, UpdateMetadataFetcher updateMetadataFetcher, LauncherApkDownloader launcherApkDownloader, LauncherUpdateConfig launcherUpdateConfig, Function1 isCurrent, LauncherUpdateControllerCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(isCurrent, "isCurrent");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        return new LauncherUpdateController(coroutineScope, updateMetadataFetcher, launcherApkDownloader, launcherUpdateConfig, isCurrent, callbacks);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateServiceFlow(final CoroutineScope scope, final Function2<? super String, ? super Continuation<? super UpdateMetadataHttpResult>, ? extends Object> metadataRequest, final Function3<? super LauncherApkDownloadRequest, ? super LauncherApkDownloadObserver, ? super Continuation<? super LauncherApkDownloadResult>, ? extends Object> apkDownload, final LauncherUpdateConfig config, UpdateAnalyticsReporter analyticsReporter, LauncherUpdateServiceHost host, Function0<String> currentServer, Function1<? super String, Unit> markCurrentServerUnreachable, Function1<? super Function0<Unit>, Unit> postToMain, Unit testSeam) {
        this(analyticsReporter, host, currentServer, markCurrentServerUnreachable, postToMain, new Function2() { // from class: com.arizona.launcher.LauncherUpdateServiceFlow$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LauncherUpdateServiceFlow._init_$lambda$1(CoroutineScope.this, metadataRequest, apkDownload, config, (Function1) obj, (LauncherUpdateControllerCallbacks) obj2);
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
        Intrinsics.checkNotNullParameter(testSeam, "testSeam");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LauncherUpdateController _init_$lambda$1(CoroutineScope coroutineScope, Function2 function2, Function3 function3, LauncherUpdateConfig launcherUpdateConfig, Function1 isCurrent, LauncherUpdateControllerCallbacks callbacks) {
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
            this.checkServers.put(Long.valueOf(longValue), invoke);
            this.controller.checkLauncherUpdate(longValue, invoke);
        }
    }

    public final void requestApkDownload() {
        UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent;
        Long beginLauncherApkOperation = this.host.beginLauncherApkOperation();
        if (beginLauncherApkOperation != null) {
            long longValue = beginLauncherApkOperation.longValue();
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
                UpdateAnalyticsReporter.reportError$default(updateAnalyticsReporter, updateAnalyticsErrorEvent, null, invoke, 2, null);
                this.host.completeLauncherApk(longValue, false, false, false, invoke);
                this.apkServers.remove(Long.valueOf(longValue));
            } else if (!(prepareLauncherApkDownload instanceof LauncherApkPreparation.Ready)) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (!this.host.promoteLauncherForeground()) {
                    UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, invoke, 2, null);
                    this.host.completeLauncherApk(longValue, false, false, false, invoke);
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
        if (!this.host.isCurrentLauncherCheckOperation(j)) {
            this.checkServers.remove(Long.valueOf(j));
        } else if (launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.Success) {
            this.checkServers.remove(Long.valueOf(j));
            this.host.completeLauncherCheck(j, ((LauncherUpdateCheckOutcome.Success) launcherUpdateCheckOutcome).getNeedsUpdate(), true);
        } else if (Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.ServerEmpty.INSTANCE)) {
            String remove = this.checkServers.remove(Long.valueOf(j));
            if (remove == null) {
                remove = this.currentServer.invoke();
            }
            String str = remove;
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_SERVER_EMPTY, null, str, 2, null);
            this.markCurrentServerUnreachable.invoke(str);
            this.host.completeLauncherCheck(j, false, false);
        } else if (launcherUpdateCheckOutcome instanceof LauncherUpdateCheckOutcome.RequestFailed) {
            failLauncherCheck(j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED);
            Log.w(TAG, "Launcher metadata request failed: " + ((LauncherUpdateCheckOutcome.RequestFailed) launcherUpdateCheckOutcome).getResult());
        } else if (!Intrinsics.areEqual(launcherUpdateCheckOutcome, LauncherUpdateCheckOutcome.InvalidMetadata.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            failLauncherCheck(j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_JSON_INVALID);
        }
    }

    private final void failLauncherCheck(long j, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent) {
        String remove = this.checkServers.remove(Long.valueOf(j));
        if (remove == null) {
            remove = this.currentServer.invoke();
        }
        this.markCurrentServerUnreachable.invoke(remove);
        UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, updateAnalyticsErrorEvent, null, this.currentServer.invoke(), 2, null);
        this.host.completeLauncherCheck(j, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleApkOutcome(long j, LauncherApkOutcome launcherApkOutcome) {
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
        if (launcherApkOutcome instanceof LauncherApkOutcome.Success) {
            LauncherApkDownloadResult.Success result = ((LauncherApkOutcome.Success) launcherApkOutcome).getResult();
            this.host.completeLauncherProgress(result.getTotalBytes());
            this.host.completeLauncherApk(j, true, false, true, null);
            long totalBytes = result.getTotalBytes();
            int attempts = result.getAttempts();
            Log.i(TAG, "Launcher APK ready: bytes=" + totalBytes + ", attempts=" + attempts + ", resumed=" + result.getResumedFromBytes());
        } else if (!(launcherApkOutcome instanceof LauncherApkOutcome.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, str, 2, null);
            LauncherApkOutcome.Failure failure = (LauncherApkOutcome.Failure) launcherApkOutcome;
            this.host.completeLauncherApk(j, false, failure.getClassification().isRemoteFailure(), true, str);
            String label = failure.getClassification().getLabel();
            Log.e(TAG, "Launcher APK download failed: " + label + ", attempts=" + failure.getResult().getAttempts());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCancellation(long j, LauncherUpdatePhase launcherUpdatePhase) {
        int i = WhenMappings.$EnumSwitchMapping$0[launcherUpdatePhase.ordinal()];
        if (i == 1) {
            if (this.host.isCurrentLauncherCheckOperation(j)) {
                failLauncherCheck(j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED);
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
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_CANCELED, null, str, 2, null);
            this.host.completeLauncherApk(j, false, false, true, str);
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
            failLauncherCheck(j, UpdateAnalyticsErrorEvent.LAUNCHER_UPDATE_CHECK_REQUEST_FAILED);
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            String remove = this.apkServers.remove(Long.valueOf(j));
            if (remove == null) {
                remove = this.currentServer.invoke();
            }
            String str = remove;
            UpdateAnalyticsReporter.reportError$default(this.analyticsReporter, UpdateAnalyticsErrorEvent.LAUNCHER_APK_DOWNLOAD_FAILED, null, str, 2, null);
            this.host.completeLauncherApk(j, false, true, true, str);
        }
        Log.e(TAG, "Unexpected launcher " + launcherUpdatePhase + " failure", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCurrentControllerOperation(long j) {
        return this.host.isCurrentLauncherCheckOperation(j) || this.host.isCurrentLauncherApkOperation(j);
    }

    /* compiled from: LauncherUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/LauncherUpdateServiceFlow$Companion;", "", "<init>", "()V", "TAG", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
