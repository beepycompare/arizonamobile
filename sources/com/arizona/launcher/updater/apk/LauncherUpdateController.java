package com.arizona.launcher.updater.apk;

import com.arizona.launcher.updater.apk.LauncherApkPreparation;
import com.arizona.launcher.updater.apk.LauncherUpdateController;
import com.arizona.launcher.updater.http.UpdateMetadataFetcher;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import com.google.android.vending.expansion.downloader.Constants;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 :2\u00020\u0001:\u00029:B\u0083\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017BE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u001cB\u008b\u0001\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u0016\u0010\u001fJ\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0006J\u0018\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,J\u0016\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0013J\u0018\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0012H\u0002J\u001f\u00104\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e06H\u0082\bJ'\u00107\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e06H\u0082\bJ\u0017\u00108\u001a\u00020\u001e2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e06H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R2\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b<\u0012\b\b=\u0012\u0004\b\u0003\u0010\u0000¨\u0006;"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateController;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "metadataRequest", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "apkDownload", "Lkotlin/Function3;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "config", "Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;", "isCurrent", "Lkotlin/Function1;", "", "", "callbacks", "Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;)V", "metadataFetcher", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "launcherApkDownloader", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;)V", "testSeam", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lcom/arizona/launcher/updater/apk/LauncherUpdateConfig;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/apk/LauncherUpdateControllerCallbacks;Lkotlin/Unit;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "apkJobLock", "activeApkDownload", "Lcom/arizona/launcher/updater/apk/LauncherUpdateController$ActiveApkDownload;", "checkLauncherUpdate", "Lkotlinx/coroutines/Job;", "token", "server", "prepareLauncherApkDownload", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation;", "externalFilesRoot", "Ljava/io/File;", "startLauncherApkDownload", "preparation", "Lcom/arizona/launcher/updater/apk/LauncherApkPreparation$Ready;", "cancelLauncherApkDownload", "isLauncherApkDownloadActive", "apkObserver", "owner", "dispatchIfCurrent", "callback", "Lkotlin/Function0;", "dispatchApkIfCurrent", "ignoreCallbackFailure", "ActiveApkDownload", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdateController {
    @Deprecated
    public static final String APK_DIRECTORY = "launcher_new/";
    @Deprecated
    public static final String METADATA_FILE_NAME = "app_version.json";
    private ActiveApkDownload activeApkDownload;
    private final Function3<LauncherApkDownloadRequest, LauncherApkDownloadObserver, Continuation<? super LauncherApkDownloadResult>, Object> apkDownload;
    private final Object apkJobLock;
    private final LauncherUpdateControllerCallbacks callbacks;
    private final LauncherUpdateConfig config;
    private final Function1<Long, Boolean> isCurrent;
    private final Function2<String, Continuation<? super UpdateMetadataHttpResult>, Object> metadataRequest;
    private final CoroutineScope scope;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    private LauncherUpdateController(CoroutineScope coroutineScope, Function2<? super String, ? super Continuation<? super UpdateMetadataHttpResult>, ? extends Object> function2, Function3<? super LauncherApkDownloadRequest, ? super LauncherApkDownloadObserver, ? super Continuation<? super LauncherApkDownloadResult>, ? extends Object> function3, LauncherUpdateConfig launcherUpdateConfig, Function1<? super Long, Boolean> function1, LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks) {
        this.scope = coroutineScope;
        this.metadataRequest = function2;
        this.apkDownload = function3;
        this.config = launcherUpdateConfig;
        this.isCurrent = function1;
        this.callbacks = launcherUpdateControllerCallbacks;
        this.apkJobLock = new Object();
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.apk.LauncherUpdateController$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<String, Continuation<? super UpdateMetadataHttpResult>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, UpdateMetadataFetcher.class, "get", "get(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super UpdateMetadataHttpResult> continuation) {
            return ((UpdateMetadataFetcher) this.receiver).get(str, continuation);
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.apk.LauncherUpdateController$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<LauncherApkDownloadRequest, LauncherApkDownloadObserver, Continuation<? super LauncherApkDownloadResult>, Object>, SuspendFunction {
        AnonymousClass2(Object obj) {
            super(3, obj, LauncherApkDownloader.class, "download", "download(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(LauncherApkDownloadRequest launcherApkDownloadRequest, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super LauncherApkDownloadResult> continuation) {
            return ((LauncherApkDownloader) this.receiver).download(launcherApkDownloadRequest, launcherApkDownloadObserver, continuation);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateController(CoroutineScope scope, UpdateMetadataFetcher metadataFetcher, LauncherApkDownloader launcherApkDownloader, LauncherUpdateConfig config, Function1<? super Long, Boolean> isCurrent, LauncherUpdateControllerCallbacks callbacks) {
        this(scope, new AnonymousClass1(metadataFetcher), new AnonymousClass2(launcherApkDownloader), config, isCurrent, callbacks);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(metadataFetcher, "metadataFetcher");
        Intrinsics.checkNotNullParameter(launcherApkDownloader, "launcherApkDownloader");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(isCurrent, "isCurrent");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LauncherUpdateController(CoroutineScope scope, Function2<? super String, ? super Continuation<? super UpdateMetadataHttpResult>, ? extends Object> metadataRequest, Function3<? super LauncherApkDownloadRequest, ? super LauncherApkDownloadObserver, ? super Continuation<? super LauncherApkDownloadResult>, ? extends Object> apkDownload, LauncherUpdateConfig config, Function1<? super Long, Boolean> isCurrent, LauncherUpdateControllerCallbacks callbacks, Unit testSeam) {
        this(scope, metadataRequest, apkDownload, config, isCurrent, callbacks);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(metadataRequest, "metadataRequest");
        Intrinsics.checkNotNullParameter(apkDownload, "apkDownload");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(isCurrent, "isCurrent");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(testSeam, "testSeam");
    }

    public final Job checkLauncherUpdate(long j, String server) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(server, "server");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LauncherUpdateController$checkLauncherUpdate$1(server, this, j, null), 3, null);
        return launch$default;
    }

    public final LauncherApkPreparation prepareLauncherApkDownload(String server, File file) {
        Intrinsics.checkNotNullParameter(server, "server");
        if (StringsKt.isBlank(server)) {
            return LauncherApkPreparation.ServerEmpty.INSTANCE;
        }
        if (file == null) {
            return LauncherApkPreparation.ExternalStorageUnavailable.INSTANCE;
        }
        String str = "app-" + this.config.getFlavor() + Constants.FILENAME_SEQUENCE_SEPARATOR + this.config.getBuildType() + ".apk";
        return new LauncherApkPreparation.Ready(new LauncherApkDownloadRequest(server + APK_DIRECTORY + str, new File(file, str), null, null, 12, null));
    }

    public final Job startLauncherApkDownload(long j, LauncherApkPreparation.Ready preparation) {
        Job launch$default;
        ActiveApkDownload activeApkDownload;
        Job job;
        Intrinsics.checkNotNullParameter(preparation, "preparation");
        final Object obj = new Object();
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, CoroutineStart.LAZY, new LauncherUpdateController$startLauncherApkDownload$job$1(this, preparation, obj, j, null), 1, null);
        synchronized (this.apkJobLock) {
            activeApkDownload = this.activeApkDownload;
            this.activeApkDownload = new ActiveApkDownload(obj, launch$default);
        }
        if (activeApkDownload != null && (job = activeApkDownload.getJob()) != null) {
            job.cancel(new CancellationException("Superseded by a newer launcher APK download"));
        }
        launch$default.invokeOnCompletion(new Function1() { // from class: com.arizona.launcher.updater.apk.LauncherUpdateController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return LauncherUpdateController.startLauncherApkDownload$lambda$1(LauncherUpdateController.this, obj, (Throwable) obj2);
            }
        });
        launch$default.start();
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit startLauncherApkDownload$lambda$1(LauncherUpdateController launcherUpdateController, Object obj, Throwable th) {
        synchronized (launcherUpdateController.apkJobLock) {
            ActiveApkDownload activeApkDownload = launcherUpdateController.activeApkDownload;
            if ((activeApkDownload != null ? activeApkDownload.getOwner() : null) == obj) {
                launcherUpdateController.activeApkDownload = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final boolean cancelLauncherApkDownload() {
        Job job;
        synchronized (this.apkJobLock) {
            ActiveApkDownload activeApkDownload = this.activeApkDownload;
            job = activeApkDownload != null ? activeApkDownload.getJob() : null;
        }
        if (job == null) {
            return false;
        }
        job.cancel(new CancellationException("Launcher APK download cancelled by owner"));
        return true;
    }

    public final boolean isLauncherApkDownloadActive() {
        boolean z;
        Job job;
        synchronized (this.apkJobLock) {
            ActiveApkDownload activeApkDownload = this.activeApkDownload;
            z = false;
            if (activeApkDownload != null && (job = activeApkDownload.getJob()) != null) {
                if (job.isActive()) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LauncherApkDownloadObserver apkObserver(final Object obj, final long j) {
        return new LauncherApkDownloadObserver() { // from class: com.arizona.launcher.updater.apk.LauncherUpdateController$apkObserver$1
            @Override // com.arizona.launcher.updater.apk.LauncherApkDownloadObserver
            public void onProgress(LauncherApkProgress progress) {
                boolean z;
                LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks;
                Intrinsics.checkNotNullParameter(progress, "progress");
                LauncherUpdateController launcherUpdateController = LauncherUpdateController.this;
                Object obj2 = obj;
                long j2 = j;
                synchronized (launcherUpdateController.apkJobLock) {
                    LauncherUpdateController.ActiveApkDownload activeApkDownload = launcherUpdateController.activeApkDownload;
                    z = (activeApkDownload != null ? activeApkDownload.getOwner() : null) == obj2;
                }
                if (z && ((Boolean) launcherUpdateController.isCurrent.invoke(Long.valueOf(j2))).booleanValue()) {
                    try {
                        launcherUpdateControllerCallbacks = launcherUpdateController.callbacks;
                        launcherUpdateControllerCallbacks.onApkProgress(j2, progress);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.arizona.launcher.updater.apk.LauncherApkDownloadObserver
            public void onRetry(LauncherApkRetry retry) {
                boolean z;
                LauncherUpdateControllerCallbacks launcherUpdateControllerCallbacks;
                Intrinsics.checkNotNullParameter(retry, "retry");
                LauncherUpdateController launcherUpdateController = LauncherUpdateController.this;
                Object obj2 = obj;
                long j2 = j;
                synchronized (launcherUpdateController.apkJobLock) {
                    LauncherUpdateController.ActiveApkDownload activeApkDownload = launcherUpdateController.activeApkDownload;
                    z = (activeApkDownload != null ? activeApkDownload.getOwner() : null) == obj2;
                }
                if (z && ((Boolean) launcherUpdateController.isCurrent.invoke(Long.valueOf(j2))).booleanValue()) {
                    try {
                        launcherUpdateControllerCallbacks = launcherUpdateController.callbacks;
                        launcherUpdateControllerCallbacks.onApkRetry(j2, retry);
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    private final void dispatchIfCurrent(long j, Function0<Unit> function0) {
        if (((Boolean) this.isCurrent.invoke(Long.valueOf(j))).booleanValue()) {
            try {
                function0.invoke();
            } catch (Exception unused) {
            }
        }
    }

    private final void dispatchApkIfCurrent(Object obj, long j, Function0<Unit> function0) {
        Boolean valueOf;
        synchronized (this.apkJobLock) {
            ActiveApkDownload activeApkDownload = this.activeApkDownload;
            valueOf = Boolean.valueOf((activeApkDownload != null ? activeApkDownload.getOwner() : null) == obj);
        }
        if (valueOf.booleanValue() && ((Boolean) this.isCurrent.invoke(Long.valueOf(j))).booleanValue()) {
            try {
                function0.invoke();
            } catch (Exception unused) {
            }
        }
    }

    private final void ignoreCallbackFailure(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateController$ActiveApkDownload;", "", "owner", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/Job;)V", "getOwner", "()Ljava/lang/Object;", "getJob", "()Lkotlinx/coroutines/Job;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ActiveApkDownload {
        private final Job job;
        private final Object owner;

        public static /* synthetic */ ActiveApkDownload copy$default(ActiveApkDownload activeApkDownload, Object obj, Job job, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = activeApkDownload.owner;
            }
            if ((i & 2) != 0) {
                job = activeApkDownload.job;
            }
            return activeApkDownload.copy(obj, job);
        }

        public final Object component1() {
            return this.owner;
        }

        public final Job component2() {
            return this.job;
        }

        public final ActiveApkDownload copy(Object owner, Job job) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(job, "job");
            return new ActiveApkDownload(owner, job);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActiveApkDownload) {
                ActiveApkDownload activeApkDownload = (ActiveApkDownload) obj;
                return Intrinsics.areEqual(this.owner, activeApkDownload.owner) && Intrinsics.areEqual(this.job, activeApkDownload.job);
            }
            return false;
        }

        public int hashCode() {
            return (this.owner.hashCode() * 31) + this.job.hashCode();
        }

        public String toString() {
            Object obj = this.owner;
            return "ActiveApkDownload(owner=" + obj + ", job=" + this.job + ")";
        }

        public ActiveApkDownload(Object owner, Job job) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(job, "job");
            this.owner = owner;
            this.job = job;
        }

        public final Object getOwner() {
            return this.owner;
        }

        public final Job getJob() {
            return this.job;
        }
    }

    /* compiled from: LauncherUpdateController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdateController$Companion;", "", "<init>", "()V", "METADATA_FILE_NAME", "", "APK_DIRECTORY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
