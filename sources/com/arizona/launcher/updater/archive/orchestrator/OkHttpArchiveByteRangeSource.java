package com.arizona.launcher.updater.archive.orchestrator;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.DownloadFailureClassifier;
import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.DownloadFailureKind;
import com.arizona.launcher.DownloadRetryDecision;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitor;
import com.arizona.launcher.updater.archive.download.ArchiveRemoteNetworkPolicy;
import com.arizona.launcher.updater.archive.download.SafeArchiveDns;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0003*+,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u001b0\u001fH\u0082@¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0000¨\u0006-"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "retryPolicy", "Lcom/arizona/launcher/DownloadRetryPolicy;", "networkMonitor", "Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "retryListener", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "client", "Lokhttp3/OkHttpClient;", "allowInsecureLoopback", "", "<init>", "(Lcom/arizona/launcher/DownloadRetryPolicy;Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;Lokhttp3/OkHttpClient;Z)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "request", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOnce", "expectedBodyBytes", "", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validatePartialResponse", "response", "Lokhttp3/Response;", "executeCancellable", ExifInterface.GPS_DIRECTION_TRUE, NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "consume", "Lkotlin/Function1;", "(Lokhttp3/Call;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readExactly", "", "input", "Ljava/io/InputStream;", "expectedBytes", "parseContentRange", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ParsedContentRange;", "raw", "", "ArchiveHttpHop", "ParsedContentRange", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OkHttpArchiveByteRangeSource implements ArchiveByteRangeSource {
    @Deprecated
    public static final long CALL_TIMEOUT_SECONDS = 120;
    @Deprecated
    public static final int HTTP_PARTIAL_CONTENT = 206;
    @Deprecated
    public static final long MAX_RANGE_BODY_BYTES = 67108864;
    @Deprecated
    public static final int MAX_REDIRECT_HOPS = 5;
    private final boolean allowInsecureLoopback;
    private final OkHttpClient client;
    private final ArchiveNetworkMonitor networkMonitor;
    private final ArchiveRangeRetryListener retryListener;
    private final DownloadRetryPolicy retryPolicy;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<Integer> REDIRECT_HTTP_STATUSES = SetsKt.setOf((Object[]) new Integer[]{300, 301, 302, 303, 307, 308});
    private static final Regex CONTENT_RANGE = new Regex("bytes ([0-9]+)-([0-9]+)/([0-9]+)");

    public OkHttpArchiveByteRangeSource(DownloadRetryPolicy retryPolicy, ArchiveNetworkMonitor networkMonitor, ArchiveRangeRetryListener retryListener, OkHttpClient client, boolean z) {
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        Intrinsics.checkNotNullParameter(client, "client");
        this.retryPolicy = retryPolicy;
        this.networkMonitor = networkMonitor;
        this.retryListener = retryListener;
        this.allowInsecureLoopback = z;
        this.client = client.newBuilder().followRedirects(false).followSslRedirects(false).callTimeout(120L, TimeUnit.SECONDS).dns(new SafeArchiveDns(client.dns(), z)).build();
    }

    public /* synthetic */ OkHttpArchiveByteRangeSource(DownloadRetryPolicy downloadRetryPolicy, ArchiveNetworkMonitor archiveNetworkMonitor, ArchiveRangeRetryListener.None none, OkHttpClient okHttpClient, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadRetryPolicy, archiveNetworkMonitor, (i & 4) != 0 ? ArchiveRangeRetryListener.None.INSTANCE : none, (i & 8) != 0 ? new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build() : okHttpClient, (i & 16) != 0 ? false : z);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:12|13|14|15|16|(5:18|19|20|(2:22|(2:26|(2:28|(2:30|(6:32|13|14|15|16|(0))))(2:33|34)))|36)|62) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01df, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e0, code lost:
        r11 = r2;
        r2 = r4;
        r4 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01ca -> B:61:0x01ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0239 -> B:61:0x01ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x029d -> B:40:0x0101). Please submit an issue!!! */
    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(ArchiveByteRangeRequest archiveByteRangeRequest, Continuation<? super ArchiveByteRangeResult> continuation) {
        OkHttpArchiveByteRangeSource$fetch$1 okHttpArchiveByteRangeSource$fetch$1;
        int i;
        OkHttpArchiveByteRangeSource$fetch$1 okHttpArchiveByteRangeSource$fetch$12;
        long j;
        ArchiveByteRangeRequest archiveByteRangeRequest2;
        int i2;
        char c;
        OkHttpArchiveByteRangeSource$fetch$1 okHttpArchiveByteRangeSource$fetch$13;
        DownloadFailureDetails downloadFailureDetails;
        ArchiveByteRangeRequest archiveByteRangeRequest3;
        long j2;
        int i3;
        ArchiveByteRangeResult archiveByteRangeResult;
        if (continuation instanceof OkHttpArchiveByteRangeSource$fetch$1) {
            okHttpArchiveByteRangeSource$fetch$1 = (OkHttpArchiveByteRangeSource$fetch$1) continuation;
            if ((okHttpArchiveByteRangeSource$fetch$1.label & Integer.MIN_VALUE) != 0) {
                okHttpArchiveByteRangeSource$fetch$1.label -= Integer.MIN_VALUE;
                Object obj = okHttpArchiveByteRangeSource$fetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okHttpArchiveByteRangeSource$fetch$1.label;
                int i4 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long endInclusive = (archiveByteRangeRequest.getEndInclusive() - archiveByteRangeRequest.getStartInclusive()) + 1;
                    if (StringsKt.isBlank(archiveByteRangeRequest.getPackageId()) || archiveByteRangeRequest.getExpectedArchiveSize() <= 0 || archiveByteRangeRequest.getStartInclusive() < 0 || archiveByteRangeRequest.getEndInclusive() < archiveByteRangeRequest.getStartInclusive() || archiveByteRangeRequest.getEndInclusive() >= archiveByteRangeRequest.getExpectedArchiveSize() || endInclusive <= 0 || endInclusive > MAX_RANGE_BODY_BYTES) {
                        return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.INVALID_REQUEST, null, null, 6, null);
                    }
                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$1;
                    j = endInclusive;
                    archiveByteRangeRequest2 = archiveByteRangeRequest;
                    i2 = 0;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                    int i5 = (int) j;
                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                    obj = executeOnce(archiveByteRangeRequest2, i5, okHttpArchiveByteRangeSource$fetch$12);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    i3 = okHttpArchiveByteRangeSource$fetch$1.I$0;
                    j2 = okHttpArchiveByteRangeSource$fetch$1.J$0;
                    archiveByteRangeRequest3 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetch$1.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (IOException e) {
                            IOException e2 = e;
                            downloadFailureDetails = DownloadFailureClassifier.INSTANCE.classify(e2);
                            DownloadRetryDecision decide = this.retryPolicy.decide(downloadFailureDetails.getKind(), i3, this.networkMonitor.hasValidatedNetwork(), downloadFailureDetails.getHttpStatus());
                            if (!Intrinsics.areEqual(decide, DownloadRetryDecision.WaitForValidatedNetwork.INSTANCE)) {
                                ArchiveNetworkMonitor archiveNetworkMonitor = this.networkMonitor;
                                okHttpArchiveByteRangeSource$fetch$1.L$0 = archiveByteRangeRequest3;
                                okHttpArchiveByteRangeSource$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                                okHttpArchiveByteRangeSource$fetch$1.L$2 = downloadFailureDetails;
                                okHttpArchiveByteRangeSource$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(decide);
                                okHttpArchiveByteRangeSource$fetch$1.J$0 = j2;
                                okHttpArchiveByteRangeSource$fetch$1.I$0 = i3;
                                okHttpArchiveByteRangeSource$fetch$1.label = 2;
                                obj = archiveNetworkMonitor.awaitValidatedNetwork(okHttpArchiveByteRangeSource$fetch$1);
                                if (obj != coroutine_suspended) {
                                    int i6 = i3;
                                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$1;
                                    archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                    j = j2;
                                    i2 = i6;
                                    if (!((Boolean) obj).booleanValue()) {
                                    }
                                    i4 = 1;
                                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                                    int i52 = (int) j;
                                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                                    obj = executeOnce(archiveByteRangeRequest2, i52, okHttpArchiveByteRangeSource$fetch$12);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            } else if (decide instanceof DownloadRetryDecision.Retry) {
                                DownloadRetryDecision.Retry retry = (DownloadRetryDecision.Retry) decide;
                                int nextAttempt = retry.getNextAttempt();
                                this.retryListener.onRetry(archiveByteRangeRequest3.getPackageId(), retry.getNextAttempt(), retry.getAfterMs(), downloadFailureDetails);
                                long afterMs = retry.getAfterMs();
                                okHttpArchiveByteRangeSource$fetch$1.L$0 = archiveByteRangeRequest3;
                                okHttpArchiveByteRangeSource$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(e2);
                                okHttpArchiveByteRangeSource$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(downloadFailureDetails);
                                okHttpArchiveByteRangeSource$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(decide);
                                okHttpArchiveByteRangeSource$fetch$1.J$0 = j2;
                                okHttpArchiveByteRangeSource$fetch$1.I$0 = nextAttempt;
                                c = 3;
                                okHttpArchiveByteRangeSource$fetch$1.label = 3;
                                if (DelayKt.delay(afterMs, okHttpArchiveByteRangeSource$fetch$1) != coroutine_suspended) {
                                    okHttpArchiveByteRangeSource$fetch$13 = okHttpArchiveByteRangeSource$fetch$1;
                                    archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                    j = j2;
                                    i2 = nextAttempt;
                                    i4 = 1;
                                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$13;
                                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                                    int i522 = (int) j;
                                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                                    obj = executeOnce(archiveByteRangeRequest2, i522, okHttpArchiveByteRangeSource$fetch$12);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            } else if (!Intrinsics.areEqual(decide, DownloadRetryDecision.Disabled.INSTANCE) && !Intrinsics.areEqual(decide, DownloadRetryDecision.DoNotRetry.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.NETWORK_FAILED, null, downloadFailureDetails.getSubtypeSuffix(), 2, null);
                            }
                            return coroutine_suspended;
                        }
                        archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure) {
                        }
                        return archiveByteRangeResult;
                    } catch (CancellationException e3) {
                        throw e3;
                    }
                } else if (i == 2) {
                    int i7 = okHttpArchiveByteRangeSource$fetch$1.I$0;
                    long j3 = okHttpArchiveByteRangeSource$fetch$1.J$0;
                    DownloadRetryDecision downloadRetryDecision = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetch$1.L$3;
                    IOException iOException = (IOException) okHttpArchiveByteRangeSource$fetch$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    downloadFailureDetails = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetch$1.L$2;
                    j = j3;
                    i2 = i7;
                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$1;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetch$1.L$0;
                    if (!((Boolean) obj).booleanValue()) {
                        return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.NETWORK_FAILED, null, downloadFailureDetails.getSubtypeSuffix(), 2, null);
                    }
                    i4 = 1;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                    int i5222 = (int) j;
                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                    obj = executeOnce(archiveByteRangeRequest2, i5222, okHttpArchiveByteRangeSource$fetch$12);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 3) {
                    int i8 = okHttpArchiveByteRangeSource$fetch$1.I$0;
                    long j4 = okHttpArchiveByteRangeSource$fetch$1.J$0;
                    DownloadRetryDecision downloadRetryDecision2 = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetch$1.L$3;
                    DownloadFailureDetails downloadFailureDetails2 = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetch$1.L$2;
                    IOException iOException2 = (IOException) okHttpArchiveByteRangeSource$fetch$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    okHttpArchiveByteRangeSource$fetch$13 = okHttpArchiveByteRangeSource$fetch$1;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetch$1.L$0;
                    j = j4;
                    i2 = i8;
                    c = 3;
                    i4 = 1;
                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$13;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                    int i52222 = (int) j;
                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                    obj = executeOnce(archiveByteRangeRequest2, i52222, okHttpArchiveByteRangeSource$fetch$12);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 4) {
                    int i9 = okHttpArchiveByteRangeSource$fetch$1.I$1;
                    int i10 = okHttpArchiveByteRangeSource$fetch$1.I$0;
                    long j5 = okHttpArchiveByteRangeSource$fetch$1.J$0;
                    DownloadRetryDecision downloadRetryDecision3 = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetch$1.L$3;
                    DownloadFailureDetails downloadFailureDetails3 = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetch$1.L$2;
                    ArchiveByteRangeResult archiveByteRangeResult2 = (ArchiveByteRangeResult) okHttpArchiveByteRangeSource$fetch$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$1;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetch$1.L$0;
                    j = j5;
                    i2 = i10;
                    i4 = 1;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                    int i522222 = (int) j;
                    okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                    okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                    okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                    okHttpArchiveByteRangeSource$fetch$12.label = i4;
                    obj = executeOnce(archiveByteRangeRequest2, i522222, okHttpArchiveByteRangeSource$fetch$12);
                    if (obj != coroutine_suspended) {
                        archiveByteRangeRequest3 = archiveByteRangeRequest2;
                        okHttpArchiveByteRangeSource$fetch$1 = okHttpArchiveByteRangeSource$fetch$12;
                        i3 = i2;
                        j2 = j;
                        archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure) {
                            ArchiveByteRangeResult.Failure failure = (ArchiveByteRangeResult.Failure) archiveByteRangeResult;
                            if (failure.getCode() == ArchiveByteRangeErrorCode.HTTP_STATUS && CollectionsKt.contains(DownloadRetryPolicy.Companion.getRETRYABLE_HTTP_STATUSES(), failure.getHttpStatus())) {
                                Integer httpStatus = failure.getHttpStatus();
                                if (httpStatus == null) {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                int intValue = httpStatus.intValue();
                                DownloadFailureDetails downloadFailureDetails4 = new DownloadFailureDetails("HTTP_" + intValue, Boxing.boxInt(intValue), DownloadFailureKind.HTTP);
                                DownloadRetryDecision decide2 = this.retryPolicy.decide(DownloadFailureKind.HTTP, i3, this.networkMonitor.hasValidatedNetwork(), Boxing.boxInt(intValue));
                                if (decide2 instanceof DownloadRetryDecision.Retry) {
                                    DownloadRetryDecision.Retry retry2 = (DownloadRetryDecision.Retry) decide2;
                                    int nextAttempt2 = retry2.getNextAttempt();
                                    this.retryListener.onRetry(archiveByteRangeRequest3.getPackageId(), retry2.getNextAttempt(), retry2.getAfterMs(), downloadFailureDetails4);
                                    long afterMs2 = retry2.getAfterMs();
                                    okHttpArchiveByteRangeSource$fetch$1.L$0 = archiveByteRangeRequest3;
                                    okHttpArchiveByteRangeSource$fetch$1.L$1 = SpillingKt.nullOutSpilledVariable(archiveByteRangeResult);
                                    okHttpArchiveByteRangeSource$fetch$1.L$2 = SpillingKt.nullOutSpilledVariable(downloadFailureDetails4);
                                    okHttpArchiveByteRangeSource$fetch$1.L$3 = SpillingKt.nullOutSpilledVariable(decide2);
                                    okHttpArchiveByteRangeSource$fetch$1.J$0 = j2;
                                    okHttpArchiveByteRangeSource$fetch$1.I$0 = nextAttempt2;
                                    okHttpArchiveByteRangeSource$fetch$1.I$1 = intValue;
                                    okHttpArchiveByteRangeSource$fetch$1.label = 4;
                                    if (DelayKt.delay(afterMs2, okHttpArchiveByteRangeSource$fetch$1) != coroutine_suspended) {
                                        okHttpArchiveByteRangeSource$fetch$12 = okHttpArchiveByteRangeSource$fetch$1;
                                        archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                        j = j2;
                                        i2 = nextAttempt2;
                                        i4 = 1;
                                        JobKt.ensureActive(okHttpArchiveByteRangeSource$fetch$12.getContext());
                                        int i5222222 = (int) j;
                                        okHttpArchiveByteRangeSource$fetch$12.L$0 = archiveByteRangeRequest2;
                                        okHttpArchiveByteRangeSource$fetch$12.L$1 = null;
                                        okHttpArchiveByteRangeSource$fetch$12.L$2 = null;
                                        okHttpArchiveByteRangeSource$fetch$12.L$3 = null;
                                        okHttpArchiveByteRangeSource$fetch$12.J$0 = j;
                                        okHttpArchiveByteRangeSource$fetch$12.I$0 = i2;
                                        okHttpArchiveByteRangeSource$fetch$12.label = i4;
                                        obj = executeOnce(archiveByteRangeRequest2, i5222222, okHttpArchiveByteRangeSource$fetch$12);
                                        if (obj != coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                        }
                        return archiveByteRangeResult;
                    }
                    return coroutine_suspended;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        okHttpArchiveByteRangeSource$fetch$1 = new OkHttpArchiveByteRangeSource$fetch$1(this, continuation);
        Object obj2 = okHttpArchiveByteRangeSource$fetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okHttpArchiveByteRangeSource$fetch$1.label;
        int i42 = 1;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeOnce(ArchiveByteRangeRequest archiveByteRangeRequest, int i, Continuation<? super ArchiveByteRangeResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new OkHttpArchiveByteRangeSource$executeOnce$2(archiveByteRangeRequest, this, i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveByteRangeResult validatePartialResponse(Response response, ArchiveByteRangeRequest archiveByteRangeRequest, int i) {
        if (response.code() != 206) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.HTTP_STATUS, Integer.valueOf(response.code()), null, 4, null);
        }
        String httpUrl = response.request().url().toString();
        if (!ArchiveRemoteNetworkPolicy.INSTANCE.isAllowedUrl(httpUrl, this.allowInsecureLoopback)) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.EFFECTIVE_URL_UNSAFE, null, null, 6, null);
        }
        String header$default = Response.header$default(response, "Content-Encoding", null, 2, null);
        if (header$default != null && !StringsKt.equals(header$default, "identity", true)) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.CONTENT_ENCODING_UNSUPPORTED, null, null, 6, null);
        }
        ParsedContentRange parseContentRange = parseContentRange(Response.header$default(response, "Content-Range", null, 2, null));
        if (parseContentRange == null) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.CONTENT_RANGE_INVALID, null, null, 6, null);
        }
        if (parseContentRange.getStart() != archiveByteRangeRequest.getStartInclusive() || parseContentRange.getEnd() != archiveByteRangeRequest.getEndInclusive() || parseContentRange.getTotal() != archiveByteRangeRequest.getExpectedArchiveSize()) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.CONTENT_RANGE_MISMATCH, null, null, 6, null);
        }
        ResponseBody body = response.body();
        long contentLength = body.contentLength();
        if (contentLength >= 0 && contentLength != i) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.BODY_LENGTH_MISMATCH, null, null, 6, null);
        }
        byte[] readExactly = readExactly(body.byteStream(), i);
        if (readExactly == null) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.BODY_LENGTH_MISMATCH, null, null, 6, null);
        }
        return new ArchiveByteRangeResult.Success(new ArchiveByteRangeResponse(readExactly, StrongEtag.Companion.parse(Response.header$default(response, "ETag", null, 2, null)), httpUrl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop;", "", "Redirect", "Terminal", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop$Redirect;", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop$Terminal;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ArchiveHttpHop {

        /* compiled from: ArchiveManifestResolver.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop$Redirect;", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop;", "fromUrl", "", FirebaseAnalytics.Param.LOCATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFromUrl", "()Ljava/lang/String;", "getLocation", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Redirect implements ArchiveHttpHop {
            public static final int $stable = 0;
            private final String fromUrl;
            private final String location;

            public static /* synthetic */ Redirect copy$default(Redirect redirect, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = redirect.fromUrl;
                }
                if ((i & 2) != 0) {
                    str2 = redirect.location;
                }
                return redirect.copy(str, str2);
            }

            public final String component1() {
                return this.fromUrl;
            }

            public final String component2() {
                return this.location;
            }

            public final Redirect copy(String fromUrl, String str) {
                Intrinsics.checkNotNullParameter(fromUrl, "fromUrl");
                return new Redirect(fromUrl, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Redirect) {
                    Redirect redirect = (Redirect) obj;
                    return Intrinsics.areEqual(this.fromUrl, redirect.fromUrl) && Intrinsics.areEqual(this.location, redirect.location);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.fromUrl.hashCode() * 31;
                String str = this.location;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                String str = this.fromUrl;
                return "Redirect(fromUrl=" + str + ", location=" + this.location + ")";
            }

            public Redirect(String fromUrl, String str) {
                Intrinsics.checkNotNullParameter(fromUrl, "fromUrl");
                this.fromUrl = fromUrl;
                this.location = str;
            }

            public final String getFromUrl() {
                return this.fromUrl;
            }

            public final String getLocation() {
                return this.location;
            }
        }

        /* compiled from: ArchiveManifestResolver.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop$Terminal;", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ArchiveHttpHop;", "result", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;)V", "getResult", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Terminal implements ArchiveHttpHop {
            public static final int $stable = 8;
            private final ArchiveByteRangeResult result;

            public static /* synthetic */ Terminal copy$default(Terminal terminal, ArchiveByteRangeResult archiveByteRangeResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveByteRangeResult = terminal.result;
                }
                return terminal.copy(archiveByteRangeResult);
            }

            public final ArchiveByteRangeResult component1() {
                return this.result;
            }

            public final Terminal copy(ArchiveByteRangeResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new Terminal(result);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Terminal) && Intrinsics.areEqual(this.result, ((Terminal) obj).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "Terminal(result=" + this.result + ")";
            }

            public Terminal(ArchiveByteRangeResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final ArchiveByteRangeResult getResult() {
                return this.result;
            }
        }
    }

    private final byte[] readExactly(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                return null;
            }
            if (read != 0) {
                i2 += read;
            }
        }
        if (inputStream.read() == -1) {
            return bArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ParsedContentRange;", "", TtmlNode.START, "", TtmlNode.END, UpdateServiceContract.BundleKey.TOTAL, "<init>", "(JJJ)V", "getStart", "()J", "getEnd", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParsedContentRange {
        private final long end;
        private final long start;
        private final long total;

        public static /* synthetic */ ParsedContentRange copy$default(ParsedContentRange parsedContentRange, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parsedContentRange.start;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = parsedContentRange.end;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = parsedContentRange.total;
            }
            return parsedContentRange.copy(j4, j5, j3);
        }

        public final long component1() {
            return this.start;
        }

        public final long component2() {
            return this.end;
        }

        public final long component3() {
            return this.total;
        }

        public final ParsedContentRange copy(long j, long j2, long j3) {
            return new ParsedContentRange(j, j2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ParsedContentRange) {
                ParsedContentRange parsedContentRange = (ParsedContentRange) obj;
                return this.start == parsedContentRange.start && this.end == parsedContentRange.end && this.total == parsedContentRange.total;
            }
            return false;
        }

        public int hashCode() {
            return (((Long.hashCode(this.start) * 31) + Long.hashCode(this.end)) * 31) + Long.hashCode(this.total);
        }

        public String toString() {
            long j = this.start;
            long j2 = this.end;
            return "ParsedContentRange(start=" + j + ", end=" + j2 + ", total=" + this.total + ")";
        }

        public ParsedContentRange(long j, long j2, long j3) {
            this.start = j;
            this.end = j2;
            this.total = j3;
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getStart() {
            return this.start;
        }

        public final long getTotal() {
            return this.total;
        }
    }

    private final ParsedContentRange parseContentRange(String str) {
        Long longOrNull;
        Regex regex = CONTENT_RANGE;
        String obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        MatchResult matchEntire = regex.matchEntire(obj);
        if (matchEntire != null && (longOrNull = StringsKt.toLongOrNull(matchEntire.getGroupValues().get(1))) != null) {
            long longValue = longOrNull.longValue();
            Long longOrNull2 = StringsKt.toLongOrNull(matchEntire.getGroupValues().get(2));
            if (longOrNull2 != null) {
                long longValue2 = longOrNull2.longValue();
                Long longOrNull3 = StringsKt.toLongOrNull(matchEntire.getGroupValues().get(3));
                if (longOrNull3 != null) {
                    long longValue3 = longOrNull3.longValue();
                    if (longValue >= 0 && longValue2 >= longValue && longValue3 > longValue2) {
                        return new ParsedContentRange(longValue, longValue2, longValue3);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$Companion;", "", "<init>", "()V", "HTTP_PARTIAL_CONTENT", "", "MAX_REDIRECT_HOPS", "MAX_RANGE_BODY_BYTES", "", "CALL_TIMEOUT_SECONDS", "REDIRECT_HTTP_STATUSES", "", "getREDIRECT_HTTP_STATUSES", "()Ljava/util/Set;", "CONTENT_RANGE", "Lkotlin/text/Regex;", "getCONTENT_RANGE", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getREDIRECT_HTTP_STATUSES() {
            return OkHttpArchiveByteRangeSource.REDIRECT_HTTP_STATUSES;
        }

        public final Regex getCONTENT_RANGE() {
            return OkHttpArchiveByteRangeSource.CONTENT_RANGE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object executeCancellable(final Call call, Function1<? super Response, ? extends T> function1, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$executeCancellable$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.cancel();
            }
        });
        try {
            Response execute = call.execute();
            T invoke = function1.invoke(execute);
            CloseableKt.closeFinally(execute, null);
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(invoke));
            }
        } catch (Throwable th) {
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(ResultKt.createFailure(th)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
