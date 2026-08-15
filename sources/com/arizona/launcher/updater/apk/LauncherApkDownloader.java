package com.arizona.launcher.updater.apk;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.UtilsKt;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.apk.LauncherApkDownloadError;
import com.arizona.launcher.updater.apk.LauncherApkDownloadResult;
import com.arizona.launcher.updater.apk.LauncherApkDownloader;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* compiled from: LauncherApkDownloader.kt */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 y2\u00020\u0001:\npqrstuvwxyB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012$\b\u0002\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0004\b\u0018\u0010\u0019J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020-2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u0010\"\u001a\u00020-H\u0002J.\u00101\u001a\u0002022\u0006\u0010\"\u001a\u00020-2\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u00105J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u00103\u001a\u000200H\u0002J6\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002072\u0006\u0010\"\u001a\u00020-2\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010=J>\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020-2\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002J6\u0010C\u001a\u0002022\u0006\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020-2\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002J>\u0010D\u001a\u0002022\u0006\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020-2\u0006\u0010E\u001a\u00020F2\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002JW\u0010G\u001a\u0002022\u0006\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020-2\u0006\u0010H\u001a\u00020\u000f2\b\u0010I\u001a\u0004\u0018\u00010\u000f2\b\u0010J\u001a\u0004\u0018\u00010F2\u0006\u00104\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002¢\u0006\u0002\u0010KJ\u001e\u0010L\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020-2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002J\u0018\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020QH\u0002J\u0016\u0010R\u001a\u00020\u00142\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010-2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010V\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020-H\u0002J\u0010\u0010W\u001a\u00020\u00142\u0006\u0010N\u001a\u00020*H\u0002J\u0010\u0010X\u001a\u00020\u00142\u0006\u0010N\u001a\u00020*H\u0002J\u0010\u0010Y\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020*H\u0002J\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020*H\u0002J\f\u0010]\u001a\u00020^*\u00020@H\u0002J\u0010\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020aH\u0002J\u000e\u0010b\u001a\u0004\u0018\u00010c*\u00020@H\u0002J\u0016\u0010d\u001a\u0004\u0018\u00010a*\u00020@2\u0006\u0010e\u001a\u00020fH\u0002J\f\u0010g\u001a\u00020U*\u00020hH\u0002J\f\u0010i\u001a\u00020^*\u00020hH\u0002J\u0018\u0010j\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010k\u001a\u00020lH\u0002J\u0018\u0010m\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010n\u001a\u00020oH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b{\u0012\b\b|\u0012\u0004\b\u0003\u0010\u0000¨\u0006z"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader;", "", "baseClient", "Lokhttp3/OkHttpClient;", "retryPolicy", "Lcom/arizona/launcher/updater/apk/LauncherApkRetryPolicy;", "fileOps", "Lcom/arizona/launcher/updater/apk/LauncherApkFileOps;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "allowInsecureLoopback", "", "maxRedirects", "", "maxApkBytes", "", "checkpointBytes", "retryDelay", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "onCallCreated", "Lkotlin/Function1;", "Lokhttp3/Call;", "<init>", "(Lokhttp3/OkHttpClient;Lcom/arizona/launcher/updater/apk/LauncherApkRetryPolicy;Lcom/arizona/launcher/updater/apk/LauncherApkFileOps;Lkotlinx/coroutines/CoroutineDispatcher;ZIJJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function2;", "networkPolicy", "Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;", "client", "resumeStore", "Lcom/arizona/launcher/updater/apk/LauncherApkResumeStore;", "download", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadResult;", "request", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;", "observer", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadRequest;Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupTemporaryArtifacts", "Lcom/arizona/launcher/updater/apk/LauncherApkCleanupResult;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadOwned", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;Lcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preparePartial", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;", "executeAttempt", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "preparation", "attempt", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;ILcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildNetworkRequest", "Lokhttp3/Request;", "url", "Lokhttp3/HttpUrl;", "executeHop", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome;", "networkRequest", "(Lokhttp3/Request;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;ILcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeResponse", "response", "Lokhttp3/Response;", "isActive", "Lkotlin/Function0;", "consumeFreshResponse", "consumeResumeResponse", TtmlNode.TAG_METADATA, "Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "writeAndCommit", "startOffset", "totalBytes", "resumableMetadata", "(Lokhttp3/Response;Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;JLjava/lang/Long;Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;ILcom/arizona/launcher/updater/apk/LauncherApkDownloadObserver;Lkotlin/jvm/functions/Function0;)Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "verifyCompletedPayload", "saveResumeMetadata", "partialFile", "syncOutput", "output", "Ljava/io/RandomAccessFile;", "ensureTransferActive", "validateRequest", "invalidRequestError", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "discardNonResumablePartialQuietly", "discardArtifacts", "discardArtifactsQuietly", "ensureParentDirectory", "parent", "isSymbolicLink", UtilsKt.SCHEME_FILE, "toHttpFailure", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome$Failed;", "invalidResume", "reason", "", "resumeValidator", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ResumeValidator;", "validatorValue", "kind", "Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "toDownloadError", "Ljava/io/IOException;", "toAttemptFailure", "notifyProgress", "progress", "Lcom/arizona/launcher/updater/apk/LauncherApkProgress;", "notifyRetry", "retry", "Lcom/arizona/launcher/updater/apk/LauncherApkRetry;", "PartialPreparation", "HopOutcome", "AttemptOutcome", "ValidatedRequest", "ResumeValidator", "ParsedContentRange", "PayloadIntegrityException", "LauncherApkStorageException", "LauncherApkNetworkException", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkDownloader {
    @Deprecated
    public static final String ACCEPT_ENCODING_IDENTITY = "identity";
    @Deprecated
    public static final String CACHE_CONTROL_NO_CACHE = "no-cache";
    @Deprecated
    public static final long DEFAULT_CHECKPOINT_BYTES = 4194304;
    @Deprecated
    public static final long DEFAULT_MAX_APK_BYTES = 1073741824;
    @Deprecated
    public static final int DEFAULT_MAX_REDIRECTS = 5;
    @Deprecated
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    @Deprecated
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    @Deprecated
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    @Deprecated
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    @Deprecated
    public static final String HEADER_ETAG = "ETag";
    @Deprecated
    public static final String HEADER_IF_RANGE = "If-Range";
    @Deprecated
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    @Deprecated
    public static final String HEADER_LOCATION = "Location";
    @Deprecated
    public static final String HEADER_RANGE = "Range";
    @Deprecated
    public static final int HTTP_OK = 200;
    @Deprecated
    public static final int HTTP_PARTIAL = 206;
    @Deprecated
    public static final int HTTP_RANGE_NOT_SATISFIABLE = 416;
    @Deprecated
    public static final String PARTIAL_SUFFIX = ".part";
    @Deprecated
    public static final int READ_BUFFER_BYTES = 65536;
    private final boolean allowInsecureLoopback;
    private final long checkpointBytes;
    private final OkHttpClient client;
    private final LauncherApkFileOps fileOps;
    private final CoroutineDispatcher ioDispatcher;
    private final long maxApkBytes;
    private final int maxRedirects;
    private final LauncherApkNetworkPolicy networkPolicy;
    private final Function1<Call, Unit> onCallCreated;
    private final LauncherApkResumeStore resumeStore;
    private final Function2<Long, Continuation<? super Unit>, Object> retryDelay;
    private final LauncherApkRetryPolicy retryPolicy;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<Integer> REDIRECT_STATUSES = SetsKt.setOf((Object[]) new Integer[]{301, 302, 303, 307, 308});
    private static final Regex SHA256_REGEX = new Regex("[0-9a-fA-F]{64}");
    private static final Regex CONTENT_RANGE_REGEX = new Regex("bytes ([0-9]+)-([0-9]+)/([0-9]+)");
    private static final byte[] APK_ZIP_MAGIC = {80, 75, 3, 4};

    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LauncherApkValidatorKind.values().length];
            try {
                iArr[LauncherApkValidatorKind.STRONG_ETAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LauncherApkValidatorKind.LAST_MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LauncherApkDownloader(OkHttpClient baseClient, LauncherApkRetryPolicy retryPolicy, LauncherApkFileOps fileOps, CoroutineDispatcher ioDispatcher, boolean z, int i, long j, long j2, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> retryDelay, Function1<? super Call, Unit> onCallCreated) {
        Intrinsics.checkNotNullParameter(baseClient, "baseClient");
        Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
        Intrinsics.checkNotNullParameter(fileOps, "fileOps");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(retryDelay, "retryDelay");
        Intrinsics.checkNotNullParameter(onCallCreated, "onCallCreated");
        this.retryPolicy = retryPolicy;
        this.fileOps = fileOps;
        this.ioDispatcher = ioDispatcher;
        this.allowInsecureLoopback = z;
        this.maxRedirects = i;
        this.maxApkBytes = j;
        this.checkpointBytes = j2;
        this.retryDelay = retryDelay;
        this.onCallCreated = onCallCreated;
        LauncherApkNetworkPolicy launcherApkNetworkPolicy = new LauncherApkNetworkPolicy(z);
        this.networkPolicy = launcherApkNetworkPolicy;
        this.client = baseClient.newBuilder().followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(false).dns(new SafeLauncherApkDns(baseClient.dns(), launcherApkNetworkPolicy, z)).addInterceptor(new LauncherApkNetworkGuardInterceptor(launcherApkNetworkPolicy)).addNetworkInterceptor(new LauncherApkNetworkGuardInterceptor(launcherApkNetworkPolicy)).build();
        this.resumeStore = new FileLauncherApkResumeStore(fileOps);
        if (i < 0) {
            throw new IllegalArgumentException("maxRedirects must not be negative".toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException("maxApkBytes must be positive".toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException("checkpointBytes must be positive".toString());
        }
    }

    public /* synthetic */ LauncherApkDownloader(OkHttpClient okHttpClient, LauncherApkRetryPolicy launcherApkRetryPolicy, AndroidLauncherApkFileOps androidLauncherApkFileOps, CoroutineDispatcher coroutineDispatcher, boolean z, int i, long j, long j2, Function2 function2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, (i2 & 2) != 0 ? new LauncherApkRetryPolicy(0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 15, null) : launcherApkRetryPolicy, (i2 & 4) != 0 ? AndroidLauncherApkFileOps.INSTANCE : androidLauncherApkFileOps, (i2 & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? 5 : i, (i2 & 64) != 0 ? DEFAULT_MAX_APK_BYTES : j, (i2 & 128) != 0 ? 4194304L : j2, (i2 & 256) != 0 ? new AnonymousClass1(null) : function2, (i2 & 512) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LauncherApkDownloader._init_$lambda$0((Call) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "delayMs", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizona.launcher.updater.apk.LauncherApkDownloader$1", f = "LauncherApkDownloader.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"delayMs"}, nl = {-1}, s = {"J$0"}, v = 2)
    /* renamed from: com.arizona.launcher.updater.apk.LauncherApkDownloader$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.J$0 = ((Number) obj).longValue();
            return anonymousClass1;
        }

        public final Object invoke(long j, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Long.valueOf(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Long l, Continuation<? super Unit> continuation) {
            return invoke(l.longValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j = this.J$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.J$0 = j;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(Call it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object download$default(LauncherApkDownloader launcherApkDownloader, LauncherApkDownloadRequest launcherApkDownloadRequest, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            launcherApkDownloadObserver = LauncherApkDownloadObserver.Companion.getNone();
        }
        return launcherApkDownloader.download(launcherApkDownloadRequest, launcherApkDownloadObserver, continuation);
    }

    public final Object download(LauncherApkDownloadRequest launcherApkDownloadRequest, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super LauncherApkDownloadResult> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new LauncherApkDownloader$download$2(this, launcherApkDownloadRequest, launcherApkDownloadObserver, null), continuation);
    }

    public final Object cleanupTemporaryArtifacts(File file, Continuation<? super LauncherApkCleanupResult> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new LauncherApkDownloader$cleanupTemporaryArtifacts$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0185 -> B:13:0x004c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadOwned(ValidatedRequest validatedRequest, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super LauncherApkDownloadResult> continuation) {
        LauncherApkDownloader$downloadOwned$1 launcherApkDownloader$downloadOwned$1;
        int i;
        ValidatedRequest validatedRequest2;
        LauncherApkDownloadObserver launcherApkDownloadObserver2;
        LauncherApkDownloader$downloadOwned$1 launcherApkDownloader$downloadOwned$12;
        int i2;
        int i3;
        ValidatedRequest validatedRequest3;
        LauncherApkDownloadObserver launcherApkDownloadObserver3;
        PartialPreparation partialPreparation;
        long j;
        AttemptOutcome attemptOutcome;
        Object executeAttempt;
        LauncherApkResumeMetadata metadata;
        LauncherApkResumeMetadata metadata2;
        if (continuation instanceof LauncherApkDownloader$downloadOwned$1) {
            launcherApkDownloader$downloadOwned$1 = (LauncherApkDownloader$downloadOwned$1) continuation;
            if ((launcherApkDownloader$downloadOwned$1.label & Integer.MIN_VALUE) != 0) {
                launcherApkDownloader$downloadOwned$1.label -= Integer.MIN_VALUE;
                Object obj = launcherApkDownloader$downloadOwned$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = launcherApkDownloader$downloadOwned$1.label;
                int i4 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    validatedRequest2 = validatedRequest;
                    launcherApkDownloadObserver2 = launcherApkDownloadObserver;
                    launcherApkDownloader$downloadOwned$12 = launcherApkDownloader$downloadOwned$1;
                    i2 = 1;
                    JobKt.ensureActive(launcherApkDownloader$downloadOwned$12.getContext());
                    PartialPreparation preparePartial = preparePartial(validatedRequest2);
                    boolean z = preparePartial instanceof PartialPreparation.Resume;
                    if (z) {
                    }
                    if (r9 != null) {
                    }
                    if (z) {
                    }
                    long j2 = r16;
                    notifyProgress(launcherApkDownloadObserver2, new LauncherApkProgress(j2, (r3 != null || (metadata = r3.getMetadata()) == null) ? validatedRequest2.getExpectedSizeBytes() : Boxing.boxLong(metadata.getTotalBytes()), i2, r16 > 0 ? i4 : 0));
                    launcherApkDownloader$downloadOwned$12.L$0 = validatedRequest2;
                    launcherApkDownloader$downloadOwned$12.L$1 = launcherApkDownloadObserver2;
                    launcherApkDownloader$downloadOwned$12.L$2 = SpillingKt.nullOutSpilledVariable(preparePartial);
                    launcherApkDownloader$downloadOwned$12.L$3 = null;
                    launcherApkDownloader$downloadOwned$12.I$0 = i2;
                    launcherApkDownloader$downloadOwned$12.J$0 = j2;
                    launcherApkDownloader$downloadOwned$12.label = i4;
                    executeAttempt = executeAttempt(validatedRequest2, preparePartial, i2, launcherApkDownloadObserver2, launcherApkDownloader$downloadOwned$12);
                    if (executeAttempt != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    j = launcherApkDownloader$downloadOwned$1.J$0;
                    int i5 = launcherApkDownloader$downloadOwned$1.I$0;
                    launcherApkDownloadObserver3 = (LauncherApkDownloadObserver) launcherApkDownloader$downloadOwned$1.L$1;
                    validatedRequest3 = (ValidatedRequest) launcherApkDownloader$downloadOwned$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i3 = i5;
                    partialPreparation = (PartialPreparation) launcherApkDownloader$downloadOwned$1.L$2;
                    attemptOutcome = (AttemptOutcome) obj;
                    if (attemptOutcome instanceof AttemptOutcome.Completed) {
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j3 = launcherApkDownloader$downloadOwned$1.J$1;
                    int i6 = launcherApkDownloader$downloadOwned$1.I$1;
                    long j4 = launcherApkDownloader$downloadOwned$1.J$0;
                    int i7 = launcherApkDownloader$downloadOwned$1.I$0;
                    AttemptOutcome attemptOutcome2 = (AttemptOutcome) launcherApkDownloader$downloadOwned$1.L$3;
                    PartialPreparation partialPreparation2 = (PartialPreparation) launcherApkDownloader$downloadOwned$1.L$2;
                    launcherApkDownloadObserver2 = (LauncherApkDownloadObserver) launcherApkDownloader$downloadOwned$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    i2 = i6;
                    validatedRequest2 = (ValidatedRequest) launcherApkDownloader$downloadOwned$1.L$0;
                    int i8 = 1;
                    try {
                        launcherApkDownloader$downloadOwned$12 = launcherApkDownloader$downloadOwned$1;
                        i4 = i8;
                        PartialPreparation preparePartial2 = preparePartial(validatedRequest2);
                        boolean z2 = preparePartial2 instanceof PartialPreparation.Resume;
                        PartialPreparation.Resume resume = z2 ? (PartialPreparation.Resume) preparePartial2 : null;
                        long committedBytes = (resume != null || (metadata2 = resume.getMetadata()) == null) ? 0L : metadata2.getCommittedBytes();
                        PartialPreparation.Resume resume2 = z2 ? (PartialPreparation.Resume) preparePartial2 : null;
                        long j22 = committedBytes;
                        notifyProgress(launcherApkDownloadObserver2, new LauncherApkProgress(j22, (resume2 != null || (metadata = resume2.getMetadata()) == null) ? validatedRequest2.getExpectedSizeBytes() : Boxing.boxLong(metadata.getTotalBytes()), i2, committedBytes > 0 ? i4 : 0));
                        launcherApkDownloader$downloadOwned$12.L$0 = validatedRequest2;
                        launcherApkDownloader$downloadOwned$12.L$1 = launcherApkDownloadObserver2;
                        launcherApkDownloader$downloadOwned$12.L$2 = SpillingKt.nullOutSpilledVariable(preparePartial2);
                        launcherApkDownloader$downloadOwned$12.L$3 = null;
                        launcherApkDownloader$downloadOwned$12.I$0 = i2;
                        launcherApkDownloader$downloadOwned$12.J$0 = j22;
                        launcherApkDownloader$downloadOwned$12.label = i4;
                        executeAttempt = executeAttempt(validatedRequest2, preparePartial2, i2, launcherApkDownloadObserver2, launcherApkDownloader$downloadOwned$12);
                        if (executeAttempt != coroutine_suspended) {
                            launcherApkDownloadObserver3 = launcherApkDownloadObserver2;
                            j = j22;
                            LauncherApkDownloader$downloadOwned$1 launcherApkDownloader$downloadOwned$13 = launcherApkDownloader$downloadOwned$12;
                            partialPreparation = preparePartial2;
                            launcherApkDownloader$downloadOwned$1 = launcherApkDownloader$downloadOwned$13;
                            validatedRequest3 = validatedRequest2;
                            obj = executeAttempt;
                            i3 = i2;
                            attemptOutcome = (AttemptOutcome) obj;
                            if (attemptOutcome instanceof AttemptOutcome.Completed) {
                                AttemptOutcome.Completed completed = (AttemptOutcome.Completed) attemptOutcome;
                                return new LauncherApkDownloadResult.Success(validatedRequest3.getDestination(), completed.getTotalBytes(), completed.getResumedFromBytes(), i3);
                            } else if (!(attemptOutcome instanceof AttemptOutcome.Failed)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                AttemptOutcome.Failed failed = (AttemptOutcome.Failed) attemptOutcome;
                                if (failed.getDiscardArtifacts()) {
                                    try {
                                        discardArtifacts(validatedRequest3.getPartialFile());
                                    } catch (IOException e) {
                                        return new LauncherApkDownloadResult.Failure(new LauncherApkDownloadError.Storage(e), i3);
                                    }
                                }
                                if (!failed.getRetryable() || i3 >= this.retryPolicy.getMaxAttempts()) {
                                    return new LauncherApkDownloadResult.Failure(failed.getError(), i3);
                                }
                                ValidatedRequest validatedRequest4 = validatedRequest3;
                                int i9 = i3 + 1;
                                long delayBeforeAttempt = this.retryPolicy.delayBeforeAttempt(i9);
                                i8 = i4;
                                LauncherApkDownloadObserver launcherApkDownloadObserver4 = launcherApkDownloadObserver3;
                                int i10 = i3;
                                notifyRetry(launcherApkDownloadObserver4, new LauncherApkRetry(i10, i9, delayBeforeAttempt, failed.getError()));
                                Function2<Long, Continuation<? super Unit>, Object> function2 = this.retryDelay;
                                Long boxLong = Boxing.boxLong(delayBeforeAttempt);
                                launcherApkDownloader$downloadOwned$1.L$0 = validatedRequest4;
                                launcherApkDownloader$downloadOwned$1.L$1 = launcherApkDownloadObserver4;
                                launcherApkDownloader$downloadOwned$1.L$2 = SpillingKt.nullOutSpilledVariable(partialPreparation);
                                launcherApkDownloader$downloadOwned$1.L$3 = SpillingKt.nullOutSpilledVariable(attemptOutcome);
                                launcherApkDownloader$downloadOwned$1.I$0 = i10;
                                launcherApkDownloader$downloadOwned$1.J$0 = j;
                                launcherApkDownloader$downloadOwned$1.I$1 = i9;
                                launcherApkDownloader$downloadOwned$1.J$1 = delayBeforeAttempt;
                                launcherApkDownloader$downloadOwned$1.label = 2;
                                if (function2.invoke(boxLong, launcherApkDownloader$downloadOwned$1) != coroutine_suspended) {
                                    launcherApkDownloadObserver2 = launcherApkDownloadObserver4;
                                    i2 = i9;
                                    validatedRequest2 = validatedRequest4;
                                    launcherApkDownloader$downloadOwned$12 = launcherApkDownloader$downloadOwned$1;
                                    i4 = i8;
                                    JobKt.ensureActive(launcherApkDownloader$downloadOwned$12.getContext());
                                    PartialPreparation preparePartial22 = preparePartial(validatedRequest2);
                                    boolean z22 = preparePartial22 instanceof PartialPreparation.Resume;
                                    if (z22) {
                                    }
                                    if (resume != null) {
                                    }
                                    if (z22) {
                                    }
                                    long j222 = committedBytes;
                                    notifyProgress(launcherApkDownloadObserver2, new LauncherApkProgress(j222, (resume2 != null || (metadata = resume2.getMetadata()) == null) ? validatedRequest2.getExpectedSizeBytes() : Boxing.boxLong(metadata.getTotalBytes()), i2, committedBytes > 0 ? i4 : 0));
                                    launcherApkDownloader$downloadOwned$12.L$0 = validatedRequest2;
                                    launcherApkDownloader$downloadOwned$12.L$1 = launcherApkDownloadObserver2;
                                    launcherApkDownloader$downloadOwned$12.L$2 = SpillingKt.nullOutSpilledVariable(preparePartial22);
                                    launcherApkDownloader$downloadOwned$12.L$3 = null;
                                    launcherApkDownloader$downloadOwned$12.I$0 = i2;
                                    launcherApkDownloader$downloadOwned$12.J$0 = j222;
                                    launcherApkDownloader$downloadOwned$12.label = i4;
                                    executeAttempt = executeAttempt(validatedRequest2, preparePartial22, i2, launcherApkDownloadObserver2, launcherApkDownloader$downloadOwned$12);
                                    if (executeAttempt != coroutine_suspended) {
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (IOException e2) {
                        return new LauncherApkDownloadResult.Failure(new LauncherApkDownloadError.Storage(e2), i2 - 1);
                    }
                    JobKt.ensureActive(launcherApkDownloader$downloadOwned$12.getContext());
                }
            }
        }
        launcherApkDownloader$downloadOwned$1 = new LauncherApkDownloader$downloadOwned$1(this, continuation);
        Object obj2 = launcherApkDownloader$downloadOwned$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = launcherApkDownloader$downloadOwned$1.label;
        int i42 = 1;
        if (i != 0) {
        }
    }

    private final PartialPreparation preparePartial(ValidatedRequest validatedRequest) {
        File parentFile = validatedRequest.getDestination().getParentFile();
        Intrinsics.checkNotNull(parentFile);
        ensureParentDirectory(parentFile);
        File partialFile = validatedRequest.getPartialFile();
        if (partialFile.exists() && isSymbolicLink(partialFile)) {
            discardArtifacts(partialFile);
        }
        LauncherApkResumeMetadata load = this.resumeStore.load(partialFile);
        if (!partialFile.isFile()) {
            this.resumeStore.delete(partialFile);
            return PartialPreparation.Fresh.INSTANCE;
        }
        if (load != null && load.matches(validatedRequest.getSourceUrl().toString(), validatedRequest.getExpectedSizeBytes(), validatedRequest.getExpectedSha256()) && load.getTotalBytes() <= this.maxApkBytes) {
            long totalBytes = load.getTotalBytes();
            Long expectedSizeBytes = validatedRequest.getExpectedSizeBytes();
            if (totalBytes == (expectedSizeBytes != null ? expectedSizeBytes.longValue() : load.getTotalBytes()) && partialFile.length() >= load.getCommittedBytes() && load != null && load.getCommittedBytes() != 0 && load.getCommittedBytes() != load.getTotalBytes()) {
                if (partialFile.length() > load.getCommittedBytes()) {
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(partialFile, "rw");
                        RandomAccessFile randomAccessFile2 = randomAccessFile;
                        randomAccessFile2.setLength(load.getCommittedBytes());
                        randomAccessFile2.getFD().sync();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(randomAccessFile, null);
                    } catch (IOException e) {
                        throw new IOException("Unable to roll partial launcher APK back to its checkpoint", e);
                    }
                }
                return new PartialPreparation.Resume(load);
            }
        }
        discardArtifacts(partialFile);
        return PartialPreparation.Fresh.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x009d -> B:19:0x00a4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeAttempt(ValidatedRequest validatedRequest, PartialPreparation partialPreparation, int i, LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super AttemptOutcome> continuation) {
        LauncherApkDownloader$executeAttempt$1 launcherApkDownloader$executeAttempt$1;
        int i2;
        ValidatedRequest validatedRequest2;
        PartialPreparation partialPreparation2;
        int i3;
        LauncherApkDownloadObserver launcherApkDownloadObserver2;
        LauncherApkDownloader$executeAttempt$1 launcherApkDownloader$executeAttempt$12;
        HttpUrl httpUrl;
        LinkedHashSet linkedSetOf;
        int i4;
        Object executeHop;
        if (continuation instanceof LauncherApkDownloader$executeAttempt$1) {
            launcherApkDownloader$executeAttempt$1 = (LauncherApkDownloader$executeAttempt$1) continuation;
            if ((launcherApkDownloader$executeAttempt$1.label & Integer.MIN_VALUE) != 0) {
                launcherApkDownloader$executeAttempt$1.label -= Integer.MIN_VALUE;
                Object obj = launcherApkDownloader$executeAttempt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = launcherApkDownloader$executeAttempt$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpUrl sourceUrl = validatedRequest.getSourceUrl();
                    validatedRequest2 = validatedRequest;
                    partialPreparation2 = partialPreparation;
                    i3 = i;
                    launcherApkDownloadObserver2 = launcherApkDownloadObserver;
                    launcherApkDownloader$executeAttempt$12 = launcherApkDownloader$executeAttempt$1;
                    httpUrl = sourceUrl;
                    linkedSetOf = SetsKt.linkedSetOf(sourceUrl.toString());
                    i4 = 0;
                    JobKt.ensureActive(launcherApkDownloader$executeAttempt$12.getContext());
                    Request buildNetworkRequest = buildNetworkRequest(httpUrl, partialPreparation2);
                    launcherApkDownloader$executeAttempt$12.L$0 = validatedRequest2;
                    launcherApkDownloader$executeAttempt$12.L$1 = partialPreparation2;
                    launcherApkDownloader$executeAttempt$12.L$2 = launcherApkDownloadObserver2;
                    launcherApkDownloader$executeAttempt$12.L$3 = httpUrl;
                    launcherApkDownloader$executeAttempt$12.L$4 = linkedSetOf;
                    launcherApkDownloader$executeAttempt$12.L$5 = SpillingKt.nullOutSpilledVariable(buildNetworkRequest);
                    launcherApkDownloader$executeAttempt$12.I$0 = i3;
                    launcherApkDownloader$executeAttempt$12.I$1 = i4;
                    launcherApkDownloader$executeAttempt$12.label = 1;
                    executeHop = executeHop(buildNetworkRequest, validatedRequest2, partialPreparation2, i3, launcherApkDownloadObserver2, launcherApkDownloader$executeAttempt$12);
                    if (executeHop != coroutine_suspended) {
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i4 = launcherApkDownloader$executeAttempt$1.I$1;
                    int i5 = launcherApkDownloader$executeAttempt$1.I$0;
                    Request request = (Request) launcherApkDownloader$executeAttempt$1.L$5;
                    LinkedHashSet linkedHashSet = (LinkedHashSet) launcherApkDownloader$executeAttempt$1.L$4;
                    HttpUrl httpUrl2 = (HttpUrl) launcherApkDownloader$executeAttempt$1.L$3;
                    ValidatedRequest validatedRequest3 = (ValidatedRequest) launcherApkDownloader$executeAttempt$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    launcherApkDownloader$executeAttempt$12 = launcherApkDownloader$executeAttempt$1;
                    LauncherApkDownloadObserver launcherApkDownloadObserver3 = (LauncherApkDownloadObserver) launcherApkDownloader$executeAttempt$1.L$2;
                    partialPreparation2 = (PartialPreparation) launcherApkDownloader$executeAttempt$1.L$1;
                    i3 = i5;
                    HopOutcome hopOutcome = (HopOutcome) obj;
                    if (hopOutcome instanceof HopOutcome.Terminal) {
                        if (!(hopOutcome instanceof HopOutcome.Redirect)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (i4 >= this.maxRedirects) {
                            return new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("redirect limit exceeded"), false, false);
                        }
                        HttpUrl resolve = httpUrl2.resolve(((HopOutcome.Redirect) hopOutcome).getLocation());
                        if (resolve == null) {
                            return new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("invalid redirect location"), false, false);
                        }
                        if (httpUrl2.isHttps() && !resolve.isHttps()) {
                            return new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("HTTPS downgrade rejected"), false, false);
                        }
                        if (!this.networkPolicy.isAllowed(resolve)) {
                            return new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("unsafe redirect target"), false, false);
                        }
                        if (linkedHashSet.add(resolve.toString())) {
                            i4++;
                            validatedRequest2 = validatedRequest3;
                            launcherApkDownloadObserver2 = launcherApkDownloadObserver3;
                            httpUrl = resolve;
                            linkedSetOf = linkedHashSet;
                            JobKt.ensureActive(launcherApkDownloader$executeAttempt$12.getContext());
                            Request buildNetworkRequest2 = buildNetworkRequest(httpUrl, partialPreparation2);
                            launcherApkDownloader$executeAttempt$12.L$0 = validatedRequest2;
                            launcherApkDownloader$executeAttempt$12.L$1 = partialPreparation2;
                            launcherApkDownloader$executeAttempt$12.L$2 = launcherApkDownloadObserver2;
                            launcherApkDownloader$executeAttempt$12.L$3 = httpUrl;
                            launcherApkDownloader$executeAttempt$12.L$4 = linkedSetOf;
                            launcherApkDownloader$executeAttempt$12.L$5 = SpillingKt.nullOutSpilledVariable(buildNetworkRequest2);
                            launcherApkDownloader$executeAttempt$12.I$0 = i3;
                            launcherApkDownloader$executeAttempt$12.I$1 = i4;
                            launcherApkDownloader$executeAttempt$12.label = 1;
                            executeHop = executeHop(buildNetworkRequest2, validatedRequest2, partialPreparation2, i3, launcherApkDownloadObserver2, launcherApkDownloader$executeAttempt$12);
                            if (executeHop != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            linkedHashSet = linkedSetOf;
                            obj = executeHop;
                            ValidatedRequest validatedRequest4 = validatedRequest2;
                            httpUrl2 = httpUrl;
                            launcherApkDownloadObserver3 = launcherApkDownloadObserver2;
                            validatedRequest3 = validatedRequest4;
                            HopOutcome hopOutcome2 = (HopOutcome) obj;
                            if (hopOutcome2 instanceof HopOutcome.Terminal) {
                                return ((HopOutcome.Terminal) hopOutcome2).getOutcome();
                            }
                        } else {
                            return new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("redirect loop"), false, false);
                        }
                    }
                }
            }
        }
        launcherApkDownloader$executeAttempt$1 = new LauncherApkDownloader$executeAttempt$1(this, continuation);
        Object obj2 = launcherApkDownloader$executeAttempt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = launcherApkDownloader$executeAttempt$1.label;
        if (i2 != 0) {
        }
    }

    private final Request buildNetworkRequest(HttpUrl httpUrl, PartialPreparation partialPreparation) {
        Request.Builder header = new Request.Builder().url(httpUrl).get().header("Cache-Control", "no-cache").header("Accept-Encoding", "identity");
        PartialPreparation.Resume resume = partialPreparation instanceof PartialPreparation.Resume ? (PartialPreparation.Resume) partialPreparation : null;
        if (resume != null) {
            header.header("Range", "bytes=" + resume.getMetadata().getCommittedBytes() + Constants.FILENAME_SEQUENCE_SEPARATOR);
            header.header("If-Range", resume.getMetadata().getValidatorValue());
        }
        return header.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeHop(Request request, final ValidatedRequest validatedRequest, final PartialPreparation partialPreparation, final int i, final LauncherApkDownloadObserver launcherApkDownloadObserver, Continuation<? super HopOutcome> continuation) {
        LauncherApkDownloader$executeHop$1 launcherApkDownloader$executeHop$1;
        LauncherApkDownloader$executeHop$1 launcherApkDownloader$executeHop$12;
        Object coroutine_suspended;
        int i2;
        Request request2;
        ValidatedRequest validatedRequest2;
        PartialPreparation partialPreparation2;
        int i3;
        LauncherApkDownloadObserver launcherApkDownloadObserver2;
        CompletableDeferred completableDeferred;
        Call call;
        Object result;
        if (continuation instanceof LauncherApkDownloader$executeHop$1) {
            launcherApkDownloader$executeHop$1 = (LauncherApkDownloader$executeHop$1) continuation;
            if ((launcherApkDownloader$executeHop$1.label & Integer.MIN_VALUE) != 0) {
                launcherApkDownloader$executeHop$1.label -= Integer.MIN_VALUE;
                launcherApkDownloader$executeHop$12 = launcherApkDownloader$executeHop$1;
                Object obj = launcherApkDownloader$executeHop$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = launcherApkDownloader$executeHop$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    request2 = request;
                    final Call newCall = this.client.newCall(request2);
                    try {
                        Result.Companion companion = Result.Companion;
                        LauncherApkDownloader launcherApkDownloader = this;
                        this.onCallCreated.invoke(newCall);
                        Result.m9916constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m9916constructorimpl(ResultKt.createFailure(th));
                    }
                    final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    try {
                        launcherApkDownloader$executeHop$12.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                        launcherApkDownloader$executeHop$12.L$1 = validatedRequest;
                        launcherApkDownloader$executeHop$12.L$2 = partialPreparation;
                        launcherApkDownloader$executeHop$12.L$3 = launcherApkDownloadObserver;
                        launcherApkDownloader$executeHop$12.L$4 = newCall;
                        launcherApkDownloader$executeHop$12.L$5 = CompletableDeferred$default;
                        launcherApkDownloader$executeHop$12.I$0 = i;
                        launcherApkDownloader$executeHop$12.label = 1;
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(launcherApkDownloader$executeHop$12), 1);
                        cancellableContinuationImpl.initCancellability();
                        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloader$executeHop$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                invoke2(th2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th2) {
                                Call.this.cancel();
                            }
                        });
                        try {
                            newCall.enqueue(new Callback() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloader$executeHop$3$2
                                @Override // okhttp3.Callback
                                public void onFailure(Call call2, IOException error) {
                                    LauncherApkDownloader.AttemptOutcome.Failed attemptFailure;
                                    Intrinsics.checkNotNullParameter(call2, "call");
                                    Intrinsics.checkNotNullParameter(error, "error");
                                    try {
                                        if (cancellableContinuationImpl2.isActive()) {
                                            Result.Companion companion3 = Result.Companion;
                                            attemptFailure = this.toAttemptFailure(error);
                                            cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(new LauncherApkDownloader.HopOutcome.Terminal(attemptFailure)));
                                        }
                                    } finally {
                                        CompletableDeferred$default.complete(Unit.INSTANCE);
                                    }
                                }

                                @Override // okhttp3.Callback
                                public void onResponse(final Call call2, Response response) {
                                    LauncherApkDownloader.AttemptOutcome.Failed attemptFailure;
                                    LauncherApkDownloader.HopOutcome consumeResponse;
                                    Intrinsics.checkNotNullParameter(call2, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    try {
                                        try {
                                            try {
                                                Response response2 = response;
                                                final CancellableContinuation<LauncherApkDownloader.HopOutcome> cancellableContinuation = cancellableContinuationImpl2;
                                                LauncherApkDownloader launcherApkDownloader2 = this;
                                                LauncherApkDownloader.ValidatedRequest validatedRequest3 = validatedRequest;
                                                LauncherApkDownloader.PartialPreparation partialPreparation3 = partialPreparation;
                                                int i4 = i;
                                                LauncherApkDownloadObserver launcherApkDownloadObserver3 = launcherApkDownloadObserver;
                                                try {
                                                    Response response3 = response2;
                                                    if (cancellableContinuation.isActive()) {
                                                        consumeResponse = launcherApkDownloader2.consumeResponse(response3, validatedRequest3, partialPreparation3, i4, launcherApkDownloadObserver3, new Function0<Boolean>() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloader$executeHop$3$2$onResponse$outcome$1$1
                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Boolean invoke() {
                                                                return Boolean.valueOf(cancellableContinuation.isActive() && !call2.isCanceled());
                                                            }
                                                        });
                                                        CloseableKt.closeFinally(response2, null);
                                                        if (cancellableContinuationImpl2.isActive()) {
                                                            Result.Companion companion3 = Result.Companion;
                                                            cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(consumeResponse));
                                                        }
                                                        CompletableDeferred$default.complete(Unit.INSTANCE);
                                                        return;
                                                    }
                                                    throw new CancellationException("Launcher APK download cancelled");
                                                } finally {
                                                }
                                            } catch (CancellationException unused) {
                                                CompletableDeferred$default.complete(Unit.INSTANCE);
                                            } catch (RuntimeException e) {
                                                if (cancellableContinuationImpl2.isActive()) {
                                                    Result.Companion companion4 = Result.Companion;
                                                    cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(new LauncherApkDownloader.HopOutcome.Terminal(new LauncherApkDownloader.AttemptOutcome.Failed(new LauncherApkDownloadError.Storage(new IOException("Unexpected launcher APK transport failure", e)), false, false))));
                                                }
                                                CompletableDeferred$default.complete(Unit.INSTANCE);
                                            }
                                        } catch (LauncherApkDownloader.LauncherApkStorageException e2) {
                                            if (cancellableContinuationImpl2.isActive()) {
                                                Result.Companion companion5 = Result.Companion;
                                                cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(new LauncherApkDownloader.HopOutcome.Terminal(new LauncherApkDownloader.AttemptOutcome.Failed(new LauncherApkDownloadError.Storage(e2.getIoCause()), false, false))));
                                            }
                                            CompletableDeferred$default.complete(Unit.INSTANCE);
                                        } catch (LauncherApkDownloader.PayloadIntegrityException e3) {
                                            if (cancellableContinuationImpl2.isActive()) {
                                                CancellableContinuation<LauncherApkDownloader.HopOutcome> cancellableContinuation2 = cancellableContinuationImpl2;
                                                String message = e3.getMessage();
                                                if (message == null) {
                                                    message = "invalid APK payload";
                                                }
                                                LauncherApkDownloader.HopOutcome.Terminal terminal = new LauncherApkDownloader.HopOutcome.Terminal(new LauncherApkDownloader.AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity(message), true, true));
                                                Result.Companion companion6 = Result.Companion;
                                                cancellableContinuation2.resumeWith(Result.m9916constructorimpl(terminal));
                                            }
                                            CompletableDeferred$default.complete(Unit.INSTANCE);
                                        } catch (IOException e4) {
                                            if (cancellableContinuationImpl2.isActive()) {
                                                Result.Companion companion7 = Result.Companion;
                                                attemptFailure = this.toAttemptFailure(e4);
                                                cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(new LauncherApkDownloader.HopOutcome.Terminal(attemptFailure)));
                                            }
                                            CompletableDeferred$default.complete(Unit.INSTANCE);
                                        }
                                    } catch (Throwable th2) {
                                        CompletableDeferred$default.complete(Unit.INSTANCE);
                                        throw th2;
                                    }
                                }
                            });
                        } catch (RuntimeException e) {
                            CompletableDeferred$default.complete(Unit.INSTANCE);
                            if (cancellableContinuationImpl2.isActive()) {
                                Result.Companion companion3 = Result.Companion;
                                cancellableContinuationImpl2.resumeWith(Result.m9916constructorimpl(new HopOutcome.Terminal(new AttemptOutcome.Failed(new LauncherApkDownloadError.Network(new IOException("Unable to enqueue launcher APK request", e)), true, false))));
                            }
                        }
                        result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(launcherApkDownloader$executeHop$12);
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        validatedRequest2 = validatedRequest;
                        partialPreparation2 = partialPreparation;
                        i3 = i;
                        launcherApkDownloadObserver2 = launcherApkDownloadObserver;
                        completableDeferred = CompletableDeferred$default;
                        call = newCall;
                    }
                    return result == coroutine_suspended ? coroutine_suspended : result;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = launcherApkDownloader$executeHop$12.I$0;
                    CancellationException cancellationException = (CancellationException) launcherApkDownloader$executeHop$12.L$6;
                    CompletableDeferred completableDeferred2 = (CompletableDeferred) launcherApkDownloader$executeHop$12.L$5;
                    Call call2 = (Call) launcherApkDownloader$executeHop$12.L$4;
                    LauncherApkDownloadObserver launcherApkDownloadObserver3 = (LauncherApkDownloadObserver) launcherApkDownloader$executeHop$12.L$3;
                    PartialPreparation partialPreparation3 = (PartialPreparation) launcherApkDownloader$executeHop$12.L$2;
                    ValidatedRequest validatedRequest3 = (ValidatedRequest) launcherApkDownloader$executeHop$12.L$1;
                    Request request3 = (Request) launcherApkDownloader$executeHop$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw cancellationException;
                } else {
                    i3 = launcherApkDownloader$executeHop$12.I$0;
                    completableDeferred = (CompletableDeferred) launcherApkDownloader$executeHop$12.L$5;
                    call = (Call) launcherApkDownloader$executeHop$12.L$4;
                    launcherApkDownloadObserver2 = (LauncherApkDownloadObserver) launcherApkDownloader$executeHop$12.L$3;
                    partialPreparation2 = (PartialPreparation) launcherApkDownloader$executeHop$12.L$2;
                    validatedRequest2 = (ValidatedRequest) launcherApkDownloader$executeHop$12.L$1;
                    Request request4 = (Request) launcherApkDownloader$executeHop$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } catch (CancellationException e3) {
                        e = e3;
                        request2 = request4;
                    }
                }
                call.cancel();
                launcherApkDownloader$executeHop$12.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                launcherApkDownloader$executeHop$12.L$1 = SpillingKt.nullOutSpilledVariable(validatedRequest2);
                launcherApkDownloader$executeHop$12.L$2 = SpillingKt.nullOutSpilledVariable(partialPreparation2);
                launcherApkDownloader$executeHop$12.L$3 = SpillingKt.nullOutSpilledVariable(launcherApkDownloadObserver2);
                launcherApkDownloader$executeHop$12.L$4 = SpillingKt.nullOutSpilledVariable(call);
                launcherApkDownloader$executeHop$12.L$5 = SpillingKt.nullOutSpilledVariable(completableDeferred);
                launcherApkDownloader$executeHop$12.L$6 = e;
                launcherApkDownloader$executeHop$12.I$0 = i3;
                launcherApkDownloader$executeHop$12.label = 2;
                if (BuildersKt.withContext(NonCancellable.INSTANCE, new LauncherApkDownloader$executeHop$4(completableDeferred, null), launcherApkDownloader$executeHop$12) != coroutine_suspended) {
                    throw e;
                }
            }
        }
        launcherApkDownloader$executeHop$1 = new LauncherApkDownloader$executeHop$1(this, continuation);
        launcherApkDownloader$executeHop$12 = launcherApkDownloader$executeHop$1;
        Object obj2 = launcherApkDownloader$executeHop$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = launcherApkDownloader$executeHop$12.label;
        if (i2 != 0) {
        }
        call.cancel();
        launcherApkDownloader$executeHop$12.L$0 = SpillingKt.nullOutSpilledVariable(request2);
        launcherApkDownloader$executeHop$12.L$1 = SpillingKt.nullOutSpilledVariable(validatedRequest2);
        launcherApkDownloader$executeHop$12.L$2 = SpillingKt.nullOutSpilledVariable(partialPreparation2);
        launcherApkDownloader$executeHop$12.L$3 = SpillingKt.nullOutSpilledVariable(launcherApkDownloadObserver2);
        launcherApkDownloader$executeHop$12.L$4 = SpillingKt.nullOutSpilledVariable(call);
        launcherApkDownloader$executeHop$12.L$5 = SpillingKt.nullOutSpilledVariable(completableDeferred);
        launcherApkDownloader$executeHop$12.L$6 = e;
        launcherApkDownloader$executeHop$12.I$0 = i3;
        launcherApkDownloader$executeHop$12.label = 2;
        if (BuildersKt.withContext(NonCancellable.INSTANCE, new LauncherApkDownloader$executeHop$4(completableDeferred, null), launcherApkDownloader$executeHop$12) != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HopOutcome consumeResponse(Response response, ValidatedRequest validatedRequest, PartialPreparation partialPreparation, int i, LauncherApkDownloadObserver launcherApkDownloadObserver, Function0<Boolean> function0) {
        AttemptOutcome consumeResumeResponse;
        if (REDIRECT_STATUSES.contains(Integer.valueOf(response.code()))) {
            String header$default = Response.header$default(response, "Location", null, 2, null);
            if (header$default == null) {
                return new HopOutcome.Terminal(new AttemptOutcome.Failed(new LauncherApkDownloadError.RedirectRejected("redirect has no Location header"), false, false));
            }
            return new HopOutcome.Redirect(header$default);
        } else if (!this.networkPolicy.isAllowed(response.request().url())) {
            return new HopOutcome.Terminal(new AttemptOutcome.Failed(new LauncherApkDownloadError.UnsafeUrl(response.request().url().toString()), false, false));
        } else {
            String header$default2 = Response.header$default(response, "Content-Encoding", null, 2, null);
            if (header$default2 != null && !StringsKt.equals(header$default2, "identity", true)) {
                return new HopOutcome.Terminal(new AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity("unsupported Content-Encoding: " + header$default2), false, true));
            }
            if (Intrinsics.areEqual(partialPreparation, PartialPreparation.Fresh.INSTANCE)) {
                consumeResumeResponse = consumeFreshResponse(response, validatedRequest, i, launcherApkDownloadObserver, function0);
            } else if (!(partialPreparation instanceof PartialPreparation.Resume)) {
                throw new NoWhenBranchMatchedException();
            } else {
                consumeResumeResponse = consumeResumeResponse(response, validatedRequest, ((PartialPreparation.Resume) partialPreparation).getMetadata(), i, launcherApkDownloadObserver, function0);
            }
            return new HopOutcome.Terminal(consumeResumeResponse);
        }
    }

    private final AttemptOutcome consumeFreshResponse(Response response, ValidatedRequest validatedRequest, int i, LauncherApkDownloadObserver launcherApkDownloadObserver, Function0<Boolean> function0) {
        LauncherApkDownloader launcherApkDownloader;
        if (response.code() != 200) {
            return toHttpFailure(response);
        }
        Long valueOf = Long.valueOf(response.body().contentLength());
        if (valueOf.longValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            launcherApkDownloader = this;
            if (valueOf.longValue() > launcherApkDownloader.maxApkBytes) {
                return new AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity("launcher APK exceeds the configured size limit"), false, true);
            }
        } else {
            launcherApkDownloader = this;
        }
        if (validatedRequest.getExpectedSizeBytes() != null && valueOf != null && !Intrinsics.areEqual(validatedRequest.getExpectedSizeBytes(), valueOf)) {
            return new AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity("launcher APK Content-Length differs from expected size"), true, true);
        }
        Long expectedSizeBytes = validatedRequest.getExpectedSizeBytes();
        Long l = expectedSizeBytes == null ? valueOf : expectedSizeBytes;
        ResumeValidator resumeValidator = resumeValidator(response);
        return launcherApkDownloader.writeAndCommit(response, validatedRequest, 0L, l, (l == null || resumeValidator == null) ? null : new LauncherApkResumeMetadata(validatedRequest.getSourceUrl().toString(), l.longValue(), 0L, resumeValidator.getKind(), resumeValidator.getValue(), validatedRequest.getExpectedSizeBytes(), validatedRequest.getExpectedSha256()), i, launcherApkDownloadObserver, function0);
    }

    private final AttemptOutcome consumeResumeResponse(Response response, ValidatedRequest validatedRequest, LauncherApkResumeMetadata launcherApkResumeMetadata, int i, LauncherApkDownloadObserver launcherApkDownloadObserver, Function0<Boolean> function0) {
        ParsedContentRange parseContentRange;
        if (response.code() == 200) {
            try {
                discardArtifacts(validatedRequest.getPartialFile());
                return consumeFreshResponse(response, validatedRequest, i, launcherApkDownloadObserver, function0);
            } catch (IOException e) {
                return new AttemptOutcome.Failed(new LauncherApkDownloadError.Storage(e), false, false);
            }
        } else if (response.code() == 416) {
            return new AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity("saved APK range was rejected"), true, true);
        } else {
            if (response.code() != 206) {
                return toHttpFailure(response);
            }
            String header$default = Response.header$default(response, "Content-Range", null, 2, null);
            if (header$default == null || (parseContentRange = Companion.parseContentRange(header$default)) == null) {
                return invalidResume("missing or malformed Content-Range");
            }
            if (parseContentRange.getStart() != launcherApkResumeMetadata.getCommittedBytes() || parseContentRange.getEnd() != launcherApkResumeMetadata.getTotalBytes() - 1 || parseContentRange.getTotal() != launcherApkResumeMetadata.getTotalBytes()) {
                return invalidResume("Content-Range does not match the saved APK checkpoint");
            }
            Long valueOf = Long.valueOf(response.body().contentLength());
            Long l = valueOf.longValue() >= 0 ? valueOf : null;
            long totalBytes = launcherApkResumeMetadata.getTotalBytes() - launcherApkResumeMetadata.getCommittedBytes();
            if (l != null && l.longValue() != totalBytes) {
                return invalidResume("partial response length does not match Content-Range");
            }
            if (!Intrinsics.areEqual(validatorValue(response, launcherApkResumeMetadata.getValidatorKind()), launcherApkResumeMetadata.getValidatorValue())) {
                return invalidResume("APK representation validator changed");
            }
            return writeAndCommit(response, validatedRequest, launcherApkResumeMetadata.getCommittedBytes(), Long.valueOf(launcherApkResumeMetadata.getTotalBytes()), launcherApkResumeMetadata, i, launcherApkDownloadObserver, function0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0263  */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object, java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AttemptOutcome writeAndCommit(Response response, ValidatedRequest validatedRequest, long j, Long l, LauncherApkResumeMetadata launcherApkResumeMetadata, int i, LauncherApkDownloadObserver launcherApkDownloadObserver, Function0<Boolean> function0) {
        ValidatedRequest validatedRequest2;
        LauncherApkResumeMetadata launcherApkResumeMetadata2;
        Throwable th;
        long j2;
        try {
            try {
                try {
                    try {
                        validatedRequest2 = validatedRequest.getDestination().getParentFile();
                        Intrinsics.checkNotNull(validatedRequest2);
                        ensureParentDirectory(validatedRequest2);
                    } catch (IOException e) {
                        validatedRequest2 = validatedRequest;
                        try {
                            throw new LauncherApkStorageException(e);
                        } catch (LauncherApkNetworkException e2) {
                            e = e2;
                            launcherApkResumeMetadata2 = launcherApkResumeMetadata;
                            if (launcherApkResumeMetadata2 == null) {
                                discardArtifactsQuietly(validatedRequest2.getPartialFile());
                            }
                            throw e.getIoCause();
                        } catch (CancellationException e3) {
                            e = e3;
                            launcherApkResumeMetadata2 = launcherApkResumeMetadata;
                            if (launcherApkResumeMetadata2 == null) {
                                discardArtifactsQuietly(validatedRequest2.getPartialFile());
                            }
                            throw e;
                        }
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(validatedRequest.getPartialFile(), "rw");
                        try {
                            RandomAccessFile randomAccessFile2 = randomAccessFile;
                            long j3 = 0;
                            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                            if (i2 == 0) {
                                randomAccessFile2.setLength(0L);
                                try {
                                    this.resumeStore.delete(validatedRequest.getPartialFile());
                                } catch (IOException e4) {
                                    throw new LauncherApkStorageException(e4);
                                }
                            } else if (randomAccessFile2.length() != j) {
                                try {
                                    throw new PayloadIntegrityException("partial APK length differs from its committed checkpoint");
                                } catch (Throwable th2) {
                                    th = th2;
                                    th = th;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(randomAccessFile, th);
                                        throw th3;
                                    }
                                }
                            }
                            randomAccessFile2.seek(j);
                            if (launcherApkResumeMetadata != null && i2 == 0) {
                                syncOutput(randomAccessFile2);
                                saveResumeMetadata(validatedRequest.getPartialFile(), launcherApkResumeMetadata);
                            }
                            byte[] bArr = new byte[65536];
                            InputStream byteStream = response.body().byteStream();
                            long j4 = j;
                            long j5 = j4;
                            launcherApkResumeMetadata2 = launcherApkResumeMetadata;
                            while (function0.invoke().booleanValue()) {
                                try {
                                    try {
                                        try {
                                            int read = byteStream.read(bArr);
                                            if (read < 0) {
                                                long j6 = j3;
                                                if (l != null && j4 != l.longValue()) {
                                                    throw new EOFException("launcher APK ended at " + j4 + " bytes, expected " + l);
                                                }
                                                if (j4 <= j6) {
                                                    throw new PayloadIntegrityException("launcher APK response was empty");
                                                }
                                                syncOutput(randomAccessFile2);
                                                if (launcherApkResumeMetadata2 != null) {
                                                    LauncherApkResumeMetadata copy$default = LauncherApkResumeMetadata.copy$default(launcherApkResumeMetadata2, null, 0L, j4, null, null, null, null, 123, null);
                                                    saveResumeMetadata(validatedRequest.getPartialFile(), copy$default);
                                                    launcherApkResumeMetadata2 = copy$default;
                                                }
                                                Unit unit = Unit.INSTANCE;
                                                try {
                                                    CloseableKt.closeFinally(randomAccessFile, null);
                                                    ensureTransferActive(function0);
                                                    verifyCompletedPayload(validatedRequest, function0);
                                                    ensureTransferActive(function0);
                                                    try {
                                                        this.resumeStore.delete(validatedRequest.getPartialFile());
                                                        ensureTransferActive(function0);
                                                        this.fileOps.atomicReplace(validatedRequest.getPartialFile(), validatedRequest.getDestination());
                                                        LauncherApkFileOps launcherApkFileOps = this.fileOps;
                                                        File parentFile = validatedRequest.getDestination().getParentFile();
                                                        Intrinsics.checkNotNull(parentFile);
                                                        launcherApkFileOps.syncDirectory(parentFile);
                                                        return new AttemptOutcome.Completed(validatedRequest.getDestination().length(), j);
                                                    } catch (IOException e5) {
                                                        throw new LauncherApkStorageException(e5);
                                                    }
                                                } catch (LauncherApkNetworkException e6) {
                                                    e = e6;
                                                    validatedRequest2 = validatedRequest;
                                                    if (launcherApkResumeMetadata2 == null) {
                                                    }
                                                    throw e.getIoCause();
                                                } catch (CancellationException e7) {
                                                    e = e7;
                                                    validatedRequest2 = validatedRequest;
                                                    if (launcherApkResumeMetadata2 == null) {
                                                    }
                                                    throw e;
                                                }
                                            } else if (read != 0) {
                                                if (l != null) {
                                                    j2 = j3;
                                                    if (read > l.longValue() - j4) {
                                                        throw new PayloadIntegrityException("launcher APK response exceeded its size");
                                                    }
                                                } else {
                                                    j2 = j3;
                                                }
                                                long j7 = read;
                                                if (j7 > this.maxApkBytes - j4) {
                                                    throw new PayloadIntegrityException("launcher APK exceeds the configured size limit");
                                                }
                                                try {
                                                    randomAccessFile2.write(bArr, 0, read);
                                                    long j8 = j4 + j7;
                                                    byte[] bArr2 = bArr;
                                                    InputStream inputStream = byteStream;
                                                    notifyProgress(launcherApkDownloadObserver, new LauncherApkProgress(j8, l, i, i2 > 0));
                                                    if (launcherApkResumeMetadata2 == null || j8 - j5 < this.checkpointBytes) {
                                                        bArr = bArr2;
                                                        byteStream = inputStream;
                                                        j4 = j8;
                                                    } else {
                                                        syncOutput(randomAccessFile2);
                                                        LauncherApkResumeMetadata copy$default2 = LauncherApkResumeMetadata.copy$default(launcherApkResumeMetadata2, null, 0L, j8, null, null, null, null, 123, null);
                                                        try {
                                                            saveResumeMetadata(validatedRequest.getPartialFile(), copy$default2);
                                                            launcherApkResumeMetadata2 = copy$default2;
                                                            bArr = bArr2;
                                                            byteStream = inputStream;
                                                            j4 = j8;
                                                            j5 = j4;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            throw th;
                                                        }
                                                    }
                                                    j3 = j2;
                                                } catch (IOException e8) {
                                                    throw new LauncherApkStorageException(new IOException("Unable to write partial launcher APK", e8));
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            th = th;
                                            throw th;
                                        }
                                    } catch (IOException e9) {
                                        throw new LauncherApkNetworkException(e9);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    th = th;
                                    throw th;
                                }
                            }
                            throw new CancellationException("Launcher APK download cancelled");
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (LauncherApkNetworkException e10) {
                        e = e10;
                    } catch (CancellationException e11) {
                        e = e11;
                    }
                } catch (LauncherApkNetworkException e12) {
                    e = e12;
                    validatedRequest2 = validatedRequest;
                    launcherApkResumeMetadata2 = launcherApkResumeMetadata;
                    if (launcherApkResumeMetadata2 == null) {
                    }
                    throw e.getIoCause();
                } catch (CancellationException e13) {
                    e = e13;
                    validatedRequest2 = validatedRequest;
                    launcherApkResumeMetadata2 = launcherApkResumeMetadata;
                    if (launcherApkResumeMetadata2 == null) {
                    }
                    throw e;
                }
            } catch (LauncherApkStorageException e14) {
                throw e14;
            } catch (RuntimeException e15) {
                throw new LauncherApkStorageException(new IOException("Unable to complete launcher APK file transaction", e15));
            }
        } catch (PayloadIntegrityException e16) {
            throw e16;
        } catch (IOException e17) {
            throw new LauncherApkStorageException(new IOException("Unable to write partial launcher APK", e17));
        }
    }

    private final void verifyCompletedPayload(ValidatedRequest validatedRequest, Function0<Boolean> function0) {
        File partialFile = validatedRequest.getPartialFile();
        ensureTransferActive(function0);
        if (validatedRequest.getExpectedSizeBytes() != null) {
            long length = partialFile.length();
            Long expectedSizeBytes = validatedRequest.getExpectedSizeBytes();
            if (expectedSizeBytes == null || length != expectedSizeBytes.longValue()) {
                throw new PayloadIntegrityException("launcher APK size verification failed");
            }
        }
        byte[] bArr = APK_ZIP_MAGIC;
        byte[] bArr2 = new byte[bArr.length];
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(partialFile, "r");
            try {
                randomAccessFile.readFully(bArr2);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(randomAccessFile, null);
                if (!Arrays.equals(bArr2, bArr)) {
                    throw new PayloadIntegrityException("downloaded payload is not an APK ZIP");
                }
                String expectedSha256 = validatedRequest.getExpectedSha256();
                if (expectedSha256 == null) {
                    return;
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    FileInputStream fileInputStream = new FileInputStream(partialFile);
                    FileInputStream fileInputStream2 = fileInputStream;
                    byte[] bArr3 = new byte[65536];
                    while (true) {
                        ensureTransferActive(function0);
                        int read = fileInputStream2.read(bArr3);
                        if (read < 0) {
                            break;
                        } else if (read > 0) {
                            messageDigest.update(bArr3, 0, read);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    byte[] digest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                    if (!Intrinsics.areEqual(ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.updater.apk.LauncherApkDownloader$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LauncherApkDownloader.verifyCompletedPayload$lambda$2(((Byte) obj).byteValue());
                        }
                    }, 30, (Object) null), expectedSha256)) {
                        throw new PayloadIntegrityException("launcher APK SHA-256 verification failed");
                    }
                } catch (IOException e) {
                    throw new LauncherApkStorageException(new IOException("Unable to hash downloaded launcher APK", e));
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(randomAccessFile, th);
                    throw th2;
                }
            }
        } catch (PayloadIntegrityException e2) {
            throw e2;
        } catch (EOFException unused) {
            throw new PayloadIntegrityException("downloaded payload is not an APK ZIP");
        } catch (IOException e3) {
            throw new LauncherApkStorageException(new IOException("Unable to inspect downloaded launcher APK", e3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence verifyCompletedPayload$lambda$2(byte b) {
        String num = Integer.toString(b & 255, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return StringsKt.padStart(num, 2, '0');
    }

    private final void saveResumeMetadata(File file, LauncherApkResumeMetadata launcherApkResumeMetadata) {
        try {
            this.resumeStore.save(file, launcherApkResumeMetadata);
        } catch (IOException e) {
            throw new LauncherApkStorageException(e);
        }
    }

    private final void syncOutput(RandomAccessFile randomAccessFile) {
        try {
            randomAccessFile.getFD().sync();
        } catch (IOException e) {
            throw new LauncherApkStorageException(new IOException("Unable to sync partial launcher APK", e));
        }
    }

    private final void ensureTransferActive(Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            throw new CancellationException("Launcher APK download cancelled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValidatedRequest validateRequest(LauncherApkDownloadRequest launcherApkDownloadRequest) {
        String str;
        Boolean m9916constructorimpl;
        String obj;
        HttpUrl parse = HttpUrl.Companion.parse(launcherApkDownloadRequest.getUrl());
        if (parse == null) {
            return null;
        }
        Long expectedSizeBytes = launcherApkDownloadRequest.getExpectedSizeBytes();
        if (expectedSizeBytes != null) {
            long j = this.maxApkBytes;
            long longValue = expectedSizeBytes.longValue();
            if (1 > longValue || longValue > j) {
                return null;
            }
        }
        String expectedSha256 = launcherApkDownloadRequest.getExpectedSha256();
        if (expectedSha256 == null || (obj = StringsKt.trim((CharSequence) expectedSha256).toString()) == null) {
            str = null;
        } else {
            String lowerCase = obj.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            str = lowerCase;
        }
        if (str == null || SHA256_REGEX.matches(str)) {
            File absoluteFile = launcherApkDownloadRequest.getDestination().getAbsoluteFile();
            try {
                File parentFile = absoluteFile.getParentFile();
                if (parentFile != null) {
                    File canonicalFile = parentFile.getCanonicalFile();
                    if (canonicalFile != null) {
                        File file = new File(canonicalFile, absoluteFile.getName());
                        if (absoluteFile.exists()) {
                            try {
                                Result.Companion companion = Result.Companion;
                                LauncherApkDownloader launcherApkDownloader = this;
                                m9916constructorimpl = Result.m9916constructorimpl(Boolean.valueOf(!Intrinsics.areEqual(absoluteFile.getCanonicalPath(), file.getAbsolutePath())));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m9922isFailureimpl(m9916constructorimpl)) {
                                m9916constructorimpl = true;
                            }
                            if (((Boolean) m9916constructorimpl).booleanValue()) {
                                return null;
                            }
                        }
                        File parentFile2 = file.getParentFile();
                        if (parentFile2 == null) {
                            return null;
                        }
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (!StringsKt.isBlank(name) && !file.isDirectory()) {
                            File file2 = new File(parentFile2, file.getName() + PARTIAL_SUFFIX);
                            String path = file.getPath();
                            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                            return new ValidatedRequest(parse, file, file2, expectedSizeBytes, str, path);
                        }
                    }
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LauncherApkDownloadError invalidRequestError(LauncherApkDownloadRequest launcherApkDownloadRequest) {
        String str;
        if (HttpUrl.Companion.parse(launcherApkDownloadRequest.getUrl()) == null) {
            str = "launcher APK URL is invalid";
        } else if (launcherApkDownloadRequest.getExpectedSizeBytes() != null && launcherApkDownloadRequest.getExpectedSizeBytes().longValue() <= 0) {
            str = "expected APK size must be positive";
        } else if (launcherApkDownloadRequest.getExpectedSizeBytes() != null && launcherApkDownloadRequest.getExpectedSizeBytes().longValue() > this.maxApkBytes) {
            str = "expected APK size exceeds the configured limit";
        } else if (launcherApkDownloadRequest.getExpectedSha256() != null && !SHA256_REGEX.matches(StringsKt.trim((CharSequence) launcherApkDownloadRequest.getExpectedSha256()).toString())) {
            str = "expected APK SHA-256 must contain 64 hexadecimal characters";
        } else {
            str = "launcher APK destination is invalid";
        }
        return new LauncherApkDownloadError.InvalidRequest(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardNonResumablePartialQuietly(ValidatedRequest validatedRequest) {
        LauncherApkResumeMetadata load = this.resumeStore.load(validatedRequest.getPartialFile());
        if (load == null || !load.matches(validatedRequest.getSourceUrl().toString(), validatedRequest.getExpectedSizeBytes(), validatedRequest.getExpectedSha256()) || load.getCommittedBytes() <= 0 || !validatedRequest.getPartialFile().isFile() || validatedRequest.getPartialFile().length() < load.getCommittedBytes()) {
            discardArtifactsQuietly(validatedRequest.getPartialFile());
        }
    }

    private final void discardArtifacts(File file) {
        this.resumeStore.delete(file);
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete partial launcher APK");
        }
    }

    private final void discardArtifactsQuietly(File file) {
        try {
            Result.Companion companion = Result.Companion;
            LauncherApkDownloader launcherApkDownloader = this;
            discardArtifacts(file);
            Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void ensureParentDirectory(File file) {
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException("Unable to create launcher APK destination directory");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSymbolicLink(File file) {
        Boolean m9916constructorimpl;
        File parentFile;
        boolean z;
        File canonicalFile;
        try {
            Result.Companion companion = Result.Companion;
            LauncherApkDownloader launcherApkDownloader = this;
            parentFile = file.getParentFile();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        if (parentFile != null && (canonicalFile = parentFile.getCanonicalFile()) != null && Intrinsics.areEqual(file.getCanonicalPath(), new File(canonicalFile, file.getName()).getAbsolutePath())) {
            z = false;
            m9916constructorimpl = Result.m9916constructorimpl(Boolean.valueOf(z));
            if (Result.m9922isFailureimpl(m9916constructorimpl)) {
                m9916constructorimpl = true;
            }
            return ((Boolean) m9916constructorimpl).booleanValue();
        }
        z = true;
        m9916constructorimpl = Result.m9916constructorimpl(Boolean.valueOf(z));
        if (Result.m9922isFailureimpl(m9916constructorimpl)) {
        }
        return ((Boolean) m9916constructorimpl).booleanValue();
    }

    private final AttemptOutcome.Failed toHttpFailure(Response response) {
        int code;
        return new AttemptOutcome.Failed(new LauncherApkDownloadError.HttpStatus(response.code()), response.code() == 408 || response.code() == 425 || response.code() == 429 || (500 <= (code = response.code()) && code < 600), false);
    }

    private final AttemptOutcome.Failed invalidResume(String str) {
        return new AttemptOutcome.Failed(new LauncherApkDownloadError.Integrity(str), true, true);
    }

    private final ResumeValidator resumeValidator(Response response) {
        String str;
        String header$default = Response.header$default(response, "ETag", null, 2, null);
        String obj = header$default != null ? StringsKt.trim((CharSequence) header$default).toString() : null;
        if (obj != null) {
            String str2 = obj;
            if (StringsKt.startsWith$default((CharSequence) str2, '\"', false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) str2, '\"', false, 2, (Object) null) && !StringsKt.startsWith(obj, "W/", true)) {
                return new ResumeValidator(LauncherApkValidatorKind.STRONG_ETAG, obj);
            }
        }
        String header$default2 = Response.header$default(response, "Last-Modified", null, 2, null);
        if (header$default2 == null || (str = StringsKt.trim((CharSequence) header$default2).toString()) == null || str.length() <= 0) {
            str = null;
        }
        if (str != null) {
            return new ResumeValidator(LauncherApkValidatorKind.LAST_MODIFIED, str);
        }
        return null;
    }

    private final String validatorValue(Response response, LauncherApkValidatorKind launcherApkValidatorKind) {
        String obj;
        String obj2;
        int i = WhenMappings.$EnumSwitchMapping$0[launcherApkValidatorKind.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            String header$default = Response.header$default(response, "Last-Modified", null, 2, null);
            if (header$default == null || (obj2 = StringsKt.trim((CharSequence) header$default).toString()) == null || obj2.length() <= 0) {
                return null;
            }
            return obj2;
        }
        String header$default2 = Response.header$default(response, "ETag", null, 2, null);
        if (header$default2 != null && (obj = StringsKt.trim((CharSequence) header$default2).toString()) != null) {
            String str = obj;
            if (StringsKt.startsWith$default((CharSequence) str, '\"', false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) str, '\"', false, 2, (Object) null) && !StringsKt.startsWith(obj, "W/", true)) {
                return obj;
            }
        }
        return null;
    }

    private final LauncherApkDownloadError toDownloadError(IOException iOException) {
        String message;
        if ((iOException instanceof SocketTimeoutException) || ((iOException instanceof InterruptedIOException) && (message = iOException.getMessage()) != null && StringsKt.contains((CharSequence) message, (CharSequence) "timeout", true))) {
            return new LauncherApkDownloadError.Timeout(iOException);
        }
        return new LauncherApkDownloadError.Network(iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AttemptOutcome.Failed toAttemptFailure(IOException iOException) {
        if (iOException instanceof UnsafeLauncherApkUrlException) {
            return new AttemptOutcome.Failed(new LauncherApkDownloadError.UnsafeUrl(((UnsafeLauncherApkUrlException) iOException).getBlockedUrl()), false, false);
        }
        if (iOException instanceof UnsafeLauncherApkHostException) {
            return new AttemptOutcome.Failed(new LauncherApkDownloadError.UnsafeUrl(((UnsafeLauncherApkHostException) iOException).getBlockedHost()), false, false);
        }
        return new AttemptOutcome.Failed(toDownloadError(iOException), true, false);
    }

    private final void notifyProgress(LauncherApkDownloadObserver launcherApkDownloadObserver, LauncherApkProgress launcherApkProgress) {
        try {
            Result.Companion companion = Result.Companion;
            LauncherApkDownloader launcherApkDownloader = this;
            launcherApkDownloadObserver.onProgress(launcherApkProgress);
            Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void notifyRetry(LauncherApkDownloadObserver launcherApkDownloadObserver, LauncherApkRetry launcherApkRetry) {
        try {
            Result.Companion companion = Result.Companion;
            LauncherApkDownloader launcherApkDownloader = this;
            launcherApkDownloadObserver.onRetry(launcherApkRetry);
            Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;", "", "Fresh", "Resume", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation$Fresh;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation$Resume;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface PartialPreparation {

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ê\u0001\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation$Fresh;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;", "<init>", "()V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Fresh implements PartialPreparation {
            public static final int $stable = 0;
            public static final Fresh INSTANCE = new Fresh();

            private Fresh() {
            }
        }

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation$Resume;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PartialPreparation;", TtmlNode.TAG_METADATA, "Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;)V", "getMetadata", "()Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Resume implements PartialPreparation {
            public static final int $stable = LauncherApkResumeMetadata.$stable;
            private final LauncherApkResumeMetadata metadata;

            public static /* synthetic */ Resume copy$default(Resume resume, LauncherApkResumeMetadata launcherApkResumeMetadata, int i, Object obj) {
                if ((i & 1) != 0) {
                    launcherApkResumeMetadata = resume.metadata;
                }
                return resume.copy(launcherApkResumeMetadata);
            }

            public final LauncherApkResumeMetadata component1() {
                return this.metadata;
            }

            public final Resume copy(LauncherApkResumeMetadata metadata) {
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                return new Resume(metadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Resume) && Intrinsics.areEqual(this.metadata, ((Resume) obj).metadata);
            }

            public int hashCode() {
                return this.metadata.hashCode();
            }

            public String toString() {
                return "Resume(metadata=" + this.metadata + ")";
            }

            public Resume(LauncherApkResumeMetadata metadata) {
                Intrinsics.checkNotNullParameter(metadata, "metadata");
                this.metadata = metadata;
            }

            public final LauncherApkResumeMetadata getMetadata() {
                return this.metadata;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome;", "", "Redirect", "Terminal", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome$Redirect;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome$Terminal;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface HopOutcome {

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome$Redirect;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome;", FirebaseAnalytics.Param.LOCATION, "", "<init>", "(Ljava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Redirect implements HopOutcome {
            public static final int $stable = 0;
            private final String location;

            public static /* synthetic */ Redirect copy$default(Redirect redirect, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = redirect.location;
                }
                return redirect.copy(str);
            }

            public final String component1() {
                return this.location;
            }

            public final Redirect copy(String location) {
                Intrinsics.checkNotNullParameter(location, "location");
                return new Redirect(location);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Redirect) && Intrinsics.areEqual(this.location, ((Redirect) obj).location);
            }

            public int hashCode() {
                return this.location.hashCode();
            }

            public String toString() {
                return "Redirect(location=" + this.location + ")";
            }

            public Redirect(String location) {
                Intrinsics.checkNotNullParameter(location, "location");
                this.location = location;
            }

            public final String getLocation() {
                return this.location;
            }
        }

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome$Terminal;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$HopOutcome;", "outcome", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;)V", "getOutcome", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Terminal implements HopOutcome {
            public static final int $stable = 8;
            private final AttemptOutcome outcome;

            public static /* synthetic */ Terminal copy$default(Terminal terminal, AttemptOutcome attemptOutcome, int i, Object obj) {
                if ((i & 1) != 0) {
                    attemptOutcome = terminal.outcome;
                }
                return terminal.copy(attemptOutcome);
            }

            public final AttemptOutcome component1() {
                return this.outcome;
            }

            public final Terminal copy(AttemptOutcome outcome) {
                Intrinsics.checkNotNullParameter(outcome, "outcome");
                return new Terminal(outcome);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Terminal) && Intrinsics.areEqual(this.outcome, ((Terminal) obj).outcome);
            }

            public int hashCode() {
                return this.outcome.hashCode();
            }

            public String toString() {
                return "Terminal(outcome=" + this.outcome + ")";
            }

            public Terminal(AttemptOutcome outcome) {
                Intrinsics.checkNotNullParameter(outcome, "outcome");
                this.outcome = outcome;
            }

            public final AttemptOutcome getOutcome() {
                return this.outcome;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome$Completed;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome$Failed;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface AttemptOutcome {

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome$Completed;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "totalBytes", "", "resumedFromBytes", "<init>", "(JJ)V", "getTotalBytes", "()J", "getResumedFromBytes", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Completed implements AttemptOutcome {
            public static final int $stable = 0;
            private final long resumedFromBytes;
            private final long totalBytes;

            public static /* synthetic */ Completed copy$default(Completed completed, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = completed.totalBytes;
                }
                if ((i & 2) != 0) {
                    j2 = completed.resumedFromBytes;
                }
                return completed.copy(j, j2);
            }

            public final long component1() {
                return this.totalBytes;
            }

            public final long component2() {
                return this.resumedFromBytes;
            }

            public final Completed copy(long j, long j2) {
                return new Completed(j, j2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Completed) {
                    Completed completed = (Completed) obj;
                    return this.totalBytes == completed.totalBytes && this.resumedFromBytes == completed.resumedFromBytes;
                }
                return false;
            }

            public int hashCode() {
                return (Long.hashCode(this.totalBytes) * 31) + Long.hashCode(this.resumedFromBytes);
            }

            public String toString() {
                long j = this.totalBytes;
                return "Completed(totalBytes=" + j + ", resumedFromBytes=" + this.resumedFromBytes + ")";
            }

            public Completed(long j, long j2) {
                this.totalBytes = j;
                this.resumedFromBytes = j2;
            }

            public final long getTotalBytes() {
                return this.totalBytes;
            }

            public final long getResumedFromBytes() {
                return this.resumedFromBytes;
            }
        }

        /* compiled from: LauncherApkDownloader.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome$Failed;", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$AttemptOutcome;", "error", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "retryable", "", "discardArtifacts", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;ZZ)V", "getError", "()Lcom/arizona/launcher/updater/apk/LauncherApkDownloadError;", "getRetryable", "()Z", "getDiscardArtifacts", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements AttemptOutcome {
            public static final int $stable = 8;
            private final boolean discardArtifacts;
            private final LauncherApkDownloadError error;
            private final boolean retryable;

            public static /* synthetic */ Failed copy$default(Failed failed, LauncherApkDownloadError launcherApkDownloadError, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    launcherApkDownloadError = failed.error;
                }
                if ((i & 2) != 0) {
                    z = failed.retryable;
                }
                if ((i & 4) != 0) {
                    z2 = failed.discardArtifacts;
                }
                return failed.copy(launcherApkDownloadError, z, z2);
            }

            public final LauncherApkDownloadError component1() {
                return this.error;
            }

            public final boolean component2() {
                return this.retryable;
            }

            public final boolean component3() {
                return this.discardArtifacts;
            }

            public final Failed copy(LauncherApkDownloadError error, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Failed(error, z, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Failed) {
                    Failed failed = (Failed) obj;
                    return Intrinsics.areEqual(this.error, failed.error) && this.retryable == failed.retryable && this.discardArtifacts == failed.discardArtifacts;
                }
                return false;
            }

            public int hashCode() {
                return (((this.error.hashCode() * 31) + Boolean.hashCode(this.retryable)) * 31) + Boolean.hashCode(this.discardArtifacts);
            }

            public String toString() {
                LauncherApkDownloadError launcherApkDownloadError = this.error;
                boolean z = this.retryable;
                return "Failed(error=" + launcherApkDownloadError + ", retryable=" + z + ", discardArtifacts=" + this.discardArtifacts + ")";
            }

            public Failed(LauncherApkDownloadError error, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
                this.retryable = z;
                this.discardArtifacts = z2;
            }

            public final LauncherApkDownloadError getError() {
                return this.error;
            }

            public final boolean getRetryable() {
                return this.retryable;
            }

            public final boolean getDiscardArtifacts() {
                return this.discardArtifacts;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\nHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006'"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;", "", "sourceUrl", "Lokhttp3/HttpUrl;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "partialFile", "expectedSizeBytes", "", "expectedSha256", "", "destinationKey", "<init>", "(Lokhttp3/HttpUrl;Ljava/io/File;Ljava/io/File;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getSourceUrl", "()Lokhttp3/HttpUrl;", "getDestination", "()Ljava/io/File;", "getPartialFile", "getExpectedSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpectedSha256", "()Ljava/lang/String;", "getDestinationKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lokhttp3/HttpUrl;Ljava/io/File;Ljava/io/File;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ValidatedRequest;", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ValidatedRequest {
        private final File destination;
        private final String destinationKey;
        private final String expectedSha256;
        private final Long expectedSizeBytes;
        private final File partialFile;
        private final HttpUrl sourceUrl;

        public static /* synthetic */ ValidatedRequest copy$default(ValidatedRequest validatedRequest, HttpUrl httpUrl, File file, File file2, Long l, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                httpUrl = validatedRequest.sourceUrl;
            }
            if ((i & 2) != 0) {
                file = validatedRequest.destination;
            }
            if ((i & 4) != 0) {
                file2 = validatedRequest.partialFile;
            }
            if ((i & 8) != 0) {
                l = validatedRequest.expectedSizeBytes;
            }
            if ((i & 16) != 0) {
                str = validatedRequest.expectedSha256;
            }
            if ((i & 32) != 0) {
                str2 = validatedRequest.destinationKey;
            }
            String str3 = str;
            String str4 = str2;
            return validatedRequest.copy(httpUrl, file, file2, l, str3, str4);
        }

        public final HttpUrl component1() {
            return this.sourceUrl;
        }

        public final File component2() {
            return this.destination;
        }

        public final File component3() {
            return this.partialFile;
        }

        public final Long component4() {
            return this.expectedSizeBytes;
        }

        public final String component5() {
            return this.expectedSha256;
        }

        public final String component6() {
            return this.destinationKey;
        }

        public final ValidatedRequest copy(HttpUrl sourceUrl, File destination, File partialFile, Long l, String str, String destinationKey) {
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(partialFile, "partialFile");
            Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
            return new ValidatedRequest(sourceUrl, destination, partialFile, l, str, destinationKey);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ValidatedRequest) {
                ValidatedRequest validatedRequest = (ValidatedRequest) obj;
                return Intrinsics.areEqual(this.sourceUrl, validatedRequest.sourceUrl) && Intrinsics.areEqual(this.destination, validatedRequest.destination) && Intrinsics.areEqual(this.partialFile, validatedRequest.partialFile) && Intrinsics.areEqual(this.expectedSizeBytes, validatedRequest.expectedSizeBytes) && Intrinsics.areEqual(this.expectedSha256, validatedRequest.expectedSha256) && Intrinsics.areEqual(this.destinationKey, validatedRequest.destinationKey);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.sourceUrl.hashCode() * 31) + this.destination.hashCode()) * 31) + this.partialFile.hashCode()) * 31;
            Long l = this.expectedSizeBytes;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.expectedSha256;
            return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.destinationKey.hashCode();
        }

        public String toString() {
            HttpUrl httpUrl = this.sourceUrl;
            File file = this.destination;
            File file2 = this.partialFile;
            Long l = this.expectedSizeBytes;
            String str = this.expectedSha256;
            return "ValidatedRequest(sourceUrl=" + httpUrl + ", destination=" + file + ", partialFile=" + file2 + ", expectedSizeBytes=" + l + ", expectedSha256=" + str + ", destinationKey=" + this.destinationKey + ")";
        }

        public ValidatedRequest(HttpUrl sourceUrl, File destination, File partialFile, Long l, String str, String destinationKey) {
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            Intrinsics.checkNotNullParameter(destination, "destination");
            Intrinsics.checkNotNullParameter(partialFile, "partialFile");
            Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
            this.sourceUrl = sourceUrl;
            this.destination = destination;
            this.partialFile = partialFile;
            this.expectedSizeBytes = l;
            this.expectedSha256 = str;
            this.destinationKey = destinationKey;
        }

        public final HttpUrl getSourceUrl() {
            return this.sourceUrl;
        }

        public final File getDestination() {
            return this.destination;
        }

        public final File getPartialFile() {
            return this.partialFile;
        }

        public final Long getExpectedSizeBytes() {
            return this.expectedSizeBytes;
        }

        public final String getExpectedSha256() {
            return this.expectedSha256;
        }

        public final String getDestinationKey() {
            return this.destinationKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ResumeValidator;", "", "kind", "Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "value", "", "<init>", "(Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;Ljava/lang/String;)V", "getKind", "()Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResumeValidator {
        private final LauncherApkValidatorKind kind;
        private final String value;

        public static /* synthetic */ ResumeValidator copy$default(ResumeValidator resumeValidator, LauncherApkValidatorKind launcherApkValidatorKind, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                launcherApkValidatorKind = resumeValidator.kind;
            }
            if ((i & 2) != 0) {
                str = resumeValidator.value;
            }
            return resumeValidator.copy(launcherApkValidatorKind, str);
        }

        public final LauncherApkValidatorKind component1() {
            return this.kind;
        }

        public final String component2() {
            return this.value;
        }

        public final ResumeValidator copy(LauncherApkValidatorKind kind, String value) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(value, "value");
            return new ResumeValidator(kind, value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResumeValidator) {
                ResumeValidator resumeValidator = (ResumeValidator) obj;
                return this.kind == resumeValidator.kind && Intrinsics.areEqual(this.value, resumeValidator.value);
            }
            return false;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            LauncherApkValidatorKind launcherApkValidatorKind = this.kind;
            return "ResumeValidator(kind=" + launcherApkValidatorKind + ", value=" + this.value + ")";
        }

        public ResumeValidator(LauncherApkValidatorKind kind, String value) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(value, "value");
            this.kind = kind;
            this.value = value;
        }

        public final LauncherApkValidatorKind getKind() {
            return this.kind;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ParsedContentRange;", "", TtmlNode.START, "", TtmlNode.END, UpdateServiceContract.BundleKey.TOTAL, "<init>", "(JJJ)V", "getStart", "()J", "getEnd", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        public final long getStart() {
            return this.start;
        }

        public final long getEnd() {
            return this.end;
        }

        public final long getTotal() {
            return this.total;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$PayloadIntegrityException;", "Ljava/io/IOException;", "message", "", "<init>", "(Ljava/lang/String;)V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PayloadIntegrityException extends IOException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PayloadIntegrityException(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$LauncherApkStorageException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "ioCause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getIoCause", "()Ljava/io/IOException;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LauncherApkStorageException extends RuntimeException {
        private final IOException ioCause;

        public final IOException getIoCause() {
            return this.ioCause;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LauncherApkStorageException(IOException ioCause) {
            super(ioCause);
            Intrinsics.checkNotNullParameter(ioCause, "ioCause");
            this.ioCause = ioCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$LauncherApkNetworkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "ioCause", "Ljava/io/IOException;", "<init>", "(Ljava/io/IOException;)V", "getIoCause", "()Ljava/io/IOException;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LauncherApkNetworkException extends RuntimeException {
        private final IOException ioCause;

        public final IOException getIoCause() {
            return this.ioCause;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LauncherApkNetworkException(IOException ioCause) {
            super(ioCause);
            Intrinsics.checkNotNullParameter(ioCause, "ioCause");
            this.ioCause = ioCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LauncherApkDownloader.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$Companion;", "", "<init>", "()V", "DEFAULT_MAX_REDIRECTS", "", "DEFAULT_MAX_APK_BYTES", "", "DEFAULT_CHECKPOINT_BYTES", "READ_BUFFER_BYTES", "PARTIAL_SUFFIX", "", "HTTP_OK", "HTTP_PARTIAL", "HTTP_RANGE_NOT_SATISFIABLE", "HEADER_ACCEPT_ENCODING", "ACCEPT_ENCODING_IDENTITY", "HEADER_CACHE_CONTROL", "CACHE_CONTROL_NO_CACHE", "HEADER_CONTENT_ENCODING", "HEADER_CONTENT_RANGE", "HEADER_ETAG", "HEADER_IF_RANGE", "HEADER_LAST_MODIFIED", "HEADER_LOCATION", "HEADER_RANGE", "REDIRECT_STATUSES", "", "getREDIRECT_STATUSES", "()Ljava/util/Set;", "SHA256_REGEX", "Lkotlin/text/Regex;", "getSHA256_REGEX", "()Lkotlin/text/Regex;", "CONTENT_RANGE_REGEX", "getCONTENT_RANGE_REGEX", "APK_ZIP_MAGIC", "", "getAPK_ZIP_MAGIC", "()[B", "parseContentRange", "Lcom/arizona/launcher/updater/apk/LauncherApkDownloader$ParsedContentRange;", "value", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getREDIRECT_STATUSES() {
            return LauncherApkDownloader.REDIRECT_STATUSES;
        }

        public final Regex getSHA256_REGEX() {
            return LauncherApkDownloader.SHA256_REGEX;
        }

        public final Regex getCONTENT_RANGE_REGEX() {
            return LauncherApkDownloader.CONTENT_RANGE_REGEX;
        }

        public final byte[] getAPK_ZIP_MAGIC() {
            return LauncherApkDownloader.APK_ZIP_MAGIC;
        }

        public final ParsedContentRange parseContentRange(String value) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(value, "value");
            MatchResult matchEntire = getCONTENT_RANGE_REGEX().matchEntire(StringsKt.trim((CharSequence) value).toString());
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
    }
}
