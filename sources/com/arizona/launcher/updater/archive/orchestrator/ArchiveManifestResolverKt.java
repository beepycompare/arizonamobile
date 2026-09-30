package com.arizona.launcher.updater.archive.orchestrator;

import android.util.Log;
import com.arizona.launcher.updater.archive.download.ArchiveRemoteNetworkPolicy;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002\u001a\"\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"asBufferedStreamer", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "indexFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "detail", "", "logResolver", "", "message", "elapsedMs", "", "startedAtNs", "indexHost", "serverBaseUrl", "packageUrl", "resolveArchiveUrl", "allowInsecureLoopback", "", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolverKt {
    public static final ArchiveByteRangeStreamer asBufferedStreamer(ArchiveByteRangeSource archiveByteRangeSource) {
        Intrinsics.checkNotNullParameter(archiveByteRangeSource, "<this>");
        return new ArchiveManifestResolverKt$asBufferedStreamer$1(archiveByteRangeSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OriginalTzArchivePackageIndexResult.Failure indexFailure(ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode, String str) {
        return new OriginalTzArchivePackageIndexResult.Failure(archiveManifestResolutionErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logResolver(String str) {
        try {
            Log.i("ArchiveManifestResolver", str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long elapsedMs(long j) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexHost(String str, String str2) {
        Object m9921constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            URI uri = new URI(str2);
            if (!uri.isAbsolute()) {
                if (!StringsKt.endsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
                    str = str + "/";
                }
                uri = new URI(str).resolve(uri);
            }
            m9921constructorimpl = Result.m9921constructorimpl(uri.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th));
        }
        String str3 = Result.m9927isFailureimpl(m9921constructorimpl) ? null : m9921constructorimpl;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = str3;
        if (StringsKt.isBlank(str4)) {
            str4 = "unknown";
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveArchiveUrl(String str, String str2, boolean z) {
        Object m9921constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            URI uri = new URI(str2);
            if (!StringsKt.endsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
                str = str + "/";
            }
            if (!uri.isAbsolute()) {
                uri = new URI(str).resolve(uri);
            }
            String uri2 = uri.toString();
            ArchiveRemoteNetworkPolicy archiveRemoteNetworkPolicy = ArchiveRemoteNetworkPolicy.INSTANCE;
            Intrinsics.checkNotNull(uri2);
            if (!archiveRemoteNetworkPolicy.isAllowedUrl(uri2, z)) {
                uri2 = null;
            }
            m9921constructorimpl = Result.m9921constructorimpl(uri2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9921constructorimpl = Result.m9921constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9927isFailureimpl(m9921constructorimpl) ? null : m9921constructorimpl;
    }
}
