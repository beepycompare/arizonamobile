package com.arizona.launcher.updater.archive.download;

import com.arizona.launcher.DownloadFailureClassifier;
import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.DownloadFailureKind;
import com.arizona.launcher.DownloadRetryDecision;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadListener;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.download.ArchiveResumableHttpEngine;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.stats.CodePackage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import okhttp3.OkHttpClient;
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$0#H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0003\u0010\u0000¨\u0006."}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloader;", "", "retryPolicy", "Lcom/arizona/launcher/DownloadRetryPolicy;", "networkMonitor", "Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "networkReconnectTimeoutMs", "", "blockingTaskDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "allowInsecureLoopback", "", "resumeStore", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;", "httpClient", "Lokhttp3/OkHttpClient;", "forceEveryBytes", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Lcom/arizona/launcher/DownloadRetryPolicy;Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;JLkotlinx/coroutines/CoroutineDispatcher;ZLcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;Lokhttp3/OkHttpClient;JLcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "client", "engine", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine;", "download", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "request", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;", "(Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAttempt", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "allowInvalidResumeReset", "progress", "Lkotlin/Function1;", "", "(Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyFailure", "Lcom/arizona/launcher/DownloadFailureDetails;", "attempt", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Failed;", "hasSecurityCause", "cause", "", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageDownloader {
    @Deprecated
    public static final long BUSY_RETRY_DELAY_MS = 500;
    @Deprecated
    public static final long DEFAULT_FORCE_EVERY_BYTES = 262144;
    @Deprecated
    public static final int MAX_BUSY_RETRIES = 3;
    @Deprecated
    public static final int MAX_CAUSE_DEPTH = 8;
    @Deprecated
    public static final long MAX_UNSIGNED_CRC32 = 4294967295L;
    private final boolean allowInsecureLoopback;
    private final CoroutineDispatcher blockingTaskDispatcher;
    private final OkHttpClient client;
    private final ArchiveDirectoryCreator directoryCreator;
    private final ArchiveResumableHttpEngine engine;
    private final ArchiveNetworkMonitor networkMonitor;
    private final long networkReconnectTimeoutMs;
    private final ArchiveDownloadResumeStore resumeStore;
    private final DownloadRetryPolicy retryPolicy;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ArchivePackageDownloader(DownloadRetryPolicy retryPolicy, ArchiveNetworkMonitor networkMonitor, long j, CoroutineDispatcher blockingTaskDispatcher, boolean z, ArchiveDownloadResumeStore resumeStore, OkHttpClient httpClient, long j2, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(blockingTaskDispatcher, "blockingTaskDispatcher");
        Intrinsics.checkNotNullParameter(resumeStore, "resumeStore");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.retryPolicy = retryPolicy;
        this.networkMonitor = networkMonitor;
        this.networkReconnectTimeoutMs = j;
        this.blockingTaskDispatcher = blockingTaskDispatcher;
        this.allowInsecureLoopback = z;
        this.resumeStore = resumeStore;
        this.directoryCreator = directoryCreator;
        OkHttpClient build = httpClient.newBuilder().followRedirects(false).followSslRedirects(false).callTimeout(0L, TimeUnit.MILLISECONDS).dns(new SafeArchiveDns(httpClient.dns(), z)).build();
        this.client = build;
        this.engine = new ArchiveResumableHttpEngine(build, resumeStore, z, j2, 0L, directoryCreator, 16, null);
    }

    public /* synthetic */ ArchivePackageDownloader(DownloadRetryPolicy downloadRetryPolicy, ArchiveNetworkMonitor archiveNetworkMonitor, long j, CoroutineDispatcher coroutineDispatcher, boolean z, ArchiveDownloadResumeStore archiveDownloadResumeStore, OkHttpClient okHttpClient, long j2, ArchiveDirectoryCreator archiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadRetryPolicy, archiveNetworkMonitor, (i & 4) != 0 ? 30000L : j, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i & 16) != 0 ? false : z, (i & 32) != 0 ? new FileArchiveDownloadResumeStore(null, null, 3, null) : archiveDownloadResumeStore, (i & 64) != 0 ? Companion.defaultHttpClient() : okHttpClient, (i & 128) != 0 ? 262144L : j2, (i & 256) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : archiveDirectoryCreator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ec  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14, types: [int] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0307 -> B:107:0x030a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0368 -> B:114:0x036c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0231 -> B:48:0x0191). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x024d -> B:48:0x0191). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object download(ArchiveDownloadRequest archiveDownloadRequest, ArchiveDownloadListener archiveDownloadListener, Continuation<? super ArchivePackageDownloadResult> continuation) {
        ArchivePackageDownloader$download$1 archivePackageDownloader$download$1;
        int i;
        ArchivePackageDownloader$download$1 archivePackageDownloader$download$12;
        final Ref.LongRef longRef;
        int i2;
        int i3;
        int i4;
        int i5;
        final ArchiveDownloadListener archiveDownloadListener2;
        File file;
        final ArchiveDownloadRequest archiveDownloadRequest2;
        boolean z;
        ArchiveDownloadRequest archiveDownloadRequest3;
        DownloadFailureDetails downloadFailureDetails;
        Object obj;
        int i6;
        Object obj2;
        char c;
        ArchiveDownloadListener archiveDownloadListener3;
        ArchiveResumableHttpEngine.AttemptResult attemptResult;
        Object runAttempt;
        ArchivePackageDownloader archivePackageDownloader = this;
        if (continuation instanceof ArchivePackageDownloader$download$1) {
            archivePackageDownloader$download$1 = (ArchivePackageDownloader$download$1) continuation;
            if ((archivePackageDownloader$download$1.label & Integer.MIN_VALUE) != 0) {
                archivePackageDownloader$download$1.label -= Integer.MIN_VALUE;
                Object obj3 = archivePackageDownloader$download$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archivePackageDownloader$download$1.label;
                ?? r8 = 1;
                DownloadFailureDetails downloadFailureDetails2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    if (!StringsKt.isBlank(archiveDownloadRequest.getPackageId()) && !StringsKt.isBlank(archiveDownloadRequest.getUrl()) && archiveDownloadRequest.getExpectedSize() > 0) {
                        long expectedCrc32 = archiveDownloadRequest.getExpectedCrc32();
                        if (0 <= expectedCrc32 && expectedCrc32 < 4294967296L) {
                            File parentFile = archiveDownloadRequest.getDestination().getParentFile();
                            if (parentFile == null) {
                                return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.INVALID_REQUEST, null, 2, null);
                            }
                            try {
                                if ((!parentFile.exists() && !archivePackageDownloader.directoryCreator.createDirectories(parentFile)) || !parentFile.isDirectory()) {
                                    return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.DESTINATION_UNAVAILABLE, null, 2, null);
                                }
                                if (!ArchiveRemoteNetworkPolicy.INSTANCE.isAllowedUrl(archiveDownloadRequest.getUrl(), archivePackageDownloader.allowInsecureLoopback)) {
                                    return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.RETRY_EXHAUSTED, new DownloadFailureDetails(CodePackage.SECURITY, null, null, 6, null));
                                }
                                archivePackageDownloader$download$12 = archivePackageDownloader$download$1;
                                longRef = new Ref.LongRef();
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                i5 = 0;
                                archiveDownloadListener2 = archiveDownloadListener;
                                file = parentFile;
                                archiveDownloadRequest2 = archiveDownloadRequest;
                                JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                                if (i2 == 0) {
                                }
                                Function1<? super Long, Unit> function1 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj4) {
                                        return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj4).longValue());
                                    }
                                };
                                archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                                archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                archivePackageDownloader$download$12.L$3 = longRef;
                                archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                                archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                                archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                                archivePackageDownloader$download$12.I$0 = i3;
                                archivePackageDownloader$download$12.I$1 = i2;
                                archivePackageDownloader$download$12.I$2 = i4;
                                archivePackageDownloader$download$12.I$3 = i5;
                                archivePackageDownloader$download$12.label = r8;
                                runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, r14, function1, archivePackageDownloader$download$12);
                                if (runAttempt != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            } catch (IOException e) {
                                return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.DESTINATION_UNAVAILABLE, ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e) ? new DownloadFailureDetails("STORAGE", null, null, 6, null) : null);
                            }
                        }
                    }
                    return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.INVALID_REQUEST, null, 2, null);
                } else if (i == 1) {
                    int i7 = archivePackageDownloader$download$1.I$3;
                    int i8 = archivePackageDownloader$download$1.I$2;
                    int i9 = archivePackageDownloader$download$1.I$1;
                    int i10 = archivePackageDownloader$download$1.I$0;
                    archiveDownloadRequest3 = (ArchiveDownloadRequest) archivePackageDownloader$download$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    i2 = i9;
                    longRef = (Ref.LongRef) archivePackageDownloader$download$1.L$3;
                    i3 = i10;
                    archiveDownloadListener3 = (ArchiveDownloadListener) archivePackageDownloader$download$1.L$1;
                    i5 = i7;
                    file = (File) archivePackageDownloader$download$1.L$2;
                    i4 = i8;
                    archivePackageDownloader$download$12 = archivePackageDownloader$download$1;
                    attemptResult = (ArchiveResumableHttpEngine.AttemptResult) obj3;
                    if (!Intrinsics.areEqual(attemptResult, ArchiveResumableHttpEngine.AttemptResult.Completed.INSTANCE)) {
                    }
                } else if (i == 2) {
                    int i11 = archivePackageDownloader$download$1.I$3;
                    int i12 = archivePackageDownloader$download$1.I$2;
                    int i13 = archivePackageDownloader$download$1.I$1;
                    int i14 = archivePackageDownloader$download$1.I$0;
                    ArchiveResumableHttpEngine.AttemptResult attemptResult2 = (ArchiveResumableHttpEngine.AttemptResult) archivePackageDownloader$download$1.L$4;
                    archiveDownloadRequest3 = (ArchiveDownloadRequest) archivePackageDownloader$download$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    archivePackageDownloader$download$12 = archivePackageDownloader$download$1;
                    archiveDownloadListener2 = (ArchiveDownloadListener) archivePackageDownloader$download$1.L$1;
                    i5 = i11;
                    file = (File) archivePackageDownloader$download$1.L$2;
                    i4 = i12;
                    i2 = i13;
                    longRef = (Ref.LongRef) archivePackageDownloader$download$1.L$3;
                    i3 = i14;
                    c = 2;
                    archiveDownloadRequest2 = archiveDownloadRequest3;
                    r8 = 1;
                    JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                    if (i2 == 0) {
                    }
                    Function1<? super Long, Unit> function12 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj4).longValue());
                        }
                    };
                    archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                    archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                    archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                    archivePackageDownloader$download$12.L$3 = longRef;
                    archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                    archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                    archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                    archivePackageDownloader$download$12.I$0 = i3;
                    archivePackageDownloader$download$12.I$1 = i2;
                    archivePackageDownloader$download$12.I$2 = i4;
                    archivePackageDownloader$download$12.I$3 = i5;
                    archivePackageDownloader$download$12.label = r8;
                    runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, r14, function12, archivePackageDownloader$download$12);
                    if (runAttempt != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i != 3) {
                    if (i == 4) {
                        int i15 = archivePackageDownloader$download$1.I$3;
                        int i16 = archivePackageDownloader$download$1.I$2;
                        int i17 = archivePackageDownloader$download$1.I$1;
                        int i18 = archivePackageDownloader$download$1.I$0;
                        DownloadRetryDecision downloadRetryDecision = (DownloadRetryDecision) archivePackageDownloader$download$1.L$6;
                        DownloadFailureDetails downloadFailureDetails3 = (DownloadFailureDetails) archivePackageDownloader$download$1.L$5;
                        ArchiveResumableHttpEngine.AttemptResult attemptResult3 = (ArchiveResumableHttpEngine.AttemptResult) archivePackageDownloader$download$1.L$4;
                        ResultKt.throwOnFailure(obj3);
                        Object obj4 = coroutine_suspended;
                        archiveDownloadRequest2 = (ArchiveDownloadRequest) archivePackageDownloader$download$1.L$0;
                        longRef = (Ref.LongRef) archivePackageDownloader$download$1.L$3;
                        archivePackageDownloader$download$12 = archivePackageDownloader$download$1;
                        archiveDownloadListener2 = (ArchiveDownloadListener) archivePackageDownloader$download$1.L$1;
                        i2 = i17;
                        i4 = i16;
                        i3 = i18;
                        i5 = i15;
                        file = (File) archivePackageDownloader$download$1.L$2;
                        z = true;
                        archivePackageDownloader = this;
                        coroutine_suspended = obj4;
                        r8 = z;
                        downloadFailureDetails2 = null;
                        JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                        boolean z2 = i2 == 0 ? r8 : false;
                        Function1<? super Long, Unit> function122 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj42) {
                                return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj42).longValue());
                            }
                        };
                        archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                        archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                        archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                        archivePackageDownloader$download$12.L$3 = longRef;
                        archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                        archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                        archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                        archivePackageDownloader$download$12.I$0 = i3;
                        archivePackageDownloader$download$12.I$1 = i2;
                        archivePackageDownloader$download$12.I$2 = i4;
                        archivePackageDownloader$download$12.I$3 = i5;
                        archivePackageDownloader$download$12.label = r8;
                        runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, z2, function122, archivePackageDownloader$download$12);
                        if (runAttempt != coroutine_suspended) {
                            archiveDownloadRequest3 = archiveDownloadRequest2;
                            archiveDownloadListener3 = archiveDownloadListener2;
                            obj3 = runAttempt;
                            attemptResult = (ArchiveResumableHttpEngine.AttemptResult) obj3;
                            if (!Intrinsics.areEqual(attemptResult, ArchiveResumableHttpEngine.AttemptResult.Completed.INSTANCE)) {
                                archiveDownloadListener3.onProgress(archiveDownloadRequest3.getPackageId(), archiveDownloadRequest3.getExpectedSize(), archiveDownloadRequest3.getExpectedSize());
                                return new ArchivePackageDownloadResult.Success(archiveDownloadRequest3.getDestination(), i3);
                            }
                            archiveDownloadListener2 = archiveDownloadListener3;
                            if (Intrinsics.areEqual(attemptResult, ArchiveResumableHttpEngine.AttemptResult.SameDestinationBusy.INSTANCE)) {
                                if (i4 >= 3) {
                                    return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.SAME_TASK_BUSY_EXHAUSTED, downloadFailureDetails2, 2, downloadFailureDetails2);
                                }
                                int i19 = i4 + 1;
                                archivePackageDownloader$download$12.L$0 = archiveDownloadRequest3;
                                archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                archivePackageDownloader$download$12.L$3 = longRef;
                                archivePackageDownloader$download$12.L$4 = SpillingKt.nullOutSpilledVariable(attemptResult);
                                archivePackageDownloader$download$12.I$0 = i3;
                                archivePackageDownloader$download$12.I$1 = i2;
                                archivePackageDownloader$download$12.I$2 = i19;
                                archivePackageDownloader$download$12.I$3 = i5;
                                c = 2;
                                archivePackageDownloader$download$12.label = 2;
                                if (DelayKt.delay(500L, archivePackageDownloader$download$12) != coroutine_suspended) {
                                    i4 = i19;
                                    archiveDownloadRequest2 = archiveDownloadRequest3;
                                    r8 = 1;
                                    JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                                    if (i2 == 0) {
                                    }
                                    Function1<? super Long, Unit> function1222 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj42) {
                                            return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj42).longValue());
                                        }
                                    };
                                    archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                                    archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                    archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                    archivePackageDownloader$download$12.L$3 = longRef;
                                    archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.I$0 = i3;
                                    archivePackageDownloader$download$12.I$1 = i2;
                                    archivePackageDownloader$download$12.I$2 = i4;
                                    archivePackageDownloader$download$12.I$3 = i5;
                                    archivePackageDownloader$download$12.label = r8;
                                    runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, z2, function1222, archivePackageDownloader$download$12);
                                    if (runAttempt != coroutine_suspended) {
                                    }
                                }
                            } else if (Intrinsics.areEqual(attemptResult, ArchiveResumableHttpEngine.AttemptResult.Canceled.INSTANCE)) {
                                return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.CANCELED, downloadFailureDetails2, 2, downloadFailureDetails2);
                            } else {
                                if (Intrinsics.areEqual(attemptResult, ArchiveResumableHttpEngine.AttemptResult.ResumeReset.INSTANCE)) {
                                    archiveDownloadRequest2 = archiveDownloadRequest3;
                                    i2 = 1;
                                    r8 = 1;
                                    JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                                    if (i2 == 0) {
                                    }
                                    Function1<? super Long, Unit> function12222 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj42) {
                                            return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj42).longValue());
                                        }
                                    };
                                    archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                                    archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                    archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                    archivePackageDownloader$download$12.L$3 = longRef;
                                    archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                                    archivePackageDownloader$download$12.I$0 = i3;
                                    archivePackageDownloader$download$12.I$1 = i2;
                                    archivePackageDownloader$download$12.I$2 = i4;
                                    archivePackageDownloader$download$12.I$3 = i5;
                                    archivePackageDownloader$download$12.label = r8;
                                    runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, z2, function12222, archivePackageDownloader$download$12);
                                    if (runAttempt != coroutine_suspended) {
                                    }
                                } else if (!(attemptResult instanceof ArchiveResumableHttpEngine.AttemptResult.Failed)) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    ArchiveResumableHttpEngine.AttemptResult.Failed failed = (ArchiveResumableHttpEngine.AttemptResult.Failed) attemptResult;
                                    if (failed.getArtifactResetFailed()) {
                                        return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.PARTIAL_RESET_FAILED, archivePackageDownloader.classifyFailure(failed));
                                    }
                                    if (failed.getContentLengthMismatch()) {
                                        return ArchivePackageDownloaderKt.failure$default(ArchivePackageDownloadErrorCode.CONTENT_LENGTH_MISMATCH, downloadFailureDetails2, 2, downloadFailureDetails2);
                                    }
                                    DownloadFailureDetails classifyFailure = archivePackageDownloader.classifyFailure(failed);
                                    DownloadRetryDecision decide = archivePackageDownloader.retryPolicy.decide(classifyFailure.getKind(), i3, archivePackageDownloader.networkMonitor.hasValidatedNetwork(), classifyFailure.getHttpStatus());
                                    if (Intrinsics.areEqual(decide, DownloadRetryDecision.Disabled.INSTANCE) || Intrinsics.areEqual(decide, DownloadRetryDecision.DoNotRetry.INSTANCE)) {
                                        return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.RETRY_EXHAUSTED, classifyFailure);
                                    }
                                    if (!Intrinsics.areEqual(decide, DownloadRetryDecision.WaitForValidatedNetwork.INSTANCE)) {
                                        obj4 = coroutine_suspended;
                                        File file2 = file;
                                        z = true;
                                        if (!(decide instanceof DownloadRetryDecision.Retry)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        DownloadRetryDecision.Retry retry = (DownloadRetryDecision.Retry) decide;
                                        int nextAttempt = retry.getNextAttempt();
                                        archiveDownloadListener2.onRetry(archiveDownloadRequest3.getPackageId(), retry.getNextAttempt(), retry.getAfterMs(), classifyFailure);
                                        long afterMs = retry.getAfterMs();
                                        archivePackageDownloader$download$12.L$0 = archiveDownloadRequest3;
                                        archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                        archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file2);
                                        archivePackageDownloader$download$12.L$3 = longRef;
                                        archivePackageDownloader$download$12.L$4 = SpillingKt.nullOutSpilledVariable(attemptResult);
                                        archivePackageDownloader$download$12.L$5 = SpillingKt.nullOutSpilledVariable(classifyFailure);
                                        archivePackageDownloader$download$12.L$6 = SpillingKt.nullOutSpilledVariable(decide);
                                        archivePackageDownloader$download$12.I$0 = nextAttempt;
                                        archivePackageDownloader$download$12.I$1 = i2;
                                        archivePackageDownloader$download$12.I$2 = i4;
                                        archivePackageDownloader$download$12.I$3 = i5;
                                        archivePackageDownloader$download$12.label = 4;
                                        if (DelayKt.delay(afterMs, archivePackageDownloader$download$12) == obj4) {
                                            return obj4;
                                        }
                                        i3 = nextAttempt;
                                        archiveDownloadRequest2 = archiveDownloadRequest3;
                                        file = file2;
                                        archivePackageDownloader = this;
                                        coroutine_suspended = obj4;
                                        r8 = z;
                                        downloadFailureDetails2 = null;
                                        JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                                        if (i2 == 0) {
                                        }
                                        Function1<? super Long, Unit> function122222 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj42) {
                                                return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj42).longValue());
                                            }
                                        };
                                        archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                                        archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                        archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                        archivePackageDownloader$download$12.L$3 = longRef;
                                        archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                                        archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                                        archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                                        archivePackageDownloader$download$12.I$0 = i3;
                                        archivePackageDownloader$download$12.I$1 = i2;
                                        archivePackageDownloader$download$12.I$2 = i4;
                                        archivePackageDownloader$download$12.I$3 = i5;
                                        archivePackageDownloader$download$12.label = r8;
                                        runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, z2, function122222, archivePackageDownloader$download$12);
                                        if (runAttempt != coroutine_suspended) {
                                        }
                                    } else if (i5 != 0) {
                                        return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.NETWORK_MONITOR_FAILED, classifyFailure);
                                    } else {
                                        archiveDownloadListener2.onWaitingForNetwork(archiveDownloadRequest3.getPackageId(), classifyFailure);
                                        ArchiveNetworkMonitor archiveNetworkMonitor = archivePackageDownloader.networkMonitor;
                                        obj = coroutine_suspended;
                                        File file3 = file;
                                        long j = archivePackageDownloader.networkReconnectTimeoutMs;
                                        archivePackageDownloader$download$12.L$0 = archiveDownloadRequest3;
                                        archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                        archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file3);
                                        archivePackageDownloader$download$12.L$3 = longRef;
                                        archivePackageDownloader$download$12.L$4 = SpillingKt.nullOutSpilledVariable(attemptResult);
                                        archivePackageDownloader$download$12.L$5 = classifyFailure;
                                        archivePackageDownloader$download$12.L$6 = SpillingKt.nullOutSpilledVariable(decide);
                                        archivePackageDownloader$download$12.I$0 = i3;
                                        archivePackageDownloader$download$12.I$1 = i2;
                                        archivePackageDownloader$download$12.I$2 = i4;
                                        z = true;
                                        archivePackageDownloader$download$12.I$3 = 1;
                                        archivePackageDownloader$download$12.label = 3;
                                        obj2 = ArchiveNetworkMonitorKt.awaitValidatedNetworkWithin(archiveNetworkMonitor, j, archivePackageDownloader$download$12);
                                        if (obj2 == obj) {
                                            return obj;
                                        }
                                        int i20 = i4;
                                        downloadFailureDetails = classifyFailure;
                                        i6 = i20;
                                        file = file3;
                                        i5 = 1;
                                        if (!((Boolean) obj2).booleanValue()) {
                                            i4 = i6;
                                            coroutine_suspended = obj;
                                            archiveDownloadRequest2 = archiveDownloadRequest3;
                                            r8 = z;
                                            downloadFailureDetails2 = null;
                                            JobKt.ensureActive(archivePackageDownloader$download$12.getContext());
                                            if (i2 == 0) {
                                            }
                                            Function1<? super Long, Unit> function1222222 = new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj42) {
                                                    return ArchivePackageDownloader.download$lambda$0(Ref.LongRef.this, archiveDownloadListener2, archiveDownloadRequest2, ((Long) obj42).longValue());
                                                }
                                            };
                                            archivePackageDownloader$download$12.L$0 = archiveDownloadRequest2;
                                            archivePackageDownloader$download$12.L$1 = archiveDownloadListener2;
                                            archivePackageDownloader$download$12.L$2 = SpillingKt.nullOutSpilledVariable(file);
                                            archivePackageDownloader$download$12.L$3 = longRef;
                                            archivePackageDownloader$download$12.L$4 = downloadFailureDetails2;
                                            archivePackageDownloader$download$12.L$5 = downloadFailureDetails2;
                                            archivePackageDownloader$download$12.L$6 = downloadFailureDetails2;
                                            archivePackageDownloader$download$12.I$0 = i3;
                                            archivePackageDownloader$download$12.I$1 = i2;
                                            archivePackageDownloader$download$12.I$2 = i4;
                                            archivePackageDownloader$download$12.I$3 = i5;
                                            archivePackageDownloader$download$12.label = r8;
                                            runAttempt = archivePackageDownloader.runAttempt(archiveDownloadRequest2, z2, function1222222, archivePackageDownloader$download$12);
                                            if (runAttempt != coroutine_suspended) {
                                            }
                                        } else {
                                            return ArchivePackageDownloaderKt.access$failure(ArchivePackageDownloadErrorCode.NETWORK_MONITOR_FAILED, downloadFailureDetails);
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i21 = archivePackageDownloader$download$1.I$3;
                    int i22 = archivePackageDownloader$download$1.I$2;
                    i2 = archivePackageDownloader$download$1.I$1;
                    i3 = archivePackageDownloader$download$1.I$0;
                    DownloadRetryDecision downloadRetryDecision2 = (DownloadRetryDecision) archivePackageDownloader$download$1.L$6;
                    downloadFailureDetails = (DownloadFailureDetails) archivePackageDownloader$download$1.L$5;
                    ArchiveResumableHttpEngine.AttemptResult attemptResult4 = (ArchiveResumableHttpEngine.AttemptResult) archivePackageDownloader$download$1.L$4;
                    Ref.LongRef longRef2 = (Ref.LongRef) archivePackageDownloader$download$1.L$3;
                    ResultKt.throwOnFailure(obj3);
                    archivePackageDownloader$download$12 = archivePackageDownloader$download$1;
                    archiveDownloadListener2 = (ArchiveDownloadListener) archivePackageDownloader$download$1.L$1;
                    z = true;
                    i6 = i22;
                    i5 = i21;
                    file = (File) archivePackageDownloader$download$1.L$2;
                    archiveDownloadRequest3 = (ArchiveDownloadRequest) archivePackageDownloader$download$1.L$0;
                    longRef = longRef2;
                    obj = coroutine_suspended;
                    obj2 = obj3;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                }
            }
        }
        archivePackageDownloader$download$1 = new ArchivePackageDownloader$download$1(archivePackageDownloader, continuation);
        Object obj32 = archivePackageDownloader$download$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archivePackageDownloader$download$1.label;
        ?? r82 = 1;
        DownloadFailureDetails downloadFailureDetails22 = null;
        if (i != 0) {
        }
    }

    public static /* synthetic */ Object download$default(ArchivePackageDownloader archivePackageDownloader, ArchiveDownloadRequest archiveDownloadRequest, ArchiveDownloadListener archiveDownloadListener, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            archiveDownloadListener = ArchiveDownloadListener.None.INSTANCE;
        }
        return archivePackageDownloader.download(archiveDownloadRequest, archiveDownloadListener, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit download$lambda$0(Ref.LongRef longRef, ArchiveDownloadListener archiveDownloadListener, ArchiveDownloadRequest archiveDownloadRequest, long j) {
        longRef.element = Math.max(longRef.element, j);
        archiveDownloadListener.onProgress(archiveDownloadRequest.getPackageId(), RangesKt.coerceAtMost(longRef.element, archiveDownloadRequest.getExpectedSize()), archiveDownloadRequest.getExpectedSize());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAttempt(final ArchiveDownloadRequest archiveDownloadRequest, final boolean z, final Function1<? super Long, Unit> function1, Continuation<? super ArchiveResumableHttpEngine.AttemptResult> continuation) {
        final ArchiveOwnedDownloadSession archiveOwnedDownloadSession = new ArchiveOwnedDownloadSession();
        return ArchivePackageDownloaderKt.runDrainedOwnedBlockingTask(this.blockingTaskDispatcher, new Function1() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchivePackageDownloader.runAttempt$lambda$0(ArchivePackageDownloader.this, archiveDownloadRequest, archiveOwnedDownloadSession, z, function1, (Function0) obj);
            }
        }, new Function0() { // from class: com.arizona.launcher.updater.archive.download.ArchivePackageDownloader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchivePackageDownloader.runAttempt$lambda$1(ArchiveOwnedDownloadSession.this);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ArchiveResumableHttpEngine.AttemptResult runAttempt$lambda$0(ArchivePackageDownloader archivePackageDownloader, ArchiveDownloadRequest archiveDownloadRequest, ArchiveOwnedDownloadSession archiveOwnedDownloadSession, boolean z, Function1 function1, Function0 ensureActiveAtTaskStart) {
        Intrinsics.checkNotNullParameter(ensureActiveAtTaskStart, "ensureActiveAtTaskStart");
        return archivePackageDownloader.engine.executeAttempt(archiveDownloadRequest, archiveOwnedDownloadSession, z, ensureActiveAtTaskStart, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit runAttempt$lambda$1(ArchiveOwnedDownloadSession archiveOwnedDownloadSession) {
        archiveOwnedDownloadSession.cancel();
        return Unit.INSTANCE;
    }

    private final DownloadFailureDetails classifyFailure(ArchiveResumableHttpEngine.AttemptResult.Failed failed) {
        if (failed.getStorageFailure()) {
            return new DownloadFailureDetails("STORAGE", null, null, 6, null);
        }
        if (hasSecurityCause(failed.getCause())) {
            return new DownloadFailureDetails(CodePackage.SECURITY, null, null, 6, null);
        }
        Integer httpStatus = failed.getHttpStatus();
        if (httpStatus == null) {
            Exception cause = failed.getCause();
            ArchiveHttpResponseException archiveHttpResponseException = cause instanceof ArchiveHttpResponseException ? (ArchiveHttpResponseException) cause : null;
            httpStatus = archiveHttpResponseException != null ? Integer.valueOf(archiveHttpResponseException.getCode()) : null;
        }
        if (httpStatus != null) {
            return new DownloadFailureDetails("HTTP_" + httpStatus, httpStatus, DownloadFailureKind.HTTP);
        }
        return DownloadFailureClassifier.INSTANCE.classify(failed.getCause());
    }

    private final boolean hasSecurityCause(Throwable th) {
        for (int i = 0; i < 8 && th != null; i++) {
            if ((th instanceof ArchiveSecurityException) || (th instanceof ArchiveUnsafeHostException)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageDownloader.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloader$Companion;", "", "<init>", "()V", "MAX_BUSY_RETRIES", "", "BUSY_RETRY_DELAY_MS", "", "MAX_UNSIGNED_CRC32", "DEFAULT_FORCE_EVERY_BYTES", "MAX_CAUSE_DEPTH", "defaultHttpClient", "Lokhttp3/OkHttpClient;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpClient defaultHttpClient() {
            return new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
        }
    }
}
