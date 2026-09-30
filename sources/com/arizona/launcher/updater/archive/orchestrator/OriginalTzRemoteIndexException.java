package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzRemoteIndexException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "packageId", "", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "detail", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;Ljava/lang/String;)V", "getPackageId", "()Ljava/lang/String;", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "getDetail", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class OriginalTzRemoteIndexException extends RuntimeException {
    private final ArchiveManifestResolutionErrorCode code;
    private final String detail;
    private final String packageId;

    public OriginalTzRemoteIndexException(String packageId, ArchiveManifestResolutionErrorCode code, String str) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(code, "code");
        this.packageId = packageId;
        this.code = code;
        this.detail = str;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final ArchiveManifestResolutionErrorCode getCode() {
        return this.code;
    }

    public final String getDetail() {
        return this.detail;
    }
}
