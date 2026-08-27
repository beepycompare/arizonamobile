package com.arizona.launcher.updater.archive.download;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
/* compiled from: ArchiveResumableHttpEngine.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 I2\u00020\u0001:\u0005EFGHIB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J4\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J<\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J<\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002JD\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J,\u00105\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00106\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u0001022\b\u00108\u001a\u0004\u0018\u000102H\u0002J,\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u0001022\b\u00108\u001a\u0004\u0018\u000102H\u0002J\u0014\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u000102H\u0002J\u0014\u0010?\u001a\u0004\u0018\u0001022\b\u0010>\u001a\u0004\u0018\u000102H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010A\u001a\u00020DH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bK\u0012\b\bL\u0012\u0004\b\u0003\u0010\u0000¨\u0006J"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine;", "", "client", "Lokhttp3/OkHttpClient;", "resumeStore", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;", "allowInsecureLoopback", "", "forceEveryBytes", "", "progressMinIntervalMs", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Lokhttp3/OkHttpClient;Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;ZJJLcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "executeAttempt", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "request", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;", "session", "Lcom/arizona/launcher/updater/archive/download/ArchiveOwnedDownloadSession;", "allowInvalidResumeReset", "ensureActiveAtTaskStart", "Lkotlin/Function0;", "", "progress", "Lkotlin/Function1;", "prepareOwned", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation;", "normalizeOwnedResult", "startOffset", "result", "discardArtifactsOwned", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "runDownload", "preparation", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$Ready;", "consumeTerminalResponse", "response", "Lokhttp3/Response;", "consumeFreshResponse", "consumeResumeResponse", "validatorsMatch", "resumeRejected", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Failed;", "httpStatus", "", "detail", "", "writeBody", "expectedBodyBytes", "persistCommittedOffset", "committedOffset", "strongEtag", "lastModified", "buildRequest", "Lokhttp3/Request;", "url", "parseContentRange", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ParsedContentRange;", "raw", "strongEtagOrNull", "isCanceledIo", "error", "Ljava/io/IOException;", "isStorageFailure", "", "ResumePreparation", "ArtifactDiscardResult", "AttemptResult", "ParsedContentRange", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveResumableHttpEngine {
    @Deprecated
    public static final long DEFAULT_FORCE_EVERY_BYTES = 262144;
    @Deprecated
    public static final long DEFAULT_PROGRESS_INTERVAL_MS = 300;
    @Deprecated
    public static final int HTTP_CREATED = 201;
    @Deprecated
    public static final int HTTP_OK = 200;
    @Deprecated
    public static final int HTTP_PARTIAL_CONTENT = 206;
    @Deprecated
    public static final int HTTP_PRECONDITION_FAILED = 412;
    @Deprecated
    public static final int HTTP_RANGE_NOT_SATISFIABLE = 416;
    @Deprecated
    public static final int HTTP_RESET_CONTENT = 205;
    @Deprecated
    public static final int MAX_CAUSE_DEPTH = 8;
    @Deprecated
    public static final int READ_BUFFER_BYTES = 65536;
    private final boolean allowInsecureLoopback;
    private final OkHttpClient client;
    private final ArchiveDirectoryCreator directoryCreator;
    private final long forceEveryBytes;
    private final long progressMinIntervalMs;
    private final ArchiveDownloadResumeStore resumeStore;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<Integer> REDIRECT_HTTP_STATUSES = SetsKt.setOf((Object[]) new Integer[]{300, 301, 302, 303, 307, 308});
    private static final Regex CONTENT_RANGE = new Regex("bytes ([0-9]+)-([0-9]+)/([0-9]+)");

    public ArchiveResumableHttpEngine(OkHttpClient client, ArchiveDownloadResumeStore resumeStore, boolean z, long j, long j2, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(resumeStore, "resumeStore");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.client = client;
        this.resumeStore = resumeStore;
        this.allowInsecureLoopback = z;
        this.forceEveryBytes = j;
        this.progressMinIntervalMs = j2;
        this.directoryCreator = directoryCreator;
        if (j <= 0) {
            throw new IllegalArgumentException("forceEveryBytes must be positive".toString());
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("progressMinIntervalMs must be non-negative".toString());
        }
    }

    public /* synthetic */ ArchiveResumableHttpEngine(OkHttpClient okHttpClient, ArchiveDownloadResumeStore archiveDownloadResumeStore, boolean z, long j, long j2, ArchiveDirectoryCreator archiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(okHttpClient, archiveDownloadResumeStore, z, (i & 8) != 0 ? 262144L : j, (i & 16) != 0 ? 300L : j2, (i & 32) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : archiveDirectoryCreator);
    }

    public final AttemptResult executeAttempt(ArchiveDownloadRequest request, ArchiveOwnedDownloadSession session, boolean z, Function0<Unit> ensureActiveAtTaskStart, Function1<? super Long, Unit> progress) {
        AttemptResult.Failed failed;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(ensureActiveAtTaskStart, "ensureActiveAtTaskStart");
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (session.isCancellationRequested()) {
            return AttemptResult.Canceled.INSTANCE;
        }
        String destinationKey = ArchiveDownloadDestinationRegistry.INSTANCE.destinationKey(request.getDestination());
        try {
            if (ArchiveDownloadDestinationRegistry.INSTANCE.tryAcquire(destinationKey, session)) {
                try {
                    try {
                        try {
                            try {
                                ensureActiveAtTaskStart.invoke();
                            } catch (IOException e) {
                                if (!session.isCancellationRequested() && !isCanceledIo(e)) {
                                    failed = new AttemptResult.Failed(e, false, null, false, false, isStorageFailure(e), 30, null);
                                }
                                AttemptResult.Canceled canceled = AttemptResult.Canceled.INSTANCE;
                                ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
                                return canceled;
                            }
                        } catch (RuntimeException e2) {
                            failed = new AttemptResult.Failed(e2, false, null, false, false, false, 62, null);
                        }
                    } catch (InterruptedIOException e3) {
                        if (!session.isCancellationRequested() && !Thread.currentThread().isInterrupted() && !isCanceledIo(e3)) {
                            failed = new AttemptResult.Failed(e3, false, null, false, false, isStorageFailure(e3), 30, null);
                        }
                        AttemptResult.Canceled canceled2 = AttemptResult.Canceled.INSTANCE;
                        ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
                        return canceled2;
                    }
                    if (session.isCancellationRequested()) {
                        AttemptResult.Canceled canceled3 = AttemptResult.Canceled.INSTANCE;
                        ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
                        return canceled3;
                    }
                    ResumePreparation prepareOwned = prepareOwned(request);
                    if (prepareOwned instanceof ResumePreparation.Failed) {
                        failed = new AttemptResult.Failed(((ResumePreparation.Failed) prepareOwned).getCause(), false, null, false, true, ((ResumePreparation.Failed) prepareOwned).getStorageFailure(), 14, null);
                    } else if (Intrinsics.areEqual(prepareOwned, ResumePreparation.AlreadyComplete.INSTANCE)) {
                        progress.invoke(Long.valueOf(request.getExpectedSize()));
                        failed = AttemptResult.Completed.INSTANCE;
                    } else if (!(prepareOwned instanceof ResumePreparation.Ready)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        progress.invoke(Long.valueOf(RangesKt.coerceAtMost(((ResumePreparation.Ready) prepareOwned).getOffset(), request.getExpectedSize())));
                        failed = normalizeOwnedResult(request, ((ResumePreparation.Ready) prepareOwned).getOffset(), z, runDownload(request, (ResumePreparation.Ready) prepareOwned, session, progress));
                    }
                    ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
                    return failed;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    session.cancel();
                    AttemptResult.Canceled canceled4 = AttemptResult.Canceled.INSTANCE;
                    ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
                    return canceled4;
                }
            }
            return AttemptResult.SameDestinationBusy.INSTANCE;
        } catch (Throwable th) {
            ArchiveDownloadDestinationRegistry.INSTANCE.release(destinationKey, session);
            throw th;
        }
    }

    private final ResumePreparation prepareOwned(ArchiveDownloadRequest archiveDownloadRequest) {
        String lastModified;
        ArchiveDownloadResumeMetadata load = this.resumeStore.load(archiveDownloadRequest.getDestination());
        boolean isFile = archiveDownloadRequest.getDestination().isFile();
        if (load != null && load.isResumeCompatible(archiveDownloadRequest.getPackageId(), archiveDownloadRequest.getExpectedSize(), archiveDownloadRequest.getExpectedCrc32()) && isFile && archiveDownloadRequest.getDestination().length() >= load.getCommittedOffset() && archiveDownloadRequest.getDestination().length() <= archiveDownloadRequest.getExpectedSize()) {
            if (load.getCommittedOffset() == archiveDownloadRequest.getExpectedSize()) {
                return ResumePreparation.AlreadyComplete.INSTANCE;
            }
            String strongEtag = load.getStrongEtag();
            if ((strongEtag != null && !StringsKt.isBlank(strongEtag)) || ((lastModified = load.getLastModified()) != null && !StringsKt.isBlank(lastModified))) {
                return new ResumePreparation.Ready(load.getCommittedOffset(), load.getStrongEtag(), load.getLastModified());
            }
        }
        if (load == null && !isFile) {
            return new ResumePreparation.Ready(0L, null, null, 6, null);
        }
        ArtifactDiscardResult discardArtifactsOwned = discardArtifactsOwned(archiveDownloadRequest.getDestination());
        if (Intrinsics.areEqual(discardArtifactsOwned, ArtifactDiscardResult.Success.INSTANCE)) {
            return new ResumePreparation.Ready(0L, null, null, 6, null);
        }
        if (!(discardArtifactsOwned instanceof ArtifactDiscardResult.Failed)) {
            throw new NoWhenBranchMatchedException();
        }
        ArtifactDiscardResult.Failed failed = (ArtifactDiscardResult.Failed) discardArtifactsOwned;
        return new ResumePreparation.Failed(failed.getCause(), failed.getStorageFailure());
    }

    private final AttemptResult normalizeOwnedResult(ArchiveDownloadRequest archiveDownloadRequest, long j, boolean z, AttemptResult attemptResult) {
        if (attemptResult instanceof AttemptResult.Failed) {
            AttemptResult.Failed failed = (AttemptResult.Failed) attemptResult;
            if (failed.getContentLengthMismatch()) {
                ArtifactDiscardResult discardArtifactsOwned = discardArtifactsOwned(archiveDownloadRequest.getDestination());
                if (!Intrinsics.areEqual(discardArtifactsOwned, ArtifactDiscardResult.Success.INSTANCE)) {
                    if (!(discardArtifactsOwned instanceof ArtifactDiscardResult.Failed)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ArtifactDiscardResult.Failed failed2 = (ArtifactDiscardResult.Failed) discardArtifactsOwned;
                    return AttemptResult.Failed.copy$default(failed, new IOException("Unable to discard length-mismatched archive", failed2.getCause()), false, null, false, true, failed2.getStorageFailure(), 14, null);
                }
            } else if (j > 0 && failed.getResumeRejected() && z) {
                ArtifactDiscardResult discardArtifactsOwned2 = discardArtifactsOwned(archiveDownloadRequest.getDestination());
                if (Intrinsics.areEqual(discardArtifactsOwned2, ArtifactDiscardResult.Success.INSTANCE)) {
                    return AttemptResult.ResumeReset.INSTANCE;
                }
                if (!(discardArtifactsOwned2 instanceof ArtifactDiscardResult.Failed)) {
                    throw new NoWhenBranchMatchedException();
                }
                ArtifactDiscardResult.Failed failed3 = (ArtifactDiscardResult.Failed) discardArtifactsOwned2;
                return AttemptResult.Failed.copy$default(failed, new IOException("Unable to reset rejected archive resume", failed3.getCause()), false, null, false, true, failed3.getStorageFailure(), 14, null);
            }
        }
        return attemptResult;
    }

    private final ArtifactDiscardResult discardArtifactsOwned(File file) {
        try {
            this.resumeStore.delete(file);
            if (file.exists() && !file.delete() && file.exists()) {
                return new ArtifactDiscardResult.Failed(new IOException("Unable to delete archive partial"), false, 2, null);
            }
            return ArtifactDiscardResult.Success.INSTANCE;
        } catch (IOException e) {
            return new ArtifactDiscardResult.Failed(e, isStorageFailure(e));
        } catch (SecurityException e2) {
            return new ArtifactDiscardResult.Failed(new IOException("Unable to delete archive artifacts", e2), false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    private final AttemptResult runDownload(ArchiveDownloadRequest archiveDownloadRequest, ResumePreparation.Ready ready, ArchiveOwnedDownloadSession archiveOwnedDownloadSession, Function1<? super Long, Unit> function1) {
        Throwable th;
        String url = archiveDownloadRequest.getUrl();
        int i = 0;
        while (!archiveOwnedDownloadSession.isCancellationRequested() && !Thread.currentThread().isInterrupted()) {
            if (!ArchiveRemoteNetworkPolicy.INSTANCE.isAllowedUrl(url, this.allowInsecureLoopback)) {
                return new AttemptResult.Failed(new ArchiveSecurityException("unsafe archive download URL"), false, null, false, false, false, 62, null);
            }
            long offset = ready.getOffset();
            String strongEtag = ready.getStrongEtag();
            ArchiveOwnedDownloadSession lastModified = ready.getLastModified();
            Call newCall = this.client.newCall(buildRequest(url, offset, strongEtag, lastModified));
            archiveOwnedDownloadSession.attach(newCall);
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    Response execute = newCall.execute();
                    try {
                        Response response = execute;
                        if (!REDIRECT_HTTP_STATUSES.contains(Integer.valueOf(response.code()))) {
                            try {
                                AttemptResult consumeTerminalResponse = consumeTerminalResponse(archiveDownloadRequest, ready, response, function1, archiveOwnedDownloadSession);
                                CloseableKt.closeFinally(execute, null);
                                archiveOwnedDownloadSession.clearCall(newCall);
                                return consumeTerminalResponse;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            url = ArchiveRedirectPolicy.INSTANCE.resolve(response.request().url().toString(), Response.header$default(response, "Location", null, 2, null), i, this.allowInsecureLoopback);
                            if (url == null) {
                                AttemptResult.Failed failed = new AttemptResult.Failed(new ArchiveSecurityException("unsafe archive redirect or redirect limit exceeded"), false, null, false, false, false, 62, null);
                                CloseableKt.closeFinally(execute, null);
                                archiveOwnedDownloadSession.clearCall(newCall);
                                return failed;
                            }
                            i++;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(execute, null);
                            archiveOwnedDownloadSession.clearCall(newCall);
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                CloseableKt.closeFinally(execute, th);
                                throw th5;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException e) {
                    e = e;
                    if (!newCall.isCanceled() && !lastModified.isCancellationRequested() && !isCanceledIo(e)) {
                        throw e;
                    }
                    AttemptResult.Canceled canceled = AttemptResult.Canceled.INSTANCE;
                    lastModified.clearCall(newCall);
                    return canceled;
                }
            } catch (IOException e2) {
                e = e2;
                lastModified = archiveOwnedDownloadSession;
                if (!newCall.isCanceled()) {
                    throw e;
                }
                AttemptResult.Canceled canceled2 = AttemptResult.Canceled.INSTANCE;
                lastModified.clearCall(newCall);
                return canceled2;
            } catch (Throwable th7) {
                th = th7;
                lastModified = archiveOwnedDownloadSession;
                lastModified.clearCall(newCall);
                throw th;
            }
        }
        return AttemptResult.Canceled.INSTANCE;
    }

    private final AttemptResult consumeTerminalResponse(ArchiveDownloadRequest archiveDownloadRequest, ResumePreparation.Ready ready, Response response, Function1<? super Long, Unit> function1, ArchiveOwnedDownloadSession archiveOwnedDownloadSession) {
        if (!ArchiveRemoteNetworkPolicy.INSTANCE.isAllowedUrl(response.request().url().toString(), this.allowInsecureLoopback)) {
            return new AttemptResult.Failed(new ArchiveSecurityException("unsafe archive download URL"), false, null, false, false, false, 62, null);
        }
        String header$default = Response.header$default(response, "Content-Encoding", null, 2, null);
        if (header$default != null && !StringsKt.equals(header$default, "identity", true)) {
            return new AttemptResult.Failed(new IOException("unsupported Content-Encoding: " + header$default), false, null, false, false, false, 62, null);
        }
        if (ready.getOffset() == 0) {
            return consumeFreshResponse(archiveDownloadRequest, response, function1, archiveOwnedDownloadSession);
        }
        return consumeResumeResponse(archiveDownloadRequest, ready, response, function1, archiveOwnedDownloadSession);
    }

    private final AttemptResult consumeFreshResponse(ArchiveDownloadRequest archiveDownloadRequest, Response response, Function1<? super Long, Unit> function1, ArchiveOwnedDownloadSession archiveOwnedDownloadSession) {
        if (response.code() != 200) {
            return new AttemptResult.Failed(new ArchiveHttpResponseException(response.code(), null, 2, null), false, Integer.valueOf(response.code()), false, false, false, 58, null);
        }
        long contentLength = response.body().contentLength();
        if (contentLength >= 0 && !ArchiveResponseLengthValidator.INSTANCE.matches(archiveDownloadRequest.getExpectedSize(), contentLength)) {
            return new AttemptResult.Failed(new IOException("Content-Length mismatch: expected=" + archiveDownloadRequest.getExpectedSize() + " actual=" + contentLength), true, null, false, false, false, 60, null);
        }
        return writeBody(archiveDownloadRequest, 0L, archiveDownloadRequest.getExpectedSize(), response, function1, archiveOwnedDownloadSession);
    }

    private final AttemptResult consumeResumeResponse(ArchiveDownloadRequest archiveDownloadRequest, ResumePreparation.Ready ready, Response response, Function1<? super Long, Unit> function1, ArchiveOwnedDownloadSession archiveOwnedDownloadSession) {
        int code = response.code();
        if (code != 200 && code != 201 && code != 205) {
            if (code == 206) {
                ParsedContentRange parseContentRange = parseContentRange(Response.header$default(response, "Content-Range", null, 2, null));
                if (parseContentRange == null) {
                    return resumeRejected(206, "invalid Content-Range");
                }
                long expectedSize = archiveDownloadRequest.getExpectedSize() - 1;
                long expectedSize2 = archiveDownloadRequest.getExpectedSize() - ready.getOffset();
                if (parseContentRange.getStart() != ready.getOffset() || parseContentRange.getEnd() != expectedSize || parseContentRange.getTotal() != archiveDownloadRequest.getExpectedSize()) {
                    long offset = ready.getOffset();
                    long expectedSize3 = archiveDownloadRequest.getExpectedSize();
                    long start = parseContentRange.getStart();
                    long end = parseContentRange.getEnd();
                    return resumeRejected(206, "Content-Range mismatch: expected=" + offset + Constants.FILENAME_SEQUENCE_SEPARATOR + expectedSize + "/" + expectedSize3 + " actual=" + start + Constants.FILENAME_SEQUENCE_SEPARATOR + end + "/" + parseContentRange.getTotal());
                } else if (!validatorsMatch(ready, response)) {
                    return resumeRejected(206, "archive resume validator changed");
                } else {
                    if ((parseContentRange.getEnd() - parseContentRange.getStart()) + 1 != expectedSize2) {
                        return new AttemptResult.Failed(new IOException("Content-Range remaining length mismatch"), true, null, false, false, false, 60, null);
                    }
                    long contentLength = response.body().contentLength();
                    if (contentLength >= 0 && contentLength != expectedSize2) {
                        return new AttemptResult.Failed(new IOException("partial Content-Length mismatch: expected=" + expectedSize2 + " actual=" + contentLength), true, null, false, false, false, 60, null);
                    }
                    return writeBody(archiveDownloadRequest, ready.getOffset(), expectedSize2, response, function1, archiveOwnedDownloadSession);
                }
            } else if (code != 412 && code != 416) {
                return new AttemptResult.Failed(new ArchiveHttpResponseException(response.code(), null, 2, null), false, Integer.valueOf(response.code()), false, false, false, 58, null);
            }
        }
        return resumeRejected(response.code(), "server rejected archive resume");
    }

    private final boolean validatorsMatch(ResumePreparation.Ready ready, Response response) {
        String obj;
        String strongEtag = ready.getStrongEtag();
        String str = null;
        if (strongEtag != null) {
            return Intrinsics.areEqual(strongEtagOrNull(Response.header$default(response, "ETag", null, 2, null)), strongEtag);
        }
        String lastModified = ready.getLastModified();
        if (lastModified != null) {
            String header$default = Response.header$default(response, "Last-Modified", null, 2, null);
            if (header$default != null && (obj = StringsKt.trim((CharSequence) header$default).toString()) != null && obj.length() > 0) {
                str = obj;
            }
            return Intrinsics.areEqual(str, lastModified);
        }
        return true;
    }

    private final AttemptResult.Failed resumeRejected(int i, String str) {
        return new AttemptResult.Failed(new ArchiveHttpResponseException(i, str), false, Integer.valueOf(i), true, false, false, 50, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d3, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0206, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0209, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020c, code lost:
        return r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x020d, code lost:
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AttemptResult writeBody(ArchiveDownloadRequest archiveDownloadRequest, long j, long j2, Response response, Function1<? super Long, Unit> function1, ArchiveOwnedDownloadSession archiveOwnedDownloadSession) {
        AttemptResult.Failed failed;
        BufferedSource bufferedSource;
        Throwable th;
        AttemptResult.Failed failed2;
        Throwable th2;
        String obj;
        ArchiveResumableHttpEngine archiveResumableHttpEngine = this;
        long j3 = j2;
        String strongEtagOrNull = archiveResumableHttpEngine.strongEtagOrNull(Response.header$default(response, "ETag", null, 2, null));
        String header$default = Response.header$default(response, "Last-Modified", null, 2, null);
        String str = (header$default == null || (obj = StringsKt.trim((CharSequence) header$default).toString()) == null || obj.length() <= 0) ? null : obj;
        File parentFile = archiveDownloadRequest.getDestination().getParentFile();
        if (parentFile == null) {
            return new AttemptResult.Failed(new IOException("destination has no parent"), false, null, false, false, false, 62, null);
        }
        try {
            if ((!parentFile.exists() && !archiveResumableHttpEngine.directoryCreator.createDirectories(parentFile)) || !parentFile.isDirectory()) {
                return new AttemptResult.Failed(new IOException("destination parent unavailable"), false, null, false, false, false, 62, null);
            }
            AtomicLong atomicLong = new AtomicLong(j);
            Ref.LongRef longRef = new Ref.LongRef();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(archiveDownloadRequest.getDestination(), "rw");
                try {
                    RandomAccessFile randomAccessFile2 = randomAccessFile;
                    try {
                        if (j != 0) {
                            if (randomAccessFile2.length() < j) {
                                failed = new AttemptResult.Failed(new IOException("partial file shorter than durable resume offset"), false, null, true, false, false, 54, null);
                            } else if (randomAccessFile2.length() > archiveDownloadRequest.getExpectedSize()) {
                                failed = new AttemptResult.Failed(new IOException("partial file longer than expected package size"), false, null, true, false, false, 54, null);
                            } else if (randomAccessFile2.length() < archiveDownloadRequest.getExpectedSize()) {
                                randomAccessFile2.setLength(archiveDownloadRequest.getExpectedSize());
                            }
                            CloseableKt.closeFinally(randomAccessFile, null);
                            return failed;
                        }
                        randomAccessFile2.setLength(archiveDownloadRequest.getExpectedSize());
                        randomAccessFile2.seek(j);
                        BufferedSource source = response.body().source();
                        try {
                            BufferedSource bufferedSource2 = source;
                            byte[] bArr = new byte[65536];
                            String str2 = strongEtagOrNull;
                            long j4 = 0;
                            long j5 = 0;
                            while (true) {
                                Ref.LongRef longRef2 = longRef;
                                try {
                                    try {
                                        if (j4 >= j3) {
                                            AtomicLong atomicLong2 = atomicLong;
                                            RandomAccessFile randomAccessFile3 = randomAccessFile;
                                            BufferedSource bufferedSource3 = source;
                                            byte[] bArr2 = bArr;
                                            String str3 = str;
                                            RandomAccessFile randomAccessFile4 = randomAccessFile2;
                                            if (bufferedSource2.read(bArr2, 0, 1) >= 0) {
                                                AttemptResult.Failed failed3 = new AttemptResult.Failed(new IOException("response body longer than promised length"), true, null, false, false, false, 60, null);
                                                CloseableKt.closeFinally(bufferedSource3, null);
                                                CloseableKt.closeFinally(randomAccessFile3, null);
                                                return failed3;
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            CloseableKt.closeFinally(bufferedSource3, null);
                                            if (atomicLong2.get() != archiveDownloadRequest.getExpectedSize()) {
                                                randomAccessFile4.getFD().sync();
                                                persistCommittedOffset(archiveDownloadRequest, j + j2, str2, str3);
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                            CloseableKt.closeFinally(randomAccessFile3, null);
                                            writeBody$reportProgress(archiveDownloadRequest, longRef2, this, function1, archiveDownloadRequest.getExpectedSize(), true);
                                            return AttemptResult.Completed.INSTANCE;
                                        }
                                        try {
                                            if (archiveOwnedDownloadSession.isCancellationRequested() || Thread.currentThread().isInterrupted()) {
                                                break;
                                            }
                                            int read = bufferedSource2.read(bArr, 0, (int) Math.min((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, Math.min(j3 - j4, archiveResumableHttpEngine.forceEveryBytes - j5)));
                                            try {
                                                if (read < 0) {
                                                    failed2 = new AttemptResult.Failed(new EOFException("response body truncated: got=" + j4 + " expected=" + j3), false, null, false, false, false, 62, null);
                                                    th2 = null;
                                                    break;
                                                }
                                                if (read != 0) {
                                                    AtomicLong atomicLong3 = atomicLong;
                                                    long j6 = read;
                                                    if (j + j4 + j6 > archiveDownloadRequest.getExpectedSize()) {
                                                        failed2 = new AttemptResult.Failed(new IOException("response body exceeds expected package size"), true, null, false, false, false, 60, null);
                                                        th2 = null;
                                                        break;
                                                    }
                                                    randomAccessFile2.write(bArr, 0, read);
                                                    long j7 = j4 + j6;
                                                    j5 += j6;
                                                    RandomAccessFile randomAccessFile5 = randomAccessFile;
                                                    RandomAccessFile randomAccessFile6 = randomAccessFile2;
                                                    long j8 = j + j7;
                                                    byte[] bArr3 = bArr;
                                                    BufferedSource bufferedSource4 = bufferedSource2;
                                                    bufferedSource = source;
                                                    archiveResumableHttpEngine = this;
                                                    try {
                                                        writeBody$reportProgress$default(archiveDownloadRequest, longRef2, archiveResumableHttpEngine, function1, j8, false, 32, null);
                                                        if (j5 < archiveResumableHttpEngine.forceEveryBytes && j7 != j2) {
                                                            longRef = longRef2;
                                                            randomAccessFile = randomAccessFile5;
                                                            atomicLong = atomicLong3;
                                                            source = bufferedSource;
                                                            bufferedSource2 = bufferedSource4;
                                                            bArr = bArr3;
                                                            randomAccessFile2 = randomAccessFile6;
                                                            j4 = j7;
                                                        }
                                                        randomAccessFile6.getFD().sync();
                                                        String str4 = str;
                                                        String str5 = str2;
                                                        archiveResumableHttpEngine.persistCommittedOffset(archiveDownloadRequest, j8, str5, str4);
                                                        str2 = str5;
                                                        atomicLong3.set(j8);
                                                        writeBody$reportProgress(archiveDownloadRequest, longRef2, this, function1, j8, true);
                                                        archiveResumableHttpEngine = this;
                                                        longRef = longRef2;
                                                        str = str4;
                                                        randomAccessFile = randomAccessFile5;
                                                        atomicLong = atomicLong3;
                                                        source = bufferedSource;
                                                        bufferedSource2 = bufferedSource4;
                                                        bArr = bArr3;
                                                        j5 = 0;
                                                        randomAccessFile2 = randomAccessFile6;
                                                        j4 = j7;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        th = th;
                                                        try {
                                                            throw th;
                                                        } catch (Throwable th4) {
                                                            try {
                                                                CloseableKt.closeFinally(bufferedSource, th);
                                                                throw th4;
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                Throwable th6 = th;
                                                                throw th6;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    archiveResumableHttpEngine = this;
                                                    longRef = longRef2;
                                                    bufferedSource2 = bufferedSource2;
                                                }
                                                j3 = j2;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                bufferedSource = source;
                                                throw th;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            bufferedSource = source;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        Throwable th62 = th;
                                        throw th62;
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    archiveResumableHttpEngine = this;
                                    return (archiveOwnedDownloadSession.isCancellationRequested() || archiveResumableHttpEngine.isCanceledIo(e)) ? AttemptResult.Canceled.INSTANCE : new AttemptResult.Failed(e, false, null, false, false, archiveResumableHttpEngine.isStorageFailure(e), 30, null);
                                }
                            }
                            RandomAccessFile randomAccessFile7 = randomAccessFile;
                            BufferedSource bufferedSource5 = source;
                            AttemptResult.Canceled canceled = AttemptResult.Canceled.INSTANCE;
                            CloseableKt.closeFinally(bufferedSource5, null);
                            CloseableKt.closeFinally(randomAccessFile7, null);
                            return canceled;
                        } catch (Throwable th10) {
                            th = th10;
                            bufferedSource = source;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                    }
                } catch (Throwable th12) {
                    th = th12;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            return new AttemptResult.Failed(e3, false, null, false, false, ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e3), 30, null);
        }
    }

    static /* synthetic */ void writeBody$reportProgress$default(ArchiveDownloadRequest archiveDownloadRequest, Ref.LongRef longRef, ArchiveResumableHttpEngine archiveResumableHttpEngine, Function1 function1, long j, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        writeBody$reportProgress(archiveDownloadRequest, longRef, archiveResumableHttpEngine, function1, j, z);
    }

    private static final void writeBody$reportProgress(ArchiveDownloadRequest archiveDownloadRequest, Ref.LongRef longRef, ArchiveResumableHttpEngine archiveResumableHttpEngine, Function1<? super Long, Unit> function1, long j, boolean z) {
        long coerceIn = RangesKt.coerceIn(j, 0L, archiveDownloadRequest.getExpectedSize());
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - longRef.element >= archiveResumableHttpEngine.progressMinIntervalMs) {
            longRef.element = currentTimeMillis;
            function1.invoke(Long.valueOf(coerceIn));
        }
    }

    private final void persistCommittedOffset(ArchiveDownloadRequest archiveDownloadRequest, long j, String str, String str2) {
        this.resumeStore.save(archiveDownloadRequest.getDestination(), new ArchiveDownloadResumeMetadata(archiveDownloadRequest.getPackageId(), archiveDownloadRequest.getExpectedSize(), archiveDownloadRequest.getExpectedCrc32(), j, str, str2));
    }

    private final Request buildRequest(String str, long j, String str2, String str3) {
        Request.Builder builder = new Request.Builder().url(str).header("Accept-Encoding", "identity").get();
        if (j > 0) {
            String str4 = str2;
            if (str4 == null || StringsKt.isBlank(str4)) {
                String str5 = str3;
                if (str5 != null && !StringsKt.isBlank(str5)) {
                    builder.header("If-Range", str3);
                }
            } else {
                builder.header("If-Range", str2);
            }
            builder.header("Range", "bytes=" + j + Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        return builder.build();
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

    private final String strongEtagOrNull(String str) {
        String obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() >= 3 && !StringsKt.startsWith(obj, "W/", true)) {
            String str2 = obj;
            if (StringsKt.first(str2) == '\"' && StringsKt.last(str2) == '\"') {
                return obj;
            }
        }
        return null;
    }

    private final boolean isCanceledIo(IOException iOException) {
        IOException iOException2;
        int i = 0;
        IOException iOException3 = iOException;
        while (i < 8 && (iOException2 = iOException3) != null) {
            String message = iOException2.getMessage();
            if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "Canceled", true)) {
                return true;
            }
            i++;
            iOException3 = iOException2.getCause();
        }
        return false;
    }

    private final boolean isStorageFailure(Throwable th) {
        return ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(th);
    }

    /* compiled from: ArchiveResumableHttpEngine.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation;", "", "Ready", "AlreadyComplete", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$AlreadyComplete;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ResumePreparation {

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$Ready;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation;", TypedValues.CycleType.S_WAVE_OFFSET, "", "strongEtag", "", "lastModified", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getOffset", "()J", "getStrongEtag", "()Ljava/lang/String;", "getLastModified", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements ResumePreparation {
            public static final int $stable = 0;
            private final String lastModified;
            private final long offset;
            private final String strongEtag;

            public static /* synthetic */ Ready copy$default(Ready ready, long j, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = ready.offset;
                }
                if ((i & 2) != 0) {
                    str = ready.strongEtag;
                }
                if ((i & 4) != 0) {
                    str2 = ready.lastModified;
                }
                return ready.copy(j, str, str2);
            }

            public final long component1() {
                return this.offset;
            }

            public final String component2() {
                return this.strongEtag;
            }

            public final String component3() {
                return this.lastModified;
            }

            public final Ready copy(long j, String str, String str2) {
                return new Ready(j, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Ready) {
                    Ready ready = (Ready) obj;
                    return this.offset == ready.offset && Intrinsics.areEqual(this.strongEtag, ready.strongEtag) && Intrinsics.areEqual(this.lastModified, ready.lastModified);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = Long.hashCode(this.offset) * 31;
                String str = this.strongEtag;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.lastModified;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                long j = this.offset;
                String str = this.strongEtag;
                return "Ready(offset=" + j + ", strongEtag=" + str + ", lastModified=" + this.lastModified + ")";
            }

            public Ready(long j, String str, String str2) {
                this.offset = j;
                this.strongEtag = str;
                this.lastModified = str2;
            }

            public /* synthetic */ Ready(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
            }

            public final long getOffset() {
                return this.offset;
            }

            public final String getStrongEtag() {
                return this.strongEtag;
            }

            public final String getLastModified() {
                return this.lastModified;
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$AlreadyComplete;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class AlreadyComplete implements ResumePreparation {
            public static final int $stable = 0;
            public static final AlreadyComplete INSTANCE = new AlreadyComplete();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof AlreadyComplete) {
                    AlreadyComplete alreadyComplete = (AlreadyComplete) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1401318437;
            }

            public String toString() {
                return "AlreadyComplete";
            }

            private AlreadyComplete() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ResumePreparation;", "cause", "Ljava/io/IOException;", "storageFailure", "", "<init>", "(Ljava/io/IOException;Z)V", "getCause", "()Ljava/io/IOException;", "getStorageFailure", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements ResumePreparation {
            public static final int $stable = 8;
            private final IOException cause;
            private final boolean storageFailure;

            public static /* synthetic */ Failed copy$default(Failed failed, IOException iOException, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    iOException = failed.cause;
                }
                if ((i & 2) != 0) {
                    z = failed.storageFailure;
                }
                return failed.copy(iOException, z);
            }

            public final IOException component1() {
                return this.cause;
            }

            public final boolean component2() {
                return this.storageFailure;
            }

            public final Failed copy(IOException cause, boolean z) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                return new Failed(cause, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Failed) {
                    Failed failed = (Failed) obj;
                    return Intrinsics.areEqual(this.cause, failed.cause) && this.storageFailure == failed.storageFailure;
                }
                return false;
            }

            public int hashCode() {
                return (this.cause.hashCode() * 31) + Boolean.hashCode(this.storageFailure);
            }

            public String toString() {
                IOException iOException = this.cause;
                return "Failed(cause=" + iOException + ", storageFailure=" + this.storageFailure + ")";
            }

            public Failed(IOException cause, boolean z) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.cause = cause;
                this.storageFailure = z;
            }

            public /* synthetic */ Failed(IOException iOException, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(iOException, (i & 2) != 0 ? false : z);
            }

            public final IOException getCause() {
                return this.cause;
            }

            public final boolean getStorageFailure() {
                return this.storageFailure;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveResumableHttpEngine.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult;", "", "Success", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ArtifactDiscardResult {

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult$Success;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Success implements ArtifactDiscardResult {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 375877548;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ArtifactDiscardResult;", "cause", "Ljava/io/IOException;", "storageFailure", "", "<init>", "(Ljava/io/IOException;Z)V", "getCause", "()Ljava/io/IOException;", "getStorageFailure", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements ArtifactDiscardResult {
            public static final int $stable = 8;
            private final IOException cause;
            private final boolean storageFailure;

            public static /* synthetic */ Failed copy$default(Failed failed, IOException iOException, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    iOException = failed.cause;
                }
                if ((i & 2) != 0) {
                    z = failed.storageFailure;
                }
                return failed.copy(iOException, z);
            }

            public final IOException component1() {
                return this.cause;
            }

            public final boolean component2() {
                return this.storageFailure;
            }

            public final Failed copy(IOException cause, boolean z) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                return new Failed(cause, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Failed) {
                    Failed failed = (Failed) obj;
                    return Intrinsics.areEqual(this.cause, failed.cause) && this.storageFailure == failed.storageFailure;
                }
                return false;
            }

            public int hashCode() {
                return (this.cause.hashCode() * 31) + Boolean.hashCode(this.storageFailure);
            }

            public String toString() {
                IOException iOException = this.cause;
                return "Failed(cause=" + iOException + ", storageFailure=" + this.storageFailure + ")";
            }

            public Failed(IOException cause, boolean z) {
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.cause = cause;
                this.storageFailure = z;
            }

            public /* synthetic */ Failed(IOException iOException, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(iOException, (i & 2) != 0 ? false : z);
            }

            public final IOException getCause() {
                return this.cause;
            }

            public final boolean getStorageFailure() {
                return this.storageFailure;
            }
        }
    }

    /* compiled from: ArchiveResumableHttpEngine.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "Canceled", "SameDestinationBusy", "ResumeReset", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Canceled;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Completed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$ResumeReset;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$SameDestinationBusy;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface AttemptResult {

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Completed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Completed implements AttemptResult {
            public static final int $stable = 0;
            public static final Completed INSTANCE = new Completed();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Completed) {
                    Completed completed = (Completed) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -102337515;
            }

            public String toString() {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
            }

            private Completed() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Canceled;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Canceled implements AttemptResult {
            public static final int $stable = 0;
            public static final Canceled INSTANCE = new Canceled();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Canceled) {
                    Canceled canceled = (Canceled) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 888612239;
            }

            public String toString() {
                return "Canceled";
            }

            private Canceled() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$SameDestinationBusy;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SameDestinationBusy implements AttemptResult {
            public static final int $stable = 0;
            public static final SameDestinationBusy INSTANCE = new SameDestinationBusy();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SameDestinationBusy) {
                    SameDestinationBusy sameDestinationBusy = (SameDestinationBusy) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1540424917;
            }

            public String toString() {
                return "SameDestinationBusy";
            }

            private SameDestinationBusy() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$ResumeReset;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class ResumeReset implements AttemptResult {
            public static final int $stable = 0;
            public static final ResumeReset INSTANCE = new ResumeReset();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ResumeReset) {
                    ResumeReset resumeReset = (ResumeReset) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -55989140;
            }

            public String toString() {
                return "ResumeReset";
            }

            private ResumeReset() {
            }
        }

        /* compiled from: ArchiveResumableHttpEngine.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0018\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003JT\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0083\u0004J\n\u0010#\u001a\u00020\bHÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0000¨\u0006&"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Failed;", "Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "contentLengthMismatch", "", "httpStatus", "", "resumeRejected", "artifactResetFailed", "storageFailure", "<init>", "(Ljava/lang/Exception;ZLjava/lang/Integer;ZZZ)V", "getCause", "()Ljava/lang/Exception;", "getContentLengthMismatch", "()Z", "getHttpStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResumeRejected", "getArtifactResetFailed", "getStorageFailure", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Exception;ZLjava/lang/Integer;ZZZ)Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$AttemptResult$Failed;", "equals", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements AttemptResult {
            public static final int $stable = 8;
            private final boolean artifactResetFailed;
            private final Exception cause;
            private final boolean contentLengthMismatch;
            private final Integer httpStatus;
            private final boolean resumeRejected;
            private final boolean storageFailure;

            public static /* synthetic */ Failed copy$default(Failed failed, Exception exc, boolean z, Integer num, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    exc = failed.cause;
                }
                if ((i & 2) != 0) {
                    z = failed.contentLengthMismatch;
                }
                if ((i & 4) != 0) {
                    num = failed.httpStatus;
                }
                if ((i & 8) != 0) {
                    z2 = failed.resumeRejected;
                }
                if ((i & 16) != 0) {
                    z3 = failed.artifactResetFailed;
                }
                if ((i & 32) != 0) {
                    z4 = failed.storageFailure;
                }
                boolean z5 = z3;
                boolean z6 = z4;
                return failed.copy(exc, z, num, z2, z5, z6);
            }

            public final Exception component1() {
                return this.cause;
            }

            public final boolean component2() {
                return this.contentLengthMismatch;
            }

            public final Integer component3() {
                return this.httpStatus;
            }

            public final boolean component4() {
                return this.resumeRejected;
            }

            public final boolean component5() {
                return this.artifactResetFailed;
            }

            public final boolean component6() {
                return this.storageFailure;
            }

            public final Failed copy(Exception exc, boolean z, Integer num, boolean z2, boolean z3, boolean z4) {
                return new Failed(exc, z, num, z2, z3, z4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Failed) {
                    Failed failed = (Failed) obj;
                    return Intrinsics.areEqual(this.cause, failed.cause) && this.contentLengthMismatch == failed.contentLengthMismatch && Intrinsics.areEqual(this.httpStatus, failed.httpStatus) && this.resumeRejected == failed.resumeRejected && this.artifactResetFailed == failed.artifactResetFailed && this.storageFailure == failed.storageFailure;
                }
                return false;
            }

            public int hashCode() {
                Exception exc = this.cause;
                int hashCode = (((exc == null ? 0 : exc.hashCode()) * 31) + Boolean.hashCode(this.contentLengthMismatch)) * 31;
                Integer num = this.httpStatus;
                return ((((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.resumeRejected)) * 31) + Boolean.hashCode(this.artifactResetFailed)) * 31) + Boolean.hashCode(this.storageFailure);
            }

            public String toString() {
                Exception exc = this.cause;
                boolean z = this.contentLengthMismatch;
                Integer num = this.httpStatus;
                boolean z2 = this.resumeRejected;
                boolean z3 = this.artifactResetFailed;
                return "Failed(cause=" + exc + ", contentLengthMismatch=" + z + ", httpStatus=" + num + ", resumeRejected=" + z2 + ", artifactResetFailed=" + z3 + ", storageFailure=" + this.storageFailure + ")";
            }

            public Failed(Exception exc, boolean z, Integer num, boolean z2, boolean z3, boolean z4) {
                this.cause = exc;
                this.contentLengthMismatch = z;
                this.httpStatus = num;
                this.resumeRejected = z2;
                this.artifactResetFailed = z3;
                this.storageFailure = z4;
            }

            public /* synthetic */ Failed(Exception exc, boolean z, Integer num, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(exc, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
            }

            public final Exception getCause() {
                return this.cause;
            }

            public final boolean getContentLengthMismatch() {
                return this.contentLengthMismatch;
            }

            public final Integer getHttpStatus() {
                return this.httpStatus;
            }

            public final boolean getResumeRejected() {
                return this.resumeRejected;
            }

            public final boolean getArtifactResetFailed() {
                return this.artifactResetFailed;
            }

            public final boolean getStorageFailure() {
                return this.storageFailure;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveResumableHttpEngine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$ParsedContentRange;", "", TtmlNode.START, "", TtmlNode.END, UpdateServiceContract.BundleKey.TOTAL, "<init>", "(JJJ)V", "getStart", "()J", "getEnd", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* compiled from: ArchiveResumableHttpEngine.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResumableHttpEngine$Companion;", "", "<init>", "()V", "HTTP_OK", "", "HTTP_CREATED", "HTTP_PARTIAL_CONTENT", "HTTP_RESET_CONTENT", "HTTP_PRECONDITION_FAILED", "HTTP_RANGE_NOT_SATISFIABLE", "READ_BUFFER_BYTES", "DEFAULT_FORCE_EVERY_BYTES", "", "DEFAULT_PROGRESS_INTERVAL_MS", "MAX_CAUSE_DEPTH", "REDIRECT_HTTP_STATUSES", "", "getREDIRECT_HTTP_STATUSES", "()Ljava/util/Set;", "CONTENT_RANGE", "Lkotlin/text/Regex;", "getCONTENT_RANGE", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getREDIRECT_HTTP_STATUSES() {
            return ArchiveResumableHttpEngine.REDIRECT_HTTP_STATUSES;
        }

        public final Regex getCONTENT_RANGE() {
            return ArchiveResumableHttpEngine.CONTENT_RANGE;
        }
    }
}
