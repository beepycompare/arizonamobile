package com.arizona.launcher.updater.archive.orchestrator;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeStreamResult;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 ;2\u00020\u0001:\u000489:;B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002JD\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00182\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#H\u0082@¢\u0006\u0002\u0010$J6\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u0010&J6\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018H\u0002J0\u0010*\u001a\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H+0\u0018H\u0082@¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020!H\u0002J\u0014\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b=\u0012\b\b>\u0012\u0004\b\u0003\u0010\u0000¨\u0006<"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "retryPolicy", "Lcom/arizona/launcher/DownloadRetryPolicy;", "networkMonitor", "Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "retryListener", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "client", "Lokhttp3/OkHttpClient;", "allowInsecureLoopback", "", "<init>", "(Lcom/arizona/launcher/DownloadRetryPolicy;Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;Lokhttp3/OkHttpClient;Z)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "request", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asStreamer", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;", "stream", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult;", "consumer", "Lkotlin/Function1;", "Ljava/io/InputStream;", "", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isValidRange", "rangeLength", "", "fetchWithRetry", "expectedBodyBytes", "", "bodyHasStarted", "Lkotlin/Function0;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOnce", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validatePartialResponse", "response", "Lokhttp3/Response;", "executeCancellable", ExifInterface.GPS_DIRECTION_TRUE, NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "consume", "(Lokhttp3/Call;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readExactly", "", "input", "expectedBytes", "parseContentRange", "Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$ParsedContentRange;", "raw", "", "ArchiveHttpHop", "LimitedInputStream", "ParsedContentRange", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean fetchWithRetry$lambda$0() {
        return false;
    }

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

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeSource
    public Object fetch(ArchiveByteRangeRequest archiveByteRangeRequest, Continuation<? super ArchiveByteRangeResult> continuation) {
        long endInclusive = (archiveByteRangeRequest.getEndInclusive() - archiveByteRangeRequest.getStartInclusive()) + 1;
        if (!isValidRange(archiveByteRangeRequest, endInclusive) || endInclusive > MAX_RANGE_BODY_BYTES) {
            return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.INVALID_REQUEST, null, null, 6, null);
        }
        return fetchWithRetry$default(this, archiveByteRangeRequest, (int) endInclusive, null, null, continuation, 8, null);
    }

    public final ArchiveByteRangeStreamer asStreamer() {
        return new ArchiveByteRangeStreamer() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$asStreamer$1
            @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeStreamer
            public final Object stream(ArchiveByteRangeRequest archiveByteRangeRequest, Function1<? super InputStream, Unit> function1, Continuation<? super ArchiveByteRangeStreamResult> continuation) {
                return OkHttpArchiveByteRangeSource.this.stream(archiveByteRangeRequest, function1, continuation);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stream(ArchiveByteRangeRequest archiveByteRangeRequest, final Function1<? super InputStream, Unit> function1, Continuation<? super ArchiveByteRangeStreamResult> continuation) {
        OkHttpArchiveByteRangeSource$stream$1 okHttpArchiveByteRangeSource$stream$1;
        int i;
        long j;
        ArchiveByteRangeResult archiveByteRangeResult;
        if (continuation instanceof OkHttpArchiveByteRangeSource$stream$1) {
            okHttpArchiveByteRangeSource$stream$1 = (OkHttpArchiveByteRangeSource$stream$1) continuation;
            if ((okHttpArchiveByteRangeSource$stream$1.label & Integer.MIN_VALUE) != 0) {
                okHttpArchiveByteRangeSource$stream$1.label -= Integer.MIN_VALUE;
                OkHttpArchiveByteRangeSource$stream$1 okHttpArchiveByteRangeSource$stream$12 = okHttpArchiveByteRangeSource$stream$1;
                Object obj = okHttpArchiveByteRangeSource$stream$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okHttpArchiveByteRangeSource$stream$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long endInclusive = 1 + (archiveByteRangeRequest.getEndInclusive() - archiveByteRangeRequest.getStartInclusive());
                    if (!isValidRange(archiveByteRangeRequest, endInclusive) || endInclusive > SieveCacheKt.NodeLinkMask) {
                        return new ArchiveByteRangeStreamResult.Failure(ArchiveByteRangeErrorCode.INVALID_REQUEST, null, null, 6, null);
                    }
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Function1<? super InputStream, Unit> function12 = new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return OkHttpArchiveByteRangeSource.stream$lambda$0(Ref.BooleanRef.this, function1, (InputStream) obj2);
                        }
                    };
                    Function0<Boolean> function0 = new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean z;
                            z = Ref.BooleanRef.this.element;
                            return Boolean.valueOf(z);
                        }
                    };
                    okHttpArchiveByteRangeSource$stream$12.L$0 = SpillingKt.nullOutSpilledVariable(archiveByteRangeRequest);
                    okHttpArchiveByteRangeSource$stream$12.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    okHttpArchiveByteRangeSource$stream$12.L$2 = SpillingKt.nullOutSpilledVariable(booleanRef);
                    okHttpArchiveByteRangeSource$stream$12.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                    okHttpArchiveByteRangeSource$stream$12.L$4 = SpillingKt.nullOutSpilledVariable(function0);
                    okHttpArchiveByteRangeSource$stream$12.J$0 = endInclusive;
                    okHttpArchiveByteRangeSource$stream$12.label = 1;
                    obj = fetchWithRetry(archiveByteRangeRequest, (int) endInclusive, function12, function0, okHttpArchiveByteRangeSource$stream$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = endInclusive;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = okHttpArchiveByteRangeSource$stream$12.J$0;
                    Function0 function02 = (Function0) okHttpArchiveByteRangeSource$stream$12.L$4;
                    Function1 function13 = (Function1) okHttpArchiveByteRangeSource$stream$12.L$3;
                    Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) okHttpArchiveByteRangeSource$stream$12.L$2;
                    Function1 function14 = (Function1) okHttpArchiveByteRangeSource$stream$12.L$1;
                    ArchiveByteRangeRequest archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$stream$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Success)) {
                    ArchiveByteRangeResult.Success success = (ArchiveByteRangeResult.Success) archiveByteRangeResult;
                    return new ArchiveByteRangeStreamResult.Success(success.getResponse().getStrongEtag(), success.getResponse().getEffectiveUrl(), j);
                } else if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    ArchiveByteRangeResult.Failure failure = (ArchiveByteRangeResult.Failure) archiveByteRangeResult;
                    return new ArchiveByteRangeStreamResult.Failure(failure.getCode(), failure.getHttpStatus(), failure.getDetail());
                }
            }
        }
        okHttpArchiveByteRangeSource$stream$1 = new OkHttpArchiveByteRangeSource$stream$1(this, continuation);
        OkHttpArchiveByteRangeSource$stream$1 okHttpArchiveByteRangeSource$stream$122 = okHttpArchiveByteRangeSource$stream$1;
        Object obj2 = okHttpArchiveByteRangeSource$stream$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okHttpArchiveByteRangeSource$stream$122.label;
        if (i != 0) {
        }
        archiveByteRangeResult = (ArchiveByteRangeResult) obj2;
        if (!(archiveByteRangeResult instanceof ArchiveByteRangeResult.Success)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit stream$lambda$0(Ref.BooleanRef booleanRef, Function1 function1, InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        booleanRef.element = true;
        function1.invoke(input);
        return Unit.INSTANCE;
    }

    private final boolean isValidRange(ArchiveByteRangeRequest archiveByteRangeRequest, long j) {
        return !StringsKt.isBlank(archiveByteRangeRequest.getPackageId()) && archiveByteRangeRequest.getExpectedArchiveSize() > 0 && archiveByteRangeRequest.getStartInclusive() >= 0 && archiveByteRangeRequest.getEndInclusive() >= archiveByteRangeRequest.getStartInclusive() && archiveByteRangeRequest.getEndInclusive() < archiveByteRangeRequest.getExpectedArchiveSize() && j > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:12|13|14|15|16|(5:18|19|20|(2:22|(2:28|(2:30|(2:32|(6:34|13|14|15|16|(0))))(2:35|36)))|38)|69) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ce, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01cf, code lost:
        r21 = r12;
        r12 = r2;
        r2 = r11;
        r11 = r9;
        r9 = r4;
        r4 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01b7 -> B:48:0x01bc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x026a -> B:25:0x00da). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02bf -> B:25:0x00da). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchWithRetry(ArchiveByteRangeRequest archiveByteRangeRequest, int i, Function1<? super InputStream, Unit> function1, Function0<Boolean> function0, Continuation<? super ArchiveByteRangeResult> continuation) {
        OkHttpArchiveByteRangeSource$fetchWithRetry$1 okHttpArchiveByteRangeSource$fetchWithRetry$1;
        int i2;
        int i3;
        Function1<? super InputStream, Unit> function12;
        Function0<Boolean> function02;
        int i4;
        OkHttpArchiveByteRangeSource$fetchWithRetry$1 okHttpArchiveByteRangeSource$fetchWithRetry$12;
        ArchiveByteRangeRequest archiveByteRangeRequest2;
        boolean z;
        Function1<? super InputStream, Unit> function13;
        int i5;
        char c;
        OkHttpArchiveByteRangeSource$fetchWithRetry$1 okHttpArchiveByteRangeSource$fetchWithRetry$13;
        char c2;
        Function0<Boolean> function03;
        DownloadFailureDetails downloadFailureDetails;
        OkHttpArchiveByteRangeSource$fetchWithRetry$1 okHttpArchiveByteRangeSource$fetchWithRetry$14;
        ArchiveByteRangeRequest archiveByteRangeRequest3;
        int i6;
        ArchiveByteRangeResult archiveByteRangeResult;
        if (continuation instanceof OkHttpArchiveByteRangeSource$fetchWithRetry$1) {
            okHttpArchiveByteRangeSource$fetchWithRetry$1 = (OkHttpArchiveByteRangeSource$fetchWithRetry$1) continuation;
            if ((okHttpArchiveByteRangeSource$fetchWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                okHttpArchiveByteRangeSource$fetchWithRetry$1.label -= Integer.MIN_VALUE;
                Object obj = okHttpArchiveByteRangeSource$fetchWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = okHttpArchiveByteRangeSource$fetchWithRetry$1.label;
                int i7 = 1;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i3 = i;
                    function12 = function1;
                    function02 = function0;
                    i4 = 0;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                    archiveByteRangeRequest2 = archiveByteRangeRequest;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                    obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 1) {
                    i6 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1;
                    i5 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0;
                    function02 = (Function0) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2;
                    function13 = (Function1) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1;
                    archiveByteRangeRequest3 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (IOException e) {
                            IOException e2 = e;
                            if (!function02.invoke().booleanValue()) {
                                return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.NETWORK_FAILED, null, DownloadFailureClassifier.INSTANCE.classify(e2).getSubtypeSuffix(), 2, null);
                            }
                            DownloadFailureDetails classify = DownloadFailureClassifier.INSTANCE.classify(e2);
                            DownloadRetryDecision decide = this.retryPolicy.decide(classify.getKind(), i6, this.networkMonitor.hasValidatedNetwork(), classify.getHttpStatus());
                            if (Intrinsics.areEqual(decide, DownloadRetryDecision.WaitForValidatedNetwork.INSTANCE)) {
                                ArchiveNetworkMonitor archiveNetworkMonitor = this.networkMonitor;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0 = archiveByteRangeRequest3;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1 = function13;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2 = function02;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3 = SpillingKt.nullOutSpilledVariable(e2);
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4 = classify;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5 = SpillingKt.nullOutSpilledVariable(decide);
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0 = i5;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1 = i6;
                                c2 = 2;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.label = 2;
                                obj = archiveNetworkMonitor.awaitValidatedNetwork(okHttpArchiveByteRangeSource$fetchWithRetry$1);
                                if (obj != coroutine_suspended) {
                                    okHttpArchiveByteRangeSource$fetchWithRetry$14 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                                    archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                    i4 = i6;
                                    i3 = i5;
                                    function12 = function13;
                                    function03 = function02;
                                    downloadFailureDetails = classify;
                                    if (!((Boolean) obj).booleanValue()) {
                                    }
                                }
                            } else if (decide instanceof DownloadRetryDecision.Retry) {
                                DownloadRetryDecision.Retry retry = (DownloadRetryDecision.Retry) decide;
                                int nextAttempt = retry.getNextAttempt();
                                z = true;
                                this.retryListener.onRetry(archiveByteRangeRequest3.getPackageId(), retry.getNextAttempt(), retry.getAfterMs(), classify);
                                long afterMs = retry.getAfterMs();
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0 = archiveByteRangeRequest3;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1 = function13;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2 = function02;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3 = SpillingKt.nullOutSpilledVariable(e2);
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4 = SpillingKt.nullOutSpilledVariable(classify);
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5 = SpillingKt.nullOutSpilledVariable(decide);
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0 = i5;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1 = nextAttempt;
                                c = 3;
                                okHttpArchiveByteRangeSource$fetchWithRetry$1.label = 3;
                                if (DelayKt.delay(afterMs, okHttpArchiveByteRangeSource$fetchWithRetry$1) != coroutine_suspended) {
                                    okHttpArchiveByteRangeSource$fetchWithRetry$13 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                                    archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                    i4 = nextAttempt;
                                    i3 = i5;
                                    function12 = function13;
                                    i7 = 1;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$13;
                                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                                    obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
                                    if (obj != coroutine_suspended) {
                                    }
                                }
                            } else if (!Intrinsics.areEqual(decide, DownloadRetryDecision.Disabled.INSTANCE) && !Intrinsics.areEqual(decide, DownloadRetryDecision.DoNotRetry.INSTANCE)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.NETWORK_FAILED, null, classify.getSubtypeSuffix(), 2, null);
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
                } else if (i2 == 2) {
                    int i8 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1;
                    int i9 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0;
                    DownloadRetryDecision downloadRetryDecision = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5;
                    downloadFailureDetails = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4;
                    IOException iOException = (IOException) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3;
                    function03 = (Function0) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2;
                    Function1<? super InputStream, Unit> function14 = (Function1) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    i4 = i8;
                    i3 = i9;
                    function12 = function14;
                    okHttpArchiveByteRangeSource$fetchWithRetry$14 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0;
                    c2 = 2;
                    if (!((Boolean) obj).booleanValue()) {
                        function02 = function03;
                        i7 = 1;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$14;
                        JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                        okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                        obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.NETWORK_FAILED, null, downloadFailureDetails.getSubtypeSuffix(), 2, null);
                } else if (i2 == 3) {
                    int i10 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1;
                    i5 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0;
                    DownloadRetryDecision downloadRetryDecision2 = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5;
                    DownloadFailureDetails downloadFailureDetails2 = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4;
                    IOException iOException2 = (IOException) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3;
                    function02 = (Function0) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2;
                    function13 = (Function1) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    okHttpArchiveByteRangeSource$fetchWithRetry$13 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                    z = true;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0;
                    i4 = i10;
                    c = 3;
                    i3 = i5;
                    function12 = function13;
                    i7 = 1;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$13;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                    obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i2 == 4) {
                    int i11 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$2;
                    int i12 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1;
                    int i13 = okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0;
                    DownloadRetryDecision downloadRetryDecision3 = (DownloadRetryDecision) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5;
                    DownloadFailureDetails downloadFailureDetails3 = (DownloadFailureDetails) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4;
                    ArchiveByteRangeResult archiveByteRangeResult2 = (ArchiveByteRangeResult) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3;
                    function02 = (Function0) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2;
                    Function1<? super InputStream, Unit> function15 = (Function1) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                    archiveByteRangeRequest2 = (ArchiveByteRangeRequest) okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0;
                    i4 = i12;
                    i3 = i13;
                    function12 = function15;
                    i7 = 1;
                    JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                    okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                    obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
                    if (obj != coroutine_suspended) {
                        int i14 = i4;
                        archiveByteRangeRequest3 = archiveByteRangeRequest2;
                        okHttpArchiveByteRangeSource$fetchWithRetry$1 = okHttpArchiveByteRangeSource$fetchWithRetry$12;
                        function13 = function12;
                        i5 = i3;
                        i6 = i14;
                        archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure) {
                            ArchiveByteRangeResult.Failure failure = (ArchiveByteRangeResult.Failure) archiveByteRangeResult;
                            if (failure.getCode() == ArchiveByteRangeErrorCode.HTTP_STATUS && CollectionsKt.contains(DownloadRetryPolicy.Companion.getRETRYABLE_HTTP_STATUSES(), failure.getHttpStatus()) && !function02.invoke().booleanValue()) {
                                Integer httpStatus = failure.getHttpStatus();
                                if (httpStatus == null) {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                int intValue = httpStatus.intValue();
                                DownloadFailureDetails downloadFailureDetails4 = new DownloadFailureDetails("HTTP_" + intValue, Boxing.boxInt(intValue), DownloadFailureKind.HTTP);
                                DownloadRetryDecision decide2 = this.retryPolicy.decide(DownloadFailureKind.HTTP, i6, this.networkMonitor.hasValidatedNetwork(), Boxing.boxInt(intValue));
                                if (decide2 instanceof DownloadRetryDecision.Retry) {
                                    DownloadRetryDecision.Retry retry2 = (DownloadRetryDecision.Retry) decide2;
                                    int nextAttempt2 = retry2.getNextAttempt();
                                    this.retryListener.onRetry(archiveByteRangeRequest3.getPackageId(), retry2.getNextAttempt(), retry2.getAfterMs(), downloadFailureDetails4);
                                    long afterMs2 = retry2.getAfterMs();
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$0 = archiveByteRangeRequest3;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$1 = function13;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$2 = function02;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$3 = SpillingKt.nullOutSpilledVariable(archiveByteRangeResult);
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$4 = SpillingKt.nullOutSpilledVariable(downloadFailureDetails4);
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.L$5 = SpillingKt.nullOutSpilledVariable(decide2);
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.I$0 = i5;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.I$1 = nextAttempt2;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.I$2 = intValue;
                                    okHttpArchiveByteRangeSource$fetchWithRetry$1.label = 4;
                                    if (DelayKt.delay(afterMs2, okHttpArchiveByteRangeSource$fetchWithRetry$1) != coroutine_suspended) {
                                        i3 = i5;
                                        function12 = function13;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12 = okHttpArchiveByteRangeSource$fetchWithRetry$1;
                                        archiveByteRangeRequest2 = archiveByteRangeRequest3;
                                        i4 = nextAttempt2;
                                        i7 = 1;
                                        JobKt.ensureActive(okHttpArchiveByteRangeSource$fetchWithRetry$12.getContext());
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$0 = archiveByteRangeRequest2;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$1 = function12;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$2 = function02;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$3 = null;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$4 = null;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.L$5 = null;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.I$0 = i3;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.I$1 = i4;
                                        okHttpArchiveByteRangeSource$fetchWithRetry$12.label = i7;
                                        obj = executeOnce(archiveByteRangeRequest2, i3, function12, okHttpArchiveByteRangeSource$fetchWithRetry$12);
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
        okHttpArchiveByteRangeSource$fetchWithRetry$1 = new OkHttpArchiveByteRangeSource$fetchWithRetry$1(this, continuation);
        Object obj2 = okHttpArchiveByteRangeSource$fetchWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = okHttpArchiveByteRangeSource$fetchWithRetry$1.label;
        int i72 = 1;
        if (i2 != 0) {
        }
    }

    static /* synthetic */ Object fetchWithRetry$default(OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, ArchiveByteRangeRequest archiveByteRangeRequest, int i, Function1 function1, Function0 function0, Continuation continuation, int i2, Object obj) {
        Function0 function02 = function0;
        if ((i2 & 8) != 0) {
            function02 = new Function0() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(OkHttpArchiveByteRangeSource.fetchWithRetry$lambda$0());
                }
            };
        }
        return okHttpArchiveByteRangeSource.fetchWithRetry(archiveByteRangeRequest, i, function1, function02, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object executeOnce$default(OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, ArchiveByteRangeRequest archiveByteRangeRequest, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return okHttpArchiveByteRangeSource.executeOnce(archiveByteRangeRequest, i, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeOnce(ArchiveByteRangeRequest archiveByteRangeRequest, int i, Function1<? super InputStream, Unit> function1, Continuation<? super ArchiveByteRangeResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new OkHttpArchiveByteRangeSource$executeOnce$2(archiveByteRangeRequest, this, i, function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArchiveByteRangeResult validatePartialResponse(Response response, ArchiveByteRangeRequest archiveByteRangeRequest, int i, Function1<? super InputStream, Unit> function1) {
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
        StrongEtag parse = StrongEtag.Companion.parse(Response.header$default(response, "ETag", null, 2, null));
        if (function1 != null) {
            InputStream byteStream = body.byteStream();
            try {
                InputStream inputStream = byteStream;
                LimitedInputStream limitedInputStream = new LimitedInputStream(inputStream, i);
                function1.invoke(limitedInputStream);
                if (limitedInputStream.getRemaining() == 0 && inputStream.read() == -1) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteStream, null);
                    return new ArchiveByteRangeResult.Success(new ArchiveByteRangeResponse(new byte[0], parse, httpUrl));
                }
                ArchiveByteRangeResult.Failure failure = new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.BODY_LENGTH_MISMATCH, null, null, 6, null);
                CloseableKt.closeFinally(byteStream, null);
                return failure;
            } finally {
            }
        } else {
            byte[] readExactly = readExactly(body.byteStream(), i);
            if (readExactly == null) {
                return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.BODY_LENGTH_MISMATCH, null, null, 6, null);
            }
            return new ArchiveByteRangeResult.Success(new ArchiveByteRangeResponse(readExactly, parse, httpUrl));
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OkHttpArchiveByteRangeSource$LimitedInputStream;", "Ljava/io/InputStream;", "delegate", "expectedBytes", "", "<init>", "(Ljava/io/InputStream;J)V", "value", "remaining", "getRemaining", "()J", "read", "", "buffer", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LimitedInputStream extends InputStream {
        private final InputStream delegate;
        private long remaining;

        public LimitedInputStream(InputStream delegate, long j) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
            this.remaining = j;
        }

        public final long getRemaining() {
            return this.remaining;
        }

        @Override // java.io.InputStream
        public int read() {
            int read;
            if (this.remaining > 0 && (read = this.delegate.read()) >= 0) {
                this.remaining--;
                return read;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer, int i, int i2) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            long j = this.remaining;
            if (j <= 0 || i2 <= 0) {
                return j <= 0 ? -1 : 0;
            }
            int read = this.delegate.read(buffer, i, (int) Math.min(i2, j));
            if (read < 0) {
                return -1;
            }
            this.remaining -= read;
            return read;
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
                cancellableContinuationImpl2.resumeWith(Result.m9919constructorimpl(invoke));
            }
        } catch (Throwable th) {
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9919constructorimpl(ResultKt.createFailure(th)));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
