package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.download.ArchiveRemoteNetworkPolicy;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"indexFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "detail", "", "resolveArchiveUrl", "serverBaseUrl", "packageUrl", "allowInsecureLoopback", "", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolverKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final OriginalTzArchivePackageIndexResult.Failure indexFailure(ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode, String str) {
        return new OriginalTzArchivePackageIndexResult.Failure(archiveManifestResolutionErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveArchiveUrl(String str, String str2, boolean z) {
        Object m9916constructorimpl;
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
            m9916constructorimpl = Result.m9916constructorimpl(uri2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m9922isFailureimpl(m9916constructorimpl) ? null : m9916constructorimpl;
    }
}
